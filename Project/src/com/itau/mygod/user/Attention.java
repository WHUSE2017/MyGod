package com.itau.mygod.user;

import cn.bmob.v3.BmobObject;

public class Attention extends BmobObject{
	
	private Product pId;
	private User buyerId;
	
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
	
	
	
}
