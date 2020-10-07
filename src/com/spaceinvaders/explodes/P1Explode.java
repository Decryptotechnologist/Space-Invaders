package com.spaceinvaders.explodes;

import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.player.Player;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ghomez
 */
public class P1Explode extends Explode {
	
    /**Attributes*/
    
    /**P1ExplodeAnim Animation of P1Explode object */
    private static final Animation P1ExplodeAnim = new Animation(8, 
        new Texture("/Sprites/SI_Player2"), 
        new Texture("/Sprites/SI_Player1_1"), 
        new Texture("/Sprites/SI_Player2"), 
        new Texture("/Sprites/SI_Player1_1"), 
        new Texture("/Sprites/SI_Player2"), 
        new Texture("/Sprites/SI_Player1_1")
    );
    
    

    /**Constructor*/
        
    /**
    * Initialises a new P1Explode object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of P1Explode
    * @param y - the y coordinate of P1Explode
    * @param h - the height of P1Explode
    * @param w - the width of P1Explode
    * @param isDead - the isDead boolean of P1Explode
    */
    public P1Explode(int x, int y, int h, int w, boolean isDead){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.isDead = isDead;
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
                p1x_w = 40;
                p1x_h = 75;
                
                break;
            case 480:
                p1x_w = 80;
                p1x_h = 150;
                
                break;
            case 604:
                p1x_w = 80;
                p1x_h = 150;
            
                break;
            default:
                p1x_w = 80;
                p1x_h = 150;    
                
                break;
        }
        
    }
    
    /**
    * render()
    * 
    * Renders/Repaints P1Explode Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
        //System.out.println("Rendering P1Explode . . .");
        //Draw P1Explode
        for (P1Explode p1X : P1Explod) {
           if (p1X.isDead == false) {
		if(Display.showBounds){
                    g.setColor(Color.green);
                    g.drawRect(p1X.x, p1X.y+50, p1X.width-60, p1X.height/3+6);
                }
                P1ExplodeAnim.render(g, p1X.x, p1X.y+4, p1X.width-60, p1X.height);
                
                //Draw P1ExplodingLives
                if(Player.lives == 2){
                    P1ExplodeAnim.render(g, Labels.livesImg2X, Labels.livesImg2Y, Labels.livesImgScale, Labels.livesImgScale);
                }
                if(Player.lives == 1){
                    P1ExplodeAnim.render(g, Labels.livesImg1X, Labels.livesImg1Y, Labels.livesImgScale, Labels.livesImgScale);
                }
                if(Player.lives == 0){
                    P1ExplodeAnim.render(g, Labels.livesImg2X, Labels.livesImg2Y, Labels.livesImgScale, Labels.livesImgScale);
                    P1ExplodeAnim.render(g, Labels.livesImg1X, Labels.livesImg1Y, Labels.livesImgScale, Labels.livesImgScale);
                    P1ExplodeAnim.render(g, Labels.livesImg0X, Labels.livesImg0Y, Labels.livesImgScale, Labels.livesImgScale);
                }
				
            }
        }
        
    }
    
    
    /**
    * tick()
    * 
    * Updates P1Explode Objects
    */
    public static void tick(){
        //System.out.println("P1Explode Ticked!");
        P1Explod = getAll();
        P1ExplodeAnim.run();
        
        if(Game.gameTimer % 7 == 0 && P1Explod.size() > 0){                                    
            clearAll();
        }
        if(Player.lives == 0){
            Game.player.isDead = true;
            Game.player.dead();
	}
        Player.lives = Player.getPLives();
    }
    
    
    /**
    * P1Detonate()
    * 
    * Fires a Player Explosion, creating a new P1Explode 
    * object with Player objects x and y coordinates as a 
    * reference point
    * 
    * @param p1 - a Player object
    */
    public static void P1Detonate(Player p1){
        P1Explode p1x = new P1Explode((int) p1.x - 5, (int) p1.y-22, p1x_w, p1x_h, false);
        P1Explod.add(p1x);
    }
	
    
	
    /**
    * getAll()
    * 
    * Returns the List of the P1Explode 
    * objects referenced by P1Explode
    * 
    * @return P1Explod
    */
    public static List<P1Explode> getAll() {
        P1ExplodA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < P1Explod.size(); i++) {
            if (P1Explod.get(i).isDead == false) {
                P1ExplodA.add(j, P1Explod.get(i));
                j++;
            }
        }
        
        return P1ExplodA;
    }
    
    
    /**
    * clearAll()
    * 
    * Clears the Lists of the Rectangles 
    * referenced by P1ExplodeRect and
    * P1Explod objects
    * 
    */  
    public static void clearAll(){
        P1Explod.clear();
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
