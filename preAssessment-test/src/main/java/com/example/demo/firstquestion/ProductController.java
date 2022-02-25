package com.example.demo.firstquestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 Map<String, List<Product>> res = new HashMap<String, List<Product>>();
	
	@PostMapping("/sortProducts")	
	public Map<String,List<Product>> getSortedProduct(@RequestBody Map<String,List<Product>> map){

			
		res.put("ProductList", productService.getAllSortedProduct(map.get("productList")));

		return res;
	}

}
