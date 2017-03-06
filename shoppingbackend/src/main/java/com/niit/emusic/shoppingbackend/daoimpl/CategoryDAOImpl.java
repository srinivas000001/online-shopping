package com.niit.emusic.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.emusic.shoppingbackend.dao.CategoryDAO;
import com.niit.emusic.shoppingbackend.model.Category;
import com.niit.emusic.shoppingbackend.model.Category;


@Repository("CategoryDAO")
@Transactional 
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// getting single category based on id
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Category> list() {

		String selectActiveCategory="From Category"; //where active=:active";
		

Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

//query.setParameter("active", true);
return query.getResultList();

	}

	
	//Updating Single Category
	
	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		
		
//		category.setIs_Active(false);
		try {

			sessionFactory.getCurrentSession().delete(category);

			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
