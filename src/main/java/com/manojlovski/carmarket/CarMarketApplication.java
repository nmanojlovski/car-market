package com.manojlovski.carmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class CarMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMarketApplication.class, args);
    }


}
