package com.crojas.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crojas.demo.model.entities.Contacto;
import com.crojas.demo.model.service.ContactoService;


@RestController
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private ContactoService cs;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Contacto>> showIndex() {
		
		List<Contacto> contactos = cs.findAll();
		System.out.println( contactos.size() );
		
		return new ResponseEntity<List<Contacto>>( contactos, HttpStatus.OK );
		
	}
	
	@RequestMapping(value="/contacto/", method=RequestMethod.GET)
	public ResponseEntity<Contacto> showContact() {
		
		Contacto contacto = new Contacto();
		contacto.setFecha( new Date() );
		contacto.setNombre( "Christian" );
		contacto.setCorreo( "crojas@azurian.com" );
		contacto.setMensaje( "asdasdadasdasdasdasda" );
		
		cs.create( contacto );
		
		return new ResponseEntity<Contacto>( contacto, HttpStatus.OK );
		
	}
	
}
