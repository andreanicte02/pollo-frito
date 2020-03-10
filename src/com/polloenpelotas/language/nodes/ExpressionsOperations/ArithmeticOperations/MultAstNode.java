package com.polloenpelotas.language.nodes.ExpressionsOperations.ArithmeticOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class MultAstNode extends BinaryOperationNode {
    public MultAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "mult", "*", e1, true, e2);
    }
}
