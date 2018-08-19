package net.gsk.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{

	@Override
	public String getMessage() {
		return message;
	}

	
	private static final long serialVersionUID = 1L;
    private String message;
    
	public ProductNotFoundException() {
		this("Product is not avilable.");
	}

	public ProductNotFoundException(String message) {
		this.message=System.currentTimeMillis()+" : "+ message;
		
	}

	
	

}
