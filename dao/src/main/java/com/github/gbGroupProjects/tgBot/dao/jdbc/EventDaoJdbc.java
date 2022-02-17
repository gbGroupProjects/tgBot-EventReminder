package com.github.gbGroupProjects.tgBot.dao.jdbc;


import com.github.gbGroupProjects.tgBot.dao.EventDao;
import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventDaoJdbc  implements EventDao {
    private String sqlAllUserEvents     = "SELECT e.event_id, e.user_name, e.category_id, e.comment, e.date, e.active  FROM event e WHERE e.user_id = :user_id ORDER BY e.event_id";
    private String sqlAddNewEvent       = "INSERT INTO event(user_id, comment ) VALUES (:user_id, :comment )";
    private String sqlCountOfUserEvents = "SELECT count(*) FROM event";
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EventDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer addEvent(int user_id, Event event) {
            Map<String, Object> mapParams = new HashMap<>();
            mapParams.put("user_id", user_id);
            mapParams.put("comment", event.getCommentToDo());
            // todo:
            SqlParameterSource sqlParameterSource = new MapSqlParameterSource(mapParams);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(sqlAddNewEvent, sqlParameterSource, keyHolder);
            return (Integer) keyHolder.getKey();
    }

    @Override
    public List<Event> getAllUserEvents(int userId) {
        return namedParameterJdbcTemplate.query(sqlAllUserEvents, new EventRowMapper());
    }

    public Integer countOfUserEvents(int user_id) {
        return namedParameterJdbcTemplate.queryForObject(sqlCountOfUserEvents + " WHERE e.user_id = " + user_id, new MapSqlParameterSource(), Integer.class);
    }

    private class EventRowMapper implements RowMapper<Event> {
        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            Event ev = new Event();
            ev.setEventId(resultSet.getInt("event_id"));
            ev.setDateOfEvent(resultSet.getDate("date").toLocalDate());
            ev.setCommentToDo(resultSet.getString("comment"));

            //  todo:  add
            return ev;
        }
    }
}
