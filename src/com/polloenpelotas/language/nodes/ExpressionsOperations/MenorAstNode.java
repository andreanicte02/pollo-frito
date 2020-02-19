package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class MenorAstNode extends BinaryOperationNode {
    public MenorAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "menor", "<", e1, true, e2);
    }
}
