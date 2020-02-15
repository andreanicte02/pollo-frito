package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class BinaryOperationNode extends ProAstNode {

    private final String operationName;
    private final AstNode e1;
    private final boolean unwrap1;
    private final AstNode e2;

    public BinaryOperationNode(FileLocation fl, String operationName, AstNode e1, boolean unwrap1, AstNode e2) {
        super(fl);
        this.operationName = operationName;
        this.e1 = e1;
        this.unwrap1 = unwrap1;
        this.e2 = e2;
    }
    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        final ZProtoObject r1 = e1.execute(ambit);
        final ZProtoObject r2 = e2.execute(ambit);
        return r1.executeOperation(operationName, r2);
    }

}
