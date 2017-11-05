package com.itau.mygod.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.search.MyListView;
import com.itau.mygod.search.RecordSQLiteOpenHelper;
import com.itau.mygod.task.Callback;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;

public class SearchActivity extends BaseActivity {

	private EditText et_search;
	private TextView tv_tip;
	private MyListView listView;
	private TextView tv_clear;
	private RecordSQLiteOpenHelper helper = new RecordSQLiteOpenHelper(this);;
	private SQLiteDatabase db;
	private BaseAdapter adapter;
	private SimpleAdapter simAdapter;
	private ArrayList<Product> data;
	private Intent mIntent;
	private ListView household_ListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search);
		//datalist = new ArrayList<Map<String,Object>>();
		// 初始化控件
		initView();	
  
		// 清空搜索历史
		tv_clear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				deleteData();
				queryData("");
			}
		});
		

		// 搜索框的键盘搜索键点击回调
		et_search.setOnKeyListener(new View.OnKeyListener() {// 输入完后按键盘上的搜索键

			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {// 修改回车键功能
					// 先隐藏键盘
					((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
							getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
					// 按完搜索键后将当前查询的关键字保存起来,如果该关键字已经存在就不执行保存
					boolean hasData = hasData(et_search.getText().toString().trim());
					if (!hasData) {
						insertData(et_search.getText().toString().trim());
						queryData("");
					}
					// TODO 根据输入的内容模糊查询商品，需跳转到另一个界面，待实现
					Toast.makeText(SearchActivity.this, "clicked!", Toast.LENGTH_SHORT).show();
					Bundle bundle=new Bundle();
					final Intent mmIntent=new Intent();
					bundle.putString("productTitle",et_search.getText().toString());
					mmIntent.putExtras(bundle);
//					ComponentName com = new ComponentName("com.itau.mygod.ui","com.itau.mygod.ui.SearchResultActivity");
//					mmIntent.setComponent(com);
					mmIntent.setClass(SearchActivity.this, SearchResultActivity.class);
					SearchActivity.this.doAsync(new Callable<Boolean>() {

						@Override
						public Boolean call() throws Exception {
							Log.i("debug","运行里层了！");
							startActivity(mmIntent);

							return true;
						}
						
					}, new Callback<Boolean>() {

						@Override
						public void onCallback(Boolean pCallbackValue) {
							// TODO Auto-generated method stub
									
						}
					}, new Callback<Exception>() {

						@Override
						public void onCallback(Exception pCallbackValue) {
							// TODO Auto-generated method stub
							Log.i("debug",pCallbackValue.getMessage());
						}
					}, true, getResources().getString(R.string.all_loading));
					

				}
				return false;
			}
		});

		// 搜索框的文本变化实时监听
		et_search.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {
				//if (s.toString().trim().length() == 0) {
				//	tv_tip.setText("历史搜索");
				//} else {
				//	tv_tip.setText("搜索结果");
				//}
				String tempName = et_search.getText().toString();
				// 根据tempName模糊查询数据库中有没有数据
				queryData(tempName);

			}
		});
        
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				TextView textView = (TextView) view.findViewById(R.id.stv_title);
				String name = textView.getText().toString();
				et_search.setText(name);
				Toast.makeText(SearchActivity.this, name, Toast.LENGTH_SHORT).show();
				// TODO 获取到item上面的文字，根据该关键字跳转到另一个页面查询，待实现
				
				Bundle bundle=new Bundle();
				mIntent=new Intent();
				bundle.putString("productTitle",name);
				mIntent.putExtras(bundle);
				
				mIntent.setClass(SearchActivity.this, SearchResultActivity.class);
				SearchActivity.this.doAsync(new Callable<Boolean>() {

					@Override
					public Boolean call() throws Exception {
						Log.i("debug","运行里层了！");
						startActivity(mIntent);

						return true;
					}
					
				}, new Callback<Boolean>() {

					@Override
					public void onCallback(Boolean pCallbackValue) {
						// TODO Auto-generated method stub
								
					}
				}, new Callback<Exception>() {

					@Override
					public void onCallback(Exception pCallbackValue) {
						// TODO Auto-generated method stub
						Log.i("debug",pCallbackValue.getMessage());
					}
				}, true, getResources().getString(R.string.all_loading));
		 				
			}
			
		});


		// 第一次进入查询所有的历史记录
		queryData("");
	}
	

	/**
	 * 插入数据
	 */
	private void insertData(String tempName) {
		db = helper.getWritableDatabase();
		db.execSQL("insert into records(name) values('" + tempName + "')");
		db.close();
	}

	/**
	 * 模糊查询数据
	 */
	private void queryData(String tempName) {
		Cursor cursor = helper.getReadableDatabase().rawQuery(
				"select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
		// 创建adapter适配器对象
		adapter = new SimpleCursorAdapter(this, R.layout.search_list, cursor, new String[] { "name" },
				new int[] { R.id.stv_title }, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		// 设置适配器
		listView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	
	/**
	 * 检查数据库中是否已经有该条记录
	 */
	private boolean hasData(String tempName) {
		Cursor cursor = helper.getReadableDatabase().rawQuery(
				"select id as _id,name from records where name =?", new String[]{tempName});
		//判断是否有下一个
		return cursor.moveToNext();
	}

	/**
	 * 清空数据
	 */
	private void deleteData() {
		db = helper.getWritableDatabase();
		db.execSQL("delete from records");
		db.close();
	}
	

	
	protected void initView() {
		et_search = (EditText) findViewById(R.id.et_search);
		tv_tip = (TextView) findViewById(R.id.tv_tip);
		listView = (com.itau.mygod.search.MyListView) findViewById(R.id.listView);
		tv_clear = (TextView) findViewById(R.id.tv_clear);
		household_ListView=(ListView)this.findViewById(R.id.household_listview);

		// 调整EditText左边的搜索按钮的大小
		Drawable drawable = getResources().getDrawable(R.drawable.search);
		drawable.setBounds(0, 0, 50, 50);// 第一0是距左边距离，第二0是距上边距离，60分别是长宽
		et_search.setCompoundDrawables(drawable, null, null, null);// 只放左边
	}


	@Override
	protected void findViewById() {
		// TODO 自动生成的方法存根
		
	}


}
