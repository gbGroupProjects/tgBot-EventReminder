package com.github.gbGroupProjects.tgBot.model;
/*
    Категория Event - день рождения, или личное событие, или бизнас события
 */
public class EventCategory {
    private Integer categoryId;
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Event Category{" +
                "Id=" + categoryId +
                ", Name='" + categoryName + '\'' +
                '}';
    }

}
