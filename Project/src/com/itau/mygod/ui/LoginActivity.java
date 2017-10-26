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
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

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
<<<<<<< HEAD
	private String serverAddress="http://mdemo.e-cology.cn/login.do";
	public static String MOBILE_SERVERS_URL="http://mserver.e-cology.cn/servers.do";
=======
	String username;
	String password;
>>>>>>> 5b48a5617474366448eac929d9c6611ac32e2c12
	
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
<<<<<<< HEAD
		break;

		
	case R.id.login:
		
		doLogin();
//		userlogin();
		
		break;
		
=======
		break;		
	case R.id.login:		
		login(v);
		break;		
>>>>>>> 5b48a5617474366448eac929d9c6611ac32e2c12
	default:
		break;
	}
		
	}
<<<<<<< HEAD
	
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
		
		final String username=loginaccount.getText().toString().trim();
		final String password=loginpassword.getText().toString().trim();
		String serverAdd = serverAddress;
		
		if(username.equals("")){
			DisplayToast("用户名不能为空!");
		}
		if(password.equals("")){
			DisplayToast("密码不能为空!");
		}
		Log.i("debug","运行外层了！");
		loginActivity.doAsync(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				Log.i("debug","运行里层了！");
//				String clientVersion = getVersionName();
//				String deviceid = getDeviceId();
//				String token = getToken();
//				String clientOs = getClientOs();
//				String clientOsVer = getClientOsVer();
//				String language = getLanguage();
//				String country = getCountry();
//				
//				Constants.clientVersion = clientVersion;
//				Constants.deviceid = deviceid;
//				Constants.token = token;
//				Constants.clientOs = clientOs;
//				Constants.clientOsVer = clientOsVer;
//				Constants.language = language;
//				Constants.country = country;
//				Constants.user = username;
//				Constants.pass = password;

				BmobQuery<User> query = new BmobQuery<User>();
				query.addWhereEqualTo("name", username);
				query.addWhereEqualTo("passwd", password);
				query.findObjects(new FindListener<User>() {
					@Override
					public void done(List<User> object, BmobException e) {
						Log.i("debug","done");
						if(object.size() != 0)
						{
							Toast.makeText(getBaseContext(), "用户登陆成功！", Toast.LENGTH_LONG).show();
							Intent intent = new Intent();   
							intent.putExtra("login", ""); //向父Activity发送数据  
							setResult(20,intent);        
							finish();
						}
						else
						{
							Toast.makeText(getBaseContext(), "用户名错误或密码错误!", Toast.LENGTH_SHORT).show();
									
						}		
					}			
				});
				return true;
			}
			
		}, new Callback<Boolean>() {

			@Override
			public void onCallback(Boolean pCallbackValue) {
				// TODO Auto-generated method stub
				
			}
		}, new Callback<Exception>() {

			@Override
			public void onCallback(Exception pCallbackValue) {
				// TODO Auto-generated method stub
				
			}
		}, true, getResources().getString(R.string.login_loading));
		
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
	
=======
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
>>>>>>> 5b48a5617474366448eac929d9c6611ac32e2c12
}
	

	