package com.crojas.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crojas.demo.model.entities.Contacto;
import com.crojas.demo.model.service.ContactoService;


@Controller
@RequestMapping( value = "/export" )
public class ExportarExcelController {
	
	
	@Autowired
	private ContactoService cs;
	
	@GetMapping
	public String index() {
		return "export";
	}
	
	@GetMapping("/excel")
	public String exportar(Model model) {
		
		System.out.println("=== EXPORTANDO ===");
		Collection<Contacto> contactos = this.cs.findAll();
		
		model.addAttribute("contactos", contactos);
		
		return "crearExcel";
		
	}
	
	
}
