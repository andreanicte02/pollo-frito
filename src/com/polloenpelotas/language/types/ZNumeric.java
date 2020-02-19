package com.polloenpelotas.language.types;

import org.jetbrains.annotations.NotNull;

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


    public ZNumeric rest (ZInteger e){

        return new ZNumeric(this.value -e.getValue());
    }

    public ZNumeric rest (ZNumeric e){

        return new ZNumeric(this.value -e.getValue());
    }


    public ZNumeric mult(ZInteger e){

        return new ZNumeric(this.value * e.getValue());
    }

    public ZNumeric mult(ZNumeric e){

        return new ZNumeric(this.value * e.getValue());
    }

    // TODO: validar que el numero no sea div entre 0

    public ZNumeric div(ZInteger e){

        return new ZNumeric(this.value / e.getValue());
    }

    public ZNumeric div(ZNumeric e){

        return new ZNumeric(this.value / e.getValue());
    }

    public ZNumeric pot(@NotNull ZInteger e){

        return new ZNumeric( Math.pow(this.value, e.getValue()));
    }

    public ZNumeric pot(@NotNull ZNumeric e){

        return new ZNumeric( Math.pow(this.value, e.getValue()));
    }


    public ZNumeric mod(@NotNull ZInteger e){

        return new ZNumeric( this.value % e.getValue());
    }

    public ZNumeric mod(@NotNull ZNumeric e){

        return new ZNumeric( this.value % e.getValue());
    }


    public ZNumeric unaryMinus (ZInteger e) {

        return  new ZNumeric(value * -1);

    }

    public ZBoolean mayor(ZInteger e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZBoolean mayor (ZNumeric e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZBoolean menor(ZInteger e){

        return new ZBoolean(this.value < e.getValue());
    }

    public ZBoolean menor (ZNumeric e){

        return new ZBoolean(this.value < e.getValue());
    }

    public ZBoolean mayorIgual(ZInteger e){

        return new ZBoolean(this.value >= e.getValue());
    }

    public ZBoolean mayorIgual (ZNumeric e){

        return new ZBoolean(this.value >= e.getValue());
    }


    public ZBoolean menorIgual(ZInteger e){

        return new ZBoolean(this.value <= e.getValue());
    }

    public ZBoolean menorIgual (ZNumeric e){

        return new ZBoolean(this.value <= e.getValue());
    }


    public ZBoolean equalTo(ZInteger e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZBoolean equalTo (ZNumeric e){

        return new ZBoolean(this.value == e.getValue());
    }





    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
