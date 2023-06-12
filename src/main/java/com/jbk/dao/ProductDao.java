package com.jbk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.model.Product;
@Repository
public interface ProductDao {
	public boolean saveProduct(Product product);
	public Product getProductId(Long productId);
	public List<Product> getaAllProduct();
	public boolean deleteProduct(Long productId);
	public boolean updateProduct(Product product);
	
	

	public double countSumOfProductPrice();
	public Product getMaxPriceProduct();
	public Product getMinPriceProduct();
	public int getTotalCountOfProdcut();
}
