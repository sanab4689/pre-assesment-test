package com.example.demo.firstquestion;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
public List<Product> getAllSortedProduct(List<Product> product) {

		
		//Using Comparator,lambda and Method Reference
		

	product.sort(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed());
		return product;
	}

}



