package com.ssafy.homework.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.homework.model.dto.Product;

public interface ProductService {
	public List<Product> select() throws SQLException;
	public void insert(Product product) throws SQLException;
}
