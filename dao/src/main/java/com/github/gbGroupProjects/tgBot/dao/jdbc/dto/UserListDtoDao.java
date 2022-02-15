package com.github.gbGroupProjects.tgBot.dao.jdbc.dto;

import com.github.gbGroupProjects.tgBot.model.dto.UserDto;

import java.time.LocalDate;
import java.util.List;

/**
 * User DAO Interface.
 */
public interface UserListDtoDao {
    List<UserDto> findAllUsersWithEvents(LocalDate dateFrom, LocalDate dateTo);
}
