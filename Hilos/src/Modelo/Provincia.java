/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author viccr
 */
public class Provincia {

    String codElect, provincia;
    private int cantidad;

    public Provincia(String codElec, String provincia) {
        this.provincia = provincia;
        this.codElect = codElec;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodElect() {
        return codElect;
    }

    public void setCodElect(String codElect) {
        this.codElect = codElect;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
