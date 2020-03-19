package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZAmbit;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DefaultSwitchAstNode extends ProAstNode {

    private final List<AstNode> instructions;

    public DefaultSwitchAstNode(@NotNull FileLocation fileLocation) {
        super(fileLocation);
        this.instructions = new ArrayList<>();
    }

    public DefaultSwitchAstNode(@NotNull FileLocation fileLocation, List<AstNode> instructions) {
        super(fileLocation);
        this.instructions = instructions;
    }



    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        ZAmbit local = new ZAmbit(ambit);

        return ChickenUtils.ejecutarSentencias(instructions, local);

    }

    @Override
    public Node createNode() {

        Node result = new Node("default");
        result.add(new Node("default"));
        result.add(ChickenUtils.nodeInstructions(instructions,"Instructions"));

        return result;
    }
}
