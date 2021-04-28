package com.ssafy.homework.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepo productRepo;
	
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public List<Product> select() throws SQLException {
		return productRepo.select();
	}

	@Override
	public void insert(Product product) throws SQLException {
		productRepo.insert(product);

	}

}
