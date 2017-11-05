package com.itau.mygod.ui;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.ProductDetailActivity.GameThread;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.User;

public class LoginActivity extends BaseActivity implements OnClickListener {
	
private static final String Tag="LoginActivity";
public static final int LOGIN_REFRESH = 1;
private LoginActivity loginActivity=null;
	private ImageView loginLogo,login_more;
	private EditText loginaccount,loginpassword;
	private ToggleButton isShowPassword;
	private boolean isDisplayflag=false;//是否显示密码
	private String getpassword;
	private Button loginBtn,register;
	private Intent mIntent;
	private String serverAddress="http://mdemo.e-cology.cn/login.do";
	public static String MOBILE_SERVERS_URL="http://mserver.e-cology.cn/servers.do";
	private Handler myHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		loginActivity=LoginActivity.this;
		findViewById();
		initView();
		myHandler = new Handler()

	       {

	              //接收到消息后处理

	              public void handleMessage(Message msg)

	              {

	                     switch (msg.what)

	                     {

	                     case ProductDetailActivity.REFRESH:

	                                    //刷新界面

	                            break;

	                     }

	                     super.handleMessage(msg);

	              }                  

	       };
	}
	
	@Override
	protected void findViewById() {
		loginLogo=(ImageView)this.findViewById(R.id.logo);
		login_more=(ImageView)this.findViewById(R.id.login_more);
		loginaccount=(EditText)this.findViewById(R.id.loginaccount);
		loginpassword=(EditText)this.findViewById(R.id.loginpassword);
		
		isShowPassword=(ToggleButton)this.findViewById(R.id.isShowPassword);
		loginBtn=(Button)this.findViewById(R.id.login);
		register=(Button)this.findViewById(R.id.register);
		
		getpassword=loginpassword.getText().toString();
	}

	
	
	
	@Override
	protected void initView() {
		
		//显示密码的togglebutton点击事件,动态显示隐藏密码--->点击前先判定
//		isShowPassword.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				
//				if(getpassword.equals("")||getpassword.length()<=0){
//					DisPlay("密码不能为空");
//				}
//				
//				if(!isDisplayflag){
//					//隐藏密码
//					//loginpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); 
//					//loginpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD); 
//					loginpassword.setInputType(0x90); 
//					
//				}else{
//					//loginpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); 
//					//loginpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());  
//					loginpassword.setInputType(0x81);
//				}
//				//isDisplayflag=!isDisplayflag;
//				loginpassword.postInvalidate();
//			}
//		});
		
		
		register.setOnClickListener(this);
		
		isShowPassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				Log.i(Tag, "开关按钮状态="+isChecked);
				
//				if(getpassword.equals("")||getpassword.length()<=0){
//					DisPlay("密码不能为空");
//				}
				
			
				if(isChecked){
					//隐藏
					loginpassword.setInputType(0x90);    
					//loginpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				}else{
					//明文显示	
					loginpassword.setInputType(0x81); 
					//loginpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
				}
				Log.i("togglebutton", ""+isChecked);
				//loginpassword.postInvalidate();
			}
		});
	
		
		loginBtn.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
	switch (v.getId()) {
	case R.id.register:
		mIntent=new Intent(LoginActivity.this, RegisterNormalActivity.class);
		startActivity(mIntent);			
		break;

		
	case R.id.login:
		
		doLogin();
//		userlogin();
		
		break;
		
	default:
		break;
	}
		
	}
	
	//之前的方式太繁瑣了
//	private void userlogin() 
//	{
//		ConnectivityManager con = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
//		boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
//		boolean mobile = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
//		if(!(wifi||mobile))
//		{
//			Toast.makeText(this, "当前未连接网络！", Toast.LENGTH_SHORT).show();
//		}
//		else
//		{
//				 username=loginaccount.getText().toString().trim();
//			 password=loginpassword.getText().toString().trim();
//			String serverAdd = serverAddress;
//			
//			if(username.equals("")){
//				DisplayToast("用户名不能为空!");
//			}
//			if(password.equals("")){
//				DisplayToast("密码不能为空!");
//			}
//			
//			if(username.equals("test")&&password.equals("123")){
//				DisplayToast("登陆成功!");
//				Intent data=new Intent();  
//	            data.putExtra("name", username);  
//	//            data.putExtra("values", 100);  
//	            //请求代码可以自己设置，这里设置成20  
//	            setResult(20, data); 
//				
	
//				LoginActivity.this.finish();
//			}
//		
//		}
//		
////		new LoginTask().execute(username, password);
//		
//	}

	//登录系统
	private void doLogin(){
		ConnectivityManager con = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
		boolean wifi = con.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		boolean mobile = con.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();
		if(!(wifi||mobile))
		{
			Toast.makeText(this, "当前未连接网络！", Toast.LENGTH_SHORT).show();
		}
		else
		{
		final String username=loginaccount.getText().toString().trim();
		final String password=loginpassword.getText().toString().trim();
		String serverAdd = serverAddress;
		
		if(username.equals("")){
			DisplayToast("用户名不能为空!");
			return;
		}
		if(password.equals("")){
			DisplayToast("密码不能为空!");
			return;
		}
		Log.i("debug","运行外层了！");
		loginActivity.doAsync(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				Log.i("debug","运行里层了！");
				String clientVersion = getVersionName();
				String deviceid = getDeviceId();
				String token = getToken();
				String clientOs = getClientOs();
				String clientOsVer = getClientOsVer();
				String language = getLanguage();
				String country = getCountry();
				
				Constants.clientVersion = clientVersion;
				Constants.deviceid = deviceid;
				Constants.token = token;
				Constants.clientOs = clientOs;
				Constants.clientOsVer = clientOsVer;
				Constants.language = language;
				Constants.country = country;
				Constants.user = username;
				Constants.pass = password;

				return true;
			}
			
		}, new Callback<Boolean>() {

			@Override
			public void onCallback(Boolean pCallbackValue) {
				// TODO Auto-generated method stub
				BmobQuery<User> query = new BmobQuery<User>();
				query.addWhereEqualTo("name", username);
				query.addWhereEqualTo("passwd", password);
				query.findObjects(new FindListener<User>() {
					@Override
					public void done(List<User> object, BmobException e) {
						Log.i("debug","done");
						if(object.size() != 0)
						{
							Constants.status = true;
							Constants.userobject = object.get(0);
							Toast.makeText(getBaseContext(), "用户登陆成功！", Toast.LENGTH_LONG).show();
							Intent intent = new Intent();  
							intent.setAction(TAG);  
							setResult(20,intent); 
							sendBroadcast(intent);
							finish();
						}
						else
						{
							Toast.makeText(getBaseContext(), "用户名错误或密码错误!", Toast.LENGTH_SHORT).show();
									
						}		
					}			
				});
			}
		}, new Callback<Exception>() {

			@Override
			public void onCallback(Exception pCallbackValue) {
				// TODO Auto-generated method stub
				Log.i("debug",pCallbackValue.getMessage());
			}
		}, true, getResources().getString(R.string.login_loading));
	}	
	}
	class GameThread implements Runnable

    {

           public void run()

           {

                  while (!Thread.currentThread().isInterrupted())

                  {

                         Message message = new Message();

                         message.what = LOGIN_REFRESH;

                         //发送消息

                         myHandler.sendMessage(message);

                         try

                         {

                                Thread.sleep(100);

                         }

                         catch (InterruptedException e)

                         {

                                Thread.currentThread().interrupt();

                         }

                  }

           }

    }

//	class LoginTask extends AsyncTask<String, Void, JSONObject>{
//
//
//		@Override
//		protected JSONObject doInBackground(String... params) {
//			HashMap<String, String> map=new HashMap<String, String>();
//			
//			map.put("name", username);
//			map.put("pass", password);
//			map.put("server", serverAddress);
//			
//			
//			try {
//				return new JSONObject(new String("{a:1,b:2}"));
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return null;
//		}
//	}
	
}
