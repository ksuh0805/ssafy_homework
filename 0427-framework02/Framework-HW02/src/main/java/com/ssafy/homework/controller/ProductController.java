package com.ssafy.homework.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("list")
	public void list(Model model) throws SQLException {
		List<Product> products = pService.select();
		model.addAttribute("products", products);
	}
	
	@GetMapping("registerform")
	public void register() {}
	
	@GetMapping("register")
	public String register(Product product) throws SQLException {
		pService.insert(product);
		System.out.println("insert");
		return "registerform";
	}
}
