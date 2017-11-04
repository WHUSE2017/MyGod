package com.itau.mygod.ui;

import java.util.List;

<<<<<<< HEAD
import com.itau.mygod.ui.MyProductsActivity;
=======
import com.itau.jingdong.MyProductsActivity;
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
import com.itau.jingdong.R;
import com.itau.jingdong.R.drawable;
import com.itau.jingdong.R.id;
import com.itau.jingdong.R.layout;
import com.itau.mygod.user.Order;
import com.itau.mygod.user.Product;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

public class OrderDetailActivity extends Activity implements OnClickListener{

	private Button button_agree;
	private Button button_cancel;
	private ImageView order_detail_image;
	private ImageView productImage;

	private String productArea;
	private String productId;
	private String productImageUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_detail);
		button_agree=(Button)findViewById(R.id.btn_order_agree);
		order_detail_image=(ImageView)findViewById(R.id.order_detail_image);
		Bundle bundle=getIntent().getExtras();
		//Bundle bundle=getIntent().getExtras();
		TextView tv_Title=(TextView)findViewById(R.id.order_detail_title);
		TextView tv_Price=(TextView)findViewById(R.id.order_detail_price);
		TextView tv_Content=(TextView)findViewById(R.id.order_detail_content);
		tv_Title.setText(bundle.getString("title"));
		tv_Price.setText(bundle.getString("price"));
		tv_Content.setText(bundle.getString("description"));
		productImageUrl=bundle.getString("image");
		productId=(String)bundle.getString("pId");
		Log.i("sysout", "orderDetail==="+bundle.getString("description"));
		Log.i("sysout", "orderDetail==="+bundle.getString("product_id"));
		Log.i("sysout", "orderDetail==="+productId);

		//button_agree.setOnClickListener(null);
		initView();
	}
	protected void initView(){
		
		
		if(productImageUrl.length()==0){
			order_detail_image.setImageResource(R.drawable.default_image);
		}else{
			ImageLoader.getInstance().displayImage(productImageUrl, order_detail_image);
		}
		order_detail_image.setLayoutParams(new LayoutParams(getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()/4*3));
		button_agree.setOnClickListener(this);
		
		
				
	}
	public void button_agree(View view){
		new AlertDialog.Builder(OrderDetailActivity.this).setTitle("系统提示")//设置对话框标题  
		  
	     .setMessage("确定完成订单吗")//设置显示的内容  
	  
	     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
	    	 
	  	   
	         @Override  
	  
	         public void onClick(DialogInterface dialog, int which) {
	        	 //确定按钮的响应事件  

					// TODO Auto-generated method stub
					
		        	 Product productUpdate=new Product();
		        	 productUpdate.setStatus(3);
		        	 productUpdate.update(productId, new UpdateListener() {
						
						@Override
						public void done(BmobException e) {
							// TODO Auto-generated method stub
		        	         if(e==null){
	      	                   Log.i("bmob","更新成功");
	      	                 }else{
	      	                   Log.i("bmob","更新失败："+e.getMessage()+","+e.getErrorCode());
	      	                 }
						}
					});
		        	 Toast.makeText(OrderDetailActivity.this,"订单完成！", Toast.LENGTH_SHORT).show();
		        	 
		        	 BmobQuery<Order> query=new BmobQuery<Order>();
		        	 query.addWhereEqualTo("pId", productId);
		        	 query.findObjects(new FindListener<Order>() {
						
						@Override
						public void done(List<Order> order, BmobException arg1) {
							// TODO Auto-generated method stub
							Order newOrder =new Order();
							newOrder.setStatus(2);
							for(Order MyOrder:order)
							{
								String OrderId=MyOrder.getObjectId();
								newOrder.update(OrderId, new UpdateListener() {
									
									@Override
									public void done(BmobException e) {
										// TODO Auto-generated method stub
					        	         if(e==null){
					      	                   Log.i("bmob","更新成功");
					      	                 }else{
					      	                   Log.i("bmob","更新失败："+e.getMessage()+","+e.getErrorCode());
					      	                 }
									}
								});

							}

						}
					});
//		        	Order order =new Order();
//		        	order.setStatus(2);

		        	 
		        	 
				
	  //=================================================================================================
		        	 startActivity(new Intent(OrderDetailActivity.this, OrderActivity.class)); 
	         }  
	  
	     }).setNegativeButton("返回",new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				 finish();
				
			}//返回按钮       
	  
	     }).show();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		button_agree(v);
	}
	

}
