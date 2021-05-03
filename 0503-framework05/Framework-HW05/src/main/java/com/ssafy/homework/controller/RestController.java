package com.ssafy.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.homework.model.dto.Product;
import com.ssafy.homework.model.service.ProductService;

@Controller
@RequestMapping("/manage")
public class RestController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> retriveProduct() throws Exception{
		List<Product> list = productService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> detailProduct(@PathVariable("id") String id) throws Exception{
		Product p = productService.select(id);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	@PostMapping(value = "/product")
	public ResponseEntity<List<Product>> userRegister(@RequestBody Product product) throws Exception {
		int cnt = productService.insert(product);
		List<Product> list = productService.selectAll();
		if(cnt == 0) {
			return new ResponseEntity(HttpStatus.CONFLICT);			
		}
		else if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	@PutMapping(value = "/product")
	public ResponseEntity<List<Product>> productModify(@RequestBody Product product) throws Exception {
		productService.update(product);
		List<Product> list = productService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<List<Product>> productDelete(@PathVariable("id") String id) throws Exception {
		productService.delete(id);
		System.out.println("delete" + " " + id);
		List<Product> list = productService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
}
