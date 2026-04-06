package session02_btvn.bai3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              HttpServletRequest request) {

        if (("admin".equals(username) && "admin123".equals(password)) ||
                ("staff".equals(username) && "staff123".equals(password))) {

            session.setAttribute("loggedUser", username);
            session.setAttribute("role", "admin".equals(username) ? "Quản lý" : "Nhân viên");
            return "redirect:/orders";
        } else {
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}