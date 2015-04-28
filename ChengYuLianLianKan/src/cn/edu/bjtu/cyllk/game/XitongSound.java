package cn.edu.bjtu.cyllk.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.business.BaseActivity;
import cn.edu.bjtu.cyllk.business.SoundPlayer;
import cn.edu.bjtu.cyllk.global.Constant;

public class XitongSound extends BaseActivity {
	ImageView imageView1, imageView2;
	ImageButton button1, button2, button3, button4;
	boolean flag = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);// ȫ��
		requestWindowFeature(Window.FEATURE_NO_TITLE);// û�б�����
		setContentView(R.layout.xitong_sound);

		imageView1 = (ImageView) findViewById(R.id.shengyin);
		imageView1 = (ImageView) findViewById(R.id.yinxiao);

		button3 = (ImageButton) findViewById(R.id.yinxiaoButton);
		button4 = (ImageButton) findViewById(R.id.gerenButton);

		// Ϊ�������ư�ť��Ӽ���
		button1 = (ImageButton) findViewById(R.id.switchButton1);
		button2 = (ImageButton) findViewById(R.id.switchButton2);
		if (Constant.musicSt)
			button1.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.option_sound_switch_open));
		else
			button1.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.option_sound_switch_close));
		if (Constant.soundSt)
			button2.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.option_sound_switch_open));
		else
			button2.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.option_sound_switch_close));

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				// �����ͼ����
				if (Constant.musicSt) {
					button1.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.option_sound_switch_close));
					Constant.musicSt = false;
					SoundPlayer.pauseMusic();
				} else {
					button1.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.option_sound_switch_open));
					Constant.musicSt = true;
					SoundPlayer.startMusic();
				}
				// ������ر������ֲ���
			}
		});
		// if(Constant.musicSt==true){
		// SoundPlayer.startMusic();}
		// else{
		// SoundPlayer.pauseMusic();}

		// Ϊ��Ч���ư�ť��Ӽ���
		button2 = (ImageButton) findViewById(R.id.switchButton2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				// �����ͼ����������Ч����
				if (Constant.soundSt == true) {
					button2.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.option_sound_switch_close));
					Constant.soundSt = false;
				} else {
					button2.setBackgroundDrawable(getResources().getDrawable(
							R.drawable.option_sound_switch_open));
					Constant.soundSt = true;
				}
			}
		});
		// Ϊ�鿴��Ϣ��ť��Ӽ��
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				finish();
				Intent intent = new Intent(XitongSound.this, XitongXinxi.class);
				Bundle bundle = new Bundle(); // ������ʵ����һ��Bundle����
				intent.putExtras(bundle); // ��Bundle������ӵ�Intent������
				startActivity(intent); // �����µ�Activity
			}
		});
	}

	@Override
	public void processMessage(Message message) {
		// TODO Auto-generated method stub

	}

}