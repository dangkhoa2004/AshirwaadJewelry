package com.shop.Jewelry.Controler;

import com.shop.Jewelry.Configuration.SessionManager;
import com.shop.Jewelry.Model.Account;
import com.shop.Jewelry.Model.Mouse;
import com.shop.Jewelry.Repository.AccountRepository;
import com.shop.Jewelry.Repository.MouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    public MouseRepository mouseRepo;

    @Autowired
    public AccountRepository accountRepo;

    Account account = null;

    // Không cần isLogin
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        String textFail = null;
        this.account = accountRepo.findByUsername(username);
        if (this.account == null) {
            textFail = "Đăng nhập thất bại !";
            model.addAttribute("textFail", textFail);
            return "login";
        }
        SessionManager.login(account);
        return "redirect:/fshop";
    }

    @GetMapping("/logout")
    public String logout() {
        SessionManager.logout();
        return "redirect:/fshop";
    }

    @GetMapping("/fshop")
    public String fshop(Model model) {
        List<Mouse> lstMouse = mouseRepo.findAll();
        model.addAttribute("lstMouse", lstMouse);
        return "fshop";
    }
}
