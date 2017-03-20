package com.crojas.demo.model.dao;

import java.io.Serializable;
import java.util.Collection;


public interface IOperations <T extends Serializable> {
	
	
	public T findOne( final Integer id );
	
	
	public Collection<T> findAll();
	
	
	public void create( final T entity );
	
	
	public T update( final T entity );
	
	
	public void delete( final T entity );
	
	
	public void deleteById( final Integer id );
	
	
}
