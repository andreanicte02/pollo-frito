package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.MatrixUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

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

    public ZString add(ZNothing e){

        return new ZString(value + "null");
    }

    public ZInteger add(ZBoolean e){

        return new ZInteger(getInt() + e.getInt());
    }

    public ZNumeric add(ZNumeric e){

        return new ZNumeric(getInt() + e.getValue());
    }

    public ZNumeric add(ZInteger e){

        return new ZNumeric(getInt() + e.getValue());
    }



    public ZVector add(ZVector vector) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,vector,"add","+");

    }

    public ZMatriz add(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"add","+");

    }


    /**equalTo*/
    public ZBoolean equalTo(ZBoolean e){

        return new ZBoolean(this.value == e.getValue());
    }


    public ZBoolean equalTo(ZNothing e){

        return new ZBoolean(false);
    }


    public ZVector equalTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"equalTo","==");

    }

    public ZMatriz equalTo(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"equalTo","==");

    }

    /**notequalto*/
    public ZBoolean notEqualTo(ZBoolean e){

        return new ZBoolean(this.value != e.getValue());
    }

    public ZBoolean notEqualTo (ZNothing e){

        return new ZBoolean( true);
    }

    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"notEqualTo","!=");

    }

    public ZMatriz notEqualTo(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"notEqualTo","!=");

    }

    /**and*/
    public ZBoolean and(ZBoolean e){

        return new ZBoolean(this.value && e.getValue());
    }

    public ZVector and (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"and","&");

    }

    public ZMatriz and(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"and","&");

    }

    /**or*/
    public ZBoolean or(ZBoolean e){

        return new ZBoolean(this.value || e.getValue());
    }

    public ZVector or (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"or","|");

    }

    public ZMatriz or(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"or","|");

    }

    /**not*/
    public ZBoolean not(ZNothing e){

        return new ZBoolean(!this.value);

    }

    /**relacionales*/

    public ZBoolean mayor(ZInteger e){

        return new ZBoolean(this.getInt() > e.getValue());
    }

    public ZBoolean mayor (ZNumeric e){

        return new ZBoolean(this.getInt() > e.getValue());
    }

    public ZBoolean mayor(ZBoolean e){

        return new ZBoolean(this.getInt() > e.getInt());
    }



    public ZBoolean menor(ZBoolean e){

        return new ZBoolean(getInt()< e.getInt());
    }

    public ZBoolean menor(ZInteger e){

        return new ZBoolean(getInt()< e.getValue());
    }

    public ZBoolean menor(ZNumeric e){

        return new ZBoolean(getInt()< e.getValue());
    }


    public ZBoolean mayorIgual(ZInteger e){

        return new ZBoolean(getInt() >= e.getValue());
    }

    public ZBoolean mayorIgual (ZNumeric e){

        return new ZBoolean(getInt() >= e.getValue());
    }

    public ZBoolean mayorIgual(ZBoolean e){

        return new ZBoolean(getInt() >= e.getInt());
    }


    public ZBoolean menorIgual(ZInteger e){

        return new ZBoolean(getInt() <= e.getValue());
    }

    public ZBoolean menorIgual (ZNumeric e){

        return new ZBoolean(getInt() <= e.getValue());
    }

    public ZBoolean menorIgual(ZBoolean e){

        return new ZBoolean(getInt() <= e.getInt());
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
    /**value condicion*/

    public ZBoolean valueCondition(){

        return this;
    }

    /**typeof*/

    public ZString typeof(){

        return new ZString("boolean");

    }


    public int getInt(){

        return value?1:0;
    }


    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
