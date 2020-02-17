package com.polloenpelotas.language.types;

public class ZNumeric extends ZProtoObject {

    private final double value;

    public ZNumeric(double value) {
        this.value = value;
    }

    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
