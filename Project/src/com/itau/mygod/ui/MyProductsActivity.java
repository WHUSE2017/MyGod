<<<<<<< HEAD
package com.itau.mygod.ui;
=======
package com.itau.jingdong;
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;

import com.itau.mygod.ui.OrderActivity;
import com.itau.mygod.ui.OrderDetailActivity;
import com.itau.mygod.ui.ProductDetailActivity;
import com.itau.mygod.user.Order;
import com.itau.mygod.user.Product;
import com.nostra13.universalimageloader.core.ImageLoader;
<<<<<<< HEAD
import com.itau.jingdong.R;
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c

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

public class MyProductsActivity extends Activity implements OnClickListener{

	private Button button_delete;
	
	private ImageView pro_detail_image;


	private String productArea;
	private String productId;
	private String productImageUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_products);
		button_delete=(Button)findViewById(R.id.btn_product_cancle);

		pro_detail_image=(ImageView)findViewById(R.id.pro_detail_image);
		Bundle bundle=getIntent().getExtras();
		//Bundle bundle=getIntent().getExtras();
		TextView tv_Title=(TextView)findViewById(R.id.pro_detail_title);
		TextView tv_Price=(TextView)findViewById(R.id.pro_detail_price);
		TextView tv_Content=(TextView)findViewById(R.id.pro_detail_content);
		tv_Title.setText(bundle.getString("title"));
		tv_Price.setText(bundle.getString("price"));
		tv_Content.setText(bundle.getString("description"));
		productImageUrl=bundle.getString("image");
		productId=(String)bundle.getString("pId");
		Log.i("sysout", "myproducts==="+bundle.getString("description"));
		Log.i("sysout", "myproducts==="+bundle.getString("product_id"));
		Log.i("sysout", "myproducts==="+productId);
		//button_agree.setOnClickListener(null);
		initView();
	}
	
	
	
protected void initView(){
		
		if(productImageUrl.length()==0){
			pro_detail_image.setImageResource(R.drawable.default_image);
		}else{
			ImageLoader.getInstance().displayImage(productImageUrl, pro_detail_image);
		}
		pro_detail_image.setLayoutParams(new LayoutParams(getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()/4*3));

		button_delete.setOnClickListener(this);

		
		//  删除
//    	button_delete.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//               }
//		});
		
	}
public void button_delete(View view){
	
	new AlertDialog.Builder(MyProductsActivity.this).setTitle("系统提示")//设置对话框标题  
	  
     .setMessage("确定下架该商品吗？")//设置显示的内容  
  
     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
   
         @Override  
  
         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
           
  //=================================================================================================
        	 Product productUpdate=new Product();
        	 productUpdate.setStatus(0);
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
        	 Toast.makeText(MyProductsActivity.this,"商品下架成功", Toast.LENGTH_SHORT).show();
        	 
        	 
        	 
        	 BmobQuery<Order> query=new BmobQuery<Order>();
        	 query.addWhereEqualTo("pId", productId);
        	 query.findObjects(new FindListener<Order>() {
				
				@Override
				public void done(List<Order> order, BmobException arg1) {
					// TODO Auto-generated method stub
					Order newOrder =new Order();
					newOrder.setStatus(0);
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
		
	        	//跳转到订单页
		        startActivity(new Intent(MyProductsActivity.this, OrderActivity.class));
        	 
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
	button_delete(v);
}  	



}
