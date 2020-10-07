package com.spaceinvaders.enemies;

import com.spaceinvaders.bullets.EnBullet;
import com.spaceinvaders.explodes.EnExplode;
import com.spaceinvaders.graphics.*;
import java.awt.*;
import java.util.List;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.pkg2018.*;

/**
 * UFO objects represent one UFO object 
 (above the first top-most row of enemies), 
 there are 1 of them at any one time randomly 
 through-out the game each with their own 
 collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class UFO extends Enemy {
	
    /**Attributes*/
	
    /**anim variable of UFO object */
    private static final Animation anim = new Animation(18, 
            new Texture("/Sprites/SI_enemy4_0"), 
            new Texture("/Sprites/SI_enemy4_1"), 
            new Texture("/Sprites/SI_enemy4_0"), 
            new Texture("/Sprites/SI_enemy4_1")
    );
    

    
    /**Constructor*/
        
    /**
    * UFO(int x, int y, boolean isDead, int DIR, int ID)
    * 
    * Initialises a new UFO object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of UFO
    * @param y - the y coordinate of UFO
    * @param isDead - the isDead boolean of UFO
    * @param DIR - the direction of travel(Integer) of UFO
    * @param ID - the id reference of an UFO object
    */
    public UFO(int x, int y, boolean isDead, int DIR, int ID) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h/2;
        this.isDead = isDead;
        this.ufoDirection = DIR;
        this.id = ID;
    }

    
    /**Public Protocol*/
        
    
    /**
    * initUFO()
 
 Initialises a single UFO object
 and its linked Rectangle object
    */
    public static void initUFO() {
        Sound.UFOsndA.stop();
        if(random.nextInt(Enemy.UFOfreq) == 0){
            UFO eufo_a = new UFO(40, eufo_y, false, 0, 0);
            EnemiUFO.add(eufo_a);
        } else {
            UFO eufo_b = new UFO(Game.getGameWidth()-40, eufo_y, false, 1, 1);
            EnemiUFO.add(eufo_b);
        }
        
        //play sound
        if(Game.getGameSound() && 
                !Game.getGame().stateManager.currentState.getName().equals("menu") && 
                Game.getGame().menu == null){
            Sound.UFOsnd.play();
            
            Sound.UFOsndA.play();
        }
    }
    
    
    /**
    * move(int id)
    * 
    * Moves a row of UFO objects
    * 
    * @param id - the id reference of an UFO object (within EnemiUFO List)
    */
    public void move(int id) {
       
        for (int i = id; i < EnemiUFO.size(); i++) {
            if (EnemiUFO.get(i).isDead == false) {
                    if (EnemiUFO.get(i).x > leftSide - 5 && EnemiUFO.get(i).x < rightSide) {
                        if (EnemiUFO.get(i).x < rightSide && ufoDirection == 0) {

                            moveRight(EnemiUFO.get(i));
                            
                            if (EnemiUFO.get(i).x == leftSide + 10 || EnemiUFO.get(i).x + 20 == rightSide) {
                                for (int j = 0; j < EnemiUFO.size(); j++) {
                                    if (EnemiUFO.get(j).ufoDirection == 0) {
                                        EnemiUFO.get(j).ufoDirection = 1;
                                    } else {
                                        EnemiUFO.get(j).ufoDirection = 0;
                                    }
                                }
                            }

                        } else {

                            moveLeft(EnemiUFO.get(i));
                            
                            if (EnemiUFO.get(i).x == leftSide + 10 || EnemiUFO.get(i).x + 12 == rightSide) {
                                for (int j = 0; j < EnemiUFO.size(); j++) {
                                    if (EnemiUFO.get(j).ufoDirection == 0) {
                                        EnemiUFO.get(j).ufoDirection = 1;
                                    } else {
                                        EnemiUFO.get(j).ufoDirection = 0;
                                    }
                                }

                            }
                        }
                    }

            }
        }
        
        
    }
    
    
    /**
    * moveRight(UFO eufo)
    * 
    * Moves the UFO object referenced by id 
    * to the right by increasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 0(right).
    * 
    * @param eufo - the eufo reference of an UFO object (within EnemiUFO List)
    */
    public void moveRight(UFO eufo) {
        eufo.x += EnSpeed * 5;
    }

    
    /**
    * moveLeft(UFO eufo)
    * 
    * Moves the UFO object referenced by id 
    * to the left by decreasing its x value by 
    * EnSpeed (and does the same for the x value 
    * of its linked Rectangle) after checking 
    * its Direction value is 1(left).
    * 
    * @param eufo - the eufo reference of an UFO object (within EnemiUFO List)
    */
    public static void moveLeft(UFO eufo) {
        eufo.x -= EnSpeed * 5;
    }

    
    /**
    * UFOFire(UFO eufo)
    * 
    * Fires a bullet, creating a new Enbullet 
    * object with UFO objects (referenced 
    * by id) x and y coordinates as a starting 
    * point via EnBullet.FireUFO() message
    * 
    * @param eufo - the eufo reference of an UFO object (within EnemiUFO List)
    */
    public static void UFOFire(UFO eufo) {
        EnBullet.FireEn(eufo);
    }

    
    /**
    * UFOHit(UFO eufo)
    * 
    * Fires an Enemy Explosion, creating a new EnExplode object with UFO
    * objects (referenced by id) x and y coordinates as a reference point via
    * EnExplode.EnXDetonate() message
    * 
    * Following this UFO objects (referenced by id) isDead
    * value is changed to true.
    *
    * @param eufo - the eufo reference of an UFO object (within EnemiUFO List)
    */
    public static void UFOHit(UFO eufo) {
        EnExplode.EnXDetonate(eufo);
        if(random.nextInt(25) == 0){
//            POW.init(Enemiez4.get(id));
        }
        eufo.isDead = true;
        Sound.UFOsnd.stop();
        Sound.UFOsndA.stop();
    }

    
    /**
    * tick()
    * 
    * Updates UFO Objects
    */
    public static void tick(){
        EnemiUFO = UFO.getAll();
        
        anim.run();
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public static void render(Render target, Graphics2D g){
        if (null == Game.aGame.menu){
            
            for(UFO eufo : EnemiUFO) {
                if(eufo.isDead == false){
                    anim.render(g, eufo.x, eufo.y, eufo.width, eufo.height);
                    if(Display.showBounds){
                        g.setColor(Color.red);
                        g.drawRect(eufo.x, eufo.y, eufo.width, eufo.height-8);
                        g.drawString("Eufo:"+eufo.id, eufo.x, eufo.y-4);
                        
                        if(eufo.ufoDirection == 0){
                            g.drawString("DIR: Right", eufo.x-6, eufo.y+44);
                        } else if(eufo.ufoDirection == 1){
                            g.drawString("DIR: Left", eufo.x-6, eufo.y+44);
                        } else {
                            g.drawString("DIR: Down", eufo.x-6, eufo.y+44);
                        }
                    }
                }
            }
            
        }
    }
    

    
    /**
    * getAll1()
 
 Returns the List of the UFO objects referenced by EnemiUFO
    *
    * @return EnemiUFO
    */
    public static List<UFO> getAll() {
        return EnemiUFO;
    }


    
    /**
    * clearAll()
    * 
    */
    public static void clearAll() {
        EnemiUFO.clear();
    }
    
    
    /**
     * getBounds()
     * 
     * @return new Rectangle(this.x, this.y, this.width, this.height)
     */
    @Override
    public Rectangle getBounds() {
      return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
}
