package com.hf.utils;

import org.apache.log4j.Logger;

import java.util.Calendar;

public class JavaUtils {

    Logger logger = Logger.getLogger(JavaUtils.class);

    public String createRandomEmail() {
        long c = Calendar.getInstance().getTimeInMillis();
        return c + "@yopmail.com";
    }
}
