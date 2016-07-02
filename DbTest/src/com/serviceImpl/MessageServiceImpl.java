package com.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.daoImpl.MessageDaoImpl;

import dao.CommentDao;
import dao.MessageDao;
import entity.Message;
import service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;
	
	@Override
	public void addMessage(Message message) {
		
		messageDao.insertMessage(message);

	}

	@Override
	public void delete(Message message) {
		
		messageDao.deleteMessage(message);

	}
	@Override
	public Message getMessageById(int id) {
		
		Message message = (Message) messageDao.selectMessageById(id).get(0);
		return message;
	}
	

	@Override
	public void deleteAll() {
		
		messageDao.deleteAll();

	}

	@Override
	public List<Message> getMessage() {
		
		List<Message> messages = messageDao.selectMessage();
		return messages;
	}

	@Override
	public List<Message> getMessageByUserId(int id) {
		
		List<Message> messages = messageDao.selectMessageByUserId(id);
		return messages;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public List<Message> getMessageStartAtId(int id) {
		
		List<Message> messages = messageDao.selectMessageStartAtId(id);
		return messages;
	}

	@Override
	public List<Message> getMessageToDownToId(int id) {
		List<Message> messages = messageDao.selectMessageToDownToId(id);
		return messages;
	}

	@Override
	public List<Message> getNewMessageToId(int id) {
		List<Message> messages = messageDao.selectNewMessageToId(id);
		return messages;
	}

	@Override
	public List<Message> getOlderMessage(int startId, int endId) {
		List<Message> messages = messageDao.selectOlderMessage(startId, endId);
		return messages;
	}

	

}
