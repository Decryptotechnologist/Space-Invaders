package com.spaceinvaders.graphics;

import com.spaceinvaders.barricade.Barricade;
import com.spaceinvaders.bullets.*;
import com.spaceinvaders.enemies.Enemy;
import com.spaceinvaders.explodes.*;
import com.spaceinvaders.pkg2018.Game;
import com.spaceinvaders.powerup.POW;
import java.awt.Graphics2D;

/**
 * Screen objects represent 
 * 
 * @author(s) The Cherno, Ghomez
 */
public class Screen extends Render {

    /**Attributes*/                                      
    
    /**render variable of Screen object*/ 
    private final Render3D render;
    
    
    /**Constructor*/
    
    
    /**
    * Screen(int width, int height)
    * 
    * @param height the height of Render
    * @param width the width of Render
    */
    public Screen(int width, int height) {
        super(width, height);        
        System.out.println("Screen: New Screen Created");
        render = new Render3D(width, height);
    }


    /**
    * render(Game game, boolean hasFocus, Graphics2D g)
    * 
    * Renders/Repaints Screen Objects
    * 
    * @param game - the height of Screen
    * @param hasFocus - the width of Screen
    * @param g
    */
    public void render(Game game, boolean hasFocus, Graphics2D g) {
        
        if((game.menu == null && !game.stateManager.currentState.getName().equals("menu")) || game.stateManager.currentState.getName().equals("Credits")){    
            
            render.renderDistanceLimiter();
            
            if(game.showSpace){
                render.Space();
            }
            
            if(game.showStars){
                render.Stars();
            }
            
            draw(render, 0, 0);
            
            
            Game.player.render(this, g);
            Barricade.render(this, g);
            Game.level.render(this, g);
            
            EnExplode.render(this, g);
            P1Explode.render(this, g);
            BRCExplode.render(this, g);
            P1BExplode.render(this, g);
            
            POW.render(this, g);
            Enemy.render(this, g);
            
            P1Bullet.render(this, g);
            EnBullet.render(this, g);
        }


        if (game.menu != null) {
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = (pixels[i] & 0xfcfcfc) >> 2;
            }
            game.menu.render(this, g);
        } 
        
        if (!hasFocus) {
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = (pixels[i] & 0xfc0024) >> 2;
            }
            if (System.currentTimeMillis() / 450 % 2 != 0) {
                scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX, Labels.click2FocusY, 235, 225, 220, 35, 0xff0000);
            }
            Star.clearAll();
        }
                
    }

}
