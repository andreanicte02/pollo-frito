package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class AssignAstNode extends ProAstNode {

    private final AstNode e;
    private final AstNode e2;

    public AssignAstNode(@NotNull FileLocation fileLocation, AstNode e, AstNode e2) {
        super(fileLocation);
        this.e = e;
        this.e2 = e2;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {



        if(e instanceof FindIDAstNode){
            ((FindIDAstNode) e).setLeft(true);
        }

        ZProtoObject r2 = ChickenUtils.unwrap(e2.execute(ambit));
        ZProtoObject r1 = e.execute(ambit);

        r1.executeOperation("assign","=",r2);






        return null;
    }
}
