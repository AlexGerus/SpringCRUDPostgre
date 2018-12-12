package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.modules.Role;
import project.modules.User;
import project.service.RoleService;
import project.service.UserService;
import java.util.List;

@Controller
public class SpringController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String getAdd(Model model) {
        model.addAttribute("userAttribute", new User());
        model.addAttribute("roleAttribute", new Role());
        return "/addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("userAttribute") User user, @ModelAttribute("roleAttribute") Role role) {
        userService.addUser(user);
        roleService.addRole(user, role);
        return "redirect:/list";
    }

    @RequestMapping(value = "/deleteUser/{id}" , method = RequestMethod.GET)
    public String getDelete(@PathVariable("id") long id, Model model) {
        roleService.deleteRole(id);
        userService.deleteUser(id);
        model.addAttribute("id", id);
        return "redirect:/list";
    }

    @RequestMapping(value = {"/","/list"} , method = RequestMethod.GET)
    public String listUsers(Model model){
        List<User> list = userService.listUser();
        model.addAttribute("list", list);
        model.addAttribute("userAttribute", new User());
        model.addAttribute("roleAttribute", new Role());
        return "list";
    }



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") long id, Model model ) {
        model.addAttribute("changeUser", userService.getUser(id));
        return "list";
    }

    @RequestMapping(value = "/changeUser")
    public String changeUser(@RequestParam(value = "idChange") long id,
                             @RequestParam(value = "nameChange") String name,
                             @RequestParam(value = "ageChange") int age,
                             @ModelAttribute("changeUser") User profile) {

        profile.setUserId(id);
        profile.setUserName(name);
        profile.setUserAge(age);
        userService.changeUser(profile);
        return "redirect:/list";
    }
}