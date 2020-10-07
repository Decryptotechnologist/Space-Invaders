/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.enemies;

import com.spaceinvaders.bullets.EnBullet;
import com.spaceinvaders.explodes.EnExplode;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.powerup.POW;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class Enemy7 extends Enemy {
    
    /**Attributes*/
    
//    /**animE7 variable of Enemy7 object */
//    private static final Animation animE7 = new Animation(18, 
//        Texture.en7_0, 
//        Texture.en7_1, 
//        Texture.en7_0, 
//        Texture.en7_1
//    );

    
    
    
    /**Constructor*/
        
    /**
    * Enemy7(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy7 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy7
    * @param y - the y coordinate of Enemy7
    * @param isDead - the isDead boolean of Enemy7
    * @param DIR - the direction of travel(Integer) of Enemy7
    * @param ID - the id reference of an Enemy7 object
    * @param col - the color of an Enemy7 object
    */
    public Enemy7(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en7Direction = DIR;
        this.e7Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE7()
    * 
    * Initialises a row of 8 Enemy7 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE7() {
        if(Enemy.E7rows < 10){
            int offSet = (10 - Enemy.E7rows)/2;
            for (int t = 0 + offSet; t < Enemy.E7rows + offSet; t++) {
                Enemy7 e7 = new Enemy7(xSpace0 * t + xSpace1, e7_y, false, 0, t, e7_col);
                Enemi7.add(e7);
            }
        } else {
            for (int t = 0; t < Enemy.E7rows; t++) {
                Enemy7 e7 = new Enemy7(xSpace0 * t + xSpace1, e7_y, false, 0, t, e7_col);
                Enemi7.add(e7);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy7 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e7 - the id reference of an Enemy7 object (within Enemi7 List)
    */
    public static void moveRight(Enemy7 e7) {
        e7.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy7 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e7 - the id reference of an Enemy7 object (within Enemi7 List)
    */
    public static void moveLeft(Enemy7 e7) {
        e7.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy7 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e7 - the id reference of an Enemy7 object (within Enemi7 List)
    */
    public static void moveDown(Enemy7 e7) {
        e7.y += yFall;
    }

    
    /**
    * E7Fire(Enemy7 e7)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy7 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e7 - the e7 reference of an Enemy7 object (within Enemi7 List)
    */
    public static void E7Fire(Enemy7 e7) {
        EnBullet.FireEn(e7);
    }

    
    /**
    * E7Hit(Enemy7 e7)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy7 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy7 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e7 - the e7 reference of an Enemy7 object (within Enemi7 List)
    */
    public static void E7Hit(Enemy7 e7) {
        EnExplode.EnXDetonate(e7);
        if(random.nextInt(25) == 0){
            POW.init(e7);
        }
        e7.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy7 Objects
    */
    public static void tick(){
        Enemi7 = Enemy7.getAll();
        
        animE7.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for(Enemy7 en7 : Enemi7) {
                if(en7.isDead == false){
                    animE7.render(target, en7.x, en7.y, enScale, en7.width, en7.height, en7.e7Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en7.x, en7.y, en7.getBounds().width, en7.getBounds().height);
                        g.drawString("En7:"+en7.id, en7.x, en7.y-4);
                        
                        if(en7.en7Direction == 0){
                            g.drawString("DIR: R x:"+en7.x, en7.x-6, en7.y+54);
                        } else if(en7.en7Direction == 1){
                            g.drawString("DIR: L x:"+en7.x, en7.x-6, en7.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en7.y, en7.x-6, en7.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy7 
 objects referenced by Enemi7
    * 
    * @return Enemi7
    */
    public static List<Enemy7> getAll() {
        Enemi7A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi7.size(); i++) {
            if (Enemi7.get(i).isDead == false) {
                Enemi7A.add(j, Enemi7.get(i));
                
                j++;
            }
        }
        
        return Enemi7A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi7.clear();
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
