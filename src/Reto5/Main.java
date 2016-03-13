package Reto5;

import reto3b.*;
import reto4.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lope on 2/27/2016.
 */
public class Main extends JPanel implements KeyListener{

    double sX = 1;
    double sY = 1;
    int dX = 0;
    int dY = 0;
    int r = 0;
    int xO = 50;
    int yO = 30;

    private int d= 50;
    private double[][] projectMatrix = new ProjectionTransformer().apply(d);

    FileReader fileReader = new FileReader();

    List<Punto3Dh> puntosF = fileReader.getPuntos();
    List<int[]> aristasF = fileReader.getAristas();

    List<Punto3Dh> puntos = new LinkedList<>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.green);
        dibujarObjeto(g);

    }



    /*public void transformar(){
        for(int i = 0; i < puntosF.size();i++){

            Punto2Dh p1 = puntosF.get(i);

            Matriz2D origen1 = new Matriz2D();
            Matriz2D origen2 = new Matriz2D();
            Matriz2D rotacion = new Matriz2D();
            Matriz2D escala = new Matriz2D();
            Matriz2D traslacion = new Matriz2D();

            origen1.setMatriz(0,0,1);
            origen1.setMatriz(0,1,0);
            origen1.setMatriz(0,2,-xO);
            origen1.setMatriz(1,0,0);
            origen1.setMatriz(1,1,1);
            origen1.setMatriz(1,2,-yO);
            origen1.setMatriz(2,0,0);
            origen1.setMatriz(2,1,0);
            origen1.setMatriz(2,2,1);

            origen2.setMatriz(0,0,1);
            origen2.setMatriz(0,1,0);
            origen2.setMatriz(0,2,xO);
            origen2.setMatriz(1,0,0);
            origen2.setMatriz(1,1,1);
            origen2.setMatriz(1,2,yO);
            origen2.setMatriz(2,0,0);
            origen2.setMatriz(2,1,0);
            origen2.setMatriz(2,2,1);

            double angRad = Math.toRadians(r);
            double cos = Math.cos(angRad);
            double sin = Math.sin(angRad);

            rotacion.setMatriz(0,0,cos);
            rotacion.setMatriz(0,1,sin);
            rotacion.setMatriz(0,2,0);
            rotacion.setMatriz(1,0,-sin);
            rotacion.setMatriz(1,1,cos);
            rotacion.setMatriz(1,2,0);
            rotacion.setMatriz(2,0,0);
            rotacion.setMatriz(2,1,0);
            rotacion.setMatriz(2,2,1);

            escala.setMatriz(0,0,sX);
            escala.setMatriz(0,1,0);
            escala.setMatriz(0,2,0);
            escala.setMatriz(1,0,0);
            escala.setMatriz(1,1,sY);
            escala.setMatriz(1,2,0);
            escala.setMatriz(2,0,0);
            escala.setMatriz(2,1,0);
            escala.setMatriz(2,2,1);

            traslacion.setMatriz(0,0,1);
            traslacion.setMatriz(0,1,0);
            traslacion.setMatriz(0,2,dX);
            traslacion.setMatriz(1,0,0);
            traslacion.setMatriz(1,1,1);
            traslacion.setMatriz(1,2,dY);
            traslacion.setMatriz(2,0,0);
            traslacion.setMatriz(2,1,0);
            traslacion.setMatriz(2,2,1);

            p1 = p1.transf(origen1,p1);
            p1 = p1.transf(rotacion,p1);
            p1 = p1.transf(escala,p1);
            p1 = p1.transf(traslacion,p1);
            p1 = p1.transf(origen2,p1);

            puntos.add(i,p1);
        }
    }
    */

    public void dibujarObjeto(Graphics g){
        int x0;
        int y0;
        int x1;
        int y1;

        //transformar();

        // THIS IS UTTER SHIT (for the moment) AND SHOULD NOT BE TAKEN SERIOUSLY
        for (int[] arista : aristasF) {


            // referencia Point point1 = new Point(Util.multiply(projectMatrix, points[i].toMatrix()));
            Point point1 = new Point(new Matriz3D().mult(matrizproyecto, puntosF.get(arista[0]))); //matrizproyecto es ProjectMatrix convertido a Matriz3D
            Point point2 = new Point(new Matriz3D().mult(matrizproyecto, puntosF.get(arista[1])));
            g.drawLine(point1, point2, g);


        }

    }

    public void keyReleased(KeyEvent ke) {
        repaint();
    }

    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("key pressed W");
            dY -= 5;
        }

        if(ke.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("key pressed A");
            dX -= 5;
        }

        if(ke.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("key pressed S");
            dY += 5;
        }

        if(ke.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("key pressed D");
            dX += 5;
        }

        if(ke.getKeyCode() == KeyEvent.VK_Q) {
            System.out.println("key pressed Q");
            r += 5;
            if(r == 360){ r = 0;}
            System.out.println("r = " + r);
        }

        if(ke.getKeyCode() == KeyEvent.VK_E) {
            System.out.println("key pressed E");
            if(r == 0){ r = 360;}
            r -= 5;
            System.out.println("r = " + r);
        }

        if(ke.getKeyCode() == KeyEvent.VK_MINUS || ke.getKeyCode() == KeyEvent.VK_SUBTRACT) {
            System.out.println("key pressed -");
            if(sX >= 0.2){
                sX -= 0.2;
                sY -= 0.2;
            }else{
                System.out.println("Escala Minima Alcanzada");
            }
        }

        if(ke.getKeyCode() == KeyEvent.VK_PLUS || ke.getKeyCode() == KeyEvent.VK_ADD) {
            System.out.println("key pressed +");
            sX += 0.2;
            sY += 0.2;

        }
    }

    public void keyTyped(KeyEvent ke) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("3DObj");
//      Lines frame = new Lines();
//      frame.addKeyListener(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main main = new Main();
        frame.add(main);
        frame.addKeyListener(main);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
