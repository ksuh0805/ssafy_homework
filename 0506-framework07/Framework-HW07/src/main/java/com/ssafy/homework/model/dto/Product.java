package com.ssafy.homework.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="상품정보", description = "상품코드, 이름, 가격, 설명 등을 설정합니다")
public class Product {
	@ApiModelProperty(value="상품코드")
	private String id;
	@ApiModelProperty(value="상품이름")
	private String name;
	@ApiModelProperty(value="상품가격")
	private Integer price;
	@ApiModelProperty(value="상품설명")
	private String description;
	
	public Product() {
	}
	public Product(String id, String name, Integer price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
}
