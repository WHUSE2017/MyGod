package com.itau.mygod.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.security.auth.Destroyable;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

import com.itau.jingdong.R;
import com.itau.mygod.ui.IndexShakeActivity;
import com.itau.mygod.user.Product;

public class HistoryActivity extends Activity{
	
	private EditText product_name, product_price,product_description;
	private Spinner product_class,product_area;
	private ImageButton product_image;
	private ImageView product_view;
	private Button product_submit;
	private Activity historyActivity;
	private Intent intent;
	private String productName;
	private String productPrice;
	private String productClass;
	private String productDescription;
	private String productArea;
	private String pic_path="";
	private static final String IMAGE_UNSPECIFIED = "image/*";  
	private final int IMAGE_CODE = 200; // 这里的IMAGE_CODE是自己任意定义的
	private boolean isCompleted=false;
	private static final String tag = "HistoryActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		product_name=(EditText) findViewById(R.id.product_name_text);
		product_class=(Spinner) findViewById(R.id.product_class_spinner);
		product_price=(EditText) findViewById(R.id.product_price_text);
		product_image=(ImageButton) findViewById(R.id.product_camer_button);
		product_view=(ImageView) findViewById(R.id.set_pic);
		product_submit=(Button) findViewById(R.id.product_submit_button);
		product_description=(EditText) findViewById(R.id.product_description_text);
		product_area=(Spinner) findViewById(R.id.product_area_spinner);
		//下拉框
		productArea = (String) product_area.getSelectedItem();
		productClass = (String) product_class.getSelectedItem();
		
		//product_submit.setOnClickListener(this);
		historyActivity=HistoryActivity.this;
		//监听获得商品种类
		product_class.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position ,long id){
				productClass = (String) product_class.getSelectedItem();
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});
		//监听获得地点信息
		product_area.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position ,long id){
				productArea = (String) product_area.getSelectedItem();
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				
			}
		});
		//监听图像获取
	    product_image.setOnClickListener(new OnClickListener() {  
	    	  
	        @Override  
	        public void onClick(View v) {  
	            // TODO Auto-generated method stub  
//	        	Intent intent = new Intent();
//	        	intent.setType("image/*");   
//	            intent.setAction(Intent.ACTION_GET_CONTENT);   
//	        	startActivityForResult(intent, IMAGE_CODE);
	        	Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent, IMAGE_CODE);
	  
//	    	    Intent intent = new Intent(Intent.ACTION_PICK, null);  
//	    	    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);  
//	    	    startActivityForResult(intent, IMAGE_CODE);  
	            //setImage1(); // 魅族显示风格：最新，照片，图库；华为：包含有相片的一组目录，  
	                            // 小米：选择要使用的应用，最后没有结果  
	  
	            // setImage(); //魅族显示风格：图库，文件选择(图片文件) ；华为：最近的照片 小米：选择要使用的应用，最后没有结果  
	  
	        }  
	  
	    });  
		//监听提交按钮
		product_submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				productName=product_name.getText().toString();
				productPrice=product_price.getText().toString();
				productDescription=product_description.getText().toString();
				addProduct();
				if(isCompleted)
				{
					isCompleted=false;
				intent=new Intent(HistoryActivity.this,IndexShakeActivity.class);
				startActivity(intent);
				pic_path="";
				finish();
				}
			}
		});
	}
	/**
	 * 图片处理
	 */
	@SuppressLint("NewApi")
	@SuppressWarnings("finally")
	@Override  
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	    // TODO Auto-generated method stub  
		super.onActivityResult(requestCode, resultCode, data); 
	      
	    Bitmap bm = null;  
	  
	    // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口  
	  
	    ContentResolver resolver = getContentResolver();  
	  
	    if (requestCode == IMAGE_CODE) {  
	  
	        try {  
	  
	            Uri originalUri = data.getData(); // 获得图片的uri  
	  
	            bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);  
	  
	            product_view.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 300, 300));  //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示  
	            // 显得到bitmap图片  
	  
 				if(originalUri != null){
 					pic_path = getRealPathFromURI(originalUri);
 					Toast.makeText(this, "获取图片成功，path="+pic_path, Toast.LENGTH_SHORT).show();
 					//setImageView(realPath);
 				}else{
 					Log.e(tag, "从相册获取图片失败");
 				}
	            String[] proj = { MediaStore.Images.Media.DATA };  
	  
//	            // 好像是android多媒体数据库的封装接口，具体的看Android文档  
//	            @SuppressWarnings("deprecation")
//				Cursor cursor = this.managedQuery(originalUri, proj, null, null, null);  
//	            //===============wtt
//	            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);  
//	            // 将光标移至开头 ，这个很重要，不小心很容易引起越界  
//	            cursor.moveToFirst();  
//	            // 最后根据索引值获取图片路径  
//
//	            cursor.close();
	            
	            //.setText(path);  
	        } catch (IOException e) {  
	            Log.e("TAG-->Error", e.toString());  
	  
	            }  
	  
	            finally {  
	                return;  
	            }  
	        }  
	       
	  
	    } 
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
	};
	
	/**
	 * uri转path
	 * @param uri
	 * @return
	 */
	public String getRealPathFromURI(Uri contentUri){
        try{
            String[] proj = {MediaStore.Images.Media.DATA};
            // Do not call Cursor.close() on a cursor obtained using this method, 
            // because the activity will do that for you at the appropriate time
            Cursor cursor = this.managedQuery(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }catch (Exception e){
            return contentUri.getPath();
        }
	}
	
//图片？？
 
	
	/**
	 * 在用户界面显示所选图片   update
	 * @param data
	 */
//	private void setImage1() {  
//		//进入图库
//	    Intent intent = new Intent(Intent.ACTION_PICK, null);  
//	    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);  
//	    startActivityForResult(intent, IMAGE_CODE);  
//	} 
	 
	 /**
	  * 检查商品信息完整性：商品名+价格
	  * @return 
	  * true 完整
	  */
	public void addProduct() {
        if(productName.length() == 0)
		{
			Toast.makeText(getBaseContext(), "请输入商品名称", Toast.LENGTH_LONG).show();
			isCompleted=false;
		}
        else if (productPrice.length() == 0||!isNum(productPrice)) 
        {
        	Toast.makeText(getBaseContext(), "请输入价格", Toast.LENGTH_LONG).show();
        	isCompleted=false;
		}
		else if(pic_path.length()==0) 
		{
			System.out.println("pic_path为空");
			final Product product = new Product();
			product.setTitle(product_name.getText().toString());
			product.setType(productClass);
			product.setPrice(productPrice);
			product.setDescription(productDescription);
			product.setArea(productArea);
			BmobQuery<Product> query = new BmobQuery<Product>();
			query.addWhereEqualTo("title", product_name.getText().toString());
			query.addWhereEqualTo("type", productClass);
			query.addWhereEqualTo("price", productPrice);
			query.addWhereEqualTo("description", productDescription);
			query.addWhereEqualTo("area", productArea);
			
			query.findObjects(new FindListener<Product>() {
				
				@Override
				public void done(List<Product> object, BmobException e) {
					
						product.save(new SaveListener<String>() {
							
							@Override
							public void done(String objectId, BmobException e) {
								if(e == null)
								{
									Toast.makeText(getBaseContext(), "无图片发布成功!"+pic_path+"没了", Toast.LENGTH_SHORT).show();
								}
								else
								{
									Toast.makeText(getBaseContext(), "无图片发布失败!"+pic_path+"没了", Toast.LENGTH_LONG).show();
								}
							}				
						});
					
					
					
				}
			});
		//return true;
			isCompleted=true;
			
		}
        else
        {
        	final BmobFile file_image=new BmobFile(new File(pic_path));
		    file_image.uploadblock(new UploadFileListener() {
				

				@Override
				public void done(BmobException arg0) {
					// TODO Auto-generated method stub
					if(arg0==null){
						Toast.makeText(HistoryActivity.this, "上传文件成功:" + file_image.getFileUrl(), Toast.LENGTH_SHORT).show();
					Product product = new Product();
					product.setTitle(product_name.getText().toString());
					product.setType(productClass);
					product.setPrice(productPrice);
					product.setDescription(productDescription);
					product.setArea(productArea);
					product.setImage(file_image);
					product.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if(e==null){
                                Log.d("bmob", "成功");
                            }else{
                                Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                            }
                        }
                    });
					}else{
						Log.e(tag,"失败："+arg0.getMessage()+","+arg0.getErrorCode());
						Toast.makeText(HistoryActivity.this,"发布失败！", Toast.LENGTH_SHORT).show();
					}
//					BmobQuery<Product> query = new BmobQuery<Product>();
//					query.addWhereEqualTo("title", product_name.getText().toString());
//					query.addWhereEqualTo("type", productClass);
//					query.addWhereEqualTo("price", productPrice);
//					query.addWhereEqualTo("description", productDescription);
//					query.addWhereEqualTo("area", productArea);
//					query.addWhereEqualTo("image", file_image);
					
//					query.findObjects(new FindListener<Product>() {
//						
//						@Override
//						public void done(List<Product> object, BmobException e) {
//							
//								product.save(new SaveListener<String>() {
//									
//									@Override
//									public void done(String objectId, BmobException e) {
//										if(e == null)
//										{
//											//Toast.makeText(getBaseContext(), "有图片发布成功!", Toast.LENGTH_SHORT).show();
//											Toast.makeText(getBaseContext(), "有图片发布成功，path="+pic_path, Toast.LENGTH_LONG).show();
//										}
//										else
//										{
//											//Toast.makeText(getBaseContext(), "有图片发布失败!", Toast.LENGTH_LONG).show();
//											Toast.makeText(getBaseContext(), "有图片发布失败!，path="+pic_path, Toast.LENGTH_LONG).show();
//										}
//									}				
//								});
//						}
//					});
					
				}
				 @Override
	                public void onProgress(Integer value) {
	                    // 返回的上传进度（百分比）
	                }
			}); 
			
		//return true;
		    isCompleted=true;
		}

		
	}
	/**
	 * 判断价格输入是否为合法字符（0-9）
	 * @param str
	 * @return
	 */
	public boolean isNum(String str)
	{
		if (str.charAt(0)-'0'==0) {
			return false;
			
		}
		for (int i = 0; i < str.length(); i++) {
			
			int chr=str.charAt(i);
			if (chr<48||chr>57) {
				return false;
			}
		}
		return true;
	}
	
}
