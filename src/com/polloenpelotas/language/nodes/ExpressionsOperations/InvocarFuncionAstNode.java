package com.polloenpelotas.language.nodes.ExpressionsOperations;

import com.polloenpelotas.language.ChickenUtils;
import com.polloenpelotas.language.FileLocation;
import com.polloenpelotas.language.LocatedSemanticException;
import com.polloenpelotas.language.SemanticException;
import com.polloenpelotas.language.nodes.AstNode;
import com.polloenpelotas.language.nodes.ProAstNode;
import com.polloenpelotas.language.types.ZFunction;
import com.polloenpelotas.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

import java.sql.Struct;
import java.util.List;

public class InvocarFuncionAstNode extends ProAstNode {
    private  String id;
    private  List<AstNode> argumentos;

    public InvocarFuncionAstNode(@NotNull FileLocation fileLocation, String id, List<AstNode> argumentos) {
        super(fileLocation);
        this.id = id;
        this.argumentos = argumentos;
    }

    @Override
    public ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {

        List<ZProtoObject> unwrapArguments = ChickenUtils.unwrapListExp(argumentos,ambit);
        ZFunction function = (ZFunction) ChickenUtils.getFuncion(id,ambit);
        return function.ejecutarFuncion(unwrapArguments);
    }
}
