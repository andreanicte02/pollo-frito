package com.polloenpelotas.language;

import com.polloenpelotas.Utils;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.*;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class ChickenUtils {


    /**maneja las variables*/
    public static @NotNull ZProtoObject unwrap(@NotNull ZProtoObject value){

        if (value instanceof ZVar) {
            return ((ZVar) value).getValue();
        }
        return value;
    }

    /**obtiene la variable del lado izquierdo*/
    public static @NotNull ZProtoObject getVarLeft(@NotNull ZProtoObject ambit, String name){

        for(ZProtoObject e = ambit; e!= null; e= e.getAnterior()){

            if(e.members.containsKey(name)){

                // se obtiene un zvar
                return e.members.get(name);
            }
        }

        return createVariable(ambit,name);

    }

    /**crea una variavle*/
    public static @NotNull ZProtoObject createVariable(@NotNull ZProtoObject ambit, String name){

        ambit.members.put(name, new ZVar(ZNothing.getInstance()));
        return ambit.members.get(name);

    }

    /**obtiene una varialbe del lado derecho*/
    public static @NotNull ZProtoObject getVarRight(@NotNull ZProtoObject ambit, String name) throws SemanticException {

        for(ZProtoObject e = ambit; e!= null; e= e.getAnterior()){

            if(e.members.containsKey(name)){

                return e.members.get(name);
            }
        }

        throw new SemanticException("La variable con el nombre id: "+name+", no existe");
    }

    /**declararparametro*/

    public static void declararParametro(String name, ZVar var, ZProtoObject ambit) throws SemanticException {

        //en el ambito actual de la funcion
        if (ambit.members.containsKey(name)){

            throw new SemanticException("La variable con el nombre id: "+name+", ya existe");

        }
        ambit.members.put(name,var);


    }

    public static void crearFuncion(String name, ZFunction funcion, ZProtoObject ambit) throws SemanticException {

        //solo deberia ser global
        if(ambit.functions.containsKey(name)){

            throw new SemanticException("La funcion con el nombre id: "+name+", ya existe");
        }
        ambit.functions.put(name, funcion);

    }

    //si esta dentro de otra funcion la llamada, el global no va ser el actual
    public static ZFunction getFuncion(String name, ZProtoObject amibt) throws SemanticException {

        for(ZProtoObject e = amibt; e != null; e= e.getAnterior()){

            if(e.functions.containsKey(name)){
                return e.functions.get(name);
            }
        }

        throw new  SemanticException("La funcion con el nombre id: "+name+", no existe");


    }

    public static ZProtoObject ejecutarSentencias(List<AstNode> lInstructions, ZProtoObject ambit) throws LocatedSemanticException {

        for (AstNode node:lInstructions
             ) {

            var result = node.execute(ambit);

            if(result instanceof ZRetorno || result instanceof ZBreak){
                return result;
            }



        }

        return ZNothing.getInstance();
    }

    /**desenvoler una lista con AstNodes*/
    public static List<ZProtoObject> unwrapListExp(List<AstNode> lista, ZProtoObject ambit) throws LocatedSemanticException {
        List<ZProtoObject> nueva = new ArrayList<>();

        for (AstNode node:
             lista) {

            nueva.add(unwrap(node.execute(ambit)));

        }

        return nueva;

    }


    /**funcionC*/

    public static ZProtoObject createStructC(List<ZProtoObject> unwrapList) throws SemanticException {
        //estan totalmente desembueltos

        List<ZVar> newData = new ArrayList<>();


        if (unwrapList.stream().anyMatch(x->x instanceof ZList)){

            unwrapList.forEach(x->{
                if(x instanceof ZList){
                    newData.addAll(setListInList((ZList) x));

                } else if(x instanceof ZVector){

                    newData.addAll(setVectorInVector((ZVector) x));

                }else{
                    newData.add(new ZVar(x));
                }
            });

            return new ZList(newData);
        }

        unwrapList.forEach(x-> {
            if (x instanceof ZVector){
                newData.addAll(setVectorInVector((ZVector) x));
            }else{
                newData.add(new ZVar(x));
            }
        });

        return new ZVector(defineTypeVector(newData));
    }

    /**encuentra la prioridad del vector*/
    public static  List<ZVar>  defineTypeVector(List<ZVar> list) throws SemanticException {

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZString)){
            return castearVector(list,"castS","castS");
        }

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZNumeric)){
            return castearVector(list,"castN","castN");
        }

        if(list.stream().anyMatch(x->x.getValue() instanceof  ZInteger)){
            return castearVector(list,"castI","castI");
        }

        return list;

    }

    /**metodo que se encarga de castear los vectores*/
    public static List<ZVar> castearVector(List<ZVar> list,String name, String simbol) throws SemanticException {
        List <ZVar> niuList= new ArrayList<>();
        for (ZVar node:
             list) {
            ZProtoObject aux = node.getValue().executeOperation(name, simbol, ZNothing.getInstance());
            niuList.add(new ZVar(aux));
        }
        return  niuList;
    }


    /**si en una funcionC viene un vector saca los valores y los
     *  agrega en una nueva lista para poder juntarlos con el vector final*/
    public static List<ZVar> setVectorInVector(ZVector vector){

        List<ZVar> list= new ArrayList<>();
        for (ZVar node:
             vector.getList()) {

            list.add(new ZVar(node.getValue()));

        }
        return list;
        
    }

    /**funcionC cuando vienen lista*/

    public static List<ZVar> setListInList(ZList lista){
        List<ZVar> nuevaLista= new ArrayList<>();
        List<ZVar> temporal = lista.getList();

        for(int x=0; x<temporal.size();x++){

            if(temporal.get(x).getValue()instanceof ZVector){

                ZVar zvar = new ZVar(ZNothing.getInstance());
                castVectorSize1(zvar, (ZVector) temporal.get(x).getValue());
                nuevaLista.add(zvar);
                continue;
            }
            nuevaLista.add(new ZVar(temporal.get(x).getValue()));
        }


        return nuevaLista;

    }


    /**metodo con el se crea una lsita nueva*/
    public static List<ZVar>  createListData(List<ZProtoObject> unwrapList){

        List<ZVar> dataList = new ArrayList<>();
        for (ZProtoObject node:
             unwrapList) {

            if (node instanceof ZVector){
                dataList.add(addDataVectorToList( (ZVector) node));
                continue;
            }
            dataList.add(new ZVar(node));
        }

        return dataList;
    }

    /**si una vector es del tamaño1 se obtiene el dato primitivo que este tiene*/
    public static ZVar addDataVectorToList(ZVector vector){

        if(vector.getList().size()>1 || vector.getList().size() == 0) {
            return new ZVar(vector);
        }

        ZVar aux = vector.getList().get(0);
        return new ZVar(aux.getValue());

    }

    /**aumenta el tamaño*/
    public static void  increaseZSize(List<ZVar> list, int index){

        if(index> list.size()){

            for (int x = list.size()-1; x<index-1;x++){
                list.add(new ZVar(ZNothing.getInstance()));
            }
        }

    }


    /**accesos*/

    /*si es un vector solo se envia el vector otra vez*/
    /*si es una lista solo se envia la lista otra vez*/
    /*si viniera un primitivo, se tendria que envolver en un vector*/

    public static ZProtoObject returnValueAccess2List(ZProtoObject unwrapValue, ZVar wrapValue){

        if (unwrapValue instanceof ZVector){
            return new ZVector(((ZVector) unwrapValue).getList());
        }

        if(unwrapValue instanceof ZList){
            return new ZList(((ZList) unwrapValue).getList());
        }

        return new ZVector(wrapValue);

    }
    /**si hay un dato primitivo**/
    public static boolean isPrimitive(ZProtoObject val) {

        if (val instanceof ZInteger || val instanceof ZNumeric || val instanceof ZString || val instanceof ZBoolean || val instanceof ZNothing) {
            return true;

        }
        return false;
    }

    public static void castVectorSize1(ZVar var, ZVector vector){

        if(vector.getList().size()==1 && ChickenUtils.isPrimitive(vector.getList().get(0).getValue())){

            var.setValue(vector.getList().get(0).getValue());

            return;
        }
        var.setValue(vector);

        return;
    }

    @NotNull
    public static List<ZVar> copiaPorValor(@NotNull List<ZVar> actual){

        List<ZVar> nueva =  new ArrayList<>();

        for (ZVar node:
             actual) {

            nueva.add(new ZVar(node.getValue()));

        }

        return nueva;

    }

    public static void isSize0(ZVector valor, String lado) throws SemanticException {

        if(valor.getList().size() == 0){

            throw new SemanticException(" Error al acceder id[exp] || id[[exp]]  del lado " + lado );
        }


    }

    public static ZVector rightVectorOperation(ZProtoObject left ,ZVector right, String name, String sim) throws SemanticException {

        List<ZVar> nova = new ArrayList<>();
        for (ZVar node:
                right.getList()) {

            ZProtoObject aux = left.executeOperation(name,sim,node.getValue());
            nova.add(new ZVar(aux));
        }

        return new ZVector(nova);

    }

    public static ZVector leftVectorOperation (ZVector left, ZProtoObject right, String name, String sim) throws SemanticException {

        List<ZVar> nova = new ArrayList<>();

        for(ZVar node:
            left.getList()){

            ZProtoObject aux = node.getValue().executeOperation(name, sim,right);
            nova.add(new ZVar(aux));
        }

        return new ZVector(nova);

    }

    public static ZVector vectorVectorOperation(ZVector left, ZVector right, String name, String sim) throws SemanticException {


        if(left.getList().size()==right.getList().size()){

            return operar2VecotresXD(left,right,name,sim);

        }

        if(left.getList().size()==1){

            ZProtoObject aux =  unwrap(left.getList().get(0));
            return rightVectorOperation(aux,right, name, sim);
        }

        if(right.getList().size() == 1){

            ZProtoObject aux = unwrap(right.getList().get(0));
            return leftVectorOperation(left,aux, name, sim);
        }

        throw new SemanticException("error al operar vectores, no son del mismo tamaño");
    }

    public static ZVector operar2VecotresXD(ZVector left, ZVector right, String name, String sim) throws SemanticException {
        ZProtoObject aux;
        ZProtoObject aux2;
        ZProtoObject niuValue;
        List<ZVar> nueva = new ArrayList<>();

        for (int i = 0; i<left.getList().size();i++){

            aux = unwrap(left.getList().get(i));
            aux2 = unwrap(right.getList().get(i));
            niuValue = aux.executeOperation(name, sim,aux2);
            nueva.add(new ZVar(niuValue));

        }

        return new ZVector(nueva);

    }







}
