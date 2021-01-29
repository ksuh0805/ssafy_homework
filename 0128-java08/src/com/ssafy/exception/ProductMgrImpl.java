package com.ssafy.exception;

import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private static IProductMgr instance;
	public static  IProductMgr getInstance() {
		if(instance == null) {
			instance = new ProductMgrImpl();
		}
		return instance;
	}
	private ProductMgrImpl(){}
	
	/*
	 * 상품 관리 리스트
	 */
	ArrayList<Product> products = new ArrayList<>();
	
	/*
	 * 상품을 리스트에 추가
	 * @param product : 추가할 상품
	 */
	@Override
	public void add(Product p) throws DuplicateException {
		for(Product product : products) {
			if(p.getProductNum() == product.getProductNum()) {
				throw new DuplicateException();
			}
		}
		products.add(p);
	}
	/*
	 * 상품 리스트 조회
	 * @return 상품 리스트
	 */
	@Override
	public List<Product> getList() {
		return products;
	}
	/*
	 * TV 리스트 조회
	 * @return TV 리스트
	 */
	@Override
	public List<TV> getTVlist() {
		ArrayList<TV> tvs = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				tvs.add((TV)products.get(i));
			}
		}
		return tvs;
	}
	/*
	 * 냉장고 리스트 조회
	 * @return 냉장고 리스트
	 */
	@Override
	public List<Refrigerator> getRflist() {
		ArrayList<Refrigerator> rfs = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				rfs.add((Refrigerator)products.get(i));
			}
		}
		return rfs;
	}
	/*
	 * 특정 상품번호로 검색
	 * @param pnum : 검색할 상품번호
	 * @return 특정 상품번호의 상품
	 */
	@Override
	public Product searchByNum(int pnum) throws CodeNotFoundException{
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductNum() == pnum)
				return products.get(i);
		}
		throw new CodeNotFoundException();
	}
	/*
	 * 특정 상품명을 포함하는 상품 검색
	 * @param pname : 검색할 상품명
	 * @return 특정 상품명을 포함하는 상품
	 */
	@Override
	public List<Product> searchByName(String pname) {
		ArrayList<Product> targets = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getName().contains(pname))
				targets.add(products.get(i));
		}
		return targets;
	}
	/*
	 * 특정 용량 이상 냉장고 검색
	 * @param volume : 특정 용량
	 * @return 특정 용량 이상 냉장고 리스트
	 */
	@Override
	public List<Refrigerator> searchByVolume(int vol) throws ProductNotFoundException{
		ArrayList<Refrigerator> targets = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator)products.get(i);
				if(r.getVolume() >= vol) targets.add(r);
			}
		}
		if(targets.size() != 0) {
			return targets;			
		}else {
			throw new ProductNotFoundException();
		}
	}
	/*
	 * 특정 인치 이상 TV 검색
	 * @param inch : 특정 인치
	 * @return 특정 인치 이하 TV 리스트
	 */
	@Override
	public List<TV> searchByInch(int inch) throws ProductNotFoundException{
		ArrayList<TV> targets = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				TV t = (TV)products.get(i);
				if(t.getInch() >=  inch) targets.add(t);
			}
		}
		if(targets.size() != 0) {
			return targets;			
		}else {
			throw new ProductNotFoundException();
		}
	}
	/*
	 * 상품을 리스트에서 삭제
	 * @param pnum : 삭제할 상품 번호
	 * @return 삭제된 상품
	 */
	@Override
	public Product remove(int pnum) {
		Product target = null;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductNum() == pnum) {
				target = products.get(i);
				products.remove(i);
			}
		}
		return target;
	}
	/*
	 * 상품을 리스트에 추가
	 * @param pnum: 변경할 상품 번호, price : 변경할 가격
	 * @return 변경된 후 상품
	 */
	@Override
	public Product modify(int pnum, int price) throws CodeNotFoundException {
		Product p = searchByNum(pnum);
		products.get(products.indexOf(p)).setPrice(price);
		return p;
	}
	/*
	 * 전체 상품의 가격 합
	 * @return 전체 상품 가격 총 합
	 */
	@Override
	public int getTotalPrice() {
		int total = 0;
		for(int i = 0; i < products.size(); i++) {
			total += products.get(i).getPrice();
		}
		return total;
	}
}
