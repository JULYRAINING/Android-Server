package service;

import entity.TokenValidate;

public interface TokenValidateService {
	public void deleteTokenValidateById(int id);
	public void addTokenValidate(TokenValidate tokenValidate);
	public TokenValidate getTokenValidate(int id);
}
