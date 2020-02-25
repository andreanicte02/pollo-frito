package com.polloenpelotas.language;

import com.polloenpelotas.language.types.*;
import org.jetbrains.annotations.NotNull;

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

                // se obtiene un zvar
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

    public static void  increaseZSize(List<ZVar> list, int index){

        if(index> list.size()){

            for (int x = list.size()-1; x<index-1;x++){
                list.add(new ZVar(ZNothing.getInstance()));
            }
        }

    }

    public static ZProtoObject createStructC(List<ZProtoObject> unwrapList){
        //estan totalmente desembueltos

        if (exitsList(unwrapList)){
            return null;
        }



        return new ZVector(createVectorData(unwrapList));
    }

    /*indica si existe una lista, entre los valores */
    public static boolean exitsList(List<ZProtoObject> unwrapList){

        for (ZProtoObject zvalue:
             unwrapList) {

            if (zvalue instanceof ZList){
                return true;
            }
        }
        return false;


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

    public static List<ZVar>  createListData(List<ZProtoObject> unwrapList){

        List<ZVar> dataList = new ArrayList<>();
        for (ZProtoObject node:
             unwrapList) {

            if (node instanceof ZVector){
                addDataVectorToList(dataList, (ZVector) node);
                continue;
            }
            dataList.add(new ZVar(node));
        }

        return dataList;
    }

    public static void addDataVectorToList(List<ZVar> dataList, ZVector vector){

        if(vector.getList().size()>1 || vector.getList().size() == 0) {
            dataList.add(new ZVar(vector));
            return;
        }

        ZVar aux = vector.getList().get(0);
        dataList.add(new ZVar(aux.getValue()));


    }

    /*si es un vector solo se envia el vector otra vez*/
    /*si es una lista solo se envia la lista otra vez*/
    /*si viniera un primitivo, se tendria que envolver en un vector*/

    public static ZProtoObject returnValueAcces2List(ZProtoObject unwrapValue, ZVar wrapValue){

        if (unwrapValue instanceof ZVector){
            return new ZVector(((ZVector) unwrapValue).getList());
        }

        if(unwrapValue instanceof ZList){
            return new ZList(((ZList) unwrapValue).getList());
        }

        return new ZVector(wrapValue);

    }



    private ChickenUtils(){


    }
}
