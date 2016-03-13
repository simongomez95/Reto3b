//package reto4;
//
//import reto3b.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.*;
//import java.util.List;
//
///**
// * Created by lope on 2/27/2016.
// */
//public class Main extends JPanel implements KeyListener{
//
//    double sX = 1;
//    double sY = 1;
//    int dX = 0;
//    int dY = 0;
//    int r = 0;
//    int xO = 50;
//    int yO = 30;
//
//    FileReader fileReader = new FileReader();
//
//    List<Punto2Dh> puntosF = fileReader.getPuntos();
//    List<int[]> aristasF = fileReader.getAristas();
//
//    List<Punto2Dh> puntos = new LinkedList<>();
//
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        Graphics2D g2d = (Graphics2D) g;
//
//        dibujarObjeto(g2d);
//    }
//
//    public void transformar(){
//        for(int i = 0; i < puntosF.size();i++){
//
//            Punto2Dh p1 = puntosF.get(i);
//
//            Matriz2D origen1 = new Matriz2D();
//            Matriz2D origen2 = new Matriz2D();
//            Matriz2D rotacion = new Matriz2D();
//            Matriz2D escala = new Matriz2D();
//            Matriz2D traslacion = new Matriz2D();
//
//            origen1.setMatriz(0,0,1);
//            origen1.setMatriz(0,1,0);
//            origen1.setMatriz(0,2,-xO);
//            origen1.setMatriz(1,0,0);
//            origen1.setMatriz(1,1,1);
//            origen1.setMatriz(1,2,-yO);
//            origen1.setMatriz(2,0,0);
//            origen1.setMatriz(2,1,0);
//            origen1.setMatriz(2,2,1);
//
//            origen2.setMatriz(0,0,1);
//            origen2.setMatriz(0,1,0);
//            origen2.setMatriz(0,2,xO);
//            origen2.setMatriz(1,0,0);
//            origen2.setMatriz(1,1,1);
//            origen2.setMatriz(1,2,yO);
//            origen2.setMatriz(2,0,0);
//            origen2.setMatriz(2,1,0);
//            origen2.setMatriz(2,2,1);
//
//            double angRad = Math.toRadians(r);
//            double cos = Math.cos(angRad);
//            double sin = Math.sin(angRad);
//
//            rotacion.setMatriz(0,0,cos);
//            rotacion.setMatriz(0,1,sin);
//            rotacion.setMatriz(0,2,0);
//            rotacion.setMatriz(1,0,-sin);
//            rotacion.setMatriz(1,1,cos);
//            rotacion.setMatriz(1,2,0);
//            rotacion.setMatriz(2,0,0);
//            rotacion.setMatriz(2,1,0);
//            rotacion.setMatriz(2,2,1);
//
//            escala.setMatriz(0,0,sX);
//            escala.setMatriz(0,1,0);
//            escala.setMatriz(0,2,0);
//            escala.setMatriz(1,0,0);
//            escala.setMatriz(1,1,sY);
//            escala.setMatriz(1,2,0);
//            escala.setMatriz(2,0,0);
//            escala.setMatriz(2,1,0);
//            escala.setMatriz(2,2,1);
//
//            traslacion.setMatriz(0,0,1);
//            traslacion.setMatriz(0,1,0);
//            traslacion.setMatriz(0,2,dX);
//            traslacion.setMatriz(1,0,0);
//            traslacion.setMatriz(1,1,1);
//            traslacion.setMatriz(1,2,dY);
//            traslacion.setMatriz(2,0,0);
//            traslacion.setMatriz(2,1,0);
//            traslacion.setMatriz(2,2,1);
//
//            p1 = p1.transf(origen1,p1);
//            p1 = p1.transf(rotacion,p1);
//            p1 = p1.transf(escala,p1);
//            p1 = p1.transf(traslacion,p1);
//            p1 = p1.transf(origen2,p1);
//
//            puntos.add(i,p1);
//        }
//    }
//
//    public void dibujarObjeto(Graphics2D g2d){
//        int x0;
//        int y0;
//        int x1;
//        int y1;
//
//        transformar();
//
//        for (int[] arista : aristasF) {
//
//
//            x0 = (int) puntos.get(arista[0]).getX();
//            y0 = (int) puntos.get(arista[0]).getY();
//            x1 = (int) puntos.get(arista[1]).getX();
//            y1 = (int) puntos.get(arista[1]).getY();
//
////            Punto2Dh ini = new Punto2Dh(x0,y0);
////            Punto2Dh fin = new Punto2Dh(x1,y1);
////
////            Matriz2D origen1 = new Matriz2D();
////            Matriz2D origen2 = new Matriz2D();
////            Matriz2D rotacion = new Matriz2D();
////            Matriz2D escala = new Matriz2D();
////            Matriz2D traslacion = new Matriz2D();
////
////            origen1.setMatriz(0,0,1);
////            origen1.setMatriz(0,1,0);
////            origen1.setMatriz(0,2,-xO);
////            origen1.setMatriz(1,0,0);
////            origen1.setMatriz(1,1,1);
////            origen1.setMatriz(1,2,-yO);
////            origen1.setMatriz(2,0,0);
////            origen1.setMatriz(2,1,0);
////            origen1.setMatriz(2,2,1);
////
////            origen2.setMatriz(0,0,1);
////            origen2.setMatriz(0,1,0);
////            origen2.setMatriz(0,2,xO);
////            origen2.setMatriz(1,0,0);
////            origen2.setMatriz(1,1,1);
////            origen2.setMatriz(1,2,yO);
////            origen2.setMatriz(2,0,0);
////            origen2.setMatriz(2,1,0);
////            origen2.setMatriz(2,2,1);
////
////            double angRad = Math.toRadians(r);
////            double cos = Math.cos(angRad);
////            double sin = Math.sin(angRad);
////
////            rotacion.setMatriz(0,0,cos);
////            rotacion.setMatriz(0,1,sin);
////            rotacion.setMatriz(0,2,0);
////            rotacion.setMatriz(1,0,-sin);
////            rotacion.setMatriz(1,1,cos);
////            rotacion.setMatriz(1,2,0);
////            rotacion.setMatriz(2,0,0);
////            rotacion.setMatriz(2,1,0);
////            rotacion.setMatriz(2,2,1);
////
////            escala.setMatriz(0,0,sX);
////            escala.setMatriz(0,1,0);
////            escala.setMatriz(0,2,0);
////            escala.setMatriz(1,0,0);
////            escala.setMatriz(1,1,sY);
////            escala.setMatriz(1,2,0);
////            escala.setMatriz(2,0,0);
////            escala.setMatriz(2,1,0);
////            escala.setMatriz(2,2,1);
////
////            traslacion.setMatriz(0,0,1);
////            traslacion.setMatriz(0,1,0);
////            traslacion.setMatriz(0,2,dX);
////            traslacion.setMatriz(1,0,0);
////            traslacion.setMatriz(1,1,1);
////            traslacion.setMatriz(1,2,dY);
////            traslacion.setMatriz(2,0,0);
////            traslacion.setMatriz(2,1,0);
////            traslacion.setMatriz(2,2,1);
////
////            ini.transf(origen1,ini);
////            ini.transf(rotacion,ini);
////            ini.transf(escala,ini);
////            ini.transf(traslacion,ini);
////            ini.transf(origen2,ini);
////
////            fin.transf(origen1,fin);
////            fin.transf(rotacion,fin);
////            fin.transf(escala,fin);
////            fin.transf(traslacion,fin);
////            fin.transf(origen2,fin);
////
////            x0 = (int)(ini.getX());
////            y0 = (int)(ini.getY());
////            x1 = (int)(fin.getX());
////            y1 = (int)(fin.getY());
//
//
////            x0 -= xO;
////            y0 -= yO;
////            x1 -= xO;
////            y1 -= yO;
////
////            double angRad = Math.toRadians(r);
////            double cos = Math.cos(angRad);
////            double sin = Math.sin(angRad);
////
////            x0 = (int)(x0*cos+y0*sin);
////            y0 = (int)(x0*sin-y0*cos);
////            x1 = (int)(x1*cos+y1*sin);
////            y1 = (int)(x1*sin-y1*cos);
////
////            x0 = (int)(x0*sX);
////            y0 = (int)(y0*sX);
////            x1 = (int)(x1*sX);
////            y1 = (int)(y1*sX);
////
////            x0 += dX + xO;
////            y0 += dY + yO;
////            x1 += dX + xO;
////            y1 += dY + yO;
//
//            g2d.drawLine(x0, y0, x1, y1);
//
//        }
//
//    }
//
//    public void keyReleased(KeyEvent ke) {
//        repaint();
//    }
//
//    public void keyPressed(KeyEvent ke) {
//        if(ke.getKeyCode() == KeyEvent.VK_W) {
//            System.out.println("key pressed W");
//            dY -= 5;
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_A) {
//            System.out.println("key pressed A");
//            dX -= 5;
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_S) {
//            System.out.println("key pressed S");
//            dY += 5;
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_D) {
//            System.out.println("key pressed D");
//            dX += 5;
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_Q) {
//            System.out.println("key pressed Q");
//            r += 5;
//            if(r == 360){ r = 0;}
//            System.out.println("r = " + r);
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_E) {
//            System.out.println("key pressed E");
//            if(r == 0){ r = 360;}
//            r -= 5;
//            System.out.println("r = " + r);
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_MINUS || ke.getKeyCode() == KeyEvent.VK_SUBTRACT) {
//            System.out.println("key pressed -");
//            if(sX >= 0.2){
//                sX -= 0.2;
//                sY -= 0.2;
//            }else{
//                System.out.println("Escala Minima Alcanzada");
//            }
//        }
//
//        if(ke.getKeyCode() == KeyEvent.VK_PLUS || ke.getKeyCode() == KeyEvent.VK_ADD) {
//            System.out.println("key pressed +");
//            sX += 0.2;
//            sY += 0.2;
//
//        }
//    }
//
//    public void keyTyped(KeyEvent ke) {
//        repaint();
//    }
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Lines");
////      Lines frame = new Lines();
////      frame.addKeyListener(frame);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Main main = new Main();
//        frame.add(main);
//        frame.addKeyListener(main);
//        frame.setSize(500, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//}
