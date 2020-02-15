package com.polloenpelotas.language.types;

import com.polloenpelotas.language.SemanticException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;



public abstract class ZProtoObject {
    private final Map<String, ZProtoObject> members = new HashMap<>();



    public ZProtoObject executeOperation(String name, ZProtoObject o) throws SemanticException {
        try {
            final var method = this.getClass().getDeclaredMethod(name, o.getClass());
            return (ZProtoObject) method.invoke(this, o);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new SemanticException(e.getMessage());
        }
        /*        try {
            var method= MathMap.class.getDeclaredMethod(name, v1.getClass(), v2.getClass());
            return (ZContainer) method.invoke(null, v1, v2);

        } catch (NoSuchMethodException e) {
            throw new BinaryOperationNotSupported(v1, v2, symbol);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                if (e.getCause() instanceof SemanticException) {
                    throw (SemanticException) e.getCause();
                }
                throw new RuntimeException(e.getCause());
            }
            throw new RuntimeException(e);

        }
        * */
    }
}

