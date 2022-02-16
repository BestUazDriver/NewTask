package com.sabitov.demo.weather;

import com.sabitov.demo.models.Weather;
import com.sabitov.demo.repositories.JSONParser;
import com.sabitov.demo.repositories.WeatherInfo;
import com.sabitov.demo.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@Controller
@RequestMapping("/weatherInfo")
public class WeatherController {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    private final String keyApi = "61c4a7fe2f5767b8c857034ee7ab4c50";

    @GetMapping
    public String getWeatherInf(@RequestParam(name = "city", defaultValue = "Kazan") String city, HttpServletResponse resp) {
        URL url = null;
        PrintWriter out = null;
        try {

            url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + keyApi);
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = new WeatherInfo().getInfo(url);
        out.print(content);
        out.flush();
        System.out.println(content);
        Weather weather = new JSONParser().weatherParse(content);
        weatherRepository.save(weather);
        return content;
    }
}
