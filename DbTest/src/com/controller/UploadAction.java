package com.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller()
public class UploadAction {

	@RequestMapping("upload/image")
	@ResponseBody
	public void addImage(@RequestParam("uploadImage") MultipartFile[] files) 
			throws IllegalStateException, IOException {
		
		for (int i = 0; i < files.length; i++) {

			if (i == 0) {
				File targetFile = new File("F:/1.png");
				files[i].transferTo(targetFile);
			} else if (i == 1) {
				File targetFile = new File("F:/2.png");
				files[i].transferTo(targetFile);
			}

		}

	}
	@RequestMapping("upload/dataJson")
	@ResponseBody
	public void addData(@RequestParam("data") String dataStr, 
			@RequestParam("uploadImage") MultipartFile[] files) throws IllegalStateException, IOException{
		System.out.println(dataStr);
		for (int i = 0; i < files.length; i++) {

			if (i == 0) {
				File targetFile = new File("F:/1.png");
				files[i].transferTo(targetFile);
			} else if (i == 1) {
				File targetFile = new File("F:/2.png");
				files[i].transferTo(targetFile);
			}

		}
	}
	

	/*
	 * @RequestMapping("uploadImage")
	 * 
	 * @ResponseBody public void addImage(HttpServletRequest request) throws
	 * IllegalStateException, IOException {
	 * 
	 * MultipartHttpServletRequest multipartHttpServletRequest =
	 * (MultipartHttpServletRequest) request;
	 * 
	 * 
	 * 
	 * 
	 * List<MultipartFile> fileList =
	 * multipartHttpServletRequest.getFiles("uploadfile"); int fileCount =
	 * fileList.size(); System.out.println(fileCount); for (int i = 0; i <
	 * fileCount; i++) {
	 * 
	 * if (i == 0) { File targetFile = new File("F:/1.png");
	 * fileList.get(i).transferTo(targetFile); } else if (i == 1) { File
	 * targetFile = new File("F:/2.png");
	 * fileList.get(i).transferTo(targetFile); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

}
