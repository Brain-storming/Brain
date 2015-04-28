package cn.edu.bjtu.cyllk.game;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.business.BaseActivity;
import cn.edu.bjtu.cyllk.business.ChooseMode;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class Shangcheng extends BaseActivity{
	
	private ImageView  buy1, buy2;
    private ImageView star;
	private AnimationDrawable anima;
	private TextView xmd, tsk;
	String name, bn;
	public static Communication con;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shangcheng);
		
		 buy1 = (ImageView) findViewById(R.id.buyButton1);
		 buy2 = (ImageView) findViewById(R.id.buyButton2);
		 star=(ImageView)findViewById(R.id.shop_bganima);

		  xmd = (TextView) findViewById(R.id.xmd);
		  tsk = (TextView) findViewById(R.id.tsk);

		  buy1.setOnClickListener(buy1Button);
		  buy2.setOnClickListener(buy2Button);
		
		  con = Communication.instance;
		  
		 /* Timer time = new Timer();
		  TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Conmmunication.instance.getshop(Constant.userName);
				System.out.println(Constant.userName);

			}
		};
		time.schedule(task, 3000);*/
		  con.getshop(Constant.userName);
	}
	public void onWindowFocusChanged(boolean hasFocus) {

		super.onWindowFocusChanged(hasFocus);
		 anima = (AnimationDrawable) star.getBackground();
		 anima.start();
	}
	// 提示卡购买
		public OnClickListener buy1Button = new OnClickListener() {

			public void onClick(View v) {

				//con = Conmmunication.newInstance();
				/*final  Timer time = new Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						Conmmunication.instance.changshop("ka", 1);
						time.cancel();
					}
				};
				time.schedule(task, 3000);*/
				con.changshop("ka", 1);
			}
		};
		// 醒目灯购买
		public OnClickListener buy2Button = new OnClickListener() {

			public void onClick(View v) {
				//con = Conmmunication.newInstance();
				/*final Timer time = new Timer();
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						Conmmunication.instance.changshop("deng", 1);
	                    time.cancel();
					}
				};
				time.schedule(task, 3000);*/
				con.changshop("deng", 1);
			}
		};
		

		public void processMessage(Message message) {
			switch (message.what) {
			case Config.REQUEST_GET_PROP:
				tsk.setText("现拥有" + message.arg1 + "个");
				xmd.setText("现拥有" + message.arg2 + "个");
				System.out.println("deng=" + message.arg1 + "ka=" + message.arg2);
				break;
			case Config.REQUEST_MODIFY_PROP:
				if (message.arg1 == Config.SUCCESS) {
					//Toast.makeText(this, "购买成功", 1).show();
					Communication.instance.getshop(Constant.userName);
				} else if (message.arg1 == Config.FAIl) {
					//Toast.makeText(this, "购买失败!", 1).show();
				}
				break;
			default:
				break;
			}

		}
		
		@SuppressLint("ShowToast")
		@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if(keyCode == KeyEvent.KEYCODE_BACK ){
				//Toast.makeText(Shangcheng.this, "返回到游戏大厅  ! !", 1000).show();
				finish();
				return true;
			}
			return super.onKeyDown(keyCode, event);
		}


}
