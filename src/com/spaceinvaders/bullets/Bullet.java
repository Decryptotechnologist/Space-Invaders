/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.bullets;

import com.spaceinvaders.barricade.Barricade;
import com.spaceinvaders.pkg2018.*;
import com.spaceinvaders.enemies.Enemy;
import com.spaceinvaders.level.Level;
import com.spaceinvaders.player.Player;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Ghomez
 */
public class Bullet {
    
    /**Attributes*/
    
    /**x coordinate of Bullet object */
    public int x;
        
    /**y coordinate of Bullet object */
    public int y;
        
    /**height of Bullet object*/
    public int height;
        
    /**width of Bullet object */
    public int width;
        
    /**width of Bullet and its linked Rectangle object*/
    public static int w;

    /**height of Bullet and its linked Rectangle object*/
    public static int h;
    
    /**isDead (true/false) value of Bullet object*/
    public boolean isDead;
    
    /**bulletSpeed of Bullet object*/
    public static int bulletSpeed;

    /**enBulletScale variable of Bullet object */
    public static double enBulletScale;
    
    /**enBulletXoffs variable of Bullet object */
    public static int enBulletXoffs;
    
    /**enBulletYoffs variable of Bullet object */
    public static int enBulletYoffs;
    
    /**playerBulletScale variable of Bullet object */
    public static double playerBulletScale;
    
    /**playerBulletXoffs variable of Bullet object */
    public static int playerBulletXoffs;
    
    /**playerBulletYoffs variable of Bullet object */
    public static int playerBulletYoffs;
    
    /**EnBullCol variable of Bullet object */
    public static int EnBullCol;

    /**P1B variable of Bullet object */
    public static List<P1Bullet> P1B = new ArrayList<>();
    
    /**P1BA variable of Bullet object */
    public static List<P1Bullet> P1BA;
    
    /**EnBull variable of Bullet object */
    public static List<EnBullet> EnBull = new ArrayList<>();
    
    
    
    /**Constructor*/
    
    /**
    * Bullet()
    * 
    * Initialises a new Bullet object
    */
    public Bullet(){
        //System.out.println("Bullet: New Bullet Created");
        setUp();
    }
    
    
    /**Public Protocol*/
    
    
    /**
     * setUp()
     * 
     * Setup Bullet Objects
     */
    public static void setUp(){
        P1Bullet.setUp();
        EnBullet.setUp();
        
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                w = 10;
                h = 20;
            
                bulletSpeed = 9;
            
                break;
                
            case 480:
                w = 12;
                h = 25;
            
                bulletSpeed = 12;
            
                break;
                
            case 604:
                w = 15;
                h = 35;
            
                bulletSpeed = 17;
                break;
                
            default:
                w = 15;
                h = 35;
            
                bulletSpeed = 17;
                break;
                
        }
        
    }

    
    /**
    * tick()
    * 
    * Updates Bullet Objects
    */
    public static synchronized void tick(){
        //Check All Bullet Collisions
        checkCollisions();
        //Tick(Update) Player Bullets
        P1Bullet.tick();
        //Tick(Update) Enemy Bullets
        EnBullet.tick();
    }
    
    
    /**
    * move(Bullet b)
    * 
    * @param b - a Bullet instance
    */
    public static void move(Bullet b) {
        if(!Game.Paused) {
            if(b instanceof EnBullet){
                //Move Enemy Bullet: b
                EnBullet.move((EnBullet) b);
            } else if(b instanceof P1Bullet){
                //Move Player Bullet: b
                P1Bullet.move((P1Bullet) b);
            }
        }
    }
    
    
    /**
    * checkCollisions()
    * 
    */
    public static synchronized void checkCollisions() {
        
	//Check collisions between AllEnBulletRect&P1Rect
        for(int i = 0; i < EnBull.size(); i++){
            if(EnBull.get(i).isDead == false){
                    move(EnBull.get(i));
                    
                    //Check collisions between EnBullet & Player1						
                    if(EnBull.get(i).getBounds().intersects(Game.player.P1rect)){
                        if(!Game.Paused){
                            //message Player1 hit
                            Game.player.P1Hit();
                        }

                        //message EnBullet(id) hit
                        BulletHit(EnBull.get(i));								
                    }

                    //Check collisions between EnBullet & Barricade
                    for (Barricade BRC1 : Barricade.BRC) {
                        for (int k = 0; k < Barricade.BarricadeRect.size(); k++) {
                            if (EnBull.get(i).getBounds().intersects(Barricade.BarricadeRect.get(k))) {

                                //message EnBullet(id) hit
                                BulletHit(EnBull.get(i));

                                //message BarricadeRect(id) hit
                                BRC1.BRCHit(k);
                            }
                        }
                    }


                    //Check collisions between EnBullet & Ground		
                    if(EnBull.get(i).getBounds().intersects(Level.groundBounds)) {

                        //message EnBullet(id) hit
                        BulletHit(EnBull.get(i));
                    }

                    //Check collisions between P1Bullet&EnBullet		
                    for(int j = 0; j < P1B.size(); j++){
                        if(P1B.get(j).isDead == false){
                            if(EnBull.get(i).getBounds().intersects(P1B.get(j).getBounds())){

                                //message P1Bullet(id) hit
                                BulletHit(P1B.get(j));

                                //message EnBullet(id) hit
                                BulletHit(EnBull.get(i));

                                //add Score
                                Game.increaseScore(5);

                                //play sound
                                if(Game.getGameSound()){
                                    Sound.ricochet.play();
                                }
                            }
                        }	
                    }												
	
            }
        }

	//Check collisions between P1BulletRect&AllEnemyRect
	for(int i = 0; i < P1B.size(); i++){
            if(P1B.get(i).isDead == false){

                move(P1B.get(i));

                //Check collisions between P1Bullet & Barricade
                for (Barricade BRC1 : Barricade.BRC) {
                    for (int k = 0; k < Barricade.BarricadeRect.size(); k++) {
                        if (P1B.get(i).getBounds().intersects(Barricade.BarricadeRect.get(k))) {
                            
                            //message P1Bullet(id) hit
                            BulletHit(P1B.get(i));
                            
                            //message BarricadeRect(id) hit
                            BRC1.BRCHit(k);
                        }
                    }
                }
                                
		//Check collisions between P1Bullet&En1
		for(int c = 0; c < Enemy.EnemiAll.size(); c++){
                    if(Enemy.EnemiAll.get(c).isDead == false){
			if(P1B.get(i).getBounds().intersects(Enemy.EnemiAll.get(c).getBounds())){
							
                            //message P1Bullet(id) hit
                            BulletHit(P1B.get(i));
							
                            //message Enemy1(id) hit
                            Enemy.EnemyHit(Enemy.EnemiAll.get(c));
							
                            //add Score
                            Game.increaseScore(Enemy.EnemiAll.get(c));
                            
                            //play sound    
                            if(Game.getGameSound()){
                                Sound.EnExp.play();
                            }
			}

                    } 
                                        
                }
                
                
				
		//Check collisions between P1Bullet&EnUFO
		for(int c = 0; c < Enemy.EnemiUFO.size(); c++){
                    if(Enemy.EnemiUFO.get(c).isDead == false){
			if(P1B.get(i).getBounds().intersects(Enemy.EnemiUFO.get(c).getBounds())){
							
                            //message P1Bullet(id) hit
                            BulletHit(P1B.get(i));
							
                            //message UFO(id) hit
                            Enemy.EnemyHit(Enemy.EnemiUFO.get(c));
							
                            //add Score
                            Game.increaseScore(100);
                            Player.killShot += 1;
                                                        
                            //play sound
                            if(Game.getGameSound()){
                                Sound.EnExp.play();                                                        
                            }
                        }
													
                    } 

		}                           
                
                if (P1B.get(i).getBounds().intersects(Game.hud.ceilBounds)) {
                    BulletHit(P1B.get(i));
                }
            }
	}	
        
    }
    
    
    /**
    * BulletHit(Bullet b)
    * 
    * @param b - a Bullet instance
    */
    public static void BulletHit(Bullet b){
        if(b instanceof P1Bullet){
            //Player Bullet Hit: b
            P1Bullet.P1BHit((P1Bullet) b);
        } else if(b instanceof EnBullet){
            //Enemy Bullet Hit: b
            EnBullet.EnBHit((EnBullet) b);
        }
    }
    
    /**
    * setEnemyBulletCol(int col)
    * 
    * @param col - Color of Enemy Bullet
    */
    public static void setEnemyBulletCol(int col) {
        //Set Enemy Bullet Color: col
        EnBullCol = col;
    }
    
}
