package service;

import java.util.List;

import entity.Message;

public interface MessageService {

	public void addMessage(Message message);
	public void delete(Message message);
	public Message getMessageById(int id);
	public void deleteAll();
	public List<Message> getMessage();
	public List<Message> getMessageStartAtId(int id);
	public List<Message> getMessageToDownToId(int id);
	public List<Message> getNewMessageToId(int id);
	public List<Message> getOlderMessage(int startId, int endId);

	public List<Message> getMessageByUserId(int id);
	
}
