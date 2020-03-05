package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.TransferTypes.ZBreak;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.TransferTypes.ZRetorno;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SwitchAstNode extends ProAstNode {
    private final AstNode expresion;
    private final List<CaseSwitchAstNode> cases;
    private final AstNode defaul;

    public SwitchAstNode(@NotNull FileLocation fileLocation, AstNode expresion, List<CaseSwitchAstNode> cases, AstNode defaul) {

        super(fileLocation);
        this.expresion = expresion;
        this.cases = cases;
        this.defaul = defaul;

    }

    public SwitchAstNode(@NotNull FileLocation fileLocation, AstNode expresion, List<CaseSwitchAstNode> cases) {

        super(fileLocation);
        this.expresion = expresion;
        this.cases = cases;
        this.defaul = new DefaultSwitchAstNode(fileLocation);

    }

    public SwitchAstNode(@NotNull FileLocation fileLocation, AstNode expresion, AstNode defaul) {

        super(fileLocation);
        this.expresion = expresion;
        this.cases = new ArrayList<>();
        this.defaul = defaul;

    }



    public SwitchAstNode(@NotNull FileLocation fileLocation, AstNode expresion) {

        super(fileLocation);
        this.expresion = expresion;
        this.cases = new ArrayList<>();
        this.defaul = new DefaultSwitchAstNode(fileLocation);

    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        //todoo desembuelto

        ZProtoObject val = ChickenUtils.unwrap(expresion.execute(ambit));

        for (CaseSwitchAstNode node:
             cases) {

            node.setValSwitch(val);
            ZProtoObject result = node.execute(ambit);

            if(result instanceof ZRetorno){
                return result;
            }

            if(result instanceof ZBreak){
                return ZNothing.getInstance();
            }
            
        }


        return valDefault(ambit);
    }

    public ZProtoObject valDefault(ZProtoObject ambit) throws LocatedSemanticException {

        ZProtoObject result = defaul.execute(ambit);

        if(result instanceof ZRetorno){
            return  result;
        }

        return ZNothing.getInstance();
    }
}
