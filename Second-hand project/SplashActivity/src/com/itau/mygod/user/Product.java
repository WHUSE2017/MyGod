package com.itau.mygod.user;

import java.io.File;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Product extends BmobObject{
	private BmobFile image;
	private String title;
	private String price;
	private String description;
	private String area;
	private String type;
	private int status;
	private User salerId;
	
	public BmobFile getImage() {	
    return image;
	}
	public void setImage(BmobFile image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	 public String getIconUrl() {
		 return image.getUrl(); }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getSalerId() {
		return salerId;
	}
	public void setSalerId(User salerId) {
		this.salerId = salerId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
