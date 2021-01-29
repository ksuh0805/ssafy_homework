package com.ssafy.exception;

public class DuplicateException extends RuntimeException{
	DuplicateException(){
		System.err.println("이미 존재하는 상품입니다");
	}
}
