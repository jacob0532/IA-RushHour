/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AEstrella;
import java.util.ArrayList;

public class Board {
    //Este tablero se utiliza para trabajar en los estados
    private int[][]  configuration={
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0}
    };
    private int g = 0;
    private int h = 0;
    Board padre=null;
    
    public int getF(){
        return (h+g);
    }
    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public Board getPadre() {
        return padre;
    }

    public int[] getExit() {
        return exit;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setPadre(Board padre) {
        this.padre = padre;
    }
    private int[] exit = {0,0};
    
    public Board(int[][] pBoard, int[] pExit) {
        if (pBoard.length == 6){
            for (int x = 0; x < pBoard.length; x++) {
                if (pBoard[x].length ==6){}else{
                    //TODO: informar tamano erroneo de matriz
                    System.out.println("tamano erroneo de matriz");
                    break;
                }
            }
            configuration =pBoard;
        }else{
             //TODO: informar tamano erroneo de matriz
             System.out.println("tamano erroneo de matriz");
        }
        
        if(pExit.length ==2){
            exit = pExit;
        }else
        {/*TODO: informar tamano erroneo de matriz de salida*/
            System.out.println("tamano erroneo de matriz de salida");
        }
    }
    
    public int[][] getConfiguration(){
        return configuration;
    }
    
    
}