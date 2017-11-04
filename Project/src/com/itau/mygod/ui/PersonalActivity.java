package com.itau.mygod.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.utils.CommonTools;
import com.itau.mygod.utils.ExitView;
import com.itau.mygod.widgets.CustomScrollView;


public class PersonalActivity extends BaseActivity implements OnClickListener {

	private ImageView mBackgroundImageView = null;
	private Button mLoginButton,mMoreButton,mExitButton;
	private CustomScrollView mScrollView = null;
	private Intent mIntent=null;
	private ExitView exit;
	private LinearLayout Ly_login,Ly_Other;
	private RelativeLayout Ly_personalInfo;
	private RelativeLayout personalOrder;
	private RelativeLayout userSafety;
	private TextView username;
	private int LOGIN_CODE=100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		mBackgroundImageView = (ImageView) findViewById(R.id.personal_background_image);
		mLoginButton = (Button) findViewById(R.id.personal_login_button);
		mScrollView = (CustomScrollView) findViewById(R.id.personal_scrollView);
		//mMoreButton=(Button)this.findViewById(R.id.personal_more_button);
		mExitButton=(Button)this.findViewById(R.id.personal_exit);
		
		
		Ly_login=(LinearLayout)findViewById(R.id.login);
		Ly_personalInfo=(RelativeLayout)findViewById(R.id.personal);
		Ly_Other=(LinearLayout)findViewById(R.id.other_layout);
		username=(TextView)findViewById(R.id.username);
		personalOrder=(RelativeLayout)findViewById(R.id.personal_all_order);
		userSafety=(RelativeLayout)findViewById(R.id.user_safety);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		mScrollView.setImageView(mBackgroundImageView);
		
		mLoginButton.setOnClickListener(this);
		//mMoreButton.setOnClickListener(this);
		mExitButton.setOnClickListener(this);
		personalOrder.setOnClickListener(this);
		userSafety.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		//CommonTools.showShortToast(PersonalActivity.this, "稍后开放");
		switch (v.getId()) {
		case R.id.personal_login_button:
			mIntent=new Intent(PersonalActivity.this, LoginActivity.class);
			
			startActivityForResult(mIntent, LOGIN_CODE);
			break;

		case R.id.personal_all_order:
			if(Constants.status){
				mIntent=new Intent(PersonalActivity.this, OrderActivity.class);
				startActivity(mIntent);
				}else{
					DisplayToast("您还未登录，请先登录！");
					mIntent=new Intent(PersonalActivity.this, LoginActivity.class);
					
					startActivityForResult(mIntent, LOGIN_CODE);
				}
			break;
			
		case R.id.user_safety:
			mIntent=new Intent(PersonalActivity.this, UserSafetyActivity.class);
			
			startActivityForResult(mIntent, LOGIN_CODE);
			break;
			
		case R.id.personal_exit:
			
			//实例化SelectPicPopupWindow
			exit = new ExitView(PersonalActivity.this, itemsOnClick);
			//显示窗口
			exit.showAtLocation(PersonalActivity.this.findViewById(R.id.layout_personal), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
			
			
			break;
			
		default:
			break;
		}
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		if(resultCode==20){
			String name=data.getExtras().getString("username");
			Log.i("name", name);
			username.setText(name);
			if(Ly_login.isShown()){
				Ly_personalInfo.setVisibility(View.VISIBLE);
				Ly_login.setVisibility(View.GONE);
				Ly_Other.setVisibility(View.GONE);
			}
			Ly_personalInfo.setVisibility(View.VISIBLE);
			Ly_login.setVisibility(View.GONE);
			Ly_Other.setVisibility(View.GONE);
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	//为弹出窗口实现监听类
    private OnClickListener  itemsOnClick = new OnClickListener(){

		public void onClick(View v) {
			
			switch (v.getId()) {
			case R.id.btn_exit:
				CommonTools.showShortToast(PersonalActivity.this, "退出程序");
				
				break;
			case R.id.btn_cancel:
				PersonalActivity.this.dismissDialog(R.id.btn_cancel);
				
				break;
			default:
				break;
			}
		}
    };
	
}
