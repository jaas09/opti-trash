package com.example.pagina;

import java.util.*;

public class Grafo {
    private Map<Integer, List<int[]>> grafo;
    private List<List<Integer>> caminosPosibles;
    private List<Integer> caminoEuleriano;

    public Grafo() {
        grafo = new HashMap<>();
        caminosPosibles = new ArrayList<>();
        caminoEuleriano = new ArrayList<>();
    }

    public void agregarArco(int origen, int destino, int peso) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new int[]{destino, peso});
    }

    private void encontrarCaminos(int nodoActual, List<Integer> camino) {
        camino.add(nodoActual);

        if (!grafo.containsKey(nodoActual) || grafo.get(nodoActual).isEmpty()) {
            caminosPosibles.add(new ArrayList<>(camino));
            camino.remove(camino.size() - 1);
            return;
        }

        List<int[]> adyacentes = new ArrayList<>(grafo.get(nodoActual));
        for (int[] arco : adyacentes) {
            int siguienteNodo = arco[0];
            grafo.get(nodoActual).remove(arco);
            encontrarCaminos(siguienteNodo, camino);
        }

        camino.remove(camino.size() - 1);
    }

    private void encontrarCaminoOptimo() {
        List<Integer> mejorCamino = null;
        int distanciaMinima = Integer.MAX_VALUE;

        for (List<Integer> camino : caminosPosibles) {
            int distancia = 0;
            for (int i = 0; i < camino.size() - 1; i++) {
                int nodoActual = camino.get(i);
                int siguienteNodo = camino.get(i + 1);
                for (int[] arco : grafo.get(nodoActual)) {
                    if (arco[0] == siguienteNodo) {
                        distancia += arco[1];
                        break;
                    }
                }
            }
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                mejorCamino = camino;
            }
        }

        caminoEuleriano = mejorCamino;
    }

    public List<Integer> resolverCarteroChino() {
        caminosPosibles.clear();
        caminoEuleriano.clear();
        encontrarCaminos(0, new ArrayList<>());
        encontrarCaminoOptimo();
        return caminoEuleriano;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArco(0, 1, 5);
        grafo.agregarArco(0, 2, 10);
        grafo.agregarArco(1, 2, 3);
        grafo.agregarArco(1, 3, 7);
        grafo.agregarArco(2, 1, 2);
        grafo.agregarArco(2, 3, 1);
        grafo.agregarArco(3, 0, 8);
        grafo.agregarArco(3, 1, 6);

        List<Integer> caminoEuleriano = grafo.resolverCarteroChino();
        if (caminoEuleriano.isEmpty()) {
            System.out.println("El grafo dirigido no es euleriano");
        } else {
            System.out.println("Camino Euleriano: " + caminoEuleriano);
        }
    }
}