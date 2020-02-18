package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.UnaryOperationNode;
import org.jetbrains.annotations.NotNull;

public class UnaryNotNode extends UnaryOperationNode {
    public UnaryNotNode(@NotNull FileLocation fileLocation,  AstNode e) {
        super(fileLocation, "operationName", "operationSymbol", e);
    }
}
