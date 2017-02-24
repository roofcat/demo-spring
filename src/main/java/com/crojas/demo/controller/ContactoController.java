package com.crojas.demo.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crojas.demo.model.entities.Contacto;
import com.crojas.demo.model.service.ContactoService;


@RestController
@RequestMapping(value="/contacto")
public class ContactoController {
	
	
	@Autowired
	private ContactoService cs;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity< Collection< Contacto > > showIndex() {
		
		Contacto contacto = new Contacto();
		contacto.setFecha( new Date() );
		contacto.setNombre( "Christian" );
		contacto.setCorreo( "crojas@azurian.com" );
		contacto.setMensaje( "asdasdadasdasdasdasda" );
		
		cs.create( contacto );
		
		Collection<Contacto> contactos = cs.findAll();
		
		return new ResponseEntity< Collection< Contacto > >( contactos, HttpStatus.OK );
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity< Contacto > createContact( @RequestBody Contacto contacto ) {
		
		try {
			
			cs.create( contacto );
			
			return new ResponseEntity<Contacto>( contacto, HttpStatus.OK );
			
		} catch ( Exception e ) {
			
			return new ResponseEntity<Contacto>( HttpStatus.BAD_REQUEST );
			
		}
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity< Contacto > showContact( @PathVariable Integer id  ) {
		
		Contacto contacto = null;
		
		contacto = cs.findOne( id );
		
		if ( contacto == null ) {
			
			return new ResponseEntity< Contacto >( HttpStatus.NOT_FOUND );
			
		} else {
			
			return new ResponseEntity< Contacto >( contacto, HttpStatus.OK );
			
		}
		
	}
	
}
