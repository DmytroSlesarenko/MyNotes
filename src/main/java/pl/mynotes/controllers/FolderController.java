package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mynotes.models.Folder;
import pl.mynotes.models.User;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;
import pl.mynotes.repositories.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class FolderController {

    private final FolderRepository folderRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public FolderController(FolderRepository folderRepository, NoteRepository noteRepository, UserRepository userRepository) {
        this.folderRepository = folderRepository;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute(name = "user")
    public User loggedUser(Principal principal) {
        return userRepository.getUserByUsername(principal.getName());
    }

    @ModelAttribute(name = "folders")
    public List<Folder> folders(Principal principal){
        User user = userRepository.getUserByUsername(principal.getName());
        return folderRepository.findAllByUserId(user.getId());
    }

    @GetMapping("/folders")
    public String allFolders() {
        return "allFolder";
    }


    @GetMapping("/folder/add")
    public String addFolderForm(Model model) {
        model.addAttribute("folder", new Folder());
        return "addFolder";
    }

    @PostMapping("/folder/add/{userId}")
    public String saveFolder(Folder folder, @PathVariable Long userId, Model model) {
        List<Folder> folders = folderRepository.findAllByUserId(userId);
        for (Folder element : folders) {
            if (element.getName().equals(folder.getName())) {
                model.addAttribute("error", 1);
                return "addFolderError";
            }
        }
        folder.setUser(userRepository.findById(userId).get());
        folderRepository.save(folder);
        return "redirect:/notes";
    }

    @GetMapping("/folder/all/add")
    public String addAllFolderForm(Model model) {
        model.addAttribute("folder", new Folder());
        return "addAllFolder";
    }

    @PostMapping("/folder/all/add/{userId}")
    public String saveAllFolder(Folder folder, @PathVariable Long userId, Model model) {
        List<Folder> folders = folderRepository.findAllByUserId(userId);
        for (Folder element : folders) {
            if (element.getName().equals(folder.getName())) {
                model.addAttribute("error", 1);
                return "addAllFolderError";
            }
        }
        folder.setUser(userRepository.findById(userId).get());
        folderRepository.save(folder);
        return "redirect:/folders";
    }

    @GetMapping("/folder/{folderId}")
    public String openFolder(Model model, @PathVariable Long folderId) {
        model.addAttribute("folder", folderRepository.findById(folderId).get());
        model.addAttribute("notes", noteRepository.findAllByFolderId(folderId));
        return "openFolder";
    }

    @GetMapping("/folder/edit/{folderId}")
    public String editFolderForm(Model model, @PathVariable Long folderId) {
        model.addAttribute("folder", folderRepository.findById(folderId).get());
        return "editFolder";
    }

    @PostMapping("/folder/edit")
    public String editFolder(Folder folder) {
        folderRepository.save(folder);
        return "redirect:/folder/" + folder.getId();
    }

    @GetMapping("/folder/delete/{folderId}")
    public String deleteFolder(@PathVariable Long folderId) {
        noteRepository.deleteFolderId(folderId);
        folderRepository.deleteById(folderId);
        return "redirect:/folders";
    }
}
