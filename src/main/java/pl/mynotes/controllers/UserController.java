package pl.mynotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

//    @PostMapping("/login")
//    public String logged() {
//        return "redirect:/notes";
//    }


    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
