package com.itau.mygod.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.jingdong.R;
import com.itau.mygod.adapter.CatergoryAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.category.BooksActivity;
import com.itau.mygod.category.ClothingActivity;
import com.itau.mygod.category.DigitActivity;
import com.itau.mygod.category.FurnitureActivity;
import com.itau.mygod.category.HouseholdActivity;
import com.itau.mygod.category.LaptopActivity;
import com.itau.mygod.category.MobilephoneActivity;
import com.itau.mygod.category.SkinProtectionActivity;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.Category;
import com.itau.mygod.user.User;


public class CategoryActivity extends BaseActivity {

	private ListView catergory_listview;
	private ArrayList<Category> data;
//	private LayoutInflater layoutInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		initData();
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		catergory_listview=(ListView)this.findViewById(R.id.catergory_listview);
		BmobQuery<Category> query = new BmobQuery<Category>();
		query.order("Ctype");
		final ProgressDialog mPD;
		mPD=ProgressDialog.show(CategoryActivity.this, getTitle(), getResources().getString(R.string.category_loading), true, false);
		query.findObjects(new FindListener<Category>() {
			@Override
			public void done(List<Category> object, BmobException e) {
				Log.i("debug","done");
				if(object.size() != 0)
				{
					for(Category ct:object){
						data.add(ct);
					}
				}	
				Log.i("debug","setAdapte");
				catergory_listview.setAdapter(new CatergoryAdapter(CategoryActivity.this,data));
				mPD.dismiss();
				catergory_listview.setOnItemClickListener(new OnItemClickListener() {	
					@Override
					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
							long id) {
//						Toast.makeText(CategoryActivity.this, "你点击了第"+id+"项", 1).show();
						switch ((int)id) {
						case 0:
							Intent intent0=new Intent(CategoryActivity.this, HouseholdActivity.class);
							startActivity(intent0);
							break;
						case 1:
							Intent intent1=new Intent(CategoryActivity.this, BooksActivity.class);
							startActivity(intent1);
							break;
						case 2:
							Intent intent2=new Intent(CategoryActivity.this, ClothingActivity.class);
							startActivity(intent2);
							break;
						case 3:
							Intent intent3=new Intent(CategoryActivity.this, LaptopActivity.class);
							startActivity(intent3);
							break;
						case 4:
							Intent intent4=new Intent(CategoryActivity.this, DigitActivity.class);
							startActivity(intent4);
							break;
						case 5:
							Intent intent5=new Intent(CategoryActivity.this, FurnitureActivity.class);
							startActivity(intent5);
							break;
						case 6:
							Intent intent6=new Intent(CategoryActivity.this, MobilephoneActivity.class);
							startActivity(intent6);
							break;
						case 7:
							Intent intent7=new Intent(CategoryActivity.this, SkinProtectionActivity.class);
							startActivity(intent7);
							break;
						default:
							break;
						}

						
						
						
					}
				});
			}			
		});
//		CategoryActivity.this.doAsync(new Callable<ArrayList<Category>>() {
//
//			@Override
//			public ArrayList<Category> call() throws Exception {
//				Log.i("debug","运行里层了！");
//
//				// TODO Auto-generated method stub
//				BmobQuery<Category> query = new BmobQuery<Category>();
//				query.order("Ctype");
//				query.findObjects(new FindListener<Category>() {
//					@Override
//					public void done(List<Category> object, BmobException e) {
//						Log.i("debug","done");
//						if(object.size() != 0)
//						{
//							for(Category ct:object){
//								data.add(ct);
//							}
//						}	
//					}			
//				});
//			
//				return data;
//			}
//			
//		}, new Callback<ArrayList<Category>>() {
//
//			@Override
//			public void onCallback(ArrayList<Category> pCallbackValue) {
//				Log.i("debug","setAdapte");
//				catergory_listview.setAdapter(new CatergoryAdapter(CategoryActivity.this,pCallbackValue));
//				catergory_listview.setOnItemClickListener(new OnItemClickListener() {
//
//					@Override
//					public void onItemClick(AdapterView<?> adapterview, View view, int parent,
//							long id) {
//						Toast.makeText(CategoryActivity.this, "你点击了第"+id+"项", 1).show();
//						
//					}
//				});
//			}
//		}, new Callback<Exception>() {
//
//			@Override
//			public void onCallback(Exception pCallbackValue) {
//				// TODO Auto-generated method stub
//				Log.i("debugerror",pCallbackValue.getMessage());
//			}
//		}, true, getResources().getString(R.string.category_loading));
	}
	

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}
	
	private void initData(){
		data = new ArrayList<Category>();
	}
	
	private Integer[] mImageIds = {R.drawable.catergory_appliance,R.drawable.catergory_book,R.drawable.catergory_cloth,R.drawable.catergory_deskbook,
			R.drawable.catergory_digtcamer,R.drawable.catergory_furnitrue,R.drawable.catergory_mobile,R.drawable.catergory_skincare
			 };
	//给照片添加文字显示(Title)
	private String[] mTitleValues = { "家电", "图书", "衣服", "笔记本", "数码",
			"家具", "手机", "护肤" };
	
	private String[] mContentValues={"家电/生活电器/厨房电器", "电子书/图书/小说","男装/女装/童装", "笔记本/笔记本配件/产品外设", "摄影摄像/数码配件", 
			"家具/灯具/生活用品", "手机通讯/运营商/手机配件", "面部护理/口腔护理/..."};
	

}
