package com.jbk.sorting;

import java.util.Comparator;

import com.jbk.model.Product;

public class ProductNameComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		return p2.getProductName().compareTo(p1.getProductName());
		
	}

}
