package com.example.pagina;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Lista<T> implements Iterable<T> {
    private Nodo<T> cabeza;
    private int tam;

    class Nodo<T> {
        T item;
        Nodo<T> enlace;
    }

    public Lista() {
        cabeza = null;
        tam = 0;
    }

    public int getTam()
    {
        return tam;
    }

    public boolean esta_vacio() {
        return cabeza == null;
    }

    public void insertar(T item) {
        cabeza = insertar(cabeza, item);
    }

    private Nodo<T> insertar(Nodo<T> x, T item) {
        if (x == null) {
            x = new Nodo<>();
            x.item = item;
            x.enlace = null;
            tam++;
            return x;
        }

        x.enlace = insertar(x.enlace, item);
        return x;
    }

    public T get(int pos) {
        if (pos > getTam() - 1) {
            throw new NoSuchElementException("Fuera de rango");
        }
        for (int i = 0; i < pos; i++) {
            cabeza = cabeza.enlace;
        }
        return cabeza.item;
    }

    public boolean pertenece(T itemBuscado) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.item.equals(itemBuscado)) {
                return true;
            }
            actual = actual.enlace;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Lista_Iterador(cabeza);
    }

    private class Lista_Iterador implements Iterator<T> {
        private Nodo<T> actual;

        public Lista_Iterador(Nodo<T> a) {
            actual = a;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Lista vacía");
            }
            T i = actual.item;
            actual = actual.enlace;
            return i;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.item.toString());
            if (actual.enlace != null) {
                sb.append(", ");
            }
            actual = actual.enlace;
        }
        sb.append("]");
        return sb.toString();
    }
}