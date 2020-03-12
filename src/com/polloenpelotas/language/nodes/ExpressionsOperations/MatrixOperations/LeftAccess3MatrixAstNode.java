package com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class LeftAccess3MatrixAstNode extends ProAstNode {
    private  final AstNode mat;
    private  final AstNode index1;

    public LeftAccess3MatrixAstNode(@NotNull FileLocation fileLocation, AstNode mat, AstNode index1) {
        super(fileLocation);
        this.mat = mat;
        this.index1 = index1;
    }


    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        ambit.inMatrix=true;
        ZProtoObject m1 = ChickenUtils.unwrap(mat.execute(ambit));
        ZProtoObject i1 = ChickenUtils.unwrap(index1.execute(ambit));

        return m1.executeOperation("access3","matrix[,exp]",i1);
    }
}
