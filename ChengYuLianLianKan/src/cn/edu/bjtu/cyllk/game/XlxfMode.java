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
		// ȫ������
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ��Ӳ���
		setContentView(R.layout.xlxf_mode);

		// Ϊ���ٿ�ʼview��Ӽ���
		ImageView quickStartView = (ImageView) findViewById(R.id.xlxf_quickstart_imageView);
		quickStartView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(XlxfMode.this, XlxfGame.class);
				Bundle bundle = new Bundle(); // ������ʵ����һ��Bundle����
				finish();

				intent.putExtras(bundle); // ��Bundle������ӵ�Intent������
				startActivity(intent); // �����µ�Activity

			}
		});
		// Ϊѡ�����view��Ӽ���
		ImageView xuanzehaoyouView = (ImageView) findViewById(R.id.xlxf_xuanzehaoyou_imageView);
		xuanzehaoyouView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(XlxfMode.this, PlayerList.class);
				Bundle bundle = new Bundle(); // ������ʵ����һ��Bundle����
				finish();
				intent.putExtras(bundle); // ��Bundle������ӵ�Intent������
				startActivity(intent); // �����µ�Activity
			}
		});

		// Ϊ����view��Ӽ���
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
