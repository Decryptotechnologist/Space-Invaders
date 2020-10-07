package com.spaceinvaders.explodes;

import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.Game;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
* BRCExplode objects represent the user in the game
* represented by a small green spaceship that 
* fires bullets at aliens
* 
* @author(s) Ghomez
*/
public class BRCExplode extends Explode {

    private int col;

    
    /**Constructor*/
    
    
    /**
    * BRCExplode(int x, int y, int h, int w, boolean isDead)
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
    public BRCExplode(int x, int y, int h, int w, boolean isDead){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.isDead = isDead;
        this.col = 0x000000;
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
                BRCx_w = 4;//(100/18) /4;//6;
                BRCx_h = 6;//(135/12) /4;//8;

                BRCeXScale_a = 0.08;
                BRCeXScale_b = 0.09;
                BRCeXoffs_a = -5;
                BRCeXoffs_b = -2;
                BRCeYoffs_b = -5;
            
                break;
            case 480:
                BRCx_w = 100/18;//6;
                BRCx_h = 135/12;//8;

                BRCeXScale_a = 0.16;
                BRCeXScale_b = 0.18;
            
                break;
                
            case 604:
                BRCx_w = 100/18;//6;
                BRCx_h = 135/12;//8;

                BRCeXScale_a = 0.16;
                BRCeXScale_b = 0.18;
            
                break;
                
            default:
                BRCx_w = 100/18;//6;
                BRCx_h = 135/12;//8;

                BRCeXScale_a = 0.16;
                BRCeXScale_b = 0.18;
                
                break;
        }
        
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints BRCExplode Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
        //Draw BECExplode
        for (BRCExplode BRCXp1 : BRCXP) {
            if (BRCXp1.isDead == false) {
                target.scaleDraw(Texture.BRCExplode, BRCeXScale_a, BRCXp1.x+BRCeXoffs_a, BRCXp1.y, 0,0,64,64, BRCXp1.col);
                target.scaleDraw(Texture.BRCExplode, BRCeXScale_b, BRCXp1.x+BRCeXoffs_b, BRCXp1.y+BRCeYoffs_b, 0,0,64,64, BRCXp1.col);
            }
        }
    }
    
    
    /**
    * tick()
    * 
    * Updates BRCExplode Objects
    */
    public static void tick(){
        BRCXP = BRCExplode.getAll();
        BRCXPR = BRCExplode.getAllRect();
    }
    
    
    /**
    * BRCXDetonate(Rectangle p1Bull)
    * 
    * Fires a BRCExplode Explosion, creating a new BRCExplode 
    * object with Player Bullet objects x and y coordinates as a 
    * reference point
    * 
    * 
    * @param p1Bull - the Player Bullet or EnBullet Rectangle object
    */
    public static void BRCXDetonate(Rectangle p1Bull){
        BRCExplode BRCx = new BRCExplode((int) p1Bull.x, (int) p1Bull.y, BRCx_w, BRCx_h, false);
        boolean oldBRCx = BRCXP.contains(BRCx);
        if(!oldBRCx){
            BRCXP.add(BRCx);
            BRCXPR.add(BRCx.getBounds());
        }
    }

    
    /**
    * BRCEHit(int id)
    * 
    * BRCExplode objects (referenced by id) 
    * isDead value is changed to
    * true. 
    * 
    * @param id - the id reference of an BRCExplode object
    */
    public void BRCEHit(int id){
	BRCXP.get(id).isDead = true;
        BRCXP.remove(id);
        BRCXPR.remove(id);
    }

    
    /**
    * getAll()
    * 
    * Returns the List of the BRCExplode 
    * objects referenced by BRCExplodez
    * 
    * @return BRCExplodez
    */
    public static List<BRCExplode> getAll() {
        BRCXPA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < BRCXP.size(); i++) {
            if (BRCXP.get(i).isDead == false) {
                BRCXPA.add(j, BRCXP.get(i));
                j++;
            }
        }
        
        return BRCXPA;
    }
    
    
    /**
    * getAllRect()
    * 
    * Returns the List of the Rectangles 
    * referenced by BRCExplodeRect 
    * 
    * @return BRCExplodeRect
    */	
    public static List<Rectangle> getAllRect() {
        BRCXPR.clear();
	return BRCXPR;
    }
    
    
    /**
    * Clears the Lists of the BRCExplode objects
    * 
    */    
    public static void clearAll() {
        BRCXP.clear();
        BRCXPR.clear();
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
