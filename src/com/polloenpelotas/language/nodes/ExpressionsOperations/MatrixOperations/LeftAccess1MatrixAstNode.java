package com.polloenpelotas.language.nodes.ExpressionsOperations.MatrixOperations;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class LeftAccess1MatrixAstNode extends ProAstNode {
    public   final AstNode mat;
    private  final AstNode index1;
    private  final AstNode index2;


    public LeftAccess1MatrixAstNode(@NotNull FileLocation fileLocation, AstNode mat, AstNode index1, AstNode index2) {
        super(fileLocation);
        this.mat = mat instanceof FindIDLeftAstNode ? new FindIDAstNode(fileLocation,((FindIDLeftAstNode) mat).getName()):mat;
        this.index1 = index1;
        this.index2 = index2;
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ambit.inMatrix=true;

        ZProtoObject m1 = ChickenUtils.unwrap(mat.execute(ambit));
        ZProtoObject i1 = ChickenUtils.unwrap(index1.execute(ambit));
        ZProtoObject i2 = ChickenUtils.unwrap(index2.execute(ambit));

        return m1.executeOperation("access1","Matrix[exp,exp]",i1,i2);

    }

    @Override
    public Node createNode() {
        Node result = new Node("LeftAcces1MatrixAstNode");
        Node aux1 = mat.createNode();
        Node aux2 = index1.createNode();
        Node aux3 = index2.createNode();

        result.add(aux1);
        result.add(new Node("["));
        result.add(aux2);
        result.add(new Node(","));
        result.add(aux3);
        result.add(new Node("]"));

        return result;
    }
}
