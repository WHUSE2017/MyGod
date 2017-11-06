package com.itau.mygod.user;

import cn.bmob.v3.BmobObject;    

/**  
 * Created by Administrator on 2016/9/10 0010.  
 */    
public class User extends BmobObject {
	private String name;
	private String passwd;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
	
  

      //两个参数，前者是上下文，后面是一个监听事件
   
    

