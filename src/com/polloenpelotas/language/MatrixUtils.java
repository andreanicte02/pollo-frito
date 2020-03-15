package com.polloenpelotas.language;

import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations.LeftAccess1MatrixAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.types.*;

import java.util.Arrays;

public final class MatrixUtils {

    public static ZMatriz leftMatrix(ZMatriz matriz, ZProtoObject data){

        ZMatriz niu = new ZMatriz(new ZInteger(matriz.getRow()), new ZInteger(matriz.getCol()));


        return null;

    }
    

    public static ZProtoObject findMatrix(AstNode e, ZProtoObject ambit) throws LocatedSemanticException {

        if(e instanceof FindIDAstNode || e instanceof FindIDLeftAstNode){

            return ChickenUtils.unwrap(e.execute(ambit));
        }

        if(e instanceof BinaryOperationNode){
           return findMatrix(((BinaryOperationNode) e).e1,ambit);
        }

        if(e instanceof LeftAccess1MatrixAstNode){

           return findMatrix(((LeftAccess1MatrixAstNode) e).mat,ambit);
        }


        return ZNothing.getInstance();


    }

    public static void findTypeMatrix(ZMatriz mat) throws SemanticException {

        for (int i= 0; i<mat.getRow(); i++){

            for (int j=0; j<mat.getCol(); j++){

                if(ChickenUtils.unwrap(mat.mat[i][j]) instanceof ZString){
                    castMatrix(mat,"castS","castS");
                    return;

                }

            }
        }


        for (int i= 0; i<mat.getRow(); i++){

            for (int j=0; j<mat.getCol(); j++){

                if(ChickenUtils.unwrap(mat.mat[i][j]) instanceof ZNumeric){
                    castMatrix(mat,"castN","castN");
                    return;
                }

            }
        }


        for (int i= 0; i<mat.getRow(); i++){

            for (int j=0; j<mat.getCol(); j++){

                if(ChickenUtils.unwrap(mat.mat[i][j]) instanceof ZNumeric){
                    castMatrix(mat,"castI","castI");
                    return;
                }

            }
        }

    }

    public static void castMatrix(ZMatriz mat, String name, String simbol) throws SemanticException {

        for (int i= 0; i<mat.getRow(); i++){

            for (int j=0; j<mat.getCol(); j++){


                ZProtoObject aux = ChickenUtils.unwrap(mat.mat[i][j]);
                ZProtoObject newValue = aux.executeOperation(name,simbol,ZNothing.getInstance());
                mat.mat[i][j]=new ZVar(newValue);

            }
        }

    }

}




