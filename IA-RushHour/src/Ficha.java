/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeico
 */
public class Ficha {
    int tipo; // 3-camion-2-carro-1-carroPrincipal
    String forma; // vertical - horizontal
    int espacios; // 3 para camion - 2 para carro - 2 para carroPrincipal
    int posicion;
    int[] posiciones;//[col,col,col] o [fila,fila,fila] dependiendo de la forma y tipo

    public Ficha(int tipo, String forma, int espacios, int posicion) {
        this.tipo = tipo;
        this.forma = forma;
        this.espacios = espacios;
        this.posicion = posicion;
        this.posiciones = new int[espacios];
    }
    
    //Valida que un moviemiento sea valido en el tablero
    public boolean movEsValido(){
        for (int i = 0; i < posiciones.length; i++) {
            if(posiciones[i]+1 > 5 || posiciones[i]-1 < 0){
                return false;
            }
        }
        return true;
    }
    public void mover(String tipoMov){
        if(movEsValido()){
            switch(tipoMov){
                case "ARRIBA":case "IZQUIERDA":
                    for (int i = 0; i < posiciones.length; i++) {
                        this.posiciones[i] = posiciones[i]-1;
                    }
                    break;
                case "ABAJO":case "DERECHA":
                    for (int i = 0; i < posiciones.length; i++) {
                        this.posiciones[i] = posiciones[i]+1;
                    }
                    break;
            } 
        }
        else{
            System.out.println("Error no puede mover ficha a ese lugar");
        }
    }    
    public void imprimirPosicion(){
        System.out.print("[ ["+posicion+",[ ");
        for (int i = 0; i < posiciones.length; i++) {
            System.out.print(posiciones[i]+ " "); 
        }
        System.out.print("]] ]");
        System.out.println("");
    }
    
    
}
