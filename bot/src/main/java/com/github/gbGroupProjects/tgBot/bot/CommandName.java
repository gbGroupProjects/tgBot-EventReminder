package com.github.gbGroupProjects.tgBot.bot;
/*
    помощник распознавания команд
 */
public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    DELETE("/delete"),
    GET("/get"),

    ADDUSER("/add"),
    ADDEVENT("/addevent"),
    ADDEVENTCATEGORY("/addcategory");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
