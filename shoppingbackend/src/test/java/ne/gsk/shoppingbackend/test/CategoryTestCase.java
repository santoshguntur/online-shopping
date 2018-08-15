package ne.gsk.shoppingbackend.
test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.gsk.shoppingbackend.dao.CategoryDAO;
import net.gsk.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category c1;
	
	@BeforeClass
	public static void init(){
		context = new  AnnotationConfigApplicationContext();
		context.scan("net.gsk.shoppingbackend");
		context.refresh();
		categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
	}
   
/*	 @Test
	 public void testAddCategory(){
		  c1=new Category();
			c1.setDescription("desccccc"); c1.setName("Television");c1.setImgURL("CAT_01.png");
         assertEquals("Successfully Added Customer category",true,categoryDAO.add(c1));
	 }
	
	//Get method test case
	 @Test
	 public void testGetCategory(){
		 c1=categoryDAO.get(35);
         assertEquals("Successfully fetched the Customer category",1,c1.getId());
	 }
	
	 @Test
	 public void testUpdateCategory(){
		 c1=categoryDAO.get(35);
		 c1.setDescription("Desc Updated...");
        assertEquals("Successfully updated the Customer",true,categoryDAO.update(c1));
	 }
	
	@Test
	 public void testDeleteCategory(){
		 c1=categoryDAO.get(35);
       assertEquals("Successfully deleted the Customer category",true,categoryDAO.delete(c1));
	 }*/
	
	/* @Test
	 public void testAllCategorys(){
		
        assertEquals("Successfully fectced the list of categories",2,categoryDAO.list().size());
	 }*/
	
	@Test
	public void testCURDCategory(){
       //Add oparation
		Category c1=new Category();
		
		c1.setDescription("desccccc"); c1.setName("Television");c1.setImgURL("CAT_01.png");
		 assertEquals("Successfully Added Customer category",true,categoryDAO.add(c1));
      Category c2=new Category();
		
		c2.setDescription("Mobile desccccc"); c2.setName("Mobile");c2.setImgURL("CAT_02.png");
		 assertEquals("Successfully Added Customer category",true,categoryDAO.add(c2));
	   Category c3=new Category();
			
			c3.setDescription("Laptop desccccc"); c3.setName("Laptop");c3.setImgURL("CAT_03.png");
			 assertEquals("Successfully Added Customer category",true,categoryDAO.add(c3));
		
	//Fetching and renaming the category
			 c1=categoryDAO.get(2);
			 c1.setDescription("Desc updated");
			 assertEquals("Successfully updated the Customer",true,categoryDAO.update(c1));
	//Delete the category
			 c1=categoryDAO.get(2);
		       assertEquals("Successfully deleted the Customer category",true,categoryDAO.delete(c1));
	//Get all the list		 
		       assertEquals("Successfully fectced the list of categories",2,categoryDAO.list().size());
	}
}