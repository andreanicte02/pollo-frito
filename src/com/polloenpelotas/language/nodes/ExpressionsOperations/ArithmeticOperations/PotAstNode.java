package com.polloenpelotas.language.nodes.ExpressionsOperations.ArithmeticOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class PotAstNode extends BinaryOperationNode {
    public PotAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "pot", "^", e1, true, e2);
    }
}
