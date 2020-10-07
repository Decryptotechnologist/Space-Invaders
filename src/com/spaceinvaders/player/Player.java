package com.spaceinvaders.player;

import com.spaceinvaders.bullets.P1Bullet;
import com.spaceinvaders.explodes.P1Explode;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.pkg2018.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Player objects represent the user in the game
 * represented by a small green spaceship that 
 * fires bullets at aliens
 * 
 * @author(s) Ghomez
 */
public class Player {

    /**Attributes*/
        
    /**mouseLeft boolean of Player object*/
    public static boolean mouseLeft;
    
    /**mouseRight boolean of Player object*/
    public static boolean mouseRight;
    
    /**mouseFire boolean of Player object*/
    public static boolean mouseFire;

    /**name variable of Player object*/
    public static String name;
    
    /**shotsFired variable of Player object*/
    private static int shotsFired;
    
    /**hiScore variable of Player object*/
    public static String[] hiScore = {"1000", "2000"};

    /**x coordinate of Player object*/
    public double x;
        
    /**y coordinate of Player object*/
    public double y;
        
    /**Speed of travel of Player object*/
    public static double moveSpeed;// = 18;
    
    /**StarzX coordinate of Player object*/
    public double StarzX = 0;
        
    /**width variable of Player object*/
    public static int Pwidth;
        
    /**height variable of Player object*/
    public static int Pheight;
        
    /**lives variable of Player object*/
    public static int lives;
        
    /**Lose A Life count variable of Player object*/
    private int LALCount = 0;
       
    /**references a Player Rectangle object*/
    public Rectangle P1rect;
	
    /**isDead boolean of Player object*/
    public boolean isDead = false;
    
    /**time variable of Player object*/
    public int time;   
    
    /**startLives variable of Player object*/
    public int startLives;
    
    /**killShot variable of Player object*/
    public static int killShot;
    
    /**isFiring boolean of Player object*/
    public static boolean isFiring;
    
    /**power variable of Player object*/
    public static int power;
    
    /**suit variable of Player object*/
    public static int suit; 
    
    /**fired boolean of Player object*/
    public boolean fired;

    /**playName variable of Player object*/
    public static String playName;
    
    /**playScore variable of Player object*/
    public static String playScore;
    
    /**playScore variable of Player object*/
    public static String levelNo;
    
    /**plivesImg BufferedImage of Player object*/
    private final BufferedImage plivesImg;
    
    /**playerImg BufferedImage of Player object*/
    private final BufferedImage playerImg;
    
    /**playerCannonImga BufferedImage of Player object*/
    private final BufferedImage playerCannonImga;
    
    /**playerCannonImgb BufferedImage of Player object*/
    private final BufferedImage playerCannonImgb;
    
    /**playerShieldImga BufferedImage of Player object*/
    private final BufferedImage playerShieldImga;
    
    /**playerShieldImgb BufferedImage of Player object*/
    private final BufferedImage playerShieldImgb;
    
    /**playerSpeedImg BufferedImage of Player object*/
    private final BufferedImage playerSpeedImg;
    
    /**rapidFire boolean of Player object*/
    public static boolean rapidFire;
    
    /**livesNo variable of Player object*/
    public static String livesNo;
    
    /**ImgPLives BufferedImage of Player object*/
    public static BufferedImage imgPLives;
    
    /**ImgP1 BufferedImage of Player object*/
    private BufferedImage imgP1;
    
    
    /**Links*/
        
    /**A Linked Game object*/
    public Game game;

    
    
        
    /**Constructor*/
        
    
    /**
     * Player(int x, int y, int h, int w, String name, int lives)
     * 
     * Initialises a new Player object with a this.x set to x,
     * this.y set to y, this.Pheight set to h, this.Pwidth set 
     * to w, this.isDead set to isDead, this.visible 
     * set to vis and this.Direction set to DIR(NOT implemented)
     * 
     * @param x - the x coordinate of Player
     * @param y - the y coordinate of Player
     * @param h - the height of Player
     * @param w - the width of Player
     * @param Name - the name of Player
     * @param Lives - the no. of lives of Player
     */ 
    public Player(int x, int y, int h, int w, String Name, int Lives){
        System.out.println("Player: New Player Created");
	this.x = x;
	this.y = y;
	Pwidth = w;
	Pheight = h;
	playName = Name;
        lives = Lives;
	this.startLives = lives;
        this.LALCount = 0;
        killShot = 0;
        shotsFired = 0;
        levelNo = "Lv";
        livesNo = "L";
        
	this.P1rect = new Rectangle(x+4, y+21, w-7, (h/2)-10);
        power = 0;
        suit = power;
        moveSpeed = 18;
        isFiring = false;
        rapidFire = true;
        
        plivesImg = new Texture("/Sprites/SI_Player0").getImage();
        playerImg = new Texture("/Sprites/SI_Player0").getImage();
        
        playerCannonImga = new Texture("/Sprites/SI_Player5Ta").getImage();
        playerCannonImgb = new Texture("/Sprites/SI_Player5T").getImage();
        
        playerShieldImga = new Texture("/Sprites/SI_Player4Ta").getImage();
        playerShieldImgb = new Texture("/Sprites/SI_Player4T").getImage();
        
        playerSpeedImg = new Texture("/Sprites/SI_Player6T").getImage();
    }
    
    
    /**Public Protocol*/
    
    
    /**
     * increasePlayerLives(int i)
     * 
     * @param i
     */
    public void increasePlayerLives(int i) {
        lives += i;
    }
    
    
    /**
     * getShotsFired()
     * 
     * @return shotsFired
     */
    public static int getShotsFired() {
        return shotsFired;
    }
    
    
    /**
     * resetShotsFired()
     * 
     */
    public static void resetShotsFired() {
        shotsFired = 0;
    }
    
    /**
     * getPlayScore()
     * 
     * @return playScore
     */
    public String getPlayScore() {
        return playScore;
    }

    /**
     * setPlayScore(String playScore)
     * 
     * @param playScore
     */
    public void setPlayScore(String playScore) {
        this.playScore = playScore;
    }
    
    
    /**
     * render(Render target, Graphics2D g)
     * 
     * @param target
     * @param g
     */
    public void render(Render target, Graphics2D g){

        //Draw Player and Bounds
        if(this.isDead == false){
            //Draw Player
            g.drawImage(imgP1, (int) x, (int) y-15, Pwidth, Pheight, null);
            
            //Draw Bounds
            if(Display.showBounds){
                g.setColor(Color.yellow);
                g.drawRect(P1rect.x, P1rect.y, P1rect.width, P1rect.height);
            }
        }
        
    }
    
    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * @param game
    * @param up
    * @param down
    * @param left
    * @param right
    * @param fire
    */ 
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {

        //Load Player Lives image
        imgPLives = plivesImg;

        //Load Player image
        if(suit == 0){
            imgP1 = playerImg;
        }
        if(suit == 1){
            if(Game.gameTimer % 2 == 0){
                //p1 with cannons
                imgP1 = playerCannonImga;
            }else{
                //p1 with cannons
                imgP1 = playerCannonImgb;
            }
        }
        if(suit == 2){
            if(Game.gameTimer % 2 == 0){
                //p1 with Sheild
                imgP1 = playerShieldImga;
            } else {
                imgP1 = playerShieldImgb;
            }
        }
        if(suit == 3){
            //p1 with Speed
            imgP1 = playerSpeedImg;
        }
        
	if (left) {
            if(x > 0){
		x -= moveSpeed;
		P1rect.x -= moveSpeed;
            }
	}
	if (right) {
            if(x < 516){
		x += moveSpeed;
		P1rect.x += moveSpeed;
            }
	}
        if (mouseLeft) {
           if(x > 0){
		StarzX -= Game.MouseSpeed*1.6;
            }
	}
	if (mouseRight) {
            if(x < 516){
		StarzX += Game.MouseSpeed*1.6;
            }
	}
	if (fire) {
            if(game.menu == null && !game.stateManager.currentState.getName().equals("menu")){
                if(isFiring == false || rapidFire == true){
                    P1Bullet.FireP1(this);
                    isFiring = true;
                    shotsFired++;
                }
            }
	}
        if (mouseFire) {
            if(game.menu == null && !game.stateManager.currentState.getName().equals("menu")){
                if(isFiring == false || rapidFire == true){
                    P1Bullet.FireP1(this);
                    isFiring = true;
                    fire = false;
                    shotsFired++;
                }
            }
	}

        lives = Player.getPLives();
    }
		
    
    
    /**
    * loseALife()
    * 
    * Checks if LALCount is less than 1 then 
    * checks if live is greater than or equal 
    * to 1. As the checks pass lives is 
    * decremented by 1 and a P1Explode is 
    * fired via the P1Explode.P1Detonate(this) 
    * message.
    * 
    */
    public void loseALife(){
	if(LALCount < 1){
            if(lives >= 1){
		lives--;
		P1Explode.P1Detonate(this);
                        
                //play sound
                if(Game.getGameSound()){
                    Sound.P1Exp.play();
                }
            }
	}
        
        setPOW(0);
    }
	
    
    /**
     * dead()
     * 
     * sets game.lose() to this Player 
     * via the message game.lose(this)
     * 
     * GAME OVER!!
     */        
    public void dead(){
        System.out.println("GAME OVER!!!");
        setPLives(0);
        Game.getGame().lose();
    }
	
    
    /**
     * P1Hit()
     * 
     * sends loseAlife() message and increases LALCount 
     * by 1 if LALCount is less than 3 else its sets LALCount to 0
     * 
     */
    public void P1Hit(){
        if(suit == 2){
            suit = 0;
            Sound.shieldDown.play();
        } else {
            loseALife();
            if(LALCount < startLives){
                LALCount += 1;
            } else { 
                LALCount = 0;
            }	
        }
    }

    
    /**
    * extraLife()
    * 
    * Checks if LALCount is less than 1 then 
    * checks if live is greater than or equal 
    * to 1. As the checks pass lives is 
    * decremented by 1 and a P1Explode is 
    * fired via the P1Explode.P1Detonate(this) 
    * message.
    * 
    */
    public void extraLife(){
	lives++;
	
        setPOW(getPOW());
    }
    
    
    /**
    * setName(String nam)
    * 
    * @param nam
    */
    public void setName(String nam){
        name = nam;
    }
    
    
    /**
    * setPLives(int i)
    * 
    * @param i
    */
    public static void setPLives(int i) {
        lives = i;
    }
    
    
    /**
    * getPLives()
    * 
    * @return lives
    */
    public static int getPLives() {
        return lives;
    }
    
    
    /**
    * setPOW(int i)
    * 
    * @param i
    */
    public static void setPOW(int i) {
        if(power < 4){
            power = i;
        } else {
            power = 0;
            if(getPLives() < 3){
                Game.increaseGameLives(1);
            }
        }
        suit = power;
        if(suit == 3){
            moveSpeed = 26;
        } else {
            moveSpeed = 17;
        }
    }
    
    
    /**
    * getPOW()
    * 
    * @return power
    */
    public static int getPOW() {
        return power;
    }
    
    
}

