package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.EstractorCitrico;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ZArray extends ZProtoObject {

    public List<Integer> sizeList;
    public List<Object> superMatrix;
    public List<Integer> auxAcces = new ArrayList<>();

    public ZArray(ZProtoObject data, List<Integer> sizeList) throws SemanticException {



        this.sizeList = sizeList;
        EstractorCitrico estractor = new EstractorCitrico(data);
        this.superMatrix=ChickenUtils.crearDimension(this.sizeList,this.sizeList.size()-1, estractor::get);


        System.out.println("");

    }

    public ZArray(int pela, List<ZVar> lisData, List<Integer> sizeList){

        this.sizeList = sizeList;
        EstractorCitrico estractor = new EstractorCitrico(lisData);
        this.superMatrix=ChickenUtils.crearDimension(this.sizeList,this.sizeList.size()-1, estractor::get);
    }

    public ZArray(List<Object> superMatrix, List<Integer> sizeList){
        this.superMatrix = superMatrix;
        this.sizeList = sizeList;

    }

    public ZArray(List<Object> superMatrix, List<Integer> sizeList, List <Integer> auxAcces){
        this.superMatrix = superMatrix;
        this.sizeList = sizeList;
        this.auxAcces = auxAcces;

    }

    public ZProtoObject access(ZInteger index) throws SemanticException {


        if(sizeList.size() != auxAcces.size()){
            auxAcces.add(index.getValue());
        }

        List <Integer> prueba = new ArrayList<>();
        prueba.addAll(auxAcces);
        auxAcces.clear();

        if(sizeList.size() == prueba.size()){
            return acceder(prueba);
        }else{
            return new ZArray(superMatrix,sizeList,prueba);
        }


    }

    public ZProtoObject access(ZVector index) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access","array[exp]",aux);
    }

    public ZProtoObject access1Left(ZInteger index) throws SemanticException {

        if(sizeList.size() != auxAcces.size()){
            auxAcces.add(index.getValue());
        }

        List <Integer> prueba = new ArrayList<>();
        prueba.addAll(auxAcces);
        auxAcces.clear();

        if(sizeList.size() == prueba.size()){
            return acceder(prueba);
        }else{
            return new ZArray(superMatrix,sizeList,prueba);
        }


    }


    public ZProtoObject acceder(List<Integer> indiceAccesos) throws SemanticException {

        Collections.reverse(indiceAccesos);
        ZProtoObject nova = new ZArray(superMatrix,new ArrayList<>());
        for(int x =0; x<indiceAccesos.size();x++){
            if(nova instanceof ZArray) {
                nova = ChickenUtils.obtenerDimension(((ZArray) nova).superMatrix,indiceAccesos.get(x));
            }
        }

        return nova;


    }

    public ZString typeof(){

        return new ZString("array");

    }

    public ZInteger length (){


        Integer asdf = sizeList.stream().reduce(1,(x,y)->x*y);
        return new ZInteger(asdf);
    }






    @Override
    public String toChickenString() {

        try {
            String cadena ="array: ";

            for (int x =sizeList.size()-1; x>=0;x--){
                cadena+=sizeList.get(x).toString()+" ";
            }

            return  cadena  +"\n"+ChickenUtils.stringArray(superMatrix, sizeList);
        } catch (SemanticException e) {
            e.printStackTrace();
        }

        return ZNothing.getInstance().toChickenString();

    }
}
