package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.telegram_rain_bot.command.CommandName.HELP;
import static com.github.telegram_rain_bot.command.CommandName.START;

public class HelpCommand implements Command{

    private final SendMessageService sendMessageService;

    public static final String HELP_MESSAGE = String.format("""
                    ✨<b>Available commands</b>✨
                    <b>Start\\finish work with bot</b>
                    %s - start working with me
                    %s - receive help
                    """,
            START.getCommandName(),  HELP.getCommandName());

    public HelpCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
