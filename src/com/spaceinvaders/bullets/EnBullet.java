package com.spaceinvaders.bullets;

import com.spaceinvaders.enemies.*;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * EnBullet objects represent the Enemy bullets in the game
 * represented by a small white strange shape bullets
 * that rain from the sky fired by all 4 sets of Alien invaders. 
 * 
 * @author(s) Ghomez
 */
public class EnBullet extends Bullet {

    /**Attributes*/                                      
    
    /**enBullIMG BufferedImage of EnBullet object*/
    //private static final BufferedImage enBullIMG = new Texture("/Sprites/SI_enemyBullet1_1").getImage();

    
    /**Constructor*/
        
    /**
    * EnBullet(int x, int y, int h, int w, boolean isDead)
    * 
    * Initialises a new EnBullet object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w, this.visible 
    * set to vis
    * 
    * @param x the x coordinate of EnBullet
    * @param y the y coordinate of EnBullet
    * @param h the height of EnBullet
    * @param w the width of EnBullet
    * @param isDead the isDead boolean of EnBullet
    */
    public EnBullet(int x, int y, int h, int w, boolean isDead){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.isDead = isDead;
    }

    
    /**
     * setUp()
     * 
     * Setup Enemy Bullet Objects
     */
    public static void setUp(){
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                enBulletScale = 0.1;
                enBulletXoffs = -2;
                enBulletYoffs = 0;
            
                break;
                
            case 480:
                enBulletScale = 0.4;
                enBulletXoffs = 0;
                enBulletYoffs = 0;
            
                break;
                
            case 604:
                enBulletScale = 0.3;
                enBulletXoffs = 3;
                enBulletYoffs = 15;
                
                break;
                
            default:
                enBulletScale = 0.3;
                enBulletXoffs = 3;
                enBulletYoffs = 15;
                
                break;
                
        }
            
    }
    
    
    /**
    * FireEn(Enemy en)
    * 
    * Fires a bullet, creating a new Enbullet 
    * object with Enemy objects (referenced 
    * by id) x and y coordinates as a starting 
    * point
    * 
    * @param en a reference to an Enemy object
    */
    public static void FireEn(Enemy en){
        //Create New EnBullet
        EnBullet eb = new EnBullet((int) en.x + 3, (int) en.y + 15, w, h, false);
        //Add EnBullet to EnBull List
        EnBull.add(eb);
    }
    
    
    /**
    * move(EnBullet eB)
    * 
    * Moves each of the EnBullet objects (depending how
    * many EnBullet objects remain in EnBulletz List) 
    * after checking that the EnBullet object isDead 
    * value is false and visible value is true.
    * 
    * @param eB - the eB reference of an EnBullet object (within EnBulletz List)
    */
    public static void move(EnBullet eB){
        if(eB.isDead == false){
            eB.y += bulletSpeed;
        }
    }

    
    /**
    * EnBHit(EnBullet eB)
    * 
    * EnBullet objects (referenced by id) 
    * isDead value is changed to false 
    * and true respectively. 
    * 
    * @param eB the eB reference of an EnBullet object (within EnBulletz List)
    */
    public static void EnBHit(EnBullet eB){
	eB.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates EnBullet Objects
    */
    public static void tick(){
        //Update All Enemy Bullets
        EnBull = EnBullet.getAll();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * Renders/Repaints Enemy Bullet Objects
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
            //Draw EnBullets
            for(EnBullet enB : EnBull) {
                if(enB.isDead == false){
                    if(Display.showBounds){
                        //Draw Bounds
                        g.setColor(Color.red);
                        g.drawRect(enB.x+4, enB.y, enB.width/3, enB.height);
                    }
                    //Render EnBullets
                    target.scaleDraw(Texture.enBull, enBulletScale, enB.x+enBulletXoffs, enB.y+enBulletYoffs, 0, 0, 64, 64, Bullet.EnBullCol);
                }
            }
        }
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the EnBullet 
    * objects referenced by EnBulletz
    * 
    * @return EnBulletz
    */
    public static List<EnBullet> getAll() {
        //Return All Enemy Bullets
	return EnBull;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        //Clear All Enemy Bullets
        EnBull.clear();
    }
    
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
    public Rectangle getBounds(){
      return new Rectangle(this.x+4, this.y, this.width/3, this.height);
    }
    
}
