package com.marcoarcarisi.demo.controller;

import com.marcoarcarisi.demo.entity.DatiLogin;
import com.marcoarcarisi.demo.entity.TreniCreati;
import com.marcoarcarisi.demo.service.DatiLoginService;
import com.marcoarcarisi.demo.service.TreniCreatiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private DatiLoginService service;

    @Autowired
    private TreniCreatiService treniService;

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
            int inserito=service.insertDato(user);
            if(inserito == 0){
                session.setAttribute("user",user.getUserName());
                session.setAttribute("utente",user);
                return "Home";
            } else if(inserito == 1){
                model.addAttribute("errorUsername", "L'username è già presente nel database.");
                return "Register";
            } else{
                model.addAttribute("errorPassword", "Password non valida, deve contenere almeno un carattere Maiuscolo e un numero");
                return "Register";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Errore durante la registrazione: " + e.getMessage());
            return "Home";
        }
    }

    @GetMapping("/profilo")
    public String showProfile(Model model, HttpSession session) {
        String username = (String) session.getAttribute("user");
        if (username != null) {
            List<TreniCreati> treniCreati = treniService.getTreniByUtente(username);
            model.addAttribute("treniCreati", treniCreati);
            return "Profilo";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/eliminaTreno")
    public String deleteTreno(@RequestParam int trenoId){
        treniService.deleteTreno(trenoId);
        return "redirect:/profilo";
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
            int accesso = service.effettuaAccesso(username,password);
            if(accesso == 0){
                DatiLogin user = new DatiLogin(username,password,service.findByUserName(username).getRuolo());
                session.setAttribute("user",user.getUserName());
                session.setAttribute("utente",user);
                return "Home";
            } else if (accesso == 1){
                model.addAttribute("errorUsername", "Nome utente non valido. Riprova");
                return "Login";
            } else {
                model.addAttribute("errorPassword", "Password non valida. Riprova.");
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
