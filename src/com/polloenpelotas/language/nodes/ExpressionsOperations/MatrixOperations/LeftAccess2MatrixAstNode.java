package com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class LeftAccess2MatrixAstNode extends BinaryOperationNode {


    public LeftAccess2MatrixAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl,"access2","matrix[exp,]",e1 instanceof FindIDLeftAstNode ? new FindIDAstNode(fl,((FindIDLeftAstNode) e1).getName()):e1,true, e2);
    }


    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        ambit.inMatrix=true;
        ZProtoObject m1 = ChickenUtils.unwrap(this.e1.execute(ambit));
        ZProtoObject i1 = ChickenUtils.unwrap(this.e2.execute(ambit));

        return m1.executeOperation("access2","matrix[exp,]",i1);

    }
}
