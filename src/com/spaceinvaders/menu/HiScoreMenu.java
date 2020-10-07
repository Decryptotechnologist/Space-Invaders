/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.menu;

import com.spaceinvaders.graphics.Render;
import com.spaceinvaders.graphics.Texture;
import com.spaceinvaders.pkg2018.Display;
import com.spaceinvaders.pkg2018.Game;
import com.spaceinvaders.pkg2018.Sound;
import java.awt.Graphics2D;

/**
 *
 * @author Ghomez
 */
public class HiScoreMenu extends Menu {
    
    /**Attributes*/
    
    /**HSMfirstTick variable of HiScoreMenu object */ 
    private boolean HSMfirstTick = true;
    
    /**HSMTimer variable of HiScoreMenu object */ 
    private int HSMTimer = 550;
    
    
    /**Constructor*/
    
    /**
    * HiScoreMenu(Game game)
    * 
    * Initialises a new HiScoreMenu object
    * 
    * @param game - the height of StartMenu
    */ 
    public HiScoreMenu(Game game) {
        System.out.println("HiScoreMenu: New Hi-Score Menu Created");
        this.game = game;
        //Menu.setUp();
    }
    
    
    /**Public protocol*/
    
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints HiScoreMenu Objects
    * 
    * @param target
    * @param g
    */     
    @Override
    public void render(Render target, Graphics2D g) {
        
        if (HSMTimer > 15) {
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
        if(HSMTimer > 0) {
            HSMTimer--;
        }
        if(HSMfirstTick) {
            HSMfirstTick = false;
            System.out.println("HiScoreMenu: Cue Start Screen . . .");
            System.out.println("HiScoreMenu: Cue Dodgy soundtrack . . .");
            
            //Set StatusBar: "Cue HiScore Screen . . ."
            Display.setStatusBar("Cue HiScore Screen . . .");
            
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Menu3.play();
            }
        }
        if (HSMTimer == 0) {
            Sound.stopAll();
            System.out.println("HiScoreMenu: End Dodgy soundtrack . . .");
            
            //Set Game Menu: null
            game.setMenu(null);
            System.out.println("HiScoreMenu: Game On!!!");
            
            //Set StatusBar: "Game On!!!"
            Display.setStatusBar("Game On!!!");
            
            //Reset Game Time
            Game.resetGameTime();
        }
    }
    
    
}
