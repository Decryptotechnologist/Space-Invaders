/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.menu;

import com.spaceinvaders.graphics.*;
import com.spaceinvaders.input.MouseInput;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;


/**
 * PauseMenu objects represent one Enemy4 object 
 * (above the first top-most row of enemies), 
 * there are 1 of them at any one time randomly 
 * through-out the game each with their own 
 * collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class PauseMenu extends Menu {

    /**Attributes*/
    
    /**PMfirstTick variable of PauseMenu object */ 
    private boolean PMfirstTick = true;
    
    /**PMTimer variable of PauseMenu object */ 
    private int PMTimer = 550;
    
    //private Color txtCol = new Color(Texture.getCol(0x00ac00));
    

    /**Public protocol*/ 
    
    
    /**
    * render(Graphics2D g)
    * 
    * Renders/Repaints PauseMenu Objects
    * 
    * @param target
    * @param g - the g of PauseMenu
    */
    @Override
    public void render(Render target, Graphics2D g) {
        
        MouseInput.MouseButton = 0;
        
        //Draw Background
        target.draw(Texture.menuImage, 0, -20);
        
        //Render Paused text
        if (System.currentTimeMillis() / 450 % 2 == 0) {
            //Draw Background
            target.draw(Texture.menuImage, 0, -20);
            
            //Draw 3D Paused text: Green, Blue Shadow
            target.scaleDraw(Texture.buttonsA, 2, 186, 312, 6, 270, 148, 30, 0x013f0c);
            target.scaleDraw(Texture.buttonsA, 2, 184, 310, 6, 270, 148, 30, 0x0afa00);
            
            Display.setStatusBar("Paused . . .");
        } else {
            //Draw Background
            target.draw(Texture.menuImage0, 0, -20);
            
            //Draw 3D Paused text: Blue, Green Shadow
            target.scaleDraw(Texture.buttonsA, 2, 186, 312, 6, 270, 148, 30, 0x0000ac);
            target.scaleDraw(Texture.buttonsA, 2, 184, 310, 6, 270, 148, 30, 0x0000fa);
            
            //Set StatusBar: " "
            Display.setStatusBar(" ");
        }
        
        //Draw Resume Button
        if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 368 && MouseInput.MouseY < 368 + 60) {
                g.drawImage(resumeOffBtn, 106, 368, 160, 60, null);
                
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 164, 394, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 25, 394, 22, 20, null);
                }

                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    System.out.println("PauseMenu: Resume Selected");
                    Game.getGame().setMenu(null);
                    Game.Paused = false;
                    
                    Sound.reloopLevel(Game.levelNo);
                    //config.loadConfiguration("res/sys/config.xml");
                }
            } else {
                g.drawImage(resumeOnBtn, 106, 368, 160, 60, null);
            }

            //Draw Restart Button
            if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 260 && MouseInput.MouseY > 432 && MouseInput.MouseY < 432 + 60) {
                g.drawImage(restartOffBtn, 106, 432, 260, 60, null);
                
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 264, 452, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 24, 454, 22, 20, null);
                }
                
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    Game.Paused = false;

                    System.out.println("PauseMenu: Restart Selected");
                    Game.getGame().setMenu(null);
                    Game.getGame().stateManager.setState("menu");

                    Game.level = new Level(Game.startLevel);
                }
            } else {
                g.drawImage(restartOnBtn, 112, 432, 260, 60, null);
            }

            //Draw Quit Button
            if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 492 && MouseInput.MouseY < 492 + 60) {
                g.drawImage(quitOffBtn, 106, 492, 160, 60, null);
                
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 164, 518, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 28, 518, 22, 20, null);
                }
		
                if (MouseInput.MouseButton == 1) {
                    System.out.println("PauseMenu: Quit Selected");
                    Game.getGame().setMenu(null);
                
                    Game.quitGame();
                }
            } else {
                g.drawImage(quitOnBtn, 106, 492, 160, 60, null);
            }
            
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates PauseMenu Object
    * 
    * @param game - the Game of PauseMenu
    * @param up - the up variable of PauseMenu
    * @param down - the down variable of PauseMenu
    * @param left - the left variable of PauseMenu
    * @param right - the right variable of PauseMenu
    * @param fire - the fire variable of PauseMenu
    */
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        //Manage Pause Menu: Timer
        if (PMTimer > 0) {
            PMTimer--;
        }
        //Manage Pause Menu: First Tick
        if (PMfirstTick) {
            PMfirstTick = false;
            System.out.println("PauseMenu: Cue Pause Screen . . .");
            System.out.println("PauseMenu: Cue Pause Wav . . .");
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Paused.loop();
            }
            Display.setStatusBar("Paused . . .");
        }
        //Manage Pause Menu: Last Tick
        if (PMTimer == 0) {
            Display.setStatusBar(" ");
        }
    
    }
    
}

