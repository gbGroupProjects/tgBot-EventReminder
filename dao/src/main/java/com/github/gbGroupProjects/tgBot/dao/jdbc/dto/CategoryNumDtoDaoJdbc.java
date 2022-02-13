package com.github.gbGroupProjects.tgBot.dao.jdbc.dto;

import com.github.gbGroupProjects.tgBot.model.dto.CategoryGroupDto;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryNumDtoDaoJdbc implements CategoryNumDtoDao {

    private String sqlFindCategoriesWithSumOfExpenses = "" +
            "  SELECT   c.category_name AS categoryName, " +
            "           count(e.price) AS numOfEvents " +
            "  FROM event e " +
            "  INNER JOIN category c " +
            "  ON e.category_id = c.category_id " +
            "       WHERE date BETWEEN :dateFrom AND :dateTo " +
            "       GROUP BY e.category_id " +
            "       ORDER BY numOfEvents " +
            "       DESC";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CategoryNumDtoDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<CategoryGroupDto> findCategoriesWithSumOfExpenses(LocalDate dateFrom, LocalDate dateTo) {

        Map<String, LocalDate> paramsOfSQL = new HashMap<>();
        paramsOfSQL.put("dateFrom", dateFrom);
        paramsOfSQL.put("dateTo",  dateTo);
        return namedParameterJdbcTemplate.query(sqlFindCategoriesWithSumOfExpenses,
                paramsOfSQL,
                BeanPropertyRowMapper.newInstance(CategoryGroupDto.class));
    }
}
