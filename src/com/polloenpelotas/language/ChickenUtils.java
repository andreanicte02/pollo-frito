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

        List<ZVar> newData = new ArrayList<>();

        if (exitsList(unwrapList)){
            return null;
        }


        for (ZProtoObject node:
             unwrapList) {

            if(node instanceof ZVector){
                newData.addAll(setVectorInVector((ZVector) node));
                continue;
            }
            newData.add(new ZVar(node));

        }


        return new ZVector(newData);
    }

    public static void castearVector(List<ZVar> list){

        int estado =-1;

        for(ZVar node:
        list){
            if(node.getValue() instanceof  ZString){
                return;
            }
        }


    }

    public static void castearString(){}


    public static List<ZVar> setVectorInVector(ZVector vector){

        List<ZVar> list= new ArrayList<>();
        for (ZVar node:
             vector.getList()) {

            list.add(new ZVar(node.getValue()));

        }
        return list;
        
    }

    public static ZProtoObject vectorSize1(ZVector vect){

        ZProtoObject aux = unwrap(vect.getList().get(0));
        if(aux instanceof ZVector){
            return vectorSize1((ZVector) aux);
        }
        return aux;
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

    public static ZProtoObject returnValueAccess2List(ZProtoObject unwrapValue, ZVar wrapValue){

        if (unwrapValue instanceof ZVector){
            return new ZVector(((ZVector) unwrapValue).getList());
        }

        if(unwrapValue instanceof ZList){
            return new ZList(((ZList) unwrapValue).getList());
        }

        return new ZVector(wrapValue);

    }

    public static boolean isPrimitive(ZProtoObject val) {

        if (val instanceof ZInteger || val instanceof ZNumeric || val instanceof ZString || val instanceof ZBoolean) {
            return true;

        }
        return false;
    }

    public static void castVectorSize1(ZVar var, ZVector vector){

        if(vector.getList().size()==1 && ChickenUtils.isPrimitive(vector.getList().get(0).getValue())){

            var.setValue(vector.getList().get(0).getValue());

            return;
        }
        var.setValue(vector);

        return;
    }

    @NotNull
    public static List<ZVar> copiaPorValor(@NotNull List<ZVar> actual){

        List<ZVar> nueva =  new ArrayList<>();

        for (ZVar node:
             actual) {

            nueva.add(new ZVar(node.getValue()));

        }

        return nueva;

    }

    public static void isSize0(ZVector valor, String lado) throws SemanticException {

        if(valor.getList().size() == 0){

            throw new SemanticException(" Error al acceder id[exp] || id[[exp]]  del lado " + lado );
        }


    }

    public static ZVector rightVectorOperation(ZProtoObject left ,ZVector right, String name, String sim) throws SemanticException {

        List<ZVar> nova = new ArrayList<>();
        for (ZVar node:
                right.getList()) {

            ZProtoObject aux = left.executeOperation(name,sim,node.getValue());
            nova.add(new ZVar(aux));
        }

        return new ZVector(nova);

    }

    public static ZVector leftVectorOperation (ZVector left, ZProtoObject right, String name, String sim) throws SemanticException {

        List<ZVar> nova = new ArrayList<>();

        for(ZVar node:
            left.getList()){

            ZProtoObject aux = node.getValue().executeOperation(name, sim,right);
            nova.add(new ZVar(aux));
        }

        return new ZVector(nova);

    }

    public static ZVector vectorVectorOperation(ZVector left, ZVector right, String name, String sim) throws SemanticException {


        if(left.getList().size()==right.getList().size()){

            return operar2VecotresXD(left,right,name,sim);

        }

        if(left.getList().size()==1){

            ZProtoObject aux =  unwrap(left.getList().get(0));
            return rightVectorOperation(aux,right, name, sim);
        }

        if(right.getList().size() == 1){

            ZProtoObject aux = unwrap(right.getList().get(0));
            return leftVectorOperation(left,aux, name, sim);
        }

        throw new SemanticException("error al operar vectores, no son del mismo tamaño");
    }

    public static ZVector operar2VecotresXD(ZVector left, ZVector right, String name, String sim) throws SemanticException {
        ZProtoObject aux;
        ZProtoObject aux2;
        ZProtoObject niuValue;
        List<ZVar> nueva = new ArrayList<>();

        for (int i = 0; i<left.getList().size();i++){

            aux = unwrap(left.getList().get(i));
            aux2 = unwrap(right.getList().get(i));
            niuValue = aux.executeOperation(name, sim,aux2);
            nueva.add(new ZVar(niuValue));

        }

        return new ZVector(nueva);

    }







}
