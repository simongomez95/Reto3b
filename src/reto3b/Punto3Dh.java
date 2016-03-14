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
public class Punto3Dh {
    
    private double x;
    private double y;
    private double z;
    private double w;
    
    public Punto3Dh(double x1, double y1, double z1){
        x = x1;
        y = y1;
        z = z1;
        w = 1;
    }

    public Punto3Dh transf(Matriz3D m1, Punto3Dh p){
        double[][] m = m1.getMatriz();
        double[] point={p.getX(), p.getY(),p.getZ(), p.getW()};
        double[] res={0, 0, 0, 0};
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                res[i] += m[i][j]*point[j];
            }
        }
        return new Punto3Dh(res[0], res[1], res[2]);
    }

    public void normalize(){
        if(w == 1){
            return;
        }else{
            x = x/w;
            y = y/w;
            z = z/w;
        }

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
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

    public void setZ(double z) {
        this.z = z;
    }

    public void setW(double w) {
        this.w = w;
    }
    
    
    
}
