package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.Product;
import com.project.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3/")
public class ProductController {
	@Autowired
	private ProductService pserv;
	
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)    // response is give record to postman
	{
		return new ResponseEntity<Product>(pserv.createProductDetail(product),HttpStatus.CREATED);
	}
	
	 @GetMapping("/product")
	    public List<Product> getAllProducts() {
	        return pserv.getAllProducts();
	    }
	
	@GetMapping("/product/{productID}")
	public ResponseEntity<Product> getProduct(@PathVariable("productID")  Long productID)    // response is give record to postman
	{
		return new ResponseEntity<Product>(pserv.getProductById(productID),HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productID}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productID")  Long productID)    // response is give record to postman
	{
		pserv.deleteProductDetail(productID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/product/{productID}")
	public ResponseEntity<String> updatedProduct(@PathVariable("productID")  Long productID,@Valid @RequestBody Product product)    // response is give record to postman
	{
		pserv.updateProductDetail(product, productID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


}
