package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

public class ZBoolean extends ZProtoObject {


    private final boolean value;

    public ZBoolean(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    /**add*/
    public ZString add(ZString e){

        return new ZString(this.value + e.getValue());
    }

    public ZVector add(ZVector vector) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,vector,"add","+");

    }

    /**equalTo*/
    public ZBoolean equalTo(ZBoolean e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZVector equalTo (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"equalTo","==");

    }

    /**and*/
    public ZBoolean and(ZBoolean e){

        return new ZBoolean(this.value && e.getValue());
    }

    public ZVector and (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"and","&");

    }

    /**or*/
    public ZBoolean or(ZBoolean e){

        return new ZBoolean(this.value || e.getValue());
    }

    public ZVector or (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"or","|");

    }

    /**not*/
    public ZBoolean not(ZNothing e){

        return new ZBoolean(!this.value);

    }

    /**cast*/

    public ZString castS (ZNothing e) throws SemanticException {

        return new ZString(this.value+"");

    }


    public ZNumeric castN (ZNothing e)  {

        if(value){
            return  new ZNumeric(1.0);
        }

       return  new ZNumeric(0.0);

    }

    public ZInteger castI(ZNothing e){
        if(value){
            return  new ZInteger(1);
        }

        return  new ZInteger(0);
    }

    public ZBoolean castB(ZNothing e){
        //o retornar el this
        return  new ZBoolean(value);

    }


    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
