package com.crojas.demo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.crojas.demo.model.entities.Contacto;


@Component
public class ContactoDao implements IContactoDao {
	
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public Contacto findOne( Integer id ) {
		return em.find( Contacto.class, id );
	}
	
	
	@SuppressWarnings( "unchecked" )
	@Override
	public List<Contacto> findAll() {
		Query query = em.createQuery( "SELECT c FROM Contacto c" );
		List<Contacto> contactos = query.getResultList();
		return contactos;
	}
	
	
	@Override
	public void create( Contacto entity ) {
		em.persist( entity );
	}
	
	
	@Override
	public Contacto update( Contacto entity ) {
		return em.merge( entity );
	}
	
	
	@Override
	public void delete( Contacto entity ) {
		em.remove( entity );
	}
	
	
	@Override
	public void deleteById( Integer id ) {
		em.remove( em.find( Contacto.class, id ) );
	}
	
	
}
