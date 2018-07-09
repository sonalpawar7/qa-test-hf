package com.hf.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {

    Properties prop;
    InputStream input = null;

    public FileUtils(String fileName) throws IOException {
        prop = new Properties();
        input = new FileInputStream(fileName);

        prop.load(input);
    }

    public String getValue(String key) {
        try {
            return prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
