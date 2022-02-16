package com.sabitov.demo.repositories;

import com.sabitov.demo.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {

}
