package com.polloenpelotas.language.types;

import com.polloenpelotas.Utils;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

import javax.swing.text.Utilities;
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

    public ZVector access(ZInteger index){

        return new ZVector( list.get(index.getValue()-1) ) ;

    }

    public ZProtoObject access(ZVector index) throws SemanticException {

        ChickenUtils.isSize0(index,"derecho");

        return this.executeOperation("access"," exp[exp] right ",index.getList().get(0).getValue());
    }

    /* * * * * * * * * * * * * * * *
     *  access from the left side  *
     * * * * * * * * * * * * * * * */

    public ZProtoObject access1Left(ZInteger index){

        ZVar aux = list.get(index.getValue()-1);

        if(ChickenUtils.isPrimitive(aux.getValue())){

            return new ZVector(list.get(index.getValue()-1));

        }

        return aux.getValue();

    }

    public ZProtoObject access1Left(ZVector index) throws SemanticException {

        ChickenUtils.isSize0(index,"izquierdo");

        return this.executeOperation("access1Left"," exp[exp] left ",index.getList().get(0).getValue());

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

        return ChickenUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZString e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this,e,"add","+");

    }
    public ZVector add(ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZBoolean e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZNothing e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this,e,"add","+");

    }

    public ZVector add(ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this,e,"add","+");

    }



    /**resta*/

    public ZVector rest (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"rest","-");
    }

    public ZVector rest (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"rest","-");
    }

    public ZVector rest (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"rest","-");
    }


    /**mult*/
    public ZVector mult (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mult","*");
    }

    public ZVector mult (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mult","*");
    }

    public ZVector mult (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"mult","*");
    }

    // TODO: validar que el numero no sea div entre 0
    /**div**/

    public ZVector div (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"div","/");

    }

    public ZVector div (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"div","/");

    }

    public ZVector div (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"div","/");

    }

    /**pot*/

    public ZVector pot (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"pot","^");

    }

    public ZVector pot (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"pot","^");

    }

    public ZVector pot (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"pot","^");

    }

    /**mod*/
    public ZVector mod (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mod","%");

    }

    public ZVector mod (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mod","%");

    }

    public ZVector mod (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"mod","%");

    }

    /**mayor*/
    public ZVector mayor (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayor",">");

    }

    public ZVector mayor (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayor",">");

    }

    public ZVector mayor (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"mayor",">");

    }

    /**menor*/
    public ZVector menor (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"menor","<");

    }
    public ZVector menor (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"menor","<");

    }
    public ZVector menor (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"menor","<");

    }

    /**mayorigual*/
    public ZVector mayorIgual (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }
    public ZVector mayorIgual (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayorIgual",">=");

    }
    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"mayorIgual",">=");

    }

    /**menorigual*/
    public ZVector menorIgual (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayorIgual","<=");

    }
    public ZVector menorIgual (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"mayorIgual","<=");

    }
    public ZVector menorIgual (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"mayorIgual","<=");

    }

    /**equalto*/
    public ZVector equalTo (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"equalTo","==");

    }
    public ZVector equalTo (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"equalTo","==");

    }

    public ZVector equalTo (ZNothing e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"equalTo","==");

    }

    public ZVector equalTo (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"equalTo","==");

    }

    /**notequalto*/
    public ZVector notEqualTo (ZInteger e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }
    public ZVector notEqualTo (ZNumeric e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZVector notEqualTo (ZNothing e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"notEqualTo","!=");

    }

    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"notEqualTo","!=");

    }

    /**and*/
    public ZVector and (ZBoolean e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"and","&");

    }

    public ZVector and (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"and","&");

    }

    /**or*/
    public ZVector or (ZBoolean e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this, e,"or","|");

    }

    public ZVector or (ZVector e) throws SemanticException {

        return ChickenUtils.vectorVectorOperation(this, e,"and","|");

    }

    /**unary*/
    public ZVector unaryMinus(ZNothing e) throws SemanticException {

        return  ChickenUtils.leftVectorOperation(this,e,"unaryMinus","-E");
    }

    /**not*/
    public ZVector not (ZNothing e) throws SemanticException {

        return ChickenUtils.leftVectorOperation(this,e,"not","!");

    }







    @Override
    public String toChickenString() {

        var strings = this.list.stream()
                .map(ZProtoObject::toChickenString) // sugar
                .collect(Collectors.toList());
//        var a = this.list.stream().map(zProtoObject -> zProtoObject.toChickenString()).collect(Collectors.toList());

        return '[' + String.join(", ", strings) + ']';
    }
}
