package com.polloenpelotas.language;

import org.jetbrains.annotations.NotNull;

public class LocatedSemanticException extends Exception {

    private final @NotNull FileLocation fileLocation;
    private final @NotNull SemanticException semanticException;

    public LocatedSemanticException(@NotNull FileLocation fileLocation, @NotNull SemanticException semanticException){
        this.fileLocation = fileLocation;
        this.semanticException = semanticException;
    }

    public FileLocation getFileLocation() {
        return fileLocation;
    }

    public SemanticException getSemanticException() {
        return semanticException;
    }
}
