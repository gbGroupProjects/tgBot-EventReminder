package com.github.gbGroupProjects.tgBot.dao;
import com.github.gbGroupProjects.tgBot.model.Event;

public interface EventDao {
    /**
     * Create new Expense
     * @param event - event to create
     * @return - id of the created event
     */
    Integer addNewEvent(Event event);

    /**
     * Get count of all events
     * @return - count of all events by Owner id
     */
    Integer countOfEvents(int id);
}
