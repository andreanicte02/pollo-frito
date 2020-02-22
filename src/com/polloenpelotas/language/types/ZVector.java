package com.polloenpelotas.language.types;

import com.polloenpelotas.language.SemanticException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZVector extends ZProtoObject {

    private  List<ZProtoObject> list = new ArrayList<>();

    public ZVector(ZProtoObject firstValue) {

        this.list.add(firstValue);
    }

    public ZVector(List<ZProtoObject> list){
        this.list = list;
    }


    public ZVector access(ZInteger index){

        return new ZVector(list.get(index.getValue()-1));

    }

    public ZProtoObject assign(ZInteger zInteger ) throws SemanticException {

        ZProtoObject aux = list.get(0);
        aux.executeOperation("assign"," [=] ",new ZInteger(zInteger.getValue()));
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
