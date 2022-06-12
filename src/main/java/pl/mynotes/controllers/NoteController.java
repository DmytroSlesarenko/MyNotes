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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NoteController {

    private final NoteRepository noteRepository;
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    public NoteController(NoteRepository noteRepository, FolderRepository folderRepository, UserRepository userRepository) {
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

    @RequestMapping("/notes")
    public String allFolder(Model model, Principal principal) {
        User user = userRepository.getUserByUsername(principal.getName());
        List<Note> notes = noteRepository.findAllByUserId(user.getId());
        model.addAttribute("notes", notes);
        return "main";
    }

    @GetMapping("/notes/add")
    public String addNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "addNote";
    }

    @PostMapping("/notes/add/{userId}")
    public String saveNote(@ModelAttribute("note") Note note, @RequestParam String type, @PathVariable Long userId) {
        note.setUser(userRepository.findById(userId).get());
        note.setDescription(note.getDescription().replaceAll("\n", "<br>"));
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

    @GetMapping("/notes/details/{noteId}")
    public String detailsNoteForm(Model model, @PathVariable Long noteId, HttpServletRequest request) {
        model.addAttribute("note", noteRepository.findById(noteId).get());
        return "detailsNote";
    }

    @GetMapping("/notes/edit/{noteId}")
    public String editNoteForm(Model model, @PathVariable Long noteId) {
        Note note = noteRepository.findById(noteId).get();
        note.setDescription(note.getDescription().replaceAll("<br>", "\n"));
        model.addAttribute("note", note);
        return "editNote";
    }

    @PostMapping("/notes/edit/{userId}")
    public String editNote(Note editedNote, @PathVariable Long userId) {
        editedNote.setUser(userRepository.findById(userId).get());
        editedNote.setDescription(editedNote.getDescription().replaceAll("\n", "<br>"));
        noteRepository.save(editedNote);
        return "redirect:/notes/details/" + editedNote.getId();
    }

    @GetMapping("/notes/delete/{noteId}")
    public String deleteNote(@PathVariable Long noteId) {
        userRepository.shareNotesDelete(noteId);
        noteRepository.deleteById(noteId);
        return "redirect:/notes";
    }

    @GetMapping("/notes/sharing/{noteId}")
    public String shareListForm(Model model, @PathVariable Long noteId) {
        Note note = noteRepository.findById(noteId).get();
        model.addAttribute("note", note);
        return "shareNote";
    }

    @PostMapping("/notes/sharing/{noteId}")
    public String shareList(@PathVariable Long noteId, HttpServletRequest request) {
        String email = request.getParameter("email");
        User user = userRepository.getUserByEmail(email);
        userRepository.shareNotes(user.getId(), noteId);
        return "redirect:/notes/details/" + noteId;
    }
}
