package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Message;

public class JsonConverter {
	
	public static <T>T toBean(String jsonString,Class classType){
		Gson gson = new Gson();
		T bean = gson.fromJson(jsonString, classType);
		
		
		return bean;
	}
	public static String toJson(Object object){
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
		
	}
	public static String toJsonExcludeWithoutExpose(Object object){
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(object);
		return json;
		
	}
	
}
