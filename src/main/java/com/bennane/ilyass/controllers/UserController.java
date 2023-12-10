package com.bennane.ilyass.controllers;

import com.bennane.ilyass.entities.User;
import com.bennane.ilyass.repositories.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers=service.listAll();
        model.addAttribute("listUsers",listUsers);
        return "users";

    }
    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("users",new User());
        return "user_form";

    }
    @PostMapping("/users/save")
    public String saveUser(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        service.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "edit_user_form";
    }


}
