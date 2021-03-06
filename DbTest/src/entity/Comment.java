package entity;// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

// Generated 2015-12-5 12:46:46 by Hibernate Tools 3.4.0.CR1

/**
 * Comment generated by hbm2java
 */
public class Comment implements java.io.Serializable {

	@Expose
	private int commentId;
	@Expose
	private String content;
	
	private UserDetail user;
	@Expose
	private String userName;
	private Message message;
	@Expose
	private Comment refComment;
	@Expose
	private String refCommentUserName;
	
	
	
	private Date time;
	
	private Set<Comment>childComments = new HashSet<Comment>();
	
	

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Comment getRefComment() {
		return refComment;
	}

	public void setRefComment(Comment refComment) {
		this.refComment = refComment;
	}

	public Set<Comment> getChildComments() {
		return childComments;
	}

	public void setChildComments(Set<Comment> childComments) {
		this.childComments = childComments;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRefCommentUserName() {
		return refCommentUserName;
	}

	public void setRefCommentUserName(String refCommentUserName) {
		this.refCommentUserName = refCommentUserName;
	}


	



	
}
