package com.polloenpelotas.language.nodes.CreateZTypes;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZNothingParameter;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class CreateZNothingParameterFunction extends ProAstNode {

    public CreateZNothingParameterFunction(@NotNull FileLocation fileLocation) {
        super(fileLocation);
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return ZNothingParameter.getInstance();
    }

    @Override
    public @NotNull Node createNode() {
        return new Node(null+"");
    }
}
