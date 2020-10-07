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
public class Enemy8 extends Enemy {
    
    /**Attributes*/
    
//    /**animE8 variable of Enemy8 object */
//    private static final Animation animE8 = new Animation(18, 
//        Texture.en8_0, 
//        Texture.en8_1, 
//        Texture.en8_0, 
//        Texture.en8_1
//    );

    
    
    
    
    /**Constructor*/
        
    /**
    * Enemy8(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy8 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy8
    * @param y - the y coordinate of Enemy8
    * @param isDead - the isDead boolean of Enemy8
    * @param DIR - the direction of travel(Integer) of Enemy8
    * @param ID - the id reference of an Enemy8 object
    * @param col - the color of an Enemy8 object
    */
    public Enemy8(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en8Direction = DIR;
        this.e8Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE8()
    * 
    * Initialises a row of 8 Enemy8 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE8() {
        if(Enemy.E8rows < 10){
            int offSet = (10 - Enemy.E8rows)/2;
            for (int t = 0 + offSet; t < Enemy.E8rows + offSet; t++) {
                Enemy8 e8 = new Enemy8(xSpace0 * t + xSpace1, e8_y, false, 0, t, e8_col);
                Enemi8.add(e8);
            }
        } else {
            for (int t = 0; t < Enemy.E8rows; t++) {
                Enemy8 e8 = new Enemy8(xSpace0 * t + xSpace1, e8_y, false, 0, t, e8_col);
                Enemi8.add(e8);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy8 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e8 - the id reference of an Enemy8 object (within Enemi8 List)
    */
    public static void moveRight(Enemy8 e8) {
        e8.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy8 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e8 - the id reference of an Enemy8 object (within Enemi8 List)
    */
    public static void moveLeft(Enemy8 e8) {
        e8.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy8 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e8 - the id reference of an Enemy8 object (within Enemi8 List)
    */
    public static void moveDown(Enemy8 e8) {
        e8.y += yFall;
    }

    
    /**
    * E8Fire(Enemy8 e8)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy8 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e8 - the e8 reference of an Enemy8 object (within Enemi8 List)
    */
    public static void E8Fire(Enemy8 e8) {
        EnBullet.FireEn(e8);
    }

    
    /**
    * E8Hit(Enemy8 e8)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy8 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy8 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e8 - the e8 reference of an Enemy8 object (within Enemi8 List)
    */
    public static void E8Hit(Enemy8 e8) {
        EnExplode.EnXDetonate(e8);
        if(random.nextInt(25) == 0){
            POW.init(e8);
        }
        e8.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy8 Objects
    */
    public static void tick(){
        Enemi8 = Enemy8.getAll();
        
        animE8.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for(Enemy8 en8 : Enemi8) {
                if(en8.isDead == false){
                    animE8.render(target, en8.x, en8.y, enScale, en8.width, en8.height, en8.e8Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en8.x, en8.y, en8.getBounds().width, en8.getBounds().height);
                        g.drawString("En8:"+en8.id, en8.x, en8.y-4);
                        
                        if(en8.en8Direction == 0){
                            g.drawString("DIR: R x:"+en8.x, en8.x-6, en8.y+54);
                        } else if(en8.en8Direction == 1){
                            g.drawString("DIR: L x:"+en8.x, en8.x-6, en8.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en8.y, en8.x-6, en8.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy8 
 objects referenced by Enemi8
    * 
    * @return Enemi8
    */
    public static List<Enemy8> getAll() {
        Enemi8A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi8.size(); i++) {
            if (Enemi8.get(i).isDead == false) {
                Enemi8A.add(j, Enemi8.get(i));
                
                j++;
            }
        }
        
        return Enemi8A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi8.clear();
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
