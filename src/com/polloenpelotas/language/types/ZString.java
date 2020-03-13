package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.VectorUtils;

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


    public ZString  add( ZNothing e) {

        return new ZString(value+"null");

    }

    public ZVector add(ZVector vector) throws SemanticException {
        return VectorUtils.rightVectorOperation(this,vector,"add","+");
    }




    /**menor**/
    public ZBoolean menor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==-1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean menor (ZNothing e){

        int res = this.value.compareTo("null");
        return res==-1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector menor (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"menor","<");

    }



    /**mayor*/
    public ZBoolean mayor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean mayor (ZNothing e){

        int res = this.value.compareTo("null");

        return res==1? new ZBoolean(true): new ZBoolean(false);

    }


    public ZVector mayor (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mayor",">");
    }


    /**mayorIgual*/
    public ZBoolean mayorIgual(ZString e){

        int res = this.value.compareTo(e.getValue());
        return res >= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean mayorIgual(ZNothing e){

        int res = this.value.compareTo("null");
        return res >= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector mayorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"mayorIgual",">=");
    }

    /**menorIgual*/
    public ZBoolean menorIgual (ZString e){


        int res = this.value.compareTo(e.getValue());
        return res <= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean menorIgual (ZNothing e){


        int res = this.value.compareTo("null");
        return res <= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZVector menorIgual (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"menorIgual","<=");
    }



    /**equalTo*/
    public ZBoolean equalTo (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==0? new ZBoolean(true): new ZBoolean(false);

    }


    public ZBoolean equalTo (ZNothing e){

        int res = this.value.compareTo("null");
        return res==0? new ZBoolean(true): new ZBoolean(false);
    }

    public ZVector equalTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"equalTo","==");

    }


    /**notEqualTo*/

    public ZBoolean notEqualTo (ZString e){

        return new ZBoolean( !equalTo(e).getValue() );
    }

    public ZBoolean notEqualTo (ZNothing e){

        return new ZBoolean( !equalTo(e).getValue());
    }

    public ZVector notEqualTo (ZVector e) throws SemanticException {

        return VectorUtils.rightVectorOperation(this,e,"notEqualTo","!=");

    }

    /**cast*/

    /**cast*/


    public ZString castS (ZNothing e)  {

        return new ZString(this.getValue());

    }

    /**length string*/

    public ZInteger stringLength(){

        return new ZInteger(this.value.length());

    }


    /**remove*/

    public ZString remove(ZString val){
        return new ZString(value.replace(val.value,""));
    }

    public ZProtoObject remove(ZVector vector) throws SemanticException {

        if(vector.getList().size()!= 1){

            throw new SemanticException("se le aplico remove a un vector > 1 | 0 ");
        }

        ZProtoObject aux = ChickenUtils.unwrap(vector.getList().get(0));
        return this.executeOperation("remove", "remove",aux);

    }

    /**tolower***/

    public ZString toLower(){

        return new ZString(value.toLowerCase());

    }

    /**touper*/


    public ZString toUpper(){

        return new ZString(value.toUpperCase());

    }






    @Override
    public String toChickenString() {
        // TODO: debe de salir con comillas?
        return "\"" + value + "\"";
    }
}
