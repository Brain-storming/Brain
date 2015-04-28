package cn.edu.bjtu.cyllk.global;

public interface Config {
	public static final int REQUEST_LOGIN = 1000; // ��¼����
	public static final int REQUEST_REGISTER = 1001; // ע������
	public static final int REQUEST_EXIT = 1002; // �˳�����
	public static final int REQUEST_QUICK_LOGIN = 1003; // ���ٵ�¼����

	public static final int REQUEST_GET_PROP = 1004; // ��ȡ��������
	public static final int REQUEST_MODIFY_PROP = 1005; // �޸ĵ�������
	public static final int REQUEST_ADD_FRIEND = 1006; // ��Ӻ�������
	public static final int REQUEST_GET_FRIEND = 1007; // ��ȡ�����б�����
	public static final int REQUEST_GET_USERS_ONLINE = 1008; // ��ȡ�����û�����
	public static final int REQUEST_ADD_SCORES = 1009; // ��ӻ��ֵ�����
	public static final int REQUEST_GET_SCORES = 1010; // ��ȡ���ֵ�����
	public static final int REQUEST_GET_CHENGYU = 1011; // ��ȡ���������
	public static final int REQUEST_SEND_INVITE = 1012; // ��������
	public static final int REQUEST_INVITE_RESULT = 1013; // ������
	public static final int REQUEST_EXIT_GAME = 1014; // �˳���Ϸ��������
	public static final int REQUEST_ADD_PLAYERSCORE = 1015; // PKʱ��ӻ��ֵ�����
	public static final int REQUEST_PK_RESULT = 1016; // PK���
	public static final int REQUEST_GET_SUBJECT = 1011;// ��ȡ���������(����requestType��num.)

	public static final int SUCCESS = 2000; // �ɹ����
	public static final int FAIl = 2001; // ʧ�ܽ��

	public static final int USER_STATE_ONLINE = 3000; // �û����ߵ�״̬
	public static final int USER_STATE_NON_ONLINE = 3001; // �û������ߵ�״̬

	public static final String RESULT = "result"; // ���
	public static final String REQUEST_TYPE = "requestType"; // ��������
	public static final String USERNAME = "username";// �û���

	public static final int XLXF_MODEL = 1;
	public static final int ZFDM_MODEL = 2;
}