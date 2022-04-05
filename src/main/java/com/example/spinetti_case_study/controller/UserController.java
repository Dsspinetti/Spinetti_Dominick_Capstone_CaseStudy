package com.example.spinetti_case_study.controller;

import com.example.spinetti_case_study.models.User;
import com.example.spinetti_case_study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        return "Login";
    }

    @GetMapping("/showCreateAccount")
    public String showCreateAccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "CreateAccount";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingresult) {

        if (bindingresult.hasErrors()) {
            return "CreateAccount";
        }

        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "UpdateAccount";
    }

    @GetMapping("/listAccounts")
    public String getAllUsersList(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "ListAccounts";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        this.userService.deleteUserById(id);
        return "ListAccounts";
    }

    @GetMapping("/showHomeScreen")
    public String showHomeScreen(Model model) {
        return "HomeScreen";
    }
}
