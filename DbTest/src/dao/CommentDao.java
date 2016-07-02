package dao;


import java.util.List;

import entity.Comment;

public interface CommentDao {


	/**
	 * 添加评论
	 */
	public void insertComment(Comment comment);
	/**
	 * 更新评论
	 */
	public void updateComment(Comment comment);
	/**
	 * 查找评论
	 */
	public Comment selectCommentById(int commentId);
	/**
	 * 删除评论
	 */
	public List<Comment> selectCommentByExample(Comment comment);
	/**
	 * 删除评论
	 */
	public void deleteComment(Comment comment);
	/**
	 * 删除评论
	 */
	public void deleteCommentById(int id);
	public void deleteAll();
	public List selectAllByMessageId(int messageId);
}
