package dao;

import entity.TokenValidate;

public interface TokenValidateDao {
	public void insertToken(TokenValidate tokenValidate);
	public TokenValidate selectToken(int id);
	public void deleteTokenById(int id);
}
