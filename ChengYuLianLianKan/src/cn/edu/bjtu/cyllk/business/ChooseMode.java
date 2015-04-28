package cn.edu.bjtu.cyllk.business;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.game.Bangzhu;
import cn.edu.bjtu.cyllk.game.Shangcheng;
import cn.edu.bjtu.cyllk.game.XitongSound;
import cn.edu.bjtu.cyllk.game.XlxfMode;
import cn.edu.bjtu.cyllk.game.ZfdmGame;
import cn.edu.bjtu.cyllk.game.ZzsfGame;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;

public class ChooseMode extends Activity {

	ImageView imageView1;
	AnimationDrawable animationDrawable1;
	ImageView zfdmView, xlxfView, zzsfView, playerlistView, xitongView,
			shangchengView, fanhuiView, bangzhuView;
	private int isPlaying = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.choose_mode);
		init();

		SoundPlayer.init(ChooseMode.this);

		if (Constant.musicSt == true) {
			SoundPlayer.startMusic();
		}
		// 为争分夺秒view添加监听
		zfdmView = (ImageView) findViewById(R.id.choose_mode_zfdm);
		zfdmView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, ZfdmGame.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为狭路相逢添加监听
		xlxfView = (ImageView) findViewById(R.id.choose_mode_xlxf);
		xlxfView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, XlxfMode.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为征战四方添加监听
		zzsfView = (ImageView) findViewById(R.id.choose_mode_zzsf);
		zzsfView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, ZzsfGame.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为玩家列表view添加监听
		playerlistView = (ImageView) findViewById(R.id.choose_mode_friendlist);
		playerlistView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Constant.playerol_list.clear();
				Communication.instance.getPlayerList();
				Intent intent = new Intent(ChooseMode.this, PlayerList.class);
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为系统view添加监听
		xitongView = (ImageView) findViewById(R.id.choose_mode_xitong);
		xitongView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, XitongSound.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为商城view添加监听
		shangchengView = (ImageView) findViewById(R.id.choose_mode_shangcheng);
		shangchengView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, Shangcheng.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为帮助view添加监听
		bangzhuView = (ImageView) findViewById(R.id.choose_mode_bangzhu);
		bangzhuView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Intent intent = new Intent(ChooseMode.this, Bangzhu.class);
				Bundle bundle = new Bundle(); // 创建并实例化一个Bundle对象
				intent.putExtras(bundle); // 将Bundle对象添加到Intent对象中
				startActivity(intent); // 启动新的Activity
			}
		});
		// 为返回view添加监听
		fanhuiView = (ImageView) findViewById(R.id.choose_mode_fanhui);
		fanhuiView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				dialog();
			}
		});

	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(ChooseMode.this);
		builder.setMessage("确定要退出吗?");
		builder.setTitle("提示");
		if (Constant.musicSt == true) {
			System.out.println("进入修改isPlaying!!!!");
			isPlaying = 1;
			SoundPlayer.pauseMusic();
			Constant.musicSt = false;
		}

		builder.setPositiveButton("确认",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Communication.instance.exitGame();
						Communication.instance.clear();
						dialog.dismiss();
						ChooseMode.this.finish();

						android.os.Process.killProcess(android.os.Process
								.myPid());
					}
				});
		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (isPlaying == 1) {
							SoundPlayer.startMusic();
							Constant.musicSt = true;
						}
						dialog.dismiss();

					}
				});
		builder.create().show();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			dialog();
			return false;
		}
		return false;
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		animationDrawable1.start();
	}

	private void init() {
		imageView1 = (ImageView) findViewById(R.id.choose_mode_modeanima);
		animationDrawable1 = (AnimationDrawable) imageView1.getBackground();
	}
}
