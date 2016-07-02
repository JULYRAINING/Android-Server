package dao;


import java.util.List;

import entity.Message;

public interface MessageDao {


	/**
	 * �������
	 */
	public void insertMessage(Message message);
	/**
	 * ��������
	 */
	public void updateMessage(Message message);
	/**
	 * ��������
	 */
	public List selectMessageById(int id);
	public List selectMessageStartAtId(int id);
	public List selectMessageToDownToId(int id);
	public List selectNewMessageToId(int id);
	public List selectOlderMessage(int startId, int endId);

	
	public List selectMessageByUserId(int id);
	
	public List selectMessageByTitle(String title);
	
	public List selectMessage();
	
	/**
	 * ɾ������
	 */
	public void deleteMessageById(int id);
	/**
	 * ɾ������
	 */
	public void deleteMessage(Message message);
	public void deleteAll();
	
}
