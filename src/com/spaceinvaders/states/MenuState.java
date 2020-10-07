/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.states;

import com.spaceinvaders.graphics.Texture;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.utils.Fonts;
import com.spaceinvaders.input.MouseInput;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * @author Ghomez
 * 
 */
public class MenuState implements State {
    
    /**Attributes*/
    
    /**menuImage BufferedImage of MenuState object*/
    private BufferedImage menuImage;
    
    /**menuImage BufferedImage of MenuState object*/
    private BufferedImage menuImage0;
    
    /**menuImage BufferedImage of MenuState object*/
    private BufferedImage menuImage1;
    
    /**menuImage BufferedImage of MenuState object*/
    private BufferedImage menuImage2;
    
    /**menuImage BufferedImage of MenuState object*/
    private BufferedImage menuImage3;
    
    /**playOffBtn BufferedImage of MenuState object*/
    private final BufferedImage playOffBtn;
    
    /**playOnBtn BufferedImage of MenuState object*/
    private final BufferedImage playOnBtn;
    
    /**optionsOffBtn BufferedImage of MenuState object*/
    private final BufferedImage optionsOffBtn;
    
    /**optionsOnBtn BufferedImage of MenuState object*/
    private final BufferedImage optionsOnBtn;
    
    /**helpOffBtn BufferedImage of MenuState object*/
    private final BufferedImage helpOffBtn;
    
    /**helpOnBtn BufferedImage of MenuState object*/
    private final BufferedImage helpOnBtn;
    
    /**quitOffBtn BufferedImage of MenuState object*/
    private final BufferedImage quitOffBtn;
    
    /**quitOnBtn BufferedImage of MenuState object*/
    private final BufferedImage quitOnBtn;
    
    /**aboutOffBtn BufferedImage of MenuState object*/
    private final BufferedImage aboutOffBtn;
    
    /**aboutOnBtn BufferedImage of MenuState object*/
    private final BufferedImage aboutOnBtn;
    
    /**leftArrowIcon BufferedImage of MenuState object*/
    private final BufferedImage leftArrowIcon;
    
    /**rightArrowIcon BufferedImage of MenuState object*/
    private final BufferedImage rightArrowIcon;
    
    /**button_width variable of MenuState object*/ 
    protected int button_width = 160;
    
    /**button_height variable of MenuState object*/ 
    protected int button_height = 80;
    
    /**hlpCol variable of MenuState object*/
    public Color hlpCol = Color.orange;
    
    /**versionCol variable of MenuState object*/
    public Color versionCol = Color.DARK_GRAY;
    
    
    
    /**Constructor*/
    
    
    /**
    * MenuState(StateManager statemanager)
    * 
    * Creates a new MenuState object
    * 
    */
    public MenuState() {
        System.out.println("MenuState: New Menu State Created");
        
        //Setup MenuState: Button Images
        playOffBtn = new Texture("/menu/play_off1").getImage();
        playOnBtn = new Texture("/menu/play_on1").getImage();
        optionsOffBtn = new Texture("/menu/options_off1").getImage();
        optionsOnBtn = new Texture("/menu/options_on1").getImage();
        helpOffBtn = new Texture("/menu/help_off1").getImage();
        helpOnBtn = new Texture("/menu/help_on1").getImage();
        quitOffBtn = new Texture("/menu/quit_off1").getImage();
        quitOnBtn = new Texture("/menu/quit_on1").getImage();
        aboutOffBtn = new Texture("/menu/about_off1").getImage();
        aboutOnBtn = new Texture("/menu/about_on1").getImage();

        //Setup MenuState: Arrow Images
        leftArrowIcon = new Texture("/menu/arrow1").getImage();
        rightArrowIcon = new Texture("/menu/arrow1R").getImage();
        
        try {
            //Setup MenuState: Background Images
            menuImage = ImageIO.read(MenuState.class.getResource("/menuState_1.png"));
            menuImage0 = ImageIO.read(MenuState.class.getResource("/menuState_1.png"));
            menuImage2 = ImageIO.read(MenuState.class.getResource("/menuState_2.png"));
            menuImage1 = ImageIO.read(MenuState.class.getResource("/menuState_3.png"));
            menuImage3 = ImageIO.read(MenuState.class.getResource("/menuState_4.png"));
        } catch (IOException ex) {
            Logger.getLogger(MenuState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**Public Protocol*/
    
    
    /**
    * tick(StateManager statemanager, Game game)
    * 
    * Updates MenuState Object
    * 
    * @param statemanager
    * @param game
    */
    @Override
    public void tick(StateManager statemanager, Game game){        
    }
    
    
    /**
     * render(Graphics2D g)
     * 
     * Renders/Repaints MenuState Objects
     * 
     * @param g
     */
    @Override
    public void render(Graphics2D g){
        MouseInput.MouseButton = 0;
        
        //Draw Background
        g.drawImage(menuImage, 0, -15, Game.getGameWidth(), Game.getGameHeight()-20, null);
        
        //Render help text
        Fonts.drawString(g, new Font("Times New Roman", Font.PLAIN, 16), hlpCol, "Use Key(s) W / UP Arrow & S / Down Arrow, or the mouse.", 76, Game.getGameHeight() - 122);
        Fonts.drawString(g, new Font("Times New Roman", Font.PLAIN, 16), hlpCol, "Enter key / Left Mouse button to select.", 76, Game.getGameHeight() - 102);
        
        
        //Draw Play Button
        if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 308 && MouseInput.MouseY < 308 + 60) {
                g.drawImage(playOffBtn, 106, 308, 160, 60, null);
                menuImage = menuImage0;
                hlpCol = Color.orange;
                versionCol = Color.DARK_GRAY;
                
                //Draw Play Button Arrows
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 164, 334, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 25, 334, 22, 20, null);
                }
                Display.setStatusBar("Play");
                
                //Set Play Button Click Logic
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    
                    System.out.println("MenuState: Play Selected");
                    //Game.getGame().setStart();
                    Game.getGame().setKeys();
                    //config.loadConfiguration("res/sys/config.xml");
                }
            } else {
                g.drawImage(playOnBtn, 106, 308, 160, 60, null);
            }

            //Draw Options Button
            if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 260 && MouseInput.MouseY > 372 && MouseInput.MouseY < 372 + 60) {
                g.drawImage(optionsOffBtn, 106, 372, 260, 60, null);
                menuImage = menuImage1;
                hlpCol = Color.red;
                versionCol = Color.white;
                
                //Draw Options Button Arrows
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 264, 392, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 24, 394, 22, 20, null);
                }
                Display.setStatusBar("Options Menu");
                
                //Set Options Button Click Logic
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();

                    System.out.println("MenuState: Options Selected");
                    Game.getGame().setOptions();
                }
                
            } else {
                g.drawImage(optionsOnBtn, 112, 372, 260, 60, null);
            }

            //Draw Help Button
            if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 432 && MouseInput.MouseY < 432 + 60) {
                g.drawImage(helpOffBtn, 106, 432, 160, 60, null);
                menuImage = menuImage2;
                hlpCol = Color.green;
                versionCol = Color.red;
                
                //Draw Help Button Arrows
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 164, 458, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 25, 458, 22, 20, null);
                }
                Display.setStatusBar("Help");
                
                //Set Help Button Click Logic
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    
                    System.out.println("MenuState: Help Selected");
                    Game.getGame().setInstructions();
                }
                
            } else {
                g.drawImage(helpOnBtn, 106, 432, 160, 60, null);
            }

            //Draw Quit Button
            if (MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 492 && MouseInput.MouseY < 492 + 60) {
                g.drawImage(quitOffBtn, 106, 492, 160, 60, null);
                menuImage = menuImage3;
                hlpCol = Color.blue;
                versionCol = Color.CYAN;
                
                //Draw Quit Button Arrows
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 106 + 164, 518, 22, 20, null);
                    g.drawImage(rightArrowIcon, 106 - 28, 518, 22, 20, null);
                }
		Display.setStatusBar("Quit?");
                
                //Set Quit Button Click Logic
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    Display.setStatusBar("Quit Game?");
                    
                    System.out.println("MenuState: Quit Selected");
                    Game.quitGame();
                }
                
            } else {
                g.drawImage(quitOnBtn, 106, 492, 160, 60, null);
            }
            
            //Draw About Button
            if (MouseInput.MouseX > 500 && MouseInput.MouseX < 500 + 80 && MouseInput.MouseY > 630 && MouseInput.MouseY < 630 + 30) {
                g.drawImage(aboutOffBtn, 500, 630, 80, 30, null);
                
                //Draw About Button Arrows
                if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                    g.drawImage(leftArrowIcon, 500 + 80, 634, 22, 20, null);
                    g.drawImage(rightArrowIcon, 500 - 28, 634, 22, 20, null);
                }
		Display.setStatusBar("About");
                
                //Set About Button Click Logic
                if (MouseInput.MouseButton == 1) {
                    Sound.stopAll();
                    Sound.btnPushed.play();
                    
                    System.out.println("MenuState: About Selected");
                    
                    Game.getGame().setAbout();
                }
                
            } else {
                g.drawImage(aboutOnBtn, 500, 630, 80, 30, null);
            }
            
            //Draw Version
            Fonts.drawString(g, new Font("Times New Roman", Font.PLAIN, 12), versionCol, Game.version, 350, 310);
            
            if(!(MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 308 && MouseInput.MouseY < 308 + 60) && !(MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 260 && MouseInput.MouseY > 372 && MouseInput.MouseY < 372 + 60) && !(MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 432 && MouseInput.MouseY < 432 + 60) && !(MouseInput.MouseX > 106 && MouseInput.MouseX < 106 + 160 && MouseInput.MouseY > 492 && MouseInput.MouseY < 492 + 60) && !(MouseInput.MouseX > 500 && MouseInput.MouseX < 500 + 80 && MouseInput.MouseY > 630 && MouseInput.MouseY < 630 + 30)){
                Display.setStatusBar("Ready");
            }
            
    }

    
    /**
    * init()
    * 
    */
    @Override
    public void init() {
        System.out.println("MenuState: Initiating Menu State . . .");
    }

    
    /**
    * enter()
    * 
    */
    @Override
    public void enter() {
        System.out.println("MenuState: Entering Menu State . . .");
        Sound.stopAll();
        Sound.Menu4.loop();
    }

    
    /**
    * exit()
    * 
    */
    @Override
    public void exit() {
        System.out.println("MenuState: Exiting Menu State . . .");
        Sound.stopAll();
    }

    
    /**
    * getName()
    * 
    * @return "menu" - name of State
    */
    @Override
    public String getName() {
        return "menu";
    }

    
}
