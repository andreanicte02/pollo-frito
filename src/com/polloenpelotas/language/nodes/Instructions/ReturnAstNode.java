package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class ReturnAstNode extends ProAstNode {

    private final AstNode e;
    public ReturnAstNode(@NotNull FileLocation fileLocation, AstNode e) {
        super(fileLocation);
        this.e = e;
    }

    public ReturnAstNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
        this.e = new CreateZNothingNode(fileLocation);
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZRetorno(ChickenUtils.unwrap(e.execute(ambit)));
    }
}
