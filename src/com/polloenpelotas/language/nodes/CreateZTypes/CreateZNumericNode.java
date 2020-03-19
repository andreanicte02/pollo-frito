package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNumeric;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class CreateZNumericNode extends ProAstNode {

    private final double value;
    public CreateZNumericNode(@NotNull FileLocation fileLocation, double value) {
        super(fileLocation);
        this.value = value;

    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZNumeric(this.value);
    }

    @Override
    public Node createNode() {

        return new Node(value+"");
    }
}
