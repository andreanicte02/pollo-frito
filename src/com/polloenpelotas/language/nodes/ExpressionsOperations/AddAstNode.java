package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class AddAstNode extends BinaryOperationNode {
    public AddAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "add", "+", e1, true, e2);
    }
}
//po
//class AddAstNode extends ProAstNode {
//    private final AstNode e1;
//    private final AstNode e2;
//    AddAstNode(FileLocation fl, AstNode e1, AstNode e2) {
//        super(fl);
//        this.e1 = e1;
//        this.e2 = e2;
//    }
//    @Override
//    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
//        final ZProtoObject r1 = e1.execute(ambit);
//        final ZProtoObject r2 = e2.execute(ambit);
//        return r1.executeOperation("add", r2);
//    }
//}