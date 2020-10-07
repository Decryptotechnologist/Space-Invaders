package com.spaceinvaders.explodes;

import com.spaceinvaders.bullets.P1Bullet;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.player.Player;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * P1BExplode objects represent the explosion of Player 1 
 * bullets when they collide with something in the game,
 * represented by a small 'animated explosion'.
 * 
 * @author(s) Ghomez
 */
public class P1BExplode extends Explode {

    /**Attributes*/                                      
    
    /**p1BulletExplodeAnim Animation of P1Explode object */
    private static final Animation p1BulletExplodeAnim = new Animation(8, 
        new Texture("/Sprites/SI_explode0"), 
        new Texture("/Sprites/SI_explode1"), 
        new Texture("/Sprites/SI_explode2"), 
        new Texture("/Sprites/SI_explode0"), 
        new Texture("/Sprites/SI_explode1"), 
        new Texture("/Sprites/SI_explode2")
    );
    

    
    /**Constructor*/
        
    /**
    * Initialises a new P1BExplode object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w, this.visible 
    * set to vis
    * 
    * @param x the x coordinate of P1BExplode
    * @param y the y coordinate of P1BExplode
    * @param h the height of P1BExplode
    * @param w the width of P1BExplode
    * @param isDead the isDead boolean of P1BExplode
    * @param suit
    */
    public P1BExplode(int x, int y, int h, int w, boolean isDead, int suit){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.isDead = isDead;
        this.suit = suit;
    }

    
    /**Public Protocol*/
        
    /**
     * setUp()
     * 
     */
    public static void setUp(){
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                p1bx_w = 4;
                p1bx_h = 8;

                playerBullExScale_a = 0.065;
                playerBullExScale_b = 0.07;
                playerBullExScale_c = 0.06;
                playerBullExXoffs = -15;
                playerBullExYoffs = 6;
                
                break;
                
            case 480:
                p1bx_w = 8;
                p1bx_h = 15;

                playerBullExScale_a = 0.13;
                playerBullExScale_b = 0.14;
                playerBullExScale_c = 0.12;
                playerBullExXoffs = -15;
                playerBullExYoffs = 6;
                
                break;
                
            case 604:
                p1bx_w = 8;
                p1bx_h = 15;

                playerBullExScale_a = 0.13;
                playerBullExScale_b = 0.14;
                playerBullExScale_c = 0.12;
                playerBullExXoffs = -15;
                playerBullExYoffs = 6;
                
                break;
                
            default:
                p1bx_w = 8;
                p1bx_h = 15;

                playerBullExScale_a = 0.13;
                playerBullExScale_b = 0.14;
                playerBullExScale_c = 0.12;
                playerBullExXoffs = -15;
                playerBullExYoffs = 6;
                
                break;
        }
        
    }
    
    /**
    * render()
    * 
    * Renders/Repaints P1BExplode Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
        //System.out.println("Rendering P1BExplode . . .");
        //Draw P1BExplode
        for (P1BExplode P1Bx : P1BXP) {
            if (P1Bx.isDead == false) {
                if(Display.showBounds){
                    g.setColor(Color.white);
                    g.drawRect(P1Bx.x, P1Bx.y, 12, 12);
                }
                switch (P1Bx.suit) {
                    case 0:
                        p1BulletExplodeAnim.render(g, P1Bx.x, P1Bx.y+4, 10, 10);
                        break;
                    case 1:
                        p1BulletExplodeAnim.render(g, P1Bx.x, P1Bx.y+4, 12, 12);
                        break;                      
                    default:
                        p1BulletExplodeAnim.render(g, P1Bx.x, P1Bx.y+4, 8, 8);
                        break;
                }
            }
        }
            
    }
    
    
    /**
    * tick()
    * 
    * Updates P1BExplode Objects
    */
    public static void tick(){
        P1BXP = P1BExplode.getAll();
        p1BulletExplodeAnim.run();
        switchsuit();
    }
    
    
    /**
    * switchsuit()
    * 
    */
    public static void switchsuit(){
        
        if(Game.gameTimer % 1 == 0){
            P1BExsuit = 1;
        } else {
            if(Game.gameTimer % 2 > 0){
                P1BExsuit = 2;
            } else {
                P1BExsuit = 0;
                P1BExplode.clearAll();
            } 
        }
        if(Game.gameTimer % 3 == 0){                                    
            P1BExplode.clearAll();
        }
                
    }
    
    
    /**
    * P1BDetonate()
    * 
    * Fires a Player Bullet Explosion, creating a new P1BExplode 
    * object with Player Bullet objects x and y coordinates as a 
    * reference point
    * 
    * 
    * @param p1Bull - the Player Bullet object
    */
    public static void P1BDetonate(P1Bullet p1Bull){
        Player.isFiring = false;
        P1BExplode p1Bx = new P1BExplode((int) p1Bull.x - random.nextInt(5), (int) p1Bull.y, p1bx_w, p1bx_h, false, 0);
        P1BXP.add(p1Bx);
    }
	
    
    /**
    * Clears the Lists of the Rectangles 
    * referenced by P1BXPR and
    * P1BXP objects
    * 
    */
    public static void clearAll(){
        P1BXP.clear();
    }
        
        
    /**
    * getAll()
    * 
    * Returns the List of the P1BExplode 
    * objects referenced by P1BExplodez 
    * (after clearing them)
    * 
    * @return P1BExplodez
    */
    public static List<P1BExplode> getAll() {
        P1BXPA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < P1BXP.size(); i++) {
            if (P1BXP.get(i).isDead == false) {
                P1BXPA.add(j, P1BXP.get(i));
                j++;
            }
        }
        
        return P1BXPA;
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
