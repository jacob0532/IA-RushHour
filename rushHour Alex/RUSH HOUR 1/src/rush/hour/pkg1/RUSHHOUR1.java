/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rush.hour.pkg1;
import java.util.Arrays;
import AEstrella.*;
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
        int[][]  configuration={
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0},
                        {0,0,0,0,0,0}
        };
        int[] exit = {2,5};
        Board b = new Board(configuration, exit);
        b.setH(new Heuristic().calcH(b.getConfiguration(), b.getExit()));
        Board aux = new Heuristic().calcAStar( b);
        
        System.out.println("Configuartion ******************************");
        int c =0;    
        while (aux.getPadre()!= null){
            c++;
            System.out.println("Configuartion ******************************");
            new Heuristic().printMatriz(aux.getConfiguration());
            aux = aux.getPadre();
            System.out.println();
        }
        System.out.println("contador= "+c);
    }
    
}
