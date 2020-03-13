package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

/**
 * representa el retorno de una sentencia que no es una expresion
 */
public class ZNothing extends ZProtoObject {

    private final static ZNothing instance = new ZNothing();


    //se trata como un string

    private ZNothing() {

    }


    public static ZNothing getInstance() {
        return instance;
    }

    /**
     * add
     */
    public ZString add(ZString e) {

        return new ZString("null" + e.getValue());

    }

    public ZString add(ZInteger e) {

        return new ZString("null" + e.getValue());

    }


    public ZString add(ZNumeric e) {

        return new ZString("null" + e.getValue());

    }


    public ZString add(ZBoolean e) {

        return new ZString("null" + e.getValue());

    }


    public ZString add(ZNothing e) {

        return new ZString("null" + "nulls");

    }


    public ZVector add(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this, e, "add", "+");

    }

    /**
     * menor
     **/
    public ZBoolean menor(ZString e) {

        int res = "null".compareTo(e.getValue());

        return res == -1 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector menor(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"menor","<");
    }


    /**
     * mayor
     */
    public ZBoolean mayor(ZString e) {

        int res = "null".compareTo(e.getValue());

        return res == 1 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector mayor(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"mayor",">");
    }


    /**
     * mayorIgual
     */
    public ZBoolean mayorIgual(ZString e) {

        int res = "null".compareTo(e.getValue());
        return res >= 0 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector mayorIgual(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"mayorIgual",">=");
    }




    /**
     * menorIgual
     */
    public ZBoolean menorIgual(ZString e) {


        int res = "null".compareTo(e.getValue());
        return res <= 0 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector menorIgual(ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }



    /**equalTo*/

    public ZBoolean equalTo (ZString e){

        int res = "null".compareTo(e.getValue());

        return res==0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean equalTo(ZInteger e){

        return new ZBoolean(false);

    }

    public ZBoolean equalTo(ZNumeric e){

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

    public ZBoolean notEqualTo (ZString e){

        return new ZBoolean( !equalTo(e).getValue() );
    }


    public ZBoolean notEqualTo(ZInteger e){

        return new ZBoolean(true);

    }

    public ZBoolean notEqualTo(ZNumeric e){

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
