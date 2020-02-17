package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class BinaryOperationNode extends ProAstNode {

    private final String operationName;
    private final String operationSymbol;
    private final AstNode e1;
    private final boolean unwrapLeft;
    private final AstNode e2;

    public BinaryOperationNode(FileLocation fl, String operationName, String operationSymbol, AstNode e1, boolean unwrapLeft, AstNode e2) {
        super(fl);
        this.operationName = operationName;
        this.operationSymbol = operationSymbol;
        this.e1 = e1;
        this.unwrapLeft = unwrapLeft;
        this.e2 = e2;
    }
    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        final ZProtoObject left = e1.execute(ambit);
        final ZProtoObject r1 = unwrapLeft? ChickenUtils.unwrap(left) : left;

        final ZProtoObject r2 = ChickenUtils.unwrap(e2.execute(ambit));

        return r1.executeOperation(this.operationName, this.operationSymbol, r2);
    }

}
