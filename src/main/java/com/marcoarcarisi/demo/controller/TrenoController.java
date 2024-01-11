package com.marcoarcarisi.demo.controller;
import com.marcoarcarisi.demo.entity.DatiLogin;
import com.marcoarcarisi.demo.entity.TreniCreati;
import com.marcoarcarisi.demo.service.TreniCreatiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcoarcarisi.demo.treno.exception.TrenoException;
import com.marcoarcarisi.demo.treno.*;

@Controller
public class TrenoController {

	@Autowired
	TreniCreatiService treniCreatiService;

	@GetMapping("/creaTreno")
	public String mostraFormCreazioneTreno(HttpSession session) {
		DatiLogin user =(DatiLogin)session.getAttribute("user");
		if(user!=null){
			return "creaTrenoForm";
		}
		return "Home";
	}

	@PostMapping("/creaTreno")
	public String creaTreno(@RequestParam String input,String nazionalita, Model model, HttpSession session) {
		try {
			Treno choochoo = new Treno(input);
			model.addAttribute("treno", choochoo);
			DatiLogin utente = (DatiLogin) session.getAttribute("user");
			if(utente!=null) {
				TreniCreati treno = new TreniCreati(input, utente.getUserName(), nazionalita);
				treniCreatiService.insertTrenoCreato(treno);
			}
		} catch (TrenoException e) {
			model.addAttribute("errore", e.getMessage());
			model.addAttribute("suggerimento", e.getSuggerimento());
		}
		return "mostraTreno";
	}
}

