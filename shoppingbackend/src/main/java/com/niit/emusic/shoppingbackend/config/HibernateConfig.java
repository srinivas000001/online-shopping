package com.niit.emusic.shoppingbackend.config;
import javax.sql.DataSource;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.emusic.shoppingbackend.dao.ProductDAO;
import com.niit.emusic.shoppingbackend.daoimpl.ProductDAOImpl;
import com.niit.emusic.shoppingbackend.model.Product;


@Configuration
@ComponentScan(basePackages={"com.niit.emusic.shoppingbackend.model"})

@EnableTransactionManagement

public class HibernateConfig 

{
	//Change the below based on DBMS
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/test";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	
	//@Bean(name = "dataSource")
	@Bean
	public DataSource getDataSource() 
	{
		
		
		BasicDataSource dataSource=new BasicDataSource();
		
	//providing the database connection information
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
    
    
    private Properties getHibernateProperties() 
    {
    	Properties properties = new Properties();
    
    	properties.put("hibernate.dialect",DATABASE_DIALECT);
        properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.format_sql", "true");
    //	properties.put("hbm2ddl.auto", "update");
    	return properties;
    }
    
   //@Autowired
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) 
    {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.scanPackages("com.niit.emusic.shoppingbackend.model");
      	return sessionBuilder.buildSessionFactory();
    }
    
	//@Autowired
	@Bean(name = "transactionManager")
    //@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
    
}
