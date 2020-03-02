package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FunctionCAstNode extends ProAstNode {

    private  final List<AstNode> listExp;

    public FunctionCAstNode(@NotNull FileLocation fileLocation, List<AstNode> listExp) {
        super(fileLocation);
        this.listExp = listExp;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        List<ZProtoObject> unwrapList =  ChickenUtils.unwrapListExp(listExp,ambit);

        return ChickenUtils.createStructC(unwrapList);



    }
}
