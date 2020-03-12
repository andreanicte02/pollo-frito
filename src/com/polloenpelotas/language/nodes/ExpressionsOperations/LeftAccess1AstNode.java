package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVector;
import org.jetbrains.annotations.NotNull;

import java.beans.Expression;

public class LeftAccess1AstNode extends ProAstNode {
    private final AstNode e;
    private final AstNode e1;

    public LeftAccess1AstNode(@NotNull FileLocation fileLocation, AstNode e, AstNode e1) {
        super(fileLocation);
        this.e = e instanceof FindIDLeftAstNode? new FindIDAstNode(fileLocation,((FindIDLeftAstNode) e).getName()):e;
        this.e1 = e1;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZProtoObject r1 = ChickenUtils.unwrap(e.execute(ambit));
        ZProtoObject r2 = ChickenUtils.unwrap(e1.execute(ambit));


        return r1.executeOperation("access1Left"," exp[exp] left ",r2);
    }

    /**
     if(!ChickenUtils.state) {
     return r1.executeOperation("access1Left", " exp[exp] left ", r2);
     }

     if(r1 instanceof ZVector){
     ChickenUtils.changeVector(((ZVector) r1).getList());
     return ZNothing.getInstance();
     }

     if(r1 instanceof ZNothing || r2 instanceof ZNothing){
     return ZNothing.getInstance();
     }**/

}
