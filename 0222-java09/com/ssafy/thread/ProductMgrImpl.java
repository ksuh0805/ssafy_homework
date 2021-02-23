package com.ssafy.thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	public void add(Product p) {
		for(int i = 0; i < products.size(); i++) {
			if((p.getName().equals(products.get(i).getName()))) return;
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
	public Product searchByNum(int pnum) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductNum() == pnum)
				return products.get(i);
		}
		return null;
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
	public List<Refrigerator> searchByVolume(int vol) {
		ArrayList<Refrigerator> targets = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				Refrigerator r = (Refrigerator)products.get(i);
				if(r.getVolume() >= vol) targets.add(r);
			}
		}
		return targets;
	}
	/*
	 * 특정 인치 이상 TV 검색
	 * @param inch : 특정 인치
	 * @return 특정 인치 이하 TV 리스트
	 */
	@Override
	public List<TV> searchByInch(int inch){
		ArrayList<TV> targets = new ArrayList<>();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i) instanceof TV) {
				TV t = (TV)products.get(i);
				if(t.getInch() >=  inch) targets.add(t);
			}
		}
		return targets;
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
	public Product modify(int pnum, int price) {
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
	@Override
	public void save() {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("product.dat"))){
			oos.writeObject(products);
			oos.flush();
			System.out.println("저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("저장 실패");
		}
		products=null;
	}
	@Override
	public void load() {
		File f=new File("product.dat");
		if(f.exists()) {
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))){
				products = (ArrayList<Product>)ois.readObject();
				System.out.println("로드 완료");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				System.err.println("로드 실패");
			}
		}
	}
}
