package com.itau.mygod.adapter;



import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.itau.jingdong.R;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.Category;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ProductAdapter extends BaseAdapter {

	 private ArrayList<Product> data; 
	 private int parant_width =0;
	 int layoutId;
	 private int parant_height =0;
	    /** 
	     * LayoutInflater 类是代码实现中获取布局文件的主要形式 
	     *LayoutInflater layoutInflater = LayoutInflater.from(context); 
	     *View convertView = layoutInflater.inflate(); 
	     *LayoutInflater的使用,在实际开发种LayoutInflater这个类还是非常有用的,它的作用类似于 findViewById(), 
	    不同点是LayoutInflater是用来找layout下xml布局文件，并且实例化！ 
	    而findViewById()是找具体xml下的具体 widget控件(如:Button,TextView等)。 
	     */  
	    private LayoutInflater layoutInflater;  
	    private Context context;  
	      
	    
	    public ProductAdapter(Context context,int layoutId) {  
	          
	        this.context = context;  
	        this.layoutInflater = LayoutInflater.from(context); 
	        data = new ArrayList<Product>();
	        this.layoutId = layoutId;
	    } 
	    
	    public ProductAdapter(Context context,int layoutId,ArrayList<Product> data) {  
	          
	        this.context = context;  
	        this.data = data;  
	        this.layoutInflater = LayoutInflater.from(context); 
	        this.layoutId = layoutId;
	    } 
	    
	    public ProductAdapter(Context context,int layoutId,ArrayList<Product> data,int width,int height) {  
	          
	        this.context = context;  
	        this.data = data;  
	        this.layoutInflater = LayoutInflater.from(context);  
	        this.parant_width = width;
	        this.parant_height = height;
	        this.layoutId = layoutId;
	    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
//		return mImageIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
//		return 0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
//		return 0;
	}
	@SuppressWarnings("null")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=new ViewHolder();
		//组装数据
		LayoutParams lp;
		if(parant_width==0||parant_height==0)
			lp=null;
		else
			lp = new LayoutParams(parant_width/4,parant_height/8);
		Log.i("debug","view");
		if(convertView==null){
//			convertView=LayoutInflater.from(context).inflate(R.layout.activity_category_item, null);
			convertView=layoutInflater.inflate(layoutId, null);
			switch(layoutId){
			case R.layout.activity_product_item:
			holder.image=(ImageView) convertView.findViewById(R.id.product_image);
			holder.title=(TextView) convertView.findViewById(R.id.productitem_title);
			holder.content=(TextView) convertView.findViewById(R.id.productitem_price);
			//使用tag存储数据
			convertView.setTag(holder);
			break;
			case R.layout.activity_index_gallery_item:
				holder.image=(ImageView) convertView.findViewById(R.id.index_gallery_item_image);
				holder.title=(TextView) convertView.findViewById(R.id.index_gallery_item_title);
				holder.content=(TextView) convertView.findViewById(R.id.index_gallery_item_price);
				//使用tag存储数据
				convertView.setTag(holder);
				break;
			}
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		Log.i("debug","image");
		Product ct = data.get(position);
		if(ct.getImage()!=null){
			ImageLoader.getInstance().displayImage(ct.getImage().getUrl(), holder.image); 
		}else{
			holder.image.setImageResource(R.drawable.default_image);
		}
		holder.image.setScaleType(ImageView.ScaleType.FIT_XY);
		if(lp!=null)
		holder.image.setLayoutParams(lp);
		holder.title.setText(ct.getTitle());
		holder.content.setText(ct.getPrice());

		return convertView;
	}
	
	
	
		

	 public static class ViewHolder {
			ImageView image;
			TextView title;
			TextView content;
		}
	
}

