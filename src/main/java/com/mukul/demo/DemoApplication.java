package com.mukul.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/payments")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Payment Service is Running Successfully!";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message", "Payment Service is Live!");
        return response;
    }

    @PostMapping("/log")
    public Map<String, Object> logPayment(@RequestBody Map<String, Object> payment) {
        payment.put("message", "Payment Logged Successfully");
        return payment;
    }
}