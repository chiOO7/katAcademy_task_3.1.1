package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.services.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public String hello() {
//        return "hello";
////        return "index";
//    }


    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.showUsers());
        model.addAttribute("user", new User());
        return "index";
    }
//
    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
//
    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }
//
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id, user);
        return "redirect:/";
    }
//
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
