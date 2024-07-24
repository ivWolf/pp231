package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(ModelMap model,
                              @RequestParam(value = "count", required = false, defaultValue = "100") Integer count) {
        model.addAttribute("users", userService.getUsers(count));

        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("email") String email) {
        userService.saveUser(new User(name, email));
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        User user = userService.getUserById(id);
        if (user != null) {
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