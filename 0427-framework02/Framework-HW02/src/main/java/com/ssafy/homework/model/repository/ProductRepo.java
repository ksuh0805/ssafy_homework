package com.ssafy.homework.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.homework.model.dto.Product;

public interface ProductRepo {
	public List<Product> select() throws SQLException;
	public void insert(Product product) throws SQLException;
}
