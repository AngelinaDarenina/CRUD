package hiber_and_web.controller;

import hiber_and_web.model.User;
import hiber_and_web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(ModelMap model) {
        List<User> allUsers = userService.listUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserByID(id));
        return "show-user";
    }

    @GetMapping("/new")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping("/")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserByID(id));
        return "user-update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }


}
