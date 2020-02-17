package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZString;
import org.jetbrains.annotations.NotNull;

public class CreateZStringNode extends ProAstNode {

    private final String value;

    public CreateZStringNode(@NotNull FileLocation fileLocation, String value) {
        super(fileLocation);
        this.value = value;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZString(this.value);
    }
}
