/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sande
 */
public class Car {
    public static void dibujar(Graphics g){
        g.setColor(Color.BLUE);
        
        g.fillRect(100,100 , 200, 100);
        //getContentPane().setBackground(new Color(70,80,70));
    }
}
