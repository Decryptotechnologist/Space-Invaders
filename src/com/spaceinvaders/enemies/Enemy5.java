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
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class Enemy5 extends Enemy {
    
    /**Attributes*/
    
//    /**animE5 variable of Enemy5 object */
//    private static final Animation animE5 = new Animation(18, 
//        Texture.en5_0, 
//        Texture.en5_1, 
//        Texture.en5_0, 
//        Texture.en5_1
//    );

    
    
    
    /**Constructor*/
        
    /**
    * Enemy5(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy5 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy5
    * @param y - the y coordinate of Enemy5
    * @param isDead - the isDead boolean of Enemy5
    * @param DIR - the direction of travel(Integer) of Enemy5
    * @param ID - the id reference of an Enemy5 object
    * @param col - the color of an Enemy5 object
    */
    public Enemy5(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en5Direction = DIR;
        this.e5Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE5()
    * 
    * Initialises a row of 8 Enemy5 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE5() {
        if(Enemy.E5rows < 10){
            int offSet = (10 - Enemy.E5rows)/2;
            for (int t = 0 + offSet; t < Enemy.E5rows + offSet; t++) {
                Enemy5 e5 = new Enemy5(xSpace0 * t + xSpace1, e5_y, false, 0, t, e5_col);
                Enemi5.add(e5);
            }
        } else {
            for (int t = 0; t < Enemy.E5rows; t++) {
                Enemy5 e5 = new Enemy5(xSpace0 * t + xSpace1, e5_y, false, 0, t, e5_col);
                Enemi5.add(e5);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy5 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e5 - the id reference of an Enemy5 object (within Enemi5 List)
    */
    public static void moveRight(Enemy5 e5) {
        e5.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy5 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e5 - the id reference of an Enemy5 object (within Enemi5 List)
    */
    public static void moveLeft(Enemy5 e5) {
        e5.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy5 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e5 - the id reference of an Enemy5 object (within Enemi5 List)
    */
    public static void moveDown(Enemy5 e5) {
        e5.y += yFall;
    }

    
    /**
    * E5Fire(Enemy5 e5)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy5 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e5 - the e5 reference of an Enemy5 object (within Enemi5 List)
    */
    public static void E5Fire(Enemy5 e5) {
        EnBullet.FireEn(e5);
    }

    
    /**
    * E5Hit(Enemy5 e5)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy5 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy5 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e5 - the e5 reference of an Enemy5 object (within Enemi5 List)
    */
    public static void E5Hit(Enemy5 e5) {
        EnExplode.EnXDetonate(e5);
        if(random.nextInt(25) == 0){
            POW.init(e5);
        }
        e5.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy5 Objects
    */
    public static void tick(){
        Enemi5 = Enemy5.getAll();
        
        animE5.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for (Enemy5 en5 : Enemi5) {
                if(en5.isDead == false){
                    animE5.render(target, en5.x, en5.y, enScale, en5.width, en5.height, en5.e5Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en5.x, en5.y, en5.getBounds().width, en5.getBounds().height);
                        g.drawString("En5:"+en5.id, en5.x, en5.y-4);
                        
                        if(en5.en5Direction == 0){
                            g.drawString("DIR: R x:"+en5.x, en5.x-6, en5.y+54);
                        } else if(en5.en5Direction == 1){
                            g.drawString("DIR: L x:"+en5.x, en5.x-6, en5.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en5.y, en5.x-6, en5.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy5 
 objects referenced by Enemi5
    * 
    * @return Enemi5
    */
    public static List<Enemy5> getAll() {
        Enemi5A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi5.size(); i++) {
            if (Enemi5.get(i).isDead == false) {
                Enemi5A.add(j, Enemi5.get(i));
                
                j++;
            }
        }
        
        return Enemi5A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi5.clear();
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
