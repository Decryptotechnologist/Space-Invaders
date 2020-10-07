/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.explodes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Explode objects represent the explosions in the game,
 * represented by a small 'animated explosion'.
 * 
 * @author(s) Ghomez
 */
public class Explode {
    
    /**Attributes*/                                      
        
    /**x coordinate of Explode object */
    public int x;
        
    /**y coordinate of Explode object */
    public int y;
        
    /**height variable of Explode object*/
    public int height;
        
    /**width variable of Explode object */
    public int width; 
        
    /**isDead (true/false) value of Explode object*/
    public boolean isDead;
    
    /**suit (true/false) value of Explode object*/
    public int suit;
    
    /**BRCx_w variable of BRCExplode object */
    public static int BRCx_w;// = 100/18;//6;
    
    /**BRCx_h variable of BRCExplode object*/
    public static int BRCx_h;// = 135/12;//8;
    
    /**BRCx_w variable of BRCExplode object */
    public static int Creditsx_w;// = 100/18;//6;
    
    /**BRCx_h variable of BRCExplode object*/
    public static int Creditsx_h;// = 135/12;//8;
    
    /**enx_w variable of EnExplode object*/
    public static int enx_w;// = 25;
        
    /**enx_h variable of EnExplode object*/
    public static int enx_h;// = 35;
    
    /**p1bx_w variable of P1BExplode object*/
    public static int p1bx_w;// = 8;
        
    /**p1bx_h variable of P1BExplode object*/
    public static int p1bx_h;// = 15;
    
    /**p1x_w variable of P1Explode object */
    public static int p1x_w;// = 80;
        
    /**p1x_h variable of P1Explode object*/
    public static int p1x_h;// = 150;
    
    /**playerBullExScale_a variable of P1BExplode object*/
    public static double playerBullExScale_a;
    
    /**playerBullExScale_b variable of P1BExplode object*/
    public static double playerBullExScale_b;
    
    /**playerBullExScale_c variable of P1BExplode object*/
    public static double playerBullExScale_c;
    
    /**playerBullExXoffs variable of P1BExplode object*/
    public static int playerBullExXoffs;
    
    /**playerBullExYoffs variable of P1BExplode object*/
    public static int playerBullExYoffs;
    
    /**enExScale_a variable of EnExplode object*/
    public static double enExScale_a;
    
    /**enExScale_b variable of EnExplode object*/
    public static double enExScale_b;
    
    /**enExScale_c variable of EnExplode object*/
    public static double enExScale_c;
    
    /**enExXoffs variable of EnExplode object*/
    public static int enExXoffs;
    
    /**enExYoffs variable of EnExplode object*/
    public static int enExYoffs;

    /**BRCeXScale_a variable of BRCExplode object*/
    public static double BRCeXScale_a;
    
    /**BRCeXScale_b variable of BRCExplode object*/
    public static double BRCeXScale_b;
    
    /**BRCeXoffs_a variable of BRCExplode object*/
    public static int BRCeXoffs_a;
    
    /**BRCeXoffs_b variable of BRCExplode object*/
    public static int BRCeXoffs_b;
    
    /**BRCeYoffs_b variable of BRCExplode object*/
    public static int BRCeYoffs_b;
    
    /**BRCeXScale_a variable of BRCExplode object*/
    public static double CreditseXScale_a;
    
    /**BRCeXScale_b variable of BRCExplode object*/
    public static double CreditseXScale_b;
    
    /**BRCeXoffs_a variable of BRCExplode object*/
    public static int CreditseXoffs_a;
    
    /**BRCeXoffs_b variable of BRCExplode object*/
    public static int CreditseXoffs_b;
    
    /**BRCeYoffs_b variable of BRCExplode object*/
    public static int CreditseYoffs_b;

    /**Exsuit variable of Explode object */
    public static int Exsuit = 1;
    
    /**P1BExsuit variable of Explode object */
    public static int P1BExsuit = 1;
    
    /**P1Exsuit variable of Explode object */
    public static int P1Exsuit = 1;
    
    /**ImgPlayerX BufferedImage of Explode object */
    public static BufferedImage imgPlayerX;
    
    /**Random of Explode object*/
    public static Random random = new Random();
    
    
    /**Links*/
    
    /**EnXP0 List of EnExplode object*/
    public static List<EnExplode> EnXP0 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP0A;
    
    /**EnXP1 List of EnExplode object*/
    public static List<EnExplode> EnXP1 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP1A;
    
    /**EnXP2 List of EnExplode object*/
    public static List<EnExplode> EnXP2 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP2A;
    
    /**EnXP3 List of EnExplode object*/
    public static List<EnExplode> EnXP3 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP3A;
    
    /**EnXP4 List of EnExplode object*/
    public static List<EnExplode> EnXP4 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP4A;
    
    /**EnXP5 List of EnExplode object*/
    public static List<EnExplode> EnXP5 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP5A;
    
    /**EnXP6 List of EnExplode object*/
    public static List<EnExplode> EnXP6 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP6A;
    
    /**EnXP7 List of EnExplode object*/
    public static List<EnExplode> EnXP7 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP7A;
    
    /**EnXP8 List of EnExplode object*/
    public static List<EnExplode> EnXP8 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP8A;
    
    /**EnXP9 List of EnExplode object*/
    public static List<EnExplode> EnXP9 = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXP9A;
    
    /**EnXPUFO List of EnExplode object*/
    public static List<EnExplode> EnXPUFO = new ArrayList<>();
    
    /**EnExplodeAnim Animation for EnExplode object*/
    public static List<EnExplode> EnXPUFOA;
    
    /**BRCXP List of BRCExplode object*/
    public static List<BRCExplode> BRCXP = new ArrayList<>();
    
    /**BRCXPA List of BRCExplode object*/
    public static List<BRCExplode> BRCXPA;
    
   /**BRCXPR List of BRCExplode(Rectangle) object*/
    public static List<Rectangle> BRCXPR = new ArrayList<>();
    
    /**BRCXP List of BRCExplode object*/
    public static List<CreditsExplode> CreditsXP = new ArrayList<>();
    
    /**BRCXPA List of BRCExplode object*/
    public static List<CreditsExplode> CreditsXPA;
    
   /**BRCXPR List of BRCExplode(Rectangle) object*/
    public static List<Rectangle> CreditsXPR = new ArrayList<>();
    
    /**P1BXP List of P1BExplode object*/
    public static List<P1BExplode> P1BXP = new ArrayList<>();
    
    /**P1BXPA List of P1BExplode object*/
    public static List<P1BExplode> P1BXPA;
    
    /**P1Explod List of P1Explode objects*/
    public static List<P1Explode> P1Explod = new ArrayList<>();
    
    /**P1ExplodA List of P1Explode objects*/
    public static List<P1Explode> P1ExplodA;
    
    
    /**Constructor*/
    
    /**
    * Explode()
    * 
    * Initialises a new Explode object
    */
    public Explode() {     
        //System.out.println("Explode: New Explode Created");
        setUp();
    }
    
    
    /**Public Protocol*/
    
    
    /**
     * setUp()
     * 
     */
    public static void setUp(){
        P1Explode.setUp();
        EnExplode.setUp();
        P1BExplode.setUp();
        BRCExplode.setUp();
        CreditsExplode.setUp();
    }
    
    
    /**
     * getBounds()
     * 
     * @return null
     */
    public Rectangle getBounds() {
        return null;
    }
    
}
