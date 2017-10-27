package com.itau.mygod.ui;

import android.os.Bundle;
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

import com.itau.jingdong.R;
import com.itau.mygod.adapter.CatergoryAdapter;
import com.itau.mygod.ui.base.BaseActivity;


public class CategoryActivity extends BaseActivity {

	private ListView catergory_listview;
//	private LayoutInflater layoutInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		catergory_listview=(ListView)this.findViewById(R.id.catergory_listview);

		catergory_listview.setAdapter(new CatergoryAdapter(CategoryActivity.this));
		catergory_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int parent,
					long id) {
				Toast.makeText(CategoryActivity.this, "你点击了地"+id+"项", 1).show();
				
			}
		});
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}
	

}
