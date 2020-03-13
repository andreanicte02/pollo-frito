package com.polloenpelotas.language;

import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import com.polloenpelotas.language.types.ZVector;

import java.util.ArrayList;
import java.util.List;

import static com.polloenpelotas.language.ChickenUtils.unwrap;

public final class VectorUtils {

    /**aumenta el tamaño del vector*/
    public static void  increaseZSize(List<ZVar> list, int index){

        if(index> list.size()){

            for (int x = list.size()-1; x<index-1;x++){
                list.add(new ZVar(ZNothing.getInstance()));
            }
        }

    }

    public static ZVector rightVectorOperation(ZProtoObject left , ZVector right, String name, String sim) throws SemanticException {

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
