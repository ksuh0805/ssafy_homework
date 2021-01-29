package com.ssafy.exception;

import java.util.List;

public interface IProductMgr {

	/*
	 * 상품을 리스트에 추가
	 * @param product : 추가할 상품
	 */
	void add(Product p) throws DuplicateException;

	/*
	 * 상품 리스트 조회
	 * @return 상품 리스트
	 */
	List<Product> getList();

	/*
	 * TV 리스트 조회
	 * @return TV 리스트
	 */
	List<TV> getTVlist();

	/*
	 * 냉장고 리스트 조회
	 * @return 냉장고 리스트
	 */
	List<Refrigerator> getRflist();

	/*
	 * 특정 상품번호로 검색
	 * @param pnum : 검색할 상품번호
	 * @return 특정 상품번호의 상품
	 */
	Product searchByNum(int pnum) throws CodeNotFoundException;

	/*
	 * 특정 상품명을 포함하는 상품 검색
	 * @param pname : 검색할 상품명
	 * @return 특정 상품명을 포함하는 상품
	 */
	List<Product> searchByName(String pname);

	/*
	 * 특정 용량 이상 냉장고 검색
	 * @param volume : 특정 용량
	 * @return 특정 용량 이상 냉장고 리스트
	 */
	List<Refrigerator> searchByVolume(int vol) throws ProductNotFoundException;

	/*
	 * 특정 인치 이상 TV 검색
	 * @param inch : 특정 인치
	 * @return 특정 인치 이하 TV 리스트
	 */
	List<TV> searchByInch(int inch) throws ProductNotFoundException;

	/*
	 * 상품을 리스트에서 삭제
	 * @param pnum : 삭제할 상품 번호
	 * @return 삭제된 상품
	 */
	Product remove(int pnum);

	/*
	 * 상품을 리스트에 추가
	 * @param pnum: 변경할 상품 번호, price : 변경할 가격
	 * @return 변경된 후 상품
	 */
	Product modify(int pnum, int price) throws CodeNotFoundException;

	/*
	 * 전체 상품의 가격 합
	 * @return 전체 상품 가격 총 합
	 */
	int getTotalPrice();

}