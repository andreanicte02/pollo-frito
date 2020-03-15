package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.MatrixUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ZInteger extends ZProtoObject {
    private final int value;

    public ZInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**suma*/
    public ZInteger add(ZInteger e) {

        return new ZInteger(this.value + e.value);
    }

    public ZString  add( ZString e) {

        return new ZString(this.value + e.getValue());
    }

    public ZNumeric add (ZNumeric e){

        return new ZNumeric(this.value+ e.getValue());
    }
    //el null se trata como un string
    public ZString add(ZNothing e){

        return new ZString(value + "null");
    }

    public ZVector add(ZVector vector) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,vector,"add","+");
    }

    public ZMatriz add(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"add","+");
    }



    /**resta*/

    public ZInteger rest (ZInteger e){

        return new ZInteger(this.value -e.getValue());
    }

    public ZNumeric rest (ZNumeric e){

        return new ZNumeric(this.value -e.getValue());
    }

    public ZVector rest (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"rest","-");
    }

    public ZMatriz rest(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"rest","-");
    }


    /**mult*/

    public ZInteger mult(ZInteger e){

        return new ZInteger(this.value * e.getValue());
    }

    public ZNumeric mult(ZNumeric e){

        return new ZNumeric(this.value * e.getValue());
    }

    public ZVector mult(ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mult","*");

    }

    public ZMatriz mult(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"mult","*");

    }

    // TODO: validar que el numero no sea div entre 0
    /**div*/
    public ZInteger div(ZInteger e){

        return new ZInteger(this.value / e.getValue());
    }

    public ZNumeric div(ZNumeric e){

        return new ZNumeric(this.value /e.getValue());
    }

    public ZVector div(ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"div","/");
    }

    public ZMatriz div(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"div","/");

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

    public ZMatriz pot(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"pot","^");

    }



    /**mod*/
    public ZInteger mod(@NotNull ZInteger e){

        return new ZInteger( this.value % e.getValue());
    }

    public ZNumeric mod(@NotNull ZNumeric e){

        return new ZNumeric( this.value % e.getValue());
    }

    public ZVector mod(@NotNull ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mod","%%");
    }

    public ZMatriz mod(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"mod","%%");

    }


    /**unaryMinus*/
    public ZInteger unaryMinus (ZNothing e) {

        return  new ZInteger(value * -1);
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

    public ZMatriz mayor(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"mayor",">");

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

    public ZMatriz menor(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"menor","<");

    }


    /**mayorIgual*/
    public ZBoolean mayorIgual(ZInteger e){

        return new ZBoolean(this.value >= e.getValue());
    }

    public ZBoolean mayorIgual (ZNumeric e){

        return new ZBoolean(this.value >= e.getValue());
    }

    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mayorIgual",">=");
    }

    public ZMatriz mayorIgual(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"mayorIgual",">=");

    }


    /**menorigual*/
    public ZBoolean menorIgual(ZInteger e){

        return new ZBoolean(this.value <= e.getValue());
    }

    public ZBoolean menorIgual (ZNumeric e){

        return new ZBoolean(this.value <= e.getValue());
    }

    public ZVector menorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }

    public ZMatriz menorIgual(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"menorIgual","<=");

    }


    /**equal to*/
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

    public ZMatriz equalTo(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"equalTo","==");

    }

    //TODO probar diferente
    /*** not equalTo*/
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

    public ZMatriz notEqualTo(ZMatriz e) throws SemanticException {

        return MatrixUtils.rightMatrixOperation(this,e,"notEqualTo","!=");

    }

    /**cast*/


    public ZString castS (ZNothing e)  {

        return new ZString(""+this.getValue());

    }

    public ZNumeric castN(ZNothing e){

        return new ZNumeric(this.getValue());

    }

    public ZInteger castI(ZNothing e){

        return new ZInteger(this.getValue());

    }

    /**trunk**/

    public ZInteger trunk(){

        return new ZInteger(value);
    }

    /**round*/
    public ZInteger round(){

        return new ZInteger(value);
    }
    /**get int**/

    public ZInteger getInt(){
        return this;
    }










    @Override
    public String toChickenString() {
        return String.valueOf(value);
    }
}
