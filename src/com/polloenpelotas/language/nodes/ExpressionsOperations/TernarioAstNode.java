package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZBoolean;
import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVector;
import org.jetbrains.annotations.NotNull;

public class TernarioAstNode extends ProAstNode {
    private final AstNode condicion;
    private final AstNode valV;
    private final AstNode valF;

    public TernarioAstNode(@NotNull FileLocation fileLocation, AstNode condicion, AstNode valV, AstNode valF) {
        super(fileLocation);
        this.condicion = condicion;
        this.valV = valV;
        this.valF = valF;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        //t odo desenvuelto

        ZProtoObject v = ChickenUtils.unwrap(valV.execute(ambit));
        ZProtoObject f = ChickenUtils.unwrap(valF.execute(ambit));

        //--- el resultado de la condcion o es un valor puntual
        //---el resultado de la o es un vector


        return ChickenUtils.valueCond("ternario",condicion,ambit)?v:f;

    }

    @Override
    public Node createNode() {

        Node result = new Node("Ternario");
        Node aux1=condicion.createNode();
        Node aux2 = valV.createNode();
        Node aux3 = valF.createNode();

        result.add(aux1);
        result.add(new Node(":"));
        result.add(aux2);
        result.add(new Node("?"));
        result.add(aux3);

        return result;

    }
}
