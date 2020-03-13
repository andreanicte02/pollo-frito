package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

import java.util.ArrayList;
import java.util.List;

public class ZMatriz extends ZProtoObject {


    public final ZVar mat[][];
    private final int row;
    private final int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

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

        //index 1 = fila
        //index 2 = columna
        if(index1.getValue() == 0 || index2.getValue() == 0){
            throw new SemanticException("Se intenta acceder con un indice 0");
        }

        if(index1.getValue()>row){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }

        if(index2.getValue()>col){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }


        return new ZVector(mat[index1.getValue()-1][index2.getValue()-1]);

    }

    public ZProtoObject access1(ZVector index1, ZInteger index2) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index1.getList());

        return this.executeOperation("access1","Matrix[exp,exp]",aux, index2);

    }

    public ZProtoObject access1(ZInteger index1, ZVector index2) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index2.getList());
        return this.executeOperation("access1","Matrix[exp,exp]", index1, aux);

    }

    public ZProtoObject access1(ZVector index1, ZVector index2) throws SemanticException {


        ZProtoObject aux1 = ChickenUtils.getFirstDataUnwrap(index1.getList());


        ZProtoObject aux2 = ChickenUtils.getFirstDataUnwrap(index2.getList());

        return this.executeOperation("access1","Matrix[exp,exp]", aux1, aux2);

    }

    /**acces tipo 2 [exp,]
     * retorna un vector con los elementos de la fila corresponiente
     * */

    public ZVector access2(ZInteger index1) throws SemanticException {

        List<ZVar> niu= new ArrayList<>();

        if(index1.getValue() == 0){
            throw new SemanticException("Se intenta acceder con un indice 0");
        }

        if(index1.getValue() > row){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }

        for (int i =0; i<col; i++){
            niu.add(mat[index1.getValue()-1][i]);
        }

        return new ZVector(niu);
    }

    public ZProtoObject access2(ZVector index1) throws SemanticException {

        //preguntar si pueden venir vector de tamaño >1 y solo tomar el primer valor

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index1.getList());
        return this.executeOperation("access2","matrix[exp,]", aux);
    }

    /**access tipo3 [,exp] obtiene las columnas*/


    public ZVector access3(ZInteger index1) throws SemanticException {

        List<ZVar> niu= new ArrayList<>();

        if(index1.getValue() == 0){
            throw new SemanticException("Se intenta acceder con un indice 0");
        }

        if(index1.getValue() > col){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango");
        }

        for (int i =0; i<row; i++){
            niu.add(mat[i][index1.getValue()-1]);
        }

        return new ZVector(niu);

    }

    public ZProtoObject access3(ZVector index1) throws SemanticException {
        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index1.getList());
        return  this.executeOperation("access3","matrix[,exp]", aux);
    }

    /**access4 devuelve un valor en especifico, el recorrido es por columna*/

    public ZProtoObject access(ZInteger index1) throws SemanticException {

        if(index1.getValue()>(row*col)){
            throw new SemanticException("Se intenta acceder con un indice fuera de rango ");
        }

        int cont=1;

        for (int x= 0; x<col; x++){

            for (int y=0; y<row; y++, cont++){

                if(cont == index1.getValue()){
                    return new ZVector(mat[y][x]);
                }

            }
        }


        throw new SemanticException("Se intenta acceder con un indice fuera de rango ");
    }

    public ZProtoObject access(ZVector index1) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index1.getList());
        return this.executeOperation("access", "matrix[ex]", aux);
    }




    public ZProtoObject access1Left(ZInteger index1) throws SemanticException{

        ZProtoObject aux = this.executeOperation("access","matrix[exp] left",index1);
        aux.inMatrix = true;
        return aux;
    }

    public ZProtoObject access1Left(ZVector index1) throws SemanticException{


        ZProtoObject aux= this.executeOperation("access","matrix[exp] left",index1);
        aux.inMatrix = true;
        return aux;
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

        return "------------------\nMatrix:\n"+ cad+"------------------";

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
