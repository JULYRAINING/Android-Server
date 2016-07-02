package utils;

import java.io.File;

public class FinalString {

	// 保存文章图片的路径
	public static final String MessageImagePath = "F:" + File.separator + "ServerFile" + File.separator + "MessageImage"
			+ File.separator;
	// 保存用户头像图片的路径
	public static final String UserImagePath = "F:" + File.separator + "ServerFile" + File.separator + "UserImage"
			+ File.separator;
	// 使用Gson解析文章内容时，其List<HashMap<String,String>>中Hash的标识
	public static final String ImageMapTag = "Image";
	// 请求图片时，表单的参数
	public static final String ImageRequestParam = "Image";
	// 请求图片时，表单的参数
		public static final String UserImageRequestParam = "userId";
	// 请求文章时，表单的参数
	public static final String AddMessageRequestParam = "data";
	// 通过用户id请求文章列表List时，表单的参数
	public static final String GetMessageByUserIdRequestParam = "userid";
	// 用户验证信息token
		public static final String UserValidateRequestParam = "token";

	// 注册用户时，表单的参数
	public static final String SimpleRegisteUserRequestParam = "simpleUserInfo";
	// 完善用户信息时，表单的参数
	public static final String RegisteUserRequestParam = "data";
	// 完善用户资料用户头像时，表单的参数
	public static final String RegisteUserImageRequestParam = "uploadImage";
	// 发表文章，提交图片时，表单的参数
	public static final String AddMessageImageRequestParam = "uploadImage";
	// 用户登录时，表单的参数
	public static final String LoginRequestParam = "loginInfo";
	// 通过用户id请求用户详细信息时，表单的参数
	public static final String GetUserDetailByIdRequestParam = "userid";
	
	public static final String CollectionRequestParam = "collectionInfo";
	
	public static final String CommentRequestParam = "commentInfo";
	
	public static final String GetCommentRequestParam = "messageId";
	
	public static final String GetMessage_Flag_RequestParams= "getMessageFlag";
	
	public static final String GetMessage_StartId_RequestParams= "getMessageStartId";

	public static final String GetMessage_EndId_RequestParams= "getMessageEndId";


	
	

}
