package com.labs.lab6.common.Data;

/**
 * Enumeration with Colors.
 */
public enum Color {
    GREEN,
    YELLOW,
    ORANGE,
    BLACK;

    /**
     * Generates a beautiful list of enum string values.
     *
     * @return String with all enum values splitted by comma.
     */
    public static String nameList() {
        String nameList = "";
        for (Color color : values()) {
            nameList += color.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
