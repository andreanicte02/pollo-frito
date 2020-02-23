package com.polloenpelotas.language.types;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZList extends ZProtoObject {

    List<ZVar> list = new ArrayList<>();

    public ZList(ZVar firstValue){
        list.add(firstValue);
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
