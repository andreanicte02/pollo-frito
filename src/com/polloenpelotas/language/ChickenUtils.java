package com.polloenpelotas.language;

import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChickenUtils {

    public static @NotNull ZProtoObject unwrap(@NotNull ZProtoObject value){
        if (value instanceof ZVar) {
            return ((ZVar) value).getValue();
        }
        return value;
    }


    public static @NotNull ZProtoObject getVarLeft(@NotNull ZProtoObject ambit, String name){

        for(ZProtoObject e = ambit; e!= null; e= e.getAnterior()){

            if(e.getMembers().containsKey(name)){

                return e.getMembers().get(name);
            }
        }
        return createVariable(ambit,name);

    }

    public static void setVariable(@NotNull ZProtoObject ambit, String name, ZVar value){

        ambit.getMembers().put(name, value);

    }

    public static @NotNull ZProtoObject createVariable(@NotNull ZProtoObject ambit, String name){

        ambit.getMembers().put(name, new ZVar(ZNothing.getInstance()));
        return ambit.getMembers().get(name);

    }


    public static @NotNull ZProtoObject getVarRight(@NotNull ZProtoObject ambit, String name) throws SemanticException {

        for(ZProtoObject e = ambit; e!= null; e= e.getAnterior()){

            if(e.getMembers().containsKey(name)){

                return e.getMembers().get(name);
            }
        }

        throw new SemanticException("La variable con el nombre id: "+name+", no existe");
    }


    private ChickenUtils(){}
}
