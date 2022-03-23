package com.github.telegram_rain_bot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.telegram_rain_bot.model.Weather;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


@Log4j2
public class OpenWeatherMapClient implements WeatherClient{


    @Value("${open_weather.token}")
    private String appId;

    @Override
    public Weather getWeatherByCityName(String city) {
        ObjectNode cityNode = getObjectNode(city);
        return buildDto(cityNode);
    }

    private ObjectNode getObjectNode(String city)  {
        URL url = buildUrl(city);
        ObjectNode node = null;
        try {
            node = new ObjectMapper().readValue(url, ObjectNode.class);
        } catch (IOException e) {
            log.error(e);
        }
        return node;
    }

    private URL buildUrl(String city){
        URL url = null;
        try {
            url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city +
                    "&units=metric&appid=" + appId);
        } catch (MalformedURLException e) {
            log.error(e);
        }
        log.info(url);
        return url;
    }

    private Weather buildDto(ObjectNode node) {
        return Weather.Builder()
                .withTemperature(node.get("main").get("temp").asDouble())
                .withPressure(node.get("main").get("pressure").asInt())
                .withHumidity(node.get("main").get("humidity").asInt())
                .withWindSpeed(node.get("wind").get("speed").asInt())
                .withCityName(node.get("name").asText())
                .withCountryName(node.get("sys").get("country").asText())
                .build();
    }
}
