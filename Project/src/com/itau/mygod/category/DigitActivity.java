package com.itau.mygod.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.jingdong.R;
import com.itau.mygod.adapter.ProductAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;

public class DigitActivity extends Activity {
	private ListView digit_ListView;
	private ArrayList<Product> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_digit);
		initData();
		findViewById();
		initView();
	}
	protected void findViewById() {
		digit_ListView=(ListView)this.findViewById(R.id.digit_listview);
		BmobQuery<Product> query = new BmobQuery<Product>();
		query.order("type");
		final ProgressDialog mPD;
		mPD=ProgressDialog.show(DigitActivity.this, getTitle(), getResources().getString(R.string.category_loading), true, false);
		query.findObjects(new FindListener<Product>() {
			@Override
			public void done(List<Product> object, BmobException e) {
				Log.i("debug","done");
				if(object.size() != 0)
				{
					for(Product ct:object){
						if(ct.getType().equals("数码"))
						{
							data.add(ct);
						}

					}
				}	
				Log.i("debug","setAdapte");
				digit_ListView.setAdapter(new ProductAdapter(DigitActivity.this,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
				mPD.dismiss();
				digit_ListView.setOnItemClickListener(new OnItemClickListener() {	
					@Override
					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
							long id) {
						Toast.makeText(DigitActivity.this, "你点击了第"+id+"项", 1).show();
						
					}
				});
			}			
		});
	}
	

	protected void initView() {
		// TODO Auto-generated method stub

	}
	
	private void initData(){
		data = new ArrayList<Product>();
	}
	
}
