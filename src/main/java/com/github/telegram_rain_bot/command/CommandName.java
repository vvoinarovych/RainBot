package com.github.telegram_rain_bot.command;

public enum CommandName {

    START("/start"),
    HELP("/help"),
    NO("no command"),
    WEATHER("/weather");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
