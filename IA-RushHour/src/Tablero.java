
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeico
 */
public class Tablero {
    //Este tablero se utiliza para trabajar en los estados
    int[][] tablero = {
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0}
    };
    public boolean tableroValido(ArrayList<Ficha> fichas){
        int x,y;
        int tipoFicha = 0;
        for (int i = 0; i < fichas.size(); i++) {
            tipoFicha = fichas.get(i).tipo;
            if(fichas.get(i).forma.equals("vertical")){
                x = fichas.get(i).posicion;
                for (int j = 0; j < fichas.get(i).posiciones.length; j++) {
                    y = fichas.get(i).posiciones[j]; //Y va cambiando
                    if(this.tablero[x][y] == 0){
                        this.tablero[x][y] = tipoFicha;
                    }
                    else{
                        return false;
                    }
                }
            }
            //si es horizontal
            else{
                y = fichas.get(i).posicion;
                for (int j = 0; j < fichas.get(i).posiciones.length; j++) {
                    x = fichas.get(i).posiciones[j]; //X va cambiando
                    if(this.tablero[x][y] == 0){
                        this.tablero[x][y] = tipoFicha;
                    }
                    else{
                        return false;
                    }
                }
            } 
        }
        return true;
    }
    public void mostrarTablero(){
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[i].length; j++) {
                System.out.println(" "+this.tablero[i][j]+" ");
            }
        }
    }
}
