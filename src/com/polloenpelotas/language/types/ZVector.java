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



    /* * * * * * * * * * * * * * * *
     *  access from the right side  *
     * * * * * * * * * * * * * * * */

    public ZVector access(ZInteger index){

        return new ZVector( list.get(index.getValue()-1) ) ;

    }

    public ZProtoObject access(ZVector index) throws SemanticException {

        ChickenUtils.isSize0(index,"derecho");

        return this.executeOperation("access"," exp[exp] right ",index.getList().get(0).getValue());
    }

    /* * * * * * * * * * * * * * * *
     *  access from the left side  *
     * * * * * * * * * * * * * * * */

    public ZProtoObject access1Left(ZInteger index){

        ZVar aux = list.get(index.getValue()-1);

        if(ChickenUtils.isPrimitive(aux.getValue())){

            return new ZVector(list.get(index.getValue()-1));

        }

        return aux.getValue();

    }

    public ZProtoObject access1Left(ZVector index) throws SemanticException {

        ChickenUtils.isSize0(index,"izquierdo");

        return this.executeOperation("access1Left"," exp[exp] left ",index.getList().get(0).getValue());

    }

    /* * * * * *
    *  assign  *
    * * * * * */

    /* primitives values */
    public ZProtoObject assign(ZInteger newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZString newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZBoolean newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZNumeric newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    /* not primitives values */


    public ZProtoObject assign(ZVector newValue){

        ZVar aux = list.get(0);
        ChickenUtils.castVectorSize1(aux,newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZList newValue){

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
