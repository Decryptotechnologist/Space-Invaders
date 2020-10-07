/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.enemies;

import com.spaceinvaders.bullets.EnBullet;
import com.spaceinvaders.explodes.EnExplode;
import com.spaceinvaders.graphics.Animation;
import com.spaceinvaders.graphics.Render;
import com.spaceinvaders.graphics.Texture;
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
public class Enemy4 extends Enemy {
    
    /**Attributes*/
    
//    /**animE4 variable of Enemy4 object */
//    private static final Animation animE4 = new Animation(18, 
//        Texture.en4_0, 
//        Texture.en4_1, 
//        Texture.en4_0, 
//        Texture.en4_1
//    );

    
    
    
    /**Constructor*/
        
    /**
    * Enemy4(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy4 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy4
    * @param y - the y coordinate of Enemy4
    * @param isDead - the isDead boolean of Enemy4
    * @param DIR - the direction of travel(Integer) of Enemy4
    * @param ID - the id reference of an Enemy4 object
    * @param col - the color of an Enemy4 object
    */
    public Enemy4(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en4Direction = DIR;
        this.e4Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE4()
    * 
    * Initialises a row of 8 Enemy4 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE4() {
        if(Enemy.E4rows < 10){
            int offSet = (10 - Enemy.E4rows)/2;
            for (int t = 0 + offSet; t < Enemy.E4rows + offSet; t++) {
                Enemy4 e4 = new Enemy4(xSpace0 * t + xSpace1, e4_y, false, 0, t, e4_col);
                Enemi4.add(e4);
            }
        } else {
            for (int t = 0; t < Enemy.E4rows; t++) {
                Enemy4 e4 = new Enemy4(xSpace0 * t + xSpace1, e4_y, false, 0, t, e4_col);
                Enemi4.add(e4);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy4 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e4 - the id reference of an Enemy4 object (within Enemi4 List)
    */
    public static void moveRight(Enemy4 e4) {
        e4.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy4 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e4 - the id reference of an Enemy4 object (within Enemi4 List)
    */
    public static void moveLeft(Enemy4 e4) {
        e4.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy4 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e4 - the id reference of an Enemy4 object (within Enemi4 List)
    */
    public static void moveDown(Enemy4 e4) {
        e4.y += yFall;
    }

    
    /**
    * E4Fire(Enemy4 e4)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy4 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e4 - the e4 reference of an Enemy4 object (within Enemi4 List)
    */
    public static void E4Fire(Enemy4 e4) {
        EnBullet.FireEn(e4);
    }

    
    /**
    * E4Hit(Enemy4 e4)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy4 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy4 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e4 - the e4 reference of an Enemy4 object (within Enemi4 List)
    */
    public static void E4Hit(Enemy4 e4) {
        EnExplode.EnXDetonate(e4);
        if(random.nextInt(25) == 0){
            POW.init(e4);
        }
        e4.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy4 Objects
    */
    public static void tick(){
        Enemi4 = Enemy4.getAll();
        
        animE4.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for (Enemy4 en4 : Enemi4) {
                if(en4.isDead == false){
                    animE4.render(target, en4.x, en4.y, enScale, en4.width, en4.height, en4.e4Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en4.x, en4.y, en4.getBounds().width, en4.getBounds().height);
                        g.drawString("En4:"+en4.id, en4.x, en4.y-4);
                        
                        if(en4.en4Direction == 0){
                            g.drawString("DIR: R x:"+en4.x, en4.x-6, en4.y+54);
                        } else if(en4.en4Direction == 1){
                            g.drawString("DIR: L x:"+en4.x, en4.x-6, en4.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en4.y, en4.x-6, en4.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy4 
 objects referenced by Enemi4
    * 
    * @return Enemi4
    */
    public static List<Enemy4> getAll() {
        Enemi4A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi4.size(); i++) {
            if (Enemi4.get(i).isDead == false) {
                Enemi4A.add(j, Enemi4.get(i));
                
                j++;
            }
        }
        
        return Enemi4A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi4.clear();
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
