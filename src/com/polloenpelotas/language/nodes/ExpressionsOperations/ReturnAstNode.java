package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZRetorno;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class ReturnAstNode extends ProAstNode {

    private  final AstNode exp;

    public ReturnAstNode(@NotNull FileLocation fileLocation, AstNode exp) {
        super(fileLocation);
        this.exp = exp;
    }


    public ReturnAstNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
        this.exp = new CreateZNothingNode(fileLocation);
    }


    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        //el valor desenvuelto
        return  new ZRetorno(ChickenUtils.unwrap(exp.execute(ambit)));

    }
}
