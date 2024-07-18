package com.project.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Product;
import com.project.exception.ProductNotFoundException;
import com.project.repository.ProductRepository;
import com.project.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository prepo;
	
	@Override
	public Product createProductDetail(Product product) {
		// TODO Auto-generated method stub
		return prepo.save(product);
	}

	@Override
	public Product getProductById(Long productID) {
		// TODO Auto-generated method stub
		return prepo.findById(productID).
				orElseThrow(()-> new ProductNotFoundException("product Info not correct"));
	}

	@Override
	public Product updateProductDetail(Product product, Long productID) {
		// TODO Auto-generated method stub
		Product pro = prepo.findById(productID)
                .orElseThrow(() -> new ProductNotFoundException("product ID " + productID + " not found"));
		pro.setCategory(pro.getCategory());
		pro.setDescription(pro.getDescription());
		pro.setPrice(pro.getPrice());
		pro.setProductID(pro.getProductID());
		pro.setProductName(pro.getProductName());
		pro.setQuantityAvailable(pro.getQuantityAvailable());
		return prepo.save(pro);
	}

	@Override
	public Product deleteProductDetail(Long productID) {
		// TODO Auto-generated method stub
		Product pro = prepo.findById(productID)
                .orElseThrow(() -> new ProductNotFoundException("product  not found"));
        prepo.delete(pro);
		return pro;	
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
