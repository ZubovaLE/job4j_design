package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    public static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        String name = "Lyubov";
        byte monthOfBirth = 8;
        short dayOfBirth = 29;
        int age = 23;
        long id = 9876543210L;
        float height = 168.8F;
        double weight = 55.45;
        char category = 'A';
        boolean married = false;
        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("User's day of birth : {}, month : {}", dayOfBirth, monthOfBirth);
        LOG.debug("User's id : {}", id);
        LOG.debug("User's height : {} and weight {}", height, weight);
        LOG.debug("Is User married?: {}, User's category: {}", married, category);
    }
}
