package cn.edu.bjtu.cyllk.global;

import java.util.List;
import java.util.Random;

public class Chengyu {
	// �������
	public static void save(List<String> list) {
		Constant.list = list;
	}

	// �������Ƿ���ȷ
	public static boolean check(String str) {
		List<String> list = Constant.list;
		for (int i = 0; i < list.size(); i++) {
			if (str.equals(list.get(i)))
				return true;
		}
		return false;
	}

	// ����ת��
	public static String[] changeChengyu(List<String> list) {
		String[][] str = new String[list.size()][4];
		String[] str1 = new String[list.size() * 4];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				str[i][j] = String.valueOf(list.get(i).charAt(j));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				str1[i * 4 + j] = str[i][j];
			}
		}
		return randoms(str1);
	}

	// ������������
	public static String[] randoms(String[] str) {
		int temp1;
		String temp2;
		int len = str.length;
		Random r = new Random();
		String returnValue[] = new String[len];
		for (int i = 0; i < str.length; i++) {
			temp1 = Math.abs(r.nextInt()) % len;
			returnValue[i] = str[temp1];
			temp2 = str[temp1];
			str[temp1] = str[len - 1];
			str[len - 1] = temp2;
			len--;
		}
		return returnValue;
	}

	// ��chengyu list���˳���string
	public static String[] chengyuToString(List<String> list) {
		String[][] str = new String[list.size()][4];
		String[] str1 = new String[list.size() * 4];

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				str[i][j] = String.valueOf(list.get(i).charAt(j));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < 4; j++) {
				str1[i * 4 + j] = str[i][j];
			}
		}
		return str1;
	}

}
