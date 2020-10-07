/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.explodes;

import com.spaceinvaders.graphics.Render;
import java.awt.Graphics2D;

/**
 *
 * @author Ghomez
 */
public interface ExplodeInterface {
    
    
    
    
    /**Public Protocol*/
    
    /**
     * setUp()
     * 
     */
    //public abstract void setUp();
    
    /**
    * clearAll()
    * 
    * Clears the Lists of the Rectangles 
    * referenced by P1ExplodeRect and
    * P1Explod objects
    * 
    */    
    //public abstract void clearAll();
    
    /**
    * getAll()
    * 
    * Returns the List of the P1Explode 
    * objects referenced by P1Explode
    * 
    * @return P1Explod
    */
    //public abstract List<P1Explode> getAll();
    
    /**
    * P1Detonate()
    * 
    * Fires a Player Explosion, creating a new P1Explode 
    * object with Player objects x and y coordinates as a 
    * reference point
    * 
    * @param p1 - a Player object
    */
    //public abstract void P1Detonate(Player p1);
    
    /**
    * render()
    * 
    * Renders/Repaints P1Explode Objects
    * 
    * @param target
    * @param g
    */
    //public abstract void render(Render target, Graphics2D g);
    
    
    
    /**
    * tick()
    * 
    * Updates Explode Objects
    */
    //public abstract void tick();
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
    //public Rectangle getBounds();
    
    
}
