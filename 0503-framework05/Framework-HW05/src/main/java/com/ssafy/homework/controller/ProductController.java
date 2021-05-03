package com.ssafy.homework.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.service.ProductService;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = {"/", "/list"})
	public String list(Model model) throws Exception {
		model.addAttribute("products", productService.selectAll());
		return "list";
	}
	
	@GetMapping(value = "/insertProduct")
	public String insertProductPage(@RequestParam Map<String,Object> model) {
		return "insertForm";
	}
	
	@PostMapping(value ="/processInsertProduct")
	public String processInsertProduct(Product product) throws Exception {
		productService.insert(product);
		return "redirect:/";
	}
	
	@GetMapping(value = "/manageProduct")
	public String manageProductPage() {
		return "manage";
	}
}
