package com.marcoarcarisi.demo.controller;

import com.marcoarcarisi.demo.entity.DatiLogin;
import com.marcoarcarisi.demo.service.DatiLoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private DatiLoginService service;

    @GetMapping("/register")
    public String showRegistrationForm(HttpSession session) {
        //String user = session.getAttribute("user");
        if(session.getAttribute("user") !=null){
            return "redirect:/";
        }
        return "Register";
    }

    @PostMapping("/register")
    public String processRegistration(@RequestParam String username,String password, Model model,HttpSession session) {
        try {
            DatiLogin user = new DatiLogin(username,password,"base");
            boolean inserito=service.insertDato(user);
            if(inserito){
                session.setAttribute("user",user);
                return "Home";
            } else {
                model.addAttribute("error", "Credenziali non valide per la registrazione");
                model.addAttribute("alertClass", "alert-danger"); // Aggiungi un attributo per definire la classe dell'alert
                return "Register";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Errore durante la registrazione: " + e.getMessage());
            return "Home";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(HttpSession session) {
        DatiLogin user = (DatiLogin) session.getAttribute("user");
        if(user!=null){
            return "Home";
        }
        return "Login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, String password, Model model, HttpSession session) {
        try {
            DatiLogin user = new DatiLogin(username,password,"base");
            if(service.effettuaAccesso(username,password)==true){
                session.setAttribute("user",user.getUserName());
                return "Home";
            } else {
                model.addAttribute("error", "Credenziali non valide. Riprova.");
                model.addAttribute("alertClass", "alert-danger"); // Aggiungi un attributo per definire la classe dell'alert
                return "Login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Errore durante la registrazione: " + e.getMessage());
            return "Home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        //DatiLogin user =(DatiLogin)session.getAttribute("user");
        if(session.getAttribute("user") != null){
            //session.setAttribute("user", null);
            session.invalidate();
            return "redirect:/";
        }
        return "redirect:/";
    }

}
