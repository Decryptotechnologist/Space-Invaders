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
public class KeysMenu extends Menu {
    
    /**Attributes*/
    
    /**KSMfirstTick variable of KeysMenu object */ 
    private boolean KSMfirstTick = true;
    
    /**KSMTimer variable of KeysMenu object */ 
    private int KSMTimer = 750;
    
    
    /**Constructor*/
    
    /**
    * KeysMenu(Game game)
    * 
    * Initialises a new KeysMenu object
    * 
    * @param game - the height of KeysMenu
    */ 
    public KeysMenu(Game game) {
        System.out.println("HiScoreMenu: New Hi-Score Menu Created");
        this.game = game;
        //Menu.setUp();
    }
    
    
    /**Public protocol*/
    
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints KeysMenu Objects
    * 
    * @param target
    * @param g
    */     
    @Override
    public void render(Render target, Graphics2D g) {
        
        if (KSMTimer > 15) {
            //Render Keyz Background and text
            //if (System.currentTimeMillis() / 450 % 2 == 0) {
                //Draw Background
                target.draw(Texture.keysMenuImage0, 0, -20);
                
                //Draw Keyboard/Key Map
                target.scaleDraw(Texture.Keyz, 1.4, 55, 200, 0, 0, 94, 340, 0xff0000);
                target.scaleDraw(Texture.Keyz, 1.4, 56, 201, 0, 0, 94, 340, 0x00d5fc);
                
                target.scaleDraw(Texture.Keyz, 1.4, 255, 200, 150, 0, 134, 340, 0xff0000);
                target.scaleDraw(Texture.Keyz, 1.4, 256, 201, 150, 0, 134, 340, 0x00d5fc);
                
                //Draw Game Keys
                target.draw("F5", 190, 234, 0x00ff0c);//New Game:F5
                target.draw("F4", 190, 250, 0x00ff0c);//ExitGame:F4
                target.draw("Q", 190, 266, 0x00ff0c);//Quit:Q
                target.draw("ESC", 190, 282, 0x00ff0c);//Pause:ESC
                target.draw("H", 190, 298, 0x00ff0c);//Help:H
                target.draw("O", 190, 314, 0x00ff0c);//Options:O
                
                //Draw Sound Keys
                target.draw("M", 190, 370, 0x00ff0c);//Music:M
                target.draw("S", 190, 388, 0x00ff0c);//SFX:S
                
                //Draw Display Keys
                target.draw("P", 190, 448, 0x00ff0c);//UPS:P
                target.draw("F", 190, 464, 0x00ff0c);//FPS:F
                target.draw("0:Zero", 190, 480, 0x00ff0c);//Stars:0(Zero)
                target.draw("1:One", 190, 496, 0x00ff0c);//Space:(One)
                target.draw("K", 190, 512, 0x00ff0c);//Killshot:K
                target.draw("B", 190, 528, 0x00ff0c);//Bounds:B
                target.draw("U", 190, 544, 0x00ff0c);//HUD:U
                target.draw("Z", 190, 560, 0x00ff0c);//Statusbar:Z
                
                
                
                //Draw Controls Keys
                target.draw("L Arrow", 450, 234, 0x00ff0c);
                target.draw("R Arrow", 450, 250, 0x00ff0c);
                target.draw("Spacebar", 450, 266, 0x00ff0c);
                target.draw("R", 450, 282, 0x00ff0c);
                
                //Draw Developer Keys
                target.draw("F6", 450, 336, 0x00ff0c);
                target.draw("F7", 450, 352, 0x00ff0c);
                target.draw("F8", 450, 368, 0x00ff0c);
                target.draw("-", 450, 382, 0x00ff0c);
                target.draw("+", 450, 396, 0x00ff0c);
                target.draw("F1:Cannon", 450, 412, 0x00ff0c);
                target.draw("F2:Shield", 450, 428, 0x00ff0c);
                target.draw("F3:Speed", 450, 444, 0x00ff0c);
                target.draw("HOME", 450, 460, 0x00ff0c);
                
                //Draw 3D Keys text
                //Draw K
                target.scaleDraw(Texture.buttonsA, 2, 220, 132, 250, 0, 22, 28, 0xff1000);
                target.scaleDraw(Texture.buttonsA, 2, 218, 130, 250, 0, 22, 28, 0xffa000);
                
                //Draw E
                target.scaleDraw(Texture.buttonsA, 2, 252, 132, 100, 0, 22, 28, 0xff1000);
                target.scaleDraw(Texture.buttonsA, 2, 250, 130, 100, 0, 22, 28, 0xffa000);
                
                //Draw Y
                target.scaleDraw(Texture.buttonsA, 2, 296, 132, 150, 26, 22, 28, 0xff1000);
                target.scaleDraw(Texture.buttonsA, 2, 294, 130, 150, 26, 22, 28, 0xffa000);
                
                //Draw S
                target.scaleDraw(Texture.buttonsA, 2, 344, 132, 176, 26, 22, 28, 0xff1000);
                target.scaleDraw(Texture.buttonsA, 2, 342, 130, 176, 26, 22, 28, 0xffa000);
                
                
                
                //Set StatusBar: "Starting . . ."
                Display.setStatusBar("Keyzzzzzzzzzzz . . .");
//            } else {
//                //Draw Background
//                target.draw(Texture.keysMenuImage, 0, -20);
//                
//                //Draw Keyboard/Key Map
//                target.scaleDraw(Texture.Keyz, 1.4, 75, 200, 0, 0, 94, 340, Texture.getCol(0x00d5fc));
//                target.scaleDraw(Texture.Keyz, 1.4, 285, 200, 150, 0, 134, 340, Texture.getCol(0x00d5fc));
//                
//                //Draw Game Keys
//                target.draw("F5", 240, 234, Texture.getCol(0xff0000));//New Game:F5
//                target.draw("F4", 240, 250, Texture.getCol(0xff0000));//ExitGame:F4
//                target.draw("Q", 240, 266, Texture.getCol(0xff0000));//Quit:Q
//                target.draw("ESC", 240, 282, Texture.getCol(0xff0000));//Pause:ESC
//                target.draw("H", 240, 298, Texture.getCol(0xff0000));//Help:H
//                target.draw("O", 240, 314, Texture.getCol(0xff0000));//Options:O
//                
//                //Draw Sound Keys
//                target.draw("M", 240, 370, Texture.getCol(0xff0000));//Music:M
//                target.draw("S", 240, 388, Texture.getCol(0xff0000));//SFX:S
//                
//                //Draw Display Keys
//                target.draw("P", 240, 448, Texture.getCol(0xff0000));//UPS:P
//                target.draw("F", 240, 464, Texture.getCol(0xff0000));//FPS:F
//                target.draw("0 : Zero", 240, 480, Texture.getCol(0xff0000));//Stars:0(Zero)
//                target.draw("1 : One", 240, 496, Texture.getCol(0xff0000));//Space:(One)
//                target.draw("K", 240, 512, Texture.getCol(0xff0000));//Killshot:K
//                target.draw("B", 240, 528, Texture.getCol(0xff0000));//Bounds:B
//                target.draw("U", 240, 544, Texture.getCol(0xff0000));//HUD:U
//                target.draw("Z", 240, 560, Texture.getCol(0xff0000));//Statusbar:Z
//                
//                //Draw Controls Keys
//                target.draw("L Arrow", 470, 234, Texture.getCol(0xff0000));
//                target.draw("R Arrow", 470, 250, Texture.getCol(0xff0000));
//                target.draw("Spacebar", 470, 266, Texture.getCol(0xff0000));
//                target.draw("R", 470, 282, Texture.getCol(0xff0000));
//                
//                //Draw Developer Keys
//                target.draw("F6,F7,F8", 470, 336, Texture.getCol(0xff0000));
//                target.draw("-", 470, 352, Texture.getCol(0xff0000));
//                target.draw("+", 470, 368, Texture.getCol(0xff0000));
//                target.draw("F1,F2,F3", 470, 382, Texture.getCol(0xff0000));
//                target.draw("HOME", 470, 400, Texture.getCol(0xff0000));
//                
//                //Draw 3D Keys text
//                //Draw K
//                target.scaleDraw(Texture.buttonsA, 2, 220, 132, 250, 0, 22, 28, Texture.getCol(0xff1000));
//                target.scaleDraw(Texture.buttonsA, 2, 218, 130, 250, 0, 22, 28, Texture.getCol(0xa0000a));
//                
//                //Draw E
//                target.scaleDraw(Texture.buttonsA, 2, 252, 132, 100, 0, 22, 28, Texture.getCol(0xff1000));
//                target.scaleDraw(Texture.buttonsA, 2, 250, 130, 100, 0, 22, 28, Texture.getCol(0xa0000a));
//                
//                //Draw Y
//                target.scaleDraw(Texture.buttonsA, 2, 296, 132, 150, 26, 22, 28, Texture.getCol(0xff1000));
//                target.scaleDraw(Texture.buttonsA, 2, 294, 130, 150, 26, 22, 28, Texture.getCol(0xa0000a));
//                
//                //Draw S
//                target.scaleDraw(Texture.buttonsA, 2, 344, 132, 176, 26, 22, 28, Texture.getCol(0xff1000));
//                target.scaleDraw(Texture.buttonsA, 2, 342, 130, 176, 26, 22, 28, Texture.getCol(0xa0000a));
//                
//                //Set StatusBar: " "
//                Display.setStatusBar(" ");
//            }
        }
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates KeysMenu Object
    * 
    * @param game - the Game of KeysMenu
    * @param up - the up variable of KeysMenu
    * @param down - the down variable of KeysMenu
    * @param left - the left variable of KeysMenu
    * @param right - the right variable of KeysMenu
    * @param fire - the fire variable of KeysMenu
    */     
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        if(KSMTimer > 0) {
            KSMTimer--;
        }
        if(KSMfirstTick) {
            KSMfirstTick = false;
            System.out.println("KeysMenu: Cue Start Screen . . .");
            System.out.println("KeysMenu: Cue Dodgy soundtrack . . .");
            
            //Set StatusBar: "Cue HiScore Screen . . ."
            Display.setStatusBar("Cue KeysMenu Screen . . .");
            
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Menu3.play();
            }
        }
        if (KSMTimer == 0) {
            Sound.stopAll();
            System.out.println("KeysMenu: End Dodgy soundtrack . . .");
            
            //Set Game Menu: null
            game.setMenu(null);
            System.out.println("KeysMenu: Game On!!!");
            
            //Set StatusBar: "Game On!!!"
            Display.setStatusBar("Game On!!!");
            
            //Reset Game Time
            Game.resetGameTime();
        }
    }
}
