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

	//�ŧi�e���ϥΪ���
	private Button mSubmit, mClear , mExit;
	private TextView num1, num2, num3, num4, num5, num6, num7;
	private EditText input;
	private String inputdata;
	private int intValue;
	
	//�ŧi��������
	final Context context = this;
	private TextView mLucluInfo, mLuckynum, mLuckuLottery;
	private String mLucky;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lottery);

		findView();
	}
	
	//�e����l��
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

	//�H�����ͤ��Ӹ��X
	public void creatLottery() {
		//���ͤ����H�����X, �Ʀr�d��ѿ�J���M�w
		TreeSet set = new TreeSet();
		while (set.size() < 6) {
			set.add((int) (Math.random() * intValue + 1));
		}
		
		//�N�����H�����X��i�e��
		Object[] strArray = set.toArray();
		num1.setText(strArray[0].toString());
		num2.setText(strArray[1].toString());
		num3.setText(strArray[2].toString());
		num4.setText(strArray[3].toString());
		num5.setText(strArray[4].toString());
		num6.setText(strArray[5].toString());
		
		//���ͯS�O���X, �Ʀr�d��1~8
		TreeSet numset = new TreeSet();
		numset.add((int) (Math.random() * 8 + 1));
		Object[] numArray = numset.toArray();
		//�]�w�S�O���X�C��ç�ȶ�i�e��
		num7.setTextColor(Color.WHITE);
		num7.setText(numArray[0].toString());
	}
	
	//�������}����
	private void ShowExitDialog() {
		AlertDialog.Builder ad = new AlertDialog.Builder(LotteryActivity.this);
		ad.setTitle("���}�{��");
		ad.setMessage("�T�w�n�������ε{����?");
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
	
	//��ܩ��B���ƪ�����
	private void ShowLuckyDialog() {
		// custom dialog
		final Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.lucky_dialog);
		//����title �T��
		dialog.setTitle("���B����");

		//�]�m������T���e - texts,and button
		mLucluInfo    = (TextView) dialog.findViewById(R.id.lottery_info);
		mLuckynum     = (TextView) dialog.findViewById(R.id.lucky_num);
		mLuckuLottery = (TextView) dialog.findViewById(R.id.lucky_info_lottery);

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog
		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//��������
				dialog.dismiss();
			}
		});
		
		//���ͤj�N, ���N�H���Ѽ�
		createLotteryLuckyNum();
		//���͵�����ܵe��
		dialog.show();
	}
	
	//�H�����ͩ��B���Ƥj�N,���N,���t
	public void createLotteryLuckyNum() {
		//���ͩ��B����
		TreeSet numset = new TreeSet();
		numset.add((int) (Math.random() * 6 + 1));
		Object[] numArray = numset.toArray();
		
		//�P�_�H�����ͪ��Ʀr, �èM�w�Ʀr�����B�Ȭ���!
		if(numArray[0].toString().equals("1")){
			mLucky = "100"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("�j�N");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("2")) {
			mLucky = "100"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("�j�N");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("3")) {
			mLucky = "100"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("�j�N");
			mLuckuLottery.setTextColor(Color.RED);
		} else if (numArray[0].toString().equals("4")) {
			mLucky = "60"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("���N");
			mLuckuLottery.setTextColor(Color.YELLOW);
		} else if (numArray[0].toString().equals("5")) {
			mLucky = "60"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("���N");
			mLuckuLottery.setTextColor(Color.YELLOW);
		} else if (numArray[0].toString().equals("6")) {
			mLucky = "30"; //���B�Ƥ�
			mLuckynum.setText(mLucky + "%");
			mLuckuLottery.setText("���t");
			mLuckuLottery.setTextColor(Color.DKGRAY);
		}
	}

	//���s�I���ƥ�
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
				
				// ��ܦ��ռֳz���X���B�Ȫ��u������
				ShowLuckyDialog();
				
			} else {
				ToastUtility.showToast(getApplicationContext(), "�п�J�j��10���Ʀr!",
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
