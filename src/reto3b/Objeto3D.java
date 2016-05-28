package reto3b;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by simon on 22/04/2016.
 */
public class Objeto3D {
    private List<int[]> listaAristas = new LinkedList<int[]>();
    private List<Punto3Dh> listaPuntos = new LinkedList<Punto3Dh>();

    private double xMenor;
    private double yMenor;
    private double zMenor;

    private double xMayor;
    private double yMayor;
    private double zMayor;

    public Objeto3D(List<int[]> aristas, List <Punto3Dh> puntos) {
        listaAristas = aristas;
        listaPuntos = puntos;

        xMenor = puntos.get(0).getX();
        yMenor = puntos.get(0).getY();
        zMenor = puntos.get(0).getZ();

        xMayor = puntos.get(0).getX();
        yMayor = puntos.get(0).getY();
        zMayor = puntos.get(0).getZ();

        //Determinamos los minimos puntos

        for(Punto3Dh punto : puntos) {
            if (punto.getX() < xMenor) {
                xMenor = punto.getX();
            }
            if (punto.getY() < yMenor) {
                yMenor = punto.getY();
            }
            if (punto.getZ() < zMenor) {
                zMenor = punto.getZ();
            }
        }

        //Determinamos puntos maximos

        for(Punto3Dh punto : puntos) {
            if (punto.getX() > xMayor) {
                xMayor = punto.getX();
            }
            if (punto.getY() > yMayor) {
                yMayor = punto.getY();
            }
            if (punto.getZ() > zMayor) {
                zMayor = punto.getZ();
            }
        }
    }

    public List<Punto3Dh> getPuntos() {
        return listaPuntos;
    }

    public List<int[]> getAristas() {
        return listaAristas;
    }

    public double getxMenor() {
        return xMenor;
    }

    public double getyMenor() {
        return yMenor;
    }

    public double getzMenor() {
        return zMenor;
    }

    public double getxMayor() {
        return xMayor;
    }

    public double getyMayor() {
        return yMayor;
    }

    public double getzMayor() {
        return zMayor;
    }
}
