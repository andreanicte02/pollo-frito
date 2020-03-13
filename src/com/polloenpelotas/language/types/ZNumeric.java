package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;
import org.jetbrains.annotations.NotNull;

public class ZNumeric extends ZProtoObject {

    public double getValue() {
        return value;
    }

    private final double value;

    public ZNumeric(double value) {
        this.value = value;
    }

    /**suma*/
    public ZNumeric add(ZNumeric e) {
        return new ZNumeric(value + e.getValue());
    }


    public ZNumeric add(ZInteger e) {
        return new ZNumeric(value + e.getValue());
    }


    public ZString add(ZString e) {
        return new ZString(value+  e.getValue());
    }

    public ZVector add(ZVector vector) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,vector,"add","+");
    }

    //el null se trata como un string
    public ZString add(ZNothing e){
        return new ZString(value + "null");
    }



    /*resta*/

    public ZNumeric rest (ZInteger e){

        return new ZNumeric(this.value -e.getValue());
    }

    public ZNumeric rest (ZNumeric e){

        return new ZNumeric(this.value -e.getValue());
    }

    public ZVector rest (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"rest","-");
    }

    /*mult*/

    public ZNumeric mult(ZInteger e){

        return new ZNumeric(this.value * e.getValue());
    }

    public ZNumeric mult(ZNumeric e){

        return new ZNumeric(this.value * e.getValue());
    }

    public ZVector mult(ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mult","*");

    }


    /*div*/

    // TODO: validar que el numero no sea div entre 0

    public ZNumeric div(ZInteger e){

        return new ZNumeric(this.value / e.getValue());
    }

    public ZNumeric div(ZNumeric e){

        return new ZNumeric(this.value / e.getValue());
    }

    public ZVector div(ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"div","/");
    }


    /**pot*/
    public ZNumeric pot(@NotNull ZInteger e){

        return new ZNumeric( Math.pow(this.value, e.getValue()));
    }

    public ZNumeric pot(@NotNull ZNumeric e){

        return new ZNumeric( Math.pow(this.value, e.getValue()));
    }


    public ZVector pot(@NotNull ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"pot","^");
    }


    /*mod*/

    public ZNumeric mod(@NotNull ZInteger e){

        return new ZNumeric( this.value % e.getValue());
    }

    public ZNumeric mod(@NotNull ZNumeric e){

        return new ZNumeric( this.value % e.getValue());
    }

    public ZVector mod(@NotNull ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mod","%%");
    }

    /**unario*/


    public ZNumeric unaryMinus (ZNothing e) {

        return  new ZNumeric(value * -1);

    }

    /**mayor*/

    public ZBoolean mayor(ZInteger e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZBoolean mayor (ZNumeric e){

        return new ZBoolean(this.value > e.getValue());
    }

    public ZVector mayor (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mayor",">");
    }



    /**menor*/

    public ZBoolean menor(ZInteger e){

        return new ZBoolean(this.value < e.getValue());
    }

    public ZBoolean menor (ZNumeric e){

        return new ZBoolean(this.value < e.getValue());
    }

    public ZVector menor (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"menor","<");

    }

    /**mayor igual*/

    public ZBoolean mayorIgual(ZInteger e){

        return new ZBoolean(this.value >= e.getValue());
    }

    public ZBoolean mayorIgual (ZNumeric e){

        return new ZBoolean(this.value >= e.getValue());
    }

    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mayorIgual","<=");
    }

    /**menor igual*/


    public ZBoolean menorIgual(ZInteger e){

        return new ZBoolean(this.value <= e.getValue());
    }

    public ZBoolean menorIgual (ZNumeric e){

        return new ZBoolean(this.value <= e.getValue());
    }


    public ZVector menorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }

    /**equalTo*/


    public ZBoolean equalTo(ZInteger e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZBoolean equalTo (ZNumeric e){

        return new ZBoolean(this.value == e.getValue());
    }

    public ZBoolean equalTo(ZNothing e){

        return new ZBoolean(false);
    }



    public ZVector equalTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"equalTo","==");

    }

    /**not equal to*/

    public ZBoolean notEqualTo (ZNumeric e){

        return new ZBoolean( !equalTo(e).getValue() );
    }

    public ZBoolean notEqualTo (ZInteger e){

        return new ZBoolean( !equalTo(e).getValue() );
    }

    public ZBoolean notEqualTo (ZNothing e){

        return new ZBoolean( true);
    }
    
    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"notEqualTo","!=");

    }

    /**cast*/

    public ZString castS (ZNothing e) throws SemanticException {

        return new ZString(""+this.getValue());

    }

    public ZNumeric castN(ZNothing e){

        return new ZNumeric(this.getValue());

    }

    /**trunk*/
    public ZInteger trunk(){

        return new ZInteger((int) value);

    }

    /**round*/

    public ZInteger round(){

        return new ZInteger((int) Math.round(value));

    }




    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
