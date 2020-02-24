package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class Access2ListAstNode extends ProAstNode {
    private  final AstNode e;
    private  final AstNode e2;


    public Access2ListAstNode(@NotNull FileLocation fileLocation, AstNode e, AstNode e2) {
        super(fileLocation);
        this.e = e;
        this.e2 = e2;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
       ZProtoObject r1 = ChickenUtils.unwrap(e.execute(ambit));
       ZProtoObject r2 = ChickenUtils.unwrap(e2.execute(ambit));

       return r1.executeOperation("access2", " exp[[exp]] ", r2);
    }
}
