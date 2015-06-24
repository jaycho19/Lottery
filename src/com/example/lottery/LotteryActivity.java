package com.example.lottery;

import java.util.TreeSet;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LotteryActivity extends Activity implements OnClickListener {

	//宣告畫面使用物件
	private Button mSubmit, mClear , mExit;
	private TextView num1, num2, num3, num4, num5, num6, num7;
	private EditText input;
	private String inputdata;
	private int intValue;
	
	//宣告視窗元件
	final Context context = this;
	private TextView mLucluInfo, mLuckynum, mLuckuLottery;
	private String mLucky;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lottery);

		findView();
	}
	
	//畫面初始化
	private void findView() {
		mSubmit = (Button) findViewById(R.id.btn_submit);
		mClear = (Button) findViewById(R.id.btn_clear);
		mExit = (Button) findViewById(R.id.btn_cancel);
		
		num1 = (TextView) findViewById(R.id.text_num1);
		num2 = (TextView) findViewById(R.id.text_num2);
		num3 = (TextView) findViewById(R.id.text_num3);
		num4 = (TextView) findViewById(R.id.text_num4);
		num5 = (TextView) findViewById(R.id.text_num5);
		num6 = (TextView) findViewById(R.id.text_num6);
		num7 = (TextView) findViewById(R.id.text_num7);
		input = (EditText) findViewById(R.id.input_num);

		mSubmit.setOnClickListener(this);
		mClear.setOnClickListener(this);
		mExit.setOnClickListener(this);
	}

	//隨機產生六個號碼
	public void creatLottery() {
		//產生六個隨機號碼, 數字範圍由輸入欄位決定
		TreeSet set = new TreeSet();
		while (set.size() < 6) {
			set.add((int) (Math.random() * intValue + 1));
		}
		
		//將六個隨機號碼塞進畫面
		Object[] strArray = set.toArray();
		num1.setText(strArray[0].toString());
		num2.setText(strArray[1].toString());
		num3.setText(strArray[2].toString());
		num4.setText(strArray[3].toString());
		num5.setText(strArray[4].toString());
		num6.setText(strArray[5].toString());
		
		//產生特別號碼, 數字範圍1~8
		TreeSet numset = new TreeSet();
		numset.add((int) (Math.random() * 8 + 1));
		Object[] numArray = numset.toArray();
		//設定特別號碼顏色並把值塞進畫面
		num7.setTextColor(Color.WHITE);
		num7.setText(numArray[0].toString());
	}
	
	//提示離開視窗
	private void ShowExitDialog() {
		AlertDialog.Builder ad = new AlertDialog.Builder(LotteryActivity.this);
		ad.setTitle("離開程式");
		ad.setMessage("確定要結束應用程式嗎?");
		ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int i) {
						// TODO Auto-generated method stub

						finish();

					}
				});
		ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int i) {
				
			}
		});
		ad.show();
	} 
	
	//顯示幸運指數的視窗
	private void ShowLuckyDialog() {
		// custom dialog
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.lucky_dialog);
		//視窗title 訊息
		dialog.setTitle("幸運指數");

		//設置視窗資訊內容 - texts,and button
		mLucluInfo    = (TextView) dialog.findViewById(R.id.lottery_info);
		mLuckynum     = (TextView) dialog.findViewById(R.id.lucky_num);
		mLuckuLottery = (TextView) dialog.findViewById(R.id.lucky_info_lottery);

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//取消視窗
				dialog.dismiss();
			}
		});
		
		//產生大吉, 中吉隨機參數
		createLotteryLuckyNum();
		//產生視窗顯示畫面
		dialog.show();
	}
	
	//隨機產生幸運指數大吉,中吉,略差
	public void createLotteryLuckyNum() {
		//產生幸運指數
		TreeSet numset = new TreeSet();
		numset.add((int) (Math.random() * 6 + 1));
		Object[] numArray = numset.toArray();
		
		//判斷隨機產生的數字, 並決定數字為幸運值為何!
		if(numArray[0].toString().equals("1")){
			mLucky = "100"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("大吉");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("2")) {
			mLucky = "100"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("大吉");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("3")) {
			mLucky = "100"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("大吉");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("4")) {
			mLucky = "60"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("中吉");
			mLuckuLottery.setTextColor(Color.YELLOW);
		} else if (numArray[0].toString().equals("5")) {
			mLucky = "60"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("中吉");
			mLuckuLottery.setTextColor(Color.YELLOW);
		} else if (numArray[0].toString().equals("6")) {
			mLucky = "30"; //幸運數比
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("略差");
			mLuckuLottery.setTextColor(Color.DKGRAY);
		}
	}

	//按鈕點擊事件
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_submit:
			if (input.getText().length() > 1
					&& input.getText().toString() != "") {
				inputdata = input.getText().toString();
				intValue = Integer.valueOf(inputdata);
				
				creatLottery();
				
				// 顯示此組樂透號碼幸運值的彈跳視窗
				ShowLuckyDialog();
				
			} else {
				ToastUtility.showToast(getApplicationContext(), "請輸入大於10的數字!",
						Toast.LENGTH_SHORT);
			}
			break;
		case R.id.btn_cancel:
			ShowExitDialog();
			break;
		case R.id.btn_clear:
			input.getText().clear();
			num1.setText("");
			num2.setText("");
			num3.setText("");
			num4.setText("");
			num5.setText("");
			num6.setText("");
			num7.setText("");
			break;
		}

	}

}
