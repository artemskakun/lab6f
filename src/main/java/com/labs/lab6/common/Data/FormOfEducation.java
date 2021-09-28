package com.labs.lab6.common.Data;

import java.io.Serializable;

/**
 * Enumeration with Forms Of Education.
 */
public enum FormOfEducation implements Serializable {
    DISTANCE_EDUCATION,
    FULL_TIME_EDUCATION,
    EVENING_CLASSES;

    /**
     * Generates a beautiful list of enum string values.
     *
     * @return String with all enum values splitted by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (FormOfEducation formOfEducation : values()) {
            nameList += formOfEducation.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}