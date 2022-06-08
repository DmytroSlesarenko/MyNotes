package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/notes")
    public String allFolder(Model model) {
        List<Note> notes = noteRepository.findAll();
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("notes", notes);
        return "main";
    }

    @GetMapping("/notes/add")
    public String addNoteForm(Model model) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("note", new Note());
        return "addNote";
    }

    @PostMapping("/notes/add")
    public String saveNote(@ModelAttribute("note") Note note, @RequestParam String type) {
        note.setDescription(note.getDescription().replaceAll("\n", "<br>"));
        note.setType(type);
        noteRepository.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/notes/details/{id}")
    public String detailsNote(Model model, @PathVariable Long id) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("note", noteRepository.findById(id).get());
        return "detailsNote";
    }

    @GetMapping("/notes/edit/{id}")
    public String editNoteForm(Model model, @PathVariable Long id) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        Note note = noteRepository.findById(id).get();
        note.setDescription(note.getDescription().replaceAll("<br>", "\n"));
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/notes/edit")
    public String editNote(Note editedNote) {
        editedNote.setDescription(editedNote.getDescription().replaceAll("\n", "<br>"));
        noteRepository.save(editedNote);
        return "redirect:/notes/details/" + editedNote.getId();
    }

    @GetMapping("/notes/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return "redirect:/notes";
    }
}
