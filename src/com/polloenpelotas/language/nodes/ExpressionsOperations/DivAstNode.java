package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class DivAstNode extends BinaryOperationNode {
    public DivAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "div", "/", e1, true, e2);
    }
}
