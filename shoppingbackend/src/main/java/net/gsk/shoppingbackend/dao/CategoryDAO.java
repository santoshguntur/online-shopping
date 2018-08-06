package net.gsk.shoppingbackend.dao;

import java.util.List;

import net.gsk.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);

}
