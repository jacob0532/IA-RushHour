/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import AEstrella.Board;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Alexander
 */
public class Car {
      public static void dibujar(Graphics g, Board b,Map m){
        
        int [][] configuration = b.getConfiguration();
        int[] exit = b.getExit();
        Map<Integer, Color> map = m;
        
        for (int x = 0; x < configuration.length; x++) {
            for (int y = 0; y < configuration[x].length; y++) {
                if(configuration[x][y] != 0 ){
                         g.setColor(map.get(configuration[x][y]));
                         g.fillRect((y*100)+4,(x*100)+57 , 100, 100);
                         
                }
                if(exit[1]==0){
                    g.setColor(Color.GRAY);
                    g.fillRect((exit[1]*100)+4,(exit[0]*100)+57 , 15, 100);
                    g.setColor(Color.BLACK);
                    g.drawRect((exit[1]*100)+4,(exit[0]*100)+57 , 15, 100);
                    
                }else if(exit[0]==0){
                    g.setColor(Color.GRAY);
                    g.fillRect((exit[1]*100)+4,(exit[0]*100)+57 , 100, 15);
                    g.setColor(Color.BLACK);
                    g.drawRect((exit[1]*100)+4,(exit[0]*100)+57 , 100, 15);
                   
                }else if(exit[1]==5){
                    g.setColor(Color.GRAY);
                    g.fillRect((exit[1]*100)+84,(exit[0]*100)+57 , 15, 100);
                    g.setColor(Color.BLACK);
                    g.drawRect((exit[1]*100)+84,(exit[0]*100)+57 , 15, 100);
                    
                }else if(exit[0]==5){
                    g.setColor(Color.GRAY);
                    g.fillRect((exit[1]*100)+4,(exit[0]*100)+137 , 100, 15);
                    g.setColor(Color.BLACK);
                    g.drawRect((exit[1]*100)+4,(exit[0]*100)+137 , 100, 15);
                   
                }
            }
        }
        
       
    }
}