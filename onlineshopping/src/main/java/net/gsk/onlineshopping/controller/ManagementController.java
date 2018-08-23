package net.gsk.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.gsk.shoppingbackend.dao.CategoryDAO;
import net.gsk.shoppingbackend.dao.ProductDAO;
import net.gsk.shoppingbackend.dto.Category;
import net.gsk.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	@Autowired
	private CategoryDAO categorydao;
	@Autowired
	private ProductDAO productdao;

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(value="operation",required=false) String operation){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Manage Products");
		mv.addObject("UserClickManageProducts", true);
		
		Product nproduct=new Product();
		nproduct.setActive(true);
		nproduct.setSupplierId(1);
		
		mv.addObject("product", nproduct);
		if("product".equalsIgnoreCase(operation)){
			mv.addObject("message", "Product Added successfully");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProduct(@ModelAttribute("product") Product mProduct){
		productdao.add(mProduct);
		
		return "redirect:/manage/products?operation=product";
	}
	
	@ModelAttribute("categories")
	public List<Category> getAllCategories(){
		
		return  categorydao.list();
	}

}
