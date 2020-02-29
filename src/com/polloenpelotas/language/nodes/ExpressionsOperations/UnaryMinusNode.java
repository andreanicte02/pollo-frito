package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZInteger;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class UnaryMinusNode extends ProAstNode {

    private  final AstNode e;

    public UnaryMinusNode(@NotNull FileLocation fileLocation, AstNode e) {
        super(fileLocation);
        this.e = e;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        ZProtoObject r1 = ChickenUtils.unwrap(this.e.execute(ambit));
        return r1.executeOperation("unaryMinus", "(-) unary", ZNothing.getInstance());
    }
}
