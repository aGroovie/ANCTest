package drugstore.ukraine.controller.admin;

import drugstore.ukraine.entity.Family;
import drugstore.ukraine.entity.User;
import drugstore.ukraine.service.FamilyService;
import drugstore.ukraine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("admin")
@SessionAttributes("family")
public class AdminController {


    @Autowired
    UserService userService;

    @Autowired
    FamilyService familyService;

    @GetMapping("user-list")
    public String userList(Model model) {

        model.addAttribute("users", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("family-list")
    public String familyList(Model model) {

        model.addAttribute("families", familyService.getAllFamilies());
        return "family-list";
    }


    @GetMapping(value = "editUserWithId/{id}")
    public String showUser(Model model, @PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        Iterable<Family> families = familyService.getAllFamilies();
        model.addAttribute("families", families);
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping(value = "updateUserWithId/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable Long id, @RequestParam String familyId) {
        Optional<Family> familyToAdd = familyService.getFamilyById(Long.parseLong(familyId));
        user.setFamily(familyToAdd.get());
        userService.updateUser(id, user);
        return "redirect:/admin/user-list";
    }

    @GetMapping(value = "deleteUserById/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/user-list";
    }

    @GetMapping(value = "deleteFamilyWithId/{id}")
    public String deleteFamilyById(@PathVariable("id") Long id) {
        familyService.deleteFamilyById(id);
        return "redirect:/admin/family-list";
    }

    @GetMapping(value = "editFamilyWithId/{id}")
    public String showFamily(Model model, @PathVariable Long id) {
        Optional<Family> family = familyService.getFamilyById(id);
        model.addAttribute("family", family.get());
        return "family-info";
    }

    @GetMapping(value = "editFamilyWithId/{id}deleteUserFromFamilyById/{id}")
    public String deleteUserFromFamilyById(@PathVariable("id") Long id) {
        Optional<User> userToRemove = userService.getUserById(id);
        userToRemove.get().setFamily(null);
        userService.saveUser(userToRemove.get());
        return "redirect:/admin/family-list";
    }

    @GetMapping("new-family")
    public String registrationFamily(Model model) {
        model.addAttribute("family", new Family());
        return "new-family";
    }

    @PostMapping("/familyRegistration")
    public String registerFamily(@ModelAttribute Family family) {
        familyService.saveFamily(family);
        return "redirect:/admin/family-list";
    }
}
