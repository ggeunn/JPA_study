package com.ohgiraffers.associationmapping.section01.manytoone;

public class CategoryDTO {

    private int CategoryCode;
    private String CategoryName;
    private Integer refCategoryCode;

    public CategoryDTO(){}

    public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.CategoryCode = categoryCode;
        this.CategoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        CategoryCode = categoryCode;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "CategoryCode=" + CategoryCode +
                ", CategoryName='" + CategoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
