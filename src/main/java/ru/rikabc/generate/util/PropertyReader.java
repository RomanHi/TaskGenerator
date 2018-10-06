package ru.rikabc.generate.util;

import java.util.ResourceBundle;

/**
 * @author Roman Khayrullin on 20.09.2018
 * @version 1.0
 */
public class PropertyReader {
    private static ResourceBundle resource = ResourceBundle.getBundle("application");

    public static String getQuery(String key) {
        return resource.getString(key);
    }

}
