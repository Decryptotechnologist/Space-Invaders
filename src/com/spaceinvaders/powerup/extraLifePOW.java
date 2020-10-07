/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.powerup;

import com.spaceinvaders.enemies.Enemy;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ghomez
 */
public class extraLifePOW extends POW {
    
    /**Attributes*/
    
    /**animExLife variable of extraLifePOW object */
    private static final Animation animExLife = new Animation(8, 
        new Texture("/Sprites/SI_Player1G"), 
        new Texture("/Sprites/SI_Player0G"), 
        new Texture("/Sprites/SI_Player1G")
    );
    private final int col;
    
    
    
    
    /**Constructor*/
    
    /**
     * Initialises a new extraLifePOW object
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param isDead
     * @param vis
     * @param suit
     */
    public extraLifePOW(int x, int y, int width, int height, boolean isDead, boolean vis, int suit){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isDead = isDead;
        this.visible = vis;
        this.suit = suit;
        this.speed = 5;
        this.col = Display.colours[5].getRGB();
    }
    
    
    /**
     * init(Enemy en)
     * 
     * init is used to initiate extraLifePOW objects
     * 
     * @param en
     */
    public static void init(Enemy en){
        extraLifePOW pow = new extraLifePOW((int) en.x + random.nextInt(5), (int) en.y, pow_w, pow_h, false, true, 4);
	extraLifePOWz.add(pow);      
    }
    
    
    /**
    * tick()
    * 
    * Updates extraLifePOW Objects
    */
    public static void tick(){
        extraLifePOWz = extraLifePOW.getAll();
    
        animExLife.run();
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints extraLifePOW Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g){
        if(null == Game.aGame.menu){
            for (extraLifePOW pow : extraLifePOWz) {
                if(pow.isDead == false){
                    animExLife.render(g, pow.x, pow.y, pow.width, pow.height);
                }
            }
        }
        
        //Draw EnExplode Text(Enemy0)
        for (extraLifePOW pow : extraLifePOWz) {
            if (pow.isDead == false) {
                target.drawText("1UP", 3, pow.x + 15, pow.y - 10, pow.col);
            }
        }
    }
    
    
    /**
    * move(extraLifePOW p)
    * 
    * Moves each of the extraLifePOW objects (depending how
    * many extraLifePOW objects remain in extraLifePOWz List) 
    * after checking that the extraLifePOW object isDead 
    * value is false and visible value is true.
    * 
    * @param p the p reference of an extraLifePOW object (within extraLifePOWz List)
    */
    public static void move(extraLifePOW p){
        p.y += speed;
    }

    
    /**
    * POWHit(extraLifePOW p1)
    * 
    * Fires an Star Explosion, creating a new starExplode object with Star
    * objects (referenced by id) x and y coordinates as a reference point via
    * starExplode.StrXDetonate() message?
    *
    * Following this Star objects (referenced by id) visible and isDead
    * values are changed to false and true respectively.
    *
    * @param p1 the p1 reference of an Star object (within stars List)
    */
    public static void POWHit(extraLifePOW p1){
	p1.visible = false;
	p1.isDead = true;
        
        //set Player1 power-up
        //Player.setPOW(p1.suit);
    }
    
    
    /**
    * getAll()
    * 
    * Returns the List of the POW objects referenced by POWz
    *
    * @return POWz
    */
    public static List<extraLifePOW> getAll() {
        extraLifePOWzA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < extraLifePOWz.size(); i++) {
            if (extraLifePOWz.get(i).isDead == false) {
                extraLifePOWzA.add(j, extraLifePOWz.get(i));
                
                j++;
            }
        }
        
        return extraLifePOWzA;
    }

    
    /**
    * clearAll()
    * 
    * Clears the List of the POW and Rectangle objects 
    * referenced by POWz and POWzRect
    *
    */
    public static void clearAll() {
        extraLifePOWz.clear();
    }
    
    
    /**
    * getBounds()
    * 
    * returns Bounds of the EnExplode objects
    * 
    * @return new Rectangle(this.x, this.y, this.width, this.height)
    */ 
    @Override
    public Rectangle getBounds(){
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
