package com.polloenpelotas.language.types;

import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.Instructions.DeclararFuncionAstNode;
import com.polloenpelotas.language.nodes.Instructions.DeclararParametroAstNode;

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


    @Override
    public String toChickenString() {
        return null;
    }
}
