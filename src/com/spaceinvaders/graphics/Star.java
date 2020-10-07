/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.graphics;

import com.spaceinvaders.pkg2018.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ghomez
 */
public class Star {
 
    /**Attributes*/
    
    /**x coordinate of Star object*/
    public double x;

    /**y coordinate of Star object*/
    public double y;
    
    /**z coordinate of Star object*/
    public double z;
    
    /**spawnX coordinate of Star object*/
    public int spawnX;

    /**spawnY coordinate of Star object*/
    public int spawnY;
    
    /**spawnZ coordinate of Star object*/
    public int spawnZ;
    
    /**col variable of Star object*/
    public int col = 0xf0f0f0;

    /**height variable of Star object*/
    public double height;

    /**width variable of Star object*/
    public double width;

    /**starSpeed of travel of Star object*/
    public static double starSpeed = 0.8;

    /**Speed of travel of Star object*/
    public int speed = 0;
    
    /**height variable of Star and its linked Rectangle object*/
    public static double h = Game.getGameHeight() / 2.46;//325;//75;//400;

    /**width variable of Star object*/
    public static double w = Game.getGameWidth() / 2.26;//265;//75;//300;

    /**isDead (true/false) value of Star object*/
    public boolean isDead;

    /**references a List of Star objects*/
    public static List<Star> stars = new ArrayList<>();
    
    /**references a List of Star objects*/
    public static List<Star> starsA = new ArrayList<>();
    
    
    //Set bounderies of Spawn Zone 75 x 75 x 75(x, y, z) in the centre of screen and 3D space
    /**spawnZone_Width coordinate of Star object*/
    public static double spawnZone_Width;// = Display.getGameHeight()/8;//[75]
    
    /**spawnZone_Height coordinate of Star object*/
    public static double spawnZone_Height;// = Display.getGameHeight()/8;//[75]
    
    /**spawnZone_X coordinate of Star object*/
    public static double spawnZone_X;// = Display.getGameWidth()/2 - (spawnZone_Width/2);//[262.5]
    
    /**spawnZone_Y coordinate of Star object*/
    public static double spawnZone_Y;// = Display.getGameHeight()/2 - (spawnZone_Height/2);//[362.5]
    
    /**spawnZone_Z coordinate of Star object*/
    public static double spawnZone_Z;// = 5000 - Display.getGameWidth()/8;//[4925]
    
    /**random variable of Star object*/
    private static final Random random = new Random();
    
    
    /**Constructor*/
    
    
    /**
    * Star(double x, double y, double z, int speed, boolean isDead, int col)
    *
    * @param x - the x coordinate of Star object
    * @param y - the y coordinate of Star object
    * @param z - the x coordinate of Star object
    * @param speed - the speed coordinate of Star object
    * @param isDead - the isDead boolean of Star object
    * @param col - the col coordinate of Star object
    */
    public Star(double x, double y, double z, int speed, boolean isDead, int col) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.speed = speed;
        this.isDead = isDead;
        this.height = h;
        this.width = w;
        this.col = col;        
    }

    
    /**Public Protocol*/
    
    
    /**
    * initStars()
    * 
    * Initialises a set of Star objects
    */
    public static void initStars() {
        //System.out.println("Star: Initiating Stars . . .");
        spawnZone_Width = Game.getGameWidth();
        spawnZone_Height = Game.getGameHeight();
        spawnZone_X = 0;
        spawnZone_Y = 0;
        spawnZone_Z = 3000 - Game.getGameWidth()/8;
        
        for (int t = 0; t < random.nextInt(5) +8; t++) {
            //random x between spawnZone_X [262.5] & spawnZone_X + spawnZone_Width [75] = [337.5]
            double rX = (int) spawnZone_X + random.nextInt() % spawnZone_Width;
            
            //random y between spawnZone_Y [362.5] & spawnZone_Y + spawnZone_Height [75] = [437.5]
            double rY = (int) spawnZone_Y + random.nextInt() % spawnZone_Height;
            
            //random z between spawnZone_Z [4925] & 5000
            double rZ = (int) spawnZone_Z + random.nextInt(10)+1;
            
            int rSpeed = random.nextInt(4);
            
            //add new Star to stars
            stars.add(new Star(rX, rY, rZ, rSpeed, false, 0xffffff));
            
        }
    
    }

    
    /**
    * move(int id)
    * 
    * Moves each of the Star objects
    * (depending how many Star objects remain in stars List) in the
    * direction negative Z, after checking
    * that the Star object isDead value is false
    *
    * @param id - the id reference of an Star object (within stars List)
    */
    public static void move(int id) {
        Star star = stars.get(id);
            if (star.isDead == false) {
                    if (star.z > 0) {
                        
                        switch(star.speed){
                            case 0:
                                star.z -= starSpeed * (18 +random.nextInt(10));//18;
                                break;
                        
                            case 1:
                                star.z -= starSpeed * (24 + random.nextInt(20));//18;
                                break;
                        
                            case 2:
                                star.z -= starSpeed * (48 + random.nextInt(30));//18;
                                break;
                        
                            case 3:
                                star.z -= starSpeed * (72 + random.nextInt(40));//18;
                                break;
                        
                            case 4:
                                star.z -= starSpeed * (180 + random.nextInt(20));//18;
                                break;
                        }
                        
                        
                        if(star.y < Game.getGameHeight()/2 -1){
                            star.y -= 0.1 + random.nextInt(5);
                        }
                        if(star.y > Game.getGameHeight()/2) {
                            star.y += 0.1 + random.nextInt(5);
                        }
                    
                        if(star.x > Game.getGameWidth()/2){
                            star.x += (0.1 + random.nextInt(5));// + game.player.StarzX;
                        } 
                        if(star.x < Game.getGameWidth()/2-1){
                            star.x -= (0.1 + random.nextInt(5));// - game.player.StarzX;
                        }
                    
                        star.col = random.nextInt(0xffffff);
                        
                        star.height++;
                        star.width++;
                    }
                    
            } else {
                starHit(id);
            }
       
    }
    
    
    /**
    * starHit(int id)
    * 
    * The Star objects (referenced by id) isDead
    * value is changed to true.
    *
    * @param id - the id reference of an Star object (within stars List)
    */
    public static void starHit(int id) {
        stars.get(id).isDead = true;
    }

    
    /**
    * tick()
    * 
    * Updates Star Object
    */
    public static void tick(){
        stars = Star.getAll();
            
        if(random.nextInt(4500) % 25 == 0){// || stars.isEmpty()){
            initStars();
        }
        for(int i = 0; i < stars.size(); i++){
            move(i);
        }
    }
    
    
    /**
    * getY(int id)
    * 
    * Returns the y value of the Star object referenced by id
    *
    * @param id - the id reference of an Star object (within stars List)
    * @return stars.get(id).y
    */
    public double getY(int id) {
        return stars.get(id).y;
    }

    
    /**
    * getX(int id)
    * 
    * Returns the x value of the Star object referenced by id
    *
    * @param id - the id reference of an Star object (within stars List)
    * @return stars.get(id).x
    */
    public double getX(int id) {
        return stars.get(id).x;
    }

    
    /**
    * getAll()
    * 
    * Returns the List of the Star objects referenced by stars
    *
    * @return stars
    */
    public static List<Star> getAll() {
        starsA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < stars.size(); i++) {
            if (stars.get(i).isDead == false) {
                starsA.add(j, stars.get(i));
                j++;
            }
        }
        
        return starsA;
    }

    
    /**
    * clearAll()
    * 
    * Clears the List of the Star objects referenced by stars
    *
    */
    public static void clearAll() {
        for (int i = 0; i < stars.size(); i++) {
            stars.get(i).isDead = true;
        }
        stars.clear();
    }

}
