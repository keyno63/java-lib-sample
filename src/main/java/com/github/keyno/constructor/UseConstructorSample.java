package com.github.keyno.constructor;

public class UseConstructorSample {

    public String useMethod(String arg1, String arg2) {
        ConstructorSample sample = new ConstructorSample(arg1);
        return sample.method(arg2);
    }

    public record ConstructorSample(String value) {

        public String method(String arg) {
            return String.format("field=[%s], method=[%s]", value, arg);
        }
    }
}

