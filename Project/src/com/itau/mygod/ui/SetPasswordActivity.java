package com.itau.mygod.ui;

import java.util.List;

import com.itau.mygod.user.User;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.SetPasswordActivity;
import com.itau.jingdong.R;
import com.itau.mygod.ui.base.BaseActivity;

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


public class SetPasswordActivity extends BaseActivity implements OnClickListener{
	private static final String Tag="SetPasswordActivity";
	private SetPasswordActivity setPasswordActivity=null;
	private EditText old_passwd_ed;
	private EditText new_passwd_ed;
	private EditText new_passwd_cer_ed;
	private Button modify;
	private Button cancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_password);
		setPasswordActivity=SetPasswordActivity.this;
		findViewById();
		initView();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.resetpwd_btn_sure:
		final String new_passwd = new_passwd_ed.getText().toString();
		final String old_passwd = old_passwd_ed.getText().toString();
		String new_passwd_cer = new_passwd_cer_ed.getText().toString();
		
		if(!new_passwd.equals(new_passwd_cer))
		{
			//如果输入的两次新密码不一致
			Toast.makeText(SetPasswordActivity.this,"两次输入的新密码不一致",Toast.LENGTH_SHORT).show();
			
		}
		else
		{
			BmobQuery<User> query = new BmobQuery<User>();
			query.setLimit(15);
			query.findObjects(new FindListener<User>() {
				@Override
				public void done(List<User> object, BmobException e) {
					String old_passwd_database = "  ";
					String id = null;
					// TODO Auto-generated method stub
					if(e == null)
					{
						for(User user:object)
						{
							if(user.getName().equals(Constants.userobject.getName()))
							{
								old_passwd_database = user.getPasswd();
								id = user.getObjectId();
								break;
							}
								
						}
						if(old_passwd_database.equals(old_passwd))
						{
							User update = new User();
							update.setPasswd(new_passwd);
							update.update(id,new UpdateListener() {
								
								@Override
								public void done(BmobException e) {
									// TODO Auto-generated method stub
									if(e == null)
									{
										Toast.makeText(SetPasswordActivity.this,"修改密码成功",Toast.LENGTH_SHORT).show();
										Intent intent = new Intent();   
										intent.putExtra("new_passwd", Constants.userobject.getPasswd()); //向父Activity发送数据  
										setResult(20,intent);        
										finish(); 
									}
								}
							});
						}
						else
						{
							Toast.makeText(SetPasswordActivity.this,"请输入正确的旧密码",Toast.LENGTH_SHORT).show();
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
	
		case R.id.resetpwd_btn_cancel:
			Intent intent = new Intent();
			setResult(20,intent);        
			finish();
			
		
	
		}	
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		old_passwd_ed = (EditText) findViewById(R.id.resetpwd_edit_pwd_old);
		new_passwd_ed = (EditText) findViewById(R.id.resetpwd_edit_pwd_new);
		new_passwd_cer_ed = (EditText) findViewById(R.id.resetpwd_edit_pwd_check);
		modify = (Button) findViewById(R.id.resetpwd_btn_sure);
		cancel = (Button) findViewById(R.id.resetpwd_btn_cancel);
		
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		old_passwd_ed.setOnClickListener(this);
		new_passwd_ed.setOnClickListener(this);
		new_passwd_cer_ed.setOnClickListener(this);
		modify.setOnClickListener(this);
		cancel.setOnClickListener(this);
		
	}

}
