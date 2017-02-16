package com.crojas.demo.model.dao;

import java.io.Serializable;
import java.util.List;


public interface IOperations <T extends Serializable> {
	
	
	public T findOne( final Integer id );
	
	
	public List<T> findAll();
	
	
	public void create( final T entity );
	
	
	public T update( final T entity );
	
	
	public void delete( final T entity );
	
	
	public void deleteById( final Integer id );
	
	
}
