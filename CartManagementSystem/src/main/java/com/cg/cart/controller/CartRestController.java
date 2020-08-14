package com.cg.cart.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cart.model.Product;
import com.cg.cart.services.CartService;


@RestController
public class CartRestController {
	
	@Autowired
	private CartService service;
	
	Logger logger = LoggerFactory.getLogger(CartRestController.class);
	
	@GetMapping("/getproductlist")
	@CrossOrigin(origins= "http://localhost:4200")
	public List<Product> fetchProductList(){
		logger.trace("access to get list of products");
		List<Product> products =  new ArrayList<Product>();
		//logic to fetch list from database
		products= service.fetchproductList();
		return products;
		
	}
	@PostMapping("/addproduct")
	@CrossOrigin(origins= "http://localhost:4200")
	public Product saveProduct(@RequestBody  Product product){
		logger.trace("product has been added sucessfully");
		return service.saveProductToDB(product);
		
	}
	@GetMapping("/getproductbyid/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public Product fetchProductById(@PathVariable int id){
		logger.trace("product has been found");
		return service.fetchProductById(id).get();
		
	}

	@DeleteMapping("/deleteproductbyid/{id}")
	@CrossOrigin(origins= "http://localhost:4200")
	public String DeleteProductById(@PathVariable int id){
		logger.trace("product has been deleted");
		return service.deleteProductById(id);
		
	}

}
