package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.*;
import com.polloenpelotas.language.types.TransferTypes.ZBreak;
import com.polloenpelotas.language.types.TransferTypes.ZContinue;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ForAstNode extends ProAstNode {

    private String id;
    private AstNode expresion;
    private List<AstNode> instructions;

    public ForAstNode( @NotNull FileLocation fileLocation, String id, AstNode expresion, List<AstNode> instructions) {
        super(fileLocation);
        this.id = id;
        this.expresion = expresion;
        this.instructions = instructions;
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZProtoObject e = ChickenUtils.obtenerUnVector(ChickenUtils.unwrap(expresion.execute(ambit)));


        ZAmbit local = new ZAmbit(ambit);
        ChickenUtils.createVariable(local,id);

        if(e instanceof ZVector){

            ZProtoObject result =  ejecutarFor(local,((ZVector) e).getList());
            ChickenUtils.estructurasFor(((ZVector) e).getList());
            return result;
        }


        if(e instanceof ZList){

            ZProtoObject result =  ejecutarFor(local, ((ZList) e).getList());
            ChickenUtils.estructurasFor(((ZVector) e).getList());
            return result;
        }

        if(e instanceof ZMatriz){

            List<ZVar> list = ChickenUtils.getListVarMatrix(((ZMatriz) e).mat,((ZMatriz) e).getRow(), ((ZMatriz) e).getCol());

            ZProtoObject result =  ejecutarFor(local, list);
            ChickenUtils.estructurasFor(list);
            return result;

        }

        if(e instanceof ZArray){
            List<ZVar> list = ChickenUtils.getListVarArray(((ZArray) e).superMatrix, ((ZArray) e).sizeList);
            ZProtoObject result = ejecutarFor(local, list);
            ChickenUtils.estructurasFor(list);
            return result;
        }


        return ZNothing.getInstance();

    }

    public ZProtoObject ejecutarFor(ZAmbit local, List<ZVar> vars) throws LocatedSemanticException {

        for (int x =0; x< vars.size();x++){

            local.members.replace(id,vars.get(x));

            ZProtoObject result = ChickenUtils.ejecutarSentencias(instructions,local);

            if(result instanceof ZBreak){
                return ZNothing.getInstance();
            }

            if(result instanceof ZContinue){
                continue;
            }

            if(result instanceof ZRetorno){
                return result;
            }

        }

        return ZNothing.getInstance();
    }

    @Override
    public @NotNull Node createNode() {
        return null;
    }
}
