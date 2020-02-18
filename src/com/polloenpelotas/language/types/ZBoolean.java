package com.polloenpelotas.language.types;

public class ZBoolean extends ZProtoObject {


    private final boolean value;

    public ZBoolean(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    public ZBoolean equalTo(ZBoolean e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZBoolean and(ZBoolean e){

        return new ZBoolean(this.value && e.getValue());
    }

    public ZBoolean or(ZBoolean e){

        return new ZBoolean(this.value || e.getValue());
    }




    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
