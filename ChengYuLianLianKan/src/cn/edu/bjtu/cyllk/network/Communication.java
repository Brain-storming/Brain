package cn.edu.bjtu.cyllk.network;

import android.content.Context;

public class Communication {
	Context context;
	private NetWorker netWorker;
	public static Communication instance = null;

	// 生成Communication通信类的实例
	public static Communication newInstance() {
		if (instance == null) {
			instance = new Communication();
		}
		return instance;
	}

	// 将构造函数私有化，使其不能生成多个实例，防止多次连接连接服务器
	private Communication() {
		netWorker = new NetWorker();
		netWorker.start();
	}

	public void login(String userName, String password) {
		netWorker.login(userName, password);
	}

	public void register(String userName, String password) {
		netWorker.register(userName, password);
	}

	public void getPlayerList() {
		netWorker.getPlayerList();
	}

	public void getFriendlist() {
		netWorker.getFriendList();
	}

	public void addFriend(String friendname) {
		netWorker.addFriend(friendname);
	}

	// 发送成语请求
	public void getChengYu(int num) {
		netWorker.getChengYu(num);
	}

	public void clear() {
		netWorker.setOnWork(false);
		instance = null;
	}

	// 商品
	public void getshop(String name) {
		netWorker.getshop(name);
	}

	// 道具
	public void changshop(String prpoName, int num) {
		netWorker.changshop(prpoName, num);
	}

	// 发送游戏中退出游戏请求
	public void exitGameActivity(String playername, String username) {
		netWorker.exitGameAcitvity(playername, username);
	}

	// 发送退出游戏请求
	public void exitGame() {
		netWorker.exitGame();
	}

	// 发送获取玩家积分
	public void getScore(String name) {
		netWorker.getScore(name);
	}
}
