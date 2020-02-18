package com.polloenpelotas.language.types;

import org.jetbrains.annotations.NotNull;

public class ZInteger extends ZProtoObject {
    private final int value;

    public ZInteger(int value) {
        this.value = value;
    }

    public ZInteger add(ZInteger e) {
        return new ZInteger(value + e.value);
    }
    public ZString  add( ZString e) {
        return new ZString(value + e.getValue());
    }

    public ZInteger unaryMinus (ZInteger e) {
        return  new ZInteger(value * e.getValue());
    }

    public  ZInteger mult(ZInteger e){
        return new ZInteger(value * e.getValue());
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
