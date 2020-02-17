package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;

public class AssignNode extends BinaryOperationNode {
    public AssignNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "assign", "=", e1, false, e2);
    }
}
