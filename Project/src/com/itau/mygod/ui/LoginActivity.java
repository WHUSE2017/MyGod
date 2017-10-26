package com.itau.mygod.ui;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.User;

public class LoginActivity extends Activity implements OnClickListener {
	private EditText et_username, et_pass;
	private Button mlogin;
	private Button mRegister;
	
    private static final String Tag="LoginActivity";
    private LoginActivity loginActivity=null;
	private Intent mIntent;
	String username;
	String password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		et_username = (EditText) findViewById(R.id.loginaccount);
		et_pass = (EditText) findViewById(R.id.loginpassword);
		mlogin = (Button) findViewById(R.id.login);
		mRegister = (Button) findViewById(R.id.register);
		mlogin.setOnClickListener(this);
		mRegister.setOnClickListener(this);		
		loginActivity=LoginActivity.this;
	}	


	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.register:
		mIntent=new Intent(LoginActivity.this, RegisterNormalActivity.class);
		startActivity(mIntent);			
		break;		
	case R.id.login:		
		login(v);
		break;		
	default:
		break;
	}
		
	}
	private void login(View view) {
		 if (et_username.getText().toString().length() == 0 || et_pass.getText().toString().length() == 0) {  
			 Toast.makeText(getBaseContext(), "学号或密码不能为空！", Toast.LENGTH_LONG).show();  
	            return; 
		 }
		 else {
		BmobQuery<User> query = new BmobQuery<User>();
		query.addWhereEqualTo("name", et_username.getText().toString());
		query.addWhereEqualTo("passwd", et_pass.getText().toString());
		query.findObjects(new FindListener<User>() {
			@Override
			public void done(List<User> object, BmobException e) {
				if(object.size() != 0)
				{
					Toast.makeText(getBaseContext(), "登录成功！", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getBaseContext(), "登录失败，请检查用户名和密码!", Toast.LENGTH_SHORT).show();
							
				}		
			}			
		});
		}
	}
}
	

	