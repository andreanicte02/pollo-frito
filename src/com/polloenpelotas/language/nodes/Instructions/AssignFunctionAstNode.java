package com.polloenpelotas.language.nodes.Instructions;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZFunction;
import com.polloenpelotas.language.types.ZNothing;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public class AssignFunctionAstNode extends ProAstNode {

    private final AstNode var;
    private final  AstNode declararFuncion;

    public AssignFunctionAstNode(@NotNull FileLocation fileLocation, AstNode var, AstNode declararFuncion) {
        super(fileLocation);
        this.var = var;
        this.declararFuncion = declararFuncion;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {


        if(!(var instanceof FindIDLeftAstNode)){
            throw new SemanticException("No se esta asignando una funcion a una variable");
        }

        String name = ((FindIDLeftAstNode) var).getName();
        ZFunction fun = (ZFunction) declararFuncion.execute(ambit);

        ChickenUtils.crearFuncion(name,fun,ambit);

        return ZNothing.getInstance();
    }
}
