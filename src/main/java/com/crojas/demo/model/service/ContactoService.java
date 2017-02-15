package com.crojas.demo.model.service;

import java.util.List;

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
	public void create( Contacto contacto ) {
		dao.create( contacto );
	}
	
	@Transactional
	public List<Contacto> findAll() {
		return dao.findAll();
	}
	
}
