
import java.util.ArrayList;
import java.util.List;

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
    boolean parada = false;

    public AlgoritmoAestrella(Tablero tableroRushHour, ArrayList<Ficha> fichas) {
        this.tableroRushHour = tableroRushHour;
        this.fichas = fichas;
        this.raiz = new Nodo(new Estado(0,fichas,tableroRushHour),null);
        this.raiz.dato.calcularEstimacionPeso();
        this.generarSolucion(raiz,1);
        //System.out.println(this.raiz.dato.estimacionPeso);
    }
    public void generarSolucion(Nodo nodo, int nivel){
        //System.out.println("--------NIVEL: " + nivel + "------------");
        for (int i = 0; i < nodo.dato.fichas.size(); i++) {
            if(nodo.dato.fichas.get(i).forma.equals("horizontal")){
                if(nodo.dato.fichas.get(i).mover("DERECHA")){ //mueve ficha a la derecha
                    Tablero tbAux = new Tablero(); //crea un tablero nuevo
                    if(tbAux.tableroValido(nodo.dato.fichas)){ //rellena el tablero y revisa que sea valido
                        Nodo aux = new Nodo(new Estado(nivel,nuevoArrayFichas(nodo.dato.fichas),tbAux),nodo);
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
                        Nodo aux = new Nodo(new Estado(nivel,nuevoArrayFichas(nodo.dato.fichas),tbAux),nodo);
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
                        Nodo aux = new Nodo(new Estado(nivel,nuevoArrayFichas(nodo.dato.fichas),tbAux),nodo);
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
                        Nodo aux = new Nodo(new Estado(nivel,nuevoArrayFichas(nodo.dato.fichas),tbAux),nodo);
                        nodo.hijos.add(aux);
                        nodo.dato.fichas.get(i).mover("ARRIBA"); //devuelve al estado original el arreglo base
                    }
                    else{
                        nodo.dato.fichas.get(i).mover("ARRIBA");
                    }
                }
            } 
        }
        
        
        for (int i = 0; i < nodo.hijos.size(); i++) {
            if(!noExisteEnGrafo(null,nodo.hijos.get(i),0)){ //Si ese nodo ya existe en el grafo
                nodo.hijos.remove(i);
                i--;
            }   
        }
        nodo.asignarPesosHijos();
        nodo.hijosValiosos();
        /*System.out.println("PADRE:");
        nodo.dato.mostrar();
        System.out.println("HIJOS:");
        nodo.mostrarHijos();*/
            
        for (int i = 0; i < nodo.hijos.size(); i++) {
            if(nodo.hijos.get(i).dato.termino()){
                System.out.println("TERMINO");
                nodo.hijos.get(i).dato.refTablero.mostrarTablero();
                System.out.println("TERMINO");
                this.parada = true;
                System.out.println("-----------------------------------------");
                System.out.println("--------------¡SOLUCION!-----------------");
                System.out.println("-----------------------------------------");
                mostrarSolucion(nodo.hijos.get(i),nivel);
                return;
            }
            else{
                if(!parada)
                    generarSolucion(nodo.hijos.get(i), nivel+1);
            }
        }
    }
    public ArrayList<Ficha> nuevoArrayFichas(ArrayList<Ficha> arrFichas){
        ArrayList<Ficha> nuevoArrFichas = new ArrayList<>();
        for (int i = 0; i < arrFichas.size(); i++) {
            int[] posicionesVar = new int[arrFichas.get(i).posiciones.length];
            System.arraycopy(arrFichas.get(i).posiciones, 0, posicionesVar, 0, arrFichas.get(i).posiciones.length);
            nuevoArrFichas.add(new Ficha(arrFichas.get(i).tipo,arrFichas.get(i).forma,
                    arrFichas.get(i).espacios,arrFichas.get(i).posicion,posicionesVar));
        }
        return nuevoArrFichas;
    }
    
    public boolean noExisteEnGrafo(ArrayList<Nodo> hijos, Nodo nodo,int nivel){
        boolean bandera = true;
        if(hijos==null){
            if(nodo.dato.nivel>nivel){
                if(tablerosIguales(raiz.dato.refTablero,nodo.dato.refTablero)){
                    return false;
                }
                else{
                    if(raiz.hijos.size()>0 && nodo.dato.nivel>(nivel+1)){
                        if(noExisteEnGrafo(raiz.hijos,nodo,nivel+1)){
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return true;
                    }
                }
            
            }
            else{
                return true;
            }
            
            
        }
        else{
            for (int i = 0; i < hijos.size(); i++) {
                if(tablerosIguales(hijos.get(i).dato.refTablero,nodo.dato.refTablero)){
                    bandera = false;
                }
                else{
                    if(hijos.get(i).hijos.size()>0 && nodo.dato.nivel>(nivel+1)){
                        if(!noExisteEnGrafo(hijos.get(i).hijos,nodo,nivel+1)){
                            bandera = false;
                        }
                    }
                }
            }
            return bandera;
        }
    }
    
    public boolean tablerosIguales(Tablero tb1, Tablero tb2){
        if(tb1.tablero.length!=tb2.tablero.length){
            return false;
        }
        else{
            for (int i = 0; i < tb1.tablero.length; i++) {
                for (int j = 0; j < tb1.tablero.length; j++) {
                    if(tb1.tablero[i][j]!=tb2.tablero[i][j]){
                        return false;
                    }
                }
            } 
        }
        return true;
    }
  
    
    public void mostrarSolucion(Nodo nodoAux,int nivel){
        while(nodoAux.padre!=null){
            System.out.println("Nivel: " + nivel);
            nodoAux.dato.refTablero.mostrarTablero();
            nivel = nivel -1;
            nodoAux = nodoAux.padre;
        }
        
    }
    
}
