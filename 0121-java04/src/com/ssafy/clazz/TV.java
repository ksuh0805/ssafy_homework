package com.ssafy.clazz;

public class TV {

    private int productNum;



    private String name;
    private int price;
    private int count;
    private int inch;
    private String displayType;

    public TV(){

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

    public void setInch(int inch) {
        this.inch = inch;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
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

    public int getInch() {
        return inch;
    }

    public String getDisplayType() {
        return displayType;
    }

    public String info() {
        String info = "\n제품번호: " + this.getProductNum()
                    + "\n제품이름: " + this.getName()
                    + "\n가격: " + this.getPrice()
                    + "\n수량: " + this.getCount()
                    + "\n인치: " + this.getInch()
                    + "\n디스플레이타입: " + this.getDisplayType();
        return info;
    }
}
