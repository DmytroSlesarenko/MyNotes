package pl.mynotes.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mynotes.models.Folder;
import pl.mynotes.models.User;
import pl.mynotes.repositories.FolderRepository;
import pl.mynotes.repositories.NoteRepository;
import pl.mynotes.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;
    private FolderRepository folderRepository;
    private NoteRepository noteRepository;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder encoder, FolderRepository folderRepository, NoteRepository noteRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.folderRepository = folderRepository;
        this.noteRepository = noteRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginError(Model model, HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        for (User user: users) {
            if ((user.getUsername().equals(request.getParameter("username")) && request.getParameter("password").equals("")) || (user.getUsername().equals(request.getParameter("username")) && !user.getPassword().equals(request.getParameter("password")))) {
                model.addAttribute("error", 1); /* 1 - user exist but password not matches */
            } else if(!user.getUsername().equals(request.getParameter("username")) || request.getParameter("username").equals("")) {
                model.addAttribute("error", 0); /* 0 - user not exist, or exist but username incorrect*/
            }
        }
        return "loginError";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "singUp";
    }

    @PostMapping("/registration")
    public String registration(User user, HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        for (User account : users) {
          if (user.getUsername().equals(account.getUsername())) {
              return "singUpUsername";
          }  else if (user.getEmail().equals(account.getEmail())) {
              return "singUpEmail";
          }
        }
        String reapedPass = request.getParameter("reapedpass");
        if (!reapedPass.equals(user.getPassword())){
            return "redirect:/registration";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping("/user/details/{userId}")
    public String userDetails(Model model, @PathVariable Long userId) {
        List<Folder> folders = folderRepository.findAllByUserId(userId);
        model.addAttribute("folders", folders);
        model.addAttribute("user", userRepository.findById(userId).get());
        return "detailsUser";
    }

    @GetMapping("/user/edit/{userId}")
    public String userEditForm(Model model, @PathVariable Long userId) {
        model.addAttribute("user", userRepository.findById(userId).get());
        return "editUser";
    }

    @PostMapping("/user/edit/")
    public String userEdit(User editedUser) {
        editedUser.setPassword(encoder.encode(editedUser.getPassword()));
        userRepository.save(editedUser);
        return "redirect:/user/details/" + editedUser.getId();
    }

    @GetMapping("/user/delete/{userId}")
    public String userDelete(@PathVariable Long userId) {
        noteRepository.deleteNotesByUserId(userId);
        folderRepository.deleteFolderByUserId(userId);
        userRepository.deleteById(userId);
        return "redirect:/logout";
    }
}
