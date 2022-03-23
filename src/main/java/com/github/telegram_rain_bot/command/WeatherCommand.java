package com.github.telegram_rain_bot.command;

import com.github.telegram_rain_bot.model.Weather;
import com.github.telegram_rain_bot.service.SendMessageService;
import com.github.telegram_rain_bot.service.WeatherClient;
import org.telegram.telegrambots.meta.api.objects.Update;

public class WeatherCommand implements Command {

    private final SendMessageService sendMessageService;
    private final WeatherClient weatherClient;

    public WeatherCommand(SendMessageService sendMessageService, WeatherClient weatherClient) {
        this.sendMessageService = sendMessageService;
        this.weatherClient = weatherClient;
    }

    @Override
    public void execute(Update update) {
        String message = update.getMessage().getText().trim();
        String cityName = message.split(" ")[1];
        Weather weather = weatherClient.getWeatherByCityName(cityName);
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), weather.toString());
    }
}
