package com.github.gbGroupProjects.tgBot.bot;

import com.github.gbGroupProjects.tgBot.command.*;

import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.github.gbGroupProjects.tgBot.bot.CommandName.*;

@Component
public class CommandContainer {
    private HelpCommand helpCommand;
    private StartCommand startCommand;
    private StopCommand stopCommand;

    private AddUserCommand addUserCommand;
//    private AddCategoryCommand addCategoryCommand;
//  private AddEventCommand addEventCommand;

    private UnknownCommand unknownCommand;

    // todo:  реализовать управление командами
    private Map<String, Command> commandMap = new HashMap<>();

    public AddUserCommand getUserCommand() {
        return addUserCommand;
    }

    public boolean isUserTelegramIdUnique(long TelegramId) {
        return addUserCommand.isUserTelegramIdUnique(TelegramId);
}


    public Command defineCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

    @Autowired
    public void setHelpCommand(HelpCommand helpCommand) {
        this.helpCommand = helpCommand;
        commandMap.put(HELP.getCommandName(), helpCommand);
    }
    @Autowired
    public void setStartCommand(StartCommand startCommand) {
        this.startCommand = startCommand;
        commandMap.put(START.getCommandName(), startCommand);
    }
    @Autowired
    public void setStopCommand(StopCommand stopCommand) {
        this.stopCommand = stopCommand;
        commandMap.put(STOP.getCommandName(), stopCommand);
    }

    @Autowired
    public void setAddUserCommand(AddUserCommand com) {
        this.addUserCommand = com;
        commandMap.put(ADDUSER.getCommandName(), com);
    }
/*    @Autowired
//    public void setAddCategoryCommand(AddCategoryCommand com) {
//        this.addCategoryCommand = com;
//        commandMap.put(ADDEVENTCATEGORY.getCommandName(), com);
//    }
    @Autowired
    public void setAddEventCommand(AddEventCommand com) {
        this.addEventCommand = com;
        commandMap.put(ADDEVENT.getCommandName(), com);
    }

 */
    @Autowired
    public void setUnknownCommand(UnknownCommand unknownCommand) {
        this.unknownCommand = unknownCommand;
    }

//    @Autowired
//    public void setCodeCommand(CodeCommand codeCommand) {
//        this.codeCommand = codeCommand;
//        commandMap.put(CODE.getCommandName(), codeCommand);
//    }
//    @Autowired
//    public void setGetCommand(GetCommand getCommand) {
//        this.getCommand = getCommand;
//        commandMap.put(GET.getCommandName(), getCommand);
//    }
}
