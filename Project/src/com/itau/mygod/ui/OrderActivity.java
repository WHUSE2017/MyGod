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
import com.itau.mygod.bean.Constants;
import com.itau.mygod.user.User;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;

public class OrderActivity extends NewBaseActivity implements OnClickListener,
IPopupItemClick, OnItemLongClickListener{
	
	private static final String Tag="OrderActivity";
	//private OrderActivity orderActivity=null;
	private SimpleAdapter adapter;
 	private List<Map<String,Object>> datalist;
	private Button layout_buy;
	private Button layout_sale;
	RelativeLayout layout_action;
	TextView tv_buyer;
	LinearLayout layout_all;
	PopupWindow morePop;
	ListView listview;
	
	public void setContentView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_order);
	}
	
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order);
		findViewById();
		
		datalist = new ArrayList<Map<String,Object>>();
		
 		int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
 		String from[] = {"title","description","price","area","phone"};	
 		
 		adapter = new SimpleAdapter(this, getProIn(),R.layout.order_list, from, to);		
 		listview.setAdapter(adapter);
		
		//orderActivity=OrderActivity.this;

	}
	

   protected void findViewById(){
	   
	   tv_buyer = (TextView) findViewById(R.id.tv_buyer);
	   tv_buyer.setTag("Buy");
	   listview = (ListView) findViewById(R.id.list_buyer);
	   layout_all = (LinearLayout) findViewById(R.id.layout_all);
	   layout_action = (RelativeLayout) findViewById(R.id.layout_action);
	   initEditPop();
	   
   }
   
   public void initViews(){
	   tv_buyer = (TextView) findViewById(R.id.tv_buyer);
	   tv_buyer.setTag("Buy");
	   listview = (ListView) findViewById(R.id.list_buyer);
	   layout_all = (LinearLayout) findViewById(R.id.layout_all);
	   layout_action = (RelativeLayout) findViewById(R.id.layout_action);
	   initEditPop();
   }
	
   public void initListeners() {

	   listview.setOnItemLongClickListener(this);
	   layout_all.setOnClickListener(this);
   }
   
   @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == layout_all) {
			showListPop();
		}else if(v ==layout_buy){
			changeTextView(v);
			morePop.dismiss();
		
		} else if (v == layout_sale) {
			changeTextView(v);
			morePop.dismiss();
			// 这里是"我卖出的"方法
		}
	}
   private void changeTextView(View v) {
		if (v == layout_buy) {
			tv_buyer.setTag("Buy");
			tv_buyer.setText("我买到的");
		} else {
			tv_buyer.setTag("Sale");
			tv_buyer.setText("我卖出的");
		}
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
   
   private void initEditPop() {
		mPopupWindow = new EditPopupWindow(this, 200, 48);
		mPopupWindow.setOnPopupItemClickListner(this);
	}
   
   EditPopupWindow mPopupWindow;
	int position;
   String phone;
   
   @Override
	public boolean onItemLongClick(AdapterView<?> arg0, View view, int position,
			long id) {
		this.position = position;
		phone = ((TextView) (view.findViewById(R.id.tv_phone))).getText().toString();
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		mPopupWindow.showAtLocation(view, Gravity.RIGHT | Gravity.TOP,
				location[0], getStateBar() + location[1]);
		return false;
	}
	

	public List<Map<String,Object>> getProIn(){
	 		BmobQuery<Order> query = new BmobQuery<Order>();
	 		query.addWhereEqualTo("status", 1);
	 		query.addWhereEqualTo("buyerId", Constants.userobject);
	 		//query.setLimit(50);
	 		query.findObjects(new FindListener<Order>() 
	 		{
	 			
	 			@Override
	 			public void done(List<Order> object, BmobException e)
	 			{
	 				Log.i("debug",""+object.size());
	 				for (Order order : object)
	 				{
	 					Map<String,Object> map = new HashMap<String, Object>();
	 					map.put("description", order.getDescription());
	 					map.put("title", order.getTitle());
	 					map.put("price", order.getPrice());
	 					map.put("area", order.getArea());
	 					map.put("phone",order.getPhone());
	 					datalist.add(map);		               
	 		         }
	 				adapter.notifyDataSetChanged();				
	 			}
	 	
	 		});		
	 		
	 		return datalist;
	 	}

	@Override
	public void CallPhone(View v) {
		Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phone));
		startActivity(intent);
	}

	@Override
	public void SendMessage(View v) {
		Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + phone));
		startActivity(intent);
	}


	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}

}
