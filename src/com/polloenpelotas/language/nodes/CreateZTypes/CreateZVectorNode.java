package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import com.polloenpelotas.language.types.ZVector;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CreateZVectorNode extends ProAstNode {

    private final List<AstNode> listExp;

    //Solo lo use para pruebas XD
    public CreateZVectorNode(@NotNull FileLocation fileLocation, List<AstNode> listExp) {
        super(fileLocation);
        this.listExp = listExp;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        List<ZVar> list = new ArrayList<>();

        for (AstNode exp:listExp) {
            list.add(new ZVar(ChickenUtils.unwrap(exp.execute(ambit))));
        }

        return new ZVector(list);
    }
}