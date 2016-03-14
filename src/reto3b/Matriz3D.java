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
public class Matriz3D {
    
    private double[][] matriz;
    
    public Matriz3D(){
        matriz = new double[4][4];
    }
    
    public double[][] mult(Matriz3D m1){
        double[][]m = m1.getMatriz();
        double[][]mR = new double[4][4];
        
        for(int i = 0;i<4;i++){
            
            for(int j = 0;j<4;j++){
                
                for(int k = 0;k<4;k++){
                    mR[i][j] += this.matriz[i][k]*m[k][j];
                }
            }
        }
        
        return mR;
    }

    public void setMatriz(double[][] m){
        matriz = m;
    }

    public void setMatrizVal(int i, int j, double val){
        matriz[i][j] = val;
    }
    
    public double[][] transp(){
        double[][] mR = this.matriz;
        for(int j = 0;j<4;j++){
               
            for(int k = 0;k<4;k++){
                mR[j][k] += this.matriz[k][j];
            }
        }
        return mR;
    }

    public double[][] getMatriz() {
        return matriz;
    }    
    
}
