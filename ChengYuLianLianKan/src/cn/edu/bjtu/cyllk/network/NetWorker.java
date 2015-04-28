package cn.edu.bjtu.cyllk.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.bjtu.cyllk.business.BaseActivity;
import cn.edu.bjtu.cyllk.business.FriendList;
import cn.edu.bjtu.cyllk.business.Login;
import cn.edu.bjtu.cyllk.business.PlayerList;
import cn.edu.bjtu.cyllk.business.Register;
import cn.edu.bjtu.cyllk.global.Config;
import cn.edu.bjtu.cyllk.global.Constant;

import android.os.Message;
import android.util.Log;

public class NetWorker extends Thread {
	private static final String SERVER_IP = "10.3.1.9";
	private static final int SERVER_PORT = 8888;

	private Socket socket = null;
	private PrintWriter out = null;
	private BufferedReader in = null;

	private boolean isWorking = true;
	protected final byte toConnect = 1;
	protected final byte isRunning = 2;
	protected byte socketState = toConnect;

	JSONObject jsonObject;
	JSONArray jsonArray;

	int requestType;

	@Override
	public void run() {
		super.run();
		while (isWorking) {
			switch (socketState) {
			case toConnect:
				connect();
				break;
			case isRunning:
				receiveMsg();
				break;
			default:
				break;
			}
		}
	}

	private void connect() {
		try {
			socket = new Socket(SERVER_IP, SERVER_PORT);
			socketState = isRunning;
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "UTF-8"));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receiveMsg() {
		try {
			String msg = in.readLine();
			jsonObject = new JSONObject(msg);
			requestType = jsonObject.getInt("requestType");
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (requestType == Config.REQUEST_REGISTER) {
			handRegister();
		} else if (requestType == Config.REQUEST_LOGIN) {
			handLogin();
		} // 退出
		else if (requestType == Config.REQUEST_EXIT) {
			Message msg = new Message();
			int num = 7;
			msg.what = num;
			BaseActivity.sendMessage(msg);
		}
		// 获取道具商城
		else if (requestType == Config.REQUEST_GET_PROP) {
			handGetshop();
		}
		// 获取道具修改
		else if (requestType == Config.REQUEST_MODIFY_PROP) {
			handChangshop();
		}

		// 判断获取在线玩家
		else if (requestType == Config.REQUEST_GET_USERS_ONLINE) {
			handPlayerList();
		}
		// 判断类型为获取好友，在进行处理
		else if (requestType == Config.REQUEST_ADD_FRIEND) {
			handAddFriend();

		}
		// 判断类型是否为邀战请求
		else if (requestType == Config.REQUEST_SEND_INVITE) {

			handYaoZhan();
		}
		// 判断对方否接收请求
		else if (requestType == Config.REQUEST_INVITE_RESULT) {

			handInviteResult();
		}
		// 判断获取好友列表
		else if (requestType == Config.REQUEST_GET_FRIEND) {
			handFriendList();
		}
		// 获取成语
		else if (requestType == Config.REQUEST_GET_SUBJECT) {
			handGetChengYu();
		}
		// 获取好友的积分
		else if (requestType == Config.REQUEST_ADD_PLAYERSCORE) {
			handAddPlayerScore();
		}
		// 获取积分
		else if (requestType == Config.REQUEST_GET_SCORES) {
			handGetSocre();
		}
		// 获取PK结果
		else if (requestType == Config.REQUEST_PK_RESULT) {
			handPKResult();
		}
		// 返回游戏中退出游戏的请求
		else if (requestType == Config.REQUEST_EXIT_GAME) {
			handExitGameActivity();
		}
	}

	public void register(String userName, String password) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("requestType", Config.REQUEST_REGISTER);
			jsonObject.put("username", userName);
			jsonObject.put("password", password);
			out.println(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private void handRegister() {
		try {
			int result = jsonObject.getInt("result");
			Message msg = new Message();
			msg.arg1 = result;
			msg.what = Config.REQUEST_REGISTER;
			Register.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void login(String userName, String password) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("requestType", Config.REQUEST_LOGIN);
			jsonObject.put("username", userName);
			jsonObject.put("password", password);
			out.println(jsonObject.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	private void handLogin() {
		try {
			int result = jsonObject.getInt("result");
			Message msg = new Message();
			msg.arg1 = result;
			msg.what = Config.REQUEST_LOGIN;
			Login.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public void getPlayerList() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("requestType", Config.REQUEST_GET_USERS_ONLINE);
			jsonObject.put("username", Constant.userName);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jsonObject.toString());
	}

	private void handPlayerList() {
		try {
			JSONArray jsonArray = jsonObject.getJSONArray("list");

			for (int i = 0; i < jsonArray.length(); i++) {
				if (!jsonArray.getJSONObject(i).optString("username")
						.equals(Constant.userName)) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("score", jsonArray.getJSONObject(i).optInt("score"));
					map.put("username",
							jsonArray.getJSONObject(i).optString("username"));
					Constant.playerol_list.add(map);
				}
			}
			Message msg = new Message();
			msg.obj = Constant.playerol_list;
			msg.what = Config.REQUEST_GET_USERS_ONLINE;
			PlayerList.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void getFriendList() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", Constant.userName);
			jo.put("requestType", Config.REQUEST_GET_FRIEND);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	private void handFriendList() {
		JSONArray ja;
		try {
			ja = jsonObject.optJSONArray("list");
			System.out.println(ja.toString());
			for (int i = 0; i < ja.length(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("score", ja.getJSONObject(i).getInt("score"));
				map.put("friendName",
						ja.getJSONObject(i).getString("friendName"));
				Constant.friend_list.add(map);
			}

			Message msg = new Message();
			msg.obj = Constant.friend_list;
			msg.what = Config.REQUEST_GET_FRIEND;
			FriendList.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void addFriend(String friendname) {
		JSONObject jo = new JSONObject();
		try {
			jo.put(Config.USERNAME, Constant.userName);
			jo.put("playername", friendname);
			jo.put(Config.REQUEST_TYPE, Config.REQUEST_ADD_FRIEND);
			out.println(jo.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void handAddFriend() {
		Message msg = new Message();
		try {
			msg.arg1 = jsonObject.getInt("result");
			msg.what = Config.REQUEST_ADD_FRIEND;
			FriendList.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 服务器传递成语的请求
	public void handGetChengYu() {
		System.out.println("传递获取成语的请求");
		Message msg = new Message();
		try {
			JSONArray ja = jsonObject.getJSONArray("chengyus");
			msg.obj = ja;
			msg.what = Config.REQUEST_GET_SUBJECT;
			BaseActivity.sendMessage(msg);

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	// 向服务器发送成语请求
	public void getChengYu(int num) {
		System.out.println("发送获取成语的请求");
		JSONObject jo = new JSONObject();
		try {
			jo.put("requestType", Config.REQUEST_GET_SUBJECT);
			jo.put("num", num);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
		Log.i("~~~", "发送获取成语的请求为：" + jo.toString());
	}

	public void exitGameAcitvity(String playername, String username) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", username);
			jo.put("playername", playername);
			jo.put("requestType", Config.REQUEST_EXIT_GAME);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	public void handExitGameActivity() {
		Message msg = new Message();
		try {
			msg.obj = jsonObject.getString("username");
			msg.what = Config.REQUEST_EXIT_GAME;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void setOnWork(boolean b) {
		this.isWorking = b;
	}

	// 退出游戏
	public void exitGame() {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", Constant.userName);
			jo.put("requestType", Config.REQUEST_EXIT);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 向服务器发送邀请玩家挑战请求
	public void yaoZhan(String playerName, String userName, int model) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("playername", playerName);
			jo.put("username", userName);
			jo.put("model", model);
			jo.put("requestType", Config.REQUEST_SEND_INVITE);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 服务器返回邀战的请求
	public void handYaoZhan() {
		Message msg = new Message();
		try {
			msg.arg1 = jsonObject.getInt("model");
			msg.obj = jsonObject.getString("username");
			msg.what = Config.REQUEST_SEND_INVITE;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 向服务器发送是否接受请求信息
	public void inviteResult(String playername, int result) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("playername", playername);
			jo.put("requestType", Config.REQUEST_INVITE_RESULT);
			jo.put("result", result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 服务器返回是否接收请求
	public void handInviteResult() {
		Message msg = new Message();
		try {
			msg.arg1 = jsonObject.getInt("result");
			msg.what = Config.REQUEST_INVITE_RESULT;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 发送玩家积分请求
	public void getScore(String name) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", name);
			jo.put("requestType", Config.REQUEST_GET_SCORES);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	public void handGetSocre() {
		try {
			int score = jsonObject.getInt("score");
			Message msg = new Message();
			msg.arg1 = score;
			msg.what = Config.REQUEST_GET_SCORES;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 发送添加积分的请求
	public void addScore(int num) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", Constant.userName);
			jo.put("requestType", Config.REQUEST_ADD_SCORES);
			jo.put("propName", "score");
			jo.put("num", num);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 向服务器发送挑战积分请求
	public void addPlayerScore(String playername, int num) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("playername", playername);
			jo.put("requestType", Config.REQUEST_ADD_PLAYERSCORE);
			jo.put("num", num);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 从服务器返回对战玩家的积分
	public void handAddPlayerScore() {
		try {
			int num = jsonObject.getInt("num");
			Message msg = new Message();
			msg.arg1 = num;
			msg.what = Config.REQUEST_ADD_PLAYERSCORE;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 发送pK结果给服务器，让服务器判断谁胜利
	public void sendPKResult(String playername) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("requestType", Config.REQUEST_PK_RESULT);
			jo.put("playername", playername);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 服务器的返回结果
	public void handPKResult() {
		Message msg = new Message();
		msg.what = Config.REQUEST_PK_RESULT;
		BaseActivity.sendMessage(msg);
	}

	// 道具的请求
	public void changshop(String prpoName, int num) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", Constant.userName);
			jo.put("propName", prpoName);
			jo.put("num", num);
			jo.put("requestType", Config.REQUEST_MODIFY_PROP);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}

	// 商城道具线程处理
	public void handChangshop() {
		try {
			int result = jsonObject.getInt("result");
			Message msg = new Message();
			msg.arg1 = result;
			msg.what = Config.REQUEST_MODIFY_PROP;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	// 商城线程处理
	public void handGetshop() {
		try {
			int xmd = jsonObject.getInt("deng");
			int tsk = jsonObject.getInt("ka");
			/*Constant.info_ka = tsk;
			Constant.info_deng = xmd;*/
			Message msg = new Message();
			msg.arg1 = tsk;
			msg.arg2 = xmd;
			msg.what = Config.REQUEST_GET_PROP;
			BaseActivity.sendMessage(msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// 商品的购买
	public void getshop(String username) {
		JSONObject jo = new JSONObject();
		try {
			jo.put("username", username);
			jo.put("requestType", Config.REQUEST_GET_PROP);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.println(jo.toString());
	}
}
