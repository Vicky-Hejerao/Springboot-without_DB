package com.jbk.controller;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.serviceIMPL.ProductServiceIMPL;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	//ProductService service=new ProductServiceIMPL();
	@Autowired
	private ProductService service;
	
	@PostMapping("/save-product")
	public String saveProduct(@RequestBody Product product) {
		boolean isAdded = service.saveProduct(product);
		
		if(isAdded) {
			return "Saved Product";
		}else {
			return "Already Exists";
		}
				
	}
	@GetMapping("/getAllProduct")
	public Object getAllProduct(){
		List<Product> list = service.getaAllProduct();
		if(list.isEmpty()) {
			return "Product not Exists";
		}else {
		return list;
		}
	}
  @GetMapping("/getProductById/{Id}")	
  public Object getProductById(@PathVariable Long Id) {  
	  Product product = service.getProductId(Id);
	  if(product==null) {
		  return "Product Not Exist";
	  }else {
		  return product;
	  }
	
  }
  @DeleteMapping("/delete-product")
  public String deletePoductBId(@RequestParam("id") Long id) {
	  boolean deleteProduct = service.deleteProduct(id);
	  if(deleteProduct) {
		  return "Deleted";
	  }
	  else {
	  return "Product Not Found"+id;
	  }  
  }
  @PutMapping("/update-product")
  public String updateProduct(@RequestBody Product product) {
	  boolean updateProduct = service.updateProduct(product);
	  if(updateProduct) {
		  return "Updated Product";
	  }else {
	      return "Product Not Found="+product.getProductId();
	  }
	  
  }
  	@GetMapping("/ASCsortProductName")
	public Object sortProductByName_ASC(){
		List<Product> sortASC = service.sortProductByName_ASC();
		if(sortASC==null) {
			return "Empty Product";
		}else {
			return sortASC;
		}		
	}
  	@GetMapping("/ASCsortProductId")
	public Object sortProductById_DSC(){
		List<Product> sortDSC = service.sortProductById_DSC();
		if(sortDSC==null) {
			return "Empty Product";
		}else {
			return sortDSC;
		}		
	}
  	@GetMapping("/ASCsortProductPrice")
	public Object sortProductByPrice_ASC(){
		List<Product> sortPriceASC = service.sortProductByPrice_ASC();
		if(sortPriceASC==null) {
			return "Empty Product";
		}else {
			return sortPriceASC;
		}		
	}
  	@GetMapping("/DSCsortProductPrice")
	public Object sortProductByPrice_DSC(){
		List<Product> sortPriceDSC = service.sortProductByPrice_DSC();
		if(sortPriceDSC==null) {
			return "Empty Product";
		}else {
			return sortPriceDSC;
		}		
	}
  	@GetMapping("/sumofAllProductPrice")
  	public double sumofAllProduct(){
  		double countSumOfProductPrice = service.countSumOfProductPrice();
		return countSumOfProductPrice;
  	}
	@GetMapping("/getMaxPriceProduct")
  	public Product getMaxPriceProduct(){
  		Product maxPriceProduct = service.getMaxPriceProduct();
  		return maxPriceProduct;
  	}
	@GetMapping("/getMinPriceProduct")
	public Product getMinPriceProduct() {
		Product minPriceProduct = service.getMinPriceProduct();
		
		return minPriceProduct;
		
	}
	@GetMapping("/getTotalCountOfProdcut")
	public int getTotalCountOfProdcut() {
		int totalCountOfProdcut = service.getTotalCountOfProdcut();
		
		return totalCountOfProdcut;
		
		
	}
	@GetMapping("/minmaxProductPrice/{minPrice}/{maxPrice}")
	public List<Product> minmaxProductPrice(@PathVariable double minPrice, @PathVariable double maxPrice) {
		List<Product> minmaxProductPrice = service.minmaxProductPrice(minPrice, maxPrice);		
		return minmaxProductPrice;	
	}
}
