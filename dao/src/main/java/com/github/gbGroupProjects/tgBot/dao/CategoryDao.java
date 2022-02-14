package com.github.gbGroupProjects.tgBot.dao;

import com.github.gbGroupProjects.tgBot.dao.jdbc.dto.CategoryNumDtoDao;
import com.github.gbGroupProjects.tgBot.model.EventCategory;
import com.github.gbGroupProjects.tgBot.model.dto.CategoryGroupDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
