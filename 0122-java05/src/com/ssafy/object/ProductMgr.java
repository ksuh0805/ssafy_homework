package com.ssafy.object;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductMgr {
    private static ProductMgr instance;
    public static ProductMgr getInstance(){
        if(instance == null){
            instance = new ProductMgr();
        }
        return instance;
    }

    Product[] products = new Product[100];
    int pos= 0;

    public void add(Product p){
        if(pos < 100) {
            products[pos++] = p;
        }else{
            System.out.println("더 이상 등록할 수 없습니다");
        }
    }
    public Product[] list(){
        return Arrays.copyOf(products, pos);
    }
    public Product list(int num){
        for(int i = 0; i < pos; i++) {
            if (products[i].getNum() == num) {
                return products[i];
            }
        }
        System.out.println("해당 제품이 존재하지 않습니다");
        return null;
    }
    public void remove(int num){
        for (int i = 0; i < pos; ++i) {
            if (products[i].getNum() == num) {
                int moveCnt = pos - i - 1;
                if (moveCnt != 0) {
                    System.arraycopy(products, i + 1, products, i, moveCnt);
                }
                products[--pos] = null;
                System.out.println(num + " 제품이 삭제되었습니다");
                return;
            }
        }
        System.out.println("해당 제품이 존재하지 않습니다");
    }
    public Product[] priceList(int price){
        ArrayList<Product> pricelist = new ArrayList<>();
        for(int i = 0; i < pos; i++){
            if(products[i].getPrice() <= price) {
                pricelist.add(products[i]);
            }
        }
        return pricelist.toArray(new Product[pricelist.size()]);
    }
}
