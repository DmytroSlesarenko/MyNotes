package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mynotes.models.Folder;
import pl.mynotes.models.Note;
import pl.mynotes.models.User;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;
import pl.mynotes.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ListController {

    private final NoteRepository noteRepository;
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    public ListController(NoteRepository noteRepository, FolderRepository folderRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.folderRepository = folderRepository;
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

    @GetMapping("/list/add")
    public String addListForm(Model model) {
        model.addAttribute("note", new Note());
        return "addList";
    }

    @PostMapping("/list/add/{userId}")
    public String saveList(@ModelAttribute("note") Note note, @RequestParam String type, HttpServletRequest request, @PathVariable Long userId) {
        List<Note> notesError = noteRepository.findAllByUserId(userId);
        for (Note element : notesError) {
            if (element.getTitle().equals(note.getTitle())) {
                return "addListError";
            }
        }
        note.setUser(userRepository.findById(userId).get());
        List<String> list = List.of(request.getParameterValues("lista"));
        String inputValue = list.stream().collect(Collectors.joining("; "));
        List<String> checkValue = List.of(request.getParameterValues("box"));
        String checks = checkValue.stream().collect(Collectors.joining("; "));
        note.setDescription(inputValue);
        note.setCheckType(checks);
        note.setType(type);
        noteRepository.save(note);
        List<Note> notes = noteRepository.findAllByUserIdNote(userId);
        for (Note item : notes) {
            if (item.getTitle().equals(note.getTitle())) {
                userRepository.shareNotes(userId, item.getId());
            }
        }
        return "redirect:/notes";
    }

    @GetMapping("/list/edit/{id}")
    public String editListForm(Model model, @PathVariable Long id) {
        Note note = noteRepository.findById(id).get();
        model.addAttribute("note", note);
        return "editList";
    }

    @PostMapping("/list/edit/{userId}")
    public String editList(Note editedNote, HttpServletRequest request, @PathVariable Long userId) {
        editedNote.setUser(userRepository.findById(userId).get());
        List<String> list = List.of(request.getParameterValues("lista"));
        String inputValue = list.stream().collect(Collectors.joining("; "));
        List<String> checkValue = List.of(request.getParameterValues("box"));
        String checks = checkValue.stream().collect(Collectors.joining("; "));
        editedNote.setDescription(inputValue);
        editedNote.setCheckType(checks);
        noteRepository.save(editedNote);
        return "redirect:/notes/details/" + editedNote.getId();
    }

    @GetMapping("/list/sharing/{noteId}")
    public String shareListForm(Model model, @PathVariable Long noteId) {
        Note note = noteRepository.findById(noteId).get();
        model.addAttribute("note", note);
        return "shareList";
    }

    @PostMapping("/list/sharing/{noteId}")
    public String shareList(@PathVariable Long noteId, HttpServletRequest request) {
        String email = request.getParameter("email");
        User user = userRepository.getUserByEmail(email);
        userRepository.shareNotes(user.getId(), noteId);
        return "redirect:/notes/details/" + noteId;
    }


}
