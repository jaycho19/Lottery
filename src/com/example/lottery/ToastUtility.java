package com.example.lottery;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class ToastUtility {
	
	private static Toast mToast;
	private static Handler mHandler = new Handler();
	private static Runnable mRunnable = new Runnable() {
		public void run() {
			mToast.cancel();
		}
	};

	//功能是顯示提示訊息
	public static void showToast(Context mContext, String text, int duration) {

		mHandler.removeCallbacks(mRunnable);
		if (mToast != null)
			mToast.setText(text);
		else
			mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
		mHandler.postDelayed(mRunnable, duration + 1000);
		mToast.show();
	}

	public static void showToast(Context mContext, int resId, int duration) {
		showToast(mContext, mContext.getResources().getString(resId), duration);
	}

}
