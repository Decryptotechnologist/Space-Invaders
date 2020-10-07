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
public class Enemy1 extends Enemy {
	
    /**Attributes*/
    
//    /**animE1 variable of Enemy1 object */
//    private static final Animation animE1 = new Animation(18, 
//        Texture.en9_0, 
//        Texture.en9_1, 
//        Texture.en9_0, 
//        Texture.en9_1
//    );
    
    
    
    /**Constructor*/
    
    /**
    * Enemy1(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy1 object with a this.x set to x, this.y set to y,
    * this.isDead set to isDead, this.height set to h, this.width set to w,
    * and this.Direction set to DIR
    *
    * @param x - the x coordinate of Enemy1
    * @param y - the y coordinate of Enemy1
    * @param isDead - the isDead boolean of Enemy1
    * @param DIR - the direction of travel(Integer) of Enemy1
    * @param ID - the id reference of an Enemy1 object
    * @param col - the color of an Enemy1 object
    */
    public Enemy1(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en1Direction = DIR;
        this.e1Col = col;
        this.id = ID;
    }

    
    /**Public Protocol*/
    
    /**
    * initE1()
    * 
    * Initialises a row of 11 Enemy1 objects and their linked Rectangle object
    * into two separate lists
    */
    public static void initE1() {
        if(Enemy.E1rows < 10){
            int offSet = (10 - Enemy.E1rows)/2;
            for (int t = 0 + offSet; t < Enemy.E1rows + offSet; t++) {
                Enemy1 e1 = new Enemy1(xSpace0 * t + xSpace1, e1_y, false, 0, t, e1_col);
                Enemi1.add(e1);
            }
        } else {
            for (int t = 0; t < Enemy.E1rows; t++) {
                Enemy1 e1 = new Enemy1(xSpace0 * t + xSpace1, e1_y, false, 0, t, e1_col);
                Enemi1.add(e1);
            }
        }
    }


    
    /**
    * moveRight(Enemy1 e1)
    * 
    * Moves the Enemy1 object referenced by id to the right by increasing its x
    * value by EnSpeed (and does the same for the x value of its linked
    * Rectangle) after checking its Direction value is 0(right).
    *
    * @param e1 - the reference of an Enemy1 object (within Enemi1 List)
    */
    public static void moveRight(Enemy1 e1) {
        e1.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(Enemy1 e1)
    * 
    * Moves the Enemy1 object referenced by id to the left by decreasing its x
    * value by EnSpeed (and does the same for the x value of its linked
    * Rectangle) after checking its Direction value is 1(left).
    *
    * @param e1 - the reference of an Enemy1 object (within Enemi1 List)
    */
    public static void moveLeft(Enemy1 e1) {
        e1.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(Enemy1 e1)
    * 
    * Moves the Enemy1 object referenced by id down the screen by increasing
    * its y value by 45 (and does the same for the y value of its linked
    * Rectangle).
    *
    * @param e1 - the reference of an Enemy1 object (within Enemi1 List)
    */
    public static void moveDown(Enemy1 e1) {
        e1.y += yFall;
    }

    
    /**
    * E1Fire(Enemy1 e1)
 
 Fires a bullet, creating a new Enbullet object with Enemy1 objects
 (referenced by id) x and y coordinates as a starting point via
 EnBullet.FireUFO() message
    *
    * @param e1 - the e1 reference of an Enemy1 object (within Enemi1 List)
    */
    public static void E1Fire(Enemy1 e1) {
        EnBullet.FireEn(e1);
    }

    
    /**
    * E1Hit(Enemy1 e1)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode object with Enemy1
    * objects (referenced by id) x and y coordinates as a reference point via
    * EnExplode.EnXDetonate() message
    *
    * Following this Enemy1 objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param e1 - the e1 reference of an Enemy1 object (within Enemi1 List)
    */
    public static void E1Hit(Enemy1 e1) {
        EnExplode.EnXDetonate(e1);
        if(random.nextInt(25) == 0){
            POW.init(e1);
        }
        e1.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy1 Objects
    */
    public static void tick(){
        Enemi1 = Enemy1.getAll();
        
        animE1.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
            
            for (Enemy1 en1 : Enemi1) {
                if(en1.isDead == false){  
                    animE1.render(target, en1.x, en1.y, enScale, en1.width, en1.height, en1.e1Col);
                    if(Display.showBounds){
                        g.setColor(Color.orange);
                        g.drawRect(en1.x, en1.y, en1.getBounds().width, en1.getBounds().height);
                        g.drawString("En1:"+en1.id, en1.x, en1.y-4);
                        
                        if(en1.en1Direction == 0){
                            g.drawString("DIR: R x:"+en1.x, en1.x-6, en1.y+54);
                        } else if(en1.en1Direction == 1){
                            g.drawString("DIR: L x:"+en1.x, en1.x-6, en1.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en1.y, en1.x-6, en1.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy1 objects referenced by Enemi1
    *
    * @return Enemi1
    */
    public static List<Enemy1> getAll() {
        Enemi1A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi1.size(); i++) {
            if (Enemi1.get(i).isDead == false) {
                Enemi1A.add(j, Enemi1.get(i));
                
                j++;
            }
        }
        
        return Enemi1A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi1.clear();
    }
    
    
}
