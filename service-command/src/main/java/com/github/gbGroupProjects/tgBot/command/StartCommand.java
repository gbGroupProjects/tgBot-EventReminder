package com.github.gbGroupProjects.tgBot.command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class StartCommand implements Command {
    public final static String START_MESSAGE = "Hello. I'm a simple bot for for event remaining";

    @Override
    public String execute(Update update) {
        return START_MESSAGE;
    }
}
