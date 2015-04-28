package cn.edu.bjtu.cyllk.game;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.business.SoundPlayer;
import cn.edu.bjtu.cyllk.global.Constant;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class XitongXinxi extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 全屏设置
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 添加布局
		setContentView(R.layout.xitong_jilu);

		ImageButton soundButton = (ImageButton) findViewById(R.id.xtxx_musicoption);
		soundButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				finish();
				Intent intent = new Intent(XitongXinxi.this, XitongSound.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
	}

}
