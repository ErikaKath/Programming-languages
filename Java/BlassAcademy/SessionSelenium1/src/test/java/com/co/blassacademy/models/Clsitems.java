package com.co.blassacademy.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("items")
public class Clsitems {
    @ExcelCellName("NOMBRE")
    private String name;
    @ExcelCellName("PRECIO")
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
