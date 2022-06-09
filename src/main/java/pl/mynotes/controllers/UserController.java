package pl.mynotes.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mynotes.models.User;
import pl.mynotes.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder encoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
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
}
