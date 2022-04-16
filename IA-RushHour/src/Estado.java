
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
public class Estado {
    int nivel; 
    ArrayList<Ficha> fichas;
    Tablero refTablero;
    double estimacionPeso; //F(n)

    public Estado(int nivel, ArrayList<Ficha> fichas, Tablero refTablero) {
        this.nivel = nivel;
        this.fichas = fichas;
        this.refTablero = refTablero;
    }
    
    
    public int cantCarrosBloqueando(){
        Ficha carroPrincipal = null;
        int cantCarrosBloqueados = 0;
        for (int i = 0; i < fichas.size(); i++) {
            if(fichas.get(i).tipo==1){
                carroPrincipal = fichas.get(i);
                break;
            }
        }
        
        int pos1 = carroPrincipal.posicion;
        int pos2 = carroPrincipal.posiciones[carroPrincipal.espacios-1];
        pos2 += 1;
        if(carroPrincipal.forma.equals("vertical")){
            for (int i = pos2; i < 6; i++) {
                /*if(refTablero.tablero[i][pos1]!=0){
                    cantCarrosBloqueados+=1;
                }*/
                cantCarrosBloqueados+=1;
            }
        }
        else{
            for (int i = pos2; i < 6; i++) {
                /*if(refTablero.tablero[pos1][i]!=0){
                    cantCarrosBloqueados+=1;
                }*/
                cantCarrosBloqueados+=1;
            }
        }
        return cantCarrosBloqueados;  
    }
  
    public double calcularHeuristica(){ //h(N)
        //1/35 * cantidad de carros que bloquean al carro rojo
        double num1 = 1.00;
        double num2 = 35.00;
        double resultado = num1/num2;
        return resultado*cantCarrosBloqueando();
    }
    public boolean termino(){
        if(cantCarrosBloqueando()==0){
            return true;
        }
        else{
            return false;
        }
    }
    public double calcularCostoExacto(){ //g(N)
        //cantidad de movimientos dados
        return nivel;
    }
    public void calcularEstimacionPeso(){
        //F(N) = g(N) + h(N)
        this.estimacionPeso = calcularCostoExacto() + calcularHeuristica();
    }
    public void mostrar(){
        refTablero.mostrarTablero();
    }
    
}
