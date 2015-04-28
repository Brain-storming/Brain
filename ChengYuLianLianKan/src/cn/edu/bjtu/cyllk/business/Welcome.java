package cn.edu.bjtu.cyllk.business;

import cn.edu.bjtu.cyllk.R;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Welcome extends Activity {

	private ImageView iv_cyllk, iv_process_circle;// 欢迎页中成语连连看图片和加载圆环图片
	private AnimationDrawable ad_cyllk, ad_process_circle;// 欢迎页中成语连连看动画和加载圆环动画

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);

		DrawAnimation();// 绘制动画
		OneMoreSecond();// 等待欢迎动画结束并跳转至登录页
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		ad_cyllk.start();
		ad_process_circle.start();
	}

	private void DrawAnimation() {
		iv_cyllk = (ImageView) findViewById(R.id.main_cyllk);
		iv_process_circle = (ImageView) findViewById(R.id.main_process_circle);
		ad_cyllk = (AnimationDrawable) iv_cyllk.getBackground();
		ad_process_circle = (AnimationDrawable) iv_process_circle
				.getBackground();
	}

	private void OneMoreSecond() {
		final Timer time_intent = new Timer();
		TimerTask tt_intent = new TimerTask() {
			public void run() {
				GoNext(Welcome.this, Login.class);
				time_intent.cancel();
			}
		};
		time_intent.schedule(tt_intent, 1000);
	}

	private void GoNext(Context con, Class<?> cls) {
		Intent intent = new Intent();
		intent.setClass(con, cls);
		finish();// 结束欢迎页
		startActivity(intent);
	}
}
