package com.tst.comment;

//게시글 번호, 댓글 번호, 댓글내용, 아이디(작성자), 작성일자

public class CommentVO {
	
	//필드
	private int boardId;
	private int commentId;
	private String commentContent;
	private String id;
	private String commentDate;
	
	public CommentVO() {}
	public CommentVO (int boardId, int commentId, String commentContent, String id, String commentDate) {
		  super();
		  this.boardId= boardId;
		  this.commentId=commentId;
		  this.commentContent=commentContent;
		  this.id=id;
		  this.commentDate=commentDate;		  
		}
	
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
}
