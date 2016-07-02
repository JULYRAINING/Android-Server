package utils;

import java.io.UnsupportedEncodingException;

public class EncodeingConverter {

	public static String convertReturnToISO(String result){
		try {
			return new String(result.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
	}
}
