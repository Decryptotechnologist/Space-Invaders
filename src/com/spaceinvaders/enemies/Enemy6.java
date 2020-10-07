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
public class Enemy6 extends Enemy {
    
    /**Attributes*/
    
//    /**animE6 variable of Enemy6 object */
//    private static final Animation animE6 = new Animation(18, 
//        Texture.en6_0, 
//        Texture.en6_1, 
//        Texture.en6_0, 
//        Texture.en6_1
//    );

    
    
    
    /**Constructor*/
        
    /**
    * Enemy6(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new Enemy6 object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of Enemy6
    * @param y - the y coordinate of Enemy6
    * @param isDead - the isDead boolean of Enemy6
    * @param DIR - the direction of travel(Integer) of Enemy6
    * @param ID - the id reference of an Enemy6 object
    * @param col - the color of an Enemy6 object
    */
    public Enemy6(int x, int y, boolean isDead, int DIR, int ID, int col) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.en6Direction = DIR;
        this.e6Col = col;
        this.id = ID;
    }
	
	
    /**Public Protocol*/
        
    
    /**
    * initE6()
    * 
    * Initialises a row of 8 Enemy6 objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initE6() {
        if(Enemy.E6rows < 10){
            int offSet = (10 - Enemy.E6rows)/2;
            for (int t = 0 + offSet; t < Enemy.E6rows + offSet; t++) {
                Enemy6 e6 = new Enemy6(xSpace0 * t + xSpace1, e6_y, false, 0, t, e6_col);
                Enemi6.add(e6);
            }
        } else {
            for (int t = 0; t < Enemy.E6rows; t++) {
                Enemy6 e6 = new Enemy6(xSpace0 * t + xSpace1, e6_y, false, 0, t, e6_col);
                Enemi6.add(e6);
            }
        }
    }
    

    
    /**
    * moveRight(int id)
    * 
    * Moves the Enemy6 object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param e6 - the id reference of an Enemy6 object (within Enemi6 List)
    */
    public static void moveRight(Enemy6 e6) {
        e6.x += (int) EnSpeed;
    }

    
    /**
    * moveLeft(int id)
    * 
    * Moves the Enemy6 object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param e6 - the id reference of an Enemy6 object (within Enemi6 List)
    */
    public static void moveLeft(Enemy6 e6) {
        e6.x -= (int) EnSpeed;
    }

    
    /**
    * moveDown(int id)
    * 
    * Moves the Enemy6 object referenced by id 
    * down the screen by increasing its y value by 
    * 45 (and does the same for the y value 
    * of its linked Rectangle).
    * 
    * @param e6 - the id reference of an Enemy6 object (within Enemi6 List)
    */
    public static void moveDown(Enemy6 e6) {
        e6.y += yFall;
    }

    
    /**
    * E6Fire(Enemy6 e6)
 
 Fires a bullet, creating a new Enbullet 
 object with Enemy6 objects (referenced 
 by id) x and y coordinates as a starting 
 point via EnBullet.FireUFO() message
    * 
    * @param e6 - the e6 reference of an Enemy6 object (within Enemi6 List)
    */
    public static void E6Fire(Enemy6 e6) {
        EnBullet.FireEn(e6);
    }

    
    /**
    * E6Hit(Enemy6 e6)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode 
    * object with Enemy6 objects (referenced 
    * by id) x and y coordinates as a reference 
    * point via EnExplode.EnXDetonate() message
    * 
    * Following this Enemy6 objects (referenced by id) 
    * visible and isDead values are changed to false 
    * and true respectively.
    * 
    * @param e6 - the e6 reference of an Enemy6 object (within Enemi6 List)
    */
    public static void E6Hit(Enemy6 e6) {
        EnExplode.EnXDetonate(e6);
        if(random.nextInt(25) == 0){
            POW.init(e6);
        }
        e6.isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Enemy6 Objects
    */
    public static void tick(){
        Enemi6 = Enemy6.getAll();
        
        animE6.runRen();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
                
            for (Enemy6 en6 : Enemi6) {
                if(en6.isDead == false){
                    animE6.render(target, en6.x, en6.y, enScale, en6.width, en6.height, en6.e6Col);
                    if(Display.showBounds){
                        g.setColor(Color.white);
                        g.drawRect(en6.x, en6.y, en6.getBounds().width, en6.getBounds().height);
                        g.drawString("En6:"+en6.id, en6.x, en6.y-4);
                        
                        if(en6.en6Direction == 0){
                            g.drawString("DIR: R x:"+en6.x, en6.x-6, en6.y+54);
                        } else if(en6.en6Direction == 1){
                            g.drawString("DIR: L x:"+en6.x, en6.x-6, en6.y+54);
                        } else {
                            g.drawString("DIR: D y:"+en6.y, en6.x-6, en6.y+54);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the Enemy6 
 objects referenced by Enemi6
    * 
    * @return Enemi6
    */
    public static List<Enemy6> getAll() {
        Enemi6A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < Enemi6.size(); i++) {
            if (Enemi6.get(i).isDead == false) {
                Enemi6A.add(j, Enemi6.get(i));
                
                j++;
            }
        }
        
        return Enemi6A;
    }

    
    /**
    * clearAll()
    */
    public static void clearAll() {
        Enemi6.clear();
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
