package com.polloenpelotas;

import com.polloenpelotas.AnalizadorCup.Lexico;
import com.polloenpelotas.AnalizadorCup.Sintactico;
import com.polloenpelotas.AnalizadorJCC.Gramatica;
import com.polloenpelotas.AnalizadorJCC.ParseException;
import com.polloenpelotas.AnalizadorJCC.TokenMgrError;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.types.ZAmbit;
import com.polloenpelotas.language.types.ZNumeric;
import com.polloenpelotas.language.types.ZVar;
import java_cup.runtime.Symbol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void pruebaJCC(String path){
        try {
            Gramatica parser = new Gramatica(new BufferedReader(new FileReader(path)));
            List<AstNode> ins = parser.Analizar();

            ZAmbit aux = new ZAmbit(null);
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
            for (AstNode intruccion: ins){
                intruccion.execute(aux);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
