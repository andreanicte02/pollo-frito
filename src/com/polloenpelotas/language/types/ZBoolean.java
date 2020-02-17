package com.polloenpelotas.language.types;

public class ZBoolean extends ZProtoObject {

    private final boolean value;

    public ZBoolean(boolean value) {
        this.value = value;
    }


    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
