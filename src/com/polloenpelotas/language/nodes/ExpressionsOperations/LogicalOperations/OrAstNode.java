package com.polloenpelotas.language.nodes.ExpressionsOperations.LogicalOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class OrAstNode extends BinaryOperationNode {
    public OrAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "or", "|", e1, true, e2);
    }
}
