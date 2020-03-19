package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZBreak;
import com.polloenpelotas.language.types.TransferTypes.ZContinue;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;
import com.polloenpelotas.language.types.ZAmbit;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WhileAstNode extends ProAstNode {
    private final AstNode cond;
    private final List<AstNode> instructions;

    public WhileAstNode(@NotNull FileLocation fileLocation, AstNode cond, List<AstNode> instructions) {
        super(fileLocation);
        this.cond = cond;
        this.instructions = instructions;
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        while (ChickenUtils.valueCond("while",cond, ambit)){

            ZProtoObject result = ChickenUtils.ejecutarSentencias(instructions,new ZAmbit(ambit));

            if(result instanceof ZRetorno){

                return result;
            }

            if(result instanceof ZContinue){
                continue;
            }

            if(result instanceof ZBreak){
                return ZNothing.getInstance();
            }

        }
        return ZNothing.getInstance();
    }

    @Override
    public Node createNode() {
        Node result = new Node("while");
        result.add(new Node("while"));
        result.add(cond.createNode());
        result.add(ChickenUtils.nodeInstructions(instructions,"Instructions"));
        return result;
    }
}
