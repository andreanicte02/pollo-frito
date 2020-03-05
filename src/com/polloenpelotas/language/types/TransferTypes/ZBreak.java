package com.polloenpelotas.language.types.TransferTypes;

import com.polloenpelotas.language.types.ZProtoObject;

public class ZBreak extends ZProtoObject {

    public static ZBreak getInstance() {
        return instance;
    }

    private final static ZBreak instance = new ZBreak();

    @Override
    public String toChickenString() {

        return null;
    }
}
