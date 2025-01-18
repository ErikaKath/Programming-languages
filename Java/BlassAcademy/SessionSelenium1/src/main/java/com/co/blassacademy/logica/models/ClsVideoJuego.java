package com.co.blassacademy.logica.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("videojuegos")

public class ClsVideoJuego {

    @ExcelCellName("NOMBRE")
    private String name;
    @ExcelCellName("EPOCA")
    private int age;
    @ExcelCellName("PRECIO")
    private double price;
    @ExcelCellName("DURACION")
    private int duration;
    @ExcelCellName("GENERO")
    private String gender;
    @ExcelCellName("EMPRESA")
    private String company;

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final var multiline = """
                {
                    name = %s
                    age= %d
                    price= %.2f
                    duration= %d
                    gender= %s
                    company= %s
                    
                }
                """;
        return String.format(multiline, name, age, price, duration, gender, company);
    }


}
