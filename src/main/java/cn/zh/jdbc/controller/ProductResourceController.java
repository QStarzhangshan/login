package cn.zh.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.zh.jdbc.domain.Product;
import cn.zh.jdbc.service.ProductService;

@RestController
public class ProductResourceController {
	
	@Autowired
	ProductService productService;
	
	//没写完
	public String addProduct(String product_name,String product_catalog,String product_baseprice,String product_description,
			String product_status,String product_department,String product_image,Integer product_sale_unit) {
		
		
		
		return "success";
	}
	
	@RequestMapping(value = "/findAllProduct",method=RequestMethod.GET)
	public List<Product> findAll(){
		List<Product> products = productService.findAll();
		return products;
	} 
}
