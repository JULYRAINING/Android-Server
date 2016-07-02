package dao;

import java.util.List;

import entity.Collection;

public interface CollectionDao {

	/**
	 * 添加收藏
	 */
	public void insertCollection(Collection collection);

	/**
	 * 更新收藏
	 */
	public void updateCollection(Collection collection);

	public void deleteAll();

	public List selectCollectionByUserId(int userId);

	public void deleteCollectionById(int userId, int messageId);

}
