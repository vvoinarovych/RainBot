package com.github.telegram_rain_bot.service;

import com.github.telegram_rain_bot.model.Weather;

public interface WeatherClient {
    Weather getWeatherByCityName(String cityName);
}
