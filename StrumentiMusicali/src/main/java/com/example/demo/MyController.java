package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	ArrayList<Strumenti> listaV= new ArrayList<>();
	
	@Autowired
	JdbcTemp s1;
	
	@GetMapping("/gestore")
	public String getGestore() {
		return "gestore";
	}
	
	@ResponseBody
	@PostMapping("/inserisci")
	public String setGestore(@RequestParam("nome") String nome, @RequestParam("marca") String marca, 
			@RequestParam("prezzo") double prezzo, @RequestParam("url") String url) {
		s1.insertStrumento(nome, marca, prezzo, url, 50, 0);
		return nome + " aggiunto con successo";
	}
	
	@ResponseBody
	@PostMapping("/aggiornaPezzi")
	public String setPezzi(@RequestParam("nome") String nome, @RequestParam("pezzi") int pezzi) {
		s1.updatePezzi(nome, pezzi);
		return nome + " quantità aggiornata";
	}
	
	@ResponseBody
	@PostMapping("/aggiornaPrezzo")
	public String setPrezzo(@RequestParam("nome") String nome, @RequestParam("prezzo") double prezzo) {
		s1.updatePrezzo(nome, prezzo);
		return nome + " prezzo aggiornato";
	}
	
	@GetMapping("/store")
	public String store(Model model) {
		ArrayList<Strumenti> listaS = s1.getLista();
		model.addAttribute("listaS", listaS);
		return "store";
	}
	
	@ResponseBody
	@PostMapping("/aggiornaUrl")
	public String setUrl(@RequestParam("nome") String nome, @RequestParam("url") String url) {
		s1.updateUrl(nome, url);
		return nome + " url aggiornato";
		
	}
	
	@PostMapping("/buy")
	public String recap(@RequestParam("selected") ArrayList<Integer> selected, Model model) {
		int somma=0;
		ArrayList<Strumenti> lista = s1.getLista();
		ArrayList<Strumenti> listaAc = new ArrayList<>();
		
		for(int i=0; i<lista.size(); i++) {
			
			if(selected.get(i)>0) {
				somma += selected.get(i)*lista.get(i).getPrezzo();
				Strumenti sm1= new Strumenti(lista.get(i).getNome(), lista.get(i).getMarca(), lista.get(i).getPrezzo(),
						lista.get(i).getUrl(),  selected.get(i));
				 listaAc.add(sm1);
				 s1.change( lista.get(i).getNome(), selected.get(i));
			}
		}
		
		model.addAttribute("lista", listaAc);
		model.addAttribute("somma", somma);
		return "recap";
	}

}
