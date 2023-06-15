package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;
import com.jbk.sorting.ProductNameComparator;
@Service
public class ProductServiceIMPL implements ProductService {
	@Autowired
	private ProductDao dao;
	List<Product> list=null;
   
	@Override
	public boolean saveProduct(Product product) {
		String productid = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductId(Long.parseLong(productid));
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductId(Long productId) {
		Product product2 = dao.getProductId(productId);
		
		return product2;
	} 

	@Override
	public List<Product> getaAllProduct() {
		List<Product> list = dao.getaAllProduct();
		return list;
	}

	@Override
	public boolean deleteProduct(Long productId) {
		boolean deleteProduct = dao.deleteProduct(productId);
		if(deleteProduct)
		return true;
		else
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> sortProductByName_ASC() {
		
		List<Product> sortProductASC = getaAllProduct();
		/*Collections.sort(sortProductASC, new ProductNameComparator());
		return sortProductASC;*/	
		Collections.sort(sortProductASC, new Comparator < Product > () {
			
            @Override
            public int compare(Product o1, Product o2) {
                return (int)(o1.getProductName().compareTo(o2.getProductName()));
            }
			
        });
		return sortProductASC;
		
		/*// using lambda expression
        // ascending order
        Collections.sort(sortProductASC, (o1, o2) -> (o1.getName().compareTo(o2.getName())));
        System.out.println("Ascending order => " + sortProductASC);
        // descending order
        Collections.sort(sortProductASC, (o1, o2) -> (o2.getName().compareTo(o1.getName())));
        System.out.println("Descending order => " + sortProductASC);*/
	}

	@Override
	public List<Product> sortProductById_DSC() {
		List<Product> sortProductDSC=getaAllProduct();
		/*Collections.sort(sortProductDSC, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p2.getProductId() - p1.getProductId());
            }
        });
		return sortProductDSC;*/
		Collections.sort(sortProductDSC, Comparator.comparingLong(Product::getProductId));
		return sortProductDSC;
		
	}	@Override
	public List<Product> sortProductByPrice_DSC() {
		List<Product> sortProductDSC=getaAllProduct();
		
		Collections.sort(sortProductDSC, Comparator.comparingDouble(Product::getProductPrice).reversed());
		return sortProductDSC;
	}
	@Override
	public double countSumOfProductPrice() {
		List<Product> list=getaAllProduct();
	        return list.stream() .mapToDouble(Product::getProductPrice).sum();
	        
		/*List<Product> list = getaAllProduct();
		Double sumOfProductPrice = list.stream().map(product -> product.getProductPrice()).reduce(0d,
				(sum, price) -> sum + price);
		return sumOfProductPrice;*/
	                	
	}

	@Override
	public Product getMaxPriceProduct() {
		List<Product> list = getaAllProduct();
		Product product = list.stream().max(Comparator.comparingDouble(Product::getProductPrice)).get();

		return product;
	}
		
	

	@Override
	public Product getMinPriceProduct() {
		List<Product> list = getaAllProduct();
		Product product = list.stream().min(Comparator.comparingDouble(Product::getProductPrice)).get();
		return product;
	}

	@Override
	public int getTotalCountOfProdcut() {
		
		return getaAllProduct().size();
	}

	@Override
	public List<Product> sortProductByPrice_ASC() {
		List<Product> sortProductASC=getaAllProduct();
		/*Collections.sort(sortProductASC, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return (int) (p1.getProductId() - p2.getProductId());
            }
        });
		return sortProductASC;*/
		
		Collections.sort(sortProductASC, Comparator.comparingDouble(Product::getProductPrice));
		return sortProductASC;
		
		//Collections.sort(sortProductASC, (p1, p2) -> (p1.getProductPrice().compareTo(p2.getProductPrice())));
        //System.out.println("Ascending order => " + sortProductASC);
		
	}

	@Override
	public List<Product> minmaxProductPrice(double minPrice, double maxPrice) {
		List<Product> list = getaAllProduct();
		return list.stream()
                .filter(product -> product.getProductPrice() >= minPrice && product.getProductPrice() <= maxPrice)
                .collect(Collectors.toList());
		
	}

	

}
