package cn.edu.bjtu.cyllk.global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Constant {
	public static String userName = "";// �û���
	public static String userPassword = "";// �û�����
	public static int gameModel = -1;// 0Ϊ��ս�ķ�ģʽ��1Ϊ�ɵ����ֶ���ģʽ���������⣩2Ϊ�µ����ֶ���ģʽ
	public static String playerName = null;
	public static String reg_username = "", reg_password = "";
	public static List<Map<String, Object>> playerol_list = new ArrayList<Map<String, Object>>();
	public static List<Map<String, Object>> friend_list = new ArrayList<Map<String, Object>>();

	public static List<String> list = null;
	public static int guanka = 1;

	public static boolean musicSt = true;// ���ֿ���
	public static boolean soundSt = true;// ��Ч����

	public static String info_name, info_score;
	public static int info_ka, info_deng;
}
