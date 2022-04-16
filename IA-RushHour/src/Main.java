
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
        int[] arreglo1 = new int[2];
        arreglo1[0] = 0;
        arreglo1[1] = 1;
        Ficha ficha1 = new Ficha(1, "horizontal", 2, 2, arreglo1); //carro rojo

        arreglo1 = new int[2];
        arreglo1[0] = 0;
        arreglo1[1] = 1;
        Ficha ficha2 = new Ficha(2, "horizontal", 2, 0, arreglo1); //carro verde

        arreglo1 = new int[3];
        arreglo1[0] = 0;
        arreglo1[1] = 1;
        arreglo1[2] = 2;
        Ficha ficha3 = new Ficha(3, "vertical", 3, 2, arreglo1); //camion amarillo

        arreglo1 = new int[3];
        arreglo1[0] = 3;
        arreglo1[1] = 4;
        arreglo1[2] = 5;
        Ficha ficha4 = new Ficha(3, "vertical", 3, 5, arreglo1); //camion amarillo

        arreglo1 = new int[2];
        arreglo1[0] = 4;
        arreglo1[1] = 5;
        Ficha ficha5 = new Ficha(2, "horizontal", 2, 0, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 0;
        arreglo1[1] = 1;
        Ficha ficha6 = new Ficha(2, "vertical", 2, 3, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 3;
        arreglo1[1] = 4;
        Ficha ficha7 = new Ficha(2, "horizontal", 2, 3, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 1;
        arreglo1[1] = 2;
        Ficha ficha8 = new Ficha(2, "horizontal", 2, 3, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 3;
        arreglo1[1] = 4;
        Ficha ficha9 = new Ficha(2, "vertical", 2, 0, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 0;
        arreglo1[1] = 1;
        Ficha ficha10 = new Ficha(2, "horizontal", 2, 5, arreglo1); //carro verde

        arreglo1 = new int[2];
        arreglo1[0] = 4;
        arreglo1[1] = 5;
        Ficha ficha11 = new Ficha(2, "vertical", 2, 3, arreglo1); //carro verde

        listaDeFichas.add(ficha1);
        listaDeFichas.add(ficha2);
        listaDeFichas.add(ficha3);
        listaDeFichas.add(ficha4);
        listaDeFichas.add(ficha5);
        listaDeFichas.add(ficha6);
        listaDeFichas.add(ficha7);
        listaDeFichas.add(ficha8);
        listaDeFichas.add(ficha9);
        listaDeFichas.add(ficha10);
        listaDeFichas.add(ficha11);
        tb1.tableroValido(listaDeFichas);
        //tb1.mostrarTablero();
        AlgoritmoAestrella Aestrella = new AlgoritmoAestrella(tb1,listaDeFichas);

    }
}
