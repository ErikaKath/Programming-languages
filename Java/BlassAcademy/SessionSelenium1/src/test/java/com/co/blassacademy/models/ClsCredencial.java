package com.co.blassacademy.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("credenciales")
public class ClsCredencial {
    @ExcelCellName("NOMBRE")
    private String name;
    @ExcelCellName("USERNAME")
    private String username;
    @ExcelCellName("PASSWORD")
    private String password;
    @ExcelCellName("MENSAJE")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
