package com.polloenpelotas;

import com.polloenpelotas.AnalizadorCup.Lexico;
import com.polloenpelotas.AnalizadorCup.Sintactico;
import com.polloenpelotas.AnalizadorJCC.Gramatica;
import com.polloenpelotas.AnalizadorJCC.ParseException;
import com.polloenpelotas.AnalizadorJCC.TokenMgrError;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.*;
import java_cup.runtime.Symbol;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class
Utils {
    public static FunNativas fn = new FunNativas();

    public static void pruebaJCC(String path){
        try {

            Gramatica parser = new Gramatica(new BufferedReader(new FileReader(path)));
            List<AstNode> ins = parser.analizar();

            ZAmbit aux = new ZAmbit(null);
            chargeFunctions(aux);



            for (AstNode intruccion: ins){
                intruccion.execute(aux);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }catch(TokenMgrError e){
            System.err.println(e.getMessage());
        } catch (LocatedSemanticException e) {
            e.printStackTrace();
        }

    }


    public static void probarCup(String path){
        Sintactico parse = null;
        Lexico lex = null;


        try {
            lex = new Lexico(new FileInputStream(path));
            parse = new Sintactico(lex);

            Symbol symbol = null;
            symbol = parse.parse();

            List<AstNode> ins = (List<AstNode>)symbol.value;

            ZAmbit aux = new ZAmbit(null);
            chargeFunctions(aux);

            for (AstNode intruccion: ins){
                intruccion.execute(aux);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void chargeFunctions(ZAmbit aux){

        aux.functions.put("print",fn.zfuncionPrint());
        aux.functions.put("c",fn.zfuncionC());
        aux.functions.put("list",fn.zfuncionList());
        aux.functions.put("length",fn.zLength());
        aux.functions.put("stringlength",fn.zStringLength());
        aux.functions.put("remove",fn.zRemove());
        aux.functions.put("tolowercase",fn.zToLower());
        aux.functions.put("touppercase",fn.zToUpper());
        aux.functions.put("trunk",fn.zTrunk());
        aux.functions.put("round",fn.zRound());
        aux.functions.put("matrix",fn.zfunctionMat());
        aux.functions.put("pie", fn.pieGraphic());
        aux.functions.put("barplot", fn.barGraphic());
    }


}

class FunNativas {
    public  ZFunction zfuncionPrint(){


        return new ZFunction( new ArrayList<>(),new ArrayList<>(), new ZAmbit(null) ){
            @Override
            //la lista ya viene desembuelta
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos)  {
                if(argumentos.size() == 0){
                    System.out.println("");
                }

                ZProtoObject val = argumentos.get(0);
                System.out.println(val.toChickenString());
                return ZNothing.getInstance();
            }
        };


    }

    public ZFunction zfuncionC(){

        return  new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                return ChickenUtils.createStructC(argumentos);
            }
        };


    }

    public ZFunction zfuncionList(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos)   {
                return new ZList(ChickenUtils.createListData(argumentos));
            }
        };
    }

    public ZFunction zLength(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            //la lista ya viene desembuelta
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {

                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion length");
                }

                ZProtoObject aux = argumentos.get(0);
                if(ChickenUtils.isPrimitive(aux)){
                    return  new ZInteger(1);
                }

                return aux.executeOperation("length", "length(EXP)");


            }
        };
    }


    public ZFunction zStringLength(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException, LocatedSemanticException {

                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion zStringLength");
                }

                ZProtoObject aux = argumentos.get(0);
                return aux.executeOperation("stringLength","stringLength");




            }
        };
    }


    public ZFunction zRemove(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {

                if(argumentos.size() != 2){
                    throw new SemanticException("Se esperaba 2 argumentos en la funcion remove");
                }

                ZProtoObject aux = argumentos.get(0);
                ZProtoObject aux2 = argumentos.get(1);

                return aux.executeOperation("remove","remove",aux2);



            }
        };
    }

    public ZFunction zToLower(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion tolower");
                }

                ZProtoObject aux = argumentos.get(0);
                return aux.executeOperation("toLower","toLower");

            }
        };
    }


    public ZFunction zToUpper(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion toupper");
                }

                ZProtoObject aux = argumentos.get(0);
                return aux.executeOperation("toUpper","toUpper");

            }
        };
    }


    public ZFunction zTrunk(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion trunk");
                }

                ZProtoObject aux = argumentos.get(0);
                return aux.executeOperation("trunk","trunk");

            }
        };
    }


    public ZFunction zRound(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                if(argumentos.size() == 0){
                    throw new SemanticException("Se esperaba un argumento en la funcion round");
                }

                ZProtoObject aux = argumentos.get(0);
                return aux.executeOperation("round","round");

            }
        };
    }

    public ZFunction zfunctionMat(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {

                //argumentos desembueltos
                if(argumentos.size()!=3){
                    throw new SemanticException("Se esperaban 3 argumentos en la funzion Matrix");
                }

                ZInteger auxF = (ZInteger) argumentos.get(1).executeOperation("getInt","buscando int first");
                ZInteger auxC = (ZInteger) argumentos.get(2).executeOperation("getInt","buscando int first");
                ZMatriz mat = new ZMatriz(auxF, auxC);
                mat.setData(argumentos.get(0));

                return mat;
            }

        };

    }

    public ZFunction pieGraphic(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){
            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException {
                if(argumentos.size()!=3){
                    throw new SemanticException("Se esperaban 3 argumentos en la funcion pie");
                }

                ZProtoObject values = ChickenUtils.obtenerUnVector(argumentos.get(0));
                ZProtoObject labels = ChickenUtils.obtenerUnVector(argumentos.get(1));
                ZProtoObject title = ChickenUtils.obtenerUnPrimitivo(argumentos.get(2));



                if (!(values instanceof  ZVector) || !(labels instanceof  ZVector)){
                    throw new SemanticException("Se esperava un vector o un dato primitivo, funcion pie");
                }



                try {
                    var js = ChickenUtils.writePie(title, values, labels);
                    ChickenUtils.writeFile(ChickenUtils.writeHtml(""),"H"+ ChickenUtils.grafiteando,"html");
                    ChickenUtils.writeFile(js, "G"+ChickenUtils.grafiteando,"js");
                    ChickenUtils.openHtml("H"+ChickenUtils.grafiteando);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return ZNothing.getInstance();


            }
        };
    }

    public static ZFunction barGraphic(){

        return new ZFunction(new ArrayList<>(),new ArrayList<>(), new ZAmbit(null)){

            @Override
            public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException, LocatedSemanticException {

                if(argumentos.size()!=5){
                    throw new SemanticException("se esperaban 5 argumentos en la funcion pie");
                }

                ZProtoObject h = ChickenUtils.obtenerUnVector(argumentos.get(0));
                ZProtoObject xLabel = ChickenUtils.obtenerUnPrimitivo(argumentos.get(1));
                ZProtoObject yLabel = ChickenUtils.obtenerUnPrimitivo(argumentos.get(2));

                ZProtoObject main = ChickenUtils.obtenerUnPrimitivo(argumentos.get(3)); //titulomai
                ZProtoObject names = ChickenUtils.obtenerUnVector(argumentos.get(4));



                if (!(names instanceof  ZVector) || !(h instanceof  ZVector)){
                    throw new SemanticException("Se esperava un vector o un dato primitivo, funcion pie");
                }



                try {
                    var js = ChickenUtils.barGraphic(main,names, h,xLabel, yLabel);
                    ChickenUtils.writeFile(ChickenUtils.writeHtml(""),"H"+ ChickenUtils.grafiteando,"html");
                    ChickenUtils.writeFile(js, "G"+ChickenUtils.grafiteando,"js");
                    ChickenUtils.openHtml("H"+ChickenUtils.grafiteando);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                return ZNothing.getInstance();
            }
        };
    }


}
