package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mynotes.models.Folder;
import pl.mynotes.models.Note;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;

import java.util.List;

@Controller
public class NoteController {

    private final NoteRepository noteRepository;
    private final FolderRepository folderRepository;

    public NoteController(NoteRepository noteRepository, FolderRepository folderRepository) {
        this.noteRepository = noteRepository;
        this.folderRepository = folderRepository;
    }

    @ModelAttribute("folders")
    public List<Folder> folders() {
        List<Folder> folders = folderRepository.findAll();
        return folders;
    }

    @RequestMapping("/notes")
    public String allFolder(Model model) {
        List<Note> notes = noteRepository.findAll();
//        List<Folder> folders = folderRepository.findAll();
//        model.addAttribute("folders", folders);
        model.addAttribute("notes", notes);
        return "main";
    }

    @GetMapping("/notes/add")
    public String addNoteForm(Model model) {
//        List<Folder> folders = folderRepository.findAll();
//        model.addAttribute("folders", folders);
        model.addAttribute("note", new Note());
        return "addNote";
    }

    @PostMapping("/notes/add")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteRepository.save(note);
        return "redirect:/notes";
    }
}
