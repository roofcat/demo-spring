package com.crojas.demo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.crojas.demo.model.dao.ContactoDao;
import com.crojas.demo.model.entities.Contacto;


@Component
public class ContactoService {
	
	@Autowired
	private ContactoDao dao;
	
	@Transactional
	public Contacto findOne( Integer id ) {
		return dao.findOne( id );
	}
	
	@Transactional
	public Collection<Contacto> findAll() {
		return dao.findAll();
	}
	
	@Transactional
	public void create( Contacto contacto ) {
		dao.create( contacto );
	}
	
	@Transactional
	public Contacto update( Contacto contacto ) {
		return dao.update( contacto );
	}
	
	@Transactional
	public void delete( Contacto contacto ) {
		dao.delete( contacto );
	}
	
	@Transactional
	public void deleteById( Integer id ) {
		dao.deleteById( id );
	}
	
}
