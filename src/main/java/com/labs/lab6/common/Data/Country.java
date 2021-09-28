package com.labs.lab6.common.Data;

import java.io.Serializable;

/**
 * Enumeration with Countries.
 */
public enum Country implements Serializable {
    VATICAN,
    THAILAND,
    NORTH_KOREA;

    /**
     * Generates a beautiful list of enum string values.
     *
     * @return String with all enum values splitted by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (Country country : values()) {
            nameList += country.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
