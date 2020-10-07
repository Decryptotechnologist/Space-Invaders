package com.spaceinvaders.enemies;

import com.spaceinvaders.bullets.EnBullet;
import com.spaceinvaders.explodes.EnExplode;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.util.List;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.powerup.POW;
import java.util.ArrayList;

/**
 * Enemy2 objects represent the Second middle
 * row of enemies to which there are 8 of, at 
 * the start of the game/level 1 each with 
 * their own collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class Enemy2 extends Enemy{

    /**Attributes*/
    
//    /**animE2 variable of Enemy2 object */
//    private static final Animation animE2 = new Animation(18, 
//        Texture.en2_0, 
//        Texture.en2_1, 
//        Texture.en2_0, 
//        Texture.en2_1
//    );
    
    
    
    /**Constructor*/
       
    /**
    * Enemy2(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy2 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w, this.visible 
    * set to vis
    * 
    * @param x - the x coordinate of Enemy2
    * @param y - the y coordinate of Enemy2
    * @param isDead - the isDead boolean of Enemy2
    * @param DIR - the direction of travel(Integer) of Enemy2
    * @param ID - the id reference of an Enemy2 object
    * @param col - the color of an Enemy2 object
    */
    public Enemy2(int x, int y, boolean isDead, int DIR, int ID, int col){
	this.x = x;
	this.y = y;
	this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en2Direction = DIR;
        this.e2Col = col;
        this.id = ID;
    }
    
	
    /**Public Protocol*/
        
    
    /**
    * initE2()
    * 
    * Initialises a row of 8 Enemy2 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE2(){
        if(Enemy.E2rows < 10){
            int offSet = (10 - Enemy.E2rows)/2;
            for (int t = 0 + offSet; t < Enemy.E2rows + offSet; t++) {
                Enemy2 e2 = new Enemy2(xSpace0 * t + xSpace1, e2_y, false, 0, t, e2_col);
                Enemi2.add(e2);
            }
        } else {
            for(int t = 0; t < Enemy.E2rows; t++) {
                Enemy2 e2 = new Enemy2(xSpace0 * t + xSpace1, e2_y, false, 0, t, e2_col);
                Enemi2.add(e2);
            }
        }
    }

    
    /**
    * moveRight(Enemy2 e2)
    * 
    * Moves the Enemy2 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e2 - the id reference of an Enemy1 object (within Enemi2 List)
    */
    public static void moveRight(Enemy2 e2){
        e2.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(Enemy2 e2)
    * 
    * Moves the Enemy2 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e2 - the id reference of an Enemy2 object (within Enemi2 List)
    */
    public static void moveLeft(Enemy2 e2){
        e2.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(Enemy2 e2)
    * 
    * Moves the Enemy2 object referenced by id 
    * down the screen by increasing its y value by 
    * 35 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e2 - the id reference of an Enemy2 object (within Enemi2 List)
    */
    public static void moveDown(Enemy2 e2) {
        e2.y += yFall;
    }

	
    /**
    * E2Fire(Enemy2 e2)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy2 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e2 - the e2 reference of an Enemy2 object (within Enemi2 List)
    */
    public static void E2Fire(Enemy2 e2) {
        EnBullet.FireEn(e2);
    }

    
    /**
    * E2Hit(Enemy2 e2)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy2 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy2 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e2 - the e2 reference of an Enemy2 object (within Enemi2 List)
    */
    public static void E2Hit(Enemy2 e2) {
        EnExplode.EnXDetonate(e2);
        if(random.nextInt(25) == 0){
            POW.init(e2);
        }
        e2.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy2 Objects
    */
    public static void tick(){
        Enemi2 = Enemy2.getAll();
        
        animE2.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){        
            
            for(Enemy2 en2 : Enemi2) {
                if(en2.isDead == false){ 
                    animE2.render(target, en2.x, en2.y, enScale, en2.width, en2.height, en2.e2Col);
                    if(Display.showBounds){
                        g.setColor(Color.magenta);
                        g.drawRect(en2.x, en2.y, en2.getBounds().width, en2.getBounds().height);
                        g.drawString("En2:"+en2.id, en2.x, en2.y-4);
                        
                        if(en2.en2Direction == 0){
                            g.drawString("DIR: R x:"+en2.x, en2.x-6, en2.y+54);
                        } else if(en2.en2Direction == 1){
                            g.drawString("DIR: L x:"+en2.x, en2.x-6, en2.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en2.y, en2.x-6, en2.y+54);
                        }
                    }
                }
            }
            
        }
    }
    
    
    
    /**
    * getAll1()
 
 Returns the List of the Enemy2 
 objects referenced by Enemi2
    * 
    * @return Enemi2
    */
    public static List<Enemy2> getAll() {
        Enemi2A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi2.size(); i++) {
            if (Enemi2.get(i).isDead == false) {
                Enemi2A.add(j, Enemi2.get(i));
                
                j++;
            }
        }
        
        return Enemi2A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi2.clear();
    }
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
//    public Rectangle getBounds() {
//      return new Rectangle(this.x, this.y, 40, 40);
//    }
    
}
