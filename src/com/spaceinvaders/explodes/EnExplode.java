package com.spaceinvaders.explodes;

import com.spaceinvaders.enemies.*;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * EnExplode objects represent the explosion of Enemies in the game,
 * represented by a small 'animated explosion'.
 * 
 * @author(s) Ghomez
 */
public class EnExplode extends Explode {
	
    /**Attributes*/                                      
       
    /**count variable for EnExplode object*/
    private static int count = 0;
    
    /**EnExplodeAnim Animation for EnExplode object*/
    private static final Animation EnExplodeAnim = new Animation(2, 
            new Texture("/Sprites/SI_explode0"), 
            new Texture("/Sprites/SI_explode1"), 
            new Texture("/Sprites/SI_explode2")
    );
    
    
    /**Constructor*/
        
    /**
    * EnExplode(int x, int y, int h, int w, boolean isDead, int suit)
    * 
    * Initialises a new EnExplode object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w
    * 
    * @param x - the x coordinate of EnExplode
    * @param y - the y coordinate of EnExplode
    * @param h - the height of EnExplode
    * @param w - the width of EnExplode
    * @param isDead - the isDead boolean of EnExplode
    * @param suit - the suit of EnExplode
    */
    public EnExplode(int x, int y, int h, int w, boolean isDead, int suit){
	this.x = x;
	this.y = y;
	this.width = w;
	this.height = h;
	this.isDead = isDead;
        this.suit = suit;
    }
	
    
    /**Public Protocol*/
       
    
    /**
    * setUp()
    * 
    * Sets Up EnExplode Objects
    * 
    */
    public static void setUp(){
        int width = Game.getGameWidth();
        switch(width){
            case 300:
                enx_w = 12;
                enx_h = 17;

                enExScale_a = 0.25;
                enExScale_b = 0.15;
                enExScale_c = 0.2;
            
                break;
                
            case 480:
                enx_w = 25;
                enx_h = 35;

                enExScale_a = 0.5;
                enExScale_b = 0.3;
                enExScale_c = 0.4;
                
                break;
                
            case 604:
                enx_w = 25;
                enx_h = 35;

                enExScale_a = 0.5;
                enExScale_b = 0.3;
                enExScale_c = 0.4;
                
                break;
                
            default:
                enx_w = 25;
                enx_h = 35;

                enExScale_a = 0.5;
                enExScale_b = 0.3;
                enExScale_c = 0.4;
                
                break;
                
        }
        
    }
    
    
    /**
    * render()
    * 
    * Renders/Repaints EnExplode Objects
    * 
    * @param target
    * @param g
    */
    public static void render(Render target, Graphics2D g) {
        
        for (EnExplode EnXp0 : EnXP0) {
            if (EnXp0.isDead == false) {
                if(Display.showBounds){
                    g.setColor(Color.green);
                    g.drawRect(EnXp0.x+count, EnXp0.y-count, EnXp0.width, EnXp0.height);
                }
                switch (EnXp0.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp0.x+count, EnXp0.y+10-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp0.x-count, EnXp0.y+10-count, 25, 25);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp0.x+count, EnXp0.y+10-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp0.x-count, EnXp0.y+10-count, 35, 35);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp0.x+count, EnXp0.y+10-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp0.x-count, EnXp0.y+10-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        for (EnExplode EnXp1 : EnXP1) {
            if (EnXp1.isDead == false) {
                switch (EnXp1.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp1.x+count, EnXp1.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp1.x-count, EnXp1.y-count, 15, 15);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp1.x+count, EnXp1.y-count, 40, 40);
                        } else {
                            EnExplodeAnim.render(g, EnXp1.x-count, EnXp1.y-count, 40, 40);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp1.x+count, EnXp1.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp1.x-count, EnXp1.y-count, 25, 25);
                        }
                        break;
                }
            }
        }
            
        for (EnExplode EnXp2 : EnXP2) {
            if (EnXp2.isDead == false) {
                switch (EnXp2.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp2.x+count, EnXp2.y-count, 10, 10);
                        } else {
                            EnExplodeAnim.render(g, EnXp2.x-count, EnXp2.y-count, 10, 10);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp2.x+count, EnXp2.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp2.x-count, EnXp2.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp2.x+count, EnXp2.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp2.x-count, EnXp2.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
            
        for (EnExplode EnXp3 : EnXP3) {
            if (EnXp3.isDead == false) {
                switch (EnXp3.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp3.x+count, EnXp3.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp3.x-count, EnXp3.y-count, 25, 25);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp3.x+count, EnXp3.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp3.x-count, EnXp3.y-count, 35, 35);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp3.x+count, EnXp3.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp3.x-count, EnXp3.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
            
        for (EnExplode EnXp4 : EnXP4) {
            if (EnXp4.isDead == false) {
                switch (EnXp4.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp4.x+count, EnXp4.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp4.x-count, EnXp4.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp4.x+count, EnXp4.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp4.x-count, EnXp4.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp4.x+count, EnXp4.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp4.x-count, EnXp4.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        
        for (EnExplode EnXp5 : EnXP5) {
            if (EnXp5.isDead == false) {
                switch (EnXp5.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp5.x+count, EnXp5.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp5.x-count, EnXp5.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp5.x+count, EnXp5.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp5.x-count, EnXp5.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp5.x+count, EnXp5.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp5.x-count, EnXp5.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        
        for (EnExplode EnXp6 : EnXP6) {
            if (EnXp6.isDead == false) {
                switch (EnXp6.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp6.x+count, EnXp6.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp6.x-count, EnXp6.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp6.x+count, EnXp6.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp6.x-count, EnXp6.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp6.x+count, EnXp6.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp6.x-count, EnXp6.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        
        for (EnExplode EnXp7 : EnXP7) {
            if (EnXp7.isDead == false) {
                switch (EnXp7.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp7.x+count, EnXp7.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp7.x-count, EnXp7.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp7.x+count, EnXp7.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp7.x-count, EnXp7.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp7.x+count, EnXp7.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp7.x-count, EnXp7.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        for (EnExplode EnXp8 : EnXP8) {
            if (EnXp8.isDead == false) {
                switch (EnXp8.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp8.x+count, EnXp8.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp8.x-count, EnXp8.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp8.x+count, EnXp8.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp8.x-count, EnXp8.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp8.x+count, EnXp8.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp8.x-count, EnXp8.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        for (EnExplode EnXp9 : EnXP9) {
            if (EnXp9.isDead == false) {
                switch (EnXp9.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp9.x+count, EnXp9.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp9.x-count, EnXp9.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp9.x+count, EnXp9.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp9.x-count, EnXp9.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp9.x+count, EnXp9.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp9.x-count, EnXp9.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
        
        for (EnExplode EnXp10 : EnXPUFO) {
            if (EnXp10.isDead == false) {
                switch (EnXp10.suit) {
                    case 0:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp10.x+count, EnXp10.y-count, 35, 35);
                        } else {
                            EnExplodeAnim.render(g, EnXp10.x-count, EnXp10.y-count, 35, 35);
                        }
                        break;
                    case 1:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp10.x+count, EnXp10.y-count, 25, 25);
                        } else {
                            EnExplodeAnim.render(g, EnXp10.x-count, EnXp10.y-count, 25, 25);
                        }
                        break;
                    default:
                        if (Enemy.allDirection == 0) {
                            EnExplodeAnim.render(g, EnXp10.x+count, EnXp10.y-count, 15, 15);
                        } else {
                            EnExplodeAnim.render(g, EnXp10.x-count, EnXp10.y-count, 15, 15);
                        }
                        break;
                }
            }
        }
            
        //Draw EnExplode Text(Enemy0)
        for (EnExplode EnXpp : EnXP0) {
            if (EnXpp.isDead == false) {
                EnXpp.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$50", 3, EnXpp.x + 15+count, EnXpp.y - 10-count, Display.colours[5].getRGB());
                } else {
                    target.drawText("$50", 3, EnXpp.x + 15-count, EnXpp.y - 10-count, Display.colours[5].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy1)
        for (EnExplode EnXp1 : EnXP1) {
            if (EnXp1.isDead == false) {
                EnXp1.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$50", 3, EnXp1.x + 15+count, EnXp1.y - 10-count, Display.colours[5].getRGB());
                } else {
                    target.drawText("$50", 3, EnXp1.x + 15-count, EnXp1.y - 10-count, Display.colours[5].getRGB());
                }
            }
        }

        //Draw EnExplode Text(Enemy2)
        for (EnExplode EnXp21 : EnXP2) {
            if (EnXp21.isDead == false) {
                EnXp21.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$30", 2, EnXp21.x + 15+count, EnXp21.y - 10-count, Display.colours[8].getRGB());
                } else {
                    target.drawText("$30", 2, EnXp21.x + 15-count, EnXp21.y - 10-count, Display.colours[8].getRGB());
                }
            }
        }

        //Draw EnExplode Text(Enemy3)
        for (EnExplode EnXp31 : EnXP3) {
            if (EnXp31.isDead == false) {
                EnXp31.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$30", 2, EnXp31.x - 5+count, EnXp31.y - 5-count, Display.colours[8].getRGB());
                } else {
                    target.drawText("$30", 2, EnXp31.x - 5-count, EnXp31.y - 5-count, Display.colours[8].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy4)
        for (EnExplode EnXp41 : EnXP4) {
            if (EnXp41.isDead == false) {
                EnXp41.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$30", 2, EnXp41.x - 5+count, EnXp41.y - 5-count, Display.colours[8].getRGB());
                } else {
                    target.drawText("$30", 2, EnXp41.x - 5-count, EnXp41.y - 5-count, Display.colours[8].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy5)
        for (EnExplode EnXp51 : EnXP5) {
            if (EnXp51.isDead == false) {
                EnXp51.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$25", 2, EnXp51.x - 5+count, EnXp51.y - 5-count, Display.colours[8].getRGB());
                } else {
                    target.drawText("$25", 2, EnXp51.x - 5-count, EnXp51.y - 5-count, Display.colours[8].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy6)
        for (EnExplode EnXp61 : EnXP6) {
            if (EnXp61.isDead == false) {
                EnXp61.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$25", 2, EnXp61.x - 5+count, EnXp61.y - 5-count, Display.colours[1].getRGB());
                } else {
                    target.drawText("$25", 2, EnXp61.x - 5-count, EnXp61.y - 5-count, Display.colours[1].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy7)
        for (EnExplode EnXp71 : EnXP7) {
            if (EnXp71.isDead == false) {
                EnXp71.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$25", 2, EnXp71.x - 5+count, EnXp71.y - 5-count, Display.colours[1].getRGB());
                } else {
                    target.drawText("$25", 2, EnXp71.x - 5-count, EnXp71.y - 5-count, Display.colours[1].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy8)
        for (EnExplode EnXp81 : EnXP8) {
            if (EnXp81.isDead == false) {
                EnXp81.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$10", 2, EnXp81.x - 5+count, EnXp81.y - 5-count, Display.colours[4].getRGB());
                } else {
                    target.drawText("$10", 2, EnXp81.x - 5-count, EnXp81.y - 5-count, Display.colours[4].getRGB());
                }
            }
        }
        
        //Draw EnExplode Text(Enemy9)
        for (EnExplode EnXp91 : EnXP9) {
            if (EnXp91.isDead == false) {
                EnXp91.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$10", 2, EnXp91.x - 5+count, EnXp91.y - 5-count, Display.colours[4].getRGB());
                } else {
                    target.drawText("$10", 2, EnXp91.x - 5-count, EnXp91.y - 5-count, Display.colours[4].getRGB());
                }
            }
        }

        //Draw EnExplode Text(UFO)
        for (EnExplode EnXp101 : EnXPUFO) {
            if (EnXp101.isDead == false) {
                EnXp101.suit = Exsuit;

                if (Enemy.allDirection == 0) {
                    target.drawText("$100", 4, EnXp101.x - 15-count, EnXp101.y + 15-count, Display.colours[10].getRGB());
                } else {
                    target.drawText("$100", 4, EnXp101.x - 15+count, EnXp101.y + 15-count, Display.colours[10].getRGB());
                }
            }
        }
        
        if(count < 100){
            count++;
        } else {
            count = 0;
            EnExplode.clearAll();
        }
    }
    
    
    /**
    * tick()
    * 
    * Updates All EnExplode Objects
    */
    public static void tick(){
        EnXP0 = EnExplode.getAll0();
        EnXP1 = EnExplode.getAll1();
        EnXP2 = EnExplode.getAll2();
        EnXP3 = EnExplode.getAll3();
        EnXP4 = EnExplode.getAll4();
        EnXP5 = EnExplode.getAll5();
        EnXP6 = EnExplode.getAll6();
        EnXP7 = EnExplode.getAll7();
        EnXP8 = EnExplode.getAll8();
        EnXP9 = EnExplode.getAll9();
        EnXPUFO = EnExplode.getAllUFO();
        
        EnExplodeAnim.run();
        switchsuit();
    }
    
    
    /**
    * switchsuit()
    * 
    */
    public static void switchsuit(){	    
        if(Game.gameTimer % 2 == 0){
            Exsuit = 1;
        } else {
            if(Game.gameTimer % 1 == 0){
                Exsuit = 2; 
            } else {
                Exsuit = 0; 
            } 
        }    
    }
    
    
    /**
    * EnXDetonate(Enemy en)
    * 
    * Fires a Enemy Explosion, creating a new EnExplode 
    * object with Enemy1 objects x and y coordinates as a 
    * reference point
    * 
    * 
    * @param en - the Enemy0 object
    */    
    public static void EnXDetonate(Enemy en){
        random = new Random();
        EnExplode enx = new EnExplode((int) en.x + random.nextInt(5), (int) en.y, enx_w, enx_h, false, 0);
        
        if(en instanceof Enemy0){
            EnXP0.add(enx);
        } else if(en instanceof Enemy1){
            EnXP1.add(enx);
        } else if(en instanceof Enemy2){
            EnXP2.add(enx);
        } else if(en instanceof Enemy3){
            EnXP3.add(enx);
        } else if(en instanceof Enemy4){
            EnXP4.add(enx);
        } else if(en instanceof Enemy5){
            EnXP5.add(enx);
        } else if(en instanceof Enemy6){
            EnXP6.add(enx);
        } else if(en instanceof Enemy7){
            EnXP7.add(enx);
        } else if(en instanceof Enemy8){
            EnXP8.add(enx);
        } else if(en instanceof Enemy9){
            EnXP9.add(enx);
        } else if(en instanceof UFO){
            EnXPUFO.add(enx);
        }
    }
	
    
    /**
    * getAll0()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP0
    * 
    * @return EnXP0
    */
    public static List<EnExplode> getAll0() {
        EnXP0A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP0.size(); i++) {
            if (EnXP0.get(i).isDead == false) {
                EnXP0A.add(j, EnXP0.get(i));
                j++;
            }
        }
        
        return EnXP0A;
    }
    
    
    /**
    * getAll1()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP1
    * 
    * @return EnXP1
    */
    public static List<EnExplode> getAll1() {
        EnXP1A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP1.size(); i++) {
            if (EnXP1.get(i).isDead == false) {
                EnXP1A.add(j, EnXP1.get(i));
                j++;
            }
        }
        
        return EnXP1A;
    }

    
    /**
    * getAll2()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP2
    * 
    * @return EnXP2
    */
    public static List<EnExplode> getAll2() {
        EnXP2A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP2.size(); i++) {
            if (EnXP2.get(i).isDead == false) {
                EnXP2A.add(j, EnXP2.get(i));
                j++;
            }
        }
        
        return EnXP2A;
    }

    
    /**
    * getAll3()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP3
    * 
    * @return EnXP3
    */
    public static List<EnExplode> getAll3() {
        EnXP3A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP3.size(); i++) {
            if (EnXP3.get(i).isDead == false) {
                EnXP3A.add(j, EnXP3.get(i));
                j++;
            }
        }
        
        return EnXP3A;
    }

    
    /**
    * getAll4()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP4
    * 
    * @return EnXP4
    */
    public static List<EnExplode> getAll4() {
        EnXP4A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP4.size(); i++) {
            if (EnXP4.get(i).isDead == false) {
                EnXP4A.add(j, EnXP4.get(i));
                j++;
            }
        }
        
        return EnXP4A;
    }
    
    
    /**
    * getAll5()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP5
    * 
    * @return EnXP5
    */
    public static List<EnExplode> getAll5() {
        EnXP5A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP5.size(); i++) {
            if (EnXP5.get(i).isDead == false) {
                EnXP5A.add(j, EnXP5.get(i));
                j++;
            }
        }
        
        return EnXP5A;
    }
    
    
    /**
    * getAll6()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP6
    * 
    * @return EnXP6
    */
    public static List<EnExplode> getAll6() {
        EnXP6A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP6.size(); i++) {
            if (EnXP6.get(i).isDead == false) {
                EnXP6A.add(j, EnXP6.get(i));
                j++;
            }
        }
        
        return EnXP6A;
    }
    
    
    /**
    * getAll7()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP7
    * 
    * @return EnXP7
    */
    public static List<EnExplode> getAll7() {
        EnXP7A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP7.size(); i++) {
            if (EnXP7.get(i).isDead == false) {
                EnXP7A.add(j, EnXP7.get(i));
                j++;
            }
        }
        
        return EnXP7A;
    }
    
    
    /**
    * getAll8()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP8
    * 
    * @return EnXP8
    */
    public static List<EnExplode> getAll8() {
        EnXP8A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP8.size(); i++) {
            if (EnXP8.get(i).isDead == false) {
                EnXP8A.add(j, EnXP8.get(i));
                j++;
            }
        }
        
        return EnXP8A;
    }
    
    
    /**
    * getAll9()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXP9
    * 
    * @return EnXP9
    */
    public static List<EnExplode> getAll9() {
        EnXP9A = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXP9.size(); i++) {
            if (EnXP9.get(i).isDead == false) {
                EnXP9A.add(j, EnXP9.get(i));
                j++;
            }
        }
        
        return EnXP9A;
    }
    
    
    /**
    * getAllUFO()
    * 
    * Returns the List of the EnExplode 
    * objects referenced by EnXPUFO
    * 
    * @return EnXPUFO
    */
    public static List<EnExplode> getAllUFO() {
        EnXPUFOA = new ArrayList<>();
        int j = 0;
        
        for (int i = 0; i < EnXPUFO.size(); i++) {
            if (EnXPUFO.get(i).isDead == false) {
                EnXPUFOA.add(j, EnXPUFO.get(i));
                j++;
            }
        }
        
        return EnXPUFOA;
    }

    
    /**
    * clearAll()
    * 
    * Clears the Lists of the EnExplode objects
    */    
    public static void clearAll() {
        EnXP0.clear();
        EnXP1.clear();
        EnXP2.clear();
        EnXP3.clear();
        EnXP4.clear();
        EnXP5.clear();
        EnXP6.clear();
        EnXP7.clear();
        EnXP8.clear();
        EnXP9.clear();
        EnXPUFO.clear();
    }
    
    
    /**
    * getBounds()
    * 
    * returns Bounds of the EnExplode objects
    * 
    * @return new Rectangle(this.x, this.y, this.width, this.height)
    */ 
    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
    
    
}
