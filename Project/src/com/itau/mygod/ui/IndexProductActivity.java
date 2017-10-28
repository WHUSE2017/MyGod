package com.itau.mygod.ui;

<<<<<<< HEAD

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

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
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
>>>>>>> 3ca326f991f769ed80235abb57e9811674989036
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.jingdong.R;
<<<<<<< HEAD
import com.itau.mygod.adapter.ProductAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;


public class IndexProductActivity extends BaseActivity {

	private ListView product_listview;
	private ArrayList<Product> data;
//	private LayoutInflater layoutInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index_product);
		initData();
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		product_listview=(ListView)this.findViewById(R.id.listView1);
		BmobQuery<Product> query = new BmobQuery<Product>();
		query.order("Ctype");
		final ProgressDialog mPD;
		mPD=ProgressDialog.show(IndexProductActivity.this, getTitle(), getResources().getString(R.string.category_loading), true, false);
		query.findObjects(new FindListener<Product>() {
			@Override
			public void done(List<Product> object, BmobException e) {
				Log.i("debug","done");
				if(object.size() != 0)
				{
					for(Product ct:object){
						data.add(ct);
					}
				}	
				Log.i("debug","setAdapte");
				product_listview.setAdapter(new ProductAdapter(IndexProductActivity.this,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
				mPD.dismiss();
				product_listview.setOnItemClickListener(new OnItemClickListener() {	
					@Override
					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
							long id) {
						Toast.makeText(IndexProductActivity.this, "你点击了第"+id+"项", 1).show();
						
					}
				});
			}			
		});
	}
	

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}
	
	private void initData(){
		data = new ArrayList<Product>();
	}
	
	
	

=======
import com.itau.mygod.product.Product;
import com.itau.mygod.user.User;
import com.itau.mygod.utils.ShakeListenerUtils;
import com.itau.mygod.utils.ShakeListenerUtils.OnShakeListener;

public class IndexProductActivity extends Activity {
	
	private SimpleAdapter adapter;
	private List<Map<String,Object>> datalist;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_product);
		datalist = new ArrayList<Map<String,Object>>();
		listView = (ListView) findViewById(R.id.listView1);
		
		int [] to = {R.id.product_image,R.id.productitem_title,R.id.productitem_price};
		String from[] = {"image","title","price"};	
		
		adapter = new SimpleAdapter(this, getProIn(),R.layout.activity_product_item, from, to);		
		listView.setAdapter(adapter);
		
		
	}

	
	public List<Map<String,Object>> getProIn()
	{
		BmobQuery<Product> query = new BmobQuery<Product>();
		query.addWhereEqualTo("status", 1);
		query.setLimit(50);
		query.findObjects(new FindListener<Product>() 
		{
			
			@Override
			public void done(List<Product> object, BmobException e)
			{
				for (Product product : object)
				{
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("image", product.getImage());
					map.put("title", product.getTitle());
					map.put("price", product.getPrice());
					datalist.add(map);		               
		         }
				adapter.notifyDataSetChanged();				
			}
	
		});		
		
		return datalist;
	}

		
>>>>>>> 3ca326f991f769ed80235abb57e9811674989036
}
