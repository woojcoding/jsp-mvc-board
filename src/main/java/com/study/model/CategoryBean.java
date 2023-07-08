package com.study.model;

public class CategoryBean {
    private Long categoryId; // 카테고리 ID

    private String name; // 카테고리 이름

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
     * 카테고리 이름을 반환합니다.
     *
     * @return 카테고리 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 카테고리 이름을 설정합니다.
     *
     * @param name 카테고리 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * CategoryBean 객체를 생성합니다.
     *
     * @param categoryId 카테고리 ID
     * @param name       카테고리 이름
     */
    public CategoryBean(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}

