package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZAmbit;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CaseSwitchAstNode extends ProAstNode {

    private  ZProtoObject valSwitch;
    private  final AstNode val;
    private  final List<AstNode> instructions;



    public CaseSwitchAstNode(@NotNull FileLocation fileLocation, AstNode expresion, List<AstNode> instructions) {
        super(fileLocation);
        this.val = expresion;
        this.instructions = instructions;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        //desenvuleto si no cagadales
        ZProtoObject valSwi = ChickenUtils.unwrap(this.valSwitch);
        ZProtoObject valCase = ChickenUtils.unwrap(this.val.execute(ambit));

        //se obtienen los primeros de un vector o se deja solo el primitivo
        ZProtoObject aux1 = ChickenUtils.obtenerUnPrimitivo(valSwi);
        ZProtoObject aux2 = ChickenUtils.obtenerUnPrimitivo(valCase);

        ZProtoObject result=aux1.executeOperation("equalTo","==",aux2);

        ZProtoObject local = new ZAmbit(ambit);

        if(result instanceof ZBoolean){

            return (((ZBoolean) result).getValue())? ChickenUtils.ejecutarSentencias(instructions,local): ZNothing.getInstance();

        }


        return ZNothing.getInstance();
    }

    public void setValSwitch(ZProtoObject valSwitch) {
        this.valSwitch = valSwitch;
    }
}
