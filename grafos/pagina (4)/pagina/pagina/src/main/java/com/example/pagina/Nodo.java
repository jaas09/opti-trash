package com.example.pagina;

public class Nodo {
    private String nombre;
    private double latitud;
    private double longitud;

    public Nodo(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() { return nombre; }
    public double getLatitud() { return latitud; }
    public double getLongitud() { return longitud; }

    @Override
    public String toString() {
        return "Nodo{" + "nombre='" + nombre + '\'' + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return nombre.equals(nodo.nombre);
    }

    @Override
    public int hashCode() { return nombre.hashCode(); }
}