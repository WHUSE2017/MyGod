package com.itau.mygod.ui.base;


import com.itau.mygod.config.Constants;
import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.Toast;

public abstract class NewBaseActivity extends Activity{
	protected int mScreenWidth;
	protected int mScreenHeight;
	public static final String TAG = "BaseActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//获取当前屏幕高度
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mScreenHeight = metric.heightPixels;
		mScreenWidth = metric.widthPixels;
		setContentView();
		initViews();
		initData();
		initListeners();
	}

	public abstract void initData();

	public abstract void initListeners() ;

	public abstract void initViews();

	public abstract void setContentView() ;
	
	Toast mToast;

	public void ShowToast(String text) {
		if (!TextUtils.isEmpty(text)) {
			if (mToast == null) {
				mToast = Toast.makeText(getApplicationContext(), text,
						Toast.LENGTH_SHORT);
			} else {
				mToast.setText(text);
			}
			mToast.show();
		}
	}
	
	

	/**
	 * 获取当前状态栏的高度
	 * @return
	 */
	public int getStateBar(){
		Rect frame = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;
		return statusBarHeight;
	}
	public static int dip2px(Context context,float dipValue){
		float scale=context.getResources().getDisplayMetrics().density;		
		return (int) (scale*dipValue+0.5f);		
	}

}