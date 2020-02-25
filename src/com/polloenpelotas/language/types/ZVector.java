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

        return ZNothing.getInstance();
    }



    public ZProtoObject assign (ZVector value) throws SemanticException {


        return ZNothing.getInstance();

    }

    /*Este metodo lo utiliza el metodo assign, pero solo con datos primitvos
    * era solo para ahorrarme el Zvar aux XD*/

    void primitivesAssign(ZProtoObject value)  {


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
