package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

/**
 * representa el retorno de una sentencia que no es una expresion
 */
public class ZNothing extends ZProtoObject {

    private final static ZNothing instance = new ZNothing();


    private ZNothing(){

    }

    public static ZNothing getInstance(){
        return instance;
    }

    /**add*/
    public ZString  add( ZString e) {

        return new ZString("null"+ e.getValue());

    }

    /**equalTo*/
    public ZBoolean equalTo(ZInteger e){

        return new ZBoolean(false);

    }

    public ZBoolean equalTo(ZNumeric e){

        return new ZBoolean(false);

    }

    public ZBoolean equalTo(ZString e){

        return new ZBoolean(false);

    }


    public ZBoolean equalTo(ZBoolean e){

        return new ZBoolean(false);

    }

    public ZBoolean equalTo(ZList e){

        return new ZBoolean(false);

    }


    public ZVector equalTo(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"equalTo","==");

    }

    public ZBoolean equalTo(ZNothing e){

        return new ZBoolean(true);

    }



    /**notequalto*/

    public ZBoolean notEqualTo(ZInteger e){

        return new ZBoolean(true);

    }

    public ZBoolean notEqualTo(ZNumeric e){

        return new ZBoolean(true);

    }

    public ZBoolean notEqualTo(ZString e){

        return new ZBoolean(true);

    }


    public ZBoolean notEqualTo(ZBoolean e){

        return new ZBoolean(true);

    }


    public ZBoolean notEqualTo(ZList e){

        return new ZBoolean(true);

    }

    public ZVector notEqualTo(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"notEqualTo","!=");

    }


    public ZBoolean notEqualTo(ZNothing e){

        return new ZBoolean(false);

    }

    /**cast*/
    public ZNothing castS (ZNothing e)  {

        return instance;

    }

    public ZNothing castN(ZNothing e){

        return instance;

    }

    public ZNothing castI(ZNothing e){

        return instance;

    }


    //TODO agregar el igual igual







    @Override
    public String toChickenString() {
        return "null";
    }
}
