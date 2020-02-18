package com.polloenpelotas.language.types;

import org.jetbrains.annotations.NotNull;

public class ZInteger extends ZProtoObject {
    private final int value;

    public ZInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ZInteger add(ZInteger e) {

        return new ZInteger(this.value + e.value);
    }

    public ZString  add( ZString e) {

        return new ZString(this.value + e.getValue());
    }

    public ZNumeric add (ZNumeric e){

        return new ZNumeric(this.value+ e.getValue());
    }

    public ZInteger rest (ZInteger e){

        return new ZInteger(this.value -e.getValue());
    }

    public ZNumeric rest (ZNumeric e){

        return new ZNumeric(this.value -e.getValue());
    }

    public ZBoolean mayor(ZInteger e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZBoolean mayor (ZNumeric e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZBoolean equalTo(ZInteger e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZBoolean equalTo (ZNumeric e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZInteger unaryMinus (ZInteger e) {

        return  new ZInteger(value * e.getValue());
    }

    public ZInteger mult(ZInteger e){

        return new ZInteger(value * e.getValue());
    }

    public ZNumeric pot(@NotNull ZInteger e){

        return new ZNumeric( Math.pow(value, e.value));
    }




    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
