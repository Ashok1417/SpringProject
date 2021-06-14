package com.ecom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.Entity.Category;

@Transactional
@Repository(value="CategoryDao")
public class CategoryImplementation implements CategoryDAO

{
    @Autowired
    SessionFactory sessionfac;
    
	@Override
	public boolean addCategory(Category category) {
		try{
			sessionfac.getCurrentSession().save(category);
		
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
	    }
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionfac.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	
		}
		
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
		sessionfac.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		

	@Override
	public List<Category> getCategories() {
		Session session = sessionfac.openSession();
		Query query = session.createQuery("from Category");
		List<Category> list = query.list();
		session.close();
		return list;
	}

	@Override
	public Category getCategory(String CategoryId) {
		Session session = sessionfac.openSession();
		Category category = (Category)session.get(Category.class, CategoryId);
		session.close();
		return category;
	}
	

}
