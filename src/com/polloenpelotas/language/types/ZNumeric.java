package com.polloenpelotas.language.types;

public class ZNumeric extends ZProtoObject {

    public double getValue() {
        return value;
    }

    private final double value;

    public ZNumeric(double value) {
        this.value = value;
    }

    public ZNumeric add(ZNumeric e) {
        return new ZNumeric(value + e.getValue());
    }


    public ZNumeric add(ZInteger e) {
        return new ZNumeric(value + e.getValue());
    }


    public ZString add(ZString e) {
        return new ZString(value+  e.getValue());
    }

    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
