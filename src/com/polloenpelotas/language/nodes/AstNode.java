package com.polloenpelotas.language.nodes;

import com.polloenpelotas.Extras.Node;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public interface AstNode {
    ZProtoObject execute(@NotNull ZProtoObject ambit) throws LocatedSemanticException;

   
}
