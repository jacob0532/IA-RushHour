
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
public class Nodo {
    Estado dato;
    ArrayList<Nodo> hijos = new ArrayList<>();

    public Nodo(Estado dato) {
        this.dato = dato;
    }
    
    public int cantHijos(){
        return this.hijos.size();
    }

    public void vaciarListaHijos(){
        int largo = this.hijos.size();
        while(largo>0){
            this.hijos.remove(largo-1);
            largo--;
        }
    }
    public void asignarPesosHijos(){
        for (int i = 0; i < this.hijos.size(); i++) {
            this.hijos.get(i).dato.calcularEstimacionPeso();
        }
    }
    public void hijosValiosos(){
        ArrayList<Boolean> listaAux = new ArrayList<>();
        for (int i = 0; i < this.cantHijos(); i++) {
            listaAux.add(false);
        }
        for (int i = 0; i < this.cantHijos(); i++) {
            for (int j = 0; j < this.cantHijos(); j++) {
                if(this.hijos.get(i).dato.estimacionPeso > this.hijos.get(j).dato.estimacionPeso){
                    listaAux.set(i, Boolean.TRUE);
                }
            }
        }
        for (int i = 0; i < this.cantHijos(); i++) {
            if(listaAux.get(i)){
                this.hijos.remove(i);
                listaAux.remove(i);
                i--;
            }
        }
    }
    public void mostrarHijos(){
        for (int i = 0; i < this.hijos.size(); i++) {
            System.out.println("Hijo " + i + " :");
            this.hijos.get(i).dato.mostrar();
            System.out.println("");
        }
    }
    
}
