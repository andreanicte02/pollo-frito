package com.polloenpelotas.language;

import com.polloenpelotas.language.types.ZProtoObject;
import com.polloenpelotas.language.types.ZVar;
import org.jetbrains.annotations.NotNull;

public final class ChickenUtils {

    public static @NotNull ZProtoObject unwrap(@NotNull ZProtoObject value){
        if (value instanceof ZVar) {
            return ((ZVar) value).getValue();
        }
        return value;
    }


    private ChickenUtils(){}
}
