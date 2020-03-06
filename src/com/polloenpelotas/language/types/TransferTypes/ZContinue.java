package com.polloenpelotas.language.types.TransferTypes;

import com.polloenpelotas.language.types.ZProtoObject;

public class ZContinue extends ZProtoObject {

    public static ZContinue getInstance() {
        return instance;
    }

    private final static ZContinue instance = new ZContinue();

    @Override
    public String toChickenString() {
        return null;
    }
}
