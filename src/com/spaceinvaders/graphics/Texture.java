/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.graphics;

import com.spaceinvaders.pkg2018.Game;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Ghomez
 */
public final class Texture {
    
    /**Attributes*/
    
    /**texMap Map<String, BufferedImage> of Texture object*/
    private final static Map<String, BufferedImage> texMap = new HashMap<String, BufferedImage>();
    
    /**renMap Map<String, Render> of Texture object*/
    private final static Map<String, Render> renMap = new HashMap<String, Render>();
    
    /**render Render of Texture object*/
    private static Render render;
    
    /**renderFileName variable of Texture object*/
    private static String renderFileName;
    
    /**renIMG BufferedImage of Texture object*/
    private static BufferedImage renIMG;
    
    /**renWidth variable of Texture object*/
    private static int renWidth;
    
    /**renHeight variable of Texture object*/
    private static int renHeight;
    
    
    /**img BufferedImage of Texture object*/
    private BufferedImage img;
    
    /**fileName variable of Texture object*/
    private String fileName;
    
    /**filePath variable of Texture object*/
    private String filePath;
    
    /**width variable of Texture object*/
    int width;
    
    /**height variable of Texture object*/
    int height;
    
    
    /**p1Bullet Render of Texture object*/
    public static final Render p1Bullet = loadBitmap("/Sprites/SI_PlayerBullet0.png");
    
    /**p1BExp Render of Texture object*/
    public static Render p1BExp = loadBitmap("/Sprites/SI_explode0.png");
            
    /**p1BExpA Render of Texture object*/
    public static Render p1BExpA = loadBitmap("/Sprites/SI_explode1.png");
    
    /**p1BExpB Render of Texture object*/
    public static Render p1BExpB = loadBitmap("/Sprites/SI_explode2.png");
    
    
    /**ground Render of Texture object*/
    public static Render ground = loadBitmap("/Sprites/SI_Ground.png");
    
    /**fonts Render of Texture object*/
    public static Render fonts = loadBitmap("/font2018.png");
    
    /**en1_0 Render of Texture object*/
    public static Render en1_0 = loadBitmap("/Sprites/SI_enemyP1_0.png");

    /**en1_1 Render of Texture object*/
    public static Render en1_1 = loadBitmap("/Sprites/SI_enemyP1_1.png");
    
    /**en2_0 Render of Texture object*/
    public static Render en2_0 = loadBitmap("/Sprites/SI_enemyP2_0.png");
    
    /**en2_1 Render of Texture object*/
    public static Render en2_1 = loadBitmap("/Sprites/SI_enemyP2_1.png");
    
    /**en3_0 Render of Texture object*/
    public static Render en3_0 = loadBitmap("/Sprites/SI_enemyP3_0.png");
    
    /**en3_1 Render of Texture object*/
    public static Render en3_1 = loadBitmap("/Sprites/SI_enemyP3_1.png");
    
    /**en4_0 Render of Texture object*/
    public static Render en4_0 = loadBitmap("/Sprites/SI_enemyP4_0A.png");
    
    /**en4_1 Render of Texture object*/
    public static Render en4_1 = loadBitmap("/Sprites/SI_enemyP4_1A.png");
    
    /**en5_0 Render of Texture object*/
    public static Render en5_0 = loadBitmap("/Sprites/SI_enemyP5_0.png");
    
    /**en5_1 Render of Texture object*/
    public static Render en5_1 = loadBitmap("/Sprites/SI_enemyP5_1.png");
    
    /**en6_0 Render of Texture object*/
    public static Render en6_0 = loadBitmap("/Sprites/SI_enemyP6_0.png");
    
    /**en6_1 Render of Texture object*/
    public static Render en6_1 = loadBitmap("/Sprites/SI_enemyP6_1.png");
    
    /**en7_0 Render of Texture object*/
    public static Render en7_0 = loadBitmap("/Sprites/SI_enemyP7_0.png");
    
    /**en7_1 Render of Texture object*/
    public static Render en7_1 = loadBitmap("/Sprites/SI_enemyP7_1.png");
    
    /**en8_0 Render of Texture object*/
    public static Render en8_0 = loadBitmap("/Sprites/SI_enemyP8_0.png");
    
    /**en8_1 Render of Texture object*/
    public static Render en8_1 = loadBitmap("/Sprites/SI_enemyP8_1.png");
    
    /**en9_0 Render of Texture object*/
    public static Render en9_0 = loadBitmap("/Sprites/SI_enemyP9_0.png");
    
    /**en9_1 Render of Texture object*/
    public static Render en9_1 = loadBitmap("/Sprites/SI_enemyP9_1.png");
    
    /**en4_0 Render of Texture object*/
    public static Render en10_0 = loadBitmap("/Sprites/SI_enemy4_0White.png");
    
    /**en4_1 Render of Texture object*/
    public static Render en10_1 = loadBitmap("/Sprites/SI_enemy4_1White.png");
            
    /**enBull Render of Texture object*/
    public static Render enBull = loadBitmap("/Sprites/SI_enemyBullet1.png");
    
    /**enExp Render of Texture object*/
    public static Render enExp = loadBitmap("/Sprites/SI_explode0.png");
            
    /**enExpA Render of Texture object*/
    public static Render enExpA = loadBitmap("/Sprites/SI_explode1.png");
    
    /**enExpB Render of Texture object*/
    public static Render enExpB = loadBitmap("/Sprites/SI_explode2.png");
    
    
    /**POWc_0 Render of Texture object*/
    public static Render POWc_0 = loadBitmapA("/Sprites/SI_cPOWT1_0.png");

    /**POWc_1 Render of Texture object*/
    public static Render POWc_1 = loadBitmapA("/Sprites/SI_cPOWT1_1.png");

    /**POWc_2 Render of Texture object*/
    public static Render POWc_2 = loadBitmapA("/Sprites/SI_cPOWT1_2.png");
    

    /**POWsh_0 Render of Texture object*/
    public static Render POWsh_0 = loadBitmapA("/Sprites/SI_shPOWT1_0.png");

    /**POWsh_1 Render of Texture object*/
    public static Render POWsh_1 = loadBitmapA("/Sprites/SI_shPOWT1_1.png");

    /**POWsh_2 Render of Texture object*/
    public static Render POWsh_2 = loadBitmapA("/Sprites/SI_shPOWT1_2.png");

    
    /**POWsp_0 Render of Texture object*/
    public static Render POWsp_0 = loadBitmapA("/Sprites/SI_spPOWT1_0.png");

    /**POWsp_1 Render of Texture object*/
    public static Render POWsp_1 = loadBitmapA("/Sprites/SI_spPOWT1_1.png");

    /**POWsp_2 Render of Texture object*/
    public static Render POWsp_2 = loadBitmapA("/Sprites/SI_spPOWT1_2.png");

    
    /**livesLabel Render of Texture object*/
    public static Render livesLabel = loadBitmap("/Sprites/SI_LivesWhite.png");
    
    /**scoreLabel Render of Texture object*/
    public static Render scoreLabel = loadBitmap("/Sprites/SI_ScoreWhite.png");
    
    /**buttonsA Render of Texture object*/
    public static Render buttonsA = loadBitmap("/Buttons2018.png");
    
    public static Render Keyz = loadBitmap("/KeysB2018.png");
    
    /**background0 Render of Texture object*/
    public static Render background0 = loadBitmapA("/Sprites/Moon revolve vray right_0000.png");
    
    /**background1 Render of Texture object*/
    public static Render background1 = loadBitmapA("/Sprites/Moon revolve vray right_0001.png");
    
    /**background2 Render of Texture object*/
    public static Render background2 = loadBitmapA("/Sprites/Moon revolve vray right_0002.png");
    
    /**background3 Render of Texture object*/
    public static Render background3 = loadBitmapA("/Sprites/Moon revolve vray right_0003.png");
    
    /**background4 Render of Texture object*/
    public static Render background4 = loadBitmapA("/Sprites/Moon revolve vray right_0004.png");
    
    /**background5 Render of Texture object*/
    public static Render background5 = loadBitmapA("/Sprites/Moon revolve vray right_0005.png");
    
    /**background6 Render of Texture object*/
    public static Render background6 = loadBitmapA("/Sprites/Moon revolve vray right_0006.png");
    
    /**background7 Render of Texture object*/
    public static Render background7 = loadBitmapA("/Sprites/Moon revolve vray right_0007.png");
    
    /**background8 Render of Texture object*/
    public static Render background8 = loadBitmapA("/Sprites/Moon revolve vray right_0008.png");
    
    /**background9 Render of Texture object*/
    public static Render background9 = loadBitmapA("/Sprites/Moon revolve vray right_0009.png");
    
    /**background10 Render of Texture object*/
    public static Render background10 = loadBitmapA("/Sprites/Moon revolve vray right_0010.png");
    
    /**background11 Render of Texture object*/
    public static Render background11 = loadBitmapA("/Sprites/Moon revolve vray right_0011.png");
    
    /**background12 Render of Texture object*/
    public static Render background12 = loadBitmapA("/Sprites/Moon revolve vray right_0012.png");
    
    /**background13 Render of Texture object*/
    public static Render background13 = loadBitmapA("/Sprites/Moon revolve vray right_0013.png");
    
    /**background14 Render of Texture object*/
    public static Render background14 = loadBitmapA("/Sprites/Moon revolve vray right_0014.png");
    
    /**background15 Render of Texture object*/
    public static Render background15 = loadBitmapA("/Sprites/Moon revolve vray right_0015.png");
    
    /**background16 Render of Texture object*/
    public static Render background16 = loadBitmapA("/Sprites/Moon revolve vray right_0016.png");
    
    /**background17 Render of Texture object*/
    public static Render background17 = loadBitmapA("/Sprites/Moon revolve vray right_0017.png");
    
    /**background18 Render of Texture object*/
    public static Render background18 = loadBitmapA("/Sprites/Moon revolve vray right_0018.png");
    
    /**background19 Render of Texture object*/
    public static Render background19 = loadBitmapA("/Sprites/Moon revolve vray right_0019.png");
    
    /**background20 Render of Texture object*/
    public static Render background20 = loadBitmapA("/Sprites/Moon revolve vray right_0020.png");
    
    /**background21 Render of Texture object*/
    public static Render background21 = loadBitmapA("/Sprites/Moon revolve vray right_0021.png");
    
    /**background22 Render of Texture object*/
    public static Render background22 = loadBitmapA("/Sprites/Moon revolve vray right_0022.png");
    
    /**background23 Render of Texture object*/
    public static Render background23 = loadBitmapA("/Sprites/Moon revolve vray right_0023.png");
    
    /**background24 Render of Texture object*/
    public static Render background24 = loadBitmapA("/Sprites/Moon revolve vray right_0024.png");
    
    /**background25 Render of Texture object*/
    public static Render background25 = loadBitmapA("/Sprites/Moon revolve vray right_0025.png");
    
    /**background26 Render of Texture object*/
    public static Render background26 = loadBitmapA("/Sprites/Moon revolve vray right_0026.png");
    
    /**background27 Render of Texture object*/
    public static Render background27 = loadBitmapA("/Sprites/Moon revolve vray right_0027.png");
    
    /**background28 Render of Texture object*/
    public static Render background28 = loadBitmapA("/Sprites/Moon revolve vray right_0028.png");
    
    /**background29 Render of Texture object*/
    public static Render background29 = loadBitmapA("/Sprites/Moon revolve vray right_0029.png");
    
    /**background30 Render of Texture object*/
    public static Render background30 = loadBitmapA("/Sprites/Moon revolve vray right_0030.png");
    
    /**background31 Render of Texture object*/
    public static Render background31 = loadBitmapA("/Sprites/Moon revolve vray right_0031.png");
    
    /**background32 Render of Texture object*/
    public static Render background32 = loadBitmapA("/Sprites/Moon revolve vray right_0032.png");
    
    /**background33 Render of Texture object*/
    public static Render background33 = loadBitmapA("/Sprites/Moon revolve vray right_0033.png");
    
    /**background34 Render of Texture object*/
    public static Render background34 = loadBitmapA("/Sprites/Moon revolve vray right_0034.png");
    
    /**background35 Render of Texture object*/
    public static Render background35 = loadBitmapA("/Sprites/Moon revolve vray right_0035.png");
    
    /**background36 Render of Texture object*/
    public static Render background36 = loadBitmapA("/Sprites/Moon revolve vray right_0036.png");
    
    /**background37 Render of Texture object*/
    public static Render background37 = loadBitmapA("/Sprites/Moon revolve vray right_0037.png");
    
    /**background38 Render of Texture object*/
    public static Render background38 = loadBitmapA("/Sprites/Moon revolve vray right_0038.png");
    
    /**background39 Render of Texture object*/
    public static Render background39 = loadBitmapA("/Sprites/Moon revolve vray right_0039.png");
    
    /**background40 Render of Texture object*/
    public static Render background40 = loadBitmapA("/Sprites/Moon revolve vray right_0040.png");
    
    /**background41 Render of Texture object*/
    public static Render background41 = loadBitmapA("/Sprites/Moon revolve vray right_0041.png");
    
    /**background42 Render of Texture object*/
    public static Render background42 = loadBitmapA("/Sprites/Moon revolve vray right_0042.png");
    
    /**background43 Render of Texture object*/
    public static Render background43 = loadBitmapA("/Sprites/Moon revolve vray right_0043.png");
    
    /**background44 Render of Texture object*/
    public static Render background44 = loadBitmapA("/Sprites/Moon revolve vray right_0044.png");
    
    /**background45 Render of Texture object*/
    public static Render background45 = loadBitmapA("/Sprites/Moon revolve vray right_0045.png");
    
    /**background46 Render of Texture object*/
    public static Render background46 = loadBitmapA("/Sprites/Moon revolve vray right_0046.png");
    
    /**background47 Render of Texture object*/
    public static Render background47 = loadBitmapA("/Sprites/Moon revolve vray right_0047.png");
    
    /**background48 Render of Texture object*/
    public static Render background48 = loadBitmapA("/Sprites/Moon revolve vray right_0048.png");
    
    /**background49 Render of Texture object*/
    public static Render background49 = loadBitmapA("/Sprites/Moon revolve vray right_0049.png");
    
    /**background50 Render of Texture object*/
    public static Render background50 = loadBitmapA("/Sprites/Moon revolve vray right_0050.png");
    
    /**background51 Render of Texture object*/
    public static Render background51 = loadBitmapA("/Sprites/Moon revolve vray right_0051.png");
    
    /**background52 Render of Texture object*/
    public static Render background52 = loadBitmapA("/Sprites/Moon revolve vray right_0052.png");
    
    /**background53 Render of Texture object*/
    public static Render background53 = loadBitmapA("/Sprites/Moon revolve vray right_0053.png");
    
    /**background54 Render of Texture object*/
    public static Render background54 = loadBitmapA("/Sprites/Moon revolve vray right_0054.png");
    
    /**background55 Render of Texture object*/
    public static Render background55 = loadBitmapA("/Sprites/Moon revolve vray right_0055.png");
    
    /**background56 Render of Texture object*/
    public static Render background56 = loadBitmapA("/Sprites/Moon revolve vray right_0056.png");
    
    /**background57 Render of Texture object*/
    public static Render background57 = loadBitmapA("/Sprites/Moon revolve vray right_0057.png");
    
    /**background58 Render of Texture object*/
    public static Render background58 = loadBitmapA("/Sprites/Moon revolve vray right_0058.png");
    
    /**background59 Render of Texture object*/
    public static Render background59 = loadBitmapA("/Sprites/Moon revolve vray right_0059.png");
    
    /**background60 Render of Texture object*/
    public static Render background60 = loadBitmapA("/Sprites/Moon revolve vray right_0060.png");
    
    /**background61 Render of Texture object*/
    public static Render background61 = loadBitmapA("/Sprites/Moon revolve vray right_0061.png");
    
    /**background62 Render of Texture object*/
    public static Render background62 = loadBitmapA("/Sprites/Moon revolve vray right_0062.png");
    
    /**background63 Render of Texture object*/
    public static Render background63 = loadBitmapA("/Sprites/Moon revolve vray right_0063.png");
    
    /**background64 Render of Texture object*/
    public static Render background64 = loadBitmapA("/Sprites/Moon revolve vray right_0064.png");
    
    /**background65 Render of Texture object*/
    public static Render background65 = loadBitmapA("/Sprites/Moon revolve vray right_0065.png");
    
    /**background66 Render of Texture object*/
    public static Render background66 = loadBitmapA("/Sprites/Moon revolve vray right_0066.png");
    
    /**background67 Render of Texture object*/
    public static Render background67 = loadBitmapA("/Sprites/Moon revolve vray right_0067.png");
    
    /**background68 Render of Texture object*/
    public static Render background68 = loadBitmapA("/Sprites/Moon revolve vray right_0068.png");
    
    /**background69 Render of Texture object*/
    public static Render background69 = loadBitmapA("/Sprites/Moon revolve vray right_0069.png");
    
    /**background70 Render of Texture object*/
    public static Render background70 = loadBitmapA("/Sprites/Moon revolve vray right_0070.png");
    
    /**background71 Render of Texture object*/
    public static Render background71 = loadBitmapA("/Sprites/Moon revolve vray right_0071.png");
    
    /**background72 Render of Texture object*/
    public static Render background72 = loadBitmapA("/Sprites/Moon revolve vray right_0072.png");
    
    /**background73 Render of Texture object*/
    public static Render background73 = loadBitmapA("/Sprites/Moon revolve vray right_0073.png");
    
    /**background74 Render of Texture object*/
    public static Render background74 = loadBitmapA("/Sprites/Moon revolve vray right_0074.png");
    
    /**background75 Render of Texture object*/
    public static Render background75 = loadBitmapA("/Sprites/Moon revolve vray right_0075.png");
    
    /**background76 Render of Texture object*/
    public static Render background76 = loadBitmapA("/Sprites/Moon revolve vray right_0076.png");
    
    /**background77 Render of Texture object*/
    public static Render background77 = loadBitmapA("/Sprites/Moon revolve vray right_0077.png");
    
    /**background78 Render of Texture object*/
    public static Render background78 = loadBitmapA("/Sprites/Moon revolve vray right_0078.png");
    
    /**background79 Render of Texture object*/
    public static Render background79 = loadBitmapA("/Sprites/Moon revolve vray right_0079.png");
    
    /**background80 Render of Texture object*/
    public static Render background80 = loadBitmapA("/Sprites/Moon revolve vray right_0080.png");
    
    /**background81 Render of Texture object*/
    public static Render background81 = loadBitmapA("/Sprites/Moon revolve vray right_0081.png");
    
    /**background82 Render of Texture object*/
    public static Render background82 = loadBitmapA("/Sprites/Moon revolve vray right_0082.png");
    
    /**background83 Render of Texture object*/
    public static Render background83 = loadBitmapA("/Sprites/Moon revolve vray right_0083.png");
    
    /**background84 Render of Texture object*/
    public static Render background84 = loadBitmapA("/Sprites/Moon revolve vray right_0084.png");
    
    /**background85 Render of Texture object*/
    public static Render background85 = loadBitmapA("/Sprites/Moon revolve vray right_0085.png");
    
    /**background86 Render of Texture object*/
    public static Render background86 = loadBitmapA("/Sprites/Moon revolve vray right_0086.png");
    
    /**background87 Render of Texture object*/
    public static Render background87 = loadBitmapA("/Sprites/Moon revolve vray right_0087.png");
    
    /**background88 Render of Texture object*/
    public static Render background88 = loadBitmapA("/Sprites/Moon revolve vray right_0088.png");
    
    
    
    /**backgroundEarth0 Render of Texture object*/
    public static Render backgroundEarth0 = loadBitmapA("/Sprites/Earth revolve vray right_0000.png");
    
    /**backgroundEarth1 Render of Texture object*/
    public static Render backgroundEarth1 = loadBitmapA("/Sprites/Earth revolve vray right_0001.png");
    
    /**backgroundEarth2 Render of Texture object*/
    public static Render backgroundEarth2 = loadBitmapA("/Sprites/Earth revolve vray right_0002.png");
    
    /**backgroundEarth3 Render of Texture object*/
    public static Render backgroundEarth3 = loadBitmapA("/Sprites/Earth revolve vray right_0003.png");
    
    /**backgroundEarth4 Render of Texture object*/
    public static Render backgroundEarth4 = loadBitmapA("/Sprites/Earth revolve vray right_0004.png");
    
    /**backgroundEarth5 Render of Texture object*/
    public static Render backgroundEarth5 = loadBitmapA("/Sprites/Earth revolve vray right_0005.png");
    
    /**backgroundEarth6 Render of Texture object*/
    public static Render backgroundEarth6 = loadBitmapA("/Sprites/Earth revolve vray right_0006.png");
    
    /**backgroundEarth7 Render of Texture object*/
    public static Render backgroundEarth7 = loadBitmapA("/Sprites/Earth revolve vray right_0007.png");
    
    /**backgroundEarth8 Render of Texture object*/
    public static Render backgroundEarth8 = loadBitmapA("/Sprites/Earth revolve vray right_0008.png");
    
    /**backgroundEarth9 Render of Texture object*/
    public static Render backgroundEarth9 = loadBitmapA("/Sprites/Earth revolve vray right_0009.png");
    
    /**backgroundEarth10 Render of Texture object*/
    public static Render backgroundEarth10 = loadBitmapA("/Sprites/Earth revolve vray right_0010.png");
    
    /**backgroundEarth11 Render of Texture object*/
    public static Render backgroundEarth11 = loadBitmapA("/Sprites/Earth revolve vray right_0011.png");
    
    /**backgroundEarth12 Render of Texture object*/
    public static Render backgroundEarth12 = loadBitmapA("/Sprites/Earth revolve vray right_0012.png");
    
    /**backgroundEarth13 Render of Texture object*/
    public static Render backgroundEarth13 = loadBitmapA("/Sprites/Earth revolve vray right_0013.png");
    
    /**backgroundEarth14 Render of Texture object*/
    public static Render backgroundEarth14 = loadBitmapA("/Sprites/Earth revolve vray right_0014.png");
    
    /**backgroundEarth15 Render of Texture object*/
    public static Render backgroundEarth15 = loadBitmapA("/Sprites/Earth revolve vray right_0015.png");
    
    /**backgroundEarth16 Render of Texture object*/
    public static Render backgroundEarth16 = loadBitmapA("/Sprites/Earth revolve vray right_0016.png");
    
    /**backgroundEarth17 Render of Texture object*/
    public static Render backgroundEarth17 = loadBitmapA("/Sprites/Earth revolve vray right_0017.png");
    
    /**backgroundEarth18 Render of Texture object*/
    public static Render backgroundEarth18 = loadBitmapA("/Sprites/Earth revolve vray right_0018.png");
    
    /**backgroundEarth19 Render of Texture object*/
    public static Render backgroundEarth19 = loadBitmapA("/Sprites/Earth revolve vray right_0019.png");
    
    /**backgroundEarth20 Render of Texture object*/
    public static Render backgroundEarth20 = loadBitmapA("/Sprites/Earth revolve vray right_0020.png");
    
    /**backgroundEarth21 Render of Texture object*/
    public static Render backgroundEarth21 = loadBitmapA("/Sprites/Earth revolve vray right_0021.png");
    
    /**backgroundEarth22 Render of Texture object*/
    public static Render backgroundEarth22 = loadBitmapA("/Sprites/Earth revolve vray right_0022.png");
    
    /**backgroundEarth23 Render of Texture object*/
    public static Render backgroundEarth23 = loadBitmapA("/Sprites/Earth revolve vray right_0023.png");
    
    /**backgroundEarth24 Render of Texture object*/
    public static Render backgroundEarth24 = loadBitmapA("/Sprites/Earth revolve vray right_0024.png");
    
    /**backgroundEarth25 Render of Texture object*/
    public static Render backgroundEarth25 = loadBitmapA("/Sprites/Earth revolve vray right_0025.png");
    
    /**backgroundEarth26 Render of Texture object*/
    public static Render backgroundEarth26 = loadBitmapA("/Sprites/Earth revolve vray right_0026.png");
    
    /**backgroundEarth27 Render of Texture object*/
    public static Render backgroundEarth27 = loadBitmapA("/Sprites/Earth revolve vray right_0027.png");
    
    /**backgroundEarth28 Render of Texture object*/
    public static Render backgroundEarth28 = loadBitmapA("/Sprites/Earth revolve vray right_0028.png");
    
    /**backgroundEarth29 Render of Texture object*/
    public static Render backgroundEarth29 = loadBitmapA("/Sprites/Earth revolve vray right_0029.png");
    
    /**backgroundEarth30 Render of Texture object*/
    public static Render backgroundEarth30 = loadBitmapA("/Sprites/Earth revolve vray right_0030.png");
    
    /**backgroundEarth31 Render of Texture object*/
    public static Render backgroundEarth31 = loadBitmapA("/Sprites/Earth revolve vray right_0031.png");
    
    /**backgroundEarth32 Render of Texture object*/
    public static Render backgroundEarth32 = loadBitmapA("/Sprites/Earth revolve vray right_0032.png");
    
    /**backgroundEarth33 Render of Texture object*/
    public static Render backgroundEarth33 = loadBitmapA("/Sprites/Earth revolve vray right_0033.png");
    
    /**backgroundEarth34 Render of Texture object*/
    public static Render backgroundEarth34 = loadBitmapA("/Sprites/Earth revolve vray right_0034.png");
    
    /**backgroundEarth35 Render of Texture object*/
    public static Render backgroundEarth35 = loadBitmapA("/Sprites/Earth revolve vray right_0035.png");
    
    /**backgroundEarth36 Render of Texture object*/
    public static Render backgroundEarth36 = loadBitmapA("/Sprites/Earth revolve vray right_0036.png");
    
    /**backgroundEarth37 Render of Texture object*/
    public static Render backgroundEarth37 = loadBitmapA("/Sprites/Earth revolve vray right_0037.png");
    
    /**backgroundEarth38 Render of Texture object*/
    public static Render backgroundEarth38 = loadBitmapA("/Sprites/Earth revolve vray right_0038.png");
    
    /**backgroundEarth39 Render of Texture object*/
    public static Render backgroundEarth39 = loadBitmapA("/Sprites/Earth revolve vray right_0039.png");
    
    /**backgroundEarth40 Render of Texture object*/
    public static Render backgroundEarth40 = loadBitmapA("/Sprites/Earth revolve vray right_0040.png");
    
    /**backgroundEarth41 Render of Texture object*/
    public static Render backgroundEarth41 = loadBitmapA("/Sprites/Earth revolve vray right_0041.png");
    
    /**backgroundEarth42 Render of Texture object*/
    public static Render backgroundEarth42 = loadBitmapA("/Sprites/Earth revolve vray right_0042.png");
    
    /**backgroundEarth43 Render of Texture object*/
    public static Render backgroundEarth43 = loadBitmapA("/Sprites/Earth revolve vray right_0043.png");
    
    /**backgroundEarth44 Render of Texture object*/
    public static Render backgroundEarth44 = loadBitmapA("/Sprites/Earth revolve vray right_0044.png");
    
    /**backgroundEarth45 Render of Texture object*/
    public static Render backgroundEarth45 = loadBitmapA("/Sprites/Earth revolve vray right_0045.png");
    
    /**backgroundEarth46 Render of Texture object*/
    public static Render backgroundEarth46 = loadBitmapA("/Sprites/Earth revolve vray right_0046.png");
    
    /**backgroundEarth47 Render of Texture object*/
    public static Render backgroundEarth47 = loadBitmapA("/Sprites/Earth revolve vray right_0047.png");
    
    /**backgroundEarth48 Render of Texture object*/
    public static Render backgroundEarth48 = loadBitmapA("/Sprites/Earth revolve vray right_0048.png");
    
    /**backgroundEarth49 Render of Texture object*/
    public static Render backgroundEarth49 = loadBitmapA("/Sprites/Earth revolve vray right_0049.png");
    
    /**backgroundEarth50 Render of Texture object*/
    public static Render backgroundEarth50 = loadBitmapA("/Sprites/Earth revolve vray right_0050.png");
    
    /**backgroundEarth51 Render of Texture object*/
    public static Render backgroundEarth51 = loadBitmapA("/Sprites/Earth revolve vray right_0051.png");
    
    /**backgroundEarth52 Render of Texture object*/
    public static Render backgroundEarth52 = loadBitmapA("/Sprites/Earth revolve vray right_0052.png");
    
    /**backgroundEarth53 Render of Texture object*/
    public static Render backgroundEarth53 = loadBitmapA("/Sprites/Earth revolve vray right_0053.png");
    
    /**backgroundEarth54 Render of Texture object*/
    public static Render backgroundEarth54 = loadBitmapA("/Sprites/Earth revolve vray right_0054.png");
    
    /**backgroundEarth55 Render of Texture object*/
    public static Render backgroundEarth55 = loadBitmapA("/Sprites/Earth revolve vray right_0055.png");
    
    /**backgroundEarth56 Render of Texture object*/
    public static Render backgroundEarth56 = loadBitmapA("/Sprites/Earth revolve vray right_0056.png");
    
    /**backgroundEarth57 Render of Texture object*/
    public static Render backgroundEarth57 = loadBitmapA("/Sprites/Earth revolve vray right_0057.png");
    
    /**backgroundEarth58 Render of Texture object*/
    public static Render backgroundEarth58 = loadBitmapA("/Sprites/Earth revolve vray right_0058.png");
    
    /**backgroundEarth59 Render of Texture object*/
    public static Render backgroundEarth59 = loadBitmapA("/Sprites/Earth revolve vray right_0059.png");
    
    /**backgroundEarth60 Render of Texture object*/
    public static Render backgroundEarth60 = loadBitmapA("/Sprites/Earth revolve vray right_0060.png");
    
    /**backgroundEarth61 Render of Texture object*/
    public static Render backgroundEarth61 = loadBitmapA("/Sprites/Earth revolve vray right_0061.png");
    
    /**backgroundEarth62 Render of Texture object*/
    public static Render backgroundEarth62 = loadBitmapA("/Sprites/Earth revolve vray right_0062.png");
    
    /**backgroundEarth63 Render of Texture object*/
    public static Render backgroundEarth63 = loadBitmapA("/Sprites/Earth revolve vray right_0063.png");
    
    /**backgroundEarth64 Render of Texture object*/
    public static Render backgroundEarth64 = loadBitmapA("/Sprites/Earth revolve vray right_0064.png");
    
    /**backgroundEarth65 Render of Texture object*/
    public static Render backgroundEarth65 = loadBitmapA("/Sprites/Earth revolve vray right_0065.png");
    
    /**backgroundEarth66 Render of Texture object*/
    public static Render backgroundEarth66 = loadBitmapA("/Sprites/Earth revolve vray right_0066.png");
    
    /**backgroundEarth67 Render of Texture object*/
    public static Render backgroundEarth67 = loadBitmapA("/Sprites/Earth revolve vray right_0067.png");
    
    /**backgroundEarth68 Render of Texture object*/
    public static Render backgroundEarth68 = loadBitmapA("/Sprites/Earth revolve vray right_0068.png");
    
    /**backgroundEarth69 Render of Texture object*/
    public static Render backgroundEarth69 = loadBitmapA("/Sprites/Earth revolve vray right_0069.png");
    
    /**backgroundEarth70 Render of Texture object*/
    public static Render backgroundEarth70 = loadBitmapA("/Sprites/Earth revolve vray right_0070.png");
    
    /**backgroundEarth71 Render of Texture object*/
    public static Render backgroundEarth71 = loadBitmapA("/Sprites/Earth revolve vray right_0071.png");
    
    /**backgroundEarth72 Render of Texture object*/
    public static Render backgroundEarth72 = loadBitmapA("/Sprites/Earth revolve vray right_0072.png");
    
    /**backgroundEarth73 Render of Texture object*/
    public static Render backgroundEarth73 = loadBitmapA("/Sprites/Earth revolve vray right_0073.png");
    
    /**backgroundEarth74 Render of Texture object*/
    public static Render backgroundEarth74 = loadBitmapA("/Sprites/Earth revolve vray right_0074.png");
    
    /**backgroundEarth75 Render of Texture object*/
    public static Render backgroundEarth75 = loadBitmapA("/Sprites/Earth revolve vray right_0075.png");
    
    /**backgroundEarth76 Render of Texture object*/
    public static Render backgroundEarth76 = loadBitmapA("/Sprites/Earth revolve vray right_0076.png");
    
    /**backgroundEarth77 Render of Texture object*/
    public static Render backgroundEarth77 = loadBitmapA("/Sprites/Earth revolve vray right_0077.png");
    
    /**backgroundEarth78 Render of Texture object*/
    public static Render backgroundEarth78 = loadBitmapA("/Sprites/Earth revolve vray right_0078.png");
    
    /**backgroundEarth79 Render of Texture object*/
    public static Render backgroundEarth79 = loadBitmapA("/Sprites/Earth revolve vray right_0079.png");
    
    /**backgroundEarth80 Render of Texture object*/
    public static Render backgroundEarth80 = loadBitmapA("/Sprites/Earth revolve vray right_0080.png");
    
    /**backgroundEarth81 Render of Texture object*/
    public static Render backgroundEarth81 = loadBitmapA("/Sprites/Earth revolve vray right_0081.png");
    
    /**backgroundEarth82 Render of Texture object*/
    public static Render backgroundEarth82 = loadBitmapA("/Sprites/Earth revolve vray right_0082.png");
    
    /**backgroundEarth83 Render of Texture object*/
    public static Render backgroundEarth83 = loadBitmapA("/Sprites/Earth revolve vray right_0083.png");
    
    /**backgroundEarth84 Render of Texture object*/
    public static Render backgroundEarth84 = loadBitmapA("/Sprites/Earth revolve vray right_0084.png");
    
    /**backgroundEarth85 Render of Texture object*/
    public static Render backgroundEarth85 = loadBitmapA("/Sprites/Earth revolve vray right_0085.png");
    
    /**backgroundEarth86 Render of Texture object*/
    public static Render backgroundEarth86 = loadBitmapA("/Sprites/Earth revolve vray right_0086.png");
    
    /**backgroundEarth87 Render of Texture object*/
    public static Render backgroundEarth87 = loadBitmapA("/Sprites/Earth revolve vray right_0087.png");
    
    /**backgroundEarth88 Render of Texture object*/
    public static Render backgroundEarth88 = loadBitmapA("/Sprites/Earth revolve vray right_0088.png");
    
    
    
    /**backgroundMars0 Render of Texture object*/
    public static Render backgroundMars0 = loadBitmapA("/Sprites/Mars revolve vray  right_0000.png");
    
    /**backgroundMars1 Render of Texture object*/
    public static Render backgroundMars1 = loadBitmapA("/Sprites/Mars revolve vray  right_0001.png");
    
    /**backgroundMars2 Render of Texture object*/
    public static Render backgroundMars2 = loadBitmapA("/Sprites/Mars revolve vray  right_0002.png");
    
    /**backgroundMars3 Render of Texture object*/
    public static Render backgroundMars3 = loadBitmapA("/Sprites/Mars revolve vray  right_0003.png");
    
    /**backgroundMars4 Render of Texture object*/
    public static Render backgroundMars4 = loadBitmapA("/Sprites/Mars revolve vray  right_0004.png");
    
    /**backgroundMars5 Render of Texture object*/
    public static Render backgroundMars5 = loadBitmapA("/Sprites/Mars revolve vray  right_0005.png");
    
    /**backgroundMars6 Render of Texture object*/
    public static Render backgroundMars6 = loadBitmapA("/Sprites/Mars revolve vray  right_0006.png");
    
    /**backgroundMars7 Render of Texture object*/
    public static Render backgroundMars7 = loadBitmapA("/Sprites/Mars revolve vray  right_0007.png");
    
    /**backgroundMars8 Render of Texture object*/
    public static Render backgroundMars8 = loadBitmapA("/Sprites/Mars revolve vray  right_0008.png");
    
    /**backgroundMars9 Render of Texture object*/
    public static Render backgroundMars9 = loadBitmapA("/Sprites/Mars revolve vray  right_0009.png");
    
    /**backgroundMars10 Render of Texture object*/
    public static Render backgroundMars10 = loadBitmapA("/Sprites/Mars revolve vray  right_0010.png");
    
    /**backgroundMars11 Render of Texture object*/
    public static Render backgroundMars11 = loadBitmapA("/Sprites/Mars revolve vray  right_0011.png");
    
    /**backgroundMars12 Render of Texture object*/
    public static Render backgroundMars12 = loadBitmapA("/Sprites/Mars revolve vray  right_0012.png");
    
    /**backgroundMars13 Render of Texture object*/
    public static Render backgroundMars13 = loadBitmapA("/Sprites/Mars revolve vray  right_0013.png");
    
    /**backgroundMars14 Render of Texture object*/
    public static Render backgroundMars14 = loadBitmapA("/Sprites/Mars revolve vray  right_0014.png");
    
    /**backgroundMars15 Render of Texture object*/
    public static Render backgroundMars15 = loadBitmapA("/Sprites/Mars revolve vray  right_0015.png");
    
    /**backgroundMars16 Render of Texture object*/
    public static Render backgroundMars16 = loadBitmapA("/Sprites/Mars revolve vray  right_0016.png");
    
    /**backgroundMars17 Render of Texture object*/
    public static Render backgroundMars17 = loadBitmapA("/Sprites/Mars revolve vray  right_0017.png");
    
    /**backgroundMars18 Render of Texture object*/
    public static Render backgroundMars18 = loadBitmapA("/Sprites/Mars revolve vray  right_0018.png");
    
    /**backgroundMars19 Render of Texture object*/
    public static Render backgroundMars19 = loadBitmapA("/Sprites/Mars revolve vray  right_0019.png");
    
    /**backgroundMars20 Render of Texture object*/
    public static Render backgroundMars20 = loadBitmapA("/Sprites/Mars revolve vray  right_0020.png");
    
    /**backgroundMars21 Render of Texture object*/
    public static Render backgroundMars21 = loadBitmapA("/Sprites/Mars revolve vray  right_0021.png");
    
    /**backgroundMars22 Render of Texture object*/
    public static Render backgroundMars22 = loadBitmapA("/Sprites/Mars revolve vray  right_0022.png");
    
    /**backgroundMars23 Render of Texture object*/
    public static Render backgroundMars23 = loadBitmapA("/Sprites/Mars revolve vray  right_0023.png");
    
    /**backgroundMars24 Render of Texture object*/
    public static Render backgroundMars24 = loadBitmapA("/Sprites/Mars revolve vray  right_0024.png");
    
    /**backgroundMars25 Render of Texture object*/
    public static Render backgroundMars25 = loadBitmapA("/Sprites/Mars revolve vray  right_0025.png");
    
    /**backgroundMars26 Render of Texture object*/
    public static Render backgroundMars26 = loadBitmapA("/Sprites/Mars revolve vray  right_0026.png");
    
   /**backgroundMars27 Render of Texture object*/
    public static Render backgroundMars27 = loadBitmapA("/Sprites/Mars revolve vray  right_0027.png");
    
    /**backgroundMars28 Render of Texture object*/
    public static Render backgroundMars28 = loadBitmapA("/Sprites/Mars revolve vray  right_0028.png");
    
    /**backgroundMars29 Render of Texture object*/
    public static Render backgroundMars29 = loadBitmapA("/Sprites/Mars revolve vray  right_0029.png");
    
    /**backgroundMars30 Render of Texture object*/
    public static Render backgroundMars30 = loadBitmapA("/Sprites/Mars revolve vray  right_0030.png");
    
    /**backgroundMars31 Render of Texture object*/
    public static Render backgroundMars31 = loadBitmapA("/Sprites/Mars revolve vray  right_0031.png");
    
    /**backgroundMars32 Render of Texture object*/
    public static Render backgroundMars32 = loadBitmapA("/Sprites/Mars revolve vray  right_0032.png");
    
    /**backgroundMars33 Render of Texture object*/
    public static Render backgroundMars33 = loadBitmapA("/Sprites/Mars revolve vray  right_0033.png");
    
    /**backgroundMars34 Render of Texture object*/
    public static Render backgroundMars34 = loadBitmapA("/Sprites/Mars revolve vray  right_0034.png");
    
    /**backgroundMars35 Render of Texture object*/
    public static Render backgroundMars35 = loadBitmapA("/Sprites/Mars revolve vray  right_0035.png");
    
    /**backgroundMars36 Render of Texture object*/
    public static Render backgroundMars36 = loadBitmapA("/Sprites/Mars revolve vray  right_0036.png");
    
    /**backgroundMars37 Render of Texture object*/
    public static Render backgroundMars37 = loadBitmapA("/Sprites/Mars revolve vray  right_0037.png");
    
    /**backgroundMars38 Render of Texture object*/
    public static Render backgroundMars38 = loadBitmapA("/Sprites/Mars revolve vray  right_0038.png");
    
    /**backgroundMars39 Render of Texture object*/
    public static Render backgroundMars39 = loadBitmapA("/Sprites/Mars revolve vray  right_0039.png");
    
    /**backgroundMars40 Render of Texture object*/
    public static Render backgroundMars40 = loadBitmapA("/Sprites/Mars revolve vray  right_0040.png");
    
    /**backgroundMars41 Render of Texture object*/
    public static Render backgroundMars41 = loadBitmapA("/Sprites/Mars revolve vray  right_0041.png");
    
    /**backgroundMars42 Render of Texture object*/
    public static Render backgroundMars42 = loadBitmapA("/Sprites/Mars revolve vray  right_0042.png");
    
    /**backgroundMars43 Render of Texture object*/
    public static Render backgroundMars43 = loadBitmapA("/Sprites/Mars revolve vray  right_0043.png");
    
    /**backgroundMars44 Render of Texture object*/
    public static Render backgroundMars44 = loadBitmapA("/Sprites/Mars revolve vray  right_0044.png");
    
    /**backgroundMars45 Render of Texture object*/
    public static Render backgroundMars45 = loadBitmapA("/Sprites/Mars revolve vray  right_0045.png");
    
    /**backgroundMars46 Render of Texture object*/
    public static Render backgroundMars46 = loadBitmapA("/Sprites/Mars revolve vray  right_0046.png");
    
    /**backgroundMars47 Render of Texture object*/
    public static Render backgroundMars47 = loadBitmapA("/Sprites/Mars revolve vray  right_0047.png");
    
    /**backgroundMars48 Render of Texture object*/
    public static Render backgroundMars48 = loadBitmapA("/Sprites/Mars revolve vray  right_0048.png");
    
    /**backgroundMars49 Render of Texture object*/
    public static Render backgroundMars49 = loadBitmapA("/Sprites/Mars revolve vray  right_0049.png");
    
    /**backgroundMars50 Render of Texture object*/
    public static Render backgroundMars50 = loadBitmapA("/Sprites/Mars revolve vray  right_0050.png");
    
    /**backgroundMars51 Render of Texture object*/
    public static Render backgroundMars51 = loadBitmapA("/Sprites/Mars revolve vray  right_0051.png");
    
    /**backgroundMars52 Render of Texture object*/
    public static Render backgroundMars52 = loadBitmapA("/Sprites/Mars revolve vray  right_0052.png");
    
    /**backgroundMars53 Render of Texture object*/
    public static Render backgroundMars53 = loadBitmapA("/Sprites/Mars revolve vray  right_0053.png");
    
    /**backgroundMars54 Render of Texture object*/
    public static Render backgroundMars54 = loadBitmapA("/Sprites/Mars revolve vray  right_0054.png");
    
    /**backgroundMars55 Render of Texture object*/
    public static Render backgroundMars55 = loadBitmapA("/Sprites/Mars revolve vray  right_0055.png");
    
    /**backgroundMars56 Render of Texture object*/
    public static Render backgroundMars56 = loadBitmapA("/Sprites/Mars revolve vray  right_0056.png");
    
    /**backgroundMars57 Render of Texture object*/
    public static Render backgroundMars57 = loadBitmapA("/Sprites/Mars revolve vray  right_0057.png");
    
    /**backgroundMars58 Render of Texture object*/
    public static Render backgroundMars58 = loadBitmapA("/Sprites/Mars revolve vray  right_0058.png");
    
    /**backgroundMars59 Render of Texture object*/
    public static Render backgroundMars59 = loadBitmapA("/Sprites/Mars revolve vray  right_0059.png");
    
    /**backgroundMars60 Render of Texture object*/
    public static Render backgroundMars60 = loadBitmapA("/Sprites/Mars revolve vray  right_0060.png");
    
    /**backgroundMars61 Render of Texture object*/
    public static Render backgroundMars61 = loadBitmapA("/Sprites/Mars revolve vray  right_0061.png");
    
    /**backgroundMars62 Render of Texture object*/
    public static Render backgroundMars62 = loadBitmapA("/Sprites/Mars revolve vray  right_0062.png");
    
    /**backgroundMars63 Render of Texture object*/
    public static Render backgroundMars63 = loadBitmapA("/Sprites/Mars revolve vray  right_0063.png");
    
    /**backgroundMars64 Render of Texture object*/
    public static Render backgroundMars64 = loadBitmapA("/Sprites/Mars revolve vray  right_0064.png");
    
    /**backgroundMars65 Render of Texture object*/
    public static Render backgroundMars65 = loadBitmapA("/Sprites/Mars revolve vray  right_0065.png");
    
    /**backgroundMars66 Render of Texture object*/
    public static Render backgroundMars66 = loadBitmapA("/Sprites/Mars revolve vray  right_0066.png");
    
    /**backgroundMars67 Render of Texture object*/
    public static Render backgroundMars67 = loadBitmapA("/Sprites/Mars revolve vray  right_0067.png");
    
    /**backgroundMars68 Render of Texture object*/
    public static Render backgroundMars68 = loadBitmapA("/Sprites/Mars revolve vray  right_0068.png");
    
    /**backgroundMars69 Render of Texture object*/
    public static Render backgroundMars69 = loadBitmapA("/Sprites/Mars revolve vray  right_0069.png");
    
    /**backgroundMars70 Render of Texture object*/
    public static Render backgroundMars70 = loadBitmapA("/Sprites/Mars revolve vray  right_0070.png");
    
    /**backgroundMars71 Render of Texture object*/
    public static Render backgroundMars71 = loadBitmapA("/Sprites/Mars revolve vray  right_0071.png");
    
    /**backgroundMars72 Render of Texture object*/
    public static Render backgroundMars72 = loadBitmapA("/Sprites/Mars revolve vray  right_0072.png");
    
    /**backgroundMars73 Render of Texture object*/
    public static Render backgroundMars73 = loadBitmapA("/Sprites/Mars revolve vray  right_0073.png");
    
    /**backgroundMars74 Render of Texture object*/
    public static Render backgroundMars74 = loadBitmapA("/Sprites/Mars revolve vray  right_0074.png");
    
    /**backgroundMars75 Render of Texture object*/
    public static Render backgroundMars75 = loadBitmapA("/Sprites/Mars revolve vray  right_0075.png");
    
    /**backgroundMars76 Render of Texture object*/
    public static Render backgroundMars76 = loadBitmapA("/Sprites/Mars revolve vray  right_0076.png");
    
    /**backgroundMars77 Render of Texture object*/
    public static Render backgroundMars77 = loadBitmapA("/Sprites/Mars revolve vray  right_0077.png");
    
    /**backgroundMars78 Render of Texture object*/
    public static Render backgroundMars78 = loadBitmapA("/Sprites/Mars revolve vray  right_0078.png");
    
    /**backgroundMars79 Render of Texture object*/
    public static Render backgroundMars79 = loadBitmapA("/Sprites/Mars revolve vray  right_0079.png");
    
    /**backgroundMars80 Render of Texture object*/
    public static Render backgroundMars80 = loadBitmapA("/Sprites/Mars revolve vray  right_0080.png");
    
    /**backgroundMars81 Render of Texture object*/
    public static Render backgroundMars81 = loadBitmapA("/Sprites/Mars revolve vray  right_0081.png");
    
    /**backgroundMars82 Render of Texture object*/
    public static Render backgroundMars82 = loadBitmapA("/Sprites/Mars revolve vray  right_0082.png");
    
    /**backgroundMars83 Render of Texture object*/
    public static Render backgroundMars83 = loadBitmapA("/Sprites/Mars revolve vray  right_0083.png");
    
    /**backgroundMars84 Render of Texture object*/
    public static Render backgroundMars84 = loadBitmapA("/Sprites/Mars revolve vray  right_0084.png");
    
    /**backgroundMars85 Render of Texture object*/
    public static Render backgroundMars85 = loadBitmapA("/Sprites/Mars revolve vray  right_0085.png");
    
    /**backgroundMars86 Render of Texture object*/
    public static Render backgroundMars86 = loadBitmapA("/Sprites/Mars revolve vray  right_0086.png");
    
    /**backgroundMars87 Render of Texture object*/
    public static Render backgroundMars87 = loadBitmapA("/Sprites/Mars revolve vray  right_0087.png");
    
    /**backgroundMars88 Render of Texture object*/
    public static Render backgroundMars88 = loadBitmapA("/Sprites/Mars revolve vray  right_0088.png");
    
    
    
    /**backgroundSun0 Render of Texture object*/
    public static Render backgroundSun0 = loadBitmapA("/Sprites/Sun revolve vray right_0000.png");
    
    /**backgroundSun1 Render of Texture object*/
    public static Render backgroundSun1 = loadBitmapA("/Sprites/Sun revolve vray right_0001.png");
    
    /**backgroundSun2 Render of Texture object*/
    public static Render backgroundSun2 = loadBitmapA("/Sprites/Sun revolve vray right_0002.png");
    
    /**backgroundSun3 Render of Texture object*/
    public static Render backgroundSun3 = loadBitmapA("/Sprites/Sun revolve vray right_0003.png");
    
    /**backgroundSun4 Render of Texture object*/
    public static Render backgroundSun4 = loadBitmapA("/Sprites/Sun revolve vray right_0004.png");
    
    /**backgroundSun5 Render of Texture object*/
    public static Render backgroundSun5 = loadBitmapA("/Sprites/Sun revolve vray right_0005.png");
    
    /**backgroundSun6 Render of Texture object*/
    public static Render backgroundSun6 = loadBitmapA("/Sprites/Sun revolve vray right_0006.png");
    
    /**backgroundSun7 Render of Texture object*/
    public static Render backgroundSun7 = loadBitmapA("/Sprites/Sun revolve vray right_0007.png");
    
    /**backgroundSun8 Render of Texture object*/
    public static Render backgroundSun8 = loadBitmapA("/Sprites/Sun revolve vray right_0008.png");
    
    /**backgroundSun9 Render of Texture object*/
    public static Render backgroundSun9 = loadBitmapA("/Sprites/Sun revolve vray right_0009.png");
    
    /**backgroundSun10 Render of Texture object*/
    public static Render backgroundSun10 = loadBitmapA("/Sprites/Sun revolve vray right_0010.png");
    
    /**backgroundSun11 Render of Texture object*/
    public static Render backgroundSun11 = loadBitmapA("/Sprites/Sun revolve vray right_0011.png");
    
    /**backgroundSun12 Render of Texture object*/
    public static Render backgroundSun12 = loadBitmapA("/Sprites/Sun revolve vray right_0012.png");
    
    /**backgroundSun13 Render of Texture object*/
    public static Render backgroundSun13 = loadBitmapA("/Sprites/Sun revolve vray right_0013.png");
    
    /**backgroundSun14 Render of Texture object*/
    public static Render backgroundSun14 = loadBitmapA("/Sprites/Sun revolve vray right_0014.png");
    
    /**backgroundSun15 Render of Texture object*/
    public static Render backgroundSun15 = loadBitmapA("/Sprites/Sun revolve vray right_0015.png");
    
    /**backgroundSun16 Render of Texture object*/
    public static Render backgroundSun16 = loadBitmapA("/Sprites/Sun revolve vray right_0016.png");
    
    /**backgroundSun17 Render of Texture object*/
    public static Render backgroundSun17 = loadBitmapA("/Sprites/Sun revolve vray right_0017.png");
    
    /**backgroundSun18 Render of Texture object*/
    public static Render backgroundSun18 = loadBitmapA("/Sprites/Sun revolve vray right_0018.png");
    
    /**backgroundSun19 Render of Texture object*/
    public static Render backgroundSun19 = loadBitmapA("/Sprites/Sun revolve vray right_0019.png");
    
    /**backgroundSun20 Render of Texture object*/
    public static Render backgroundSun20 = loadBitmapA("/Sprites/Sun revolve vray right_0020.png");
    
    /**backgroundSun21 Render of Texture object*/
    public static Render backgroundSun21 = loadBitmapA("/Sprites/Sun revolve vray right_0021.png");
    
    /**backgroundSun22 Render of Texture object*/
    public static Render backgroundSun22 = loadBitmapA("/Sprites/Sun revolve vray right_0022.png");
    
    /**backgroundSun23 Render of Texture object*/
    public static Render backgroundSun23 = loadBitmapA("/Sprites/Sun revolve vray right_0023.png");
    
    /**backgroundSun24 Render of Texture object*/
    public static Render backgroundSun24 = loadBitmapA("/Sprites/Sun revolve vray right_0024.png");
    
    /**backgroundSun25 Render of Texture object*/
    public static Render backgroundSun25 = loadBitmapA("/Sprites/Sun revolve vray right_0025.png");
    
    /**backgroundSun26 Render of Texture object*/
    public static Render backgroundSun26 = loadBitmapA("/Sprites/Sun revolve vray right_0026.png");
    
    /**backgroundSun27 Render of Texture object*/
    public static Render backgroundSun27 = loadBitmapA("/Sprites/Sun revolve vray right_0027.png");
    
    /**backgroundSun28 Render of Texture object*/
    public static Render backgroundSun28 = loadBitmapA("/Sprites/Sun revolve vray right_0028.png");
    
    /**backgroundSun29 Render of Texture object*/
    public static Render backgroundSun29 = loadBitmapA("/Sprites/Sun revolve vray right_0029.png");
    
    /**backgroundSun30 Render of Texture object*/
    public static Render backgroundSun30 = loadBitmapA("/Sprites/Sun revolve vray right_0030.png");
    
    /**backgroundSun31 Render of Texture object*/
    public static Render backgroundSun31 = loadBitmapA("/Sprites/Sun revolve vray right_0031.png");
    
    /**backgroundSun32 Render of Texture object*/
    public static Render backgroundSun32 = loadBitmapA("/Sprites/Sun revolve vray right_0032.png");
    
    /**backgroundSun33 Render of Texture object*/
    public static Render backgroundSun33 = loadBitmapA("/Sprites/Sun revolve vray right_0033.png");
    
    /**backgroundSun34 Render of Texture object*/
    public static Render backgroundSun34 = loadBitmapA("/Sprites/Sun revolve vray right_0034.png");
    
    /**backgroundSun35 Render of Texture object*/
    public static Render backgroundSun35 = loadBitmapA("/Sprites/Sun revolve vray right_0035.png");
    
    /**backgroundSun36 Render of Texture object*/
    public static Render backgroundSun36 = loadBitmapA("/Sprites/Sun revolve vray right_0036.png");
    
    /**backgroundSun37 Render of Texture object*/
    public static Render backgroundSun37 = loadBitmapA("/Sprites/Sun revolve vray right_0037.png");
    
    /**backgroundSun38 Render of Texture object*/
    public static Render backgroundSun38 = loadBitmapA("/Sprites/Sun revolve vray right_0038.png");
    
    /**backgroundSun39 Render of Texture object*/
    public static Render backgroundSun39 = loadBitmapA("/Sprites/Sun revolve vray right_0039.png");
    
    /**backgroundSun40 Render of Texture object*/
    public static Render backgroundSun40 = loadBitmapA("/Sprites/Sun revolve vray right_0040.png");
    
    /**backgroundSun41 Render of Texture object*/
    public static Render backgroundSun41 = loadBitmapA("/Sprites/Sun revolve vray right_0041.png");
    
    /**backgroundSun42 Render of Texture object*/
    public static Render backgroundSun42 = loadBitmapA("/Sprites/Sun revolve vray right_0042.png");
    
    /**backgroundSun43 Render of Texture object*/
    public static Render backgroundSun43 = loadBitmapA("/Sprites/Sun revolve vray right_0043.png");
    
    /**backgroundSun44 Render of Texture object*/
    public static Render backgroundSun44 = loadBitmapA("/Sprites/Sun revolve vray right_0044.png");
    
    /**backgroundSun45 Render of Texture object*/
    public static Render backgroundSun45 = loadBitmapA("/Sprites/Sun revolve vray right_0045.png");
    
    /**backgroundSun46 Render of Texture object*/
    public static Render backgroundSun46 = loadBitmapA("/Sprites/Sun revolve vray right_0046.png");
    
    /**backgroundSun47 Render of Texture object*/
    public static Render backgroundSun47 = loadBitmapA("/Sprites/Sun revolve vray right_0047.png");
    
    /**backgroundSun48 Render of Texture object*/
    public static Render backgroundSun48 = loadBitmapA("/Sprites/Sun revolve vray right_0048.png");
    
    /**backgroundSun49 Render of Texture object*/
    public static Render backgroundSun49 = loadBitmapA("/Sprites/Sun revolve vray right_0049.png");
    
    /**backgroundSun50 Render of Texture object*/
    public static Render backgroundSun50 = loadBitmapA("/Sprites/Sun revolve vray right_0050.png");
    
    /**backgroundSun51 Render of Texture object*/
    public static Render backgroundSun51 = loadBitmapA("/Sprites/Sun revolve vray right_0051.png");
    
    /**backgroundSun52 Render of Texture object*/
    public static Render backgroundSun52 = loadBitmapA("/Sprites/Sun revolve vray right_0052.png");
    
    /**backgroundSun53 Render of Texture object*/
    public static Render backgroundSun53 = loadBitmapA("/Sprites/Sun revolve vray right_0053.png");
    
    /**backgroundSun54 Render of Texture object*/
    public static Render backgroundSun54 = loadBitmapA("/Sprites/Sun revolve vray right_0054.png");
    
    /**backgroundSun55 Render of Texture object*/
    public static Render backgroundSun55 = loadBitmapA("/Sprites/Sun revolve vray right_0055.png");
    
    /**backgroundSun56 Render of Texture object*/
    public static Render backgroundSun56 = loadBitmapA("/Sprites/Sun revolve vray right_0056.png");
    
    /**backgroundSun57 Render of Texture object*/
    public static Render backgroundSun57 = loadBitmapA("/Sprites/Sun revolve vray right_0057.png");
    
    /**backgroundSun58 Render of Texture object*/
    public static Render backgroundSun58 = loadBitmapA("/Sprites/Sun revolve vray right_0058.png");
    
    /**backgroundSun59 Render of Texture object*/
    public static Render backgroundSun59 = loadBitmapA("/Sprites/Sun revolve vray right_0059.png");
    
    /**backgroundSun60 Render of Texture object*/
    public static Render backgroundSun60 = loadBitmapA("/Sprites/Sun revolve vray right_0060.png");
    
    /**backgroundSun61 Render of Texture object*/
    public static Render backgroundSun61 = loadBitmapA("/Sprites/Sun revolve vray right_0061.png");
    
    /**backgroundSun62 Render of Texture object*/
    public static Render backgroundSun62 = loadBitmapA("/Sprites/Sun revolve vray right_0062.png");
    
    /**backgroundSun63 Render of Texture object*/
    public static Render backgroundSun63 = loadBitmapA("/Sprites/Sun revolve vray right_0063.png");
    
    /**backgroundSun64 Render of Texture object*/
    public static Render backgroundSun64 = loadBitmapA("/Sprites/Sun revolve vray right_0064.png");
    
    /**backgroundSun65 Render of Texture object*/
    public static Render backgroundSun65 = loadBitmapA("/Sprites/Sun revolve vray right_0065.png");
    
    /**backgroundSun66 Render of Texture object*/
    public static Render backgroundSun66 = loadBitmapA("/Sprites/Sun revolve vray right_0066.png");
    
    /**backgroundSun67 Render of Texture object*/
    public static Render backgroundSun67 = loadBitmapA("/Sprites/Sun revolve vray right_0067.png");
    
    /**backgroundSun68 Render of Texture object*/
    public static Render backgroundSun68 = loadBitmapA("/Sprites/Sun revolve vray right_0068.png");
    
    /**backgroundSun69 Render of Texture object*/
    public static Render backgroundSun69 = loadBitmapA("/Sprites/Sun revolve vray right_0069.png");
    
    /**backgroundSun70 Render of Texture object*/
    public static Render backgroundSun70 = loadBitmapA("/Sprites/Sun revolve vray right_0070.png");
    
    /**backgroundSun71 Render of Texture object*/
    public static Render backgroundSun71 = loadBitmapA("/Sprites/Sun revolve vray right_0071.png");
    
    /**backgroundSun72 Render of Texture object*/
    public static Render backgroundSun72 = loadBitmapA("/Sprites/Sun revolve vray right_0072.png");
    
    /**backgroundSun73 Render of Texture object*/
    public static Render backgroundSun73 = loadBitmapA("/Sprites/Sun revolve vray right_0073.png");
    
    /**backgroundSun74 Render of Texture object*/
    public static Render backgroundSun74 = loadBitmapA("/Sprites/Sun revolve vray right_0074.png");
    
    /**backgroundSun75 Render of Texture object*/
    public static Render backgroundSun75 = loadBitmapA("/Sprites/Sun revolve vray right_0075.png");
    
    /**backgroundSun76 Render of Texture object*/
    public static Render backgroundSun76 = loadBitmapA("/Sprites/Sun revolve vray right_0076.png");
    
    /**backgroundSun77 Render of Texture object*/
    public static Render backgroundSun77 = loadBitmapA("/Sprites/Sun revolve vray right_0077.png");
    
    /**backgroundSun78 Render of Texture object*/
    public static Render backgroundSun78 = loadBitmapA("/Sprites/Sun revolve vray right_0078.png");
    
    /**backgroundSun79 Render of Texture object*/
    public static Render backgroundSun79 = loadBitmapA("/Sprites/Sun revolve vray right_0079.png");
    
    /**backgroundSun80 Render of Texture object*/
    public static Render backgroundSun80 = loadBitmapA("/Sprites/Sun revolve vray right_0080.png");
    
    /**backgroundSun81 Render of Texture object*/
    public static Render backgroundSun81 = loadBitmapA("/Sprites/Sun revolve vray right_0081.png");
    
    /**backgroundSun82 Render of Texture object*/
    public static Render backgroundSun82 = loadBitmapA("/Sprites/Sun revolve vray right_0082.png");
    
    /**backgroundSun83 Render of Texture object*/
    public static Render backgroundSun83 = loadBitmapA("/Sprites/Sun revolve vray right_0083.png");
    
    /**backgroundSun84 Render of Texture object*/
    public static Render backgroundSun84 = loadBitmapA("/Sprites/Sun revolve vray right_0084.png");
    
    /**backgroundSun85 Render of Texture object*/
    public static Render backgroundSun85 = loadBitmapA("/Sprites/Sun revolve vray right_0085.png");
    
    /**backgroundSun86 Render of Texture object*/
    public static Render backgroundSun86 = loadBitmapA("/Sprites/Sun revolve vray right_0086.png");
    
    /**backgroundSun87 Render of Texture object*/
    public static Render backgroundSun87 = loadBitmapA("/Sprites/Sun revolve vray right_0087.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render backgroundSun88 = loadBitmapA("/Sprites/Sun revolve vray right_0088.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render startMenu = loadBitmapA("/startMenu_1.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render startMenu0 = loadBitmapA("/startMenu_2.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render menuImage = loadBitmapA("/menuState_2.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render menuImage0 = loadBitmapA("/menuState_4.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render keysMenuImage = loadBitmapA("/optionsMenu_2b.png");
    
    /**backgroundSun88 Render of Texture object*/
    public static Render keysMenuImage0 = loadBitmapA("/optionsMenu_3a.png");
    
    
    /**SI2015Logo Render of Texture object*/
    public static Render SI2015Logo = loadBitmap("/SI2015-Logo2018.png");
    
    /**SI2015ScoreSheet Render of Texture object*/
    public static Render SI2015ScoreSheet = loadBitmap("/space_invaders-score-sheet.png");
    
    /**BRCExplode Render of Texture object*/
    public static Render BRCExplode = loadBitmap("/Sprites/SI_BarricadeDamage.png");
    
    /**BRC Render of Texture object*/
    public static Render BRC = loadBitmap("/Sprites/SI_BoxWhite.png");
    
    /**space0 Render of Texture object*/
    public static Render space0 = loadBitmapA("/textures/space.png");
    
    /**about Render of Texture object*/
    public static Render about = loadBitmap("/textures/SI_about0.png");
    
    /**about1 Render of Texture object*/
    public static Render about1 = loadBitmap("/textures/SI_about1.png");
    
    /**instructions Render of Texture object*/
    public static Render instructions = loadBitmap("/textures/SI_instructions.png");
    
    
    /**credits0 Render of Texture object*/
    public static Render creditsBlank = loadBitmap("/menu/credits/credits_Blank.png");
    
    /**creditsPublisher Render of Texture object*/
    public static Render creditsPublisher = loadBitmap("/menu/credits/credits_Publisher.png");
    
    /**creditsPublisherBlank Render of Texture object*/
    public static Render creditsPublisherBlank = loadBitmap("/menu/credits/credits_Publisher_Blank.png");
    
    /**credits0 Render of Texture object*/
    public static Render credits0 = loadBitmap("/menu/credits/credits_Director.png");
    
    /**credits1 Render of Texture object*/
    public static Render credits1 = loadBitmap("/menu/credits/credits_Producer.png");
    
    /**credits2 Render of Texture object*/
    public static Render credits2 = loadBitmap("/menu/credits/credits_Art_Director.png");
    
    /**credits3 Render of Texture object*/
    public static Render credits3 = loadBitmap("/menu/credits/credits_Lead_Programmer.png");
    
    /**credits4 Render of Texture object*/
    public static Render credits4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer.png");
    
    /**credits5 Render of Texture object*/
    public static Render credits5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester.png");
    
    /**credits6 Render of Texture object*/
    public static Render credits6 = loadBitmap("/menu/credits/credits_Technical_Lead.png");
    
    /**credits7 Render of Texture object*/
    public static Render credits7 = loadBitmap("/menu/credits/credits_Environment_Artist.png");
    
    /**credits8 Render of Texture object*/
    public static Render credits8 = loadBitmap("/menu/credits/credits_Sound_Engineer.png");
    
    /**credits9 Render of Texture object*/
    public static Render credits9 = loadBitmap("/menu/credits/credits_Level_Designer.png");
    
    /**credits10 Render of Texture object*/
    public static Render credits10 = loadBitmap("/menu/credits/credits_GUI_Artist.png");
    
    
    /**creditsA0 Render of Texture object*/
    public static Render creditsA0 = loadBitmap("/menu/credits/credits_Director0.png");
    
    /**creditsA1 Render of Texture object*/
    public static Render creditsA1 = loadBitmap("/menu/credits/credits_Producer0.png");
    
    /**creditsA2 Render of Texture object*/
    public static Render creditsA2 = loadBitmap("/menu/credits/credits_Art_Director0.png");
    
    /**creditsA3 Render of Texture object*/
    public static Render creditsA3 = loadBitmap("/menu/credits/credits_Lead_Programmer0.png");
    
    /**creditsA4 Render of Texture object*/
    public static Render creditsA4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer0.png");
    
    /**creditsA5 Render of Texture object*/
    public static Render creditsA5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester0.png");
    
    /**creditsA6 Render of Texture object*/
    public static Render creditsA6 = loadBitmap("/menu/credits/credits_Technical_Lead0.png");
    
    /**creditsA7 Render of Texture object*/
    public static Render creditsA7 = loadBitmap("/menu/credits/credits_Environment_Artist0.png");
    
    /**creditsA8 Render of Texture object*/
    public static Render creditsA8 = loadBitmap("/menu/credits/credits_Sound_Engineer0.png");
    
    /**creditsA9 Render of Texture object*/
    public static Render creditsA9 = loadBitmap("/menu/credits/credits_Level_Designer0.png");
    
    /**creditsA10 Render of Texture object*/
    public static Render creditsA10 = loadBitmap("/menu/credits/credits_GUI_Artist0.png");
    
    
    /**creditsB0 Render of Texture object*/
    public static Render creditsB0 = loadBitmap("/menu/credits/credits_Director1.png");
    
    /**creditsB1 Render of Texture object*/
    public static Render creditsB1 = loadBitmap("/menu/credits/credits_Producer1.png");
    
    /**creditsB2 Render of Texture object*/
    public static Render creditsB2 = loadBitmap("/menu/credits/credits_Art_Director1.png");
    
    /**creditsB3 Render of Texture object*/
    public static Render creditsB3 = loadBitmap("/menu/credits/credits_Lead_Programmer1.png");
    
    /**creditsB4 Render of Texture object*/
    public static Render creditsB4 = loadBitmap("/menu/credits/credits_Snr_Game_Designer1.png");
    
    /**creditsB5 Render of Texture object*/
    public static Render creditsB5 = loadBitmap("/menu/credits/credits_Lead_QA_Tester1.png");
    
    /**creditsB6 Render of Texture object*/
    public static Render creditsB6 = loadBitmap("/menu/credits/credits_Technical_Lead1.png");
    
    /**creditsB7 Render of Texture object*/
    public static Render creditsB7 = loadBitmap("/menu/credits/credits_Environment_Artist1.png");
    
    /**creditsB8 Render of Texture object*/
    public static Render creditsB8 = loadBitmap("/menu/credits/credits_Sound_Engineer1.png");
    
    /**creditsB9 Render of Texture object*/
    public static Render creditsB9 = loadBitmap("/menu/credits/credits_Level_Designer1.png");
    
    /**creditsB10 Render of Texture object*/
    public static Render creditsB10 = loadBitmap("/menu/credits/credits_GUI_Artist1.png");
    
    
    /**creditsLightening Render of Texture object*/
    public static Render creditsLightening = loadBitmap("/menu/credits/lighteningA0.png");
    
    /**creditsLightening0 Render of Texture object*/
    public static Render creditsLightening0 = loadBitmap("/menu/credits/lightening1.png");
    
    /**creditsLightening1 Render of Texture object*/
    public static Render creditsLightening1 = loadBitmap("/menu/credits/lightening2.png");
    
    /**creditsLightening Render of Texture object*/
    public static Render creditsLightening2 = loadBitmap("/menu/credits/lightening3.png");
    
    /**creditsLightening0 Render of Texture object*/
    public static Render creditsLightening3 = loadBitmap("/menu/credits/lightening4.png");
    
    /**creditsLightening1 Render of Texture object*/
    public static Render creditsLightening4 = loadBitmap("/menu/credits/lightening5.png");
    
    
    
    /**Constructor*/
    
    
    /**
    * Texture(String fileName)
    * 
    * @param fileName
    */
    public Texture(String fileName) {
        this.fileName = fileName;
        this.filePath = "res"+ fileName + ".png";
        BufferedImage oldTex = texMap.get(fileName);
        if(oldTex != null){
            this.img = oldTex;
        } else {
        
        try {
            System.out.println("Loading Texture: "+Game.textCount+": " + fileName);
            this.img = ImageIO.read(Texture.class.getResource(fileName + ".png"));
            texMap.put(fileName, img);
            Game.textCount++;
        } catch (IOException ex) {
            Logger.getLogger(Texture.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        this.width = img.getWidth();
        this.height = img.getHeight();
    }
    
    
    
    /**Public Protocol*/
    
    /**
     * finalize()
     * 
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        if(!fileName.isEmpty()){ 
            texMap.remove(fileName);
            System.out.println("Removing Texture from memory: " + fileName);
        }
        if(!renderFileName.isEmpty()){ 
            renMap.remove(renderFileName);
            System.out.println("Removing Render from memory: " + renderFileName);
        }
        super.finalize();
    }
    
    
    /**
    * render(Graphics2D g, int x, int y, int width, int height)
    * 
    * Renders/Repaints Texture Objects
    * 
    * @param g
    * @param x - the x variable Texture object
    * @param y - the y variable Texture object
    * @param width - the width variable Texture object
    * @param height - the height variable Texture object
    */
    public void render(Graphics2D g, int x, int y, int width, int height){
        g.drawImage(img, x, y, width, height, null);
    }
    
    
    /**
    * render(Graphics2D g, int x, int y, int width, int height, Color col)
    * 
    * Renders/Repaints Texture Objects
    * 
    * @param g
    * @param x - the x variable Texture object
    * @param y - the y variable Texture object
    * @param width - the width variable Texture object
    * @param height - the height variable Texture object
    * @param col - the color variable Texture object
    */
    public void render(Graphics2D g, int x, int y, int width, int height, Color col){
        g.drawImage(img, x, y, width, height, col, null);
    }
    
    
    /**
    * loadBitmap(String fileName)
    * 
    * 
    * @param fileName - the fileName variable Texture object
    * 
    * @return result
    */  
    public static Render loadBitmap(String fileName) {
        renderFileName = fileName;
        
        Render oldRen = renMap.get(fileName);
        if(oldRen != null){
            render = oldRen;
        } else {
            
            try {
                System.out.println("Loading Render: "+Game.renderCount+ " " + renderFileName);
                renIMG = ImageIO.read(Texture.class.getResource(renderFileName));
                renWidth = renIMG.getWidth();
                renHeight = renIMG.getHeight();
                render = new Render(renWidth, renHeight);
                renIMG.getRGB(0, 0, renWidth, renHeight, render.pixels, 0, renWidth);
                for (int i = 0; i < render.pixels.length; i++) {
                    int in = render.pixels[i];
                    int col = (in & 0xf) >> 2;
                    if (in == 0xffff00ff) {
                        col = -1;
                    }
                    render.pixels[i] = col;
                }
                
                renMap.put(renderFileName, render);
                Game.renderCount++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return renMap.get(renderFileName);
    }
    
    
    /**
    * loadTranslucentImage(String renderFName, float transperancy)
    * 
    * @param renderFName
    * @param transperancy
    * 
    * @return result
    */     
    public static Render loadTranslucentImage(String renderFName, float transperancy) {
        renderFileName = renderFName;
        
        Render oldRen = renMap.get(renderFName);
        if(oldRen != null){
            render = oldRen;
        } else {
            try {
                System.out.println("Loading Render: "+Game.renderCount+ " " + renderFileName);
                renIMG = ImageIO.read(Texture.class.getResource(renderFileName));
                renWidth = renIMG.getWidth();
                renHeight = renIMG.getHeight();
                
                // Create the image using the
                BufferedImage aimg = new BufferedImage(renWidth, renHeight, BufferedImage.TRANSLUCENT);
                // Get the images graphics
                Graphics2D g = aimg.createGraphics();
                // Set the Graphics composite to Alpha
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transperancy));
                // Draw the LOADED img into the prepared reciver image
                g.drawImage(renIMG, null, 0, 0);
                // let go of all system resources in this Graphics
                g.dispose();

                //int width = aimg.getWidth();
                //int height = aimg.getHeight();
                render = new Render(renWidth, renHeight);
                aimg.getRGB(0, 0, renWidth, renHeight, render.pixels, 0, renWidth);
//                for (int i = 0; i < render.pixels.length; i++) {
//                    int in = render.pixels[i];
//                    int col = (in & 0xf) >> 2;
//                    if (in == 0xffff00ff) {
//                        col = -1;
//                    }
//                    render.pixels[i] = col;
//                }
                
                renMap.put(renderFileName, render);
                Game.renderCount++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
        }
        return renMap.get(renderFileName);
    }

    
    /**
    * loadBitmapA(String renderFName)
    * 
    * 
    * @param renderFName - the renderFName variable Texture object
    * 
    * @return result
    */     
    public static Render loadBitmapA(String renderFName) {
        renderFileName = renderFName;
        
        Render oldRen = renMap.get(renderFName);
        if(oldRen != null){
            render = oldRen;
        } else {
            
            try {
                System.out.println("Loading Render: "+Game.renderCount+ " " + renderFileName);
                renIMG = ImageIO.read(Texture.class.getResource(renderFileName));
                renWidth = renIMG.getWidth();
                renHeight = renIMG.getHeight();
                render = new Render(renWidth, renHeight);
                renIMG.getRGB(0, 0, renWidth, renHeight, render.pixels, 0, renWidth);

                renMap.put(renderFileName, render);
                Game.renderCount++;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return renMap.get(renderFileName);
    }

    

    /**
     * getFilePath()
     * 
     * @return this.filePath
     */
    public String getFilePath(){
        return this.filePath;
    }
    
    
    /**
     * getImage()
     * 
     * @return img
     */
    public BufferedImage getImage(){
        return img;
    }

    
    /**
     * getWidth()
     * 
     * @return width
     */
    public int getWidth() {
        return width;
    }

    
    /**
     * getHeight()
     * 
     * @return height
     */
    public int getHeight() {
        return height;
    }
    
    
    /**
    * getCol(int c)
    * 
    * @param c - the c variable Texture object
    * 
    * @return r - << 16 | g << 8 | b
    */    
//    public static int getCol(int c) {
//        int r = (c >> 16) & 0xff;
//        int g = (c >> 8) & 0xff;
//        int b = (c) & 0xff;
//
//        r = r * 0x55 / 0xff;
//        g = g * 0x55 / 0xff;
//        b = b * 0x55 / 0xff;
//
//        return r << 16 | g << 8 | b;
//    }
    
    
    /**
     * clearMaps()
     * 
     */
    public static void clearMaps(){
        texMap.clear();
        renMap.clear();
    }
    
    
}
