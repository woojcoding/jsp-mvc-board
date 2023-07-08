package com.study.model;

public class BoardSearchCondition {
    private String startDate; // 검색 시작일

    private String endDate; // 검색 종료일

    private String categoryId; // 카테고리 ID

    private String keyword; // 검색 키워드

    /**
     * BoardSearchCondition 객체를 생성합니다.
     *
     * @param startDate   검색 시작일
     * @param endDate     검색 종료일
     * @param categoryId  카테고리 ID
     * @param keyword     검색 키워드
     */
    public BoardSearchCondition(String startDate, String endDate, String categoryId, String keyword) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.categoryId = categoryId;
        this.keyword = keyword;
    }

    /**
     * 검색 시작일을 반환합니다.
     *
     * @return 검색 시작일
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 검색 시작일을 설정합니다.
     *
     * @param startDate 검색 시작일
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 검색 종료일을 반환합니다.
     *
     * @return 검색 종료일
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 검색 종료일을 설정합니다.
     *
     * @param endDate 검색 종료일
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 카테고리 ID를 반환합니다.
     *
     * @return 카테고리 ID
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 카테고리 ID를 설정합니다.
     *
     * @param categoryId 카테고리 ID
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 검색 키워드를 반환합니다.
     *
     * @return 검색 키워드
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 검색 키워드를 설정합니다.
     *
     * @param keyword 검색 키워드
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
