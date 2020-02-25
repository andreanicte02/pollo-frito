package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class FindIDLeftAstNode extends ProAstNode {

    private final String name;

    public FindIDLeftAstNode(@NotNull FileLocation fileLocation, @NotNull String name) {
        super(fileLocation);
        this.name = name;
    }


    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        return ChickenUtils.getVarLeft(ambit,name);

    }
}
