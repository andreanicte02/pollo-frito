package com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;

public class Access3MatrixAstNode extends BinaryOperationNode {
    public Access3MatrixAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "access3", "matrix[,exp]", e1, true, e2);
    }
}
