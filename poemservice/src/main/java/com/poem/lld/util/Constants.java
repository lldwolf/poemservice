package com.poem.lld.util;

public class Constants {

    static {
        init();
    }

    public static String LINE_SEPARATOR;

    private static void init() {
        LINE_SEPARATOR = System.getProperty("line.separator");
    }
}
