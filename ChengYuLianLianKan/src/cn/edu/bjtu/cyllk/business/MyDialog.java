package cn.edu.bjtu.cyllk.business;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.global.Constant;

public class MyDialog extends Dialog {

	Context context;
	private TextView tv_playername, tv_playerscore, tv_deng, tv_ka;

	public MyDialog(Context context) {
		super(context);
		this.context = context;
	}

	public MyDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.playerinfo);
		tv_playername = (TextView) findViewById(R.id.info_playername);
		tv_playername.setText(Constant.info_name);
		tv_playerscore = (TextView) findViewById(R.id.info_score);
		tv_playerscore.setText(Constant.info_score);
		tv_deng = (TextView) findViewById(R.id.info_deng);
		tv_ka = (TextView) findViewById(R.id.info_ka);
		tv_deng.setText(String.valueOf(Constant.info_deng));
		tv_ka.setText(String.valueOf(Constant.info_ka));
	}
}
