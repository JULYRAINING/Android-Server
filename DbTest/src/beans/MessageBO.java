package beans;
public class MessageBO {
	public MessageBO() {}
    //��������
    private int msgId;
    //������id
    private int userId;
    //�Ƿ�ɾ��
    private int isDelete;
    //������
    private String msgSender;
    //����ʱ��
    private String msgSendTime;
    //������ͷ��
    private String msgSenderImg;
    //��������
    private String msgContent;
    private int msgApprove;
    private int msgOppose;
    private String imagePathListStr;
    
    private int categoryId;

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getMsgSender() {
		return msgSender;
	}

	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}

	public String getMsgSendTime() {
		return msgSendTime;
	}

	public void setMsgSendTime(String msgSendTime) {
		this.msgSendTime = msgSendTime;
	}

	public String getMsgSenderImg() {
		return msgSenderImg;
	}

	public void setMsgSenderImg(String msgSenderImg) {
		this.msgSenderImg = msgSenderImg;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public int getMsgApprove() {
		return msgApprove;
	}

	public void setMsgApprove(int msgApprove) {
		this.msgApprove = msgApprove;
	}

	public int getMsgOppose() {
		return msgOppose;
	}

	public void setMsgOppose(int msgOppose) {
		this.msgOppose = msgOppose;
	}

	public String getImagePathListStr() {
		return imagePathListStr;
	}

	public void setImagePathListStr(String imagePathListStr) {
		this.imagePathListStr = imagePathListStr;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "MessageBO [msgId=" + msgId + ", userId=" + userId + ", isDelete=" + isDelete + ", msgSender="
				+ msgSender + ", msgSendTime=" + msgSendTime + ", msgSenderImg=" + msgSenderImg + ", msgContent="
				+ msgContent + ", msgApprove=" + msgApprove + ", msgOppose=" + msgOppose + ", imagePathListStr="
				+ imagePathListStr + ", categoryId=" + categoryId + "]";
	}
	

}
