package com.ssafy.homework.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.homework.model.dto.Product;

@Repository
public class ProductRepoImpl implements ProductRepo {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public List<Product> select() throws SQLException {
		List<Product> list = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from product");
		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("description"));
				list.add(p);
			}
		}finally {
			
		}
		return list;
	}

	@Override
	public void insert(Product product) throws SQLException {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into product"
					+ " (id, name, price, description)"
					+ " values(?, ?, ?, ?)");
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getDescription());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
			
		}finally {
			
		}
	}

}
