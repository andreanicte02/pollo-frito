package com.polloenpelotas.language.types;

import com.polloenpelotas.language.SemanticException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;



public abstract class ZProtoObject {
    public ZProtoObject getAnterior() {
        return anterior;
    }

    public void setAnterior(ZProtoObject anterior) {
        this.anterior = anterior;
    }

    private ZProtoObject anterior=null;

    public Map<String, ZProtoObject> getMembers() {
        return members;
    }

    private final Map<String, ZProtoObject> members = new HashMap<>();


    public abstract String toChickenString();

    //
    public final ZProtoObject  executeOperation(String name, String symbol, ZProtoObject o) throws SemanticException {
        try {
            final var method = this.getClass().getDeclaredMethod(name, o.getClass());
            return (ZProtoObject) method.invoke(this, o);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // TODO: probar los diferentes tipos de exceptiones y agregar mas catch segun sea necesario
            // Ejemplo:
            // + llamar a un metodo no existente
            // + QUe exception se obtiene si se da un RuntimeException dentro de un nodo?
            e.printStackTrace();
            // TODO: agregar los nombres de los tipos
            throw new SemanticException("No se puede aplicar" + symbol + " : " + e.getMessage());
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

