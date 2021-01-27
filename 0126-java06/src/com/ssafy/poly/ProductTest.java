package com.ssafy.poly;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr productMgr = ProductMgr.getInstance();
		
		productMgr.add(new TV(123, "abc", 100000, 3, 20, "A"));
		productMgr.add(new TV(567, "xyz", 300000, 10, 60, "B"));
		productMgr.add(new Refrigerator(1000, "ookk", 2500000, 1, 200));
		productMgr.add(new Refrigerator(1005, "ookkk", 500000, 6, 100));
		productMgr.add(new TV(987, "xyz2", 400000, 100, 50, "B"));
		System.out.println("---------------------전체 제품 목록-------------------");
		for(Product p : productMgr.getList()) {
			System.out.println(p);
		}
		System.out.println("----------------------TV 목록---------------------");
		for(TV t : productMgr.getTVlist()) {
			System.out.println(t);
		}
		System.out.println("---------------------냉장고 목록--------------------");
		for(Refrigerator r : productMgr.getRflist()) {
			System.out.println(r);
		}
		System.out.println("---------------------상품 번호 123 검색---------------------");
		System.out.println(productMgr.searchByNum(123));
		System.out.println("---------------------상품 이름 ok 검색---------------------");
		for(Product p : productMgr.searchByName("ok")) {
			System.out.println(p);
		}
		System.out.println("---------------------상품 번호 567 삭제----------------------");
		System.out.println(productMgr.remove(567));
		System.out.println("상품 가격 총합:" + productMgr.getTotalPrice()+ "원");
	}
}
