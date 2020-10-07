/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.ui;

import com.spaceinvaders.utils.Fonts;
import java.awt.*;

/**
 * @author Ghomez
 * 
 */
public class Button extends Rectangle {

    /**Attributes*/
    
    /**text variable of Button object*/
    private final String text;
    
    /**textX variable of Button object*/
    private final int textX;
    
    /**textY variable of Button object*/
    private final int textY;
    
    /**font variable of Button object*/
    private final Font font;
    
    /**selectedFont variable of Button object*/
    private final Font selectedFont;
    
    /**color variable of Button object*/
    private final Color color;
    
    /**selectedColor variable of Button object*/
    private final Color selectedColor;
    
    /**selected boolean of Button object*/
    private boolean selected;

    
    /**Constructor*/
    
    
    /**
    * Button(String text, int textX, int textY, Font font, Font selectedFont, Color color, Color selectedColor)
    * 
    * Initialises a new Button object
    * 
    * @param text
    * @param textX
    * @param textY
    * @param font
    * @param selectedFont
    * @param color
    * @param selectedColor
    */
    public Button(String text, int textX, int textY, Font font, Font selectedFont, Color color, Color selectedColor) {
        this.text = text;
        this.textX = textX;
        this.textY = textY;
        this.font = font;
        this.selectedFont = selectedFont;
        this.color = color;
        this.selectedColor = selectedColor;
    }
    
    
    /**Public Protocol*/
    
    
    /**
    * setSelected(boolean selected)
    * 
    * @param selected
    */
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
    
    /**
     * render(Graphics2D g)
     * 
     * Renders/Repaints Button Objects
     * 
     * @param g
     */
    public void render(Graphics2D g){
        if(selected){
            Fonts.drawString(g, selectedFont, selectedColor, text, textX, textY);
        } else {
            Fonts.drawString(g, font, color, text, textX, textY);
        }
        FontMetrics fm = g.getFontMetrics();
        this.x = textX - 10;// (Display.getGameWidth() - fm.stringWidth(text)) / 2;
        this.y = 15 + textY - fm.getHeight();
        this.width = (int) ((int) fm.stringWidth(text)*1.2);
        this.height = fm.getHeight() + 5;
        g.drawRect(x, y, width, height);
    }
    
}
