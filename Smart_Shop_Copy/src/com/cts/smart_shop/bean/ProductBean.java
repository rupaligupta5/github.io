package com.cts.smart_shop.bean;

import java.io.InputStream;

public class ProductBean {
	private String product_Name;
	private InputStream product_Image;
	public InputStream getProduct_Image() {
		return product_Image;
	}
	public void setProduct_Image(InputStream product_Image) {
		this.product_Image = product_Image;
	}
	private String item;
	private String dom;
	private String doe;
	private String location;
	private Float rating;
	private int product_price;
	
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public ProductBean() {
		super();
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDom() {
		return dom;
	}
	public void setDom(String dom) {
		this.dom = dom;
	}
	public String getDoe() {
		return doe;
	}
	public void setDoe(String doe) {
		this.doe = doe;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "ProductBean [product_Name=" + product_Name + ", product_Image=" + product_Image + ", item=" + item
				+ ", dom=" + dom + ", doe=" + doe + ",location=" + location + ", product_price=" + product_price + ", rating=" + rating + "]";
	}
	}