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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String showHomeScreen(Model model) {
        return "HomeScreen";
    }
    //Mapping for login page
    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    //Mapping for logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpsession = request.getSession();
        httpsession.invalidate();
        return "redirect:/";
    }

    //Creating model for account creation
    @GetMapping("/showCreateAccount")
    public String showCreateAccount(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "CreateAccount";
    }
    // Saving new user to the database with binding result handling backend form validation
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingresult) {

        if (bindingresult.hasErrors()) {
            return "CreateAccount";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }
    //Mapping for update account
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "UpdateAccount";
    }
    //mapping for listing accounts
    @GetMapping("/listAccounts")
    public String getAllUsersList(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "ListAccounts";
    }
    //Mapping for deleting a user
    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        this.userService.deleteUserById(id);
        return "redirect:/listAccounts";
    }
    //Mapping for main home page
}
