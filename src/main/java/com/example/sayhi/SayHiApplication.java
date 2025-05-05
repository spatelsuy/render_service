package com.example.sayhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class SayHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SayHiApplication.class, args);
    }

    @GetMapping("/sayhi")
    public String sayHi(@RequestParam String name) {
        return "Hi " + name;
    }
}
