package com.niit.emusic.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.emusic.shoppingbackend.dao.ProductDAO;
import com.niit.emusic.shoppingbackend.model.Product;

public class ProductTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;


@BeforeClass
public static void init()
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.emusic.shoppingbackend");
	context.refresh();
	productDAO=(ProductDAO)context.getBean("ProductDAO");

	
}

/*
@Test
public void testAddProduct()
{
	product =new Product();
	
	
	product.setName("Piono");
	product.setDescription("This is Some description for testing");
	product.setImageURL("1.jpg");
	assertEquals("Successfully added  a Product inside the table",true,productDAO.add(product));
	
}


  
  @Test
 
public void testGetProduct()
{

	product=productDAO.get(1);
	assertEquals("Successfully Fetch  single Product from the table","Telivision",product.getName());

}



@Test
public void testUpdateProduct()
{

	product=productDAO.get(1);
	product.setName("TV");
	
	assertEquals("Successfully Updated  single Product from the table",true,productDAO.update(product));

}


@Test
public void testDeleteProduct()
{

	product=productDAO.get(2);
	product.setName("TV");
	
	assertEquals("Successfully Deleted  single Product from the table",true,productDAO.delete(product));

}



@Test
public void testListProduct()
{

	product=productDAO.get(1);
	product.setName("TV");
	
	assertEquals("Successfully Deleted  single Product from the table",1,productDAO.list().size());

}


*/
@Test
public void testCRUDProduct()
{
	

product=new Product();


//Add operations 
	product.setName("LapTop");
	product.setDescription("This is Some description for Laptop testing");
	product.setImageURL("8.jpg");
	assertEquals("Successfully added  a Product inside the table",true,productDAO.add(product));
	
	product=new Product();
	
	product.setName("Test");
	product.setDescription("This is Some description for Laptop testing");
	product.setImageURL("3.jpg");
	
	assertEquals("Successfully added  a Product inside the table",true,productDAO.add(product));
	
	assertEquals("Successfully Updated  single Product from the table",true,productDAO.update(product));

	
	assertEquals("Successfully Deleted  single Product from the table",true,productDAO.delete(product));
	

	assertEquals("Successfully Deleted  single Product from the table",1,productDAO.list().size());

}



}
