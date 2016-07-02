package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.daoImpl.CategoryDaoImpl;
import com.mysql.jdbc.log.Log;
import com.serviceImpl.CategoryServiceImpl;
import com.serviceImpl.CollectionServiceImpl;
import com.serviceImpl.CommentServiceImpl;
import com.serviceImpl.MessageServiceImpl;
import com.serviceImpl.UserServiceImpl;
import com.sun.java_cup.internal.runtime.virtual_parse_stack;

import beans.MessageBO;
import entity.Category;
import entity.Collection;
import entity.Comment;
import entity.Message;
import entity.UserDetail;
import service.MessageService;
import utils.JsonConverter;

public class ServiceTest {
	@Test
	public void testGetMessage(){
		List<MessageBO> messageBOs = new ArrayList<>();
		MessageService messageServiceImpl = new MessageServiceImpl();
		//List<Message> messages = messageServiceImpl.getMessageByUserId(177);
		List<Message> messages = messageServiceImpl.getMessageStartAtId(2);

		int count = messages.size();
		for (int i = 0; i < count; i++) {
			MessageBO messageBO = new MessageBO();
			messageBO.setMsgApprove(messages.get(i).getApprove());
			messageBO.setImagePathListStr(messages.get(i).getImage());
			messageBO.setMsgContent(messages.get(i).getContent());
			messageBO.setMsgId(messages.get(i).getMessageId());
			messageBO.setMsgOppose(messages.get(i).getOppose());
			messageBO.setUserId(messages.get(i).getUser().getUserId());
			messageBO.setMsgSendTime(messages.get(i).getTime().toString());
			messageBO.setMsgSender(messages.get(i).getUser().getName());
			messageBO.setMsgSenderImg(messages.get(i).getUser().getImage());
			messageBOs.add(messageBO);
		}
		String messageJson = JsonConverter.toJson(messageBOs);
		System.out.println(messageJson);
	}
	@Test
	public void testUser(){
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDetail userDetail = new UserDetail();
		userDetail.setGender(0);
		userDetail.setGrade(3);
		userDetail.setImage("png");
		userDetail.setMajor("审美");
		userDetail.setMinor("乐理");
		userDetail.setName("初音");
		userDetail.setSignature("怕什么真理无穷，进一寸有一寸的欢喜");
		
		userServiceImpl.addUser(userDetail);
	}
	
	@Test
	public void testCategory() {
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		Category category = new Category();
		category.setCategoryId(1);
		category.setName("科幻");
		category.setDescription("世界上有两样能深深震撼人心灵的东西，一样是头顶灿烂的星空，另一样是心中的道德准则");
		categoryServiceImpl.addCategory(category);
	}

	@Test
	public void testCollection() {
		CollectionServiceImpl collectionServiceImpl = new CollectionServiceImpl();
		MessageServiceImpl  messageServiceImpl = new MessageServiceImpl();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		Message message = messageServiceImpl.getMessageById(1);
		UserDetail user = userServiceImpl.getUserById(177);
		
		Collection collection = new Collection();
		collection.setId(1);
		collection.setMessage(message);
		collection.setUser(user);
		collection.setTime(new Date());
		collectionServiceImpl.addCollect(collection);
	}

	@Test
	public void testComment() {

		CommentServiceImpl commentServiceImpl = new CommentServiceImpl();
		MessageServiceImpl  messageServiceImpl = new MessageServiceImpl();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		
		Message message = messageServiceImpl.getMessageById(1);
		UserDetail user = userServiceImpl.getUserById(177);
		
		Comment comment = new Comment();
		comment.setCommentId(1);
		comment.setContent("by康德");
		comment.setMessage(message);
		comment.setUser(user);
		
		
		commentServiceImpl.addComment(comment);
	}

	@Test
	public void testMessage() {
		MessageServiceImpl  messageServiceImpl = new MessageServiceImpl();
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		
		UserDetail user = userServiceImpl.getUserById(1);
		Category category = categoryServiceImpl.getCategoryById(1);
		
		
		Message message = new Message();
		message.setApprove(13);
		message.setCategory(category);
		message.setContent("you may say I'm a dreamer,but I'm not the only one");
		message.setImage("path");
		message.setIsDelete(0);
		
		message.setTitle("dream");
		message.setUser(user);
		message.setTime(new Date());
		messageServiceImpl.addMessage(message);
	}

	@Test
	public void testUserDetail() {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserDetail user = new UserDetail();

		user.setGender(0);
		user.setGrade(3);
		user.setImage("123456");
		user.setMajor("传播学");
		user.setMinor("MBA");
		user.setName("初音");
		user.setSignature("怕什么真理无穷，进一寸有一寸的欢喜");
		

		userServiceImpl.addUser(user);

		UserDetail newUser = new UserDetail();

		newUser.setGender(0);
		newUser.setGrade(4);
		newUser.setImage("123456");
		newUser.setMajor("传播学");
		newUser.setMinor("MBA");
		newUser.setName("初音");
		newUser.setSignature("怕什么真理无穷，进一寸有一寸的欢喜");
		

		userServiceImpl.updateUser(177, newUser);
	}
	@Test
	public void deleteAll(){
		CollectionServiceImpl collectionServiceImpl = new CollectionServiceImpl();
		collectionServiceImpl.deleteAll();
		System.out.println("删除完成");
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		categoryServiceImpl.deleteAll();
		
		
		CommentServiceImpl commentServiceImpl = new CommentServiceImpl();
		commentServiceImpl.deleteAll();
		
		MessageServiceImpl messageServiceImpl = new MessageServiceImpl();
		messageServiceImpl.deleteAll();
		
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.deleteAll();
		
	}
}
