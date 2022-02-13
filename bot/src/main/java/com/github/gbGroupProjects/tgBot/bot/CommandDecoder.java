package com.github.gbGroupProjects.tgBot.bot;

import com.github.gbGroupProjects.tgBot.command.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.github.gbGroupProjects.tgBot.bot.CommandName.*;

@Component
public class CommandDecoder {
    private HelpCommand helpCommand;
    private StartCommand startCommand;
    private StopCommand stopCommand;
    private AddNewUserCommand addNewUserCommand;
    private UnknownCommand unknownCommand;
    private AddCategoryCommand addCategoryCommand;

    // todo:  реализовать управление командами
}
