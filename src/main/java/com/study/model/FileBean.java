package com.study.model;

/**
 * 파일 정보를 나타내는 클래스입니다.
 */
public class FileBean {
    private Long fileId; // 파일 ID

    private String originalName; // 원본 파일명

    private String savedName; // 저장된 파일명

    private boolean isDeleted; // 파일 삭제 여부

    private Long boardId; // 연관된 게시물 ID

    /**
     * 파일 ID를 반환합니다.
     *
     * @return 파일 ID
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * 파일 ID를 설정합니다.
     *
     * @param fileId 파일 ID
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * 원본 파일명을 반환합니다.
     *
     * @return 원본 파일명
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * 원본 파일명을 설정합니다.
     *
     * @param originalName 원본 파일명
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * 저장된 파일명을 반환합니다.
     *
     * @return 저장된 파일명
     */
    public String getSavedName() {
        return savedName;
    }

    /**
     * 저장된 파일명을 설정합니다.
     *
     * @param savedName 저장된 파일명
     */
    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    /**
     * 파일 삭제 여부를 반환합니다.
     *
     * @return 파일 삭제 여부
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * 파일 삭제 여부를 설정합니다.
     *
     * @param deleted 파일 삭제 여부
     */
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
