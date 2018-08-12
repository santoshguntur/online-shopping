package net.gsk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.gsk.shoppingbackend.dao.CategoryDAO;
import net.gsk.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories=new ArrayList();
	@Autowired
	private SessionFactory sessionFactory;
	
	static{
		Category c1=new Category();
		
		c1.setId(1);c1.setDescription("desccccc"); c1.setName("Television");c1.setImgURL("CAT_01.png");
	
      Category c2=new Category();
		
		c2.setId(2);c2.setDescription("Mobile desccccc"); c2.setName("Mobile");c2.setImgURL("CAT_02.png");
	
	   Category c3=new Category();
			
			c3.setId(3);c3.setDescription("Laptop desccccc"); c3.setName("Laptop");c3.setImgURL("CAT_03.png");
			
					
				categories.add(c1);categories.add(c2);categories.add(c3);
	}

	@Override
	public List<Category> list() {
			return categories;
	}

	@Override
	public Category get(int id) {
		for(Category c:categories){
			if(c.getId() == id)
				return c;
		}
			
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category c) {

        try{
        	//add category to database
        	sessionFactory.getCurrentSession().persist(c);
        	return true;
        }
        catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
