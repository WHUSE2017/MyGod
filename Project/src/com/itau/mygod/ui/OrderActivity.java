package com.itau.mygod.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import com.itau.mygod.ui.MyProductsActivity;
=======
import com.itau.jingdong.MyProductsActivity;
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
import com.itau.jingdong.R;
import com.itau.mygod.adapter.ProductAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.category.BooksActivity;
import com.itau.mygod.ui.base.NewBaseActivity;
import com.itau.mygod.user.Order;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;
import com.itau.mygod.widgets.EditPopupWindow;
import com.itau.mygod.widgets.IPopupItemClick;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.b.V;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class OrderActivity extends NewBaseActivity implements OnClickListener,
IPopupItemClick, OnItemClickListener,OnItemLongClickListener{
	//
	private static final String Tag="OrderActivity";
	//private OrderActivity orderActivity=null;
	private SimpleAdapter adapter;
 	private List<Map<String,Object>> datalist;
<<<<<<< HEAD
=======
	private ArrayList<Product> data;
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	private Intent mIntent;
	private Button layout_buy;
	private Button layout_sale;
	private Button Layout_going_buy;
	private Button layout_going_sale;
	private Button layout_mypro;
	
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
		
		datalist = new ArrayList<Map<String,Object>>();
		
 		int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
 		String from[] = {"title","description","price","area","phone"};	
 		
 		adapter = new SimpleAdapter(this, getProIn(),R.layout.order_list, from, to);		
 		listview.setAdapter(adapter);
		//OrderActivity=OrderActivity.this;

	}
	

   
   public void initViews(){
	   tv_buyer = (TextView) findViewById(R.id.tv_buyer);
	   tv_buyer.setTag("Buy");
	   listview = (ListView) findViewById(R.id.list_orders);
	   layout_all = (LinearLayout) findViewById(R.id.layout_all);
	   layout_action = (RelativeLayout) findViewById(R.id.layout_action);
	   
	   initEditPop();
   }
	
   public void initListeners() {

	   listview.setOnItemLongClickListener(this);
<<<<<<< HEAD
	   seeOrderDetail();
=======
	   listview.setOnItemClickListener(this);
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	   layout_all.setOnClickListener(this);
   }
   
   @Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == layout_all) {
	 		 //seeOrderDetail();
			showListPop();
		}else if(v ==layout_buy){
			Log.i("bmob","查询买入");
			changeTextView(v);
	 		int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
	 		String from[] = {"title","description","price","area","phone"};	
	 		adapter = new SimpleAdapter(this, getProBuy(),R.layout.order_list, from, to);		
	 		listview.setAdapter(adapter);
	 		Toast.makeText(this, "查看我买到的商品", Toast.LENGTH_SHORT).show();
	 		 //seeOrderDetail();
			morePop.dismiss();
		
		} else if (v == layout_sale) {
			Log.i("bmob","查询卖出");
			changeTextView(v);
	 		int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area};
	 		String from[] = {"title","description","price","area"};	
	 		adapter = new SimpleAdapter(this, getProSale(),R.layout.order_list, from, to);		
	 		listview.setAdapter(adapter);
	 		Toast.makeText(this, "查看我卖出的商品", Toast.LENGTH_SHORT).show();
	 		 //seeOrderDetail();
			morePop.dismiss();
			// 这里是"我卖出的"方法
		}
		else if(v == Layout_going_buy)
		{
			changeTextView(v);
	 		int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
	 		String from[] = {"title","description","price","area","phone"};	
	 		adapter = new SimpleAdapter(this, getProBuyGoing(),R.layout.order_list, from, to);		
	 		listview.setAdapter(adapter);
	 		Toast.makeText(this, "查看我正在买的商品", Toast.LENGTH_SHORT).show();
	 		 //seeOrderDetail();
			morePop.dismiss();
		}
		else if (v==layout_going_sale) {
	 		 //seeOrderDetail();
			changeTextView(v);
			Log.i("zyg", "进入onclick.layout_going_sale");
			int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
	 		String from[] = {"title","description","price","area","phone"};	
	 		adapter = new SimpleAdapter(this, getProSaleGoing(),R.layout.order_list, from, to);		
	 		listview.setAdapter(adapter);
	 		Toast.makeText(this, "查看我正在卖的商品", Toast.LENGTH_SHORT).show();
			morePop.dismiss();
		}
		else if (v==layout_mypro){
			changeTextView(v);
			Log.i("zyg", "进入onclick");
			int [] to = {R.id.tv_title,R.id.tv_describe,R.id.tv_price,R.id.tv_area,R.id.tv_phone};
	 		String from[] = {"title","description","price","area","phone"};	
	 		adapter = new SimpleAdapter(this, getProOnSale(),R.layout.order_list, from, to);		
	 		listview.setAdapter(adapter);
	 		Toast.makeText(this, "查看我的商品", Toast.LENGTH_SHORT).show();
			morePop.dismiss();
		}
		
		
		
	}
   private void changeTextView(View v) {
		if (v == layout_buy) {
			tv_buyer.setTag("Buy");
			tv_buyer.setText("我已买到");
		} else if(v == layout_sale) {
			tv_buyer.setTag("Sale");
			tv_buyer.setText("我已卖出");
<<<<<<< HEAD
		}
		else if (v == Layout_going_buy) {
			tv_buyer.setTag("BuyGoing");
			tv_buyer.setText("我的订购单");
		} else if(v==layout_going_sale) {
			tv_buyer.setTag("SaleGoing");
			tv_buyer.setText("待处理订单");
		}else if(v==layout_mypro){
			Log.i("zyg", "进入changeTextView");
			tv_buyer.setTag("ProductOnLine");
			tv_buyer.setText("我的架上商品");
		}
=======
		}
		else if (v == Layout_going_buy) {
			tv_buyer.setTag("BuyGoing");
			tv_buyer.setText("我的订购单");
		} else if(v==layout_going_sale) {
			tv_buyer.setTag("SaleGoing");
			tv_buyer.setText("待处理订单");
		}else if(v==layout_mypro){
			Log.i("zyg", "进入changeTextView");
			tv_buyer.setTag("ProductOnLine");
			tv_buyer.setText("我的架上商品");
		}
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
		
		
	}
   
   //显示订单
   private void showListPop() {
		View view = LayoutInflater.from(this).inflate(R.layout.pop_list, null);
		// 顶部弹出窗
		layout_buy = (Button) view.findViewById(R.id.layout_buy);
		layout_sale = (Button) view.findViewById(R.id.layout_sale);
		Layout_going_buy=(Button) view.findViewById(R.id.layout_going_buy);
		layout_going_sale=(Button)view.findViewById(R.id.layout_going_sale);
		layout_mypro=(Button)view.findViewById(R.id.layout_mypro);
		layout_buy.setOnClickListener(this);
		layout_sale.setOnClickListener(this);
		Layout_going_buy.setOnClickListener(this);
		layout_going_sale.setOnClickListener(this);
		layout_mypro.setOnClickListener(this);
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
   
   
   
   //长安
   @Override
	public boolean onItemLongClick(AdapterView<?> arg0, View view, int position,
			long id) {
		this.position = position;
		Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", Toast.LENGTH_SHORT).show();
		phone = ((TextView) (view.findViewById(R.id.tv_phone))).getText().toString();
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		mPopupWindow.showAtLocation(view, Gravity.RIGHT | Gravity.TOP,
				location[0], getStateBar() + location[1]);
		return false;
	}
   
   
   
   //短按
   
   @Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long id) {
	   this.position = position;
	   if (tv_buyer.getTag().toString().equals("SaleGoing")) {
		   Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", Toast.LENGTH_SHORT).show();
		   String title=(String) datalist.get(position).get("title");
		   String price=(String) datalist.get(position).get("price");
		   String description=(String) datalist.get(position).get("description");
		   String ImageUrl=(String) datalist.get(position).get("image");
		   //Product product=(Product) datalist.get(position).get("pId");
		   //String product_id=product.getObjectId();
		   String product_id=(String) datalist.get(position).get("pId");
			Log.i("sysout", "orderActivity"+product_id);
			Bundle bundle=new Bundle();
			mIntent=new Intent();
			bundle.putString("title", title);
			bundle.putString("price", price);
			bundle.putString("description", description);
			bundle.putString("pId", product_id);
			bundle.putString("image", ImageUrl);
			mIntent.putExtras(bundle);
			mIntent.setClass(OrderActivity.this, OrderDetailActivity.class);
			startActivity(mIntent);
	}
	   else if (tv_buyer.getTag().toString().equals("ProductOnLine")) {
		   Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", Toast.LENGTH_SHORT).show();
		   String title=(String) datalist.get(position).get("title");
		   String price=(String) datalist.get(position).get("price");
		   String description=(String) datalist.get(position).get("description");
		   String ImageUrl=(String) datalist.get(position).get("image");
		   //Product product=(Product) datalist.get(position).get("pId");
		   //String product_id=product.getObjectId();
		   String product_id=(String) datalist.get(position).get("pId");
			Log.i("sysout", "orderActivity"+product_id);
			Bundle bundle=new Bundle();
			mIntent=new Intent();
			bundle.putString("title", title);
			bundle.putString("price", price);
			bundle.putString("description", description);
			bundle.putString("pId", product_id);
			bundle.putString("image", ImageUrl);
			mIntent.putExtras(bundle);
			mIntent.setClass(OrderActivity.this, MyProductsActivity.class);
			startActivity(mIntent);
	}
		
	}

   
   //从云端加载商品----所有
	public List<Map<String,Object>> getProIn(){
		datalist.clear();
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
	 					map.put("pId", order.getPId());
	 					datalist.add(map);		               
	 		         }
	 				adapter.notifyDataSetChanged();				
	 			}
	 	
	 		});		
	 		
	 		return datalist;
	 	}
	
	
	public List<Map<String,Object>> getProOnSale(){

		datalist.clear();
		
		BmobQuery<Product> eq1 = new BmobQuery<Product>();
		eq1.addWhereEqualTo("status", 1);
		BmobQuery<Product> eq2 = new BmobQuery<Product>();
		eq2.addWhereEqualTo("status", 2);
		List<BmobQuery<Product>> queries = new ArrayList<BmobQuery<Product>>();
		queries.add(eq1);
		queries.add(eq2);
		//BmobQuery<Person> mainQuery = new BmobQuery<Person>();
		//mainQuery.or(queries);

		
 		BmobQuery<Product> query = new BmobQuery<Product>();
 		Log.i("zyg", "进入getProOnSale");
 		//没人要
 		query.or(queries);
 		query.addWhereEqualTo("salerId", Constants.userobject);
 		query.order("-createdAt");
 		//query.setLimit(50);
 		query.findObjects(new FindListener<Product>() 
 		{
 			@Override
 			public void done(List<Product> object, BmobException e)
 			{
 				Log.i("debug",""+object.size());
 				for (Product product : object)
 				{
 					
 					Map<String,Object> map = new HashMap<String, Object>();
 					map.put("description", product.getDescription());
 					map.put("title", product.getTitle());
 					map.put("price", product.getPrice());
 					map.put("area", product.getArea());
 					map.put("pId", product.getObjectId());
 					map.put("image", product.getImage().getUrl());
 					System.out.println("PID::============"+product.getObjectId());
 					
 					Log.i("sysout", "开关按钮状态="+product.getObjectId());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;

 	}
	
	
	
<<<<<<< HEAD

	//从云端加载我买到的商品
	
	public List<Map<String,Object>> getProBuy(){
		datalist.clear();
 		BmobQuery<Order> query = new BmobQuery<Order>();
 		//order 0:取消 1:正在进行 2:交易成功
 		query.addWhereEqualTo("status", 2);
 		query.addWhereEqualTo("buyerId", Constants.userobject);
 		query.order("createAt");
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
 					map.put("pId", order.getPId());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;
 	}
	
	//从云端加载我卖出的商品
	
	public List<Map<String,Object>> getProSale(){
		

=======

	//从云端加载我买到的商品
	
	public List<Map<String,Object>> getProBuy(){
		datalist.clear();
 		BmobQuery<Order> query = new BmobQuery<Order>();
 		//order 0:取消 1:正在进行 2:交易成功
 		query.addWhereEqualTo("status", 2);
 		query.addWhereEqualTo("buyerId", Constants.userobject);
 		query.order("createAt");
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
 					map.put("pId", order.getPId());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;
 	}
	
	//从云端加载我卖出的商品
	
	public List<Map<String,Object>> getProSale(){
		

>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
		datalist.clear();
		
 		BmobQuery<Product> query = new BmobQuery<Product>();
 		//东西已卖出
 		query.addWhereEqualTo("status", 3);
 		query.addWhereEqualTo("salerId", Constants.userobject);
 		//query.order(C);
 		//query.setLimit(50);
 		query.findObjects(new FindListener<Product>() 
 		{
 			@Override
 			public void done(List<Product> object, BmobException e)
 			{
 				Log.i("debug",""+object.size());
 				for (Product product : object)
 				{
 					Map<String,Object> map = new HashMap<String, Object>();
 					map.put("description", product.getDescription());
 					map.put("title", product.getTitle());
 					map.put("price", product.getPrice());
 					map.put("area", product.getArea());
 					map.put("pId", product.getObjectId());
 					map.put("image", product.getImage());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;

 	}
	
	
//从云端加载我正在卖
	public List<Map<String,Object>> getProSaleGoing(){

		datalist.clear();
 		BmobQuery<Product> query = new BmobQuery<Product>();
 		//东西已卖出
 		query.addWhereEqualTo("status", 2);
 		query.addWhereEqualTo("salerId", Constants.userobject);
 		query.order("-createdAt");
 		//query.setLimit(50);
 		query.findObjects(new FindListener<Product>() 
 		{
 			@Override
 			public void done(List<Product> object, BmobException e)
 			{
 				Log.i("debug",""+object.size());
 				for (Product product : object)
 				{
 					
 					Map<String,Object> map = new HashMap<String, Object>();
 					map.put("description", product.getDescription());
 					map.put("title", product.getTitle());
 					map.put("price", product.getPrice());
 					map.put("area", product.getArea());
 					map.put("pId", product.getObjectId());
 					map.put("image", product.getImage().getUrl());
 					System.out.println("PID::============"+product.getObjectId());
 					
 					Log.i("sysout", "开关按钮状态="+product.getObjectId());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;

 	}
	
	//从云端加载我正在买入
	
	public List<Map<String,Object>> getProBuyGoing(){
		

		datalist.clear();
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
 					map.put("pId", order.getPId());
 					datalist.add(map);		               
 		         }
 				adapter.notifyDataSetChanged();				
 			}
 	
 		});		
 		
 		return datalist;

 	}
	
	
	
	
	
	
	public void  seeOrderDetail() {
		// TODO Auto-generated method stub

		
<<<<<<< HEAD
//		listview.setAdapter(new ProductAdapter(OrderActivity.this,R.layout.activity_product_item,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
//		morePop.dismiss();
		listview.setOnItemClickListener(new OnItemClickListener() {	
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
			   OrderActivity.this.position = position;
			   if (tv_buyer.getTag().toString().equals("SaleGoing")) {
				   Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", Toast.LENGTH_SHORT).show();
				   String title=(String) datalist.get(position).get("title");
				   String price=(String) datalist.get(position).get("price");
				   String description=(String) datalist.get(position).get("description");
				   String ImageUrl=(String) datalist.get(position).get("image");
				   //Product product=(Product) datalist.get(position).get("pId");
				   //String product_id=product.getObjectId();
				   String product_id=(String) datalist.get(position).get("pId");
					Log.i("sysout", "orderActivity"+product_id);
					Bundle bundle=new Bundle();
					mIntent=new Intent();
					bundle.putString("title", title);
					bundle.putString("price", price);
					bundle.putString("description", description);
					bundle.putString("pId", product_id);
					bundle.putString("image", ImageUrl);
					mIntent.putExtras(bundle);
					mIntent.setClass(OrderActivity.this, OrderDetailActivity.class);
					startActivity(mIntent);
			}
			   else if (tv_buyer.getTag().toString().equals("ProductOnLine")) {
				   Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", Toast.LENGTH_SHORT).show();
				   String title=(String) datalist.get(position).get("title");
				   String price=(String) datalist.get(position).get("price");
				   String description=(String) datalist.get(position).get("description");
				   String ImageUrl=(String) datalist.get(position).get("image");
				   //Product product=(Product) datalist.get(position).get("pId");
				   //String product_id=product.getObjectId();
				   String product_id=(String) datalist.get(position).get("pId");
					Log.i("sysout", "orderActivity"+product_id);
					Bundle bundle=new Bundle();
					mIntent=new Intent();
					bundle.putString("title", title);
					bundle.putString("price", price);
					bundle.putString("description", description);
					bundle.putString("pId", product_id);
					bundle.putString("image", ImageUrl);
					mIntent.putExtras(bundle);
					mIntent.setClass(OrderActivity.this, MyProductsActivity.class);
					startActivity(mIntent);
			}
=======
		listview.setAdapter(new ProductAdapter(OrderActivity.this,data,getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()));
		morePop.dismiss();
		listview.setOnItemClickListener(new OnItemClickListener() {	
			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int parent,
					long id) {
				Toast.makeText(OrderActivity.this, "你点击了第"+id+"项", 1).show();
				Bundle bundle=new Bundle();
				mIntent=new Intent();

				bundle.putString("productTitle",data.get(Integer.parseInt(String.valueOf(id))).getTitle());
				bundle.putString("productPrice",data.get(Integer.parseInt(String.valueOf(id))).getPrice());
				bundle.putString("productContent",data.get(Integer.parseInt(String.valueOf(id))).getDescription());
				bundle.putString("productArea",data.get(Integer.parseInt(String.valueOf(id))).getArea());
				//bundle.putString("productId",data.get(Integer.parseInt(String.valueOf(id))).getObjectId());
				if(data.get(Integer.parseInt(String.valueOf(id))).getImage()==null)
					bundle.putString("productImage","");
				else
					bundle.putString("productImage",data.get(Integer.parseInt(String.valueOf(id))).getImage().getUrl());
				mIntent.putExtras(bundle);
				mIntent.setClass(OrderActivity.this, OrderDetailActivity.class);
				startActivity(mIntent);
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
				
			}
		});
		
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
