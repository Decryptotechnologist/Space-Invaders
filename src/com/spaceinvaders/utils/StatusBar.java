/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.utils;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * @author Ghomez
 * 
 */
public class StatusBar extends JLabel {

    /**Attributes*/
    
    /**border variable of StatusBar object */
    private Border border;
    
    /**font Font of StatusBar object */
    private Font font = new Font("Cosmic Alien", Font.PLAIN, 12);
    
    /**foreGroundCol variable of StatusBar object */
    private Color foreGroundCol = Color.red;
    
    /**backGroundCol variable of StatusBar object */
    private Color backGroundCol = new Color(0.0f, 0.0f, 0.0f, 0.96f);
    
    
    /**Constructor*/
    
    
    /**
     * StatusBar(String string, int i, Border border)
     * 
     * @param string
     * @param i
     * @param border
     */
    public StatusBar(String string, int i, Border border) {
        super(string, i);
        System.out.println("StatusBar: New Status Bar Created");
        setStatusBorder(border);
        
        this.setBorder(this.border);
        this.setFont(font);
        this.setForeground(foreGroundCol);
        this.setBackground(backGroundCol);
        this.setOpaque(true);
    }

    
    /**Public Protocol*/
    
    
    /**
     * setStatusBorder(Border border)
     * 
     * @param border
     */
    private void setStatusBorder(Border border) {
        this.border = border;
    }

    
    /**
     * setStatusBorder(Border border)
     * 
     * @param border
     */
    private void setStatusFont(Font font) {
        this.font = font;
    }

    
    /**
     * setForeGroundCol(Color foreGroundCol)
     * 
     * @param foreGroundCol
     */
    private void setForeGroundCol(Color foreGroundCol) {
        this.foreGroundCol = foreGroundCol;
    }

    
    /**
     * setBackGroundCol(Color backGroundCol)
     * 
     * @param backGroundCol
     */
    private void setBackGroundCol(Color backGroundCol) {
        this.backGroundCol = backGroundCol;
    }
    
}
