package cn.edu.bjtu.cyllk.business;

import cn.edu.bjtu.cyllk.global.Config;
import java.util.LinkedList;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public abstract class BaseActivity extends Activity {

	// 将生成的Activity都放到LinkList集合中
	protected static LinkedList<BaseActivity> queue = new LinkedList<BaseActivity>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 判断该Activity是否在LinkedList中，没有在的话就添加上
		if (!queue.contains(this)) {
			queue.add(this);
		}
	}

	public abstract void processMessage(Message msg);

	private static Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case Config.REQUEST_REGISTER:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_LOGIN:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_GET_USERS_ONLINE:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_GET_FRIEND:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_ADD_FRIEND:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_GET_CHENGYU:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_EXIT:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_EXIT_GAME:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_GET_SCORES:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_GET_PROP:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			case Config.REQUEST_MODIFY_PROP:
				if (!queue.isEmpty()) {
					queue.getLast().processMessage(msg);
				}
				break;
			default:
				break;
			}
		}
	};

	// 发送消息（、、、）
	public static void sendMessage(Message msg) {
		handler.sendMessage(msg);
	}

}
