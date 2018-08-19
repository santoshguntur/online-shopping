package net.gsk.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.gsk.onlineshopping.exception.ProductNotFoundException;
import net.gsk.shoppingbackend.dao.CategoryDAO;
import net.gsk.shoppingbackend.dao.ProductDAO;
import net.gsk.shoppingbackend.dto.Category;
import net.gsk.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index(){
		logger.info("Info log for index");
		logger.debug("Debug log for index");
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home Page ");
		//passing the list of categories
		//System.out.println("categories:"+ categoryDAO.list());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}@RequestMapping(value={"/about"})
	public ModelAndView about(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	/*
	 * Methods to all products and based on category 
	 * */
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All products");
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("page");
		
		//category DAO to fetch single category
		Category c=null;
		c=categoryDAO.get(id);
		mv.addObject("title", c.getName());
		mv.addObject("categories", categoryDAO.list());
		//passng single category object
		mv.addObject("category", c);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
	@RequestMapping(value={"/show/{id}/product"})
	public ModelAndView showSingleProducts(@PathVariable("id") int id ) throws ProductNotFoundException{
		ModelAndView mv=new ModelAndView("page");
		
		Product product=productDAO.get(id);
		
		if (product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
 /*   @RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting){
    	if(greeting ==null)
    		greeting ="Welcome to Spring MVC";
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
    
    @RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting){
    	if(greeting ==null)
    		greeting ="Welcome to Spring MVC";
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
*/
}