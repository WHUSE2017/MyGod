package com.itau.mygod.user;

import cn.bmob.v3.BmobObject;

public class Order extends BmobObject{
	
	private Product pId;
	private User buyerId;
	private Integer status;
	private String title;
	private String description;
	private String price;
	private String area;
	private String phone;
	
	public void setPId(Product pId){
		this.pId=pId;
	}
	public Product getPId(){
		return pId;
	}

	public void setBuyerId(User buyerId){
		this.buyerId=buyerId;
	}
	public User getBuyerId(){
		return buyerId;
	}
	
	public void setStatus(Integer status){
		this.status=status;
	}
	public Integer getStatus(){
		return status;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return description;
	}
	
	public void setPrice(String price){
		this.price=price;
	}
	public String getPrice(){
		return price;
	}
	
	public void setArea(String area){
		this.area=area;
	}
	public String getArea(){
		return area;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	
	
}
