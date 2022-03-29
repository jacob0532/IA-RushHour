/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeico
 */
public class ArbolN {
    Nodo raiz;

    public ArbolN(Nodo raiz) {
        this.raiz = raiz;
    }
    public void insertar(Nodo nodo, String info, String padre){
        Nodo nuevoNodo = new Nodo(info);
        //Si el padre es la raiz
        if(nodo.getDato().equals(padre)){
            nodo.aumentarHijo(nuevoNodo);
        }
        else{
            //si el padre es alguno de los hijos
            for (int i = 0; i < nodo.nohijos; i++) {
                if(nodo.hijos[i].getDato().equals(padre)){
                    //se coloca el hijo en el nodo
                    nodo.hijos[i].aumentarHijo(nuevoNodo);
                }
                else{
                    //busca el padre en los hijos del nodo
                    insertar(nodo.hijos[i],info,padre); 
                }
                
            }
        }
        
    }
    public void imprimirArbol(Nodo nodo,int nivel){
        for (int i = 0; i < nodo.nohijos; i++) {
            System.out.println("nivel: "+nivel);
            nodo.hijos[i].verNodo();
            imprimirArbol(nodo.hijos[i],nivel+1);
        }
    }
    
}
