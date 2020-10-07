/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.level;

import com.spaceinvaders.graphics.Labels;
import com.spaceinvaders.graphics.Render;
import com.spaceinvaders.graphics.Texture;
import com.spaceinvaders.pkg2018.Display;
import com.spaceinvaders.pkg2018.Game;
import com.spaceinvaders.player.Player;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Ghomez
 */
public class HUD {

    /**Attributes*/
    
    /**ceilBounds Rectangle of HUD object*/ 
    public static Rectangle ceilBounds;
    
    
    /**Constructor*/
    
    /**
     * HUD()
     * 
     */
    public HUD() {
        System.out.println("HUD: New HUD Created");
        //this.game = game;
        setUp();
    }
    
    
    /**Public protocol*/
    
    
    /**
     * setUp()
     * 
     */
    private void setUp(){
        ceilBounds = new Rectangle(0, Labels.livesLabelY+22, Game.gameWidth, 28);
        
        Player.levelNo = "Lv";
        Player.livesNo = "L";
    }
    
    
    /**
     * init()
     * 
     */
    private void init(){
        
    }
    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints Level Objects
    * 
    * @param target - the Render of Level
    * @param g
    */
    public void render(Render target, Graphics2D g){
        if(Display.showHUD){
            if(!Level.levelComplete && Game.pauseTime == 0){
                target.scaleDraw(Texture.livesLabel, Labels.LabelScale, Labels.livesLabelX, Labels.livesLabelY, 0, 0, 64, 64, Labels.livesLabelBGCol);
                target.scaleDraw(Texture.livesLabel, Labels.LabelScale, Labels.livesLabelX-2, Labels.livesLabelY-2, 0, 0, 64, 64, Labels.livesLabelFGCol);

                if(Game.gameScore >= 100000){
                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-20, Labels.scoreLabelY, 0, 0, 64, 64, Labels.scoreLabelBGCol);
                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-18, Labels.scoreLabelY-2, 0, 0, 64, 64, Labels.scoreLabelFGCol);
                } else {
                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX, Labels.scoreLabelY, 0, 0, 64, 64, Labels.scoreLabelBGCol);
                    target.scaleDraw(Texture.scoreLabel, Labels.LabelScale, Labels.scoreLabelX-2, Labels.scoreLabelY-2, 0, 0, 64, 64, Labels.scoreLabelFGCol);
                }
            }

            int gameScoreX = Labels.scoreX;
            Player.levelNo = "Lv"+Game.levelNo;
            Player.livesNo = "L"+Player.lives;

            if(Game.gameScore == 0){
                gameScoreX = Labels.scoreX-5;
                Game.player.setPlayScore("0000");
            } else if(Game.gameScore > 0  && Game.gameScore < 100){
                gameScoreX = Labels.scoreX-5;
                Game.player.setPlayScore("00"+Game.gameScore);
            } else if(Game.gameScore >= 100 && Game.gameScore < 1000){
                gameScoreX = Labels.scoreX-5;
                Game.player.setPlayScore("0"+Game.gameScore);
            } else if(Game.gameScore >= 1000 && Game.gameScore < 100000){
                gameScoreX = Labels.scoreX-5;
                Game.player.setPlayScore(""+Game.gameScore);
            } else if(Game.gameScore >= 100000){
                gameScoreX = Labels.scoreX-(5 + Game.player.getPlayScore().length());
                Game.player.setPlayScore(""+Game.gameScore);
            }   
            target.draw(Game.player.getPlayScore(), gameScoreX, Labels.scoreY, 0x00ff0c);

            if(Display.showBounds){
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(ceilBounds.x, ceilBounds.y, ceilBounds.width - 1, ceilBounds.height);
            }   

            if(Player.rapidFire){
                g.setColor(Color.red);
                g.drawRect(Labels.playerNameX-30, Labels.playerNameY-14, 76, 11);
                target.draw("RAPID", Labels.playerNameX-26, Labels.playerNameY-12, 0xff000c);
            }
            if(Display.showKillShot){
                g.setColor(Color.red);
                g.drawRect(Labels.playerNameX+142, Labels.playerNameY-14, 28, 11);
                target.draw("KShot:"+Player.killShot, Labels.playerNameX+50, Labels.playerNameY-12, 0xff000c);
            } else {
                if(Player.rapidFire){
                    g.setColor(Color.white);
                    g.drawRect(Labels.playerNameX+48, Labels.playerNameY-14, 208, 11);
                    target.draw("Hi-Score:"+Player.hiScore[0], Labels.playerNameX+50, Labels.playerNameY-12, 0xffffff);
                } else {
                    g.setColor(Color.white);
                    g.drawRect(Labels.playerNameX-32, Labels.playerNameY-14, 208, 11);
                    target.draw("Hi-Score:"+Player.hiScore[0], Labels.playerNameX-30, Labels.playerNameY-12, 0xffffff);
                }
            }

            target.draw(Player.livesNo, Labels.playerNameX-30, Labels.playerNameY, 0xdd0f0c);
            target.draw(Player.playName, Labels.playerNameX, Labels.playerNameY, 0x00ff0c);
            target.draw(Player.levelNo, Labels.playerNameX+126, Labels.playerNameY, 0xdd0f0c);
            
            //Draw 4 or More Lives left
            if(Player.lives > 3){			
                g.drawImage(Player.imgPLives, Labels.livesImg0X, Labels.livesImg0Y, Labels.livesImgScale, Labels.livesImgScale, null);

                target.drawText("X"+Player.lives, 2, Labels.playerNameX-120, Labels.playerNameY-4, 0x00ff0c);
            }
            //Draw Three Lives left
            if(Player.lives == 3){
                g.drawImage(Player.imgPLives, Labels.livesImg2X, Labels.livesImg2Y, Labels.livesImgScale, Labels.livesImgScale, null);
                g.drawImage(Player.imgPLives, Labels.livesImg1X, Labels.livesImg1Y, Labels.livesImgScale, Labels.livesImgScale, null);
                g.drawImage(Player.imgPLives, Labels.livesImg0X, Labels.livesImg0Y, Labels.livesImgScale, Labels.livesImgScale, null);
            }
            //Draw Two Lives left
            if(Player.lives == 2){			
                g.drawImage(Player.imgPLives, Labels.livesImg0X, Labels.livesImg0Y, Labels.livesImgScale, Labels.livesImgScale, null);
                g.drawImage(Player.imgPLives, Labels.livesImg1X, Labels.livesImg1Y, Labels.livesImgScale, Labels.livesImgScale, null);
            }
            //Draw One Live left
            if(Player.lives == 1){
                g.drawImage(Player.imgPLives, Labels.livesImg0X, Labels.livesImg0Y, Labels.livesImgScale, Labels.livesImgScale, null);
            }
        }
    }
    
    
    
    
}
