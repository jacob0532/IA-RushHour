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

    public Ficha(int tipo, String forma, int espacios, int posicion,int[] posiciones) {
        this.tipo = tipo;
        this.forma = forma;
        this.espacios = espacios;
        this.posicion = posicion;
        this.posiciones = posiciones;
    }

    
    //Valida que un moviemiento sea valido en el tablero
    public boolean movEsValido(String tipoMov){
        for (int i = 0; i < posiciones.length; i++) {
            if(tipoMov.equals("ARRIBA")||tipoMov.equals("IZQUIERDA")){
                if(posiciones[i]-1 < 0){
                    return false;
                }
            }
            if(tipoMov.equals("ABAJO")||tipoMov.equals("DERECHA")){
                if(posiciones[i]+1 > 5 ){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean mover(String tipoMov){
        if(movEsValido(tipoMov)){
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
            return true;
        }
        else{
            //System.out.println("Error no puede mover ficha a ese lugar");
            return false;
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
