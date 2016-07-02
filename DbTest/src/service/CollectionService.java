package service;

import entity.Collection;

public interface CollectionService {

	public void addCollect(Collection collection);
	public void deleteAll();
	public void deleteById(int userId, int messageId);
}
