package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mynotes.models.Folder;
import pl.mynotes.models.Note;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListController {

    private final NoteRepository noteRepository;
    private final FolderRepository folderRepository;

    public ListController(NoteRepository noteRepository, FolderRepository folderRepository) {
        this.noteRepository = noteRepository;
        this.folderRepository = folderRepository;
    }

    @GetMapping("/list/add")
    public String addListForm(Model model) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        model.addAttribute("note", new Note());
        return "addList";
    }

    @PostMapping("/list/add")
    public String saveList(@ModelAttribute("note") Note note, @RequestParam String type, HttpServletRequest request) {
        List<String> list = List.of(request.getParameterValues("lista"));
        String inputValue = list.stream().collect(Collectors.joining("; "));
        note.setDescription(inputValue);
        note.setType(type);
        noteRepository.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/list/edit/{id}")
    public String editListForm(Model model, @PathVariable Long id) {
        List<Folder> folders = folderRepository.findAll();
        model.addAttribute("folders", folders);
        Note note = noteRepository.findById(id).get();
        model.addAttribute("note", note);
        return "editList";
    }

    @PostMapping("/list/edit")
    public String editList(Note editedNote, HttpServletRequest request) {
        List<String> list = List.of(request.getParameterValues("lista"));
        String inputValue = list.stream().collect(Collectors.joining("; "));
        editedNote.setDescription(inputValue);
        noteRepository.save(editedNote);
        return "redirect:/notes/details/" + editedNote.getId();
    }
}
