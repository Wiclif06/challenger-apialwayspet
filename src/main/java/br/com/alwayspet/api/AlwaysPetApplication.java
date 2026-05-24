package br.com.alwayspet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AlwaysPetApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlwaysPetApplication.class, args);
    }
}
