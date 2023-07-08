package com.study.model;

public class CommentBean {
    private Long commentId; // 댓글 ID

    private String content; // 댓글 내용

    private String createdAt; // 작성 일시

    private Long boardId; // 연관된 게시물 ID

    /**
     * 댓글 ID를 반환합니다.
     *
     * @return 댓글 ID
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 댓글 ID를 설정합니다.
     *
     * @param commentId 댓글 ID
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 댓글 내용을 반환합니다.
     *
     * @return 댓글 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 댓글 내용을 설정합니다.
     *
     * @param content 댓글 내용
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 작성 일시를 반환합니다.
     *
     * @return 작성 일시
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 작성 일시를 설정합니다.
     *
     * @param createdAt 작성 일시
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 연관된 게시물 ID를 반환합니다.
     *
     * @return 연관된 게시물 ID
     */
    public Long getBoardId() {
        return boardId;
    }

    /**
     * 연관된 게시물 ID를 설정합니다.
     *
     * @param boardId 연관된 게시물 ID
     */
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
