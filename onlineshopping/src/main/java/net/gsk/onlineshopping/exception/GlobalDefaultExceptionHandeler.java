package net.gsk.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandeler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerxception(){
		ModelAndView model=new ModelAndView("error");
		model.addObject("errorTitle", "The page is not Constructed");
		model.addObject("errorDescription","The page you are looking for is not avilable now!");
		model.addObject("title", "404 error page");
		return model;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException(){
		ModelAndView model=new ModelAndView("error");
		model.addObject("errorTitle", "Product Not Avilable.");
		model.addObject("errorDescription","The product you are looking is not aviable now.");
		model.addObject("title", "Product Not Found.");
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleNormalException(Exception ex){
		ModelAndView model=new ModelAndView("error");
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		model.addObject("errorTitle", "Contact Administrtor");
		model.addObject("errorDescription",sw.toString());
		model.addObject("title", "Error..");
		return model;
	}
}
