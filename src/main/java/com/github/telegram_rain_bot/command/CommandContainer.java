package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.service.SendMessageService;
import com.github.telegram_rain_bot.service.WeatherClient;
import com.google.common.collect.ImmutableMap;

import static com.github.telegram_rain_bot.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageService sendMessageService, WeatherClient weatherClient) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(NO.getCommandName(), new NoCommand(sendMessageService))
                .put(WEATHER.getCommandName(), new WeatherCommand(sendMessageService, weatherClient))
                .build();

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}
