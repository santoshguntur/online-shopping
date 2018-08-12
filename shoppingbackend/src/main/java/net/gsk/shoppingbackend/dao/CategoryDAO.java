package net.gsk.shoppingbackend.dao;

import java.util.List;

import net.gsk.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category c);
	
	List<Category> list();

	Category get(int id);

}
