package com.project.controller;

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
import com.project.entity.Cart;
import com.project.service.CartService;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CartController {
	
	
	@Autowired
	private CartService cserv;
	
	@PostMapping("/Cart/addCart")
	public ResponseEntity<Cart> saveCart(@Valid @RequestBody Cart cart)    // response is give record to postman
	{
		return new ResponseEntity<Cart>(cserv.addCartDetail(cart),HttpStatus.CREATED);
	}
	
	@GetMapping("/Cart/get/{cartID}")
	public ResponseEntity<Cart> getCart(@PathVariable("cartID")  Long cartID)    // response is give record to postman
	{
		return new ResponseEntity<Cart>(cserv.getCartDeatil(cartID),HttpStatus.OK);
	}
	
	@DeleteMapping("/Cart/remove/{cartID}")
	public ResponseEntity<String> deleteCart(@PathVariable("cartID")  Long cartID)    // response is give record to postman
	{
		cserv.deleteCartDetail(cartID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/Cart/update/{cartID}")
	public ResponseEntity<String> updatedCart(@PathVariable("cartID")  Long cartID,@Valid @RequestBody Cart cart)    // response is give record to postman
	{
		cserv.updateCartDetail(cart, cartID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}

}
