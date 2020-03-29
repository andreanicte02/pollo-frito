package com.polloenpelotas.language.types;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.Instructions.DeclararParametroAstNode;
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


        if(argumentos.size()> declararParametros.size()){
            throw new SemanticException("La cantidad de argumentos enviados, es mayor con la cantidad de parametros declarados");
        }
        int contadorArumgentos=0;

        ZProtoObject ambitoFuncion = new ZAmbit(ambitoCapturado);

        for (int x = 0;x<declararParametros.size(); x++){

            ZVar var = (ZVar) declararParametros.get(x).execute(ambitoFuncion);

            if(var.getValue() instanceof ZNothingParameter){
                var.executeOperation("assign","=",argumentos.get(contadorArumgentos));
                contadorArumgentos++;
                continue;
            }

            if(contadorArumgentos< argumentos.size() && argumentos.get(contadorArumgentos) instanceof ZDefault){
                contadorArumgentos++;
                continue;
            }

        }

        if(contadorArumgentos!= argumentos.size()){
            throw new SemanticException("no se terminaron de declarar todos los argumentos");
        }


        var result = ChickenUtils.ejecutarSentencias(instructions,ambitoFuncion);

        if(result instanceof ZRetorno){
            return ((ZRetorno) result).getValue();
        }

        //si noretorna nada retorna nullo
        return ZNothing.getInstance();
    }




    @Override
    public String toChickenString() {
        return null;
    }
}
