
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tb1 = new Tablero();
        ArrayList<Ficha> listaDeFichas = new ArrayList<>(); 
        Ficha ficha1 = new Ficha(1,"horizontal",2,2); //carro rojo
        ficha1.posiciones[0] = 1;
        ficha1.posiciones[1] = 2;
        
        Ficha ficha2 = new Ficha(2,"vertical",2,4); //carro verde
        ficha2.posiciones[0] = 1;
        ficha2.posiciones[1] = 2;
     
        Ficha ficha3 = new Ficha(3,"vertical",3,5); //camion amarillo
        ficha3.posiciones[0] = 0;
        ficha3.posiciones[1] = 1;
        ficha3.posiciones[2] = 2;
        
        Ficha ficha4 = new Ficha(2,"horizontal",2,4); //carro verde
        ficha4.posiciones[0] = 4;
        ficha4.posiciones[1] = 5;
        
        listaDeFichas.add(ficha1);
        listaDeFichas.add(ficha2);
        listaDeFichas.add(ficha3);
        listaDeFichas.add(ficha4);
        tb1.tableroValido(listaDeFichas);
        AlgoritmoAestrella Aestrella = new AlgoritmoAestrella(tb1,listaDeFichas);
        
        
    }
}
