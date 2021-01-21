package com.ssafy.clazz;

public class Refrigerator {
    private int productNum;
    private String name;
    private int price;
    private int count;
    private int volume;

    public Refrigerator() {

    }
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getProductNum() {
        return productNum;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int getVolume() {
        return volume;
    }

    public String info() {
        String info = "\n제품번호: " + this.getProductNum()
                + "\n제품이름: " + this.getName()
                + "\n가격: " + this.getPrice()
                + "\n수량: " + this.getCount()
                + "\n용량: " + this.getVolume();
        return info;
    }
}
