package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.Access2ListAstNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.AccessStructAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import com.polloenpelotas.language.types.ZVector;
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


        ZProtoObject r2 = ChickenUtils.unwrap(e2.execute(ambit));
        ZProtoObject r1 = e.execute(ambit);


        //assginacion de tipo 2 en listas
        if(r1 instanceof ZVar && !(e instanceof FindIDLeftAstNode)){

            r1.executeOperation("assign2","  id[[exp]] = exp", r2);
            return ZNothing.getInstance();

        }

        r1.executeOperation("assign"," id[exp] || id[[exp]] [exp] || id -> asignacion", r2);


        return ZNothing.getInstance();
    }
}
