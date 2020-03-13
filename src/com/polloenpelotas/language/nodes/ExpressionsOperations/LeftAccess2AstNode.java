package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.BinaryOperationNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDAstNode;
import com.polloenpelotas.language.nodes.Instructions.FindIDLeftAstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class LeftAccess2AstNode extends BinaryOperationNode {

    public LeftAccess2AstNode(FileLocation fl, AstNode e1, AstNode e2) {
        super(fl, "access2Left", " exp[[exp]] left", e1 instanceof FindIDLeftAstNode ? new FindIDAstNode(fl,((FindIDLeftAstNode) e1).getName()):e1, true, e2);
    }

}
