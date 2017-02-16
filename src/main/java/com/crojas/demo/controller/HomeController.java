package com.crojas.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crojas.demo.model.entities.Contacto;
import com.crojas.demo.model.service.ContactoService;


@RestController
@RequestMapping(value="/contacto")
public class HomeController {
	
	
	@Autowired
	private ContactoService cs;
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Contacto>> showIndex() {
		
		Contacto contacto = new Contacto();
		contacto.setFecha( new Date() );
		contacto.setNombre( "Christian" );
		contacto.setCorreo( "crojas@azurian.com" );
		contacto.setMensaje( "asdasdadasdasdasdasda" );
		
		cs.create( contacto );
		
		List<Contacto> contactos = cs.findAll();
		
		return new ResponseEntity<List<Contacto>>( contactos, HttpStatus.OK );
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Contacto> showContact( @PathVariable Integer id  ) {
		
		Contacto contacto = null;
		
		contacto = cs.findOne( id );
		
		if ( contacto == null ) {
			
			return new ResponseEntity<Contacto>( HttpStatus.NOT_FOUND );
			
		} else {
			
			return new ResponseEntity<Contacto>( contacto, HttpStatus.OK );
			
		}
		
	}
	
}
