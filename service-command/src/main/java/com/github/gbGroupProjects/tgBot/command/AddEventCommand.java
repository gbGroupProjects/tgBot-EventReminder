package com.github.gbGroupProjects.tgBot.command;
import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
import com.github.gbGroupProjects.tgBot.dao.EventDao;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class AddEventCommand implements Command {

    public final static String REGEVENT_MESSAGE = "Registering new user's Event";

    private EventDao eventDao;

    public AddEventCommand(EventDao ev) {
        this.eventDao = ev;
    }

    @Override
    public String execute(Update update) {
        return REGEVENT_MESSAGE;
    }


}

