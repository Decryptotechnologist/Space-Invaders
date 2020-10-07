/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.states;

import com.spaceinvaders.pkg2018.*;
import java.awt.Graphics2D;

/**
 * @author Ghomez
 * 
 */
public interface State {
    
    /**Public Protocol*/
    
    
    /**
    * init()
    */
    public void init();
    
    
    /**
    * enter()
    */
    public void enter();
    
    
    /**
    * exit()
    */
    public void exit();
    
    
    /**
    * tick(StateManager statemanager, Game game)
    * 
    * Updates State Object
    * 
    * @param statemanager
    * @param game
    */
    public void tick(StateManager statemanager, Game game);
    
    
    /**
    * render(Graphics2D g)
    * 
    * Renders/Repaints State Objects
    * 
    * @param g
    */
    public void render(Graphics2D g);
    
    
    /**
    * getName()
    * 
    * @return "name" - name of State
    */
    public String getName();
    
    
}
