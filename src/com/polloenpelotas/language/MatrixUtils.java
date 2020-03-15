package com.polloenpelotas.language;

import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations.LeftAccess1MatrixAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.types.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public final class MatrixUtils {

    @NotNull
    public static ZMatriz leftMatrixOperation(@NotNull ZMatriz m1, ZProtoObject right, String name, String simbol) throws SemanticException {
        //right ya esta desembuelto XD
        //lo que se saca de la matriz hay que desembolberlo
        ZMatriz niu = new ZMatriz(new ZInteger(m1.getRow()), new ZInteger(m1.getCol()));

        for (int i= 0; i<m1.getRow(); i++){

            for (int j=0; j<m1.getCol(); j++){

                ZProtoObject aM1 = ChickenUtils.unwrap(m1.mat[i][j]);
                ZProtoObject other = aM1.executeOperation(name,simbol, right);
                niu.mat[i][j]=new ZVar(other);

            }
        }
        return niu;

    }

    @NotNull
    public static ZMatriz matrixMatrixOperation(@NotNull ZMatriz m1, @NotNull ZMatriz m2, String name, String simbol) throws SemanticException {

        if(m1.getRow()!= m2.getRow()){
            throw new SemanticException("las dimensiones de las matrices a operar no hacen match");
        }
        if(m2.getCol() != m2.getCol()){
            throw new SemanticException("las dimensiones de las matrices a operar no hacen match");
        }

        ZMatriz niu = new ZMatriz(new ZInteger(m1.getRow()),new ZInteger(m1.getCol()));

        for (int i= 0; i<m1.getRow(); i++){

            for (int j=0; j<m1.getCol(); j++){

                ZProtoObject aM1 = ChickenUtils.unwrap(m1.mat[i][j]);
                ZProtoObject aM2 = ChickenUtils.unwrap(m2.mat[i][j]);
                ZProtoObject other = aM1.executeOperation(name,simbol,aM2);
                niu.mat[i][j]=new ZVar(other);

            }
        }

        return niu;
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




