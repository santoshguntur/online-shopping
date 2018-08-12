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
   
	 @Test
	 public void testCategory(){
		  c1=new Category();
			c1.setDescription("desccccc"); c1.setName("Television");c1.setImgURL("CAT_01.png");
         assertEquals("Successfully Added Customer category",true,categoryDAO.add(c1));
	 }
}
