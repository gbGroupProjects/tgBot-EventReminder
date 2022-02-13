package com.github.gbGroupProjects.tgBot.dao;

import com.github.gbGroupProjects.tgBot.model.EventCategory;
import java.util.List;
/**
 * Category DAO Interface.
 */
public interface CategoryDao {
    /**
     * Get all categories
     * @return Category list
     */
    List<EventCategory> findAllCategories();

    /**
     * Create new Category
     * @param category - category to create
     * @return - id of the created category
     */
    Integer addNewCategory(EventCategory category);

    /**
     * Check unique category name
     * @param categoryName - Category name
     * @return - true if the category is missing
     */
    boolean isCategoryUnique(String categoryName);

    /**
     * Get count of all categories
     * @return - count of all categories
     */
    Integer countOfCategories();
}
