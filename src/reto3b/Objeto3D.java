package reto3b;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by simon on 22/04/2016.
 */
public class Objeto3D {
    private List<int[]> listaAristas = new LinkedList<int[]>();
    private List<Punto3Dh> listaPuntos = new LinkedList<Punto3Dh>();

    private double zMenor;

    public Objeto3D(List<int[]> aristas, List <Punto3Dh> puntos) {
        listaAristas = aristas;
        listaPuntos = puntos;

        //Determinamos el Z menor del Objeto
        zMenor = puntos.get(0).getZ();
        for(Punto3Dh punto : puntos) {
            if (punto.getZ() < zMenor) {
                zMenor = punto.getZ();
            }
        }
    }

    public List<Punto3Dh> getPuntos() {
        return listaPuntos;
    }

    public List<int[]> getAristas() {
        return listaAristas;
    }

    public double getzMenor() {
        return zMenor;
    }
}
