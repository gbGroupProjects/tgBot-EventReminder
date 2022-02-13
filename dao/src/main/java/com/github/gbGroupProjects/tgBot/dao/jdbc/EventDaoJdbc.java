package com.github.gbGroupProjects.tgBot.dao.jdbc;

import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.dao.EventDao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventDaoJdbc  implements EventDao {

    @Override
    public Integer addNewEvent(Event event) {
        return 0;  // todo:  реализовать
    }

    @Override
    public Integer countOfEvents(int OwnerId) {
        return 0; //namedParameterJdbcTemplate.queryForObject(sqlCountOfEvents, new MapSqlParameterSource(), Integer.class);
    }
}