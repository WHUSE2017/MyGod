package com.itau.mygod.ui;

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
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.jingdong.R;
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

		
}
