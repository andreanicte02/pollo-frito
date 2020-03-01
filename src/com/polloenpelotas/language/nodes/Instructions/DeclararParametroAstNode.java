package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import org.jetbrains.annotations.NotNull;

public class DeclararParametroAstNode extends ProAstNode {
    private final String name;
    private final AstNode exp;

    public DeclararParametroAstNode(@NotNull FileLocation fileLocation, String name, AstNode exp) {
        super(fileLocation);
        this.name = name;
        this.exp = exp;
    }

    public DeclararParametroAstNode(@NotNull FileLocation fileLocation, String name) {
        super(fileLocation);
        this.name = name;
        this.exp = new CreateZNothingNode(fileLocation);
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZProtoObject r1 = exp.execute(ambit);
        ZVar var = new ZVar(ZNothing.getInstance());
        var.executeOperation("assign","=",r1);
        ChickenUtils.declararParametro(name,r1,ambit);

        return ZNothing.getInstance();

    }
}