package net.gsk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.gsk.shoppingbackend.dao.ProductDAO;
import net.gsk.shoppingbackend.dto.Product;

@SuppressWarnings("deprecation")
@Transactional
@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	

	@Override
	public boolean add(Product p) {

		try{			
			sessionFactory.getCurrentSession().persist(p);
			return true;
		}catch (Exception e) {
			return false;
		}
	
	}

	@Override
	public boolean update(Product p) {
		try{			
			sessionFactory.getCurrentSession().update(p);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Product p) {
		try{
			p.setActive(false);
		sessionFactory.getCurrentSession().update(p);
		return true;
	}catch (Exception e) {
		return false;
	}
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listActiveProducts() {
		try{
			String selectquery="Form Product where active=:active";
			@SuppressWarnings("rawtypes")
			Query query=sessionFactory.getCurrentSession().createQuery(selectquery);
			   query.setParameter("active", true);		   
				return query.getResultList();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Product> listActiveProductByCategory(int category_id) {
		try{
			String selectquery="Form Product where active=:active and categoryid=:category_id";
			return sessionFactory.
					getCurrentSession().
					createQuery(selectquery, Product.class).
					setParameter("active", true).
					setParameter("category_id", category_id).getResultList();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
    String selectquery="Form Product where active=:active order by id";
		
		return sessionFactory.
				getCurrentSession().
				createQuery(selectquery, Product.class).
				setParameter("active", true).setFirstResult(0).setMaxResults(count).
			    getResultList();
	}

	@Override
	public Product get(int p) {
		
		return sessionFactory.getCurrentSession().get(Product.class, p);
	}
	
	@Override
	public List<Product> list(int p) {
		
		String selectquery="Form Product";
		
		return sessionFactory.
				getCurrentSession().
				createQuery(selectquery, Product.class).
			    getResultList();
	}

}
