package dao;


import java.util.List;

import entity.Comment;

public interface CommentDao {


	/**
	 * �������
	 */
	public void insertComment(Comment comment);
	/**
	 * ��������
	 */
	public void updateComment(Comment comment);
	/**
	 * ��������
	 */
	public Comment selectCommentById(int commentId);
	/**
	 * ɾ������
	 */
	public List<Comment> selectCommentByExample(Comment comment);
	/**
	 * ɾ������
	 */
	public void deleteComment(Comment comment);
	/**
	 * ɾ������
	 */
	public void deleteCommentById(int id);
	public void deleteAll();
	public List selectAllByMessageId(int messageId);
}
