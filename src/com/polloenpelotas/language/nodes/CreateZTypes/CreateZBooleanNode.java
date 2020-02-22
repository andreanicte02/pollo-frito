package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class CreateZBooleanNode extends ProAstNode {

    private final boolean value;

    public CreateZBooleanNode(@NotNull FileLocation fileLocation, boolean value) {
        super(fileLocation);
        this.value = value;
    }


    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        return new ZBoolean(this.value);
    }
}
