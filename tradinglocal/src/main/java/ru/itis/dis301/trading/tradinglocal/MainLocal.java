package ru.itis.dis301.trading.tradinglocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainLocal {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainLocal.class, args);
    }
}
