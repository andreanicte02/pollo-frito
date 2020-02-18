package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;

public class MultAstNode extends BinaryOperationNode {
    public MultAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "mult", "*", e1, true, e2);
    }
}
