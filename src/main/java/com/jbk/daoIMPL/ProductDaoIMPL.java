package com.jbk.daoIMPL;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao{
	Product product=null;
	 List<Product> list=new ArrayList<Product>();
	 
	 public ProductDaoIMPL() {
		 list.add(new Product(1l,"aaa",155l,22l,65,233d));
		 list.add(new Product(9l,"ddd",155l,22l,65,235d));
		 list.add(new Product(5l,"eee",55l,22l,85,23d));
		 list.add(new Product(2l,"bbb",55l,25l,85,293d));
		 list.add(new Product(3l,"ccc",15l,26l,67,236d));
	 }
	 
	@Override
	public boolean saveProduct(Product product) {
		boolean isExists=false;
		for (Product dbproduct : list) {
			if(dbproduct.getProductName().equalsIgnoreCase(product.getProductName())) {
				isExists=true;
				break;
			}
			
		}
		if(!isExists) {
			list.add(product);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Product getProductId(Long productId) {
		Product product=null;
		 for (Product dbproduct : list) {
	            if (dbproduct.getProductId().equals(productId)) {
	                product=dbproduct;
	                break;
	            }
	        }
	        return product;
		
		
	}

	@Override
	public List<Product> getaAllProduct() {
		
		return list;
	}

	@Override
	public boolean deleteProduct(Long productId) {
			boolean isdeleted=false;
			for (Product product : list) {
				if( product.getProductId().equals(productId)) {
					list.remove(productId);
					isdeleted=true;
					break;
				}
				
			}
			return isdeleted;
			
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isupdate=false;
		for (Product dbproduct : list) {
			if(dbproduct.getProductId().equals(product.getProductId())) {
				list.set(list.indexOf(dbproduct), product);
				isupdate=true;
				break;
			}
		}
			return isupdate;
	}

	
	@Override
	public double countSumOfProductPrice() {
		
		return 0;
	}

	@Override
	public Product getMaxPriceProduct() {
	
		return null;
	}

	@Override
	public Product getMinPriceProduct() {
		
		return null;
	}

	@Override
	public int getTotalCountOfProdcut() {
		
		return 0;
	}

}
