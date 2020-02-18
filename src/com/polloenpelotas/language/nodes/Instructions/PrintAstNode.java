package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class PrintAstNode extends ProAstNode {
    private  final AstNode e;

    public PrintAstNode(@NotNull FileLocation fileLocation, AstNode e) {
        super(fileLocation);
        this.e = e;
    }


    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZProtoObject e = this.e.execute(ambit);
        System.out.println(e.toChickenString());

        return null;
    }
}
