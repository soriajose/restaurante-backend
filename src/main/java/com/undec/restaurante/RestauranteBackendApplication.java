package com.undec.restaurante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        RestauranteBackendApplication.class,
        Jsr310JpaConverters.class
})
public class RestauranteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestauranteBackendApplication.class, args);
    }

}
