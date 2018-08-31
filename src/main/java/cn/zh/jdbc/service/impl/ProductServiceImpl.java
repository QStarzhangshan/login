package cn.zh.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zh.jdbc.dao.ProductDao;
import cn.zh.jdbc.domain.Product;
import cn.zh.jdbc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return productDao.findAll(); 
	}

}
