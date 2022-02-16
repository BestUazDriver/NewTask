package com.sabitov.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weather")
public class Weather {
    @Id
    private Long id;
    @Column(name = "temp")
    private String temp;
    @Column(name = "request_time")
    private String reqTime;
}
