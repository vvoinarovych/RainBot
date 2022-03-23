package com.github.telegram_rain_bot.service;
import com.github.telegram_rain_bot.bot.RainBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendMessageServiceImpl implements SendMessageService{

    private final RainBot rainBot;

    @Autowired
    public SendMessageServiceImpl(RainBot rainBot) {
        this.rainBot = rainBot;
    }


    @Override
    public void sendMessage(String chatId, String message) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            rainBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
