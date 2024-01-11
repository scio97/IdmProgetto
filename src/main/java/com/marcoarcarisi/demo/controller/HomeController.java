package com.marcoarcarisi.demo.controller;

import com.marcoarcarisi.demo.entity.DatiLogin;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showHome(HttpSession session) {
        DatiLogin user = (DatiLogin) session.getAttribute("user");
        if(user!=null){
            return "Home";
        }
        return "Login";
    }

}
