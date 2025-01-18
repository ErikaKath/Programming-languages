package com.co.blassacademy.logica.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("productos")

public class ClsProducto {
    @ExcelCellName("NOMBRE")
    private String name;
    @ExcelCellName("PRECIO")
    private double price;
    @ExcelCellName("STOCK")
    private int stock;
    @ExcelCellName("PESO")
    private double weight;
    @ExcelCellName("PERECIBLE")
    private boolean perecible;
    @ExcelCellName("VOLUMEN")
    private  double volume;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPerecible() {
        return perecible;
    }

    public void setPerecible(boolean perecible) {
        this.perecible = perecible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double obtenerTotal(){
        return price * stock;
    }

    @Override
    public String toString() {
        final var multiline = """
                {
                    name = %s
                    price= %.2f
                    stock= %d
                    weight= %.2f
                    perecible= %s
                    volume= %.2f
                }
                """;
        return String.format(multiline, name, price,  stock, weight, perecible, volume);
    }


}
