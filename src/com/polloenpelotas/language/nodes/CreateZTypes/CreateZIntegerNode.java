package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZInteger;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class CreateZIntegerNode extends ProAstNode {

    private final int value;

    public CreateZIntegerNode(@NotNull FileLocation fileLocation, int value) {
        super(fileLocation);
        this.value = value;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZInteger(this.value);
    }
}
