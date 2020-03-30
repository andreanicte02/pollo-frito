package com.polloenpelotas.language.types;

import com.polloenpelotas.Extras.GUI2;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.Instructions.DeclararParametroAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;

import java.util.List;

public class ZFunction extends ZProtoObject {

    private List<DeclararParametroAstNode> declararParametros;
    private List<AstNode> instructions;
    private ZProtoObject ambitoCapturado;

    public ZFunction(List<DeclararParametroAstNode> declararParametros, List<AstNode> instructions, ZProtoObject ambitoCapturado) {
        this.declararParametros =  declararParametros;
        this.instructions = instructions;
        this.ambitoCapturado = ambitoCapturado;
    }

    public ZProtoObject ejecutarFuncion(List<ZProtoObject> argumentos) throws SemanticException, LocatedSemanticException {


        if(argumentos.size()< declararParametros.size()){
            return ejecutarConError(argumentos);
        }


        ZProtoObject ambitoFuncion = new ZAmbit(ambitoCapturado);

        for (int x = 0;x<argumentos.size(); x++){

            ZVar var = (ZVar) declararParametros.get(x).execute(ambitoFuncion);

            if(argumentos.get(x) instanceof ZDefault){

                if(var.getValue() instanceof ZNothingParameter){
                    var.setValue(ZNothing.getInstance());
                }
                continue;
            }


            var.executeOperation("assign","=",argumentos.get(x));

        }

        var result = ChickenUtils.ejecutarSentencias(instructions,ambitoFuncion);

        if(result instanceof ZRetorno){
            return ((ZRetorno) result).getValue();
        }

        //si noretorna nada retorna nullo
        return ZNothing.getInstance();
    }


    public ZProtoObject ejecutarConError(List<ZProtoObject> argumentos ) throws SemanticException, LocatedSemanticException {

        printErroArgumento();
        int contadorArumgentos=0;

        ZProtoObject ambitoFuncion = new ZAmbit(ambitoCapturado);

        for (int x = 0;x<declararParametros.size(); x++){

            ZVar var = (ZVar) declararParametros.get(x).execute(ambitoFuncion);

            if(contadorArumgentos< argumentos.size() && argumentos.get(contadorArumgentos) instanceof ZDefault){

                if(var.getValue() instanceof ZNothingParameter){
                    var.setValue(ZNothing.getInstance());
                }

                contadorArumgentos++;
                continue;
            }

            if(var.getValue() instanceof ZNothingParameter){
                var.executeOperation("assign","=",argumentos.get(contadorArumgentos));
                contadorArumgentos++;
                continue;
            }


        }



        var result = ChickenUtils.ejecutarSentencias(instructions,ambitoFuncion);

        if(result instanceof ZRetorno){
            return ((ZRetorno) result).getValue();
        }

        //si noretorna nada retorna nullo
        return ZNothing.getInstance();

    }

    public void printErroArgumento(){

        FileLocation aux = new FileLocation(0,0);
        if(instructions.size()!= 0){
            AstNode insAux = instructions.get(0);

            if(insAux instanceof ProAstNode){
                aux = ((ProAstNode) insAux).fileLocation;
            }
        }
        ChickenUtils.lError.add(new LocatedSemanticException(aux,new SemanticException("la cantidad de argumentos nocoinicde, con las declaradas en la funcion, posiblemente la funcion no se ejecute de manera correcta")));
        GUI2.console.setText(GUI2.console.getText()+ "\n fila: "+aux.getY()+" columna:"+aux.getX()+ "la cantidad de argumentos nocoinicde, con las declaradas en la funcion, posiblemente la funcion no se ejecute de manera correcta");
        System.out.println("\n fila: "+aux.getY()+" columna:"+aux.getX()+"la cantidad de argumentos nocoinicde, con las declaradas en la funcion");

    }




    @Override
    public String toChickenString() {
        return null;
    }
}
