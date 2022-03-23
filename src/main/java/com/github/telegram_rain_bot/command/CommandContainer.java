package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.service.SendMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.telegram_rain_bot.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(NO.getCommandName(), new NoCommand(sendMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}
