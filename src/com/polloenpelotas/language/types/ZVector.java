package com.polloenpelotas.language.types;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZVector extends ZProtoObject {

    private final List<ZProtoObject> list = new ArrayList<>();

    public ZVector(ZProtoObject firstValue) {
        this.list.add(firstValue);
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
