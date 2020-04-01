package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.MatrixUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

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

    /**add**/
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
        return new ZString("null" + "null");
    }

    public ZVector add(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this, e, "add", "+");
    }

    public ZMatriz add(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "add", "+");
    }

    public ZString add(ZList e){
        return new ZString("null"+e.toChickenString());
    }

    /**menor*/
    public ZBoolean menor(ZString e) {

        int res = "null".compareTo(e.getValue());
        return res == -1 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector menor(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"menor","<");
    }

    public ZMatriz menor(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "menor", "<");
    }


    /**mayor*/
    public ZBoolean mayor(ZString e) {

        int res = "null".compareTo(e.getValue());
        return res == 1 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector mayor(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"mayor",">");
    }

    public ZMatriz mayor(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "mayor", ">");
    }

    /**mayor igual*/

    public ZBoolean mayorIgual(ZString e) {

        int res = "null".compareTo(e.getValue());
        return res >= 0 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector mayorIgual(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"mayorIgual",">=");
    }

    public ZMatriz mayorIgual(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "mayorIgual", ">=");
    }

    /**menor igual*/

    public ZBoolean menorIgual(ZString e) {

        int res = "null".compareTo(e.getValue());
        return res <= 0 ? new ZBoolean(true) : new ZBoolean(false);

    }

    public ZVector menorIgual(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }

    public ZMatriz menorIgual(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "menorIgual", "<=");
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

    //todo preguntar bien
    public ZBoolean equalTo(ZList e){
        return new ZBoolean(false);
    }

    public ZBoolean equalTo(ZArray e){
        return new ZBoolean(false);
    }


    public ZBoolean equalTo(ZNothing e){
        return new ZBoolean(true);
    }

    public ZVector equalTo(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"equalTo","==");
    }
    public ZMatriz equalTo(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "equalTo", "==");
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

    public ZBoolean notEqualTo(ZNothing e){
        return new ZBoolean(false);
    }

    public ZBoolean notEqualTo(ZList e){
        return new ZBoolean(true);
    }

    public ZBoolean notEqualTo(ZArray e){
        return new ZBoolean(true);
    }

    public ZVector notEqualTo(ZVector e) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,e,"notEqualTo","!=");
    }

    public ZMatriz notEqualTo(ZMatriz e) throws SemanticException {
        return MatrixUtils.rightMatrixOperation(this, e, "notEqualTo", "!=");
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

    /**typeof*/

    public ZString typeof(){

        return new ZString("null");

    }




    //TODO agregar el igual igual







    @Override
    public String toChickenString() {
        return "null";
    }
}
