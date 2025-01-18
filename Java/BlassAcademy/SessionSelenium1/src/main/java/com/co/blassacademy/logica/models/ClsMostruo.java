package com.co.blassacademy.logica.models;


import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("monstruos")

public class ClsMostruo {
    @ExcelCellName("NOMBRE")
    private String name;
    @ExcelCellName("EDAD")
    private  int age;
    @ExcelCellName("PESO")
    private double weight;
    @ExcelCellName("GENERO")
    private String gender;
    @ExcelCellName("TIPO")
    private String type;
    @ExcelCellName("NIVEL")
    private int level;

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        final var multiline = """
                {
                    name = %s
                    age = %d
                    weight= %.2f
                    gender= %s
                    type= %s
                    level= %d
                }
                """;
        return String.format(multiline, name, age, weight, gender, type, level);
    }
}
