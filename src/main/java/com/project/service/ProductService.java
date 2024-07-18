package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Product;

@Service
public interface ProductService {
	
	 Product createProductDetail (Product product);
		
	 Product getProductById(Long productID);
	
	 Product updateProductDetail(Product product, Long productID);

	 Product deleteProductDetail(Long productID);
	 
		List<Product> getAllProducts();
		


}
