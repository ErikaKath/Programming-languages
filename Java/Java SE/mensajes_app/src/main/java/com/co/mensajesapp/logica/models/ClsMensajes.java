package com.co.mensajesapp.logica.models;

public class ClsMensajes {
    int ID_MENSAJE;
    String MENSAJE;
    String AUTOR_MENSAJE;
    String FECHA_MENSAJE;

    public ClsMensajes() {
    }

    public ClsMensajes(String MENSAJE, String AUTOR_MENSAJE, String FECHA_MENSAJE) {

        this.MENSAJE = MENSAJE;
        this.AUTOR_MENSAJE = AUTOR_MENSAJE;
        this.FECHA_MENSAJE = FECHA_MENSAJE;
    }

    public int getID_MENSAJE() {
        return ID_MENSAJE;
    }

    public void setID_MENSAJE(int ID_MENSAJE) {
        this.ID_MENSAJE = ID_MENSAJE;
    }

    public String getMENSAJE() {
        return MENSAJE;
    }

    public void setMENSAJE(String MENSAJE) {
        this.MENSAJE = MENSAJE;
    }

    public String getAUTOR_MENSAJE() {
        return AUTOR_MENSAJE;
    }

    public void setAUTOR_MENSAJE(String AUTOR_MENSAJE) {
        this.AUTOR_MENSAJE = AUTOR_MENSAJE;
    }

    public String getFECHA_MENSAJE() {
        return FECHA_MENSAJE;
    }

    public void setFECHA_MENSAJE(String FECHA_MENSAJE) {
        this.FECHA_MENSAJE = FECHA_MENSAJE;
    }
}
