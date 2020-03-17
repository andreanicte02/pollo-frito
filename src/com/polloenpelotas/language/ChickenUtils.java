package com.polloenpelotas.language;

import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.*;
import com.polloenpelotas.language.types.TransferTypes.ZBreak;
import com.polloenpelotas.language.types.TransferTypes.ZContinue;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @NotNull
    public static ZProtoObject  ejecutarSentencias(@NotNull List<AstNode> lInstructions, ZProtoObject ambit) throws LocatedSemanticException {

        for (AstNode node:lInstructions
             ) {

            var result = node.execute(ambit);

            if(result instanceof ZRetorno || result instanceof ZBreak || result instanceof ZContinue){
                return result;
            }

        }

        return ZNothing.getInstance();
    }

    /**desenvoler una lista con AstNodes*/
    @NotNull
    public static List<ZProtoObject> unwrapListExp(List<AstNode> lista, ZProtoObject ambit) throws LocatedSemanticException {
        List<ZProtoObject> nueva = new ArrayList<>();

        for (AstNode node:
             lista) {

            ZProtoObject aux = unwrap(node.execute(ambit));
            nueva.add(aux);

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

    /**si es un vector de tamaño uno y es primtivo, saca el valor y lo seteta de lo contrario setea lo que trae*/
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


    /**evaluar condicion*/
    public static boolean valueCond( String simbol, AstNode condition, ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        //t odo desembuelto
        ZProtoObject con = unwrap(condition.execute(ambit));
        ZProtoObject finalCon = con.executeOperation("valueCondition", simbol);

        if(!(finalCon instanceof ZBoolean)){
            throw new SemanticException("no se puede evaluar la condicion de un "+simbol);
        }

        return ((ZBoolean) finalCon).getValue();

    }


   /**obtiene el primero dato desemvuelto de una lista de ZVAR*/
    public static ZProtoObject getFirstDataUnwrap(List <ZVar> data) throws SemanticException {

        if(data.size() == 0){
            throw  new SemanticException("Se esta tratando de acceder a una lista/vector de tamaño 0");
        }
        return  unwrap(data.get(0));

    }

    /**solo de tamaño 1*/

    public static ZProtoObject ifOnlyOneDataInVector(List<ZVar> data,String messError) throws SemanticException {

        if(data.size()!=1){
            throw new SemanticException(messError);
        }
        //desembuelto
        return  unwrap(data.get(0));

    }

    public static ZProtoObject obtenerUnVector(ZProtoObject ob){

        if(isPrimitive(ob)){
            return new ZVector(new ZVar(ob));
        }

        return ob;

    }

    public static ZProtoObject obtenerUnPrimitivo(ZProtoObject ob) throws SemanticException {
        if(ob instanceof ZVector){
            return getFirstDataUnwrap(((ZVector) ob).getList());
        }
        return  ob;
    }

    public static boolean isYLim(ZVector vector){

        if(vector.getList().size() != 2){
            return false;
        }

        if(unwrap(vector.getList().get(0)) instanceof ZNumeric || unwrap(vector.getList().get(0))  instanceof  ZInteger) {

            if (unwrap(vector.getList().get(1)) instanceof ZNumeric || unwrap(vector.getList().get(1)) instanceof ZInteger) {
                    return true;

            }
        }

        return false;
    }



    /**graficas*/
    public static int grafiteando=0;

    public static void openHtml(String name) throws IOException {
        String ruta = "src/com/polloenpelotas/Graficas/";
        String cmd2 = "gnome-open " + ruta+name + ".html"; //Comando de apagado en linux
        Runtime.getRuntime().exec(cmd2);
        grafiteando++;
    }

    public static void writeFile(String texto, String name, String extension) throws IOException {

        String ruta = "src/com/polloenpelotas/Graficas/";
        FileWriter fichero = new FileWriter(ruta+name+"."+extension);
        PrintWriter pw = new PrintWriter(fichero);
        pw.println(texto);
        fichero.close();

    }

    public static String writeHtml(String extra){

        StringBuffer buffer = new StringBuffer();

        buffer.append("<!DOCTYPE html>" + "<html> " + "\n");
        buffer.append("<head>   </head> " + "\n");
        buffer.append("<body>" + "\n");
        buffer.append(extra + "\n");
        buffer.append("<div id=" + "'G"+grafiteando+"'> </div> \n");
        buffer.append("<script src='https://cdn.plot.ly/plotly-latest.min.js'></script> \n");
        buffer.append("<script src='G"+grafiteando+".js'>" +"</script> \n");

        buffer.append("</body> \n");
        buffer.append("</html> \n");

        return buffer.toString();

    }

    public static String writePie(ZProtoObject title,ZProtoObject values, ZProtoObject labels){

        StringBuffer buffer = new StringBuffer();

        buffer.append("var data = [{\n");
        buffer.append("title: " + title.toChickenString()+","+ "\n");
        buffer.append("values: " +values.toChickenString() + "," +"\n");
        buffer.append("labels: " + labels.toChickenString() +"," +"\n");
        buffer.append("type: 'pie' \n");

        buffer.append("}];  \n \n");

        buffer.append("var layout = { \n");
        buffer.append("}; \n \n");

        buffer.append("Plotly.newPlot("+"'G"+grafiteando+"', data, layout);");
        return buffer.toString();

    }

    public static String barGraphic(ZProtoObject title, ZProtoObject  names, ZProtoObject h, ZProtoObject labelX, ZProtoObject labelY){

        StringBuffer buffer = new StringBuffer();

        buffer.append("var data = [{\n");

        buffer.append("x: " +names.toChickenString() + "," +"\n");
        buffer.append("y: " + h.toChickenString() +"," +"\n");
        buffer.append("type: 'bar' \n");

        buffer.append("}];  \n \n");


        buffer.append("var layout = { \n");
        buffer.append("title: "+title.toChickenString() +",\n");
        buffer.append("xaxis:  {title: "+labelX.toChickenString()+"},\n");
        buffer.append("yaxis:  {title: "+labelY.toChickenString()+"},\n");


        buffer.append("}; \n \n");



        buffer.append("Plotly.newPlot("+"'G"+grafiteando+"', data, layout);");
        return buffer.toString();


    }

    public static String lineGraphic(ZProtoObject v,ZProtoObject type, ZProtoObject labelX, ZProtoObject labelY, ZProtoObject title) throws SemanticException {


        StringBuffer buffer = new StringBuffer();
        String x="";
        String y="";
        String tipo = "";

        if(v instanceof ZVector){

            x=((ZVector) v).mapGraphicLine();
            y= v.toChickenString();

        } else if (v instanceof ZMatriz) {

            x = ((ZMatriz)v).mapGraphicLineX();
            y = ((ZMatriz)v).mapGraphicLineY();

        }else{

            throw new SemanticException("En la funcion plot de lineas, se esperaba una matriz, vector, o primitivo en e primer parametro");

        }

        if(!(type instanceof ZString)){
                tipo="'lines+markers'";
        }else{

            if(((ZString) type).getValue().toLowerCase().equals("o")){
                tipo="'lines+markers'";
            }else if(((ZString) type).getValue().toLowerCase().equals("p")){
                tipo="'lines'";
            }else if(((ZString) type).getValue().toLowerCase().equals("l")){
                tipo ="'markers'";
            }

        }

        buffer.append("var trace1 = { \n");
        buffer.append("x: "+x+", \n");
        buffer.append("y: "+y+", \n");
        buffer.append("mode: "+tipo+"\n");
        buffer.append("}; \n");

        buffer.append("var data = [trace1]; \n");

        buffer.append("var layout = { \n");
        buffer.append("title: "+ title.toChickenString()+",\n");
        buffer.append("xaxis:  {title: "+labelX.toChickenString()+"},\n");
        buffer.append("yaxis:  {title: "+labelY.toChickenString()+"},\n");
        buffer.append("}; \n");

        buffer.append("Plotly.newPlot("+"'G"+grafiteando+"', data, layout);");

        return buffer.toString();
    }

    public static  String histGraphic(ZProtoObject vector, ZProtoObject labelX, ZProtoObject title){



        StringBuffer buffer = new StringBuffer();

        buffer.append("var trace1 = { \n");
        buffer.append("x: "+vector.toChickenString()+",\n");
        buffer.append("type: 'histogram', \n");
        buffer.append("}; \n");

        buffer.append("var layout = { \n");
        buffer.append("title: "+ title.toChickenString()+",\n");
        buffer.append("xaxis:  {title: "+labelX.toChickenString()+"},\n");
        buffer.append("}; \n");

        buffer.append("var data = [trace1]; \n");
        buffer.append("Plotly.newPlot("+"'G"+grafiteando+"', data, layout);");


        return buffer.toString();

    }











}
