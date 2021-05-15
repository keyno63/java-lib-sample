package com.github.keyno.statics;

import com.github.keyno.statics.libs.StaticSample;

public class UseStaticSample {

    private final String value;

    public UseStaticSample(String value) {
        this.value = value;
    }

    public String function(String value) {
        final boolean isEquals = StaticSample.isEqual(this.value, value);
        if (isEquals) {
            return String.format("Arg value is equal, value =[%s]", value);
        } else {
            return "Not Equal";
        }
    }
}
