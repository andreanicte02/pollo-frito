package com.polloenpelotas.language.types;

public class ZInteger extends ZProtoObject {
    private final int value;
    ZInteger(int value) {
        this.value = value;
    }

    public ZInteger add(ZInteger e) {
        return new ZInteger(value + e.value);
    }
    public ZString add(ZString e) {
        return new ZString(value + e.getValue());
    }

    public int getValue() {
        return value;
    }
}
