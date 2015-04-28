package cn.edu.bjtu.cyllk.business;

import cn.edu.bjtu.cyllk.R;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;
import cn.edu.bjtu.cyllk.network.Communication;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.ContextMenu;
import android.view.View.OnCreateContextMenuListener;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class PlayerList extends BaseActivity {

	private AssetManager mgr;
	private Typeface tf;
	private TextView title_player_name, title_player_rank, title_player_mani;
	private ListView lv_playerollist;
	private ImageButton ib_refresh, ib_return, ib_friendlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.playerlist);

		InitComponents();

		Communication.newInstance();

		SetFuncButtonListeners();

		lv_playerollist
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View arg1, int arg2, long arg3) {

						TextView tv_playername = (TextView) arg1
								.findViewById(R.id.player_name);
						Constant.info_name = tv_playername.getText().toString();
						TextView tv_playerscore = (TextView) arg1
								.findViewById(R.id.player_rank);
						Constant.info_score = tv_playerscore.getText()
								.toString();

						Communication.instance.getshop(Constant.info_name);

						lv_playerollist
								.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {

									@Override
									public void onCreateContextMenu(
											ContextMenu arg0, View arg1,
											ContextMenuInfo arg2) {
										arg0.setHeaderTitle("操作");
										arg0.add(0, 0, 0, "查看玩家信息");
										arg0.add(0, 1, 0, "邀请对战");
									}
								});
						return false;
					}

				});

		SimpleAdapter sa = new SimpleAdapter(this, Constant.playerol_list,
				R.layout.playerollist_item, new String[] { "username", "score",
						"add" }, new int[] { R.id.player_name,
						R.id.player_rank, R.id.player_mani }) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				final View view = super.getView(position, convertView, parent);
				ImageButton ib_add = (ImageButton) view
						.findViewById(R.id.player_mani);
				TextView tv_playername = (TextView) view
						.findViewById(R.id.player_name);
				final String str_playername = tv_playername.getText()
						.toString();
				ib_add.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						Communication.instance.addFriend(str_playername);
					}
				});
				return view;
			}
		};

		lv_playerollist.setAdapter(sa);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:

			Dialog dialog = new MyDialog(PlayerList.this, R.style.MyDialog);
			dialog.show();

			break;
		case 1:
			// Toast.makeText(PlayerList.this, "Test 1", 100).show();
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

	private void SetFuncButtonListeners() {
		ib_friendlist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Constant.friend_list.clear();
				Communication.instance.getFriendlist();
				GoNext(PlayerList.this, FriendList.class);
			}
		});
		ib_return.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				finish();
			}
		});
		ib_refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (Constant.soundSt == true) {
					SoundPlayer.playsound(R.raw.bt_music);
				}
				Constant.playerol_list.clear();
				Communication.instance.getPlayerList();
				GoNext(PlayerList.this, PlayerList.class);
			}
		});
	}

	private void InitComponents() {
		mgr = getAssets();
		tf = Typeface.createFromAsset(mgr, "fonts/STLITI.TTF");
		title_player_name = (TextView) findViewById(R.id.title_player_name);
		title_player_rank = (TextView) findViewById(R.id.title_player_rank);
		title_player_mani = (TextView) findViewById(R.id.title_player_mani);
		title_player_name.setTypeface(tf);
		title_player_rank.setTypeface(tf);
		title_player_mani.setTypeface(tf);
		lv_playerollist = (ListView) findViewById(R.id.playerollist);
		ib_friendlist = (ImageButton) findViewById(R.id.playerlist_friendlist);
		ib_refresh = (ImageButton) findViewById(R.id.playerlist_refresh);
		ib_return = (ImageButton) findViewById(R.id.playerlist_return);
	}

	@Override
	public void processMessage(Message msg) {
		switch (msg.what) {
		case Config.REQUEST_GET_USERS_ONLINE:
			msg = null;
			break;
		case Config.REQUEST_ADD_FRIEND:
			msg = null;
			break;
		case Config.REQUEST_GET_PROP:
			Constant.info_deng = msg.arg2;
			Constant.info_ka = msg.arg1;
			msg = null;
			break;
		default:
			break;
		}
	}

	private void GoNext(Context con, Class<?> cls) {
		Intent intent = new Intent(con, cls);
		finish();
		startActivity(intent);
	}
}
