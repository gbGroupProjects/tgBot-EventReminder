package com.github.gbGroupProjects.tgBot.command;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class AddNewUserCommand implements Command {

    public final static String REGNEWUSER_MESSAGE = "Registering new user";

    @Override
    public String execute(Update update) {
        return REGNEWUSER_MESSAGE;
    }
}

