package com.spaceinvaders.barricade;

import com.spaceinvaders.explodes.BRCExplode;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Barricade objects represent the Barricades in the game
 * represented by a small green islands that dissolve when 
 * hit by bullet fire.
 * 
 * @author(s) Ghomez
 */
public class Barricade {
        
    /**Attributes*/
    
    /**xSpace0 variable of Barricade object */
    private static int xSpace0;// = 45;
    
    /**xSpace1 variable of Barricade object */
    private static int xSpace1;// = 65;
    
    /**BRC_y variable of Barricade object */
    private static int BRC_y;// = 550;
    
    /**BRCr_w variable of Barricade object */
    private static int BRCr_w;// = 18;
    
    /**BRCr_h variable of Barricade object */
    private static int BRCr_h;// = 12;
    
    /**BRC List of Barricade object */
    public static List<Barricade> BRC = new ArrayList<>();
    
    /**Barz1A List of Barricade object */
    private static List<Barricade> Barz1A;
    
    /**barricadeColor variable of Barricade object*/ 
    public static int barricadeColor;
    
    /**offSet variable of Barricade object*/
    private static int offSet;
    
    /**noBRC variable of Barricade object*/ 
    public static int noBRC;// = 3;
    
    /**id variable of Barricade object */
    public int id;
    
    /**x coordinate of Barricade object */
    public int x;
    
    /**y coordinate of Barricade object */
    public int y;
    
    /**BRRectHeight variable of Barricade Rectangle Object */
    public static int BRRectHeight;// = 135 / 12;
    
    /**BRRectWidth variable of Barricade Rectangle Object */
    public static int BRRectWidth;// = 100 / 18;
	
    /**isDead (true/false) value of Barricade object*/
    public boolean isDead;
        
    /**visible (true/false) value of Barricade object*/
    public boolean visible;
        
    /**Barz1 List of Barricade objects*/
    public static List<Barricade> Barz1 = new ArrayList<>();
    
    /**BarricadeRect List of Barricade Rectangle objects*/
    public static List<Rectangle> BarricadeRect = new ArrayList<>();
    
    /**BRCscale variable of Barricade object */
    public static double BRCscale;// = 0.25;
    
    
    
    /**Constructor*/
        
    /**
    * Initialises a new Barricade object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, this.visible 
    * set to vis
    * 
    * @param id - the id variable of Barricade
    * @param x - the x coordinate of Barricade
    * @param y - the y coordinate of Barricade
    * @param isDead - the isDead boolean of Barricade
    * @param vis - the visibility boolean of Barricade
    */ 
    public Barricade(int id, int x, int y, boolean isDead, boolean vis){
	this.id = id;
        this.x = x;
	this.y = y;
	this.isDead = isDead;
	this.visible = vis;
    }
    
    
    
    /**Public Protocol*/
        
    
    /**
    * initBarz()
    * 
    * Initialises a row of Barricade objects
    * and their linked Rectangle object into 
    * two separate lists
    */
    public static void initBarz(){
        setUp();
        System.out.println("Initiating Barricades . . .");
        System.out.println("No. of Barricades:"+ noBRC);
        
        switch(noBRC){
            case 1:
                //Set offSet
                offSet = (4 - noBRC)/2;

                for(int t = 0 + offSet; t < noBRC + offSet; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);

                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + 45 + (t * xSpace1) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);

                            if(r1.x > 260 && r1.x < 320 && r1.y < 582 && r1.y > 530 || 
                            r1.x > 235 && r1.x < 250 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 335 && r1.x < 360 && r1.y < 510 && r1.y > 458){

                            } else {
                                //Add Rectangle to BarricadeRect List
                                BarricadeRect.add(r1);
                            }
                        }
                    }
                }
                
                break;
                
            case 2:
                //Set offSet
                offSet = (4 - noBRC)/2;
            
                for(int t = 0 + offSet; t < noBRC + offSet; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);

                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + -55 + (t * xSpace1) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);

                            if(x1 > 160 && x1 < 220 && y < 582 && y > 530 || 
                            x1 > 355 && x1 < 415 && y < 582 && y > 530 ||

                            x1 > 135 && x1 < 155 && y < 520 && y > 468 || 
                            x1 > 225 && x1 < 245 && y < 520 && y > 468 || 
                            x1 > 330 && x1 < 350 && y < 520 && y > 468 || 
                            x1 > 420 && x1 < 440 && y < 520 && y > 468){

                            } else {
                                //Add Rectangle to BarricadeRect List
                                BarricadeRect.add(r1);
                            }
                        }
                    }
                }
                
                break;
                
            case 3:
                for(int t = 0; t < noBRC; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);
                
                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + xSpace0 + (t * xSpace1) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);

                            if(r1.x > 65 && r1.x < 125 && r1.y < 582 && r1.y > 530 || 
                            r1.x > 260 && r1.x < 320 && r1.y < 582 && r1.y > 530 || 
                            r1.x > 455 && r1.x < 515 && r1.y < 582 && r1.y > 530 || 
                            r1.x > 35 && r1.x < 55 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 235 && r1.x < 250 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 420 && r1.x < 445 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 135 && r1.x < 160 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 335 && r1.x < 360 && r1.y < 510 && r1.y > 458 || 
                            r1.x > 525 && r1.x < 565 && r1.y < 510 && r1.y > 458){

                            } else {
                                //Add Rectangle to BarricadeRect List
                                BarricadeRect.add(r1);
                            }
                        }
                    }
                }
                
                break;
                
            case 4:
                //Set offSet
                offSet = (4 - noBRC)/2;
            
                for(int t = 0 + offSet; t < noBRC + offSet; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);

                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + 20 + (t * 50) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);

                            if(x1 > 40 && x1 < 100 && y < 582 && y > 530 || 
                            x1 > 190 && x1 < 250 && y < 582 && y > 530 || 
                            x1 > 340 && x1 < 400 && y < 582 && y > 530 || 
                            x1 > 490 && x1 < 550 && y < 582 && y > 530 || 

                            x1 > 15 && x1 < 35 && y < 520 && y > 468 || 
                            x1 > 105 && x1 < 125 && y < 520 && y > 468 || 
                            x1 > 165 && x1 < 185 && y < 520 && y > 468 || 
                            x1 > 255 && x1 < 275 && y < 520 && y > 468 || 
                            x1 > 315 && x1 < 335 && y < 520 && y > 468 || 
                            x1 > 405 && x1 < 425 && y < 520 && y > 468 ||
                            x1 > 555 && x1 < 575 && y < 520 && y > 468 || 
                            x1 > 465 && x1 < 485 && y < 520 && y > 468){

                            } else {
                                //Add Rectangle to BarricadeRect List
                                BarricadeRect.add(r1);
                            }
                        }
                    }
                }
                
                break;
                
            case 5:
                for(int t = 0; t < noBRC; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);

                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + xSpace0 + (t * xSpace1) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);
                            //Add Rectangle to BarricadeRect List
                            BarricadeRect.add(r1);
                        }
                    }
                }
                
                break;
                
            case 6:
                for(int t = 0; t < noBRC; t++) {
                    //Set x
                    int x = xSpace0 + (t * xSpace1) * 3;
                    //Create New Barricade
                    Barricade b1 = new Barricade(t, x, BRC_y, false, true);
                    //Add Barricade to Barz1 List
                    Barz1.add(b1);

                    //Split each BRC into 18 * 12 rectangles
                    for(int t1 = 0; t1 < BRCr_w; t1++) {
                        for(int t2 = 0; t2 < BRCr_h; t2++) {
                            //Set x1
                            int x1 = t1 * 6 + xSpace0 + (t * xSpace1) * 3;
                            //Set y
                            int y = BRC_y + (t2 * 8);
                            //Create New Rectangle
                            Rectangle r1 = new Rectangle(x1, y, BRRectWidth, BRRectHeight);
                            //Add Rectangle to BarricadeRect List
                            BarricadeRect.add(r1);
                        }
                    }
                }
                
                break;
                
        }
        
                
    }

    
    /**
    * setUp()
    * 
    * Setup Barricade Objects
    */
    public static void setUp(){
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                BRCr_w = 9;
                BRCr_h = 6;

                xSpace0 = 25;
                xSpace1 = 35;
                BRC_y = Game.getGameHeight()-175;//550;

                BRRectWidth = 100 / BRCr_w;
                BRRectHeight = 135 / BRCr_h;
            
                break;
                
            case 480:
                BRCr_w = 18;
                BRCr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                BRC_y = 550;

                BRRectWidth = 100 / BRCr_w;
                BRRectHeight = 135 / BRCr_h;
            
                break;
                
            case 604:
                BRCr_w = 18;
                BRCr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                BRC_y = Game.getGameHeight()-230;//550;

                BRCscale = 0.25;

                BRRectWidth = 180 / BRCr_w;
                BRRectHeight = 115 / BRCr_h;
                
                break;
                
            default:
                BRCr_w = 18;
                BRCr_h = 12;

                xSpace0 = 45;
                xSpace1 = 65;
                BRC_y = Game.getGameHeight()-230;//550;

                BRCscale = 0.25;

                BRRectWidth = 180 / BRCr_w;
                BRRectHeight = 115 / BRCr_h;
                
                break;
                
        }
        

    }
    
    
    /**
    * Barricade Rectangle objects (referenced by id) 
    * is removed and a BRCXDetonate(BarricadeRect)
    * message is fired. 
    * 
    * @param id - the id reference of an Barricade Rectangle object
    */
    public void BRCHit(int id){
        //Fire Barricade Explode
	BRCExplode.BRCXDetonate(BarricadeRect.get(id));
        //Set Barricade Rectangle dead: id
        dead(id);
    }

    
    /**
    * tick()
    * 
    * Updates Barricade Objects
    */
    public static void tick(){
        //Update All Barricades
        BRC = Barricade.getAll();
        //Update All Barricade Rectangles
        BarricadeRect = Barricade.getAllRect();
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints Barricade Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g){
        //Draw Barricades
        for(int i = 0; i < BarricadeRect.size(); i++){
            if(Display.showBounds){
                //Draw Bounds
                g.setColor(Color.cyan);
                g.drawRect(BarricadeRect.get(i).x+8, BarricadeRect.get(i).y, BarricadeRect.get(i).width, BarricadeRect.get(i).height);
                g.drawString("BRC: id:"+i+" x:"+BarricadeRect.get(i).x+" y:"+BarricadeRect.get(i).y, BarricadeRect.get(i).x, BarricadeRect.get(i).y);
            }
            //Render Barricades
            target.scaleDraw(Texture.BRC, BRCscale, BarricadeRect.get(i).x, BarricadeRect.get(i).y, 0,0,64,64, barricadeColor);
        } 
    }
    
    
    /**
    * Returns the List of the Barricade 
    * objects referenced by Barz1
    * 
    * @return Barz1A
    */
    public static List<Barricade> getAll() {
        Barz1A = new ArrayList<>();
        int j = 0;
        
        //Remove All Dead Barricades
        for (int i = 0; i < Barz1.size(); i++) {
            if (Barz1.get(i).isDead == false) {
                Barz1A.add(j, Barz1.get(i));
                
                j++;
            }
        }
        
        //Return All Barricades: Barz1A
        return Barz1A;
    }

    
    /**
    * Returns the List of the Rectangles 
    * referenced by BarricadeRect 
    * 
    * @return BarricadeRect
    */	
    public static List<Rectangle> getAllRect() {   
        //Return All Barricade Rectangles
	return BarricadeRect;
    }

    
    /**
    * dead(int k)
    * 
    * @param k
    */
    public void dead(int k) {
        //Remove Barricade Rectangle: k
        BarricadeRect.remove(k);
    }
    
    
    /**
    * clearAll()
    * 
    */
    public static void clearAll() {
        //Clear All Barricades
        Barz1.clear();
        //Clear All Barricade Rectangles
        BarricadeRect.clear();
    }
    
    
    /**
    * setNoBarricades(int brc)
    * 
    * @param brc
    */
    public static void setNoBarricades(int brc) {
        //Set No. of Barricades: col
        noBRC = brc;
    }
    
    
    /**
    * setBarricadeCol(int col)
    * 
    * @param col
    */
    public static void setBarricadeCol(int col) {
        //Set Barricade Color: col
        barricadeColor = col;
    }

    
}
