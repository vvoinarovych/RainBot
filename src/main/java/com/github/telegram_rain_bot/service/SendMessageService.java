package com.github.telegram_rain_bot.service;

public interface SendMessageService {

    void sendMessage(String chatId, String message);
}
