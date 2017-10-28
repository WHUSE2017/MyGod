package com.itau.mygod.product;

import java.io.File;

import android.R.integer;
import android.R.string;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;    
public class Product extends BmobObject{
	//private int PID;
	private String type;
	private String title;
	private int status;
	private String saleId;
	private String price;
	private File image;
	private String description;
	private String area;
//	public int getPid() {
//		return PID;
//	}
//	public void setPid(int PID) {
//		this.PID = PID;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
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
}
