package com.polloenpelotas.language.types;

import com.polloenpelotas.language.SemanticException;

/**
 * representa el retorno de una sentencia que no es una expresion
 */
public class ZNothing extends ZProtoObject {

    private final static ZNothing instance = new ZNothing();
    public static ZNothing getInstance(){
        return instance;
    }

    private ZNothing(){ }

    @Override
    public String toChickenString() {
        return "Nothing";
    }
}
