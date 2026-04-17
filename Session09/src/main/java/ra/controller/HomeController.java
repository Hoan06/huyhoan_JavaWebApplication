package ra.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.UserLogin;

import java.util.Arrays;

@Controller
@RequestMapping("/auth")
public class HomeController {
    @GetMapping("/login")
    public String login(@CookieValue(value = "username" , required = false) String username ,
                        @CookieValue(value = "password" , required = false) String password, Model model) {
        UserLogin userLogin = new UserLogin();

        if (username != null && !username.isEmpty()) {
            userLogin.setUsername(username);
        }

        if (password != null && !password.isEmpty()) {
            userLogin.setPassword(password);
            userLogin.setSavePass("save"); // auto tick checkbox
        }

        model.addAttribute("userLogin", userLogin);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userLogin") UserLogin userLogin , HttpSession session , Model model
    , HttpServletResponse response) {
        if (userLogin.getUsername().equals("admin")  && userLogin.getPassword().equals("123456")) {
            session.setMaxInactiveInterval(10*60); // tồn tại session trong 10 phút
            session.setAttribute("username", userLogin.getUsername());

            if (userLogin.getSavePass()!= null && !userLogin.getSavePass().isEmpty()){
                Cookie cUsername = new Cookie("username", userLogin.getUsername());
                Cookie cPassword = new Cookie("password", userLogin.getPassword());

                cUsername.setMaxAge(7 * 24 * 60 * 60); // 7 ngày
                cPassword.setMaxAge(7 * 24 * 60 * 60);

                response.addCookie(cUsername);
                response.addCookie(cPassword);
            } else {
                Cookie cUsername = new Cookie("username", "");
                Cookie cPassword = new Cookie("password", "");

                cUsername.setMaxAge(0);
                cPassword.setMaxAge(0);

                response.addCookie(cUsername);
                response.addCookie(cPassword);
            }

            return "/home";
        } else {
            model.addAttribute("userLogin", userLogin);
            model.addAttribute("message" , "Sai username hoặc password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session , Model model) {
        session.invalidate();
        model.addAttribute("userLogin", new UserLogin());
        return "login";
    }

}
