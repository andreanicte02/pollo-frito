package com.polloenpelotas.language.types;

import com.polloenpelotas.Utils;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

import javax.swing.text.Utilities;
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

        ChickenUtils.aumentarZVector(list,index.getValue());

        return new ZVector(list.get(index.getValue()-1));

    }

    public ZProtoObject assign(ZInteger zInteger ) throws SemanticException {

        ZProtoObject aux = list.get(0);
        aux.executeOperation("assignV"," [=] ",zInteger );
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(ZVector zVector) throws SemanticException {

        ZProtoObject aux = list.get(0);
        aux.executeOperation("assignV"," [=] ", ChickenUtils.unwrap(zVector.list.get(0)));

        return ZNothing.getInstance();
    }


    public ZVector add(ZInteger zInteger) throws SemanticException {

        List<ZProtoObject> lAux = new ArrayList<>();

        for (ZProtoObject v: this.list) {

            ZProtoObject r1 = ChickenUtils.unwrap(v);

            lAux.add( new ZVar(r1.executeOperation("add","+", zInteger)));

        }

        return new ZVector(lAux);
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
