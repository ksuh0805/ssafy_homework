package com.ssafy.inf;

public class ProductTest {
	public static void main(String[] args) {
		IProductMgr productMgr = ProductMgrImpl.getInstance();
		
		productMgr.add(new TV(123, "abc", 100000, 3, 20, "A"));
		productMgr.add(new TV(567, "xyz", 300000, 10, 60, "B"));
		productMgr.add(new Refrigerator(1000, "ookk", 2500000, 1, 200));
		productMgr.add(new Refrigerator(1005, "ookkk", 500000, 6, 100));
		productMgr.add(new TV(987, "xyz2", 400000, 100, 50, "B"));
		productMgr.add(new Refrigerator(1055, "rf2", 2000000, 99, 900));
		System.out.println("---------------------전체 제품 목록-------------------");
		for(Product p : productMgr.getList()) {
			System.out.println(p);
		}
		System.out.println("--------------------------TV 목록-----------------------");
		for(TV t : productMgr.getTVlist()) {
			System.out.println(t);
		}
		System.out.println("--------------------------냉장고 목록-----------------------");
		for(Refrigerator r : productMgr.getRflist()) {
			System.out.println(r);
		}
		System.out.println("---------------------상품 번호 123 검색---------------------");
		System.out.println(productMgr.searchByNum(123));
		System.out.println("---------------------상품 이름 ok 검색---------------------");
		for(Product p : productMgr.searchByName("ok")) {
			System.out.println(p);
		}
		System.out.println("---------------------400L이상 냉장고 검색----------------------");
		for(Refrigerator r : productMgr.searchByVolume(400)) {
			System.out.println(r);
		}
		System.out.println("---------------------50inch 이상 TV 검색----------------------");
		for(TV t : productMgr.searchByInch(50)) {
			System.out.println(t);
		}
		System.out.println("---------------------상품 번호 987 500000원으로 변경----------------------");
		System.out.println(productMgr.modify(987, 500000) + "상품 가격 변경하였습니다");
		
		System.out.println("---------------------상품 번호 567 삭제----------------------");
		System.out.println(productMgr.remove(567) + "상품 삭제하였습니다");
		
		System.out.println("상품 가격 총합:" + productMgr.getTotalPrice()+ "원");
	}
}
