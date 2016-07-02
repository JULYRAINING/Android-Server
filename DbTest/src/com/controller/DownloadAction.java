package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DownloadAction {
	
	@RequestMapping("download/getImage")
	public ResponseEntity<byte[]> getImage() throws IOException{
		
		File file = new File("F:"+File.separator+"111.png");
		HttpHeaders headers = new HttpHeaders();
		
		String fileName = new String("Í¼Æ¬.png".getBytes("UTF-8"),"ISO-8859-1");
		headers.setContentDispositionFormData("fileName", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(
				FileUtil.readAsByteArray(file),headers,HttpStatus.OK);
	
		return result;
		
	}
	@RequestMapping(value ="download/getJsonData")
	@ResponseBody
	public String getData() throws UnsupportedEncodingException{
		return new String("ÎÚÀ¼°ÍÍÐµÄÒ¹".getBytes("utf-8"),"iso-8859-1");
	}
	@RequestMapping("download/getString")
	@ResponseBody
	public String getString(@RequestParam("name") String str) throws UnsupportedEncodingException{
		

		System.out.println(str);
		
		return new String(str.getBytes("utf-8"),"iso-8859-1");
	}
	

}
