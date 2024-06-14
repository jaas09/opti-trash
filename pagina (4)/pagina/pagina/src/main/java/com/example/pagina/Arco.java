// Clase Arco
package com.example.pagina;

public class Arco {
    private Nodo origen;
    private Nodo destino;
    private double peso;
    private String nombreCalle;

    public Arco(Nodo origen, Nodo destino, double peso, String nombreCalle) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
        this.nombreCalle = nombreCalle;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    @Override
    public String toString() {
        return "De " + origen + " a " + destino + " por " + nombreCalle;
    }
}