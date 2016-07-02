package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
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
import beans.UserBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.jdbc.log.Log4JLogger;
import com.serviceImpl.UserServiceImpl;
import com.serviceImpl.UserValidateServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

import entity.TokenValidate;
import entity.UserDetail;
import entity.UserValidate;
import service.TokenValidateService;
import service.UserService;
import service.UserValidateService;
import utils.EncodeingConverter;
import utils.FinalString;
import utils.JsonConverter;
import utils.MD5Convert;

@Controller
public class UserAction {

	@Resource
	public UserService userService;
	@Resource
	public UserValidateService userValidateService;
	@Resource
	public TokenValidateService tokenValidateService;
	
	@RequestMapping("user/register")
	@ResponseBody
	public void register(@RequestParam(FinalString.RegisteUserRequestParam) 
			String userInfo, 
			@RequestParam(FinalString.RegisteUserImageRequestParam) MultipartFile imageFile) throws IllegalStateException, IOException{
		
		
		System.out.println(userInfo);
		String currentTime = Long.toString(System.currentTimeMillis());
		File targetFile = new File(FinalString.UserImagePath + currentTime);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		imageFile.transferTo(targetFile);
		UserBO userBo = JsonConverter.toBean(userInfo, UserBO.class);
		System.out.println(userBo.getSignature());
		UserDetail userDetail = new UserDetail();
		
		userDetail.setUserId(userBo.getUserId());
		userDetail.setGender(userBo.getGender());
		userDetail.setGrade(userBo.getGrade());
		userDetail.setImage(currentTime);
		userDetail.setMajor(userBo.getMajor());
		userDetail.setMinor(userBo.getMinor());
		userDetail.setName(userBo.getName());
		userDetail.setSignature(userBo.getSignature());
		
		
		
		userService.addUser(userDetail);
		System.out.println("用户信息更新成功");
		
	}
	@RequestMapping("user/simpleRegister")
	@ResponseBody
	public String simpleRegister(@RequestParam(FinalString.SimpleRegisteUserRequestParam) 
			String userInfo ) throws IllegalStateException, IOException{
		
		
		
		String currentTime = Long.toString(System.currentTimeMillis());
		
		UserValidate userValidate = JsonConverter.toBean(userInfo, UserValidate.class);
		System.out.println(userValidate.toString());
		
		String password = MD5Convert.getMd5(userValidate.getPassword().concat(currentTime));
		
		userValidate.setSalt(currentTime);
		userValidate.setPassword(password);
		
		int userId = userValidateService.addUserValidate(userValidate);
		System.out.println("注册成功");
		return String.valueOf(userId);
		
		
	}
	@RequestMapping("user/getUserInfo")
	@ResponseBody
	public String getUserInfoById(
			@RequestParam(FinalString.GetUserDetailByIdRequestParam)
			int userId){
		System.out.println(userId);
		UserDetail user = userService.getUserById(userId);
		
		
		GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		
		String result = gson.toJson(user);
		System.out.println(result);
		return EncodeingConverter.convertReturnToISO(result);
		
					
	}
	/**
	 * 用户使用用户名及密码登录
	 * @param loginInfo
	 * @param response
	 * @return
	 */
	@RequestMapping("user/login")
	@ResponseBody
	public String login(@RequestParam(FinalString.LoginRequestParam) String loginInfo, 
			HttpServletResponse response){
		
		UserValidate userValidate = JsonConverter.toBean(loginInfo, UserValidate.class);
		
		
		String name = userValidate.getName();
		String password = userValidate.getPassword();
		
		
		boolean isValidate = userValidateService.isValidate(name, password);
		System.out.println(isValidate);
		int userId = userService.getUserIdByName(name);
		
		if(isValidate){
			userValidate = null;
			String token = String.valueOf(System.currentTimeMillis());
			
			TokenValidate tokenValidate = new TokenValidate();
			tokenValidate.setUserId(userId);
			tokenValidate.setToken(token);
			tokenValidate.setRequesttime(new Date());
			tokenValidate.setDeadline(new Date());
			
			tokenValidateService.deleteTokenValidateById(userId);
			
			tokenValidateService.addTokenValidate(tokenValidate);
			
			tokenValidate.setRequesttime(null);
			tokenValidate.setDeadline(null);
			
			
			String result = JsonConverter.toJson(tokenValidate);
			response.setStatus(200);
			return result;
		}else {
			response.setStatus(500);
			return "error";
		}
	}
	@RequestMapping("user/getImage")
	@ResponseBody
	public ResponseEntity<byte[]> getUserImageByUserId(@RequestParam(FinalString.UserImageRequestParam) int userId)
			throws IOException {

		String fileName = userService.getUserById(userId).getImage();
		
		String filePath = FinalString.UserImagePath + fileName;
		File file = new File(filePath);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("fileName", EncodeingConverter.convertReturnToISO(fileName));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(FileUtil.readAsByteArray(file), headers,
				HttpStatus.OK);

		return result;

	}
}
