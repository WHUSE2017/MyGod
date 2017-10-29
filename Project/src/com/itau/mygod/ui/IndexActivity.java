package com.itau.mygod.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.Bmob;

import com.itau.jingdong.R;
import com.itau.mygod.adapter.IndexGalleryAdapter;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.entity.IndexGalleryItemData;
import com.itau.mygod.ui.base.BaseActivity;
import com.itau.mygod.utils.CommonTools;
import com.itau.mygod.widgets.HomeSearchBarPopupWindow;
import com.itau.mygod.widgets.HomeSearchBarPopupWindow.onSearchBarItemClickListener;
import com.itau.mygod.widgets.jazzviewpager.JazzyViewPager;
import com.itau.mygod.widgets.jazzviewpager.OutlineContainer;
import com.itau.mygod.widgets.jazzviewpager.JazzyViewPager.TransitionEffect;
import com.itau.mygod.zxing.CaptureActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

public class IndexActivity extends BaseActivity implements OnClickListener,
		onSearchBarItemClickListener {
	public static final String TAG = IndexActivity.class.getSimpleName();
	public long exitTime = 0;
	//=============中部导航栏模块=====
	private ImageButton shake;
	private Intent mIntent;
	
	// ============== 广告切换 ===================
	private JazzyViewPager mViewPager = null;
	/**
	 * 装指引的ImageView数组
	 */
	private ImageView[] mIndicators;

	/**
	 * 装ViewPager中ImageView的数组
	 */
	private ImageView[] mImageViews;
	private List<String> mImageUrls = new ArrayList<String>();
	private LinearLayout mIndicator = null;
	private String mImageUrl = null;
	private static final int MSG_CHANGE_PHOTO = 1;
	/** 图片自动切换时间 */
	private static final int PHOTO_CHANGE_TIME = 3000;
	// ============== 广告切换 ===================

	private Gallery mStormGallery = null;
	private Gallery mPromotionGallery = null;
	private IndexGalleryAdapter mStormAdapter = null;
	private IndexGalleryAdapter mPromotionAdapter = null;
	private List<IndexGalleryItemData> mStormListData = new ArrayList<IndexGalleryItemData>();
	private List<IndexGalleryItemData> mPromotionListData = new ArrayList<IndexGalleryItemData>();
	private IndexGalleryItemData mItemData = null;
	private HomeSearchBarPopupWindow mBarPopupWindow = null;
	private EditText mSearchBox = null;
	private ImageButton mCamerButton = null;
	private LinearLayout mTopLayout = null;
	private ImageButton mshake=null;
	private ImageButton mHistoryBtn=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		
		setContentView(R.layout.activity_index);
		mHandler = new Handler(getMainLooper()) {

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				switch (msg.what) {
				case MSG_CHANGE_PHOTO:
					int index = mViewPager.getCurrentItem();
					if (index == mImageUrls.size() - 1) {
						index = -1;
					}
					mViewPager.setCurrentItem(index + 1);
					mHandler.sendEmptyMessageDelayed(MSG_CHANGE_PHOTO,
							PHOTO_CHANGE_TIME);
				}
			}

		};

		initData();

		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		mViewPager = (JazzyViewPager) findViewById(R.id.index_product_images_container);
		mIndicator = (LinearLayout) findViewById(R.id.index_product_images_indicator);

		mStormGallery = (Gallery) findViewById(R.id.index_jingqiu_gallery);
		mPromotionGallery = (Gallery) findViewById(R.id.index_tehui_gallery);

		mSearchBox = (EditText) findViewById(R.id.index_search_edit);
		mCamerButton = (ImageButton) findViewById(R.id.index_camer_button);
		mTopLayout = (LinearLayout) findViewById(R.id.index_top_layout);
		mshake=(ImageButton)findViewById(R.id.index_shake);
		mHistoryBtn=(ImageButton)findViewById(R.id.index_history_btn);
		
	}

	
	@Override
	protected void initView() {
		
		// TODO Auto-generated method stub

		// ======= 初始化ViewPager ========
		mIndicators = new ImageView[mImageUrls.size()];
		if (mImageUrls.size() <= 1) {
			mIndicator.setVisibility(View.GONE);
		}

		for (int i = 0; i < mIndicators.length; i++) {
			ImageView imageView = new ImageView(this);
			LayoutParams params = new LayoutParams(0,
					LayoutParams.WRAP_CONTENT, 1.0f);
			if (i != 0) {
				params.leftMargin = 5;
			}
			imageView.setLayoutParams(params);
			mIndicators[i] = imageView;
			if (i == 0) {
				mIndicators[i]
						.setBackgroundResource(R.drawable.android_activities_cur);
			} else {
				mIndicators[i]
						.setBackgroundResource(R.drawable.android_activities_bg);
			}

			mIndicator.addView(imageView);
		}

		mImageViews = new ImageView[mImageUrls.size()];

		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			imageView.setScaleType(ScaleType.CENTER_CROP);
			mImageViews[i] = imageView;
		}
		mViewPager.setTransitionEffect(TransitionEffect.CubeOut);
		mViewPager.setCurrentItem(0);
		mHandler.sendEmptyMessageDelayed(MSG_CHANGE_PHOTO, PHOTO_CHANGE_TIME);

		mViewPager.setAdapter(new MyAdapter());
		mViewPager.setOnPageChangeListener(new MyPageChangeListener());
		mViewPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (mImageUrls.size() == 0 || mImageUrls.size() == 1)
					return true;
				else
					return false;
			}
		});
		
		// ======= 初始化ViewPager ========

		mStormAdapter = new IndexGalleryAdapter(this,
				R.layout.activity_index_gallery_item, mStormListData,
				new int[] { R.id.index_gallery_item_image,
						R.id.index_gallery_item_text });

		mStormGallery.setAdapter(mStormAdapter);

		mPromotionAdapter = new IndexGalleryAdapter(this,
				R.layout.activity_index_gallery_item, mPromotionListData,
				new int[] { R.id.index_gallery_item_image,
						R.id.index_gallery_item_text });

		mPromotionGallery.setAdapter(mPromotionAdapter);

		mStormGallery.setSelection(3);
		mPromotionGallery.setSelection(3);

		mBarPopupWindow = new HomeSearchBarPopupWindow(this,
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mBarPopupWindow.setOnSearchBarItemClickListener(this);

		mCamerButton.setOnClickListener(this);
		mSearchBox.setOnClickListener(this);
		mshake.setOnClickListener(this);
		mHistoryBtn.setOnClickListener(this);

		mSearchBox.setInputType(InputType.TYPE_NULL);
	}

	private void initData() {
		mImageUrl = "drawable://" + R.drawable.image01;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image02;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image03;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image04;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image05;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image06;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image07;
		mImageUrls.add(mImageUrl);

		mImageUrl = "drawable://" + R.drawable.image08;
		mImageUrls.add(mImageUrl);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(1);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_01);
		mItemData.setPrice("￥79.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(2);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_02);
		mItemData.setPrice("￥89.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(3);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_03);
		mItemData.setPrice("￥99.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(4);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_04);
		mItemData.setPrice("￥109.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(5);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_05);
		mItemData.setPrice("￥119.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(6);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_06);
		mItemData.setPrice("￥129.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(7);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_07);
		mItemData.setPrice("￥139.00");
		mStormListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(8);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_08);
		mItemData.setPrice("￥69.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(9);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_09);
		mItemData.setPrice("￥99.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(10);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_10);
		mItemData.setPrice("￥109.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(11);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_11);
		mItemData.setPrice("￥119.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(12);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_12);
		mItemData.setPrice("￥129.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(13);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_13);
		mItemData.setPrice("￥139.00");
		mPromotionListData.add(mItemData);

		mItemData = new IndexGalleryItemData();
		mItemData.setId(14);
		mItemData.setImageUrl("drawable://" + R.drawable.index_gallery_14);
		mItemData.setPrice("￥149.00");
		mPromotionListData.add(mItemData);
	}

	
	public class MyAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mImageViews.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object obj) {
			if (view instanceof OutlineContainer) {
				return ((OutlineContainer) view).getChildAt(0) == obj;
			} else {
				return view == obj;
			}
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(mViewPager
					.findViewFromObject(position));
		}

		@Override
		public Object instantiateItem(View container, int position) {
			ImageLoader.getInstance().displayImage(mImageUrls.get(position),
					mImageViews[position]);
			((ViewPager) container).addView(mImageViews[position], 0);
			mViewPager.setObjectForPosition(mImageViews[position], position);
			return mImageViews[position];
		}

	}

	/**
	 * 当ViewPager中页面的状态发生改变时调用
	 * 
	 * @author Administrator
	 * 
	 */
	private class MyPageChangeListener implements OnPageChangeListener {

		/**
		 * This method will be invoked when a new page becomes selected.
		 * position: Position index of the new selected page.
		 */
		public void onPageSelected(int position) {
			setImageBackground(position);
		}

		public void onPageScrollStateChanged(int arg0) {

		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}
	}

	/**
	 * 设置选中的tip的背景
	 * 
	 * @param selectItemsIndex
	 */
	private void setImageBackground(int selectItemsIndex) {
		for (int i = 0; i < mIndicators.length; i++) {
			if (i == selectItemsIndex) {
				mIndicators[i]
						.setBackgroundResource(R.drawable.android_activities_cur);
			} else {
				mIndicators[i]
						.setBackgroundResource(R.drawable.android_activities_bg);
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.index_camer_button:
			int height = mTopLayout.getHeight()
					+ CommonTools.getStatusBarHeight(this);
			mBarPopupWindow.showAtLocation(mTopLayout, Gravity.TOP, 0, height);
			break;

		case R.id.index_search_edit:
			openActivity(SearchActivity.class);
			break;
			
		case R.id.index_history_btn:
			if (Constants.status) {
				mIntent=new Intent(IndexActivity.this, HistoryActivity.class);
				startActivity(mIntent);
				break;
			}
			else {
				Toast.makeText(getBaseContext(), "请先登录！", Toast.LENGTH_SHORT).show();
				mIntent=new Intent(IndexActivity.this, LoginActivity.class);
				startActivity(mIntent);
				break;
			}

			
		case R.id.index_shake:
			try{
			mIntent=new Intent(IndexActivity.this, IndexProductActivity.class);
			startActivity(mIntent);
			//IndexActivity.this.finish();
			}catch(Exception e){
				Log.i("错误",e.getMessage());
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void onBarCodeButtonClick() {
		// TODO Auto-generated method stub
//		CommonTools.showShortToast(this, "条码购");
		mIntent=new Intent(IndexActivity.this, CaptureActivity.class);
		startActivity(mIntent);
	}

	@Override
	public void onCameraButtonClick() {
		// TODO Auto-generated method stub
		CommonTools.showShortToast(this, "拍照购");
	}

	@Override
	public void onColorButtonClick() {
		// TODO Auto-generated method stub
		CommonTools.showShortToast(this, "颜色购");
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
		{
			if((System.currentTimeMillis() - exitTime) > 2000)
			{
				Toast.makeText(getBaseContext(), "再按一次退出", Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			}
			else
			{
				
			    finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
