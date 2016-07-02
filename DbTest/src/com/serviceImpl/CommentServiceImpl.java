package com.serviceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.CollectionDao;
import dao.CommentDao;
import entity.Comment;
import service.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentDao commentDao;

	@Override
	public void addComment(Comment comment) {

		commentDao.insertComment(comment);

	}

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public void deleteAll() {

		commentDao.deleteAll();

	}

	@Override
	public List<Comment> getAllByMessageId(int messageId) {

		return commentDao.selectAllByMessageId(messageId);
	}

	@Override
	public Comment getCommentById(int commentId) {
		
		return commentDao.selectCommentById(commentId);
	}

	

}
