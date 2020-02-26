package com.polloenpelotas.language.types;

import com.polloenpelotas.Utils;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

import javax.swing.text.Utilities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZVector extends ZProtoObject {

    public List<ZVar> getList() {
        return list;
    }

    private  List<ZVar> list = new ArrayList<>();

    public ZVector(ZVar firstValue) {

        this.list.add(firstValue);
    }

    public ZVector(List<ZVar> list){
        this.list = list;
    }

    /*el acceso a un vector siempre va retonrar un vector nuevo*/
    /*en teoria los vectores solo podrian retornar vecotres de tamaño uno de tipo primitivo */
    /*ChickenUtils.increaseZSize(list, index.getValue()); */
    public ZVector access(ZInteger index){



        return new ZVector( list.get(index.getValue()-1) ) ;

    }

    public ZProtoObject access1Left(ZInteger index){

        ZVar aux = list.get(index.getValue()-1);

        if(!(aux.getValue() instanceof ZVector) && !(aux.getValue() instanceof ZVector)){
            //seria un primitivo
            return new ZVector(list.get(index.getValue()-1));

        }

        return aux.getValue();

    }

    public ZProtoObject assignAccess(ZInteger newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assignAccess(ZVector newValue){


        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assignAccess(ZList newValue){


        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }





    @Override
    public String toChickenString() {

        var strings = this.list.stream()
                .map(ZProtoObject::toChickenString) // sugar
                .collect(Collectors.toList());
//        var a = this.list.stream().map(zProtoObject -> zProtoObject.toChickenString()).collect(Collectors.toList());

        return '[' + String.join(", ", strings) + ']';
    }
}
