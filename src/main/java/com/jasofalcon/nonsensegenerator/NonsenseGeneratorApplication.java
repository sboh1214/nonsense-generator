package com.jasofalcon.nonsensegenerator;

import com.jasofalcon.nonsensegenerator.service.NonsenseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NonsenseGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NonsenseGeneratorApplication.class, args);
    }
}
