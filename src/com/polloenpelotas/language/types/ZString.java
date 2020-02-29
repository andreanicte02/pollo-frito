package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;

public class ZString extends ZProtoObject {
    private final String value;

    public ZString(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    /**add**/
    public ZString add(ZInteger e){
        return new ZString(this.value + e.getValue());
    }
    public ZString add(ZString e){
        return new ZString(this.value + e.getValue());
    }

    public ZString add(ZNumeric e){
        return new ZString(this.value + e.getValue());
    }


    public ZString add(ZBoolean e){
        return new ZString(this.value + e.getValue());
    }

    public ZVector add(ZVector vector) throws SemanticException {
        return ChickenUtils.rightVectorOperation(this,vector,"add","+");
    }

    public ZString  add( ZNothing e) {

        return new ZString(value+"Nothing");

    }



    /**menor**/
    public ZBoolean menor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==-1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector menor (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"menor","<");

    }

    /**mayor*/
    public ZBoolean mayor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector mayor (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"mayor",">");
    }


    /**mayorIgual*/
    public ZBoolean mayorIgual(ZString e){

        int res = this.value.compareTo(e.getValue());
        return res >= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"mayorIgual",">=");
    }

    /**menorIgual*/
    public ZBoolean menorIgual (ZString e){


        int res = this.value.compareTo(e.getValue());
        return res <= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector menorIgual (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }



    /**equalTo*/
    public ZBoolean equalTo (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean equalTo (ZNothing e){

        return new ZBoolean( false);
    }

    public ZVector equalTo (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"equalTo","==");

    }


    /**notEqualTo*/

    public ZBoolean notEqualTo (ZString e){

        return new ZBoolean( !equalTo(e).getValue() );
    }

    public ZBoolean notEqualTo (ZNothing e){

        return new ZBoolean( true);
    }

    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return ChickenUtils.rightVectorOperation(this,e,"notEqualTo","!=");

    }

    /**cast*/

    /**cast*/


    public ZString castS (ZNothing e)  {

        return new ZString(this.getValue());

    }




    @Override
    public String toChickenString() {
        // TODO: debe de salir con comillas?
        return "\"" + value + "\"";
    }
}
