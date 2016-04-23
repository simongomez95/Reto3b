package reto3b;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by simon on 22/04/2016.
 */
public class Objeto3D {
    private List<int[]> listaAristas = new LinkedList<int[]>();
    private List<Punto3Dh> listaPuntos = new LinkedList<Punto3Dh>();

    public Objeto3D(List<int[]> aristas, List <Punto3Dh> puntos) {
        listaAristas = aristas;
        listaPuntos = puntos;
    }

    public List<Punto3Dh> getPuntos() {
        return listaPuntos;
    }

    public List<int[]> getAristas() {
        return listaAristas;
    }
}
