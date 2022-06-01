package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mynotes.models.Folder;
import pl.mynotes.repositories.FolderRepository;

@Controller
public class FolderController {

    private final FolderRepository folderRepository;

    public FolderController(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
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

}
