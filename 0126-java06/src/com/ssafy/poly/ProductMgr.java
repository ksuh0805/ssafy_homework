package com.ssafy.poly;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductMgr {
	private static ProductMgr instance;
	public static  ProductMgr getInstance() {
		if(instance == null) {
			instance = new ProductMgr();
		}
		return instance;
	}
	private ProductMgr(){}
	
	Product[] products = new Product[100]; 
	int size = 0;
	
	public void add(Product p) {
		products[size++] = p;
	}
	
	public Product[] getList() {
		return Arrays.copyOf(products, size);
	}
	public TV[] getTVlist() {
		ArrayList<TV> tvs = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			if(products[i] instanceof TV) {
				tvs.add((TV)products[i]);
			}
		}
		return tvs.toArray(new TV[tvs.size()]);
	}
	public Refrigerator[] getRflist() {
		ArrayList<Refrigerator> rfs = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			if(products[i] instanceof Refrigerator) {
				rfs.add((Refrigerator)products[i]);
			}
		}
		return rfs.toArray(new Refrigerator[rfs.size()]);
	}
	public Product searchByNum(int pnum) {
		for(int i = 0; i < size; i++) {
			if(products[i].getProductNum() == pnum)
				return products[i];
		}
		return null;
	}
	public Product[] searchByName(String pname) {
		ArrayList<Product> targets = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			if(products[i].getName().contains(pname))
				targets.add(products[i]);
		}
		return targets.toArray(new Product[targets.size()]);
	}
	public Product remove(int pnum) {
		Product target = null;
		for(int i = 0; i < size; i++) {
			if(products[i].getProductNum() == pnum) {
				target = products[i];
				int moveCnt = size - i - 1;
				if(moveCnt > 0) {
					System.arraycopy(products, i + 1, products, i, moveCnt);
					products[--size] = null;
				}
			}
		}
		return target;
	}
	public int getTotalPrice() {
		int total = 0;
		for(int i = 0; i < size; i++) {
			total += products[i].getPrice();
		}
		return total;
	}
}
