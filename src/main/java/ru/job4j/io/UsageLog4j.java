package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int age = 24;
        double weight = 78D;
        float height = 190F;
        long hairCount = 23434342432L;
        boolean male = true;
        char firstSymbolName = 'N';
        byte firstValue = 1;
        short secondValue = 15;
        LOG.debug("User info secondValue : {}, age : {}, weight : {}, height : {}, hairCount : {}, male : {}, firstSymbolName : {}, firstValue : {}", secondValue, age, weight, height, hairCount, male, firstSymbolName, firstValue);
    }
}