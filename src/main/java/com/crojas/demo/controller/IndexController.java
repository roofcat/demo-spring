package com.crojas.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crojas.demo.form.ContactoForm;


@Controller
@RequestMapping("/")
public class IndexController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("contactoForm", new ContactoForm());
		
		return mav;
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit( @ModelAttribute("contactoForm") @Valid ContactoForm contactoForm, BindingResult result,
			ModelMap modelMap ) {
		
		if ( result.hasErrors() ) {
			
			System.out.println("existe error");
			
			return new ModelAndView( "index", "contactoForm", contactoForm );
			
		} else {
			
			System.out.println( "no hay error" );
			
			List<ContactoForm> contactos = new ArrayList<>();
			contactos.add( contactoForm );
			contactos.add( contactoForm );
			
			return new ModelAndView( "contacto", "contactos", contactos );
			
		}
		
	}
	
	
}
