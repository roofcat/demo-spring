package com.crojas.demo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {
	
	
	private String[] packages = { "com.crojas.demo.model.entities" };
	
	
	public PersistenceJPAConfig() {
		super();
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource( dataSource() );
		em.setPackagesToScan( packages );
		em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
		
		Properties properties = new Properties();
		properties.put( "hibernate.hbm2ddl.auto", "update" );
		properties.put( "hibernate.show_sql",  "true" );
		properties.put( "hibernate.generateDdl",  "true" );
		properties.put( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
		
		em.setJpaProperties( properties );
		
		return em;
		
	}
	
	
	@Bean
	public JpaTransactionManager transactionManager( EntityManagerFactory entityManagerFactory ) {
		
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( entityManagerFactory );
		return transactionManager;
		
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName( "org.postgresql.Driver" );
		dataSource.setUrl( "jdbc:postgresql://localhost:5432/jpa_demo" );
		dataSource.setUsername( "postgres" );
		dataSource.setPassword( "12345" );
		return dataSource;
		
	}
	
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		
		return new PersistenceExceptionTranslationPostProcessor();
		
	}
	
	
}
