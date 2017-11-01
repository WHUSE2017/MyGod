package com.itau.mygod.ui;

import com.itau.jingdong.R;
import com.itau.mygod.ui.base.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class UserSafetyActivity extends BaseActivity implements OnClickListener {
	private static final String Tag="UserSafetyActivity";
	private UserSafetyActivity userSafetyActivity=null;
	private Intent mIntent;
	private LinearLayout modify_passewd_bt;
	
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
		
	}
	
	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		modify_passewd_bt.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	case R.id.setting_modify_passwd:
		mIntent=new Intent(UserSafetyActivity.this, SetPasswordActivity.class);
		startActivity(mIntent);			
		break;
		}
		
	}

	

	

}
