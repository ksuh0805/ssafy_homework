package com.ssafy.exception;

public class CodeNotFoundException extends RuntimeException{
	public CodeNotFoundException() {
		System.err.println("존재하지 않는 상품입니다");
	}
}
