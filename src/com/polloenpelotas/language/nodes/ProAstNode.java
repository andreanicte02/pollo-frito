package com.polloenpelotas.language.nodes;

import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public abstract class ProAstNode implements AstNode {

    public final @NotNull FileLocation fileLocation;

    public ProAstNode(@NotNull FileLocation fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public final ZProtoObject execute(@NotNull ZProtoObject ambit) throws LocatedSemanticException {
        try {
            return safeExecute(ambit);
        } catch (SemanticException  semanticException) {
            System.out.println("Error:" + semanticException+" [fila: " + fileLocation.getY()+", columna: "+ fileLocation.getX()+"]");
            throw new LocatedSemanticException(this.fileLocation, semanticException);
        }
    }

    @NotNull
    public abstract ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException;
}
