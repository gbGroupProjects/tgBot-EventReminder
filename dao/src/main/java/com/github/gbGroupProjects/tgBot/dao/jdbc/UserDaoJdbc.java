package com.github.gbGroupProjects.tgBot.dao.jdbc;

import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.model.User;
import com.github.gbGroupProjects.tgBot.testdb.SpringJdbcConfig;

import org.springframework.context.annotation.Bean;
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
public class UserDaoJdbc implements UserDao {

    private String sqlAllUsers = "SELECT u.user_id, u.user_name, u.telegram_id FROM user u ORDER BY u.user_id";
    private String sqlSelectUserBuTelegramId = "SELECT u.user_id, u.user_name FROM user u WHERE u.telegram_Id = :telegram_id";
    private String sqlAddNewUser = "INSERT INTO user(user_id, telegram_id, user_name ) VALUES (:user_id, :telegram_id, :user_name )";
    private String sqlCountOfUsers = "SELECT count(*) FROM user";
    private String sqlCheckUniqueUserTelegramId ="SELECT count(*) FROM user WHERE telegram_id = :telegram_id";
    private String sqlGetUserByTelegramId ="SELECT u.user_id, u.user_name, u.telegram_id FROM user u WHERE telegram_id = :telegram_id";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Integer addUser(User user) {
        Map<String, Object> mapParams = new HashMap<>();
        mapParams.put("user_id", user.getUserId());
        mapParams.put("telegram_id", user.getTelegramId());
        mapParams.put("user_name", user.getName());

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(mapParams);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sqlAddNewUser, sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();
    }

    @Override
    public Integer countOfUsers() {
        return namedParameterJdbcTemplate.queryForObject(sqlCountOfUsers, new MapSqlParameterSource(), Integer.class);
    }
    @Override
    public boolean isUserTelegramIdUnique(long TelegramId)
    {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("telegram_id", TelegramId);
        return namedParameterJdbcTemplate.queryForObject(sqlCheckUniqueUserTelegramId, sqlParameterSource, Integer.class) == 0;
    }
    @Override
    public List<User> findAllUsers() {
        return namedParameterJdbcTemplate.query(sqlAllUsers, new UserRowMapper());
   //     assertTrue(users.size() == 12);
   //     users.forEach(System.err::println); // just to print  in red color
    }

    @Override
    public List<Event> getAllUserEvents(int userId) {
        return namedParameterJdbcTemplate.query(sqlAllUsers, new EventRowMapper());
    }

    @Override
    public User getUserByTelegramId(long TelegramId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("telegram_id", TelegramId);
        String sql = "SELECT u.user_id, u.user_name, u.telegram_id FROM user u WHERE u.telegram_id = " + TelegramId;
        List<User> ls = namedParameterJdbcTemplate.query(sql,  new UserRowMapper()  );
        if (ls.size() == 1 )
            return ls.get(0);
        // return ls.get(0).;
        //User res = namedParameterJdbcTemplate.queryForObject(sqlGetUserByTelegramId, sqlParameterSource, User.class);

        //User res = namedParameterJdbcTemplate.queryForObject(sqlGetUserByTelegramId, sqlParameterSource, User.class);
        return new User();
//        String sql = "SELECT USERNAME, TIMESTAMPDIFF(YEAR, DATEOFBIRTH, CURDATE()) as AGE FROM USER WHERE USERTYPE=?";
//        SqlRowSet rowset = jdbcTemplate.queryForRowSet(sql, new Object[]{userType}, new int[]{Types.VARCHAR});
//        List<Map<String, Integer>> users = new ArrayList<Map<String, Integer>>();
//        while(rowset.next()){
//            users.add(Map.of(rowset.getString("USERNAME"), rowset.getInt("Age")));
//        }

    }


    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setTelegramId(resultSet.getLong("telegram_id"));
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_Name"));
            return user;
        }
    }
    private class EventRowMapper implements RowMapper<Event> {
        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            Event ev = new Event();
            ev.setEventId(resultSet.getInt("event_id"));
            ev.setDateOfEvent(resultSet.getDate("event_date").toLocalDate());
            //  todo:  add
            return ev;
        }
    }

}

