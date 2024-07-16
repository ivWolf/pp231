package web.controller;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;

@Controller
    public class UserController {
        private final UserService userService;
        @Autowired
        public UserController(UserService userService){
            this.userService = userService;
        }
        @GetMapping( "/")
        public String printUsers(Model model) {
            model.addAttribute("users", userService.getAllUsers());
            return "users";
        }

        @PostMapping("/addUser")
        public String addUser(@RequestParam("name")String name, @RequestParam("email")String email) {
            userService.insertUser(new User(name,email));
            return "redirect:/";
        }
        @PostMapping("/deleteUser")
        public String deleteUser(@RequestParam("id")int id) {
            User user = userService.getUserById(id);
            if(user != null) {
                userService.deleteUser(user);
            }
            return "redirect:/";
        }
        @PostMapping("/updateUser")
        public String updateUser(@ModelAttribute User user) {
            userService.updateUser(user);
            return "redirect:/";
        }
    }
