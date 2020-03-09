package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZContinue;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class ContinueAstNode extends ProAstNode {
    public ContinueAstNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return ZContinue.getInstance();
    }
}
