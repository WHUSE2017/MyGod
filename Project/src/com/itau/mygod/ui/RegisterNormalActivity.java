package com.itau.mygod.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import java.util.List;

import com.itau.jingdong.R;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.User;

public class RegisterNormalActivity extends Activity implements OnClickListener {
	private EditText et_name, et_pass1,et_pass2;
	private Button mRegister;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.activity_register_normal);
	
	et_name = (EditText) findViewById(R.id.id_username);
	et_pass1 = (EditText) findViewById(R.id.id_password1);
	et_pass2 = (EditText) findViewById(R.id.id_password2);
	mRegister = (Button) findViewById(R.id.normalregister);
	
	mRegister.setOnClickListener(this);
	
}

public void register(View view) {
	//两次输入的密码不一致
			if(!et_pass1.getText().toString().equals(et_pass2.getText().toString()))
			{
				Toast.makeText(getBaseContext(), "密码不一致  请正确密码", Toast.LENGTH_LONG).show();
			}
			//验证码为空
			else if(et_name.getText().toString().length() == 0)
			{
				Toast.makeText(getBaseContext(), "用户名不能为空", Toast.LENGTH_LONG).show();
			}
			else
			{
				final User user = new User();
				user.setName(et_name.getText().toString());
				user.setPasswd(et_pass1.getText().toString());
				BmobQuery<User> query = new BmobQuery<User>();
				query.addWhereEqualTo("name", et_name.getText().toString());
				query.findObjects(new FindListener<User>() {
					
					@Override
					public void done(List<User> object, BmobException e) {
						if(object.size() != 0)
						{
							Toast.makeText(getBaseContext(), "该用户已存在！", Toast.LENGTH_LONG).show();
						}
						else
						{
							user.save(new SaveListener<String>() {
								
								@Override
								public void done(String objectId, BmobException e) {
									if(e == null)
									{
										Toast.makeText(getBaseContext(), "注册成功!", Toast.LENGTH_SHORT).show();
										RegisterNormalActivity.this.finish();
									}
									else
									{
										Toast.makeText(getBaseContext(), "注册失败!", Toast.LENGTH_LONG).show();
									}
								}
							});
						}
						
						
					}
				});
			}
	
	
}

public void onClick(View v) {
	register(v);
	
	
}
	
}
