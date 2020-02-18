package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class UnaryMinusNode extends UnaryOperationNode {



    public UnaryMinusNode(@NotNull FileLocation fileLocation, AstNode e) {
        super(fileLocation,"unaryMinus","(unary) - ",e);

    }


}
