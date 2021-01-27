package com.ssafy.poly;

public class Refrigerator extends Product{
	private int volume;

	Refrigerator(){}
	Refrigerator(int productNum, String name, int price, int count, int volume){
		super(productNum, name, price, count);
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String toString() {
		return String.format("%-5d|%-10s|%-10s|%-10s|%-7d|%-10d"
                , this.getProductNum(), this.getName(), this.getPrice(), this.getCount(), this.getPrice(), this.getVolume());
	}
	
}
