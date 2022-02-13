package com.github.gbGroupProjects.tgBot.model.dto;
/*
    группировка Event по категориям... пока чисто идея
 */
public class CategoryGroupDto {
    private String categoryName;
    int numOfEvents;

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public int getSumOfEvents() {
        return 0;
    }
    public void setSumOfEvents(int num) {
        this.numOfEvents = num;
    }

    @Override
    public String toString() {
        return "CategorySumDto{" +
                "categoryName='" + categoryName + '\'' +
                ", sumOfEvents=" + numOfEvents +
                '}';
    }

}
