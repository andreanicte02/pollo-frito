package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

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

    /*Este el acceso de tipo uno de las listas*/
    /*Este acceso devuelve el valor envuelto en una lista nueva*/
    /*Si se crea una nueva lista, y se hacen cambios en esta,
    no deberia de afectar los datos de donde se origino? */
    public ZProtoObject access(ZInteger index) throws SemanticException {


        ZVar aux = list.get(index.getValue()-1);
        List<ZProtoObject> unwrapList = new ArrayList<>();
        unwrapList.add(ChickenUtils.unwrap(aux));

        //creo que voy a tener que hacer cambios
        return new ZList(ChickenUtils.createListData(unwrapList));

    }

    /* Este acceso devuelve el valor, lo que se encuentra en el inidice indicado */
    public ZProtoObject access2(ZInteger index){

        ZVar wrapVar = list.get(index.getValue()-1);
        ZProtoObject unwrapVar = ChickenUtils.unwrap(wrapVar);

        return ChickenUtils.returnValueAcces2List(unwrapVar,wrapVar);
    }

    public ZProtoObject access1Left(ZInteger index){

        ZVar aux = list.get(index.getValue()-1);
        
        return  new ZVector(aux);
    }

    public ZProtoObject access2Left(ZInteger index){

        ZVar aux = list.get(index.getValue()-1);

        if(!(aux.getValue() instanceof ZList) && !(aux.getValue() instanceof ZList)){
            //deberia de ser un primitivo si o si
            return new ZVector(aux);
        }

        return aux;

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
