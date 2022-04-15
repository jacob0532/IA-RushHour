
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
public class AlgoritmoAestrella {
    Tablero tableroRushHour;
    ArrayList<Ficha> fichas;
    Nodo raiz;

    public AlgoritmoAestrella(Tablero tableroRushHour, ArrayList<Ficha> fichas) {
        this.tableroRushHour = tableroRushHour;
        this.fichas = fichas;
        this.raiz = new Nodo(new Estado(0,fichas,tableroRushHour));
        this.raiz.dato.calcularEstimacionPeso();
        this.generarSolucion(raiz,1);
        //System.out.println(this.raiz.dato.estimacionPeso);
    }
    public void generarSolucion(Nodo nodo, int nivel){
        System.out.println("--------NIVEL: " + nivel + "------------");
        for (int i = 0; i < nodo.dato.fichas.size(); i++) {
            if(nodo.dato.fichas.get(i).forma.equals("horizontal")){
                if(nodo.dato.fichas.get(i).mover("DERECHA")){ //mueve ficha a la derecha
                    Tablero tbAux = new Tablero(); //crea un tablero nuevo
                    if(tbAux.tableroValido(nodo.dato.fichas)){ //rellena el tablero y revisa que sea valido
                        tbAux.mostrarTablero();
                        Nodo aux = new Nodo(new Estado(nivel,nodo.dato.fichas,tbAux));
                        nodo.hijos.add(aux);
                        nodo.dato.fichas.get(i).mover("IZQUIERDA"); //devuelve al estado original el arreglo base
                    }
                    else{
                        nodo.dato.fichas.get(i).mover("IZQUIERDA");
                    }
                }
                if(nodo.dato.fichas.get(i).mover("IZQUIERDA")){
                    Tablero tbAux = new Tablero(); //crea un tablero nuevo
                    if(tbAux.tableroValido(nodo.dato.fichas)){ //rellena el tablero y revisa que sea valido
                        tbAux.mostrarTablero();
                        Nodo aux = new Nodo(new Estado(nivel,nodo.dato.fichas,tbAux));
                        nodo.hijos.add(aux);
                        nodo.dato.fichas.get(i).mover("DERECHA"); //devuelve al estado original el arreglo base
                    }
                    else{
                        nodo.dato.fichas.get(i).mover("DERECHA");
                    }
                }
            }
            else{
                if(nodo.dato.fichas.get(i).mover("ARRIBA")){ //mueve ficha a la derecha
                    Tablero tbAux = new Tablero(); //crea un tablero nuevo
                    if(tbAux.tableroValido(nodo.dato.fichas)){ //rellena el tablero y revisa que sea valido
                        tbAux.mostrarTablero();
                        Nodo aux = new Nodo(new Estado(nivel,nodo.dato.fichas,tbAux));
                        nodo.hijos.add(aux);
                        nodo.dato.fichas.get(i).mover("ABAJO"); //devuelve al estado original el arreglo base
                    }
                    else{
                        nodo.dato.fichas.get(i).mover("ABAJO");
                    }
                }
                if(nodo.dato.fichas.get(i).mover("ABAJO")){ //mueve ficha a la derecha
                    Tablero tbAux = new Tablero(); //crea un tablero nuevo
                    if(tbAux.tableroValido(nodo.dato.fichas)){ //rellena el tablero y revisa que sea valido
                        tbAux.mostrarTablero();
                        Nodo aux = new Nodo(new Estado(nivel,nodo.dato.fichas,tbAux));
                        nodo.hijos.add(aux);
                        nodo.dato.fichas.get(i).mover("ARRIBA"); //devuelve al estado original el arreglo base
                    }
                    else{
                        nodo.dato.fichas.get(i).mover("ARRIBA");
                    }
                }
            } 
        }
        nodo.asignarPesosHijos();
        nodo.hijosValiosos();
        for (int i = 0; i < nodo.hijos.size(); i++) {
            if(nodo.hijos.get(i).dato.termino()){
                System.out.println("TERMINO");
                nodo.hijos.get(i).dato.refTablero.mostrarTablero();
                System.out.println("TERMINO");
                return;
            }
            else{
                generarSolucion(nodo.hijos.get(i), nivel+1);
            }
        }
    }
  
    
    public void mostrarSolucion(){
        
    }
    
}
