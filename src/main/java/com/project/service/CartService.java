
package com.project.service;

import org.springframework.stereotype.Service;
import com.project.entity.Cart;

@Service
public interface CartService {
	
	Cart addCartDetail (Cart cart);
	
	Cart getCartDeatil(Long cartID);
	
	Cart updateCartDetail(Cart cart, Long cartID);


	Cart deleteCartDetail(Long cartID);

}
