package interceptor;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.JsonParseException;
import com.serviceImpl.TokenValidateServiceImpl;

import entity.TokenValidate;
import service.TokenValidateService;
import utils.JsonConverter;

public class UserHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		if(uri.endsWith("simpleRegister.do")
				||uri.endsWith("register.do")
				||uri.endsWith("login.do")
				||uri.endsWith("weixin/test.do")
				){
			return true;
		}
		
		TokenValidate tokenValidate;
		
		String tokenValidateJson = request.getParameter("token");
		
		System.out.println(tokenValidateJson);
		
		String data = request.getParameter("data");
		
		System.out.println(data);
		
		String image = request.getParameter("uploadImage");
		
		System.out.println(image);
		Enumeration<String> parameterNames = request.getParameterNames();
		System.out.println("~~~~~~~~`");
		while (parameterNames.hasMoreElements()) {
			String string = (String) parameterNames.nextElement();
			System.out.println(string);
			
		}
		System.out.println("~~~~~~~~`");
		System.out.println(uri);
		System.out.println(tokenValidateJson);
		if(tokenValidateJson == null){
			System.out.println("δ��Ȩ");
			return false;
		}else {
			TokenValidateService tokenValidateService = new TokenValidateServiceImpl();
			try{
				tokenValidate = JsonConverter
						.toBean(tokenValidateJson, TokenValidate.class);
			}catch(JsonParseException e)
			{
				System.out.println("Josn����ʧ��");
				return false;
			}			
			
			int userId = tokenValidate.getUserId();
			
			TokenValidate tokenValidateBO = tokenValidateService.getTokenValidate(userId);
			
			String dbToken;
			
			if(tokenValidateBO!=null){
				dbToken = tokenValidateBO.getToken();
				if(dbToken.equals(tokenValidate.getToken())){
					System.out.println("�����֤�ɹ�");
					return true;
				}else {
					
					System.out.println("��Ȩ�����");
					return false;
				}
			}else {
				//�����ڴ��û�
				System.out.println("�����ڴ��û�");
				return false;
			}
			
			
			
			
			
		}
		
			/*String token = request.getParameter("token");
			System.out.println(uri);
			System.out.println(token);

			String dbToken = tokenValidateService.getTokenValidate(1).getToken();
			System.out.println(dbToken);
			
			if (dbToken.equals(token)) {
				
				System.out.println("��֤�ɹ�");
				return true;
			
			} else {
				
				System.out.println("��֤ʧ��");
				response.setStatus(500);
				return false;

			}*/

		

	}

}
