package com.itau.mygod.ui;

import java.util.List;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class SetPhoneActivity extends BaseActivity implements OnClickListener{
	private static final String Tag="SetPhoneActivity";
	private SetPhoneActivity setPhoneActivity=null;
	private EditText user_pwd_ed;
	private EditText new_phone_ed;
	private EditText new_phone_cer_ed;
	private Button modify;
	private Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_phone);
		setPhoneActivity=SetPhoneActivity.this;
		findViewById();
		initView();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId()) {
		case R.id.resetphone_btn_sure:
		final String new_phone = new_phone_ed.getText().toString();
		final String user_pwd = user_pwd_ed.getText().toString();
		String new_phone_cer = new_phone_cer_ed.getText().toString();
		
		if(!new_phone.equals(new_phone_cer))
		{
			//如果输入的两次新密码不一致
			Toast.makeText(SetPhoneActivity.this,"两次输入的新密码不一致",Toast.LENGTH_SHORT).show();
			
		}
		else
		{
			BmobQuery<User> query = new BmobQuery<User>();
			query.setLimit(15);
			query.findObjects(new FindListener<User>() {
				@Override
				public void done(List<User> object, BmobException e) {
					String user_passwd_database = "  ";
					String id = null;
					// TODO Auto-generated method stub
					if(e == null)
					{
						for(User user:object)
						{
							if(user.getName().equals(Constants.userobject.getName()))
							{
								user_passwd_database = user.getPasswd();
								id = user.getObjectId();
								break;
							}
								
						}
						if(user_passwd_database.equals(user_pwd))
						{
							User update = new User();
							update.setPhone(new_phone);
							update.update(id,new UpdateListener() {
								
								@Override
								public void done(BmobException e) {
									// TODO Auto-generated method stub
									if(e == null)
									{
										Toast.makeText(SetPhoneActivity.this,"修改手机号成功",Toast.LENGTH_SHORT).show();
										Intent intent = new Intent();   
										intent.putExtra("new_phone", Constants.userobject.getPhone()); //向父Activity发送数据  
										setResult(20,intent);        
										finish(); 
									}
								}
							});
						}
						else
						{
							Toast.makeText(SetPhoneActivity.this,"密码不正确",Toast.LENGTH_SHORT).show();
						}
						
					}
					else
					{
						Toast.makeText(getBaseContext(), "查找用户信息失败",Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
		break;
	
		case R.id.resetphone_btn_cancel:
			Intent intent = new Intent();
			setResult(20,intent);        
			finish();
			
		
	
		}	
	
		
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		user_pwd_ed = (EditText) findViewById(R.id.user_pwd);
		new_phone_ed = (EditText) findViewById(R.id.reset_phone);
		new_phone_cer_ed = (EditText) findViewById(R.id.reset_phone_check);
		modify = (Button) findViewById(R.id.resetphone_btn_sure);
		cancel = (Button) findViewById(R.id.resetphone_btn_cancel);
		
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		user_pwd_ed.setOnClickListener(this);
		new_phone_ed.setOnClickListener(this);
		new_phone_cer_ed.setOnClickListener(this);
		modify.setOnClickListener(this);
		cancel.setOnClickListener(this);
		
	}

}
