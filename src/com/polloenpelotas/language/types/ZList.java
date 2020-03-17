package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZList extends ZProtoObject {


    List<ZVar> list;


    public ZList(List<ZVar> list){
        this.list = new ArrayList<>();
        this.list = list;
    }

    public List<ZVar> getList() {
        return list;
    }

    /* * * * * * * * * * * * * * * *
     *  access from the right side  *
     * * * * * * * * * * * * * * * */

    /*acces devuelve el valor en una lista*/
    /*acces2 devuelve el valor indicado como tal*/

    public ZProtoObject access(ZInteger index) throws SemanticException {


        ZVar aux = list.get(index.getValue()-1);
        List<ZProtoObject> unwrapList = new ArrayList<>();
        unwrapList.add(ChickenUtils.unwrap(aux));

        //TODO posibles cambios

        return new ZList(ChickenUtils.createListData(unwrapList));

    }

    public ZProtoObject access(ZVector index) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access"," exp[exp] right ", aux);

    }


    public ZProtoObject access2(ZInteger index){

        ZVar wrapVar = list.get(index.getValue()-1);
        ZProtoObject unwrapVar = ChickenUtils.unwrap(wrapVar);

        return ChickenUtils.returnValueAccess2List(unwrapVar,wrapVar);
    }

    public ZProtoObject access2(ZVector index) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access2", " exp[[exp]] right ", aux);

    }

    /* * * * * * * * * * * * * * * *
     *  access from the left side  *
     * * * * * * * * * * * * * * * */

    public ZProtoObject access1Left(ZInteger index){

        VectorUtils.increaseZSize(list, index.getValue());
        ZVar aux = list.get(index.getValue()-1);

        return  new ZVector(aux);
    }

    public ZProtoObject access1Left(ZVector index) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access1Left", " exp[exp] left ", aux);

    }


    public ZProtoObject access2Left(ZInteger index){

        VectorUtils.increaseZSize(list, index.getValue());
        ZVar aux = list.get(index.getValue()-1);

        if(ChickenUtils.isPrimitive(aux.getValue())){

            return new ZVector(aux);
        }

        return aux;

    }

    public ZInteger length (){

        return new ZInteger(list.size());

    }


    public ZProtoObject access2Left(ZVector index) throws SemanticException {

       ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

       return this.executeOperation("access2Left", " exp[[exp]] left ", aux);

    }



    @Override
    public String toChickenString() {
        var strings = this.list.stream()
                .map(ZProtoObject::toChickenString) // sugar
                .collect(Collectors.toList());
//        var a = this.list.stream().map(zProtoObject -> zProtoObject.toChickenString()).collect(Collectors.toList());

        return "List(" + String.join(", ", strings) + ')';
    }
}
