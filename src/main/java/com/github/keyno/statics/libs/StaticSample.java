package com.github.keyno.statics.libs;

import java.util.Objects;

public class StaticSample {

    public static String value1() {
        return "value1";
    }

    public static boolean isEqual(String value1, String value2) {
        return !Objects.isNull(value1) && value1.equals(value2);
    }
}
