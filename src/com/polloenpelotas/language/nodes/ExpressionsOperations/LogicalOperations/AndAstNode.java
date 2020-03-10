package com.polloenpelotas.language.nodes.ExpressionsOperations.LogicalOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class AndAstNode extends BinaryOperationNode {
    public AndAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "and", "&", e1, true, e2);
    }
}
