package cn.edu.bjtu.cyllk.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends BaseActivity {

	private ImageView iv_cyllkol;
	private AnimationDrawable ad_cyllkol;

	private EditText et_username, et_pwd, et_repwd;
	private ImageButton ib_confirm, ib_cancel;
	private String str_hint_username, str_hint_pwd, str_hint_repwd;
	private String str_username, str_pwd, str_repwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		SoundPlayer.init(Register.this);
		DrawAnimation();
		InitComponents();
		GetHintOfETs();
		SetInputListeners();
		Communication.newInstance();
		SetFuncButtonListeners();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		ad_cyllkol.start();
	}

	private void DrawAnimation() {
		iv_cyllkol = (ImageView) findViewById(R.id.reg_cyllkol);
		ad_cyllkol = (AnimationDrawable) iv_cyllkol.getBackground();
	}

	private void InitComponents() {
		et_username = (EditText) findViewById(R.id.reg_username);
		et_pwd = (EditText) findViewById(R.id.reg_pwd);
		et_repwd = (EditText) findViewById(R.id.reg_repwd);
		ib_confirm = (ImageButton) findViewById(R.id.reg_confirm);
		ib_cancel = (ImageButton) findViewById(R.id.reg_cancel);
	}

	private void GetHintOfETs() {
		str_hint_username = et_username.getHint().toString();
		str_hint_pwd = et_pwd.getHint().toString();
		str_hint_repwd = et_repwd.getHint().toString();
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
						Toast.makeText(Register.this, "用户名只能包含数字、英文字母和中文字符",
								Toast.LENGTH_SHORT).show();
						et_username.requestFocus();
					}

				} else {
					et_pwd.setHint(str_hint_pwd);
				}
			}
		});
		et_repwd.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					et_repwd.setHint(null);
					String tempUsername = et_username.getText().toString();
					if (!InputNotNull(tempUsername)) {
						;
					} else if (!CheckUserName(tempUsername)) {
						Toast.makeText(Register.this, "用户名只能包含数字、英文字母和中文字符",
								Toast.LENGTH_SHORT).show();
						et_username.requestFocus();
					}
				} else {
					et_repwd.setHint(str_hint_repwd);
				}
			}
		});
	}

	@SuppressLint("ShowToast")
	private void SetFuncButtonListeners() {
		ib_confirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				GetInfoFromETs();

				if (!InputNotNull(str_username) && !InputNotNull(str_pwd)) {
					Toast.makeText(Register.this, "用户名、密码不能为空",
							Toast.LENGTH_SHORT).show();
				} else if (!InputNotNull(str_username)) {
					Toast.makeText(Register.this, "用户名不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (!CheckUserName(str_username)) {
					Toast.makeText(Register.this, "用户名只能包含数字、英文字母和中文字符",
							Toast.LENGTH_SHORT).show();
				} else if (!InputNotNull(str_pwd)) {
					Toast.makeText(Register.this, "密码不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (!pwdSame()) {
					Toast.makeText(Register.this, "两次输入的密码不一致",
							Toast.LENGTH_SHORT).show();
				} else {
					Communication.instance.register(str_username, str_pwd);
				}
			}
		});

		ib_cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				finish();
			}
		});
	}

	private void GetInfoFromETs() {
		str_username = et_username.getText().toString();
		str_pwd = et_pwd.getText().toString();
		str_repwd = et_repwd.getText().toString();
	}

	private boolean pwdSame() {
		if (str_repwd.equals(str_pwd)) {
			return true;
		} else {
			return false;
		}
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
		case Config.REQUEST_REGISTER:
			int result = msg.arg1;
			if (result == Config.SUCCESS) {
				Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT)
						.show();
				Constant.userName = str_username;
				Constant.userPassword = str_pwd;
				msg = null;
				GoNext(Register.this, Login.class);
			} else {
				Toast.makeText(Register.this, "注册失败", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		default:
			break;
		}
	}

	private void GoNext(Context con, Class<?> cls) {
		Constant.reg_username = str_username;
		Constant.reg_password = str_pwd;
		Intent intent = new Intent(con, cls);
		finish();
		startActivity(intent);
	}
}
