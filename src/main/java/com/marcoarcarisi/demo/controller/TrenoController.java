package com.marcoarcarisi.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcoarcarisi.demo.treno.exception.TrenoException;
import com.marcoarcarisi.demo.treno.*;

@Controller
public class TrenoController {

	@RequestMapping("/creaTreno")
	public String mostraFormCreazioneTreno() {
		return "creaTrenoForm";
	}

	@PostMapping("/creaTreno")
	public String creaTreno(@RequestParam String input, Model model) {
		try {
			Treno choochoo = new Treno(input);
			model.addAttribute("treno", choochoo);
		} catch (TrenoException e) {
			model.addAttribute("errore", e.getMessage());
			model.addAttribute("suggerimento", e.getSuggerimento());
		}
		return "mostraTreno";
	}
}

