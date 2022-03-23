package com.github.telegram_rain_bot.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with", builderMethodName = "Builder")
public class Weather {

    private Double temperature;
    private Integer pressure;
    private Integer humidity;
    private Integer windSpeed;
    private String cityName;
    private String countryName;

    @Override
    public String toString() {
        return "Location: " + cityName +
                "\nTemperature: " + temperature + " C" +
                "\nPressure: " + pressure + " Pa" +
                "\nHumidity: " +humidity + " %" +
                "\nWind speed: " + windSpeed+ " km/hour" + "\n";
    }
}
