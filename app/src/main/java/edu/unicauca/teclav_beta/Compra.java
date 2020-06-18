package edu.unicauca.teclav_beta;

import java.util.Date;

public class Compra {
    private Date cFecha;
   private String cTitulo;
   private double cPrecio;
   private String cImagen;
   private String cReferenciaCompra;

    public Compra(Date cFecha, String cTitulo, double cPrecio, String cImagen, String cReferenciaCompra) {
        this.cFecha = cFecha;
        this.cTitulo = cTitulo;
        this.cPrecio = cPrecio;
        this.cImagen = cImagen;
        this.cReferenciaCompra = cReferenciaCompra;
    }

    public Date getcFecha() {
        return cFecha;
    }

    public String getcTitulo() {
        return cTitulo;
    }

    public double getcPrecio() {
        return cPrecio;
    }

    public String getcImagen() {
        return cImagen;
    }

    public String getcReferenciaCompra() {
        return cReferenciaCompra;
    }
}
