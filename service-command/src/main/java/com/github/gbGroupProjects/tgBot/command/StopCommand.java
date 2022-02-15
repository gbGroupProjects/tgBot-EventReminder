package com.github.gbGroupProjects.tgBot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StopCommand implements Command {
    public static final String STOP_MESSAGE = "Session completed. Bye";

    @Override
    public String execute(Update update) {
        return STOP_MESSAGE;
    }
}