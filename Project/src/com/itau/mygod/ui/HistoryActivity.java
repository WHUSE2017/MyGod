package com.itau.mygod.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.security.auth.Destroyable;

import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.text.format.DateFormat;
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
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.IndexShakeActivity;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;
import com.itau.mygod.utils.BitmapCompressUtils;

public class HistoryActivity extends Activity{
	
	private EditText product_name, product_price,product_description;
	private Spinner product_class,product_area;
	//private ImageButton product_image;
	//private Layout product_pic;
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
	 private String fileName="";
	private static final String IMAGE_UNSPECIFIED = "image/*";  
	private final int IMAGE_CODE = 200; // 这里的IMAGE_CODE是自己任意定义的
	private final int CAMERA_CODE=100;
	private boolean isCompleted=false;
	private static final String tag = "HistoryActivity";
	public String salerIdString="1ab4f39828";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		product_name=(EditText) findViewById(R.id.product_name_text);
		product_class=(Spinner) findViewById(R.id.product_class_spinner);
		product_price=(EditText) findViewById(R.id.product_price_text);
		//product_image=(ImageButton) findViewById(R.id.product_camer_button);
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
	    
	    //图片按钮============================================w
	    
	    product_view.setOnClickListener(new OnClickListener() {  
	    	  
	        @Override  
	        public void onClick(View v) {  
	            // TODO Auto-generated method stub  
//	        	Intent intent = new Intent();
//	        	intent.setType("image/*");   
//	            intent.setAction(Intent.ACTION_GET_CONTENT);   
//	        	startActivityForResult(intent, IMAGE_CODE);
	        	fileName=getPhotopath();
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
				intent=new Intent(HistoryActivity.this,IndexProductActivity.class);
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
	            FileOutputStream out = new FileOutputStream(fileName);
	            Log.i("image", "====="+fileName);
	            //Uri uri_new = Uri.fromFile(out);
	            bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);  

	            //
	            product_view.setImageBitmap(ThumbnailUtils.extractThumbnail(bm, 300, 300));  
	            //使用系统的一个工具类，参数列表为 Bitmap Width,Height  这里使用压缩后显示，否则在华为手机上ImageView 没有显示  
	            // 显得到bitmap图片  
	            Bitmap myBitmap = null;
 				if(originalUri != null){
 				    pic_path = getRealPathFromURI(originalUri);
 		            Bitmap bitmap = getSmallBitmap(pic_path);
 					bitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);
 					out.flush();
 					out.close();
 					
 					
 					Toast.makeText(this, "获取图片成功，path="+pic_path, Toast.LENGTH_SHORT).show();
 				}else{
 					Log.e(tag, "从相册获取图片失败");
 				}
	            String[] proj = { MediaStore.Images.Media.DATA };  
	            
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
			
			
			final Product product = new Product();
			product.setTitle(product_name.getText().toString());
			product.setType(productClass);
			product.setPrice(productPrice);
			product.setDescription(productDescription);
			product.setArea(productArea);
			product.setSalerId(Constants.userobject);
			product.setStatus(1);//商品有效在展示
			BmobQuery<Product> query = new BmobQuery<Product>();
			query.findObjects(new FindListener<Product>() {
				@Override
				public void done(List<Product> object, BmobException e) {
					
						product.save(new SaveListener<String>() {
							
							@Override
							public void done(String objectId, BmobException e) {
								if(e == null)
								{
									Toast.makeText(getBaseContext(), "无图片发布成功!"+pic_path, Toast.LENGTH_SHORT).show();
								}
								else
								{
									Toast.makeText(getBaseContext(), "无图片发布失败!"+pic_path, Toast.LENGTH_LONG).show();
								}
							}				
						});				
				}
			});
			
		//return true;
			isCompleted=true;
			
		}
        else//有图片上传
        {
        	final BmobFile file_image=new BmobFile(new File(fileName));
		    file_image.uploadblock(new UploadFileListener() {
		    	Product product = new Product();
				@Override
				public void done(BmobException arg0) {
					// TODO Auto-generated method stub
					if(arg0==null){
					Toast.makeText(HistoryActivity.this, "上传文件成功:" + file_image.getFileUrl(), Toast.LENGTH_SHORT).show();
					//Product product = new Product();
					product.setTitle(product_name.getText().toString());
					product.setType(productClass);
					product.setPrice(productPrice);
					//product.setSalerId(salerIdString);
					product.setDescription(productDescription);
					product.setArea(productArea);
					product.setImage(file_image);
					product.setSalerId(Constants.userobject);
					product.setStatus(1);//商品有效在展示
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
	
	 /**路径创建
	  * 
	  */
	    private String getPhotopath() {
	        // TODO Auto-generated method stub

	        DateFormat df = new DateFormat();
	        Log.i("image", "进入getPhotopath");

	         String name = df.format("yyyyMMdd_hhmmss",
	                Calendar.getInstance(Locale.CHINA))
	                + ".png";
	        String fileName = "/sdcard/kkImage/" + name;
	        File file = new File("/sdcard/kkImage/");
	        if(!file.exists()){
	            Log.e("TAG","第一次创建文件夹");
	            file.mkdirs();// 如果文件夹不存在，则创建文件夹  
	        }

	        return fileName;
	    }
	/**
	 * 质量压缩方法
	 * @param image
	 * @return
	 */
//	 public static Bitmap compressImage(Bitmap image) {
//		 
//	       ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	       image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
//	       int options = 100;
//	       while (baos.toByteArray().length / 1024 > 100) {  //循环判断如果压缩后图片是否大于100kb,大于继续压缩
//	           baos.reset();//重置baos即清空baos
//	           //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
//	           image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
//	           options -= 10;//每次都减少10
//	       }
//	       ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
//	       Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
//	       return bitmap;
//	   }
	  /**
	   * 根据路径获得图片并压缩，返回bitmap用于显示
	   */ 
	    public static Bitmap getSmallBitmap(String filePath) {
	            final BitmapFactory.Options options = new BitmapFactory.Options();
	            options.inJustDecodeBounds = true;//设置为ture,只读取图片的大小，不把它加载到内存中去
	            BitmapFactory.decodeFile(filePath, options);

	            // Calculate inSampleSize
	        options.inSampleSize = calculateInSampleSize(options, 480, 800);//此处，选取了480x800分辨率的照片

	            // Decode bitmap with inSampleSize set
	        options.inJustDecodeBounds = false;//处理完后，同时需要记得设置为false

	        return BitmapFactory.decodeFile(filePath, options);
	        }
	    public static int calculateInSampleSize(BitmapFactory.Options options,int reqWidth, int reqHeight) {
	        final int height = options.outHeight;
	        final int width = options.outWidth;
	        int inSampleSize = 1;

	        if (height > reqHeight || width > reqWidth) {
	                 final int heightRatio = Math.round((float) height/ (float) reqHeight);
	                 final int widthRatio = Math.round((float) width / (float) reqWidth);
	                 inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
	        }
	            return inSampleSize;
	    }
	    
	    
	    
	    

    /**
     * 通过路径获取Bitmap对象
     *
     * @param path
     * @return
     */
//    public static Bitmap getBitmap(String path) {
//        Bitmap bm = null;
//        InputStream is = null;
//        try {
//            File outFilePath = new File(path);
//            //判断如果当前的文件不存在时，创建该文件一般不会不存在
//            if (!outFilePath.exists()) {
//                boolean flag = false;
//                try {
//                    flag = outFilePath.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("---创建文件结果----" + flag);
//            }
//            is = new FileInputStream(outFilePath);
//            bm = BitmapFactory.decodeStream(is);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return bm;
//    }
	
}
