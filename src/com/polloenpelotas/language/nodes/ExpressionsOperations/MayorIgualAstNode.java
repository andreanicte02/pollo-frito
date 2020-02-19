package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class MayorIgualAstNode extends BinaryOperationNode {
    public MayorIgualAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "mayorIgual" , ">=", e1, true, e2);
    }
}
