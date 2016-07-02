package dao;


import java.util.List;

import entity.Message;

public interface MessageDao {


	/**
	 * 添加文章
	 */
	public void insertMessage(Message message);
	/**
	 * 更新文章
	 */
	public void updateMessage(Message message);
	/**
	 * 查找文章
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
	 * 删除文章
	 */
	public void deleteMessageById(int id);
	/**
	 * 删除文章
	 */
	public void deleteMessage(Message message);
	public void deleteAll();
	
}
