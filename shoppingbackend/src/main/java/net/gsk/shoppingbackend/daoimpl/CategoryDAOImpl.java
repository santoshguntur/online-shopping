package net.gsk.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.gsk.shoppingbackend.dao.CategoryDAO;
import net.gsk.shoppingbackend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories=new ArrayList();
	
	static{
		Category c1=new Category();
		
		c1.setId(1);c1.setDescription("desccccc"); c1.setName("Television");c1.setImgURL("CAT_01.png");
	
      Category c2=new Category();
		
		c2.setId(1);c2.setDescription("desccccc"); c2.setName("Television");c2.setImgURL("CAT_02.png");
	
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
