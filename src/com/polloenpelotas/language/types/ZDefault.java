package com.polloenpelotas.language.types;

public class ZDefault extends ZProtoObject {

    public static ZDefault getInstance() {
        return instance;
    }

    private final static ZDefault instance = new ZDefault();

    @Override
    public String toChickenString() {
        return "default";
    }
}
