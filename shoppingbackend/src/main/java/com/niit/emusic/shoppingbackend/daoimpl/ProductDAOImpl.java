package com.niit.emusic.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.emusic.shoppingbackend.dao.ProductDAO;
import com.niit.emusic.shoppingbackend.model.Product;

@Repository("ProductDAO")
@Transactional 
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// getting single product based on id
	@Override
	public Product get(int id) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Product product) {

		try {

			sessionFactory.getCurrentSession().persist(product);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> list() {

		String selectActiveCategory="From Product"; //where active=:active";
		

Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

//query.setParameter("active", true);
return query.getResultList();

	}

	
	//Updating Single Category
	
	@Override
	public boolean update(Product product) {
		try {

			sessionFactory.getCurrentSession().update(product);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Product product) {
		
		
//		product.setIs_Active(false);
		try {

			sessionFactory.getCurrentSession().delete(product);

			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

/*
 * 
 * @Autowired private SessionFactory sessionFactory;
 * 
 * private static List<Product> products=new ArrayList<>();
 * 
 * 
 * static {
 * 
 * 
 * Product product=new Product();
 * 
 * product.setId(1); product.setName("Piono"); product.setDescription(
 * "Very good Noice"); product.setImageURL("1.jpg");
 * 
 * products.add(product);
 * 
 * 
 * product=new Product();
 * 
 * product.setId(2); product.setName("Drums"); product.setDescription(
 * "Very good music"); product.setImageURL("2.jpg");
 * 
 * products.add(product);
 * 
 * 
 * 
 * product=new Product();
 * 
 * product.setId(3); product.setName("Casio"); product.setDescription(
 * "Very good Noice"); product.setImageURL("3.jpg");
 * 
 * products.add(product);
 * 
 * 
 * product=new Product();
 * 
 * product.setId(4); product.setName("Drums Stricks"); product.setDescription(
 * "Very good Noice"); product.setImageURL("4.jpg");
 * 
 * products.add(product);
 * 
 * 
 * 
 * product=new Product();
 * 
 * product.setId(5); product.setName("HeadSet"); product.setDescription(
 * "Very good Noice"); product.setImageURL("5.jpg");
 * 
 * products.add(product);
 * 
 * 
 * }
 * 
 * @Override public List<Product> list() {
 * 
 * 
 * return products; }
 * 
 * @Override public Product get(int id) {
 * 
 * 
 * for(Product product : products) { if(product.getId()==id) { return product; }
 * }
 * 
 * return null; }
 * 
 * @Override
 * 
 * @Transactional public boolean add(Product product) {
 * 
 * try {
 * 
 * sessionFactory.getCurrentSession().persist(product);
 * 
 * return true; }
 * 
 * catch(Exception ex) {
 * 
 * }
 * 
 * return false; }
 * 
 * @Override public boolean update(Product product) { // TODO Auto-generated
 * method stub return false; }
 * 
 * @Override public boolean delete(Product product) { // TODO Auto-generated
 * method stub return false; }
 * 
 * }
 */