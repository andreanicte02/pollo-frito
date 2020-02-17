package com.polloenpelotas.language.types;

public class ZString extends ZProtoObject {
    private final String value;

    public ZString(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public ZString add(ZInteger e){
        return new ZString(value + e.getValue());
    }
    public ZString add(ZString e){
        return new ZString(value + e.value);
    }

    @Override
    public String toChickenString() {
        // TODO: debe de salir con comillas?
        return "\"" + value + "\"";
    }
}
