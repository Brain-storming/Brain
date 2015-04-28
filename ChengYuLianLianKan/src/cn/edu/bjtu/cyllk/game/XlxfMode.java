package cn.edu.bjtu.cyllk.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.business.PlayerList;
import cn.edu.bjtu.cyllk.business.SoundPlayer;
import cn.edu.bjtu.cyllk.global.Constant;

public class XlxfMode extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 全屏设置
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 添加布局
		setContentView(R.layout.xlxf_mode);

		// 为快速开始view添加监听
		ImageView quickStartView = (ImageView) findViewById(R.id.xlxf_quickstart_imageView);
		quickStartView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(XlxfMode.this, XlxfGame.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				finish();

				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity

			}
		});
		// 为选择好友view添加监听
		ImageView xuanzehaoyouView = (ImageView) findViewById(R.id.xlxf_xuanzehaoyou_imageView);
		xuanzehaoyouView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(XlxfMode.this, PlayerList.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				finish();
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});

		// 为返回view添加监听
		ImageView fanhuiView = (ImageView) findViewById(R.id.xlxf_fanhui_imageView);
		fanhuiView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				XlxfMode.this.finish();
			}
		});
	}

}
