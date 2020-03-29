package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import org.jetbrains.annotations.NotNull;

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

    public ZProtoObject assign(@NotNull ZMatriz zmat ) {
        value =zmat;
        return ZNothing.getInstance();
    }

    public ZProtoObject assign(@NotNull ZArray array){
        value = array;
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
