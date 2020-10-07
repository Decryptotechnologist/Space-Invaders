/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.input;

import com.spaceinvaders.menu.Menu;
import com.spaceinvaders.menu.PauseMenu;
import com.spaceinvaders.pkg2018.Game;
import com.spaceinvaders.pkg2018.Sound;
import com.spaceinvaders.player.Player;
import java.awt.event.*;

/**
 * @author The Cherno, Matt The Potatoe, Ghomez
 */
public class KeyInput extends KeyAdapter implements FocusListener {

    /**Attributes*/                                      
       
    /**NUM_KEYS variable of KeyInput object*/
    private static final int NUM_KEYS = 256;
    
    /**keys variable of KeyInput object*/
    public static final boolean[] keys = new boolean[NUM_KEYS];
    
    /**lastkeys variable of KeyInput object*/
    private static final boolean[] lastKeys = new boolean[NUM_KEYS];
    
    /**up boolean of KeyInput object*/
    private static boolean up;
    
    /**down boolean of KeyInput object*/
    private static boolean down;
    
    /**left boolean of KeyInput object*/
    private static boolean left;
    
    /**right boolean of KeyInput object*/
    private static boolean right;
    
    /**fire boolean of KeyInput object*/
    private static boolean fire;
    
    
    /**Public Protocol*/
    
    
    /**
     * keyReleased(KeyEvent e)
     * 
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    
    /**
     * keyPressed(KeyEvent e)
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    
    
    /**
     * tick(Game game, Menu menu, Player player)
     * 
     * @param game
     * @param menu
     * @param player
     */
    public static void tick(Game game, Menu menu, Player player){
        
        up = false;
        down = false;
        left = false;
        right = false;
        fire = false;
        
        up = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
        fire = keys[KeyEvent.VK_SPACE];

        if(fire) {
            keys[KeyEvent.VK_SPACE] = false;
        }

        if(keys[KeyEvent.VK_ESCAPE]) {
            keys[KeyEvent.VK_ESCAPE] = false;
            if (menu == null) {
                game.setMenu(new PauseMenu());
                Game.Paused = true;
            } else {
                game.setMenu(null);
                Game.Paused = false;
                Sound.Paused.stop();
            }
        }
        
        if (menu != null) {
            menu.tick(game, up, down, left, right, fire);
        } else {
            if(game.hasFocus()){
                player.tick(game, up, down, left, right, fire);
            }
        }
        
        for(int i = 0; i < NUM_KEYS; i++){
            lastKeys[i] = keys[i];
        }
    }
    
    
    /**
     * focusGained(FocusEvent e)
     * 
     * @param e
     */
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    
    /**
     * focusLost(FocusEvent e)
     * 
     * @param e
     */
    @Override
    public void focusLost(FocusEvent e) {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }
    }
     
    
    /**
     * isKeyDown(int key)
     * 
     * @param key
     * @return 
     */
    public static boolean isKeyDown(int key){
        return keys[key];
    }
    
    
    /**
     * wasPressed(int key)
     * 
     * @param key
     * @return 
     */
    public static boolean wasPressed(int key){
        return isKeyDown(key) && !lastKeys[key];
    }
    
    
    /**
     * wasReleased(int key)
     * 
     * @param key
     * @return 
     */
    public static boolean wasReleased(int key){
        return !isKeyDown(key) && lastKeys[key];
    }
    
    
}
