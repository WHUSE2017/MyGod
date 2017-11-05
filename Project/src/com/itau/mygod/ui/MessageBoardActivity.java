package com.itau.mygod.ui;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itau.jingdong.R;
import com.itau.mygod.bean.Constants;
import com.itau.mygod.ui.base.BaseActivity;
<<<<<<< HEAD
import com.itau.mygod.user.Attention;
import com.itau.mygod.user.Message;
import com.itau.mygod.user.Product;
import com.itau.mygod.user.User;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
=======
import com.itau.mygod.user.Message;
import com.itau.mygod.user.User;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

@SuppressLint("SimpleDateFormat")
public class MessageBoardActivity extends BaseActivity implements OnClickListener {
	private static final String Tag = "MessageBoardActivity";
	private MessageBoardActivity messageBoardActivity = null;

	private SimpleAdapter adapter;
	private List<Map<String, Object>> datalist;
	// private ListView listView;
	private ListView listMessage;
	private ImageView ivSend;
	private Dialog dialog;
	private EditText et_comment;
	private Intent mIntent;
<<<<<<< HEAD
	private Handler myHandler;
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	// private List<Message> list = new ArrayList<Message>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_board);

		datalist = new ArrayList<Map<String, Object>>();
		listMessage = (ListView) findViewById(R.id.listMessage);

<<<<<<< HEAD
		final int[] to = { R.id.tvName, R.id.tvTime, R.id.message };
		final String from[] = { "message_id", "updatedAt", "content" };
=======
		int[] to = { R.id.tvName, R.id.tvTime, R.id.message };
		String from[] = { "message_id", "updatedAt", "content" };
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c

		messageBoardActivity = MessageBoardActivity.this;
		findViewById();
		initView();
<<<<<<< HEAD
		initData();
		adapter = new SimpleAdapter(this, datalist, R.layout.message_item, from, to);
		listMessage.setAdapter(adapter);
		myHandler = new Handler()

		{

			// 接收到消息后处理

			public void handleMessage(android.os.Message msg)

			{

				switch (msg.what)

				{

				case 1:

					listMessage.setAdapter(new SimpleAdapter(MessageBoardActivity.this, getMesIn(), R.layout.message_item, from, to));

					break;

				}

				super.handleMessage(msg);

			}

		};
=======
		adapter = new SimpleAdapter(this, getMesIn(), R.layout.message_item, from, to);
		listMessage.setAdapter(adapter);
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
	}

	/**
	 * 弹出的布局
	 */
	private void showCommentDialog() {

		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View v = View.inflate(this, R.layout.message_dialog, null);
		dialog.setContentView(v);
		Button comment_cancel = (Button) v.findViewById(R.id.cancel);
		Button comment_fb = (Button) v.findViewById(R.id.Determine);
		et_comment = (EditText) v.findViewById(R.id.et_comment);
		comment_cancel.setOnClickListener(this);
		comment_fb.setOnClickListener(this);
		Window dialogWindow = dialog.getWindow();
		dialogWindow.setGravity(Gravity.TOP);

		/*
		 * 将对话框的大小按屏幕大小的百分比设置
		 */
		WindowManager m = getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = dialogWindow.getAttributes();
		p.y = DpUtils.dip2px(this, 70);
		dialogWindow.setAttributes(p);
		dialog.show();
	}

	public List<Map<String, Object>> getMesIn() {
		BmobQuery<Message> query = new BmobQuery<Message>();
		// query.addWhereEqualTo("status", 1);
		query.setLimit(50);
<<<<<<< HEAD
		datalist.clear();
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
		query.findObjects(new FindListener<Message>() {

			@Override
			public void done(List<Message> object, BmobException e) {
				for (Message message : object) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("message_id", message.getMessage_id());
					map.put("updatedAt", message.getUpdatedAt());
					map.put("content", message.getContent());
					datalist.add(map);
				}
				adapter.notifyDataSetChanged();
			}

		});

		return datalist;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ivAdd:
			if(Constants.status){
				showCommentDialog();
				
				}else{
					DisplayToast("您还未登录，请先登录！");
					mIntent=new Intent(MessageBoardActivity.this, LoginActivity.class);					
					startActivityForResult(mIntent, RESULT_OK);
				}
				
			
			break;
		case R.id.cancel:
			dialog.cancel();
			break;
		case R.id.Determine:
				final String Msg = et_comment.getText().toString();
				BmobQuery<Message> query = new BmobQuery<Message>();
				query.setLimit(15);
				query.findObjects(new FindListener<Message>() {
					@Override
					public void done(List<Message> object, BmobException e) {
						if (e == null) {
							// String old_passwd_database = " ";
							String id = null;
							// TODO Auto-generated method stub

							for (Message message : object) {
								if (message.getMessage_id().equals(Constants.userobject.getName())) {
									// old_passwd_database = user.getPasswd();
									id = message.getObjectId();
									break;
								}
							}
							if (id == null) {
								Message message_ = new Message();
								message_.setMessage_id(Constants.userobject.getName());
								message_.setContent(Msg);
								message_.save(new SaveListener<String>() {
									@Override
									public void done(String objectId, BmobException e) {
										// TODO Auto-generated method stub
										if (e == null) {											
											Toast.makeText(getBaseContext(), "上传成功!", Toast.LENGTH_SHORT).show();
											MessageBoardActivity.this.finish();
										} else {
											Toast.makeText(getBaseContext(), "上传失败!", Toast.LENGTH_LONG).show();
										}

									}
								});
							} else {

								Message update = new Message();
								update.setContent(Msg);
								update.update(id, new UpdateListener() {

									@Override
									public void done(BmobException e) {
										// TODO Auto-generated method stub
										if (e == null) {
											Toast.makeText(MessageBoardActivity.this, "上传成功", Toast.LENGTH_SHORT)
													.show();
											Intent intent = new Intent();
											intent.putExtra("Msg", Constants.messageobject.getContent()); // 向父Activity发送数据
<<<<<<< HEAD
											new Thread(){  
									            @Override  
									            public void run() {//在run()方法实现业务逻辑；  
									            	mHandler.sendEmptyMessage(1); 				  
									            }  
									        }.start();  
=======

>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c
											setResult(20, intent);
											finish();
										}
									}
								});
							}

						} else {
							Toast.makeText(getBaseContext(), "查找用户信息失败", Toast.LENGTH_SHORT).show();
						}
					}
				});

				adapter.notifyDataSetChanged();
				dialog.cancel();
				
			
			break;
		}

	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		ivSend = (ImageView) findViewById(R.id.ivAdd);

	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		ivSend.setOnClickListener(this);

	}
<<<<<<< HEAD
	
	protected void initData() {
		// TODO Auto-generated method stub
		getMesIn();

	}
=======
>>>>>>> 9429a390b68d22361d6197942ee5439cc5b1552c

}
