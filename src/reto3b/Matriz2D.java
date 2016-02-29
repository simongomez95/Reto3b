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
public class Matriz2D {
    
    private double[][] matriz;
    
    public Matriz2D(){
        matriz = new double[3][3];
        matriz[0][0] = 0;
        matriz[0][1] = 0;
        matriz[1][0] = 0;
        matriz[1][1] = 0;
        matriz[2][0] = 0;
        matriz[2][1] = 0;
        matriz[2][2] = 0;
        matriz[0][2] = 0;
        matriz[1][2] = 0;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int i,int j, double val){
        matriz[i][j] = val;
    }

    public double[][] mult(Matriz2D m1){
        double[][]m = m1.getMatriz();
        double[][]mR = new double[3][3];
        
        for(int i = 0;i<3;i++){
            
            for(int j = 0;j<3;j++){
                
                for(int k = 0;k<3;k++){
                    mR[i][j] += this.matriz[i][k]*m[k][j];
                }
            }
        }
        
        return mR;
    }
}
