package com.polloenpelotas.Extras;

import com.polloenpelotas.AnalizadorCup.Lexico;
import com.polloenpelotas.AnalizadorCup.Sintactico;
import com.polloenpelotas.AnalizadorJCC.Gramatica;
import com.polloenpelotas.AnalizadorJCC.ParseException;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.Utils;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.ZAmbit;
import java_cup.runtime.Symbol;

import java.io.*;
import java.util.List;

public class FlowInterpreter {
    AstGraphic graph = new AstGraphic();

    public void executeCup(String path){

        System.out.println("-----------------------------cup------------------------------");
        GUI2.console.setText("cup:");

        List<AstNode> ins= executeParserCup(path);


        ZAmbit ambit = new ZAmbit(null);
        Utils.chargeFunctions(ambit);
        try {
            ChickenUtils.ejecutarSentencias(ins,ambit);
        } catch (LocatedSemanticException e) {
            e.printStackTrace();
        }

    }

    public void executeJCC(String path){
        System.out.println("-----------------------------jcc------------------------------");
        GUI2.console.setText("jcc");

        List<AstNode> ins= executeParserJCC(path);



        ZAmbit ambit = new ZAmbit(null);
        Utils.chargeFunctions(ambit);
        try {
            ChickenUtils.ejecutarSentencias(ins,ambit);
        } catch (LocatedSemanticException e) {
            e.printStackTrace();
        }

    }

    public void astCup(String path){

        List<AstNode> ins= executeParserCup(path);
        Node root=ChickenUtils.nodeInstructions(ins,"root");
        graph.armar_Cuerpo_dot(root,"CUP");

    }

    public void astJCC(String path){

        List<AstNode> ins= executeParserJCC(path);
        Node root = ChickenUtils.nodeInstructions(ins,"root");
        graph.armar_Cuerpo_dot(root,"JCC");

    }

    public void tsCup(String path){


        List<AstNode> ins= executeParserCup(path);


        ZAmbit ambit = new ZAmbit(null);
        Utils.chargeFunctions(ambit);
        try {
            ChickenUtils.ejecutarSentencias(ins,ambit);
            ChickenUtils.writeFile(ChickenUtils.reporteTablaSimbolos(ambit),"TSCup_201404104","html");
            ChickenUtils.openHtml("TSCup_201404104");

        } catch (LocatedSemanticException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tsJCC(String path){


        List<AstNode> ins= executeParserJCC(path);

        ZAmbit ambit = new ZAmbit(null);
        Utils.chargeFunctions(ambit);
        try {
            ChickenUtils.ejecutarSentencias(ins,ambit);
            ChickenUtils.writeFile(ChickenUtils.reporteTablaSimbolos(ambit),"TSCup_201404104","html");
            ChickenUtils.openHtml("TSCup_201404104");

        } catch (LocatedSemanticException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<AstNode> executeParserCup(String path){

        Sintactico parse = null;
        Lexico lex = null;

        try {

            lex = new Lexico(new FileInputStream(path));
            parse = new Sintactico(lex);

            Symbol symbol = parse.parse();

            List<AstNode> ins = (List<AstNode>)symbol.value;
            return ins;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<AstNode> executeParserJCC(String path){

        try {

            Gramatica parser = new Gramatica(new BufferedReader(new FileReader(path)));
            return  parser.analizar();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;


    }
}
