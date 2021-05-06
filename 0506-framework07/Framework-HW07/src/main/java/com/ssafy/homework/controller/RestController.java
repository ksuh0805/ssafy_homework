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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/manage")
public class RestController {
	
	@Autowired
	ProductService productService;
	
	@ApiOperation(value= "상품목록", notes="상품의 <big>전체목록</big>을 반환해줍니다.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "상품목록OK"),
		@ApiResponse(code = 404, message = "페이지없음"),
		@ApiResponse(code = 500, message = "서버에러")
	})
	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> retriveProduct() throws Exception{
		List<Product> list = productService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	@ApiOperation(value= "상품정보", notes="상품의 <big>상세정보</big>를 반환해줍니다.")
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> detailProduct(@PathVariable("id") @ApiParam(value="상품 코드", required = true) String id) throws Exception{
		Product p = productService.select(id);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	@ApiOperation(value= "상품등록", notes="상품 정보 등록")
	@PostMapping(value = "/product")
	public ResponseEntity<List<Product>> productRegister(@RequestBody @ApiParam(value="상품 정보", required = true) Product product) throws Exception {
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
	@ApiOperation(value= "상품수정", notes="상품 정보 수정")
	@PutMapping(value = "/product")
	public ResponseEntity<List<Product>> productModify(@RequestBody @ApiParam(value="상품 정보", required = true) Product product) throws Exception {
		productService.update(product);
		System.out.println("modify" + product.getId());
		List<Product> list = productService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value= "상품삭제", notes="상품 삭제")
	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<List<Product>> productDelete(@PathVariable("id") @ApiParam(value="상품코드", required = true) String id) throws Exception {
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
