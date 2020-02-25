package com.polloenpelotas.language.types;

import org.jetbrains.annotations.NotNull;

public class ZVar extends ZProtoObject {

    public void setValue(ZProtoObject value) {
        this.value = value;
    }

    private @NotNull ZProtoObject value;

    public ZVar(@NotNull ZProtoObject initialValue){
        this.value = initialValue;
    }
    @NotNull
    public ZProtoObject getValue() {
        return value;
    }


    public ZProtoObject assign(@NotNull ZInteger zInteger){
        value = new ZVector(new ZVar(zInteger));
        return ZNothing.getInstance();
    }
    public ZProtoObject assign(@NotNull ZString zString) {
        value = new ZVector(new ZVar(zString));
        return ZNothing.getInstance();
    }
    public ZProtoObject assign(@NotNull ZVector zVector) {
        // TODO: se tienen mas validaciones? se pasa por referencia o por valor (se hace una copia)?

        value = zVector;
        return ZNothing.getInstance();
    }








    @Override
    public String toChickenString() {
        return value.toChickenString();
    }

    @Override
    public String toString() {
        return "ZVar{" +
                "value=" + value +
                '}';
    }
}
