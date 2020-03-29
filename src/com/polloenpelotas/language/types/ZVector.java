package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.MatrixUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ZVector extends ZProtoObject {

    public List<ZVar> getList() {
        return list;
    }

    private  List<ZVar> list = new ArrayList<>();

    public ZVector(ZVar firstValue) {

        this.list.add(firstValue);
    }

    public ZVector(List<ZVar> list){
        this.list = list;
    }



    /* * * * * * * * * * * * * * * *
     *  access from the right side  *
     * * * * * * * * * * * * * * * */

    public ZVector access(ZInteger index) throws SemanticException {
        if(index.getValue()> list.size()){
            throw new SemanticException("se esta intentado acceder a un posocion fuera de rango");
        }

        return new ZVector( list.get(index.getValue()-1) ) ;

    }

    public ZProtoObject access(ZVector index) throws SemanticException {


        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access"," exp[exp] right ", aux);
    }

    /* * * * * * * * * * * * * * * *
     *  access from the left side  *
     * * * * * * * * * * * * * * * */

    public ZProtoObject access1Left(ZInteger index) throws SemanticException {

        if(index.getValue()==0){
            throw new SemanticException("se intenta asignar a un vector en una posocion 0");
        }

        VectorUtils.increaseZSize(list, index.getValue());

        ZVar aux = list.get(index.getValue()-1);

        if(ChickenUtils.isPrimitive(aux.getValue())){

            ZVector a = new ZVector(list.get(index.getValue()-1));
            a.inMatrix = this.inMatrix;

            return a;

        }

        aux.inMatrix=this.inMatrix;
        return new ZVector(aux);

    }

    public ZProtoObject access1Left(ZVector index) throws SemanticException {

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(index.getList());

        return this.executeOperation("access1Left"," exp[exp] left ",aux);

    }

    /* * * * * *
    *  assign  *
    * * * * * */

    /* primitives values */
    public ZProtoObject assign(ZInteger newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);


        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZString newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZBoolean newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZNumeric newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZNothing newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    /* not primitives values */


    public ZProtoObject assign(ZVector newValue){

        ZVar aux = list.get(0);
        ChickenUtils.castVectorSize1(aux,newValue);

        return ZNothing.getInstance();

    }

    public ZProtoObject assign(ZList newValue){

        ZVar aux = list.get(0);
        aux.setValue(newValue);

        return ZNothing.getInstance();

    }

    /* * * * * * * * * * * * * * *
     *  operaciones aritmeticas  *
     * * * * * * * * * * * * * * */

    /**suma*/
    public ZVector add(ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"add","+");

    }
    public ZVector add(ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZBoolean e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this,e,"add","+");

    }

    public ZMatriz add(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"add","+");

    }


    /**resta*/

    public ZVector rest (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"rest","-");
    }

    public ZVector rest (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"rest","-");
    }

    public ZVector rest (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"rest","-");
    }

    public ZMatriz rest(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"rest","-");

    }


    /**mult*/
    public ZVector mult (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mult","*");
    }

    public ZVector mult (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mult","*");
    }

    public ZVector mult (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"mult","*");
    }

    public ZMatriz mult(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"mult","*");

    }


    /**div**/

    //si la division es entre cero se hace en los primitivos
    public ZVector div (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"div","/");

    }

    public ZVector div (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"div","/");

    }

    public ZVector div (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"div","/");

    }

    public ZMatriz div(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"div","/");

    }


    /**pot*/

    public ZVector pot (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"pot","^");

    }

    public ZVector pot (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"pot","^");

    }

    public ZVector pot (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"pot","^");

    }

    public ZMatriz pot(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"pot","^");

    }

    /**mod*/
    public ZVector mod (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mod","%%");

    }

    public ZVector mod (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mod","%%");

    }

    public ZVector mod (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"mod","%%");

    }

    public ZMatriz mod(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"mod","%%");

    }


    /**mayor*/
    public ZVector mayor (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayor",">");

    }

    public ZVector mayor (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayor",">");

    }

    public ZVector mayor (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayor",">");

    }

    public ZVector mayor (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayor",">");

    }


    public ZVector mayor (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"mayor",">");

    }

    public ZMatriz mayor(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"mayor",">");

    }


    /**menor*/
    public ZVector menor (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menor","<");

    }
    public ZVector menor (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menor","<");

    }

    public ZVector menor (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menor","<");

    }

    public ZVector menor (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menor","<");

    }


    public ZVector menor (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"menor","<");

    }

    public ZMatriz menor(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"menor","<");

    }

    /**mayorigual*/
    public ZVector mayorIgual (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }
    public ZVector mayorIgual (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }

    public ZVector mayorIgual (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }

    public ZVector mayorIgual (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }

    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"mayorIgual",">=");

    }

    public ZMatriz mayorIgual(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"mayorIgual",">=");

    }

    /**menorigual*/
    public ZVector menorIgual (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menorIgual","<=");

    }
    public ZVector menorIgual (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menorIgual","<=");

    }

    public ZVector menorIgual (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menorIgual","<=");

    }

    public ZVector menorIgual (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"menorIgual","<=");

    }

    public ZVector menorIgual (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"menorIgual","<=");

    }

    public ZMatriz menorIgual(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"menorIgual","<=");

    }


    /**equalto*/
    public ZVector equalTo (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"equalTo","==");

    }
    public ZVector equalTo (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"equalTo","==");

    }

    public ZVector equalTo (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"equalTo","==");

    }

    public ZVector equalTo (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"equalTo","==");

    }

    public ZVector equalTo (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"equalTo","==");

    }

    public ZMatriz equalTo(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"equalTo","==");

    }

    /**notequalto*/
    public ZVector notEqualTo (ZInteger e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }
    public ZVector notEqualTo (ZNumeric e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZVector notEqualTo (ZString e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZVector notEqualTo (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZMatriz notEqualTo(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"notEqualTo","!=");

    }

    /**and*/
    public ZVector and (ZBoolean e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"and","&");

    }

    public ZVector and (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"and","&");

    }

    public ZMatriz and(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"and","&");

    }

    /**or*/
    public ZVector or (ZBoolean e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this, e,"or","|");

    }

    public ZVector or (ZVector e) throws SemanticException {

        return VectorUtils.vectorVectorOperation(this, e,"or","|");

    }

    public ZMatriz or(ZMatriz e) throws SemanticException {
        ZProtoObject other = ChickenUtils.ifOnlyOneDataInVector(list,"se intenta operar una matriz con un vector > 1");
        return MatrixUtils.rightMatrixOperation(other,e,"or","|");

    }


    /**unary*/
    public ZVector unaryMinus(ZNothing e) throws SemanticException {

        return  VectorUtils.leftVectorOperation(this,e,"unaryMinus","-E");
    }

    /**not*/
    public ZVector not (ZNothing e) throws SemanticException {

        return VectorUtils.leftVectorOperation(this,e,"not","!");

    }

    /**value conditions*/

    public ZProtoObject valueCondition() throws SemanticException {


        ZProtoObject unwrapVal = ChickenUtils.getFirstDataUnwrap(list);
        return unwrapVal.executeOperation("valueCondition","if | switch | tern");


    }

    /**lenght*/

    public ZInteger length (){

        return new ZInteger(list.size());

    }

    /**stringLength**/
    public ZProtoObject stringLength() throws SemanticException {

        if(list.size()!=1){
            throw new SemanticException("se le aplico stringLength a un vector > 1 |0 ");
        }

        ZProtoObject val = ChickenUtils.unwrap(list.get(0));
        return val.executeOperation("stringLength","stringLength");

    }

    /**remove*/
    public ZProtoObject remove(ZString val) throws SemanticException {
        if(list.size()!=1){
            throw new SemanticException("se le aplico remove a un vector > 1 | 0 ");
        }
        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return  aux.executeOperation("remove","remove",val);
    }

    public ZProtoObject remove(ZVector val) throws SemanticException {

        if(list.size()!=1){
            throw new SemanticException("se le aplico remove a un vector > 1 | 0 ");
        }

        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return  aux.executeOperation("remove","remove",val);
    }

    /**tolower*/


    public ZProtoObject toLower() throws SemanticException {
        if(list.size()!=1){
            throw new SemanticException("se le aplico tolower a un vector > 1 | 0 ");
        }
        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return aux.executeOperation("toLower","toLower");

    }

    public ZProtoObject toUpper() throws SemanticException {
        if(list.size()!=1){
            throw new SemanticException("se le aplico toUpper a un vector > 1 | 0 ");
        }
        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return aux.executeOperation("toUpper","toUpper");

    }

    /**trunk**/
    public ZProtoObject trunk() throws SemanticException {

        if(list.size()!=1){
            throw new SemanticException("se le aplico trunk a un vector > 1 | 0 ");
        }

        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return aux.executeOperation("trunk","trunk");

    }

    /**round**/
    public ZProtoObject round() throws SemanticException {

        if(list.size()!=1){
            throw new SemanticException("se le aplico round a un vector > 1 | 0 ");
        }

        ZProtoObject aux = ChickenUtils.unwrap(list.get(0));
        return aux.executeOperation("round","round");

    }

    /**modificacion de matrices**/

    public ZProtoObject assignMatrix(ZVector niudato) throws SemanticException {

        if(list.size() == niudato.list.size()){

            for (int x =0; x<list.size(); x++){
                ZVar aux = list.get(x);
                ZVar aux2 = niudato.getList().get(x);

                aux.setValue(aux2.getValue());

            }

            return ZNothing.getInstance();
        }

        if(niudato.list.size() == 1){
            ZProtoObject nuevo = ChickenUtils.getFirstDataUnwrap(niudato.getList());
            for (int x =0; x< list.size();x++){
                ZVar aux = list.get(x);
                aux.setValue(nuevo);
            }

            return ZNothing.getInstance();
        }


        throw new SemanticException("Error Modificacion de una matriz");



    }

    /**typeof*/

    public ZProtoObject typeof() throws SemanticException {

        if(list.size() ==0){

            return  ZNothing.getInstance();

        }

        ZProtoObject aux = ChickenUtils.getFirstDataUnwrap(list);

        return aux.executeOperation("typeof","typeof");

    }


    @Override
    public String toChickenString() {

        var strings = this.list.stream()
                .map(ZProtoObject::toChickenString) // sugar
                .collect(Collectors.toList());
//        var a = this.list.stream().map(zProtoObject -> zProtoObject.toChickenString()).collect(Collectors.toList());

        return '[' + String.join(", ", strings) + ']';
    }

    public String mapGraphicLine(){

        String out ="[";
        for (int x=0 , cont = 1; x<list.size(); x++, cont++ ){
            out+=cont+",";
        }

        out = out.substring(0,out.length()-1);
        out +="]";

        return out;
    }
}
