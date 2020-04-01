package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ZVar extends ZProtoObject {

    public void setValue(ZProtoObject value) {
        this.value = value;
    }

    private @NotNull ZProtoObject value;

    public ZVar(@NotNull ZProtoObject initialValue){
        this.value = initialValue;
    }
    @NotNull
    public ZProtoObject getValue() {
        return value;
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * *
    * "assign" only when set the value to a variable   *
    * * * * * * * * * * * * * * * * * * * * * * * * *  */

    /*primitivos*/

    public ZProtoObject assign(@NotNull ZInteger zInteger){
        value = new ZVector(new ZVar(zInteger));
        return ZNothing.getInstance();
    }
    public ZProtoObject assign(@NotNull ZString zString) {
        value = new ZVector(new ZVar(zString));
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZNumeric zNumeric) {
        value = new ZVector(new ZVar(zNumeric));
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZBoolean zBoolean ) {
        value = new ZVector(new ZVar(zBoolean));
        return ZNothing.getInstance();
    }


    public ZProtoObject assign(@NotNull ZNothing nothing ) {
        value =nothing;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZNothingParameter nothing ) {
        value =nothing;
        return ZNothing.getInstance();
    }




    /*no primitivos*/
    /*se hace una copia, no es por referencia*/

    public ZProtoObject assign(@NotNull ZVector zVector) {

        value = new ZVector( ChickenUtils.copiaPorValor(zVector.getList()));
        return ZNothing.getInstance();
    }
    public ZProtoObject assign(@NotNull ZList zList) {

        value = new ZList(ChickenUtils.copiaPorValor(zList.getList()));
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZMatriz zmat ) throws SemanticException {

        List<ZVar> list = ChickenUtils.getListVarMatrix(zmat.mat,zmat.getRow(), zmat.getCol());

        value = new ZMatriz(new ZInteger(zmat.getRow()), new ZInteger(zmat.getCol()));

        ((ZMatriz) value).setData(new ZVector(ChickenUtils.copiaPorValor(list)));

        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZArray array) throws SemanticException {

        List<ZVar> list = ChickenUtils.getListVarArray(array.superMatrix,array.sizeList);

        value = new ZArray(0,ChickenUtils.copiaPorValor(list),array.sizeList);


        return ZNothing.getInstance();
    }


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * "assign2" lo uso para un acceso de tipo 2 de una lista    *
     * * * * * * * * * * * * * * * * * * * * * * * * *  * * * * **/

    /**tambien para aignacion de listas*/

    /*primtivos*/
    public ZProtoObject assign2(@NotNull ZInteger value) {

        this.value = value;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign2(@NotNull ZNumeric value) {

        this.value = value;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign2(@NotNull ZBoolean value) {

        this.value = value;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign2(@NotNull ZString value) {

        this.value = value;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign2(@NotNull ZNothing value) {

        this.value = value;
        return ZNothing.getInstance();
    }


    /*no primtivos*/
    public ZProtoObject assign2(@NotNull ZVector value) {

        ChickenUtils.castVectorSize1(this,value);
        return ZNothing.getInstance();
    }

    public ZProtoObject assign2(@NotNull ZList value) {

        this.value = value;
        return ZNothing.getInstance();
    }







    @Override
    public String toChickenString() {
        return value.toChickenString();
    }

    @Override
    public String toString() {
        return "ZVar{" +
                "value=" + value +
                '}';
    }
}
