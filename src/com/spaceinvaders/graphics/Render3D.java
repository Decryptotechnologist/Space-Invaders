/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.graphics;

import com.spaceinvaders.pkg2018.Game;
import java.util.List;

/**
 * Render3D objects represent 
 * 
 * @author(s) The Cherno, Ghomez
 */
class Render3D extends Render {

    /**Attributes*/
    
    /**zBuffer variable of Render3D object*/
    public double[] zBuffer;
	
    /**renderDistance variable of Render3D object*/
    public double renderDistance = 5.0;
    
    /**forwardGlobal variable of Render3D object*/
    private double forwardGlobal;

    /**minBrightness variable of Render3D object*/
    private final int minBrightness = 0;
    
    /**maxBrightness variable of Render3D object*/
    private final int maxBrightness = 255;
    
    /**cosine variable of Render3D object*/
    public double cosine;
    
    /**sine variable of Render3D object*/
    public double sine;
    
    /**brightness variable of Render3D object*/
    private int brightness;
    
    /**stars variable of Render3D object*/
    private List<Star> stars;

    
    
    /**Constructor*/
    
    
    /**
    * Render3D(int width, int height)
    * 
    * @param height - the height of Render3D
    * @param width - the width of Render3D
    */
    public Render3D(int width, int height) {
        super(width, height);
        System.out.println("Render3D: New Render3D Created");
	zBuffer = new double[width * height];
    }
    
    
    /**Public Protocol*/

    
    /**
     * Space()
     * 
     */
    public void Space(){
        double floorPos = 38;//8;
        double ceilingPos = 38;//8;
        double forward = Game.time * 20.0;//game.player.z;
	double right = Game.player.x * 25.0;//Math.sin(game.time / 36.0) * 0.8;//game.time * 2.0;//game.player.x;
	double up = Math.cos(Game.time / 36.0) * 1.8;//game.player.y;
	double rotation = 0;//game.player.rotation;//-Math.sin(game.time / 36.0) * 1.4;//game.player.rotation;
		
	forwardGlobal += Math.sin(Game.time * 36.0) * 0.8;//forward;
	cosine = Math.cos(rotation);
	sine = Math.sin(rotation);
	
	for(int x = 0; x < width; x++){
            zBuffer[x] = 5000;
	}
	
	double flying = Math.sin(Game.time / 36.0) * 2.8;
		
	for(int y = 0; y < height; y++){
			
            double ceiling = (y + -height / 2.0) / height;
            double z; 
			
            z = (floorPos + up + flying) / ceiling;
			
            if(ceiling < 0){
		z = (ceilingPos - up - flying) / -ceiling;
            }
						
            for(int x = 0; x < width; x++){
		double depth = (x - width / 2.0) / height;
		depth *= z;
		double xx = depth * cosine + z * sine;
		double yy = z * cosine - depth * sine;
		int xPix = (int) (xx + right);
		int yPix = (int) (yy + forward);
		zBuffer[x + y * width] = z;

                pixels[x + y * width] = Texture.space0.pixels[(5 + (xPix & 15)) + (5 + (yPix  & 15)) * 128];// & 0xffffff;
				
		if(y < 330 - (z - 110)){
                    pixels[x + y * width] = Texture.space0.pixels[(5 + (xPix & 15)) + (5 + (yPix  & 15)) * 128];// & 0xffffff;
		}
                
            }
	}

    }
	
    
    /**
     * Stars()
     * 
     */
    public void Stars(){
        
	stars = Star.getAll();
        
        for (Star star : stars) {    
            int x = (int) star.x;// random.nextDouble();
            int y = (int) star.y;//random.nextDouble();
            int z = (int) star.z;// - 10.8 - forward/8;//10.8 - forwardGlobal / 16;
            int col = star.col;//0xff00ff;
        
            for(int i = 0; i < 100; i++){
                double xx = x;//random.nextDouble();
                double yy = y;//random.nextDouble();
                double zz = z + 10.8 - forwardGlobal;// / 16;
                
                int xPixel = (int) (xx / zz * star.height + star.width);
                int yPixel = (int) (yy / zz * star.height + star.height);

			
                if(xPixel >= 0 && yPixel >= 0 && xPixel < width && yPixel < height){
                    pixels[xPixel + yPixel * width] = col;//0xff0000;
                    zBuffer[xPixel + yPixel * width] = z;
                }
            }
        }
        
    }
    
    
    /**
     * renderDistanceLimiter()
     * 
     */
    public void renderDistanceLimiter(){
	for(int i = 0; i < width * height; i++){
            int colour = pixels[i];
            brightness = (int) (renderDistance / zBuffer[i]);
            if(brightness < minBrightness){
		brightness = minBrightness;
            }
            if(brightness > maxBrightness){
		brightness = maxBrightness;
            }
			
            int r = (colour >> 16) & 0xff;
            int g = (colour >> 8) & 0xff; 
            int b =  (colour) & 0xff;
			
            r = r * brightness / 255;
            g = g * brightness / 255;
            b = b * brightness / 255;
			
            pixels[i] = r << 16 | g << 8 | b;
			
	}
    }
    
    
}
