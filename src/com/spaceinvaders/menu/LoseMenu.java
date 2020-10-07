package com.spaceinvaders.menu;

import com.spaceinvaders.level.Level;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.util.Random;

/**
 * LoseMenu objects represent one Enemy4 object 
 * (above the first top-most row of enemies), 
 * there are 1 of them at any one time randomly 
 * through-out the game each with their own 
 * collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class LoseMenu extends Menu {
    
    /**Attributes*/   
        
    /**LMfirstTick variable of LoseMenu object*/ 
    private boolean LMfirstTick = true;
    
    /**LMTimer variable of LoseMenu object*/ 
    private int LMTimer = 550;
    
    /**random variable of LoseMenu object*/ 
    Random random = new Random();
    
    
    
    /**Constructor*/
    
    
    /**
    * LoseMenu(Game game)
    * 
    * Initialises a new LoseMenu object 
    * 
    * @param game - the game variable of LoseMenu
    */    
    public LoseMenu(Game game) {
        System.out.println("LoseMenu: New Lose Menu Created");
        this.game = game;
    }

    
    /**Public protocol*/ 
    
    
    /**
    * render(Graphics2D g)
    * 
    * Renders/Repaints LoseMenu Objects
    * 
    * @param target
    * @param g - the g of LoseMenu
    */
    @Override
    public void render(Render target, Graphics2D g) {
        
        //Draw Background
        //g.drawImage(menuImage, 0, -15, Game.getGameWidth(), Game.getGameHeight()-20, null);
        
        //Render GameOver text
        if (System.currentTimeMillis() / 450 % 2 == 0) {
            //Draw Background
            target.draw(Texture.menuImage, 0, -20);
            
            //Draw 3D Game Over text: Green
            target.scaleDraw(Texture.buttonsA, 2, 116, 312, 154, 268, 158, 30, 0x013f0c);
            target.scaleDraw(Texture.buttonsA, 2, 114, 310, 154, 268, 158, 30, 0x0afa00);
            target.scaleDraw(Texture.buttonsA, 2, 452, 312, 294, 268, 15, 30, 0x013f0c);
            target.scaleDraw(Texture.buttonsA, 2, 450, 310, 294, 268, 15, 30, 0x0afa00);
            target.scaleDraw(Texture.buttonsA, 2, 424, 312, 294, 268, 15, 30, 0x013f0c);
            target.scaleDraw(Texture.buttonsA, 2, 422, 310, 294, 268, 15, 30, 0x0afa00);
            
            //Set StatusBar: "Game Over!!!"
            Display.setStatusBar("Game Over!!!");
        } else {
            //Draw Background
            target.draw(Texture.menuImage0, 0, -20);
            
            //Draw 3D Game Over text: Blue
            target.scaleDraw(Texture.buttonsA, 2, 116, 312, 154, 268, 158, 30, 0x00ac33);
            target.scaleDraw(Texture.buttonsA, 2, 114, 310, 154, 268, 158, 30, 0x0000fa);
            target.scaleDraw(Texture.buttonsA, 2, 452, 312, 294, 268, 15, 30, 0x00ac33);
            target.scaleDraw(Texture.buttonsA, 2, 450, 310, 294, 268, 15, 30, 0x0000fa);
            target.scaleDraw(Texture.buttonsA, 2, 424, 312, 294, 268, 15, 30, 0x00ac33);
            target.scaleDraw(Texture.buttonsA, 2, 422, 310, 294, 268, 15, 30, 0x0000fa);
            
            
            //Set StatusBar: " "
            Display.setStatusBar(" ");
        }
        
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates LoseMenu Object
    * 
    * @param game - the Game of LoseMenu
    * @param up - the up variable of LoseMenu
    * @param down - the down variable of LoseMenu
    * @param left - the left variable of LoseMenu
    * @param right - the right variable of LoseMenu
    * @param fire - the fire variable of LoseMenu
    */
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        //Manage Lose Menu: Timer
        if (LMTimer > 0) {
            LMTimer--;
        }
        //Manage Lose Menu: First Tick
        if (LMfirstTick) {
            LMfirstTick = false;
            System.out.println("LoseMenu: Cue Game Over Screen . . .");
            System.out.println("LoseMenu: Cue Dodgy soundtrack . . .");
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Menu3.loop();
            }
        }
        //Manage Lose Menu: Last Tick
        if (LMTimer == 0) {
            Sound.stopAll();
            game.setMenu(null);
            game.stateManager.setState("menu");
            
            Game.level = new Level(1);
            Display.setStatusBar("Ready");
        }

    }

    
}
