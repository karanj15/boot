package com.cg.cart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cart.model.Product;
import com.cg.cart.repo.CartRepo;

@Service
public class CartService {

	@Autowired
	private CartRepo repo;
	public List<Product> fetchproductList(){
		return repo.findAll();
		
	}
	public Product saveProductToDB(Product product)
	{
		return repo.save(product);
	}
	public Optional<Product> fetchProductById(int id)
	{
		return repo.findById(id);
	}
	public String  deleteProductById(int id)
	{
		String result;
		try {
		repo.deleteById(id);
		result="Product successfully deleted";
	}
		catch (Exception e) {
			result="product with id is not available";
		}
		return result;
}

}
