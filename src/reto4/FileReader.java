package reto4;

import reto3b.Objeto3D;
import reto3b.Punto3Dh;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nekothecat on 2/22/16.
 */
public class FileReader {

    private static String fileName = "AABB.txt";
    private String line = null;

    private File file;

    private FileInputStream fis;

    private BufferedReader br;

    private List<int[]> listaAristas = new LinkedList<int[]>();
    private List<Punto3Dh> listaPuntos = new LinkedList<Punto3Dh>();

    public FileReader () {

        try {
            fis = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //leerObjeto(); Esto es de cuando leerObjeto era un void


    }

    public Objeto3D[] leerObjetos() throws IOException {

        int numeroPuntos = 0;
        int numeroAristas = 0;
        int numeroObjetos = 0;


        String[] aristaStr = null;
        String[] punto = null;

        numeroObjetos= Integer.parseInt(br.readLine());
        Objeto3D[] objetos= new Objeto3D[numeroObjetos];


        for (int k = 0; k < numeroObjetos; k++) {


            listaAristas = new LinkedList<int[]>();
            listaPuntos = new LinkedList<Punto3Dh>();
            try {
                numeroPuntos = Integer.parseInt(br.readLine());
                for (int i = 0; i < numeroPuntos; i++) {
                    punto = br.readLine().split(" ");
                    listaPuntos.add(new Punto3Dh(Double.parseDouble(punto[0]), Double.parseDouble(punto[1]), Double.parseDouble(punto[2])));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                numeroAristas = Integer.parseInt(br.readLine());

                for (int j = 0; j < numeroAristas; j++) {

                    aristaStr = br.readLine().split(" ");
                    int[] arista = new int[2];
                    arista[0] = Integer.parseInt(aristaStr[0]);
                    arista[1] = Integer.parseInt(aristaStr[1]);
                    listaAristas.add(arista);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            objetos[k] = new Objeto3D(listaAristas, listaPuntos);

        }

        return objetos;


    }

    /*public List<Punto3Dh> getPuntos() {
        return listaPuntos;
    }

    public List<int[]> getAristas() {
        return listaAristas;
    }*/

}
