package com.itau.mygod.ui;



import android.content.Context;

public class DpUtils {
	public static int dip2px(Context context,float dipValue){
	     final float scale=context.getResources().getDisplayMetrics().density;
	     return (int)(dipValue*scale+0.5f);
	}

	public static int px2dp(Context context,float pxValue){
	    final float scale = context.getResources().getDisplayMetrics().density; 
	    return (int)(pxValue/scale+0.5f); 
	}
}
