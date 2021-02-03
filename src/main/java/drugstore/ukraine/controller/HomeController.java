package drugstore.ukraine.controller;
import drugstore.ukraine.entity.User;
import drugstore.ukraine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("403")
    public String accessDenied() {
        return "/403";
    }


    @GetMapping("home")
    public String showHome() {
        return "home";
    }

    @GetMapping("registration")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("registration")
    public String register(@Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "User name or password incorrect");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }
        return "login";
    }
    @GetMapping(value = "myProfile")
    public String showProfile(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userService.getUsernameFromSession(principal);
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "myProfile";

    }
    @GetMapping("admin")
    public String adminHome(Model model) {
        return "admin";
    }

    @GetMapping("updateUserWithId{id}")
    public String getUpdateUser(@PathVariable("id") Long id, Model model, @ModelAttribute("user") User user){
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }
}
