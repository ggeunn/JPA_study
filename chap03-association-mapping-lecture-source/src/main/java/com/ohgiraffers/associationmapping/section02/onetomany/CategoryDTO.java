package com.ohgiraffers.associationmapping.section02.onetomany;

import java.util.List;

public class CategoryDTO {

    private int CategoryCode;
    private String CategoryName;
    private Integer refCategoryCode;
    private List<MenuDTO> menuList;

    public CategoryDTO(){}

    public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode, List<MenuDTO> menuList) {
        CategoryCode = categoryCode;
        CategoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
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

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "CategoryCode=" + CategoryCode +
                ", CategoryName='" + CategoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
