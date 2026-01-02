package com.varsha.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private static Properties properties = new Properties();
    static
    {
        try(InputStream input = configReader.class.getClassLoader().
                getResourceAsStream("config.properties"))
        {
            properties.load(input);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }


    public static String get(String key) {
        return properties.getProperty(key);
    }
}
