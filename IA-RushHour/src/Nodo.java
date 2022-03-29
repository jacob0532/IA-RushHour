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
    String info;
    int nohijos;
    Nodo hijos[];
    Nodo hijosT[];

    public Nodo(String info) {
        this.info = info;
        this.nohijos = 0;
    }
    public void copiarHijos(){
        //Aumenta en 1 los hijos con el arreglo temporal
        hijosT = new Nodo[nohijos+1];
        for (int i = 0; i < this.nohijos; i++) {
            hijosT[i]=hijos[i];
            
        }
    }
    public void aumentarHijo(Nodo nodo){
        copiarHijos();
        hijosT[this.nohijos]=nodo;
        hijos = hijosT;
        this.nohijos++;
    }
    public String getDato(){
        return info;
    }
    public void verNodo(){
        System.out.println("{"+this.info+"}");
    }
    
    
    
}
