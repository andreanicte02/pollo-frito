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



        return new ZVector( list.get(index.getValue()-1));

    }

    /*se evalua cuando se asgina un int*/
    /*se realiza la copia por valor*/
    public ZProtoObject assign(ZInteger value)  {


        primitivesAssign(new ZInteger(value.getValue()));
        return ZNothing.getInstance();

    }

    /*solo si el vector para asignar es de tamaño 1 con un dato primitivo*/
    /*a los vectores solo se deberian de poder asignar datos primitivos
    * o vectores de tamaño 1 con datos primitivos*/
    /*cuando se asigna un vector XD*/
    public ZProtoObject assign (ZVector value) throws SemanticException {

        if(value.getList().size()>1 ){
            throw new SemanticException("error al asignar un dato a un vector");
        }

        ZProtoObject res = ChickenUtils.unwrap(value.getList().get(0));
        this.executeOperation("assign", "asginar vector", res);
        return ZNothing.getInstance();

    }

    /*Este metodo lo utiliza el metodo assign, pero solo con datos primitvos
    * era solo para ahorrarme el Zvar aux XD*/

    void primitivesAssign(ZProtoObject value)  {

        ZVar aux = list.get(0);
        aux.setValue(value);

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
