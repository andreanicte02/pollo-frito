package com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class Access1MatrixAstNode extends ProAstNode {

    private  final AstNode mat;
    private  final AstNode index1;
    private  final AstNode index2;

    public Access1MatrixAstNode(@NotNull FileLocation fileLocation, AstNode mat, AstNode index1, AstNode index2) {
        super(fileLocation);
        this.mat = mat;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZProtoObject m1 = ChickenUtils.unwrap(mat.execute(ambit));
        ZProtoObject i1 = ChickenUtils.unwrap(index1.execute(ambit));
        ZProtoObject i2 = ChickenUtils.unwrap(index2.execute(ambit));


        return m1.executeOperation("access1","Matrix[exp,exp]",i1,i2);

    }
}
