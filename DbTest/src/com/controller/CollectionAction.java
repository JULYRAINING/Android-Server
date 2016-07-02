package com.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import beans.CollectionBO;
import entity.Collection;
import entity.Message;
import entity.TokenValidate;
import entity.UserDetail;
import service.CollectionService;
import service.MessageService;
import service.UserService;
import utils.FinalString;
import utils.JsonConverter;

@Controller
public class CollectionAction {
	
	@Resource
	public CollectionService collectionService;
	@Resource
	public UserService userService;
	@Resource
	public MessageService messageService;

	@RequestMapping("collection/add")
	@ResponseBody
	public void addCollection(
			@RequestParam(FinalString.UserValidateRequestParam) String tokenInfo,
			@RequestParam(FinalString.CollectionRequestParam) 
			String collectionInfo) {
		System.out.println(collectionInfo);
		//测试uri
		//http://localhost:8080/DbTest/collection/add.do?token={"userId":23,"token":"1453645965064"}&collectionInfo={"userId":23,"messageId":13}
		CollectionBO collectionBO = JsonConverter.toBean(collectionInfo, CollectionBO.class);
		TokenValidate tokenValidate = JsonConverter.toBean(tokenInfo, TokenValidate.class);
		
		int userId = collectionBO.getUserId();
		if(tokenValidate.getUserId() == userId){
			UserDetail userDetail = userService.getUserById(userId);
			Message message = messageService.getMessageById(collectionBO.getMessageId());
			
			Collection collection = new Collection(userDetail, message, new Date());
			collectionService.addCollect(collection);
			System.out.println("收藏成功");

		}else {
			System.out.println("身份验证失败，收藏失败，token与message不符");
		}
		
		
		
		
	}

	@RequestMapping("collection/remove")
	@ResponseBody
	public void deleteCollection(@RequestParam(FinalString.UserValidateRequestParam) String tokenInfo,
			@RequestParam(FinalString.CollectionRequestParam) String collectionInfo){
		CollectionBO collectionBO = JsonConverter.toBean(collectionInfo, CollectionBO.class);
		TokenValidate tokenValidate = JsonConverter.toBean(tokenInfo, TokenValidate.class);
		
		int userId = collectionBO.getUserId();
		int messageId = collectionBO.getMessageId();
		if(tokenValidate.getUserId() == userId){
			collectionService.deleteById(userId, messageId);
			System.out.println("取消收藏已完成");
		}else {
			System.out.println("取消收藏未完成");
		}
				
	}
	
	public void getCollection() {

	}
}
