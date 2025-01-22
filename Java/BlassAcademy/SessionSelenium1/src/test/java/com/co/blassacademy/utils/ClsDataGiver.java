package com.co.blassacademy.utils;

import com.co.blassacademy.models.ClsCredencial;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClsDataGiver {
    private static Map<String, ClsCredencial> obetenerMapCredencial(){
        final var listaCredencial = ClsExcelReader.obtenerListaCredenciales();
        return listaCredencial
                .stream()
                .collect(Collectors.toMap(ClsCredencial::getName, Function.identity()));

    }
    public static ClsCredencial obetenerCredencialesValidas(){
        return obetenerMapCredencial().get("valid");
    }
    public static ClsCredencial obetenerCredencialesBloqueadas(){
        return obetenerMapCredencial().get("locked");
    }
    public static ClsCredencial obetenerCredencialesInvalidas(){
        return obetenerMapCredencial().get("invalid");
    }
}
