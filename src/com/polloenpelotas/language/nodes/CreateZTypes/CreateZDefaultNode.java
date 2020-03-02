package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZDefault;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class CreateZDefaultNode  extends ProAstNode {
    public CreateZDefaultNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return ZDefault.getInstance();
    }
}