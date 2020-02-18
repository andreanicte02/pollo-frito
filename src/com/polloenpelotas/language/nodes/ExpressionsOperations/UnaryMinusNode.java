package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.UnaryOperationNode;
import org.jetbrains.annotations.NotNull;

public class UnaryMinusNode extends UnaryOperationNode {



    public UnaryMinusNode(@NotNull FileLocation fileLocation, AstNode e) {
        super(fileLocation,"unaryMinus","(unary) - ",e);

    }


}
