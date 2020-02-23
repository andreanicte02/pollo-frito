package com.polloenpelotas.language;

import com.polloenpelotas.language.types.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public static ZProtoObject aumentarZVector(List<ZProtoObject> list, int index){

        if(index> list.size()){

            for (int x = list.size()-1; x<index-1;x++){
                list.add(new ZVar(ZNothing.getInstance()));
            }
        }
        return  ZNothing.getInstance();
    }

    public static ZProtoObject createStructC(List<ZProtoObject> expUnwrap){
        //estan totalmente desembueltos

        if (!isVector(expUnwrap)){
            return null;
        }



        return new ZVector(createVectorData(expUnwrap));
    }

    public static boolean isVector(List<ZProtoObject> expUnwrap){

        for (ZProtoObject zvalue:
             expUnwrap) {

            if (zvalue instanceof ZList){
                return false;
            }
        }
        return true;


    }

    public static void addData(ZVector vector,List<ZVar> finalList){

        //los vectores solo deberian de tener datos primtivos
        for (ZVar node: vector.getList()) {
            //se podria verificar si los vectores contienen un valor que no sea primitivo, y tirar error
            finalList.add(new ZVar(node.getValue()));

        }

    }
    public static List<ZVar> createVectorData(List<ZProtoObject> actualList){

        List<ZVar> finalValue = new ArrayList<>();
        for (ZProtoObject node:
                actualList) {

            if (node instanceof ZVector){
                addData((ZVector) node, finalValue);
                continue;
            }
            finalValue.add(new ZVar(node));

        }
        return  finalValue;

    }


    private ChickenUtils(){


    }
}
