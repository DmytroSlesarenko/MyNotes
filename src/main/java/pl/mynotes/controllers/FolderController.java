package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mynotes.models.Folder;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;

import java.util.List;

@Controller
public class FolderController {

    private final FolderRepository folderRepository;
    private final NoteRepository noteRepository;

    public FolderController(FolderRepository folderRepository, NoteRepository noteRepository) {
        this.folderRepository = folderRepository;
        this.noteRepository = noteRepository;
    }


    @GetMapping("/folder/add")
    public String addFolderForm(Model model) {
        model.addAttribute("folder", new Folder());
        return "addFolder";
    }

    @PostMapping("/folder/add")
    public String saveFolder(Folder folder) {
        folderRepository.save(folder);
        return "redirect:/notes";
    }

    @GetMapping("/folder/{id}")
    public String openFolder(Model model, @PathVariable Long id) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("folder", folderRepository.findById(id).get());
        model.addAttribute("notes", noteRepository.findAllByFolderId(id));
        return "openFolder";
    }

    @GetMapping("/folder/edit/{id}")
    public String editFolderForm(Model model, @PathVariable Long id) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("folder", folderRepository.findById(id).get());
        return "editFolder";
    }

    @PostMapping("/folder/edit")
    public String editFolder(Folder folder) {
        folderRepository.save(folder);
        return "redirect:/folder/" + folder.getId();
    }

    @GetMapping("/folder/delete/{id}")
    public String deleteFolder(@PathVariable Long id) {
        noteRepository.deleteFolderId(id);
        folderRepository.deleteById(id);
        return "redirect:/notes";
    }
}
