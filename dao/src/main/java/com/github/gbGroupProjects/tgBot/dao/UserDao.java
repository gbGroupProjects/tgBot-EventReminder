package com.github.gbGroupProjects.tgBot.dao;

import com.github.gbGroupProjects.tgBot.model.User;
import java.util.List;

/**
 * User DAO Interface.
 */
public interface UserDao {
    /**
     * Get all categories
     * @return Category list
     */
    List<User> findAllUsers();

    /**
     * Create new Category
     * @param user - category to create
     * @return - id of the created user
     */
    Integer addNewUser(User user);

    /**
     * Check unique category name
     * @param  TelegramId - Telegram ID of a user
     * @return - true if the Telegram exist
     */
    boolean isUserTelegramIdUnique(int TelegramId);

    /**
     * Get count of all users
     * @return - count of all users
     */
    Integer countOfUsers();
}