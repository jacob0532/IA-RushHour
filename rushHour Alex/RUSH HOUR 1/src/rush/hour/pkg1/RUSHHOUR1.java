/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rush.hour.pkg1;
import java.util.Arrays;
import AEstrella.*;
import GUI.RushHour;
import java.util.ArrayList;
/**
 *
 * @author sande
 */
public class RUSHHOUR1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inicia corrida");
        // TODO code application logic here
        //src\rush\hour\pkg1
        ArchiveManager archivo = new ArchiveManager("src\\rush\\hour\\pkg1\\ConfiguracionInicial.txt");
        archivo.leerArchivo();
        int[][] configuration = archivo.getConfiguration();
        int[] exit = archivo.getBoardExit();
        /*int[][]  configuration={
                        {2,2,3,11,10,10},
                        {0,0,3,11,0,0},
                        {1,1,3,0,0,0},
                        {4,6,6,7,7,9},
                        {4,0,0,8,0,9},
                        {5,5,0,8,0,9}
        };
        int[] exit = {2,5};*/
        Board b = new Board(configuration, exit);
        b.setH(new Heuristic().calcH(b.getConfiguration(), b.getExit()));
        Board aux = new Heuristic().calcAStar( b);
        
        //System.out.println("******************Configuartion******************");
        ArrayList<Board> list  =  new ArrayList<>();
        list.add(0, aux);
        int c =0; 
        while (aux.getPadre()!= null){
            list.add(0, aux.getPadre());
            c++;
            new Heuristic().printMatriz(aux.getConfiguration());
            aux = aux.getPadre();
            System.out.println();
        }
        System.out.println("Movimientos: " + c);
        
        //animacion
           java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RushHour(list,exit).setVisible(true);
            }
        });
    }
    
    
}
