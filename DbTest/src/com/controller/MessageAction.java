package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.serviceImpl.CategoryServiceImpl;
import com.serviceImpl.MessageServiceImpl;
import com.serviceImpl.UserServiceImpl;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder.Body;

import beans.MessageBO;
import entity.Category;
import entity.Message;
import entity.UserDetail;
import service.CategoryService;
import service.MessageService;
import service.UserService;
import utils.EncodeingConverter;
import utils.FinalString;
import utils.JsonConverter;

@Controller
public class MessageAction {
	@Resource
	public UserService userService;
	@Resource
	public CategoryService categoryService;
	@Resource
	public MessageService messageService;

	@RequestMapping("message/addBody")
	@ResponseBody
	public void addMessageBody(@RequestParam(FinalString.AddMessageRequestParam) String messageBody,

			@RequestParam(FinalString.AddMessageImageRequestParam) MultipartFile[] files)
					throws IllegalStateException, IOException {
		System.out.println(messageBody);
		System.out.println("123");
		System.out.println(files[0].getOriginalFilename());

		MessageBO messageBO = JsonConverter.toBean(messageBody, MessageBO.class);
		List<HashMap<String, String>> fileNameList = new ArrayList<HashMap<String, String>>();
		System.out.println(messageBO.toString());

		String imageListStr;
		if(files[0].getOriginalFilename().equals("default_upload_img.png")){
			imageListStr = null;
		}else {
			//保存图片文件
			int fileCount = files.length;
			for (int i = 0; i < fileCount; i++) {
				HashMap<String, String> maps = new HashMap<>();
				String currentTime = Long.toString(System.currentTimeMillis());
				File targetFile = new File(FinalString.MessageImagePath + currentTime);
				targetFile.mkdirs();
				files[i].transferTo(targetFile);
				maps.put(FinalString.ImageMapTag, currentTime);
				fileNameList.add(maps);

			}
			//转化imageList为Str
			Gson gson = new Gson();
			imageListStr = gson.toJson(fileNameList);
		}
		
		//解析id，查询相应实体，然后保存。
		int userId = messageBO.getUserId();
		int categoryId = messageBO.getCategoryId();
		UserDetail user = userService.getUserById(userId);
		Category category = categoryService.getCategoryById(categoryId);

		//转化为entity
		Message message = new Message();

		message.setApprove(messageBO.getMsgApprove());
		message.setOppose(messageBO.getMsgOppose());
		message.setCategory(category);
		message.setContent(messageBO.getMsgContent());
		message.setImage(imageListStr);
		message.setIsDelete(messageBO.getIsDelete());
		message.setUserName(messageBO.getMsgSender());
		message.setTitle("dream");
		message.setUser(user);
		message.setCategory(category);
		message.setTime(new Date());
		//保存到数据库
		messageService.addMessage(message);

	}

	@RequestMapping("message/getImage")
	@ResponseBody
	public ResponseEntity<byte[]> getMessageImage(@RequestParam(FinalString.ImageRequestParam) String fileName)
			throws IOException {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`"+fileName);
		String filePath = FinalString.MessageImagePath + fileName;
		File file = new File(filePath);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("fileName", EncodeingConverter.convertReturnToISO(fileName));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(FileUtil.readAsByteArray(file), headers,
				HttpStatus.OK);

		return result;

	}

	@RequestMapping("message/getBody")
	@ResponseBody
	public String getMessageBody(
			@RequestParam(FinalString.GetMessage_Flag_RequestParams)
			int flag, 
			@RequestParam(FinalString.GetMessage_StartId_RequestParams)
			int startId,
			@RequestParam(FinalString.GetMessage_EndId_RequestParams)
			int endId) {
		//将要返回客户端的数据
		List<MessageBO> messageBOs = new ArrayList<>();
		//从数据库读取的数据
		List<Message> messages ;
		
		if(flag == 1){
			//请求最新数据
			messages = messageService.getNewMessageToId(endId);
			
		}else {
			messages = messageService.getOlderMessage(startId, endId);
		}
		
		
		
		int count = messages.size();
		for (int i = 0; i < count; i++) {
			MessageBO messageBO = new MessageBO();
			messageBO.setMsgApprove(messages.get(i).getApprove());
			
			messageBO.setMsgContent(messages.get(i).getContent());
			messageBO.setMsgId(messages.get(i).getMessageId());
			messageBO.setMsgOppose(messages.get(i).getOppose());
			messageBO.setUserId(messages.get(i).getUser().getUserId());
			messageBO.setMsgSendTime(messages.get(i).getTime().toString());
			messageBO.setMsgSender(messages.get(i).getUser().getName());
			System.out.println(messages.get(i).getUser().getName());
			messageBO.setMsgSenderImg(messages.get(i).getUser().getImage());
			//判断图片是否为默认图片，若是，则返回null。
			String imageStr = messages.get(i).getImage();
			if(imageStr==null){
				
				messageBO.setImagePathListStr(null);
			}else {
				messageBO.setImagePathListStr(imageStr);
				
			}
			
			messageBO.setCategoryId(messages.get(i).getCategory().getCategoryId());
			messageBOs.add(messageBO);
		}
		String messageJson = JsonConverter.toJson(messageBOs);
		System.out.println(messageJson);
		return EncodeingConverter.convertReturnToISO(messageJson);
	}
	

	@RequestMapping("message/getBodyByUserId")
	@ResponseBody
	public String getMessageBodyByUserId(@RequestParam(FinalString.GetMessageByUserIdRequestParam) int id) {
		System.out.println(id);
		List<MessageBO> messageBOs = new ArrayList<>();

		List<Message> messages = messageService.getMessageByUserId(id);
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
			messageBO.setCategoryId(messages.get(i).getCategory().getCategoryId());
			messageBOs.add(messageBO);
		}
		String messageJson = JsonConverter.toJson(messageBOs);

		return EncodeingConverter.convertReturnToISO(messageJson);
	}
}
