package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "I support only command starting with(/).\n"
            + "to get list of available commands type /help";

    public NoCommand(SendMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
