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
 * @author sande
 */
public class Car {
      public static void dibujar(Graphics g, Board b,Map m){
        
        int [][] configuration = b.getConfiguration();
        Map<Integer, Color> map = m;
        
        for (int x = 0; x < configuration.length; x++) {
            for (int y = 0; y < configuration[x].length; y++) {
                if(configuration[x][y] != 0 ){
                         g.setColor(map.get(configuration[x][y]));
                
                    g.fillRect((y*100)+4,(x*100)+57 , 100, 100);
                }
            }
        }
        
       // g.fillRect(100,100 , 200, 100);
        //getContentPane().setBackground(new Color(70,80,70));
    }
}