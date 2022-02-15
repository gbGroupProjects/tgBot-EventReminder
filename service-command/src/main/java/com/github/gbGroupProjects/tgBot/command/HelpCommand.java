package com.github.gbGroupProjects.tgBot.command;


import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class HelpCommand implements Command {

    public static final String HELP_MESSAGE = "I can help you..\n" +
            "<b>Register in bot</b>\n" +
            "/reg - init registration \n" +

            "<b>Use following command to get your events</b>\n" +
                "/get dd.mm.yyyy - get information for the chosen day\n" +
                "/get dd.mm.yyyy-dd.mm.yyyy - get information for the chosen period\n" +
                "/get [Period world] - get information for the specific period\n" +
                "   Period worlds: DAY, WEEK, MONTH, YEAR, ALL";


    @Override
    public String execute(Update update) {
        return HELP_MESSAGE;
    }
}
