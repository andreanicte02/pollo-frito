package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZInteger;
import com.polloenpelotas.language.types.ZNumeric;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class UnaryOperationNode extends ProAstNode {

    private final String operationName;
    private final String operationSymbol;
    private final AstNode e;


    public UnaryOperationNode(@NotNull FileLocation fileLocation, String operationName, String operationSymbol, AstNode e) {
        super(fileLocation);
        this.operationName = operationName;
        this.operationSymbol = operationSymbol;
        this.e = e;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        ZProtoObject r = ChickenUtils.unwrap(e.execute(ambit));
        return r.executeOperation(operationName,operationSymbol,new ZInteger(-1));

    }
}
