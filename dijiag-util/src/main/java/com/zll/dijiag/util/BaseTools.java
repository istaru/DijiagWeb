package com.zll.dijiag.util;


import java.util.UUID;

public class BaseTools {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
