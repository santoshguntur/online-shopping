package net.gsk.shoppingbackend.dao;

import java.util.List;

import net.gsk.shoppingbackend.dto.Product;

public interface ProductDAO {

	//public List<Product> getAllProductList();
	public boolean add(Product p);
	public boolean update(Product p);
	public boolean delete(Product p);
	public Product get(int p);
	public List<Product> list(int p);
	
	//Business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int category_id);
	List<Product> getLatestActiveProducts(int count);
	
	
}
