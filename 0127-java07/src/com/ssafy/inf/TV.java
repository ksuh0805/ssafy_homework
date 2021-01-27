package com.ssafy.inf;

public class TV extends Product{
	private int inch;
    private String displayType;
    
	TV(int num, String name, int price, int count, int inch, String displayType){
		super(num, name, price, count);
		this.inch = inch;
		this.displayType = displayType;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public String toString() {
		return String.format("%-5d|%-10s|%-10s|%-10s|%-7d|%-10d|%-5s"
                , this.getProductNum(), this.getName(), this.getPrice(), this.getCount(), this.getPrice(), this.getInch(), this.getDisplayType());
	}
}
