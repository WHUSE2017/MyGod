package com.itau.mygod.user;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

public class Category extends BmobObject{
	private int Ctype;
	private String Cname;
	private BmobFile image;
	private String description;
	public int getCtype() {
		return Ctype;
	}
	public void setCtype(int ctype) {
		Ctype = ctype;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public BmobFile getImage() {
		return image;
	}
	public void setImage(BmobFile image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
