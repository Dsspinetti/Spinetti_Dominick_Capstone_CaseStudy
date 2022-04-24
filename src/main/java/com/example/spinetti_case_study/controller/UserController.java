package com.example.spinetti_case_study.controller;

import com.example.spinetti_case_study.models.Course;
import com.example.spinetti_case_study.models.User;
import com.example.spinetti_case_study.services.CourseService;
import com.example.spinetti_case_study.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;
    private CourseService courseService;


    public UserController() {
    }

    @Autowired
    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }


    //Mapping for main home page
    @GetMapping("/")
    public String showHomeScreen(Model model, @Param("keyword") String keyword, Principal principal) {
        Course course = new Course();
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("listCourses", courseService.listAll(keyword));
        model.addAttribute("keyword", keyword);
        return "home_screen";
    }

    //Mapping for login page
    @GetMapping("/login")
    public String login() {
        return "login";
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
        return "create_account";
    }

    // Saving new user to the database with binding result handling back-end form validation
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingresult) {

        if (bindingresult.hasErrors()) {
            return "create_account";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    //Mapping for update account
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_account";
    }

    //mapping for listing accounts
    @GetMapping("/listAccounts")
    public String getAllUsersList(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "list_accounts";
    }

    //Mapping for deleting a user
    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        this.userService.deleteUserById(id);
        return "redirect:/listAccounts";
    }

    //Mapping for Profile page
    @GetMapping("/profile")
    public String showProfile(Principal principal, Model model) {

        User user =
                userService.findByEmail(principal.getName());
                model.addAttribute("userName", user.getUserName());
                model.addAttribute("firstName", user.getFirstName());
                model.addAttribute("lastName", user.getLastName());
                model.addAttribute("email", user.getEmail());
        return "profile";
    }

}
