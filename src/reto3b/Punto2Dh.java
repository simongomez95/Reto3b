/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3b;

/**
 *
 * @author lope
 */
public class Punto2Dh {
    
    private double x;
    private double y;
    private double w;
    
    public Punto2Dh(double x1, double y1){
        x = x1;
        y = y1;
        w = 1;
    }
    
    public Punto2Dh transf(Matriz2D m1, Punto2Dh p){
        double[][] m = m1.getMatriz();
        double[] point={p.getX(), p.getY(), p.getW()};
        double[] res={0, 0, 0};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                res[i] += m[i][j]*point[j];
            }
        }
        return new Punto2Dh(res[0], res[1]);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getW() {
        return w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setW(double w) {
        this.w = w;
    }
    
    
}
