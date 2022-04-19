/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import AEstrella.Board;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeico
 */
//Forma de instanciarlo Hilo h = new Hilo(5,100); 
public class Hilo extends Thread{
    private int velocidad;
    ArrayList<Board> list = new ArrayList<>();
    RushHour interfaz;
    private boolean ejecutar = false; 

    public Hilo(int velocidad, ArrayList<Board> list, RushHour interfaz) {
        this.velocidad = velocidad;
        this.list = list;
        this.interfaz = interfaz;
    }
    
    @Override
    public void run(){
        interfaz.btnInit.setEnabled(false);
        interfaz.btnUpdate.setEnabled(false);
        String dificultad = "";
        Map<Integer, Color> map = new HashMap<Integer, Color>();
        if(list.size()>0){
            int[][] configuration = list.get(0).getConfiguration();
            for (int x = 0; x < configuration.length; x++) {
                for (int y = 0; y < configuration[x].length; y++) {
                    if(configuration[x][y] != 0 ){
                        
                        if(!map.containsKey(configuration[x][y])){
                            if(configuration[x][y] == 1 ){map.put(configuration[x][y], Color.RED);}
                            else{
                                Random rand = new Random();
                                float r = rand.nextFloat();
                                float v = rand.nextFloat();
                                float n = rand.nextFloat();
                                map.put(configuration[x][y], new Color(r,v, n));
                            }
                        }
                    }
                }
            }    
        }
        if(list.size()<15){
            dificultad = "FACIL";
        }
        else if(list.size()>=15 && list.size()<30){
            dificultad = "INTERMEDIA";
            
        }
        else if(list.size()>=30 && list.size()<50){
            dificultad = "DIFICIL";
            
        }
        else if(list.size()>=50){
            dificultad = "MUY DIFICIL";
            
        }
        interfaz.txtDificultad.setText(dificultad);
        try{
            while(ejecutar){    
                for (int i = 0; i < list.size(); i++) {
                    //update(interfaz.jLabel1.getGraphics());//.paint(jPanel1.getGraphics());
                    interfaz.update(interfaz.jLabel1.getGraphics());
                    //interfaz.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Utilities/cuadricula.jpg")));
                    Board get = list.get(i);
                    Car.dibujar(interfaz.jLabel1.getGraphics(),get,map); 
                    interfaz.txtMov.setText(String.valueOf(i));
                    sleep(velocidad);  
                }
                terminar();
            }
            interfaz.btnInit.setEnabled(true);
            interfaz.btnUpdate.setEnabled(true);
            
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        
    }
    public void iniciar(){
        if (!ejecutar) {
            ejecutar = true;
            start(); //metodo del thread que ejecuta el run 
        }
    }
    public void terminar(){
        if(ejecutar){
            ejecutar = false;
        }
    }
    
}
