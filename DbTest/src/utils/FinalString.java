package utils;

import java.io.File;

public class FinalString {

	// ��������ͼƬ��·��
	public static final String MessageImagePath = "F:" + File.separator + "ServerFile" + File.separator + "MessageImage"
			+ File.separator;
	// �����û�ͷ��ͼƬ��·��
	public static final String UserImagePath = "F:" + File.separator + "ServerFile" + File.separator + "UserImage"
			+ File.separator;
	// ʹ��Gson������������ʱ����List<HashMap<String,String>>��Hash�ı�ʶ
	public static final String ImageMapTag = "Image";
	// ����ͼƬʱ�����Ĳ���
	public static final String ImageRequestParam = "Image";
	// ����ͼƬʱ�����Ĳ���
		public static final String UserImageRequestParam = "userId";
	// ��������ʱ�����Ĳ���
	public static final String AddMessageRequestParam = "data";
	// ͨ���û�id���������б�Listʱ�����Ĳ���
	public static final String GetMessageByUserIdRequestParam = "userid";
	// �û���֤��Ϣtoken
		public static final String UserValidateRequestParam = "token";

	// ע���û�ʱ�����Ĳ���
	public static final String SimpleRegisteUserRequestParam = "simpleUserInfo";
	// �����û���Ϣʱ�����Ĳ���
	public static final String RegisteUserRequestParam = "data";
	// �����û������û�ͷ��ʱ�����Ĳ���
	public static final String RegisteUserImageRequestParam = "uploadImage";
	// �������£��ύͼƬʱ�����Ĳ���
	public static final String AddMessageImageRequestParam = "uploadImage";
	// �û���¼ʱ�����Ĳ���
	public static final String LoginRequestParam = "loginInfo";
	// ͨ���û�id�����û���ϸ��Ϣʱ�����Ĳ���
	public static final String GetUserDetailByIdRequestParam = "userid";
	
	public static final String CollectionRequestParam = "collectionInfo";
	
	public static final String CommentRequestParam = "commentInfo";
	
	public static final String GetCommentRequestParam = "messageId";
	
	public static final String GetMessage_Flag_RequestParams= "getMessageFlag";
	
	public static final String GetMessage_StartId_RequestParams= "getMessageStartId";

	public static final String GetMessage_EndId_RequestParams= "getMessageEndId";


	
	

}
