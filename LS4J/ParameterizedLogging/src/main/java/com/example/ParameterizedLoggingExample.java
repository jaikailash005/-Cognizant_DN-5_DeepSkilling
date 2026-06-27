package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String name = "John";
        int age = 25;

        logger.info("User Name: {}, Age: {}", name, age);

        logger.warn("User {} is {} years old", name, age);

        logger.error("Error while processing user {}", name);
    }
}