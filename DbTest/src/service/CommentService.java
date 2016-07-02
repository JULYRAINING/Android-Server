package service;

import java.util.List;

import entity.Comment;

public interface CommentService {

	public void addComment(Comment comment);
	
	public void deleteAll();
	
	public List<Comment> getAllByMessageId(int messageId);
	
	public Comment getCommentById(int commentId);
	
}
