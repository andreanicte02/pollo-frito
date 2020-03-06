package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZAmbit;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class IfAstNode extends ProAstNode {
    private final AstNode condition;
    private final List<AstNode> instructionsTrue;
    private final List<AstNode> instructionsFalse;

    public IfAstNode(@NotNull FileLocation fileLocation, AstNode condition, List<AstNode> instructionsTrue, List<AstNode> instructionsFalse) {
        super(fileLocation);
        this.condition = condition;
        this.instructionsTrue = instructionsTrue;
        this.instructionsFalse = instructionsFalse;
    }
    //TODO probarlo bien
    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        //tod o desenvuelto si no cagadales

        boolean finalCon = ChickenUtils.valueCond("if",condition, ambit);
        ZAmbit local = new ZAmbit(ambit);
        //aca se heredan las banderas para los breaks y esos
        List<AstNode> sentecias = finalCon? instructionsTrue: instructionsFalse;
        return ChickenUtils.ejecutarSentencias(sentecias,local);

    }
}
