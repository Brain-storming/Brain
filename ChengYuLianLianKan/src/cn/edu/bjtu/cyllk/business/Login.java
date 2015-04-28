package cn.edu.bjtu.cyllk.business;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends BaseActivity {

	private ImageView iv_cyllkol;// 登录页中成语连连看OL图片
	private AnimationDrawable ad_cyllkol;// 登录页中成语连连看OL动画
	private ImageButton ib_login, ib_qklogin, ib_register;// 登录页中图片按钮：登录、快速登录、新手注册
	private EditText et_username, et_pwd;// 登录页中输入框：用户名、密码
	private String str_hint_username, str_hint_pwd;// 登录页中输入框内的提示信息
	private String str_username, str_pwd;
	private Handler handler;

	
	@SuppressLint("ShowToast")
	private Runnable runnable1 = new Runnable() {

		@Override
		public void run() {
			Toast.makeText(Login.this, "已将用户名、密码截图保存至SD卡", Toast.LENGTH_SHORT)
					.show();
			et_pwd.setInputType(InputType.TYPE_CLASS_TEXT
					| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
	};

	@SuppressLint("ShowToast")
	private Runnable runnable2 = new Runnable() {

		@Override
		public void run() {
			GetInfoFromETs();
			Communication.instance.register(str_username, str_pwd);
			Communication.instance.login(str_username, str_pwd);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		SoundPlayer.init(Login.this);
		SoundPlayer.startMusic();
		DrawAnimation();
		InitComponents();
		GetHintOfETs();
		SetInputListeners();
		Communication.newInstance();
		handler = new Handler();
		SetFuncButtonListeners();
		GetInfoFromReg();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		ad_cyllkol.start();
	}

	private void DrawAnimation() {
		iv_cyllkol = (ImageView) findViewById(R.id.login_cyllkol);
		ad_cyllkol = (AnimationDrawable) iv_cyllkol.getBackground();
	}

	private void InitComponents() {
		et_username = (EditText) findViewById(R.id.login_username);
		et_pwd = (EditText) findViewById(R.id.login_pwd);
		ib_login = (ImageButton) findViewById(R.id.login_login);
		ib_qklogin = (ImageButton) findViewById(R.id.login_qklogin);
		ib_register = (ImageButton) findViewById(R.id.login_register);
	}

	private void GetHintOfETs() {
		str_hint_username = et_username.getHint().toString();
		str_hint_pwd = et_pwd.getHint().toString();
	}

	@SuppressLint("ShowToast")
	private void SetInputListeners() {
		et_username.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					et_username.setHint(null);
				} else {
					et_username.setHint(str_hint_username);
				}
			}
		});
		et_pwd.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					et_pwd.setHint(null);
					String tempUsername = et_username.getText().toString();
					if (!InputNotNull(tempUsername)) {
						;
					} else if (!CheckUserName(tempUsername)) {
						Toast.makeText(Login.this, "用户名只能包含数字、英文字母和中文字符", 10)
								.show();
						et_username.requestFocus();
					}

				} else {
					et_pwd.setHint(str_hint_pwd);
				}
			}
		});

	}

	@SuppressLint("ShowToast")
	private void SetFuncButtonListeners() {
		ib_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				GetInfoFromETs();
				if (!InputNotNull(str_username) && !InputNotNull(str_pwd)) {
					Toast.makeText(Login.this, "用户名、密码不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (!InputNotNull(str_username)) {
					Toast.makeText(Login.this, "用户名不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (!CheckUserName(str_username)) {
					Toast.makeText(Login.this, "用户名只能包含数字、英文字母和中文字符",
							Toast.LENGTH_SHORT).show();
				} else if (!InputNotNull(str_pwd)) {
					Toast.makeText(Login.this, "密码不能为空", Toast.LENGTH_SHORT)
							.show();
				} else {
					Communication.instance.login(str_username, str_pwd);
				}

			}
		});

		ib_qklogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				QkLogin(v);
			}
		});
		ib_register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				GetInfoFromETs();
				Intent intent = new Intent(Login.this, Register.class);
				finish();
				startActivity(intent);
			}
		});
	}

	private boolean CheckUserName(String username) {
		String regex = "([a-z]|[A-Z]|[0-9]|[\\u4e00-\\u9fa5])+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(username);
		return m.matches();
	}

	private boolean InputNotNull(String input) {
		if (input == "" || input.equals("") || input.equals(null)) {
			return false;
		}
		return true;
	}

	@SuppressLint("ShowToast")
	public void processMessage(Message msg) {
		switch (msg.what) {
		case Config.REQUEST_LOGIN:
			int result = msg.arg1;
			if (result == Config.SUCCESS) {
				Toast.makeText(Login.this, "欢迎回来，" + str_username,
						Toast.LENGTH_SHORT).show();
				Constant.userName = str_username;
				Constant.userPassword = str_pwd;
				SoundPlayer.stopMusic();
				GoNext(Login.this, ChooseMode.class);
				msg = null;
			} else {
				Toast.makeText(Login.this, "登录失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case Config.REQUEST_EXIT:
			;
			break;
		default:
			break;
		}
	}

	private void GetInfoFromETs() {
		str_username = et_username.getText().toString();
		str_pwd = et_pwd.getText().toString();
	}

	private void GetInfoFromReg() {
		if (InputNotNull(Constant.reg_username)
				&& InputNotNull(Constant.reg_password)) {
			et_username.setText(Constant.reg_username);
			et_pwd.setText(Constant.reg_password);
		}
	}

	@SuppressLint("ShowToast")
	private void QkLogin(View v) {
		v = findViewById(R.id.login_un_pw);
		et_username.setText(GetComplexUsername(6));
		et_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
		et_pwd.setText(GetNumPassword(6));
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd_HH-mm-ss",
				Locale.CHINA);
		String fname = "/storage/sdcard1/" + "成语连连看-" + sdf.format(new Date())
				+ ".png";
		v.setDrawingCacheEnabled(true);
		Bitmap bitmap = v.getDrawingCache();
		if (bitmap != null) {

			try {
				FileOutputStream out = new FileOutputStream(fname);
				bitmap.compress(Bitmap.CompressFormat.PNG, 1, out);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			;
		}

		new Thread() {
			public void run() {
				try {
					sleep(1000);
					handler.post(runnable1);
					sleep(2000);
					handler.post(runnable2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			};
		}.start();

	}

	private static String GetRandomString(int count, boolean letters,
			boolean numbers) {
		return org.apache.commons.lang.RandomStringUtils.random(count, letters,
				numbers);
	}

	private static String GetComplexUsername(int count) {
		return GetRandomString(count, true, true);
	}

	private static String GetNumPassword(int count) {
		return GetRandomString(count, false, true);
	}

	private void GoNext(Context con, Class<?> cls) {
		Intent intent = new Intent(con, cls);
		finish();
		startActivity(intent);
	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(Login.this);
		builder.setMessage("确定要退出吗?");
		builder.setTitle("提示");
		builder.setPositiveButton("确认",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Communication.instance.clear();
						dialog.dismiss();
						Login.this.finish();

						android.os.Process.killProcess(android.os.Process
								.myPid());

					}
				});
		builder.setNegativeButton("取消",
				new android.content.DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
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
}
