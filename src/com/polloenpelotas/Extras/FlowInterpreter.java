package com.polloenpelotas.Extras;

import com.polloenpelotas.AnalizadorCup.Lexico;
import com.polloenpelotas.AnalizadorCup.Sintactico;
import com.polloenpelotas.AnalizadorJCC.Gramatica;
import com.polloenpelotas.AnalizadorJCC.ParseException;
import com.polloenpelotas.language.*;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.ZAmbit;
import java_cup.runtime.Symbol;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlowInterpreter {

    AstGraphic graph = new AstGraphic();
    boolean isCup=false;

    public void executeCup(String path){

        System.out.println("-----------------------------cup------------------------------");
        GUI2.console.setText("cup:");


        try {

            List<AstNode> ins= getInstructionsCup(path);
            ZAmbit ambit = new ZAmbit(null);
            Utils.chargeFunctions(ambit);
            ChickenUtils.ejecutarSentencias(ins,ambit);

        } catch (LocatedSemanticException e) {
            ChickenUtils.lError.add(e);
            e.printStackTrace();
        } catch (Exception e) {
              e.printStackTrace();
        }
        ChickenUtils.printErrors(ChickenUtils.lError,true);

    }

    public void executeJCC(String entrada){
        System.out.println("-----------------------------jcc------------------------------");
        GUI2.console.setText("jcc");

        try {

            List<AstNode> ins= getInstructionsJCC(entrada);
            ZAmbit ambit = new ZAmbit(null);
            Utils.chargeFunctions(ambit);

            ChickenUtils.ejecutarSentencias(ins,ambit);
        } catch (LocatedSemanticException e) {
            ChickenUtils.lError.add(e);
            e.printStackTrace();
        } catch (ParseException e){
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage() + e.getLocalizedMessage())));

            e.printStackTrace();
        } catch ( IOException e ){
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage() )));

            e.printStackTrace();
        }

        ChickenUtils.printErrors(ChickenUtils.lError, false);


    }

    public void astCup(String path){


        try {
            List<AstNode> ins = getInstructionsCup(path);
            Node root=ChickenUtils.nodeInstructions(ins,"root");
            graph.armar_Cuerpo_dot(root,"CUP");
        }
        catch (LocatedSemanticException e){
            ChickenUtils.lError.add(e);
        }
        catch (Exception e) {

              e.printStackTrace();
        }

        ChickenUtils.printErrors(ChickenUtils.lError,true);


    }

    public void astJCC(String entrada){

        isCup = false;
        try {

            List<AstNode>ins = getInstructionsJCC(entrada);
            Node root = ChickenUtils.nodeInstructions(ins,"root");
            graph.armar_Cuerpo_dot(root,"JCC");

        } catch (ParseException e) {
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage() + e.getLocalizedMessage())));
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ChickenUtils.printErrors(ChickenUtils.lError,false);

    }

    public void tsCup(String path){


        try {
            List<AstNode> ins= getInstructionsCup(path);

            ZAmbit ambit = new ZAmbit(null);

            Utils.chargeFunctions(ambit);
            ChickenUtils.ejecutarSentencias(ins,ambit);
            ChickenUtils.writeFile(ChickenUtils.reporteTablaSimbolos(ambit),"TSCup_201404104","html");
            ChickenUtils.openHtml("TSCup_201404104");

        } catch (LocatedSemanticException e) {
            ChickenUtils.lError.add(e);
            e.printStackTrace();
        } catch (IOException e) {
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage())));
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChickenUtils.printErrors(ChickenUtils.lError,true);
    }

    public void tsJCC(String entrada){


        try {

            List<AstNode> ins= getInstructionsJCC(entrada);
            ZAmbit ambit = new ZAmbit(null);
            Utils.chargeFunctions(ambit);
            ChickenUtils.ejecutarSentencias(ins,ambit);
            ChickenUtils.writeFile(ChickenUtils.reporteTablaSimbolos(ambit),"TSCup_201404104","html");
            ChickenUtils.openHtml("TSCup_201404104");

        } catch (LocatedSemanticException e) {
            ChickenUtils.lError.add(e);
            e.printStackTrace();

        } catch (ParseException e){
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage() + e.getLocalizedMessage())));
            e.printStackTrace();
        }
        catch (IOException e) {
            ChickenUtils.lError.add(new LocatedSemanticException(new FileLocation(-1,-1), new SemanticException(e.getMessage())));

            e.printStackTrace();
        }
        ChickenUtils.printErrors(ChickenUtils.lError,false);


    }

    public void reporteErrores(){
        try {
            ChickenUtils.writeFile(ChickenUtils.reporteErrores(ChickenUtils.lError,isCup),"ReporteError","html");
            ChickenUtils.openHtml("ReporteError");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<AstNode> getInstructionsCup(String path) throws Exception {

        isCup=true;

        ChickenUtils.lError = new ArrayList<>();
        Lexico lex = new Lexico(new FileInputStream(path));
        Sintactico parse = new Sintactico(lex);
        Symbol symbol = parse.parse();
        List<AstNode> ins = (List<AstNode>)symbol.value;
        return ins;


    }



    public List<AstNode> getInstructionsJCC(String entrada) throws ParseException, FileNotFoundException {
        isCup=false;
        ChickenUtils.lError = new ArrayList<>();

        Gramatica parser = new Gramatica(new BufferedReader(new StringReader(entrada.replace("\\\"","\\$"))));
        return  parser.analizar();


    }
}
