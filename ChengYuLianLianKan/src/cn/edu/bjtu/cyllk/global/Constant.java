package cn.edu.bjtu.cyllk.global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Constant {
	public static String userName = "";// 用户名
	public static String userPassword = "";// 用户密码
	public static int gameModel = -1;// 0为征战四方模式，1为旧的争分夺秒模式（发三套题）2为新的争分夺秒模式
	public static String playerName = null;
	public static String reg_username = "", reg_password = "";
	public static List<Map<String, Object>> playerol_list = new ArrayList<Map<String, Object>>();
	public static List<Map<String, Object>> friend_list = new ArrayList<Map<String, Object>>();

	public static List<String> list = null;
	public static int guanka = 1;

	public static boolean musicSt = true;// 音乐开关
	public static boolean soundSt = true;// 音效开关

	public static String info_name, info_score;
	public static int info_ka, info_deng;
}
