// Clase Grafo
package com.example.pagina;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grafo {
    private List<Arco> arcos;

    public Grafo() {
        arcos = new ArrayList<>();
    }

    public void agregarArco(Arco arco) {
        arcos.add(arco);
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public void resolverCarteroChino() {
        if (arcos.isEmpty()) {
            System.out.println("El grafo está vacío");
            return;
        }

        // Creamos una copia de la lista de arcos
        List<Arco> arcosCopia = new ArrayList<>(arcos);

        // Inicializamos la ruta con el primer nodo del grafo
        Nodo nodoInicial = arcos.get(0).getOrigen();
        List<Nodo> ruta = new ArrayList<>();
        ruta.add(nodoInicial);

        // Recorremos la lista de arcos y agregamos los nodos a la ruta
        while (!arcosCopia.isEmpty()) {
            Arco arcoMasCercano = encontrarArcoMasCercano(ruta.get(ruta.size() - 1), arcosCopia);
            ruta.add(arcoMasCercano.getDestino());
            arcosCopia.remove(arcoMasCercano);
        }

        // Agregamos el nodo de origen al final de la ruta
        ruta.add(nodoInicial);

        System.out.println("Ruta óptima: " + ruta.toString());
    }

    private Arco encontrarArcoMasCercano(Nodo nodo, List<Arco> arcos) {
        Arco arcoMasCercano = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (Arco arco : arcos) {
            if (arco.getOrigen().equals(nodo)) {
                double distancia = calcularDistancia(nodo, arco.getDestino());
                if (distancia < distanciaMinima) {
                    distanciaMinima = distancia;
                    arcoMasCercano = arco;
                }
            }
        }

        return arcoMasCercano;
    }

    private double calcularDistancia(Nodo nodo1, Nodo nodo2) {
        // Fórmula de Haversine para calcular la distancia entre dos puntos en la superficie terrestre
        double lat1 = Math.toRadians(nodo1.getLatitud());
        double lon1 = Math.toRadians(nodo1.getLongitud());
        double lat2 = Math.toRadians(nodo2.getLatitud());
        double lon2 = Math.toRadians(nodo2.getLongitud());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double radioTierra = 6371; // en kilómetros
        double distancia = radioTierra * c;

        return distancia;
    }

    public void imprimirGrafo() {
        System.out.println("Grafo:");
        for (Arco arco : arcos) {
            System.out.println(arco.toString());
        }
    }

    public Iterator<Arco> iterator() {
        return arcos.iterator();
    }
}