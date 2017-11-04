package com.itau.mygod.user;

import cn.bmob.v3.BmobObject;

public class Message extends BmobObject{
	private String message_id;
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String time;
	private String content;
	

}
