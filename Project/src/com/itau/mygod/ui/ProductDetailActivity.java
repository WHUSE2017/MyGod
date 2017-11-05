package com.itau.mygod.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

import com.itau.jingdong.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import com.itau.mygod.bean.Constants;
<<<<<<< HEAD
import com.itau.mygod.user.Attention;
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Order;
import com.itau.mygod.user.User;
import com.itau.mygod.utils.CommonTools;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ProductDetailActivity extends Activity implements OnClickListener {

	private static final String Tag = "ProductDeatilActivity";
	public static final int REFRESH = 0;
	private ProductDetailActivity productBuyActivity = null;
	private Button productBuy;
<<<<<<< HEAD
	private Button attention;
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	private ImageView productImage;
	private String productTitle;
	private String productPrice;
	private String productContent;
	private String productArea;
	private String productId;
	private String productImageUrl;
<<<<<<< HEAD
	private String productSalerIdPhone;
	private boolean attention_status;
	private String attention_objectid;
	private Handler myHandler;

=======
	
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);

		findViewById();

		Bundle bundle = getIntent().getExtras();

		TextView tv_Title = (TextView) findViewById(R.id.detail_title);
		TextView tv_Price = (TextView) findViewById(R.id.product_price_num);
		TextView tv_Content = (TextView) findViewById(R.id.detail_content);

		productTitle = bundle.getString("productTitle");
		tv_Title.setText(productTitle);
		productPrice = bundle.getString("productPrice");
		tv_Price.setText(productPrice);
		productContent = bundle.getString("productContent");
		tv_Content.setText(productContent);
<<<<<<< HEAD
		productArea = bundle.getString("productArea");
		productId = bundle.getString("productId");
		productImageUrl = bundle.getString("productImage");
		productSalerIdPhone = bundle.getString("productSalerIdPhone");
=======
		productArea=bundle.getString("productArea");
		productId = bundle.getString("productId");
		productImageUrl = bundle.getString("productImage");
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
		initView();
		BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				BmobQuery<Attention> query = new BmobQuery<Attention>();
				query.addWhereEqualTo("buyerId", Constants.userobject);
				Product tmp = new Product();
				tmp.setObjectId(productId);
				query.addWhereEqualTo("pId", tmp);
				query.findObjects(new FindListener<Attention>() {

					@Override
					public void done(List<Attention> object, BmobException e) {
						if (e != null)
							Log.i("bmob",
									"失败：" + e.getMessage() + ","
											+ e.getErrorCode());
						if (object.size() != 0) {
							attention.setText(R.string.attention_yes);
							attention.invalidate();
							attention_status = true;
							attention_objectid = object.get(0).getObjectId();
							Log.i("bmob", "成功：" + object.get(0).getObjectId());
							// Message msg = new Message();
							// msg.what = REFRESH;
							// myHandler.sendMessage(msg);

						}
					}

				});
			}
		};
		// new Thread(new GameThread()).start();
		IntentFilter filter = new IntentFilter(LoginActivity.TAG);
		registerReceiver(broadcastReceiver, filter);
		myHandler = new Handler()

		{

			// 接收到消息后处理

			public void handleMessage(Message msg)

			{

				switch (msg.what)

				{

				case ProductDetailActivity.REFRESH:

					attention.invalidate(); // 刷新界面

					break;

				}

				super.handleMessage(msg);

			}

		};
	}

	protected void findViewById() {
		productBuy = (Button) this.findViewById(R.id.btnbuy);
		attention = (Button) this.findViewById(R.id.attention);
		productImage = (ImageView) this.findViewById(R.id.detail_image);
		attention_status = false;
	}

	protected void initView() {
		productBuy.setOnClickListener(this);
		attention.setOnClickListener(this);
		if (productImageUrl.length() == 0) {
			productImage.setImageResource(R.drawable.default_image);
		} else {
			ImageLoader.getInstance().displayImage(productImageUrl,
					productImage);
		}
		productImage.setLayoutParams(new LayoutParams(getWindowManager()
				.getDefaultDisplay().getWidth(), getWindowManager()
				.getDefaultDisplay().getHeight() / 4 * 3));
		if (Constants.status) {
			Log.i("status", "成功");
			BmobQuery<Attention> query = new BmobQuery<Attention>();
			query.addWhereEqualTo("buyerId", Constants.userobject);
			Product tmp = new Product();
			tmp.setObjectId(productId);
			query.addWhereEqualTo("pId", tmp);
			query.findObjects(new FindListener<Attention>() {

				@Override
				public void done(List<Attention> object, BmobException e) {
					if (e != null)
						Log.i("bmob",
								"失败：" + e.getMessage() + "," + e.getErrorCode());
					if (object.size() != 0) {
						attention.setText(R.string.attention_yes);
						attention_status = true;
						attention_objectid = object.get(0).getObjectId();
						Log.i("bmob", "成功：" + object.get(0).getObjectId());
						// Message msg = new Message();
						// msg.what = REFRESH;
						// myHandler.sendMessage(msg);

					}
				}

			});
		}
		productImage.setLayoutParams(new LayoutParams(getWindowManager().getDefaultDisplay().getWidth(),getWindowManager().getDefaultDisplay().getHeight()/4*3));
	}

<<<<<<< HEAD
	public void productBuy(View view) {
		if (Constants.status) {

			new AlertDialog.Builder(ProductDetailActivity.this)
					.setTitle("系统提示")
					// 设置对话框标题

					.setMessage("确定提交订单吗")
					// 设置显示的内容

					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {// 添加确定按钮

								@Override
								public void onClick(DialogInterface dialog,
										int which) {// 确定按钮的响应事件

									/**
									 * 这里要查询User表中的电话号码
									 * 
									 * Product product=new Product();
									 * 
									 * BmobQuery<Product> query=new
									 * BmobQuery<Product>();
									 * query.addWhereEqualTo
									 * ("title",productTitle);
									 * query.include("salerId");
									 * query.findObjects(this,new
									 * FindListener<Product>(){
									 * 
									 * public void onSuccess(List<Product>
									 * object){ User
									 * user=BmobUser.getCurrentUser(this,
									 * User.class);
									 * product.getSalerId.getPhone(); } public
									 * void onError(int code, String msg){
									 * Toast.makeText(getBaseContext(), "查询失败",
									 * Toast.LENGTH_SHORT).show(); }
									 * 
									 * });
									 */
									Order order = new Order();
									order.setTitle(productTitle);
									order.setPrice(productPrice);
									order.setArea(productArea);
									order.setBuyerId(Constants.userobject);
									Product product = new Product();
									product.setObjectId(productId);
									order.setPId(product);
									order.setDescription(productContent);
									order.setPhone(productSalerIdPhone);
									order.setStatus(1);

									order.save(new SaveListener<String>() {

										@Override
										public void done(String objectId,
												BmobException e) {
											// TODO Auto-generated method stub
											Toast.makeText(getBaseContext(),
													"保存成功", Toast.LENGTH_SHORT)
													.show();

										}
									});

									// 跳转到订单页
									startActivity(new Intent(
											ProductDetailActivity.this,
											OrderActivity.class));
									// ProductDetailActivity.this.finish();

								}

							})
					.setNegativeButton("返回",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									finish();

								}// 返回按钮

							}).show();
		} else {
=======
	
	public void productBuy(View view){
		if(Constants.status){
		
		new AlertDialog.Builder(ProductDetailActivity.this).setTitle("系统提示")//设置对话框标题  
		  
	     .setMessage("确定下架该商品吗？")//设置显示的内容  
	  
	     .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮  
	   
	         @Override  
	  
	         public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件  
	           
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
	        	 
	        	 Product productUpdate=new Product();
	        	 productUpdate.setStatus(2);
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
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
			Toast.makeText(getBaseContext(), "请先登录！", Toast.LENGTH_LONG).show();
			Intent mIntent = new Intent(ProductDetailActivity.this,
					LoginActivity.class);

			startActivityForResult(mIntent, 100);
		}
<<<<<<< HEAD
	}

=======
	 }  	
	
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnbuy:
			productBuy(v);

			break;
		case R.id.attention:
			if (!Constants.status) {
				Toast.makeText(getBaseContext(), "请先登录！", Toast.LENGTH_SHORT)
						.show();
				Intent mIntent = new Intent(ProductDetailActivity.this,
						LoginActivity.class);

				startActivityForResult(mIntent, 100);
			} else if (attention_status) {
				Attention gameScore = new Attention();
				gameScore.setObjectId(attention_objectid);
				gameScore.delete(new UpdateListener() {

					@Override
					public void done(BmobException e) {
						if (e == null) {
							Log.i("bmob", "成功");
							Toast.makeText(getBaseContext(), "取消关注成功！",
									Toast.LENGTH_SHORT).show();
							attention.setText(R.string.attention_no);
							attention_status = false;
							// Message msg = new Message();
							// msg.what = REFRESH;
							// myHandler.sendMessage(msg);
							new Thread(new GameThread()).start();
						} else {
							Log.i("bmob",
									"失败：" + e.getMessage() + ","
											+ e.getErrorCode());
						}
					}
				});
			} else if (!attention_status) {
				Attention gameScore = new Attention();
				Product product = new Product();
				product.setObjectId(productId);
				gameScore.setPId(product);
				gameScore.setBuyerId(Constants.userobject);
				gameScore.save(new SaveListener<String>() {

					@Override
					public void done(String objectId, BmobException e) {
						if (e == null) {
							Toast.makeText(getBaseContext(), "关注成功！",
									Toast.LENGTH_SHORT).show();
							attention.setText(R.string.attention_yes);
							attention_status = true;
							attention_objectid = objectId;
							// Message msg = new Message();
							// msg.what = REFRESH;
							// myHandler.sendMessage(msg);
							new Thread(new GameThread()).start();
						} else {
							Log.i("bmob",
									"失败：" + e.getMessage() + ","
											+ e.getErrorCode());
						}
					}
				});
			}

			break;
		default:
			break;
		}
	}

	class GameThread implements Runnable

	{

		public void run()

		{

			while (!Thread.currentThread().isInterrupted())

			{

				Message message = new Message();

				message.what = ProductDetailActivity.REFRESH;

				// 发送消息

				myHandler.sendMessage(message);

				try

				{

					Thread.sleep(100);

				}

				catch (InterruptedException e)

				{

					Thread.currentThread().interrupt();

				}

			}

		}

	}

}
