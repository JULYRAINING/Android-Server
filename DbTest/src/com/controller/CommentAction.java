package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.internal.matchers.CombinableMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

import beans.CommentBO;
import entity.Comment;
import entity.Message;
import entity.TokenValidate;
import entity.UserDetail;
import service.CommentService;
import service.MessageService;
import service.UserService;
import utils.EncodeingConverter;
import utils.FinalString;
import utils.JsonConverter;

@Controller
public class CommentAction {

	@Resource
	public CommentService commentService;
	@Resource
	public MessageService messageService;
	@Resource
	public UserService userService;
	
	@RequestMapping("comment/getAll")
	@ResponseBody
	public String getCommentByMessageId(@RequestParam(FinalString.GetCommentRequestParam)
				int messageId) throws UnsupportedEncodingException{
		
		//存在sql注入风险
		List<Comment>comments = (List<Comment>)commentService.getAllByMessageId(messageId);
		//comments.get(0);
		
		
		List<CommentBO>commentBOs = new ArrayList<>();
		
		for(Comment comment : comments){
			CommentBO commentBO = new CommentBO();
			commentBO.setCommentId(comment.getCommentId());
			commentBO.setRefCommentUserName(comment.getRefCommentUserName());
			commentBO.setUserId(comment.getUser().getUserId());
			commentBO.setUserName(comment.getUserName());
			commentBO.setContent(comment.getContent());
			commentBO.setTime(comment.getTime().toString());
			commentBOs.add(commentBO);
		}
		
		
		String result = JsonConverter.toJson(commentBOs);
		System.out.println(result);
		return EncodeingConverter.convertReturnToISO(result);

		
	}
	/**
	 * 
	 * @param tokenInfo
	 * @param commentInfo
	 * 
	 * 
	 * //测试uri
http://localhost:8080/DbTest/comment/add.do?token={"userId":23,
	"token":"1453645965064"}&commentInfo={"userId":23,"messageId":13,
	"content":"今天天气不错","refCommentId":2}
	 */
	
	@RequestMapping("comment/add")
	@ResponseBody
	public void addComment(@RequestParam(FinalString.UserValidateRequestParam) String tokenInfo,
			@RequestParam(FinalString.CommentRequestParam) String commentInfo){
		System.out.println(commentInfo);
		TokenValidate tokenValidate = JsonConverter.toBean(tokenInfo, TokenValidate.class);
		CommentBO commentBO = JsonConverter.toBean(commentInfo, CommentBO.class);
		System.out.println(commentBO.getRefCommentId());
		int userId = commentBO.getUserId();
		String userName = commentBO.getUserName();
		int messageId = commentBO.getMessageId();
		int refCommentId = commentBO.getRefCommentId();
		String refCommentUserName = commentBO.getRefCommentUserName();
		String content = commentBO.getContent();
		System.out.println(content);
		if(userId == tokenValidate.getUserId()){
			
			Message message = messageService.getMessageById(messageId);
			UserDetail userDetail = userService.getUserById(userId);
			Comment refComment = commentService.getCommentById(refCommentId);
			
			Comment comment = new Comment();
			
			comment.setMessage(message);
			comment.setUser(userDetail);
			comment.setRefComment(refComment);
			comment.setContent(content);
			comment.setTime(new Date());
			comment.setUserName(userName);
			comment.setRefCommentUserName(refCommentUserName);
			
			
			commentService.addComment(comment);
			System.out.println("评论完成");
		}else{
			System.out.println("身份验证失败,评论未完成");

			System.out.println("评论未完成");
		}
		
	}
}
