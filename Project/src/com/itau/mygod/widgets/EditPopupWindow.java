package com.itau.mygod.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.itau.jingdong.R;
import com.itau.mygod.widgets.IPopupItemClick;


public class EditPopupWindow extends BasePopupWindow implements OnClickListener {
	
		private TextView mEdit;
		private TextView mDelete;
		private IPopupItemClick mOnPopupItemClickListner;

		public EditPopupWindow(Context context, int width, int height) {
			super(LayoutInflater.from(context).inflate(
					R.layout.pop_device, null), dpToPx(context,width), dpToPx(context,height));
			setAnimationStyle(R.style.PopupAnimation);
		}
		
		private static int dpToPx(Context context, int dp) {
	        return (int) (context.getResources().getDisplayMetrics().density * dp + 0.5f);
	    }

		@Override
		public void initViews() {
			mEdit = (TextView) findViewById(R.id.tv_pop_edit);
			mDelete = (TextView) findViewById(R.id.tv_pop_delete);
		}

		@Override
		public void initEvents() {
			mEdit.setOnClickListener(this);
			mDelete.setOnClickListener(this);
		}

		@Override
		public void init() {

		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.tv_pop_edit:
				if (mOnPopupItemClickListner != null) {
					mOnPopupItemClickListner.CallPhone(v);
				}
				break;

			case R.id.tv_pop_delete:
				if (mOnPopupItemClickListner != null) {
					mOnPopupItemClickListner.SendMessage(v);
				}
				break;
			}
			dismiss();
		}

		public void setOnPopupItemClickListner(IPopupItemClick l) {
			mOnPopupItemClickListner = l;
		}


}
