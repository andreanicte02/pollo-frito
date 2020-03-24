package com.polloenpelotas.language;

import com.polloenpelotas.language.types.ZList;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import com.polloenpelotas.language.types.ZVector;

import java.util.List;

public class EstractorCitrico {

    List<ZVar> listData;
    boolean isList = false;
    int indice = 0;


    public EstractorCitrico(ZProtoObject data) throws SemanticException {

        if(data instanceof ZVector){
            listData = ((ZVector) data).getList();
        }else if(data instanceof ZList){
            listData = ((ZList) data).getList();
            isList=true;
        }else{
            throw new SemanticException("Se esperaba un vector o una lista");
        }

    }



    public ZVar get(){

        if(indice == listData.size()){
            indice =0;
        }

        if(isList){
            ZVar aux = new ZVar(new ZList(listData.get(indice)));
            indice++;
            return aux;

        }else{

            ZVar aux = listData.get(indice);
            indice++;
            return aux;

        }


    }


}
