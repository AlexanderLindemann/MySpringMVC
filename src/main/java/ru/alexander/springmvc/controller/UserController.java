package ru.alexander.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alexander.springmvc.model.User;
import ru.alexander.springmvc.service.ServiceInterface;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ServiceInterface serviceInterface;


    @GetMapping("/users")
    public String userController(Model model) {
        List<User> list = serviceInterface.listUsers();
        model.addAttribute("list", list);
        return "first/users";
    }

    @GetMapping("/addUser")
    public String getAllUsers(Model model) {
        model.addAttribute("newUser", new User());
        List<User> list = serviceInterface.listUsers();
        model.addAttribute("users", list);
        return "first/addPerson";
    }

    @PostMapping("/addUser")
    public String savePerson(Model model, User user) {
        String name = user.getName();
        String lastName = user.getLastname();
        int age = user.getAge();
        if (name != null && name.length() > 0
                && lastName != null && lastName.length() > 0
                && age != 0) {
            User newUser = new User(name, lastName, age);
            serviceInterface.add(newUser);
            return "redirect:/users";
        } else {
            return "first/addPerson";
        }
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        serviceInterface.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = serviceInterface.findById(id);
        model.addAttribute("user", user);
        return "first/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        serviceInterface.update(user);
//        serviceInterface.add(user);
        return "redirect:/users";
    }
}

