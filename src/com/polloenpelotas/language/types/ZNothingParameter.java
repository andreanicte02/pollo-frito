package com.polloenpelotas.language.types;

public class ZNothingParameter extends ZProtoObject {

    public static ZNothingParameter getInstance() {
        return instance;
    }

    private final static ZNothingParameter instance = new ZNothingParameter();


    @Override
    public String toChickenString() {
        return "null";
    }
}
