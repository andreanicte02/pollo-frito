package com.polloenpelotas.language.nodes.ExpressionsOperations;

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
        ZProtoObject con = ChickenUtils.unwrap(condicion.execute(ambit));
        ZProtoObject v = ChickenUtils.unwrap(valV.execute(ambit));
        ZProtoObject f = ChickenUtils.unwrap(valF.execute(ambit));

        //--- el resultado de la condcion o es un valor puntual
        //---el resultado de la o es un vector
        ZProtoObject finalCon = con.executeOperation("valueCondition", "tern");
        if(!(finalCon instanceof ZBoolean)){

            throw new SemanticException("no se puede evaluar el operador ?:");
        }

        return ((ZBoolean) finalCon).getValue() ?v:f;

    }
}