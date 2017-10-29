package com.itau.mygod.ui;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import com.itau.jingdong.R;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itau.mygod.bean.Constants;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;
import com.itau.mygod.user.User;
import com.nostra13.universalimageloader.core.ImageLoader;


public class ProductDetailActivity extends Activity implements OnClickListener{
	
	private static final String Tag="ProductDeatilActivity";
	private ProductDetailActivity productBuyActivity=null;
	private Button productBuy;
	private ImageView productImage;
	private String productTitle;
	private String productPrice;
	private String productContent;
	private String productArea;
	private String productId;
	private String productImageUrl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);
		
		findViewById();
		
		Bundle bundle=getIntent().getExtras();
		
		TextView tv_Title=(TextView)findViewById(R.id.detail_title);
		TextView tv_Price=(TextView)findViewById(R.id.product_price_num);
		TextView tv_Content=(TextView)findViewById(R.id.detail_content);
		
		productTitle=bundle.getString("productTitle");
		tv_Title.setText(productTitle);
		productPrice=bundle.getString("productPrice");
		tv_Price.setText(productPrice);
		productContent=bundle.getString("productContent");
		tv_Content.setText(productContent);
		productArea=bundle.getString("productArea");
		productId = bundle.getString("productId");
		productImageUrl = bundle.getString("productImage");
		initView();
	}
	
	protected void findViewById(){
		productBuy=(Button)this.findViewById(R.id.btnbuy);
		productImage = (ImageView)this.findViewById(R.id.detail_image);
	}
	
	protected void initView(){
		productBuy.setOnClickListener(this);
		if(productImageUrl.length()==0){
			productImage.setImageResource(R.drawable.default_image);
		}else{
			ImageLoader.getInstance().displayImage(productImageUrl, productImage);
		}
	}

	
	public void productBuy(View view){
		if(Constants.status){
		
		new AlertDialog.Builder(ProductDetailActivity.this).setTitle("系统提示")//设置对话框标题  
		  
	     .setMessage("确定提交订单吗")//设置显示的内容  
	  
	     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
	   
	         @Override  
	  
	         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
	        	 
	        	 /**
	        	  * 这里要查询User表中的电话号码
	        	  
	        	 Product product=new Product();
	        	 
	        	 BmobQuery<Product> query=new BmobQuery<Product>();
	        	 query.addWhereEqualTo("title",productTitle);
	        	 query.include("salerId");
	        	 query.findObjects(this,new FindListener<Product>(){
	        		 
	        		 public void onSuccess(List<Product> object){
	        			 User user=BmobUser.getCurrentUser(this, User.class);
	        			 product.getSalerId.getPhone();
	        		 }
	        		 public void onError(int code, String msg){
	        			 Toast.makeText(getBaseContext(), "查询失败", Toast.LENGTH_SHORT).show();
	        		 }
	        		 
	        	 });
	        	*/
	           
	        	 Order order=new Order();
	        	 order.setTitle(productTitle);
	        	 order.setPrice(productPrice);
	        	 order.setArea(productArea);
	        	 order.setBuyerId(Constants.userobject);
	        	 Product product = new Product();
	        	 product.setObjectId(productId);
	        	 order.setPId(product);
	        	 order.setDescription(productContent);
	        	 order.setStatus(1);
	        	 
	        	 order.save(new SaveListener<String>(){
	        		 
						@Override
						public void done(String objectId, BmobException e) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), "保存成功", Toast.LENGTH_SHORT).show();
							
						}
	        	 });

	        	//跳转到订单页
		        startActivity(new Intent(ProductDetailActivity.this, OrderActivity.class));
		        //ProductDetailActivity.this.finish();
	  
	         }  
	  
	     }).setNegativeButton("返回",new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				 finish();
				
			}//返回按钮       
	  
	     }).show();
		}else{
			Toast.makeText(getBaseContext(), "请先登录！", Toast.LENGTH_LONG).show();
			Intent mIntent=new Intent(ProductDetailActivity.this, LoginActivity.class);
			
			startActivityForResult(mIntent, 100);
		}
	 }  	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		productBuy(v);
	}
		
	}

