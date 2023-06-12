package com.jbk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jbk.model.Product;

@Service
public interface ProductService {
	
	public boolean saveProduct(Product product);
	public Product getProductId(Long productId);
	public List<Product> getaAllProduct();
	public boolean deleteProduct(Long productId);
	public boolean updateProduct(Product product);
	
	public List<Product> sortProductByName_ASC();
	public List<Product> sortProductById_DSC();
	public List<Product> sortProductByPrice_ASC();
	public List<Product> sortProductByPrice_DSC();
	public double countSumOfProductPrice();
	public Product getMaxPriceProduct();
	public Product getMinPriceProduct();
	public int getTotalCountOfProdcut();
}
