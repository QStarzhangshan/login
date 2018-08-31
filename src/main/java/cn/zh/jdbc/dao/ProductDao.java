package cn.zh.jdbc.dao;

import java.util.List;

import cn.zh.jdbc.domain.Product;

public interface ProductDao {
	public void addProduct(Product product);

	public List<Product> findAll();
}
