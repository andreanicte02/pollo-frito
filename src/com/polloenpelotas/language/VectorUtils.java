package com.polloenpelotas.language;

import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.LeftAccess1AstNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.LeftAccess2AstNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations.*;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ZProtoObject  findVector(AstNode e, ZProtoObject ambit) throws SemanticException, LocatedSemanticException {

        if(e instanceof LeftAccess1AstNode){
            ZProtoObject a1 = findVector(((LeftAccess1AstNode) e).e1, ambit);
            ZProtoObject a2 = ChickenUtils.unwrap(((LeftAccess1AstNode) e).e2.execute(ambit));

            if(a1 instanceof ZVector || a1 instanceof ZNothing){

                return a1;

            }

            if(a1 instanceof ZVar){
               return ChickenUtils.unwrap(a1);
            }

            return a1.executeOperation("access1Left","casteo vectores",a2);

        }
        if( e instanceof LeftAccess2AstNode){

            ZProtoObject a1 = findVector(((LeftAccess2AstNode) e).e1, ambit);
            ZProtoObject a2 = ChickenUtils.unwrap(((LeftAccess2AstNode) e).e2.execute(ambit));

            if(a1 instanceof ZVector || a1 instanceof ZNothing){

                return a1;

            }

            ZProtoObject other = a1.executeOperation("access2Left","casteo vectores",a2);

            if(other instanceof ZVar){

                return ChickenUtils.unwrap(other);
            }

            return other;


        }

        if ( e instanceof FindIDAstNode || e instanceof  FindIDLeftAstNode){

            return ChickenUtils.unwrap(e.execute(ambit));
        }

        return ZNothing.getInstance();

    }


    /**castear vectores*/
    public static  void changeVector(List<ZVar> list) throws SemanticException {


        if(list.stream().anyMatch(x->x.getValue() instanceof  ZList )){
            //creo que deberia de marcarse como error
            return;
        }


        if(list.stream().anyMatch(x->x.getValue() instanceof  ZVector )){
            return;
        }

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZString)){
            changeVector2(list,"castS","castS");
            return;
        }

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZNumeric)){
            changeVector2(list,"castN","castN");
            return;
        }

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZInteger)){
            changeVector2(list,"castI","castI");
            return;
        }

    }

    public static void changeVector2(List<ZVar> list,String name, String simbol) throws SemanticException {

        for (int x =0; x<list.size();x++){
            ZVar aux = list.get(x);
            aux.setValue(aux.getValue().executeOperation(name,simbol, ZNothing.getInstance()));
        }

    }

    public static List<Integer> obtenerEnteros(ZVector vector) throws SemanticException {

        List<Integer> list =new ArrayList<>();

        for (ZVar var:
             vector.getList()) {

            ZProtoObject aux = unwrap(var);
            if(!(aux instanceof ZInteger)){
                throw new SemanticException("Se esperaba un int, en las dimensiones");
            }

            list.add(((ZInteger) aux).getValue());

        }
        return list;


    }








}
