package com.github.gbGroupProjects.tgBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public class DeleteCommand implements Command{
    private final String DELETE_MESSAGE = "You can delete your events";

    @Override
    public String execute(Update update) {
        return DELETE_MESSAGE;
    }
}
