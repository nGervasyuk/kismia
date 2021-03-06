package com.kismia.settings;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import static java.lang.ClassLoader.getSystemResource;
import static com.kismia.settings.Browser.getByName;

public class TestConfig {
    private static Properties properties;

    static {
        properties = new Properties();
        URL props = getSystemResource("config.properties");
        try {
            properties.load(props.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    private static String browser = getProperty("browser.name");

    public static Browser getBrowser() {
        Browser browserForTests = getByName(browser);
        if (browserForTests != null) {
            return browserForTests;
        } else {
            throw new IllegalStateException("Browser name '" + browser + "' is not valid");
        }
    }
}
