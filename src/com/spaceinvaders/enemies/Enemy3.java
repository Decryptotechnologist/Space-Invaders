package com.spaceinvaders.enemies;

import com.spaceinvaders.bullets.EnBullet;
import com.spaceinvaders.explodes.EnExplode;
import com.spaceinvaders.graphics.*;
import java.awt.*;
import java.util.List;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.powerup.POW;
import java.util.ArrayList;

/**
 * Enemy3 objects represent the bottom lower-most
 * row of enemies to which there are 8 of, at 
 * the start of the game/level 1 each with 
 * their own collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class Enemy3 extends Enemy {
	
    /**Attributes*/
    
    /**animE3 variable of Enemy3 object */
//    private static final Animation animE3 = new Animation(18, 
//        Texture.en3_0, 
//        Texture.en3_1, 
//        Texture.en3_0, 
//        Texture.en3_1
//    );

    
    
    
    /**Constructor*/
        
    /**
    * Enemy3(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy3 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy3
    * @param y - the y coordinate of Enemy3
    * @param isDead - the isDead boolean of Enemy3
    * @param DIR - the direction of travel(Integer) of Enemy3
    * @param ID - the id reference of an Enemy3 object
    * @param col - the color of an Enemy3 object
    */
    public Enemy3(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en3Direction = DIR;
        this.e3Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE3()
    * 
    * Initialises a row of 8 Enemy3 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE3() {
        if(Enemy.E3rows < 10){
            int offSet = (10 - Enemy.E3rows)/2;
            for (int t = 0 + offSet; t < Enemy.E3rows + offSet; t++) {
                Enemy3 e3 = new Enemy3(xSpace0 * t + xSpace1, e3_y, false, 0, t, e3_col);
                Enemi3.add(e3);
            }
        } else {
            for (int t = 0; t < Enemy.E3rows; t++) {
                Enemy3 e3 = new Enemy3(xSpace0 * t + xSpace1, e3_y, false, 0, t, e3_col);
                Enemi3.add(e3);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy3 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e3 - the id reference of an Enemy3 object (within Enemi3 List)
    */
    public static void moveRight(Enemy3 e3) {
        e3.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy3 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e3 - the id reference of an Enemy3 object (within Enemi3 List)
    */
    public static void moveLeft(Enemy3 e3) {
        e3.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy3 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e3 - the id reference of an Enemy3 object (within Enemi3 List)
    */
    public static void moveDown(Enemy3 e3) {
        e3.y += yFall;
    }

    
    /**
    * E3Fire(Enemy3 e3)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy3 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e3 - the e3 reference of an Enemy3 object (within Enemi3 List)
    */
    public static void E3Fire(Enemy3 e3) {
        EnBullet.FireEn(e3);
    }

    
    /**
    * E3Hit(Enemy3 e3)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy3 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy3 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e3 - the e3 reference of an Enemy3 object (within Enemi3 List)
    */
    public static void E3Hit(Enemy3 e3) {
        EnExplode.EnXDetonate(e3);
        if(random.nextInt(25) == 0){
            POW.init(e3);
        }
        e3.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy3 Objects
    */
    public static void tick(){
        Enemi3 = Enemy3.getAll();
        
        animE3.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for (Enemy3 en3 : Enemi3) {
                if(en3.isDead == false){
                    animE3.render(target, en3.x, en3.y, enScale, en3.width, en3.height, en3.e3Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en3.x, en3.y, en3.getBounds().width, en3.getBounds().height);
                        g.drawString("En3:"+en3.id, en3.x, en3.y-4);
                        
                        if(en3.en3Direction == 0){
                            g.drawString("DIR: R x:"+en3.x, en3.x-6, en3.y+54);
                        } else if(en3.en3Direction == 1){
                            g.drawString("DIR: L x:"+en3.x, en3.x-6, en3.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en3.y, en3.x-6, en3.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy3 
 objects referenced by Enemi3
    * 
    * @return Enemi3
    */
    public static List<Enemy3> getAll() {
        Enemi3A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi3.size(); i++) {
            if (Enemi3.get(i).isDead == false) {
                Enemi3A.add(j, Enemi3.get(i));
                
                j++;
            }
        }
        
        return Enemi3A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi3.clear();
    }
    
    
}
