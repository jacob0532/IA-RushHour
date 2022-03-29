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
        /*ArbolN arbol = new ArbolN(new Nodo("0"));
        arbol.insertar(arbol.raiz, "1", "0");
        arbol.insertar(arbol.raiz, "2", "0");
        arbol.insertar(arbol.raiz, "1.1", "1");
        arbol.insertar(arbol.raiz, "1.2", "1");
        arbol.insertar(arbol.raiz, "1.3", "1");
        arbol.insertar(arbol.raiz, "1.4", "1");
        arbol.insertar(arbol.raiz, "1", "1.4");
        arbol.raiz.verNodo();
        arbol.imprimirArbol(arbol.raiz, 1);*/
        
        Ficha ficha1 = new Ficha(1,"horizontal",2,2);
        ficha1.posiciones[0] = 2;
        ficha1.posiciones[1] = 3;
        
        Ficha ficha2 = new Ficha(3,"vertical",3,2);
        ficha2.posiciones[0] = 0;
        ficha2.posiciones[1] = 1;
        ficha2.posiciones[2] = 2;
        
        Ficha ficha3 = new Ficha(3,"vertical",3,2);
        ficha3.posiciones[0] = 0;
        ficha3.posiciones[1] = 1;
        ficha3.posiciones[2] = 2;
        
        Ficha ficha4 = new Ficha(3,"vertical",3,2);
        ficha4.posiciones[0] = 0;
        ficha4.posiciones[1] = 1;
        ficha4.posiciones[2] = 2;
        
        
        System.out.println("La posicion de la ficha es: ");
        ficha1.imprimirPosicion();
    }
}
