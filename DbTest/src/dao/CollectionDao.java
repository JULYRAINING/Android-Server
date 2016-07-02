package dao;

import java.util.List;

import entity.Collection;

public interface CollectionDao {

	/**
	 * ����ղ�
	 */
	public void insertCollection(Collection collection);

	/**
	 * �����ղ�
	 */
	public void updateCollection(Collection collection);

	public void deleteAll();

	public List selectCollectionByUserId(int userId);

	public void deleteCollectionById(int userId, int messageId);

}
