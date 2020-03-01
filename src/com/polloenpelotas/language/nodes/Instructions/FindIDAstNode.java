package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class FindIDAstNode extends ProAstNode {

    public String getName() {
        return name;
    }

    private final String name;




    public FindIDAstNode(@NotNull FileLocation fileLocation, String name) {
        super(fileLocation);
        this.name = name;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {



        return ChickenUtils.getVarRight(ambit, name);


    }




}
