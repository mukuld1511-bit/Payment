package com.mukul.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/payments")
public class DemoApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostMapping("/log")
    public Map<String, Object> logPayment(@RequestBody Map<String, Object> payment) {
        mongoTemplate.save(payment, "payments");
        return payment;
    }

    @GetMapping("/logs")
    public List<Map> getLogs() {
        return mongoTemplate.findAll(Map.class, "payments");
    }
}
