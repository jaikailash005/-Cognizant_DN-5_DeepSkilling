package com.cognizant;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private static final Logger logger =
            LoggerFactory.getLogger(PaymentService.class);

    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackPayment")
    public String processPayment() {

        logger.info("Calling Third Party API...");

        return restTemplate.getForObject(
                "http://localhost:8082/payment",
                String.class);
    }

    public String fallbackPayment(Exception ex) {

        logger.error("Fallback Executed : {}", ex.getMessage());

        return "Payment Service Temporarily Unavailable";
    }

}