package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

import java.util.List;

public class ZMatriz extends ZProtoObject {


    private final ZVar mat[][];
    private final int row;
    private final int col;

    public ZMatriz(ZInteger row, ZInteger column) {
        this.mat = new ZVar[row.getValue()][column.getValue()];
        this.row = row.getValue();
        this.col = column.getValue();
    }

    public void setData(ZProtoObject data) throws SemanticException {
        int index [] = new int[1];
        index[0]=0;

        for (int x= 0; x<col; x++){

            for (int y=0; y<row; y++){

                mat[y][x]=getData(data,index);

            }
        }
    }



    /* * * * * * * * * * * * * * * *
     *  access from the right side  *
     * * * * * * * * * * * * * * * */

    public ZVector access1(ZInteger index1, ZInteger index2) throws SemanticException {

        //index 1 = x
        //index 2 = y
        if(index1.getValue() == 0 || index2.getValue() == 0){
            throw new SemanticException("Se intenta acceder con un indice 0");
        }

        if(index1.getValue()>col){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }

        if(index2.getValue()>row){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }


        return new ZVector(mat[index2.getValue()-1][index1.getValue()-1]);

    }

    public ZProtoObject access1(ZVector index1, ZInteger index2) throws SemanticException {

        ChickenUtils.isVectorSize1(index1);
        ZProtoObject aux = ChickenUtils.unwrap(index1.getList().get(0));

        return this.executeOperation("access1","access1",aux, index2);

    }

    public ZProtoObject access1(ZInteger index1, ZVector index2) throws SemanticException {

        ChickenUtils.isVectorSize1(index2);
        ZProtoObject aux = ChickenUtils.unwrap(index2.getList().get(0));

        return this.executeOperation("access1","access1", index1, aux);

    }

    public ZProtoObject access1(ZVector index1, ZVector index2) throws SemanticException {

        ChickenUtils.isVectorSize1(index1);
        ZProtoObject aux1 = ChickenUtils.unwrap(index1.getList().get(0));

        ChickenUtils.isVectorSize1(index2);
        ZProtoObject aux2 = ChickenUtils.unwrap(index2.getList().get(0));

        return this.executeOperation("access1","access1", aux1, aux2);

    }

    /**acces tipo 2 [exp,]*/

    public ZProtoObject access2(ZVector index1){


        return null;
    }

    




    @Override
    public String toChickenString() {
        String cad="";
        for (int i= 0; i<row; i++){

            for (int j=0; j<col; j++){

                cad+=ChickenUtils.unwrap(mat[i][j]).toChickenString() + " ";

            }
            cad+="\n";
        }
        return cad;

    }

    public static ZVar getData(ZProtoObject data, int index[]) throws SemanticException {


        if(ChickenUtils.isPrimitive(data)){

            return new ZVar(data);

        }

        if(!(data instanceof ZVector)){
            throw new SemanticException("la data ingresada, no es ni un vector ni un dato primitivo");
        }

        //se le pasa e casteo de la funcion c
        List<ZVar> list = ChickenUtils.defineTypeVector(((ZVector) data).getList());

        if(index[0]>=list.size()){
            index[0]= 0;
        }

        ZVar aux = new ZVar(ChickenUtils.unwrap(list.get(index[0])));

        index[0]= index[0]+1;

        return aux;
    }

}
