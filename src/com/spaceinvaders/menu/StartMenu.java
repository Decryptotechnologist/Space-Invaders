package com.spaceinvaders.menu;

import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.util.Random;
import java.awt.*;

/**
 * StartMenu objects represent one Enemy4 object 
 * (above the first top-most row of enemies), 
 * there are 1 of them at any one time randomly 
 * through-out the game each with their own 
 * collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class StartMenu extends Menu {
    
    /**Attributes*/
    
    /**SMfirstTick boolean of StartMenu object*/
    private boolean SMfirstTick = true;
    
    /**SMTimer variable of StartMenu object*/
    private int SMTimer = 500;
    
    /**random variable of StartMenu object*/
    Random random = new Random();
    
    
    
    /**Constructor*/
    
    /**
    * StartMenu(Game game)
    * 
    * Initialises a new StartMenu object
    * 
    * @param game - the height of StartMenu
    */ 
    public StartMenu(Game game) {
        System.out.println("StartMenu: New Start Menu Created");
        this.game = game;
        Menu.setUp();
    }
    
    
    /**Public protocol*/

    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints StartMenu Objects
    * 
    * @param target
    * @param g
    */     
    @Override
    public void render(Render target, Graphics2D g) {
        
        if (SMTimer > 15) {
            //Render Starting Background and text
            if (System.currentTimeMillis() / 450 % 2 == 0) {
                //Draw Background
                target.draw(Texture.startMenu0, 0, -20);
                
                //Draw 3D Starting text
                target.scaleDraw(Texture.buttonsA, 2, 156, 312, 250, 56, 210, 30, 0xff1000);
                target.scaleDraw(Texture.buttonsA, 2, 154, 310, 250, 56, 210, 30, 0xffa000);
                
                //Set StatusBar: "Starting . . ."
                Display.setStatusBar("Starting . . .");
            } else {
                //Draw Background
                target.draw(Texture.startMenu, 0, -20);
                
                //Set StatusBar: " "
                Display.setStatusBar(" ");
            }
        }
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates StartMenu Object
    * 
    * @param game - the Game of StartMenu
    * @param up - the up variable of StartMenu
    * @param down - the down variable of StartMenu
    * @param left - the left variable of StartMenu
    * @param right - the right variable of StartMenu
    * @param fire - the fire variable of StartMenu
    */     
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        if (SMTimer > 0) {
            SMTimer--;
        }
        if (SMfirstTick) {
            SMfirstTick = false;
            System.out.println("StartMenu: Cue Start Screen . . .");
            System.out.println("StartMenu: Cue Dodgy soundtrack . . .");
            
            //Set StatusBar: "Cue Start Screen . . ."
            Display.setStatusBar("Cue Start Screen . . .");
            
            Star.clearAll();
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Menu3.play();
            }
        }
        if (SMTimer == 0) {
            Sound.stopAll();
            System.out.println("StartMenu: End Dodgy soundtrack . . .");
            
            //Set Game Menu: null
            game.setMenu(null);
            System.out.println("StartMenu: Game On!!!");
            
            //Set StatusBar: "Game On!!!"
            Display.setStatusBar("Game On!!!");
            
            //Reset Game Time
            Game.resetGameTime();
        }
    }

    
}
