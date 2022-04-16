
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
    Nodo padre;
    ArrayList<Nodo> hijos = new ArrayList<>();

    public Nodo(Estado dato,Nodo padre) {
        this.dato = dato;
        this.padre = padre;
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
        boolean bandera = false;
        for (int i = 0; i < this.cantHijos(); i++) {
            for (int j = 0; j < this.cantHijos(); j++) {
                if(this.hijos.get(i).dato.estimacionPeso > this.hijos.get(j).dato.estimacionPeso){
                    bandera = true;
                }
            }
            if(bandera){
                this.hijos.remove(i);
                bandera = false;
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
