package com.github.gbGroupProjects.tgBot.dao.jdbc;

import com.github.gbGroupProjects.tgBot.model.EventCategory;
import com.github.gbGroupProjects.tgBot.testdb.SpringJdbcConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@Import({CategoryDaoJdbc.class})
@ContextConfiguration(classes = SpringJdbcConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
class CategoryDaoJdbcTestIT {

    private CategoryDaoJdbc categoryDaoJdbc;

    public CategoryDaoJdbcTestIT(@Autowired CategoryDaoJdbc categoryDaoJdbc) {
        this.categoryDaoJdbc = categoryDaoJdbc;
    }

    @Test
    void testFindAllCategories() {

        assertNotNull(categoryDaoJdbc);
        assertNotNull(categoryDaoJdbc.findAllCategories());
    }

    @Test
    void testAddNewCategory() {

        assertNotNull(categoryDaoJdbc);
        int categorySizeBefore = categoryDaoJdbc.countOfCategories();
        EventCategory category = new EventCategory();
        category.setCategoryId(7);
        category.setCategoryName("Test Category 1");
        Integer categoryId = categoryDaoJdbc.addNewCategory(category);
        assertNotNull(categoryId);
        assertEquals(categorySizeBefore, categoryDaoJdbc.countOfCategories() - 1);
    }

    @Test
    void testCountOfCategories() {
        assertNotNull(categoryDaoJdbc);
        Integer countCategory = categoryDaoJdbc.countOfCategories();
        assertNotNull(countCategory);
        assertTrue(countCategory > 0);
        EventCategory category = new EventCategory();
        category.setCategoryId(7);
        category.setCategoryName("Test Category 3");
        categoryDaoJdbc.addNewCategory(category);
        Integer countCategoryAfterAdd = categoryDaoJdbc.countOfCategories();
        assertEquals(countCategory + 1, countCategoryAfterAdd);
    }

    @Test
    void testIsCategoryUnique() {
        assertNotNull(categoryDaoJdbc);
        EventCategory category = new EventCategory();
        category.setCategoryId(7);
        category.setCategoryName("Test Category 2");
        //todo make category initialization before tests
        boolean isUnique = categoryDaoJdbc.isCategoryUnique("Test Category 2");
        assertTrue(isUnique);
        categoryDaoJdbc.addNewCategory(category);
        boolean isNotUnique = categoryDaoJdbc.isCategoryUnique("Test Category 2");
        assertFalse(isNotUnique);
    }
}