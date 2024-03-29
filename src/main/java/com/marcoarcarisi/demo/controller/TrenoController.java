package com.marcoarcarisi.demo.controller;
import com.marcoarcarisi.demo.algortitmo.*;
import com.marcoarcarisi.demo.entity.TreniCreati;
import com.marcoarcarisi.demo.service.StandardStringService;
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

import java.util.List;

@Controller
public class TrenoController {

	@Autowired
	TreniCreatiService treniCreatiService;

	@Autowired
	StandardStringService stringService;

	@Autowired
	Algoritmo algoritmo;

	@GetMapping("/creaTreno")
	public String mostraFormCreazioneTreno(HttpSession session) {
		String user =(String) session.getAttribute("user");
		if(user!=null){
			return "creaTreno";
		}
		return "redirect:/login?redirect=ct";
	}


	@PostMapping("/creaTreno")
	public String creaTreno(@RequestParam String input, String nazionalita, Model model, HttpSession session) {
		try {
			Treno choochoo = new Treno(input);
			model.addAttribute("treno", choochoo);
			model.addAttribute("stringaTreno",input);
			model.addAttribute("paeseInput",nazionalita);

			String utente = (String) session.getAttribute("user");
			if (utente != null) {
				String normal = algoritmo.check(nazionalita,stringService.getListaString());
				if(normal!= null) {
					model.addAttribute("inputNormalizzato",normal);
					TreniCreati treno = new TreniCreati(utente, input, normal,stringService.findByPaese(normal).getCodice_paese());
					treniCreatiService.insertTrenoCreato(treno);
				}
				else{
					model.addAttribute("inputNormalizzato","paese non riconosciuto");
					TreniCreati treno = new TreniCreati(utente, input, "paese non riconosciuto",null);
					treniCreatiService.insertTrenoCreato(treno);
				}
			}
		} catch (TrenoException e) {
			model.addAttribute("errore", e.getMessage());
			model.addAttribute("suggerimento", e.getSuggerimento());
		}
		return "mostraTreno";
	}


	@PostMapping("/eliminaTrenoAdmin")
	public String deleteTreno(@RequestParam int idTreno){
		treniCreatiService.deleteTreno(idTreno);
		return "redirect:/listaTreni";
	}

	@GetMapping("/listaTreni")
	public String mostraListaTreni(Model model, HttpSession session){
		String username = (String) session.getAttribute("user");
		if (username != null) {
			List<TreniCreati> treniCreati = treniCreatiService.getTreni();
			model.addAttribute("treniCreati", treniCreati);
			return "ListaTreni";
		} else {
			return "redirect:/login?redirect=lt";
		}
	}
	@GetMapping("/cercaTreni")
	public String cercaTreni(Model model, HttpSession session){
		return "CercaTreni";
	}

	@RequestMapping("/risultatoRicerca")
	public String ricercaTreni(@RequestParam String paese, Model model){
		String normal = algoritmo.check(paese,stringService.getListaString());
		if(normal != null){
			List<TreniCreati> treni = treniCreatiService.getTreniByPaese(normal);
			model.addAttribute("treniTrovati",treni);
			return "risultatoRicerca";
		}
		return "redirect:/cercaTreni";
	}
}

