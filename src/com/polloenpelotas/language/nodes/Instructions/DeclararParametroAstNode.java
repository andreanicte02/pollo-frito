package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingNode;
import com.polloenpelotas.language.nodes.CreateZTypes.CreateZNothingParameterFunction;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZNothingParameter;
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
        ChickenUtils.declararParametro(name,var,ambit);

        return var;

    }


    @Override
    public Node createNode() {
        Node result = new Node("Declarar Parametro");
        Node aux = new Node(name);
        Node aux2 = exp.createNode();

        result.add(aux);
        result.add(new Node("="));
        result.add(aux2);
        return result;
    }
}
