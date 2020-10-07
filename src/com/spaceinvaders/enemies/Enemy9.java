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
public class Enemy9 extends Enemy {
    
    /**Attributes*/
    
//    /**animE9 variable of Enemy9 object */
//    private static final Animation animE9 = new Animation(18, 
//        Texture.en9_0, 
//        Texture.en9_1, 
//        Texture.en9_0, 
//        Texture.en9_1
//    );
//    
//    /**en9TouchRight variable of Enemy9 object */
//    public static boolean en9TouchRight;
//    
//    /**en9TouchLeft variable of Enemy9 object */
//    public static boolean en9TouchLeft;
    
    
    /**Constructor*/
        
    /**
    * Enemy9(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy9 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy9
    * @param y - the y coordinate of Enemy9
    * @param isDead - the isDead boolean of Enemy9
    * @param DIR - the direction of travel(Integer) of Enemy9
    * @param ID - the id reference of an Enemy9 object
    * @param col - the color of an Enemy9 object
    */
    public Enemy9(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en9Direction = DIR;
        this.e9Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE9()
    * 
    * Initialises a row of 8 Enemy9 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE9() {
        if(Enemy.E9rows < 10){
            int offSet = (10 - Enemy.E9rows)/2;
            for (int t = 0 + offSet; t < Enemy.E9rows + offSet; t++) {
                Enemy9 e9 = new Enemy9(xSpace0 * t + xSpace1, e9_y, false, 0, t, e9_col);
                Enemi9.add(e9);
            }
        } else {
            for (int t = 0; t < Enemy.E9rows; t++) {
                Enemy9 e9 = new Enemy9(xSpace0 * t + xSpace1, e9_y, false, 0, t, e9_col);
                Enemi9.add(e9);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy9 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e9 - the id reference of an Enemy9 object (within Enemi9 List)
    */
    public static void moveRight(Enemy9 e9) {
        e9.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy9 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e9 - the id reference of an Enemy9 object (within Enemi9 List)
    */
    public static void moveLeft(Enemy9 e9) {
        e9.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy9 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e9 - the id reference of an Enemy9 object (within Enemi9 List)
    */
    public static void moveDown(Enemy9 e9) {
        e9.y += yFall;
    }

    
    /**
    * E9Fire(Enemy9 e9)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy9 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e9 - the e9 reference of an Enemy9 object (within Enemi9 List)
    */
    public static void E9Fire(Enemy9 e9) {
        EnBullet.FireEn(e9);
    }

    
    /**
    * E9Hit(Enemy9 e9)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy9 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy9 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e9 - the e9 reference of an Enemy9 object (within Enemi9 List)
    */
    public static void E9Hit(Enemy9 e9) {
        EnExplode.EnXDetonate(e9);
        if(random.nextInt(25) == 0){
            POW.init(e9);
        }
        e9.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy9 Objects
    */
    public static void tick(){
        Enemi9 = Enemy9.getAll();
        
        animE9.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for(Enemy9 en9 : Enemi9) {
                if(en9.isDead == false){
                    animE9.render(target, en9.x, en9.y, enScale, en9.width, en9.height, en9.e9Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en9.x, en9.y, en9.getBounds().width, en9.getBounds().height);
                        g.drawString("En9:"+en9.id, en9.x, en9.y-4);
                        
                        if(en9.en9Direction == 0){
                            g.drawString("DIR: R x:"+en9.x, en9.x-6, en9.y+54);
                        } else if(en9.en9Direction == 1){
                            g.drawString("DIR: L x:"+en9.x, en9.x-6, en9.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en9.y, en9.x-6, en9.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy9 
 objects referenced by Enemi9
    * 
    * @return Enemi9
    */
    public static List<Enemy9> getAll() {
        Enemi9A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi9.size(); i++) {
            if (Enemi9.get(i).isDead == false) {
                Enemi9A.add(j, Enemi9.get(i));
                
                j++;
            }
        }
        
        return Enemi9A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi9.clear();
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
