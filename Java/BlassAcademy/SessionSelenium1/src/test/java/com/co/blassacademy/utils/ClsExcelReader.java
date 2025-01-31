package com.co.blassacademy.utils;

import com.co.blassacademy.models.ClsCredencial;
import com.co.blassacademy.models.Clsitems;
import com.poiji.bind.Poiji;

import java.io.File;
import java.util.List;

public class ClsExcelReader {
    private static final String excelPath = "src/test/resources/data/seleniumData.xlsx";

    public static List<ClsCredencial> obtenerListaCredenciales(){
        return Poiji.fromExcel(new File(excelPath),ClsCredencial.class);
    }
    public static List<Clsitems>obtenerListaItem(){
        return Poiji.fromExcel(new File(excelPath), Clsitems.class);
    }
}
