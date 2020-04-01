package com.polloenpelotas.language.nodes.ExpressionsOperations.LogicalOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class OrAstNode extends BinaryOperationNode {
    public OrAstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "or", "|", e1, true, e2);
    }

    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        if(ChickenUtils.valueCond("Condicion en or",e1,ambit)){
            return new ZBoolean(true);
        }

        if(ChickenUtils.valueCond("Condicion en or",e2,ambit)){
            return new ZBoolean(true);
        }


        return new ZBoolean(false);

    }
}
