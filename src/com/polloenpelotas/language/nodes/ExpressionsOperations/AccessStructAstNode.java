package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class AccessStructAstNode extends ProAstNode {

    private  final AstNode e;
    private  final AstNode e1;
    boolean isLeft;

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public AccessStructAstNode(@NotNull FileLocation fileLocation, AstNode e, AstNode e1) {
        super(fileLocation);
        this.e = e;
        this.e1 = e1;
        isLeft = false;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {



        /*se hereda*/
        if(e instanceof AccessStructAstNode){
            ((AccessStructAstNode) e).setLeft(isLeft);
        }


        ZProtoObject r1 = ChickenUtils.unwrap(e.execute(ambit));
        ZProtoObject r2 = ChickenUtils.unwrap(e1.execute(ambit));



        /*se hereda otravez*/
        r1.setAccesListLeft(isLeft);

        return r1.executeOperation("access","exp[exp]",r2);


    }
}
