package com.ssafy.object;

public class Product {
    private int num;
    private String name;
    private int price;
    private int count;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    Product(){}

    Product(int num, String name, int price, int count){
        this.num = num;
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public String toString(){
        return String.format("제품번호: %-10s 제품이름: %-10s 가격: %-10s 수량: %-10s"
                , this.getNum(), this.getName(), this.getPrice(), this.getCount());
    }
}
