/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.explodes;

import com.spaceinvaders.graphics.Render;
import com.spaceinvaders.graphics.Texture;
import com.spaceinvaders.pkg2018.Game;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class CreditsExplode extends Explode {
    
    /**Constructor*/
    
    
    /**
    * CreditsExplode(int x, int y, int h, int w, boolean isDead)
    * 
    * Initialises a new BRCExplode object with a this.x set to x,
    * this.y set to y, this.height set to h, this.width set 
    * to w, this.isDead set to isDead.
    * 
    * @param x the x coordinate of BRCExplode
    * @param y the y coordinate of BRCExplode
    * @param h the height of BRCExplode
    * @param w the width of BRCExplode 
    * @param isDead the isDead boolean of BRCExplode
    */
    public CreditsExplode(int x, int y, int h, int w, boolean isDead){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.isDead = isDead;
    }

    
    /**Public Protocol*/
        
    /**
     * setUp()
     * 
     */
    public static void setUp(){
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                Creditsx_w = 4;//(100/18) /4;//6;
                Creditsx_h = 6;//(135/12) /4;//8;

                CreditseXScale_a = 0.08;
                CreditseXScale_b = 0.09;
                CreditseXoffs_a = -5;
                CreditseXoffs_b = -2;
                CreditseYoffs_b = -5;
            
                break;
            case 480:
                Creditsx_w = 100/18;//6;
                Creditsx_h = 135/12;//8;

                CreditseXScale_a = 0.16;
                CreditseXScale_b = 0.18;
            
                break;
                
            case 604:
                Creditsx_w = 100/18;//6;
                Creditsx_h = 135/12;//8;

                CreditseXScale_a = 0.16;
                CreditseXScale_b = 0.18;
            
                break;
                
            default:
                Creditsx_w = 100/18;//6;
                Creditsx_h = 135/12;//8;

                CreditseXScale_a = 0.16;
                CreditseXScale_b = 0.18;
                
                break;
        }
        
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints CreditsExplode Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
        //Draw BECExplode
        for (CreditsExplode CreditsXp1 : CreditsXP) {
            if (CreditsXp1.isDead == false) {
                target.scaleDraw(Texture.BRCExplode, BRCeXScale_a, CreditsXp1.x+BRCeXoffs_a, CreditsXp1.y, 0,0,64,64, 0x000000);
                target.scaleDraw(Texture.BRCExplode, BRCeXScale_b, CreditsXp1.x+BRCeXoffs_b, CreditsXp1.y+BRCeYoffs_b, 0,0,64,64, 0x000000);
            }
        }
    }
    
    
    /**
    * tick()
    * 
    * Updates CreditsExplode Objects
    */
    public static void tick(){
        CreditsXP = CreditsExplode.getAll();
        CreditsXPR = CreditsExplode.getAllRect();
    }
    
    
    /**
    * CreditsXDetonate(Rectangle p1Bull)
    * 
    * Fires a CreditsExplode Explosion, creating a new CreditsExplode 
    * object with Player Bullet objects x and y coordinates as a 
    * reference point
    * 
    * 
    * @param p1Bull - the Player Bullet Rectangle object
    */
    public static void CreditsXDetonate(Rectangle p1Bull){
        CreditsExplode Creditsx = new CreditsExplode((int) p1Bull.x, (int) p1Bull.y, BRCx_w, BRCx_h, false);
        boolean oldBRCx = CreditsXP.contains(Creditsx);
        if(!oldBRCx){
            CreditsXP.add(Creditsx);
            CreditsXPR.add(Creditsx.getBounds());
        }
    }

    
    /**
    * CreditsEHit(int id)
    * 
    * CreditsExplode objects (referenced by id) 
    * isDead value is changed to
    * true. 
    * 
    * @param id - the id reference of an CreditsExplode object
    */
    public void CreditsEHit(int id){
	CreditsXP.get(id).isDead = true;
        CreditsXP.remove(id);
        CreditsXPR.remove(id);
    }

    
    /**
    * getAll()
    * 
    * Returns the List of the CreditsExplode 
    * objects referenced by CreditsExplodez
    * 
    * @return CreditsXPA
    */
    public static List<CreditsExplode> getAll() {
        CreditsXPA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < CreditsXP.size(); i++) {
            if (CreditsXP.get(i).isDead == false) {
                CreditsXPA.add(j, CreditsXP.get(i));
                j++;
            }
        }
        
        return CreditsXPA;
    }
    
    
    /**
    * getAllRect()
    * 
    * Returns the List of the Rectangles 
    * referenced by CreditsXPR 
    * 
    * @return CreditsXPR
    */	
    public static List<Rectangle> getAllRect() {
        CreditsXPR.clear();
	return CreditsXPR;
    }
    
    
    /**
    * Clears the Lists of the CreditsExplode objects
    * 
    */    
    public static void clearAll() {
        CreditsXP.clear();
        CreditsXPR.clear();
    }

    
    /**
    * getBounds()
    * 
    * @return new Rectangle
    */ 
    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
