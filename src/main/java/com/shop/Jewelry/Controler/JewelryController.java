package com.shop.Jewelry.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Jewelry")
public class JewelryController {

    // Không cần isLogin
    @GetMapping("/home")
    public String home() {
        return "index";
    }

}
