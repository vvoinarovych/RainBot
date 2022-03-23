package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command{
    public static final String UNKNOWN_MESSAGE = "I do not understand you \uD83D\uDE1F, type /help to see what can i do for you";

    private final SendMessageService sendBotMessageService;

    public UnknownCommand(SendMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
