package com.polloenpelotas.language.types.TransferTypes;

import com.polloenpelotas.language.types.ZProtoObject;

public class ZRetorno  extends ZProtoObject {

    public ZProtoObject getValue() {
        return value;
    }

    private ZProtoObject value;

    ///// el valor debe de estar desnvuelto si no cagadales
    public ZRetorno(ZProtoObject value){
        this.value = value;

    }

    @Override
    public String toChickenString() {
        return null;
    }
}
