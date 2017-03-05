package com.niit.emusic.shoppingbackend.dao;

import java.util.List;

import com.niit.emusic.shoppingbackend.model.Product;

public interface ProductDAO 
{

 Product get(int id);
	List <Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

}
