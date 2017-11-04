package com.itau.mygod.ui;


import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserSafetyActivity extends BaseActivity implements OnClickListener {
	private static final String Tag="UserSafetyActivity";
	private UserSafetyActivity userSafetyActivity=null;
	private Intent mIntent;
	private LinearLayout modify_passewd_bt;
	private LinearLayout modify_phone_bt;
	private LinearLayout setting_check_update_bt;
	private LinearLayout setting_cancel_bt;
	private TextView user_name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_safety);
		
		userSafetyActivity = UserSafetyActivity.this;
		findViewById();
		initView();
	}
	
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		modify_passewd_bt = (LinearLayout) findViewById(R.id.setting_modify_passwd);
		modify_phone_bt = (LinearLayout) findViewById(R.id.setting_modify_phone);
		setting_check_update_bt = (LinearLayout) findViewById(R.id.setting_check_update);
		setting_cancel_bt = (LinearLayout) findViewById(R.id.setting_cancel);
		user_name = (TextView) findViewById(R.id.user_info_name);
		user_name.setText(Constants.userobject.getName());
	}
	
	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		modify_passewd_bt.setOnClickListener(this);
		modify_phone_bt.setOnClickListener(this);
		setting_check_update_bt.setOnClickListener(this);
		setting_cancel_bt.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	case R.id.setting_modify_passwd:
		mIntent=new Intent(UserSafetyActivity.this, SetPasswordActivity.class);
		startActivity(mIntent);			
		break;
		
	case R.id.setting_modify_phone:
		mIntent=new Intent(UserSafetyActivity.this, SetPhoneActivity.class);
		startActivity(mIntent);			
		break;
		
	case R.id.setting_check_update:
		Toast.makeText(UserSafetyActivity.this,"当前已是最新版本",Toast.LENGTH_SHORT).show();
		break;
		
	case R.id.setting_cancel:
		Intent logoutIntent = new Intent();
		logoutIntent.setClass(UserSafetyActivity.this,PersonalActivity.class);
		logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
		Constants.status = false;
		Toast.makeText(UserSafetyActivity.this,"用户已注销！",Toast.LENGTH_SHORT).show();
//        startActivity(logoutIntent);
		Intent intent = new Intent();  
		intent.setAction(TAG);  
		setResult(10,intent); 
		sendBroadcast(intent);
		finish();
		}
		}
	
		
	}

	

	

