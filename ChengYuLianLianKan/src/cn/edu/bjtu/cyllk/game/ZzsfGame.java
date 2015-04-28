package cn.edu.bjtu.cyllk.game;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.business.BaseActivity;
import cn.edu.bjtu.cyllk.business.SoundPlayer;
import cn.edu.bjtu.cyllk.global.Chengyu;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ZzsfGame extends BaseActivity {

	TextView textView[] = new TextView[36];
	TextView xianshiView;
	String returnValue[] = new String[36];
	String touchChengyu = "";
	Handler handler = null;
	Button shijianButton, guankaButton, jishuButton;
	Handler timeHandler = new Handler();
	Handler guankaHandler = new Handler();
	int jishu = 0;
	int flag = 0;
	int recLen = 0;
	int[] record = new int[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		;
		// ��Ӳ���
		setContentView(R.layout.zzsf_game);

		handler = new Handler();

		AssetManager mgr = getAssets();
		Typeface tf = Typeface.createFromAsset(mgr, "fonts/MSYHBD.TTF");

		Communication con = Communication.newInstance();
		con.getChengYu(9);

		shijianButton = (Button) findViewById(R.id.zzsf_shijian);
		guankaButton = (Button) findViewById(R.id.zzsf_xuanguan);
		jishuButton = (Button) findViewById(R.id.zzsf_jishu);

		shijianButton.setTextColor(Color.RED);
		timeHandler.postDelayed(runnableTimeUi, 1000);
		guankaButton.setText("��" + Constant.guanka + "��");
		jishuButton.setText("��" + jishu + "��");

		textView[0] = (TextView) findViewById(R.id.textView1);
		textView[1] = (TextView) findViewById(R.id.textView2);
		textView[2] = (TextView) findViewById(R.id.textView3);
		textView[3] = (TextView) findViewById(R.id.textView4);
		textView[4] = (TextView) findViewById(R.id.textView5);
		textView[5] = (TextView) findViewById(R.id.textView6);
		textView[6] = (TextView) findViewById(R.id.textView7);
		textView[7] = (TextView) findViewById(R.id.textView8);
		textView[8] = (TextView) findViewById(R.id.textView9);
		textView[9] = (TextView) findViewById(R.id.textView10);
		textView[10] = (TextView) findViewById(R.id.textView11);
		textView[11] = (TextView) findViewById(R.id.textView12);
		textView[12] = (TextView) findViewById(R.id.textView13);
		textView[13] = (TextView) findViewById(R.id.textView14);
		textView[14] = (TextView) findViewById(R.id.textView15);
		textView[15] = (TextView) findViewById(R.id.textView16);
		textView[16] = (TextView) findViewById(R.id.textView17);
		textView[17] = (TextView) findViewById(R.id.textView18);
		textView[18] = (TextView) findViewById(R.id.textView19);
		textView[19] = (TextView) findViewById(R.id.textView20);
		textView[20] = (TextView) findViewById(R.id.textView21);
		textView[21] = (TextView) findViewById(R.id.textView22);
		textView[22] = (TextView) findViewById(R.id.textView23);
		textView[23] = (TextView) findViewById(R.id.textView24);
		textView[24] = (TextView) findViewById(R.id.textView25);
		textView[25] = (TextView) findViewById(R.id.textView26);
		textView[26] = (TextView) findViewById(R.id.textView27);
		textView[27] = (TextView) findViewById(R.id.textView28);
		textView[28] = (TextView) findViewById(R.id.textView29);
		textView[29] = (TextView) findViewById(R.id.textView30);
		textView[30] = (TextView) findViewById(R.id.textView31);
		textView[31] = (TextView) findViewById(R.id.textView32);
		textView[32] = (TextView) findViewById(R.id.textView33);
		textView[33] = (TextView) findViewById(R.id.textView34);
		textView[34] = (TextView) findViewById(R.id.textView35);
		textView[35] = (TextView) findViewById(R.id.textView36);

		xianshiView = (TextView) findViewById(R.id.zzsf_xianshi);

		// ��������
		for (int i = 0; i < textView.length; i++) {
			textView[i].setTypeface(tf);
		}
		// ��Ӽ���
		for (int i = 0; i < textView.length; i++) {
			setTouchListener(i);
		}

	}

	// �õ������textview����ɫ
	private void setTouchListener(final int num) {
		textView[num].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if ((textView[num].getText() != "") && !zaibuzai2(record, num)) {
					if (Constant.soundSt == true) {
						SoundPlayer.playsound(R.raw.dianji_music);
					}
					textView[num].setTextColor(Color.BLUE);
					touchChengyu += textView[num].getText();
					record[flag] = num;
					flag++;
					System.out.println("touchchengyu  ��:::::" + touchChengyu
							+ "\n  flag��" + flag + "num  ��" + num);
					// ����������Ƿ�ﵽ�ĸ�
					if (flag == 4) {
						System.out.println("�����ĳ����ǣ�" + touchChengyu);
						if (Chengyu.check(touchChengyu)) {
							System.out.println("���������ȷ��");
							// ���¼���
							jishu++;
							jishuButton.setText("��" + jishu + "��");
							// ���¹ؿ�
							if (jishu == 9) {
								new AlertDialog.Builder(ZzsfGame.this)
										.setMessage("��ϲ���أ�����������һ��").show();
								new Thread() {
									public void run() {
										try {
											sleep(3000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										guankaHandler.post(runnableGuankaUi);
									}
								}.start();
							}
							// ��ȥ���textview�еĺ���
							for (int i = 0; i < 4; i++) {
								textView[record[i]].setText("");
								xianshiView.setText("�ҵ��ĳ����ǣ�" + touchChengyu);
							}
							// for (int i = 0; i < 8; i++) {
							// waigua();
							// }
						} else {
							if (Constant.soundSt == true) {
								SoundPlayer.playsound(R.raw.cuowu_music);
							}
							System.out.println("����������");
							xianshiView.setText("���Դ��ĵĶ�B�����ǣ�" + touchChengyu);
							// ��ɫ���textview�еĺ���
							new Thread() {
								public void run() {
									try {
										handler.post(runnableUi1);
										sleep(200);
										handler.post(runnableUi2);
										sleep(200);
										handler.post(runnableUi1);
										sleep(200);
										handler.post(runnableUi2);
										sleep(400);
										// ��ʼ��record
										for (int i = 0; i < 4; i++) {
											record[i] = -1;
										}
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}.start();

						}

						touchChengyu = "";
						flag = 0;
					}
				} else {
					if ((textView[num].getText() != "")
							&& (num == record[flag - 1])) {
						if (Constant.soundSt == true) {
							SoundPlayer.playsound(R.raw.quxiao_music);
						}
						flag--;
						textView[num].setTextColor(Color.BLACK);
						System.out.println("touchchengyu û��֮ǰ ��:::::"
								+ touchChengyu);
						touchChengyu = touchChengyu.substring(0,
								touchChengyu.length() - 1);
						record[flag] = -1;
						System.out.println("touchchengyu  ��:::::"
								+ touchChengyu + "\n  flag  ��" + flag);
						System.out.println("��������");
					}
				}

			}
		});
	}

	// ���������ص���Ϣ���д���
	@Override
	public void processMessage(Message msg) {
		// TODO Auto-generated method stub
		System.out.println("��������������");
		switch (msg.what) {
		case Config.REQUEST_GET_SUBJECT:
			JSONArray ja = (JSONArray) msg.obj;
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < ja.length(); i++) {
				list.add(ja.optString(i));
			}
			Chengyu.save(list);
			System.out.println("��tmҪ����ť��ֵ����");
			String[] str = Chengyu.changeChengyu(list);
			for (int i = 0; i < str.length; i++) {
				textView[i].setText(str[i]);
			}

			// time.setBase(SystemClock.elapsedRealtime());
			// time.start();

			break;
		}
	}

	// ����Runnable������runnable�и��½���
	Runnable runnableUi1 = new Runnable() {
		@Override
		public void run() {
			// ���½���
			textView[record[0]].setTextColor(Color.RED);
			textView[record[1]].setTextColor(Color.RED);
			textView[record[2]].setTextColor(Color.RED);
			textView[record[3]].setTextColor(Color.RED);
		}

	};
	Runnable runnableUi2 = new Runnable() {
		@Override
		public void run() {
			// ���½���
			textView[record[0]].setTextColor(Color.BLACK);
			textView[record[1]].setTextColor(Color.BLACK);
			textView[record[2]].setTextColor(Color.BLACK);
			textView[record[3]].setTextColor(Color.BLACK);
		}

	};
	// ��ʱ��
	Runnable runnableTimeUi = new Runnable() {
		@Override
		public void run() {
			recLen++;
			shijianButton.setText("" + recLen);
			timeHandler.postDelayed(this, 1000);
		}
	};
	// ���¹ؿ�
	Runnable runnableGuankaUi = new Runnable() {
		@Override
		public void run() {
			Constant.guanka++;
			guankaButton.setText("��" + Constant.guanka + "��");
			finish();
			Intent intent = new Intent(ZzsfGame.this, ZzsfGame.class);
			startActivity(intent);

		}
	};

	public void waigua() {
		String[] str = Chengyu.chengyuToString(Constant.list);
		String[] textViewStrings = new String[str.length];
		System.out.println("���������ҵ��ز��ǣ�");
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}
		System.out.println();
		for (int i = 0; i < textViewStrings.length; i++) {
			textViewStrings[i] = textView[i].getText().toString();
		}
		System.out.println("textView�е�Ԫ����");
		for (int i = 0; i < textViewStrings.length; i++) {
			System.out.print(textViewStrings[i]);
		}
		System.out.println();

		for (int i = 0; i < str.length; i += 4) {
			if (zaibuzai(textViewStrings, str[i])
					&& zaibuzai(textViewStrings, str[i + 1])
					&& zaibuzai(textViewStrings, str[i + 2])
					&& zaibuzai(textViewStrings, str[i + 3])) {
				System.out.println("���Ҫ��ȥ�ĳ�����"
						+ textView[xiabiao(textViewStrings, str[i])].getText()
						+ textView[xiabiao(textViewStrings, str[i + 1])]
								.getText()
						+ textView[xiabiao(textViewStrings, str[i + 2])]
								.getText()
						+ textView[xiabiao(textViewStrings, str[i + 3])]
								.getText());
				textView[xiabiao(textViewStrings, str[i])].setText("");
				textView[xiabiao(textViewStrings, str[i + 1])].setText("");
				textView[xiabiao(textViewStrings, str[i + 2])].setText("");
				textView[xiabiao(textViewStrings, str[i + 3])].setText("");

				for (int j = 0; j < textViewStrings.length; j++) {
					textViewStrings[j] = textView[j].getText().toString();
				}

				if ((xiabiao(textViewStrings, str[i]) == xiabiao(
						textViewStrings, str[i + 1]))
						&& (xiabiao(textViewStrings, str[i]) != -1)) {
					System.out.println("������ͬ������i,i+1"
							+ xiabiao(textViewStrings, str[i]) + ","
							+ xiabiao(textViewStrings, str[i + 1]));
					textView[xiabiao(textViewStrings, str[i + 1])].setText("");
				}
				if (xiabiao(textViewStrings, str[i]) == xiabiao(
						textViewStrings, str[i + 2])
						&& xiabiao(textViewStrings, str[i]) != -1) {
					System.out.println("������ͬ����!i,i+2"
							+ xiabiao(textViewStrings, str[i]) + ","
							+ xiabiao(textViewStrings, str[i + 2]));
					textView[xiabiao(textViewStrings, str[i + 2])].setText("");
				}
				if (xiabiao(textViewStrings, str[i]) == xiabiao(
						textViewStrings, str[i + 3])
						&& xiabiao(textViewStrings, str[i]) != -1) {
					System.out.println("������ͬ������i,i+3"
							+ xiabiao(textViewStrings, str[i]) + ","
							+ xiabiao(textViewStrings, str[i + 3]));
					textView[xiabiao(textViewStrings, str[i + 3])].setText("");
				}
				if (xiabiao(textViewStrings, str[i + 1]) == xiabiao(
						textViewStrings, str[i + 2])
						&& xiabiao(textViewStrings, str[i + 1]) != -1) {
					System.out.println("������ͬ������i+1,i+2"
							+ xiabiao(textViewStrings, str[i + 1]) + ","
							+ xiabiao(textViewStrings, str[i + 2]));
					textView[xiabiao(textViewStrings, str[i + 2])].setText("");
				}
				if (xiabiao(textViewStrings, str[i + 1]) == xiabiao(
						textViewStrings, str[i + 3])
						&& xiabiao(textViewStrings, str[i + 1]) != -1) {
					System.out.println("������ͬ������i+1,i+3"
							+ xiabiao(textViewStrings, str[i + 1]) + ","
							+ xiabiao(textViewStrings, str[i + 3]));
					textView[xiabiao(textViewStrings, str[i + 3])].setText("");
				}
				if (xiabiao(textViewStrings, str[i + 2]) == xiabiao(
						textViewStrings, str[i + 3])
						&& xiabiao(textViewStrings, str[i + 2]) != -1) {
					System.out.println("������ͬ������i+2,i+3"
							+ xiabiao(textViewStrings, str[i + 2]) + ","
							+ xiabiao(textViewStrings, str[i + 3]));
					textView[xiabiao(textViewStrings, str[i + 3])].setText("");
				}

				break;
			} else {
				System.out.println("��ҹ���ʧ��= =��");
			}
		}
		System.out.println("����Ѿ�������һ�Σ�");
		// textView[2].performClick();
	}

	private int xiabiao(String[] strArray, String str) {

		for (int i = 0; i < strArray.length; i++) {
			if (str.equals(strArray[i])) {
				return i;
			}
		}

		return -1;
	}

	private boolean zaibuzai(String[] strArray, String str) {

		for (int i = 0; i < strArray.length; i++) {
			if (str.equals(strArray[i])) {
				return true;
			}
		}
		return false;

	}

	private boolean zaibuzai2(int[] intArray, int num) {

		for (int i = 0; i < intArray.length; i++) {
			if (num == intArray[i]) {
				return true;
			}
		}
		return false;

	}
}
