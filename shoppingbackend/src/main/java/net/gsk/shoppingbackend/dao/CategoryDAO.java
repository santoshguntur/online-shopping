package net.gsk.shoppingbackend.dao;

import java.util.List;

import net.gsk.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category c);
	boolean update(Category c);
	boolean delete(Category c);
	

}
