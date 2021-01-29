package com.ssafy.exception;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException() {
		System.err.println("해당 상품이 존재하지 않습니다");
	}
}
