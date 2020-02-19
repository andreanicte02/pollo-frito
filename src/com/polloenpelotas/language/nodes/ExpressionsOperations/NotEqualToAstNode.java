package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class NotEqualToAstNode extends BinaryOperationNode {

    public NotEqualToAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "notEqualTo", "!=", e1, true, e2);
    }
}
