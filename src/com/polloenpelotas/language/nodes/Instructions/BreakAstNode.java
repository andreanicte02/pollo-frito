package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZBreak;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class BreakAstNode  extends ProAstNode {
    public BreakAstNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return  ZBreak.getInstance();
    }
}
