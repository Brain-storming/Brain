package cn.edu.bjtu.cyllk.network;

import android.content.Context;

public class Communication {
	Context context;
	private NetWorker netWorker;
	public static Communication instance = null;

	// ����Communicationͨ�����ʵ��
	public static Communication newInstance() {
		if (instance == null) {
			instance = new Communication();
		}
		return instance;
	}

	// �����캯��˽�л���ʹ�䲻�����ɶ��ʵ������ֹ����������ӷ�����
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

	// ���ͳ�������
	public void getChengYu(int num) {
		netWorker.getChengYu(num);
	}

	public void clear() {
		netWorker.setOnWork(false);
		instance = null;
	}

	// ��Ʒ
	public void getshop(String name) {
		netWorker.getshop(name);
	}

	// ����
	public void changshop(String prpoName, int num) {
		netWorker.changshop(prpoName, num);
	}

	// ������Ϸ���˳���Ϸ����
	public void exitGameActivity(String playername, String username) {
		netWorker.exitGameAcitvity(playername, username);
	}

	// �����˳���Ϸ����
	public void exitGame() {
		netWorker.exitGame();
	}

	// ���ͻ�ȡ��һ���
	public void getScore(String name) {
		netWorker.getScore(name);
	}
}
