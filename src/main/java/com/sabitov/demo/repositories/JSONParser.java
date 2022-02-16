package com.sabitov.demo.repositories;

import com.sabitov.demo.models.Weather;

import java.util.Date;

public class JSONParser {
    public Weather weatherParse(String content){
        Weather weather = new Weather();
        String[] split = content.split(",");
        System.out.println(split[7]);
        System.out.println(split[8]);
        System.out.println(split[9]);
        weather.setTemp(split[7].replace("\"main\":\\{\"temp\":",""));
        weather.setReqTime(new Date().toString());
        return weather;
    }
}
