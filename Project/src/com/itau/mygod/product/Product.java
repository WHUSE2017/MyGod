package com.itau.mygod.product;

import java.io.File;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Product extends BmobObject{
	private BmobFile image;
	private String title;
	private String price;
	
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

}
