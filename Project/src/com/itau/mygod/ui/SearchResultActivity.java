package com.itau.mygod.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.ProgressDialog;
import android.app.Activity;
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

public class SearchResultActivity extends Activity{
	
	private ListView product_listview;
	private ArrayList<Product> data;
	private Intent mIntent;
	private String productTitle;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_result);
		initData();
		
		Bundle bundle=getIntent().getExtras();
		productTitle=bundle.getString("productTitle");
		findViewById();
		
		
		initView();
	}
	
	protected void findViewById() {
		// TODO Auto-generated method stub
		product_listview=(ListView)this.findViewById(R.id.search_listview);
//		product_listview.setAdapter(new ProductAdapter(SearchResultActivity.this,R.layout.activity_product_item,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
		
		BmobQuery<Product> query = new BmobQuery<Product>();
		query.order("updatedAt");
		query.setLimit(20);
//		query.addWhereContains("title", productTitle);  //模糊查询title中包含关键字的商品
 		query.findObjects(new FindListener<Product>() 
 		{
 			
 			@Override
 			public void done(List<Product> object, BmobException e)
 			{
 				Log.i("debug",""+object.size());
 				if(object.size() != 0)
				{
					for(Product ct:object){
						if(ct.getTitle().contains(productTitle)||ct.getDescription().contains(productTitle))
						data.add(ct);
					}
				}
 				product_listview.setAdapter(new ProductAdapter(SearchResultActivity.this,R.layout.activity_product_item,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
 		        
 				product_listview.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
							long id) {
						// TODO Auto-generated method stub
//						Toast.makeText(SearchResultActivity.this, "你点击了第"+id+"项", 1).show();
						//跳转到商品详情
						Bundle bundle=new Bundle();
						mIntent=new Intent();

						bundle.putString("productTitle",data.get(Integer.parseInt(String.valueOf(id))).getTitle());
						bundle.putString("productPrice",data.get(Integer.parseInt(String.valueOf(id))).getPrice());
						bundle.putString("productContent",data.get(Integer.parseInt(String.valueOf(id))).getDescription());
						bundle.putString("productArea",data.get(Integer.parseInt(String.valueOf(id))).getArea());
						bundle.putString("productId",data.get(Integer.parseInt(String.valueOf(id))).getObjectId());
						if(data.get(Integer.parseInt(String.valueOf(id))).getImage()==null)
							bundle.putString("productImage","");
						else
							bundle.putString("productImage",data.get(Integer.parseInt(String.valueOf(id))).getImage().getUrl());
						mIntent.putExtras(bundle);
						mIntent.setClass(SearchResultActivity.this, ProductDetailActivity.class);
						startActivity(mIntent);
						
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
