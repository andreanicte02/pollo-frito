package com.polloenpelotas.language.nodes.ExpressionsOperations.ArithmeticOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class RestAstNode extends BinaryOperationNode {
    public RestAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "rest", "-", e1, true, e2);
    }
}
