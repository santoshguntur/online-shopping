package ne.gsk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.gsk.shoppingbackend.dao.ProductDAO;
import net.gsk.shoppingbackend.dto.Product;

public class ProductTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new  AnnotationConfigApplicationContext();
		context.scan("net.gsk.shoppingbackend");
		context.refresh();
		productDAO= (ProductDAO) context.getBean("ProductDAO");
	}
	
	
	/*	@Test
	public void testCURDOpe(){
		
		product=new Product();
		product.setActive(true);
		product.setBrand("Oppo");
		product.setCategoryId(3);
		product.setDescription("Oppo F1 Plus 64GB");
		product.setName("Oppo F1 Plus");
		product.setQuantity(5);
		product.setUnitprice(15000);
		product.setSupplierId(2);
		
		 assertEquals("Problem with adding Product:",true,productDAO.add(product));
		 
		 product=productDAO.get(2);
		 assertEquals("Problem with getting product:",2,product.getId() );
		 
		 product.setDescription("Updated dessss");
		 assertEquals("Problem with updating product:",true,productDAO.update(product) );
		 
		 assertEquals("Problem with deleting product:",true,productDAO.delete(product) );
		 
		 assertEquals("Problem with getting all products:",6,productDAO.list().size() );
		 
		 
	}*/
	@Test
	public void testListOfActiveProducts(){
		 assertEquals("Problem with getting testListOfActiveProducts:",5,productDAO.listActiveProducts().size() );
	}
	
	@Test
	public void testListOfActiveProductsByCategory(){
		 assertEquals("Problem with getting testListOfActiveProductsByCategory:",3,productDAO.listActiveProductByCategory(3).size() );
	}
	
	@Test
	public void testLatestActiveProducts(){
		 assertEquals("Problem with getting testLatestActiveProducts:",2,productDAO.getLatestActiveProducts(2).size() );
	}
	
}
