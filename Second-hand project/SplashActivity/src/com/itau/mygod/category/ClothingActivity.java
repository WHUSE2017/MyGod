package com.itau.mygod.category;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.mygod.R;
import com.itau.mygod.adapter.ProductAdapter;
import com.itau.mygod.ui.ProductDetailActivity;
import com.itau.mygod.user.Product;

public class ClothingActivity extends Activity {
	private ListView clothing_ListView;
	private ArrayList<Product> data;
	private Intent mIntent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clothing);
		initData();
		findViewById();
		initView();
	}
	protected void findViewById() {
		clothing_ListView=(ListView)this.findViewById(R.id.clothing_listview);
		BmobQuery<Product> query = new BmobQuery<Product>();
		query.include("salerId");
		query.addWhereEqualTo("status", 1);
		query.order("-createdAt");
		final ProgressDialog mPD;
		mPD=ProgressDialog.show(ClothingActivity.this, getTitle(), getResources().getString(R.string.category_loading), true, false);
		query.findObjects(new FindListener<Product>() {
			@Override
			public void done(List<Product> object, BmobException e) {
				Log.i("debug","done");
				if(object.size() != 0)
				{
					for(Product ct:object){
						if(ct.getType().equals("衣服"))
						{
							data.add(ct);
						}

					}
				}	
				Log.i("debug","setAdapte");
				clothing_ListView.setAdapter(new ProductAdapter(ClothingActivity.this,R.layout.activity_product_item,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
				mPD.dismiss();
				clothing_ListView.setOnItemClickListener(new OnItemClickListener() {	
					@Override
					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
							long id) {
						//Toast.makeText(IndexProductActivity.this, "你点击了第"+id+"项", 1).show();
						Bundle bundle=new Bundle();
						mIntent=new Intent();

						bundle.putString("productTitle",data.get(Integer.parseInt(String.valueOf(id))).getTitle());
						bundle.putString("productPrice",data.get(Integer.parseInt(String.valueOf(id))).getPrice());
						bundle.putString("productContent",data.get(Integer.parseInt(String.valueOf(id))).getDescription());
						bundle.putString("productArea",data.get(Integer.parseInt(String.valueOf(id))).getArea());
						bundle.putString("productId",data.get(Integer.parseInt(String.valueOf(id))).getObjectId());
						bundle.putString("productSalerIdPhone", data.get(Integer.parseInt(String.valueOf(id))).getSalerId().getPhone());
						if(data.get(Integer.parseInt(String.valueOf(id))).getImage()==null)
							bundle.putString("productImage","");
						else
							bundle.putString("productImage",data.get(Integer.parseInt(String.valueOf(id))).getImage().getUrl());
						mIntent.putExtras(bundle);
						mIntent.setClass(ClothingActivity.this, ProductDetailActivity.class);
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
