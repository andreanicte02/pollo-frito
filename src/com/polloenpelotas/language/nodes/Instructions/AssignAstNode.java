package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.*;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.*;
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

        if(ambit.inMatrix || r1.inMatrix){

            ambit.inMatrix = false;
            return assignAccessMatrix(r1,r2, ambit);

        }

        //assginacion de tipo 2 en listas o el 1 ya me hice bolas :(
        if(r1 instanceof ZVar && !(e instanceof FindIDLeftAstNode)){

            r1.executeOperation("assign2","  id[[exp]] = exp", r2);

            return posibleVector(ambit);

        }


        r1.executeOperation("assign"," id[exp] | id[[exp]] [exp] | id -> left", r2);

        return posibleVector(ambit);
    }


     ZNothing assignAccessMatrix(ZProtoObject r1, ZProtoObject r2, ZProtoObject ambit) throws SemanticException, LocatedSemanticException {

        if(ChickenUtils.isPrimitive(r2)){

            r2 = new ZVector(new ZVar(r2));

        }

        r1.executeOperation("assignMatrix","Matrix Assign",r2);

        ZProtoObject aux = MatrixUtils.findMatrix(e, ambit);

        if(aux instanceof ZMatriz){

            MatrixUtils.findTypeMatrix((ZMatriz) aux);
        }

        return  ZNothing.getInstance();
     }

     ZNothing posibleVector(ZProtoObject ambit) throws SemanticException, LocatedSemanticException {

        ZProtoObject aux = VectorUtils.findVector(e,ambit);

        if(aux instanceof ZVector){
            VectorUtils.changeVector(((ZVector) aux).getList());
        }


        return ZNothing.getInstance();
     }




}
