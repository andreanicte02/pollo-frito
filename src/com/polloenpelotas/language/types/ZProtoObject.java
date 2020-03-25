package com.polloenpelotas.language.types;

import com.polloenpelotas.language.SemanticException;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;



public abstract class ZProtoObject {

    public boolean inMatrix=false;

    private ZProtoObject anterior=null;

    //cambie el zproto x el zvar, xq siempre se guarda el valor envuetlo
    public final Map<String, ZVar> members = new HashMap<>();

    public final Map<String, ZFunction> functions = new HashMap<>();


    public abstract String toChickenString();

    @NotNull
    public final ZProtoObject  executeOperation(String name, String symbol, @NotNull ZProtoObject o) throws SemanticException {
        try {
            final var method = this.getClass().getDeclaredMethod(name, o.getClass());
            return (ZProtoObject) method.invoke(this, o);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // TODO: probar los diferentes tipos de exceptiones y agregar mas catch segun sea necesario
            // Ejemplo:
            // + llamar a un metodo no existente
            // + QUe exception se obtiene si se da un RuntimeException dentro de un nodo?
            // saber :v
            e.printStackTrace();
            // TODO: agregar los nombres de los tipos
            if(e instanceof InvocationTargetException){
                throw new SemanticException("No se puede aplicar " + symbol + ": " + ((InvocationTargetException) e).getTargetException().getMessage()   );
            }
            throw new SemanticException("No se puede aplicar " + symbol + " : " + e.getMessage());
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

    public final ZProtoObject  executeOperation(String name, String symbol) throws SemanticException {
        try {
            final var method = this.getClass().getDeclaredMethod(name);
            return (ZProtoObject) method.invoke(this);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // TODO: probar los diferentes tipos de exceptiones y agregar mas catch segun sea necesario
            // Ejemplo:
            // + llamar a un metodo no existente
            // + QUe exception se obtiene si se da un RuntimeException dentro de un nodo?
            // saber :v
            e.printStackTrace();
            // TODO: agregar los nombres de los tipos
            if(e instanceof InvocationTargetException){
                throw new SemanticException("No se puede aplicar " + symbol + ": " + ((InvocationTargetException) e).getTargetException().getMessage()   );
            }
            throw new SemanticException("No se puede aplicar " + symbol + " : " + e.getMessage());
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


    public final ZProtoObject  executeOperation(String name, String symbol, @NotNull ZProtoObject o, ZProtoObject o1) throws SemanticException {
        try {
            final var method = this.getClass().getDeclaredMethod(name, o.getClass(),o1.getClass());
            return (ZProtoObject) method.invoke(this, o,o1);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // TODO: probar los diferentes tipos de exceptiones y agregar mas catch segun sea necesario
            // Ejemplo:
            // + llamar a un metodo no existente
            // + QUe exception se obtiene si se da un RuntimeException dentro de un nodo?
            // saber :v
            e.printStackTrace();
            // TODO: agregar los nombres de los tipos
            if(e instanceof InvocationTargetException){
                throw new SemanticException("No se puede aplicar " + symbol + ": " + ((InvocationTargetException) e).getTargetException().getMessage()   );
            }
            throw new SemanticException("No se puede aplicar " + symbol + " : " + e.getMessage()   );
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



    public ZProtoObject getAnterior() {
        return anterior;
    }

    public void setAnterior(ZProtoObject anterior) {
        this.anterior = anterior;
    }






}

