package com.polloenpelotas.language.types;

public class ZString extends ZProtoObject {
    private final String value;

    public ZString(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

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

    public ZBoolean menor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==-1? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean mayor (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==1? new ZBoolean(true): new ZBoolean(false);

    }
    public ZBoolean mayorIgual(ZString e){

        int res = this.value.compareTo(e.getValue());
        return res >= 0? new ZBoolean(true): new ZBoolean(false);

    }

    public ZBoolean menorIgual (ZString e){


        int res = this.value.compareTo(e.getValue());
        return res <= 0? new ZBoolean(true): new ZBoolean(false);

    }



    public ZBoolean equalTo (ZString e){

        int res = this.value.compareTo(e.getValue());

        return res==0? new ZBoolean(true): new ZBoolean(false);

    }


    @Override
    public String toChickenString() {
        // TODO: debe de salir con comillas?
        return "\"" + value + "\"";
    }
}
