package com.serviceImpl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.CategoryDao;
import dao.CollectionDao;
import entity.Collection;
import service.CollectionService;

public class CollectionServiceImpl implements CollectionService {

	private CollectionDao collectionDao;

	@Override
	public void addCollect(Collection collection) {

		collectionDao.insertCollection(collection);

	}

	public CollectionDao getCollectionDao() {
		return collectionDao;
	}

	public void setCollectionDao(CollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}

	@Override
	public void deleteAll() {

		collectionDao.deleteAll();

	}

	@Override
	public void deleteById(int userId,int messageId) {

		collectionDao.deleteCollectionById(userId, messageId);

	}

}
