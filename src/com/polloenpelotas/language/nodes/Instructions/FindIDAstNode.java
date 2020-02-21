package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class FindIDAstNode extends ProAstNode {
    boolean isLeft;
    private final String name;




    public FindIDAstNode(@NotNull FileLocation fileLocation, String name) {
        super(fileLocation);
        this.name = name;
        this.isLeft = false;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {


        if(isLeft) {

            return ChickenUtils.getVarLeft(ambit, name);

        }

        return ChickenUtils.getVarRight(ambit, name);


    }

    public void setLeft(boolean left) {
        isLeft = left;
    }



}
