package com.github.gbGroupProjects.tgBot.dao.jdbc.dto;

import com.github.gbGroupProjects.tgBot.model.dto.CategoryGroupDto;

import java.time.LocalDate;
import java.util.List;

/**
 * CategorySumDto DAO Interface.
 */
public interface CategoryNumDtoDao {

    List<CategoryGroupDto> findCategoriesWithSumOfExpenses(LocalDate dateFrom, LocalDate dateTo);
}
