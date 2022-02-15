package com.github.gbGroupProjects.tgBot.dao.jdbc;

import com.github.gbGroupProjects.tgBot.model.User;
import com.github.gbGroupProjects.tgBot.testdb.SpringJdbcConfig;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@Import({UserDaoJdbc.class})
@ContextConfiguration(classes = SpringJdbcConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class UserDaoJdbcTestIT {

    private UserDaoJdbc userDaoJdbc;

    public UserDaoJdbcTestIT(@Autowired UserDaoJdbc userDaoJdbc) {
        this.userDaoJdbc = userDaoJdbc;
    }

    @Test
    void testAddNewUser() {

        assertNotNull(userDaoJdbc);
        int countOfUsersBefore = userDaoJdbc.countOfUsers();

        User user = new User();
        user.setName("tester_aw_0001");
        user.setTelegramId(10000000L);

        Integer userId = userDaoJdbc.addUser(user);
        assertNotNull(userId);
        int countOfUsersAfter = (userDaoJdbc.countOfUsers());
        assertEquals(countOfUsersBefore, countOfUsersAfter - 1);
    }

    @Test
    void testCountOfUsers() {

        assertNotNull(userDaoJdbc);
        Integer countUser = userDaoJdbc.countOfUsers();
        assertNotNull(countUser);

        User user = new User();
        user.setName("user_test_0002");
        user.setTelegramId(20000001L);

        userDaoJdbc.addUser(user);
        Integer countUserAfterAdd = userDaoJdbc.countOfUsers();
        assertNotNull(countUserAfterAdd);
        assertEquals(countUser + 1, countUserAfterAdd);
    }
}