package com.itau.mygod.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import android.widget.SimpleAdapter;

import com.itau.mygod.widgets.IPopupItemClick;
import com.itau.mygod.widgets.EditPopupWindow;
import com.itau.mygod.ui.base.NewBaseActivity;
import com.itau.jingdong.R;
import com.itau.mygod.user.Attention;
import com.itau.mygod.user.User;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import android.widget.SimpleAdapter;

import com.itau.mygod.widgets.IPopupItemClick;
import com.itau.mygod.widgets.EditPopupWindow;
import com.itau.mygod.ui.base.NewBaseActivity;
import com.itau.jingdong.R;
import com.itau.mygod.user.User;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import android.widget.SimpleAdapter;

import com.itau.jingdong.R;
import com.itau.mygod.adapter.ProductAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.user.User;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;

public class AttentionActivity extends NewBaseActivity implements OnClickListener,
OnItemClickListener{
	
	private static final String Tag="AttentionActivity";
	//private OrderActivity orderActivity=null;
	private ProductAdapter adapter;
 	private ArrayList<Product> datalist;
	private Button layout_buy;
	private Button layout_sale;
	RelativeLayout layout_action;
	TextView tv_buyer;
	LinearLayout layout_all;
	PopupWindow morePop;
	ListView listview;
	
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_attention);
	}
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		datalist = new ArrayList<Product>();
		
 		int [] to = {R.id.tva_title,R.id.tva_describe,R.id.tva_price,R.id.tva_area};
 		String from[] = {"title","description","price","area"};	
 		
 		adapter = new ProductAdapter(this,R.layout.activity_product_item, getProIn(),getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight());		
 		listview.setAdapter(adapter);
		
		//orderActivity=OrderActivity.this;

	}
	

   
   public void initViews(){
	   tv_buyer = (TextView) findViewById(R.id.tva_attentioner);
	   tv_buyer.setTag("Attention");
	   listview = (ListView) findViewById(R.id.list_attentioner);
	   layout_all = (LinearLayout) findViewById(R.id.alayout_all);
	   layout_action = (RelativeLayout) findViewById(R.id.alayout_action);
   }
	
   public void initListeners() {

	   listview.setOnItemClickListener(this);
   }
   
   private void showListPop() {
		View view = LayoutInflater.from(this).inflate(R.layout.pop_list, null);
		// 顶部弹出窗
		layout_buy = (Button) view.findViewById(R.id.layout_buy);
		layout_sale = (Button) view.findViewById(R.id.layout_sale);
		layout_buy.setOnClickListener(this);
		layout_sale.setOnClickListener(this);
		morePop = new PopupWindow(view, mScreenWidth, 600);

		morePop.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					morePop.dismiss();
					return true;
				}
				return false;
			}
		});

		morePop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
		morePop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		morePop.setTouchable(true);
		morePop.setFocusable(true);
		morePop.setOutsideTouchable(true);
		morePop.setBackgroundDrawable(new BitmapDrawable());
		// 动画效果 从顶部弹下
		morePop.setAnimationStyle(R.style.MenuPop);
		morePop.showAsDropDown(layout_action, 0, -dip2px(this, 2.0F));
	}
   
   
   EditPopupWindow mPopupWindow;
	int position;
	

	public ArrayList<Product> getProIn(){
	 		BmobQuery<Attention> query = new BmobQuery<Attention>();
	 		query.addWhereEqualTo("buyerId", Constants.userobject);
	 		query.include("pId");
	 		//query.setLimit(50);
	 		query.findObjects(new FindListener<Attention>() 
	 		{
	 			
	 			@Override
	 			public void done(List<Attention> object, BmobException e)
	 			{
	 				Log.i("debug",""+object.size());
	 				for (Attention order : object)
	 				{
	 					
	 					datalist.add(order.getPId());		               
	 		         }
	 				adapter.notifyDataSetChanged();				
	 			}
	 	
	 		});		
	 		
	 		return datalist;
	 	}


	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO 自动生成的方法存根
		listview.setAdapter(new ProductAdapter(AttentionActivity.this,R.layout.activity_product_item,datalist,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
		listview.setOnItemClickListener(new OnItemClickListener() {	
			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int parent,
					long id) {
				//Toast.makeText(IndexProductActivity.this, "你点击了第"+id+"项", 1).show();
				Bundle bundle=new Bundle();
				Intent mIntent = new Intent();

				bundle.putString("productTitle",datalist.get(Integer.parseInt(String.valueOf(id))).getTitle());
				bundle.putString("productPrice",datalist.get(Integer.parseInt(String.valueOf(id))).getPrice());
				bundle.putString("productContent",datalist.get(Integer.parseInt(String.valueOf(id))).getDescription());
				bundle.putString("productArea",datalist.get(Integer.parseInt(String.valueOf(id))).getArea());
				bundle.putString("productId",datalist.get(Integer.parseInt(String.valueOf(id))).getObjectId());
				if(datalist.get(Integer.parseInt(String.valueOf(id))).getImage()==null)
					bundle.putString("productImage","");
				else
					bundle.putString("productImage",datalist.get(Integer.parseInt(String.valueOf(id))).getImage().getUrl());
				mIntent.putExtras(bundle);
				mIntent.setClass(AttentionActivity.this, ProductDetailActivity.class);
				startActivity(mIntent);
				
			}
		});
	}

}
