package cn.zh.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.zh.jdbc.dao.ProductDao;
import cn.zh.jdbc.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void addProduct(Product product) {
		jdbcTemplate.update("insert into product(product_name,product_catalog,product_baseprice,product_sale_unit,"
				+ "product_image,product_description,product_status,product_department value(?,?,?,?,?,?,?,?))",
				product.getProduct_name(),product.getProduct_catalog(),product.getProduct_baseprice(),product.getProduct_sale_unit(),
				product.getProduct_image(),product.getProduct_description(),product.getProduct_status(),product.getProduct_depatement());
	}

	@Override
	public List<Product> findAll() {
		String sql = "select * from product";
		List<Product> products = jdbcTemplate.query(sql,new BeanPropertyRowMapper(Product.class));
		if(products!=null&products.size()>0) {
			return products;
		}else {
			return null;
		}
	
	
	
	
	
	}
	
}
