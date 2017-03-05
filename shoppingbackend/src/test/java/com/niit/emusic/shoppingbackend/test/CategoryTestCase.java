package com.niit.emusic.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.emusic.shoppingbackend.dao.CategoryDAO;
import com.niit.emusic.shoppingbackend.model.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;


@BeforeClass
public static void init()
{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.emusic.shoppingbackend");
	context.refresh();
	categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");

	
}

/*
@Test
public void testAddCategory()
{
	category =new Category();
	
	
	category.setName("Piono");
	category.setDescription("This is Some description for testing");
	category.setImageURL("1.jpg");
	assertEquals("Successfully added  a Category inside the table",true,categoryDAO.add(category));
	
}


  
  @Test
 
public void testGetCategory()
{

	category=categoryDAO.get(1);
	assertEquals("Successfully Fetch  single Category from the table","Telivision",category.getName());

}



@Test
public void testUpdateCategory()
{

	category=categoryDAO.get(1);
	category.setName("TV");
	
	assertEquals("Successfully Updated  single Category from the table",true,categoryDAO.update(category));

}


@Test
public void testDeleteCategory()
{

	category=categoryDAO.get(2);
	category.setName("TV");
	
	assertEquals("Successfully Deleted  single Category from the table",true,categoryDAO.delete(category));

}



@Test
public void testListCategory()
{

	category=categoryDAO.get(1);
	category.setName("TV");
	
	assertEquals("Successfully Deleted  single Category from the table",1,categoryDAO.list().size());

}


*/
@Test
public void testCRUDCategory()
{
	

category=new Category();


//Add operations 
	category.setName("LapTop");
	category.setDescription("This is Some description for Laptop testing");
	category.setImageURL("8.jpg");
	assertEquals("Successfully added  a Category inside the table",true,categoryDAO.add(category));
	
	category=new Category();
	
	category.setName("Test");
	category.setDescription("This is Some description for Laptop testing");
	category.setImageURL("3.jpg");
	
	assertEquals("Successfully added  a Category inside the table",true,categoryDAO.add(category));
	
	assertEquals("Successfully Updated  single Category from the table",true,categoryDAO.update(category));

	
	assertEquals("Successfully Deleted  single Category from the table",true,categoryDAO.delete(category));
	

	assertEquals("Successfully Deleted  single Category from the table",1,categoryDAO.list().size());

}



}
