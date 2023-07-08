package com.study.model;

public class BoardBean {
    private Long boardId; // 게시글 ID

    private Long categoryId; // 카테고리 ID

    private String writer; // 작성자

    private String password; // 비밀번호

    private String title; // 제목

    private String content; // 내용

    private String views; // 조회수

    private String createdAt; // 작성일

    private String modifiedAt; // 수정일

    /**
     * 게시글 ID를 반환합니다.
     *
     * @return 게시글 ID
     */
    public Long getBoardId() {
        return boardId;
    }

    /**
     * 게시글 ID를 설정합니다.
     *
     * @param boardId 게시글 ID
     */
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    /**
     * 카테고리 ID를 반환합니다.
     *
     * @return 카테고리 ID
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 카테고리 ID를 설정합니다.
     *
     * @param categoryId 카테고리 ID
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 작성자를 반환합니다.
     *
     * @return 작성자
     */
    public String getWriter() {
        return writer;
    }

    /**
     * 작성자를 설정합니다.
     *
     * @param writer 작성자
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * 비밀번호를 반환합니다.
     *
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * 비밀번호를 설정합니다.
     *
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 제목을 반환합니다.
     *
     * @return 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * 제목을 설정합니다.
     *
     * @param title 제목
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 내용을 반환합니다.
     *
     * @return 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 내용을 설정합니다.
     *
     * @param content 내용
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 조회수를 반환합니다.
     *
     * @return 조회수
     */
    public String getViews() {
        return views;
    }

    /**
     * 조회수를 설정합니다.
     *
     * @param views 조회수
     */
    public void setViews(String views) {
        this.views = views;
    }

    /**
     * 작성일을 반환합니다.
     *
     * @return 작성일
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 작성일을 설정합니다.
     *
     * @param createdAt 작성일
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 수정일을 반환합니다.
     *
     * @return 수정일
     */
    public String getModifiedAt() {
        return modifiedAt;
    }

    /**
     * 수정일을 설정합니다.
     *
     * @param modifiedAt 수정일
     */
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
