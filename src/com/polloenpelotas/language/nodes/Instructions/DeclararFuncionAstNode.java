package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZFunction;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DeclararFuncionAstNode extends ProAstNode {


    private final List<AstNode> parametros;
    private final List<AstNode> instructions;

    public DeclararFuncionAstNode(@NotNull FileLocation fileLocation, List<AstNode> parametros, List<AstNode> instructions) {
        super(fileLocation);
        this.parametros = parametros;
        this.instructions = instructions;

    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        List<DeclararParametroAstNode> lParametros = new ArrayList<>();
        for (AstNode node:
             parametros) {

            if(node instanceof DeclararParametroAstNode){
                lParametros.add((DeclararParametroAstNode) node);
                continue;
            }

            if(node instanceof FindIDAstNode){
                lParametros.add(new DeclararParametroAstNode(fileLocation ,((FindIDAstNode) node).getName(),new CreateZNothingNode(fileLocation)) );
                continue;
            }

            throw new SemanticException("Se declararon parametros, que no son de tipo -> id | id=exp");

        }

        return new ZFunction(lParametros, instructions, ambit);

    }
}
