package com.project.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Cart;
import com.project.exception.CartNotFoundException;
import com.project.repository.CartRepository;
import com.project.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository crepo;
	
	@Override
	public Cart addCartDetail(Cart cart) {
		// TODO Auto-generated method stub
		return crepo.save(cart);
	}

	@Override
	public Cart getCartDeatil(Long cartID) {
		// TODO Auto-generated method stub
		return crepo.findById(cartID).
				orElseThrow(()-> new CartNotFoundException("cart Id not correct"));  
	}

	@Override
	public Cart updateCartDetail(Cart cart, Long cartID) {
		// TODO Auto-generated method stub
		Cart ct = crepo.findById(cartID)
                .orElseThrow(() -> new CartNotFoundException("cart with ID " + cartID + " not found"));
		 ct.setCartID(ct.getCartID());
		 ct.setProductID(ct.getProductID());
		 ct.setQuantity(ct.getQuantity());
		 ct.setTotalPrice(ct.getTotalPrice());
		 ct.setUserID(ct.getUserID());
		 ct.setUserID(ct.getUserID());
			return crepo.save(ct);

	}

	@Override
	public Cart deleteCartDetail(Long cartID) {
		// TODO Auto-generated method stub
		Cart ct = crepo.findById(cartID)
                .orElseThrow(() -> new CartNotFoundException("cart Id not found"));
        crepo.delete(ct);
		return ct;	
		}

}
