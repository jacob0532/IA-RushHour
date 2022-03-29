
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
    int id; //unico
    ArrayList<Ficha> fichas = new ArrayList<>();
    Tablero tablero;
    double estimacionPeso; //F(n)
    
    public double calcularHeuristica(){ //h(N)
        return 2312.22312;
    }
    public double calcularCostoExacto(){ //g(N)
        return 2312.22312;
    }
    public void calcularEstimacionPeso(){
        //F(N) = g(N) + h(N)
        this.estimacionPeso = calcularCostoExacto() + calcularHeuristica();
    }
    
}
