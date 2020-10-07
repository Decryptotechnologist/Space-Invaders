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
 * Enemy1 objects represent the first top-most
 * row of enemies to which there are 8 of, at 
 * the start of the game/level 1 each with 
 * their own collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class Enemy0 extends Enemy {
	
    /**Attributes*/
    
//    /**animE0 variable of Enemy0 object */
//    private static final Animation animE0 = new Animation(18, 
//        Texture.en1_0, 
//        Texture.en1_1, 
//        Texture.en1_0, 
//        Texture.en1_1
//    );
    
    
    
    
    
    /**Constructor*/
    
    /**
    * Enemy0(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy1 object with a this.x set to x, this.y set to y,
    * this.isDead set to isDead, this.height set to h, this.width set to w,
    * and this.Direction set to DIR
    *
    * @param x - the x coordinate of Enemy0
    * @param y - the y coordinate of Enemy0
    * @param isDead - the isDead boolean of Enemy0
    * @param DIR - the direction of travel(Integer) of Enemy0
    * @param ID - the id reference of an Enemy0 object
    * @param col - the id reference of an Enemy0 object
    */
    public Enemy0(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en0Direction = DIR;
        this.e0Col = col;
        this.id = ID;
    }

    
    /**Public Protocol*/
    
    
    /**
    * initE0()
    * 
    * Initialises a row of 11 Enemy0 objects and their linked Rectangle object
    * into two separate lists
    */
    public static void initE0() { 
        if(Enemy.E0rows < 10){
            int offSet = (10 - Enemy.E0rows)/2;
            for (int t = 0 + offSet; t < Enemy.E0rows + offSet; t++) {
                Enemy0 e0 = new Enemy0(xSpace0 * t + xSpace1, e0_y, false, 0, t, e0_col);
                Enemi0.add(e0);
            }
        } else {
            for (int t = 0; t < Enemy.E0rows; t++) {
                Enemy0 e0 = new Enemy0(xSpace0 * t + xSpace1, e0_y, false, 0, t, e0_col);
                Enemi0.add(e0);
            }
        }
    }
    

    
    /**
    * moveRight(Enemy0 e0)
    * 
    * Moves the Enemy0 object referenced by id to the right by increasing its x
    * value by EnSpeed (and does the same for the x value of its linked
    * Rectangle) after checking its Direction value is 0(right).
    *
    * @param e0 - the reference of an Enemy0 object (within Enemi0 List)
    */
    public static void moveRight(Enemy0 e0) {
        e0.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(Enemy0 e0)
    * 
    * Moves the Enemy0 object referenced by id to the left by decreasing its x
    * value by EnSpeed (and does the same for the x value of its linked
    * Rectangle) after checking its Direction value is 1(left).
    *
    * @param e0 - the id reference of an Enemy0 object (within Enemi0 List)
    */
    public static void moveLeft(Enemy0 e0) {
        e0.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(Enemy0 e0)
    * 
    * Moves the Enemy0 object referenced by id down the screen by increasing
    * its y value by 45 (and does the same for the y value of its linked
    * Rectangle).
    *
    * @param e0 - the id reference of an Enemy0 object (within Enemi0 List)
    */
    public static void moveDown(Enemy0 e0) {
        e0.y += yFall;
    }

    
    /**
    * E0Fire(int id)
 
 Fires a bullet, creating a new Enbullet object with Enemy0 objects
 (referenced by id) x and y coordinates as a starting point via
 EnBullet.FireUFO() message
    *
    * @param e0 - the e0 reference of an Enemy0 object (within Enemi0 List)
    */
    public static void E0Fire(Enemy0 e0) {
        EnBullet.FireEn(e0);
    }

    
    /**
    * E0Hit(Enemy0 e0)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode object with Enemy0
    * objects (referenced by id) x and y coordinates as a reference point via
    * EnExplode.EnXDetonate() message
    *
    * Following this Enemy0 objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param e0 - the e0 reference of an Enemy0 object (within Enemi0 List)
    */
    public static void E0Hit(Enemy0 e0) {
        EnExplode.EnXDetonate(e0);
        if(random.nextInt(25) == 0){
            POW.init(e0);
        }
        e0.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy0 Objects
    */
    public static void tick(){
        Enemi0 = Enemy0.getAll();
        
        animE0.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if(null == Game.aGame.menu){        
            
            for (Enemy0 en0 : Enemi0) {
                if(en0.isDead == false){ 
                    animE0.render(target, en0.x, en0.y, enScale, en0.width, en0.height, en0.e0Col);
                    if(Display.showBounds){
                        g.setColor(Color.blue);
                        g.drawRect(en0.x, en0.y, en0.getBounds().width, en0.getBounds().height);
                        g.drawString("En0:"+en0.id, en0.x, en0.y-4);
                        
                        if(en0.en0Direction == 0){
                            g.drawString("DIR: R x:"+en0.x, en0.x-6, en0.y+54);
                        } else if(en0.en0Direction == 1){
                            g.drawString("DIR: L x:"+en0.x, en0.x-6, en0.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en0.y, en0.x-6, en0.y+54);
                        }
                    }
                }
            }
        
        }
    }
    

    
    /**
    * getAll1()
    * 
    * Returns the List of the Enemy0 objects referenced by Enemi0
    *
    * @return Enemi0
    */
    public static List<Enemy0> getAll() {
        Enemi0A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi0.size(); i++) {
            if (Enemi0.get(i).isDead == false) {
                Enemi0A.add(j, Enemi0.get(i));
                j++;
            }
        }
        
        return Enemi0A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi0.clear();
    }
    
    
}
