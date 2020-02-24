package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZList;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CreateZListNode extends ProAstNode {
    List<AstNode> listExp;

    public CreateZListNode(@NotNull FileLocation fileLocation, List<AstNode> listExp) {
        super(fileLocation);
        this.listExp = listExp;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        List<ZProtoObject> unwrapList= new ArrayList<>();

        for (AstNode node:
             listExp) {

            unwrapList.add(ChickenUtils.unwrap(node.execute(ambit)));

        }

        return new ZList(ChickenUtils.createListData(unwrapList));
    }
}
