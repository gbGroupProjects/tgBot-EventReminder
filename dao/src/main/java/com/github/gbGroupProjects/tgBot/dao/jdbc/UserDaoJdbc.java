package com.github.gbGroupProjects.tgBot.dao.jdbc;

import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.User;
import com.github.gbGroupProjects.tgBot.testdb.SpringJdbcConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class UserDaoJdbc implements UserDao {

    private String sqlAddNewUser = "INSERT INTO user(user_id, telegram_id, name) VALUES (:user_id, :telegram_id, :name)";
    private String sqlCountOfUsers = "SELECT count(*) FROM user";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer addUser(User user) {
        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("user_id", user.getUserId());
        mapParams.put("telegram_id", user.getTelegramId());
        mapParams.put("Name", user.getName());

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(mapParams);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sqlAddNewUser, sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();
    }

    @Override
    public Integer countOfUsers() {
        return namedParameterJdbcTemplate.queryForObject(sqlCountOfUsers, new MapSqlParameterSource(), Integer.class);
    }
}
