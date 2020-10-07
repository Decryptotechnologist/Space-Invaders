/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.pkg2018;

import com.spaceinvaders.level.Level;
import com.spaceinvaders.bullets.Bullet;
import com.spaceinvaders.enemies.*;
import com.spaceinvaders.explodes.Explode;
import com.spaceinvaders.graphics.*;
import com.spaceinvaders.input.*;
import com.spaceinvaders.level.HUD;
import com.spaceinvaders.menu.*;
import com.spaceinvaders.states.*;
import com.spaceinvaders.menu.Menu;
import com.spaceinvaders.player.Player;
import com.spaceinvaders.player.PlayerStats;
import com.spaceinvaders.powerup.POW;
import com.spaceinvaders.utils.Util;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Ghomez
 */
public class Game extends Canvas implements Runnable {

    /**Attributes*/                                      
    
    /**TITLE variable of Game object*/
    public static String TITLE = "Space Invaders 2018 v5.4 - Developer Alpha Edition VIII";
    
    /**version variable of Game object*/
    public static String version = "Developer Alpha Edition VIII v5.4";
    
    /**gameWidth variable of Game object*/
    public static int gameWidth = 604;
    
    /**gameHeight variable of Game object*/
    public static int gameHeight = 720;
    
    /**showFPS boolean of Game object*/
    public static boolean showFPS = true;
    
    /**showUPS boolean of Game object*/
    public static boolean showUPS;
    
    /**MouseSpeed variable of Game object*/
    public static double MouseSpeed;
    
    /**mainDiff variable of Game object*/
    private static int mainDiff = 1;
    
    /**mainConMouse boolean of Game object*/
    private static boolean mainConMouse;
    
    /**mainConKeys boolean of Game object*/
    private static boolean mainConKeys;
    
    /**mainSndOn boolean of Game object*/
    private static boolean mainSndOn = true;
    
    /**PlayerN variable of Game object*/
    public static String PlayerN;
    
    /**currentControl variable of Game object*/
    private static String currentControl;
    
    /**showGameTime boolean of Game object*/
    public static boolean showGameTime = true;
    public static HUD hud;
    public static PlayerStats gameStats;
    public static boolean showLevelTime = true;

    public boolean getPauseKey() {
        return input.keys[KeyEvent.VK_ESCAPE];
    }
    
    /**running boolean of Game object*/
    private boolean running = false;

    /**frames variable of Game object*/
    private int frames;
    
    /**gameScore variable of Game object*/
    public static int gameScore;
    
    /**gameTimer variable of Game object*/
    public static int gameTimer;
    
    /**fps variable of Game object*/
    private int fps;
    
    /**ups variable of Game object*/
    private int ups;
    
    /**thefps variable of Game object*/
    public static String thefps;
    
    /**theUps variable of Game object*/
    public static String theUps;
    
    /**theGameTime variable of Game object*/
    public static String theGameTime;
    
    /**bs variable of Game object*/
    private BufferStrategy bs;
    
    /**thread Thread of Game object*/
    private Thread thread;
    
    /**time variable of Game object*/
    public static double time;
    
    /**gameSndOn boolean of Game object*/
    public boolean gameSndOn;
    
    /**img variable of Game object*/
    private final BufferedImage img;
    
    /**newX variable of Game object*/
    public int[] pixels;

    /**level no. variable of Game object*/
    public static int levelNo;
        
    /**pauseTime variable of Game object*/
    public static int pauseTime = 150;
        
    /**Paused boolean of Game object*/
    public static boolean Paused;
    
    /**score variable of Game object*/
    public static int score;
    
    /**diff variable of Game object*/
    public int diff;
    
    /**tickDelayA variable of Game object*/
    private int tickDelayA = 110;
    
    /**tickDelayB variable of Game object*/
    private int tickDelayB = 110;
    
    /**hadFocus boolean of Game object*/
    public boolean hadFocus;
    
    /**newX coordinate of Game object*/
    private int newX = 0;
    
    /**oldX coordinate of Game object*/
    private int oldX = 0;
    
    /**EmptyCursor variable of Game object*/
    private Cursor emptyCursor;
    
    /**DefaultCursor variable of Game object*/
    private Cursor defaultCursor;
    
    /**mainMusicOn boolean of Game object*/
    public boolean mainMusicOn = true;
    
    /**showSpace boolean of Game object*/
    public boolean showSpace = false;
    
    /**showStars boolean of Game object*/
    public boolean showStars = true;
    
    /**currentStatus variable of Game object*/
    private String currentStatus;
    
    
    
    /**Links*/
    
    /**aGame Game of Game object*/
    public static Game aGame;
    
    /**screen Screen of Game object*/
    private Screen screen;
    
    /**stateManager StateManager of Game object*/
    public StateManager stateManager;
    
    /**menu Menu of Game object*/
    public Menu menu;
    
    /**labels Labels of Game object*/
    public static Labels labels;
    
    /**input KeyInput of Game object*/
    private final KeyInput input;
    
    /**mouseInput MouseInput of Game object*/
    private final MouseInput mouseInput;
    
    /**player Player of Game object*/
    public static Player player;
    
    /**bullets Bullet of Game object*/
    public static Bullet bullets;
    
    /**explodes Explode of Game object*/
    public static Explode explodes;
    
    /**enemies Enemy of Game object*/
    public static Enemy enemies;
    
    /**pows POW of Game object*/
    public static POW pows;
    
    /**level Level of Game object*/
    public static Level level;
    
    /**levelTime variable of Game object*/
    public static int levelTime;
    
    /**shotsFired variable of Game object*/
    private int shotsFired;
    
    /**enemizHit variable of Game object*/
    private int enemizHit;
    
    /**timeBonus variable of Game object*/
    public static int timeBonus;
    
    /**accuracyBonus variable of Game object*/
    public static int accuracyBonus;
    
    /**levelBonus variable of Game object*/
    public static int levelBonus;
    
    /**livesBonus variable of Game object*/
    public static int livesBonus;
    
    /**textCount variable of Game object*/
    public static int textCount = 0;
    
    /**renderCount variable of Game object*/
    public static int renderCount = 0;
    
    /**startLevel variable of Game object*/
    public static int startLevel = 1;
    private boolean isX64;
    private boolean isSuperFast;
    
    
    
    /**Constructor*/
    
    
    /**
    * Game()
    * 
    * Creates a new Game object
    */ 
    public Game() {
        System.out.println("Game: New Game Created");
        //config.loadConfiguration("res/sys/config.xml");
        
        //Create Keys and Mouse Input
        input = new KeyInput();
        mouseInput = new MouseInput();
        
        //Set Keys and Mouse
        addKeyListener(input);
        addFocusListener(input);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        
        //If screen null create new screen : gameWidth, gameHeight args
        if(screen == null){
            screen = new Screen(gameWidth, gameHeight);
        }
        aGame = this;
	img = new BufferedImage(gameWidth, gameHeight, BufferedImage.TYPE_INT_RGB);
	pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
        
        //Set Game Sound
        this.gameSndOn = Game.getGameSound();
        
        gameTimer = 0;
        resetScore();
        resetGameTime();
        Paused = false;
        
        init();

    }
    
    
    /**Public Protocol*/
    
    
    /**
    * init()
    * 
    * Initialises a new Game object
    */ 
    private void init(){
        System.out.println("Game: Initiating Game. . .");
        
        isX64 = Util.getOSARC().equals("X64");
        if(isX64){
            System.out.println("Game: 64 Bit Enabled");
            showSpace = true;
        }
        isSuperFast = Runtime.getRuntime().availableProcessors() > 2 || Util.isMac();
        if(isSuperFast){
            System.out.println("Game: Super fast environment Enabled");
            showSpace = true;
        }
        
        
        stateManager = new StateManager();
        stateManager.addState(new MenuState());
        stateManager.addState(new GameState());
        gameStats = new PlayerStats();
        
        requestFocus();
        start();

        if(level == null){
            levelNo = startLevel;
            level = new Level(levelNo);
        }
        
    }

    
    /**
    * start()
    * 
    */ 
    public void start() {
        System.out.println("Starting Game . . .");
        if(running) return;
        
        running = true;
        thread = new Thread(this, "Game-Thread");
        thread.start();
    }
    

    /**
    * stop()
    * 
    */
    public void stop() {
        System.out.println("Stopping Game . . .");
        if(!running) return;
        
        running = false;
        System.exit(0);
    }
    
    
    /**
    * run()
    * 
    */
    @Override
    public void run() {
        System.out.println("Running Game . . .");
        double ns;
        long previousTime = System.nanoTime();
        if(isX64 || isSuperFast){
            ns = 1000000000.0 / 30;
        } else {
            ns = 1000000000.0 / 60;
        }
	double delta = 0;
	frames = 0;
	int updates = 0;
	long timer = System.currentTimeMillis();

        while(running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / ns;
            previousTime = currentTime;
			
            if (delta >= 1) {
		tick();
		updates++;
		delta--;				
            }
			
            while(System.currentTimeMillis() - timer > 1000){
		timer += 1000;
		gameTimer += 1;
                levelTime++;
                Game.gameScore = score;
                
//                if(isX64 || isSuperFast){
//                    fps = frames/2;
//                    ups = updates/2;
//                } else {
                fps = frames;
                ups = updates;
                //}
                thefps = fps+"FPS";//"FPS:"+fps;
                theUps = ups+"UPS";//"UPS:"+ups;
                theGameTime = "GameTime:"+gameTimer;
			
                Level.theLevelTime = "Level Time:"+levelTime;
		frames = 0;
		updates = 0;
            }
            render();
            frames++;	
            setScore(score);
            
            if(isX64 || isSuperFast){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
	}
    }
    
    
    /**
    * getGameTime()
    * 
    * @return running
    */
    public int getGameTime() {
        return gameTimer;
    }
    
    
    /**
    * resetGameTime()
    * 
    */
    public static void resetGameTime() {
        gameTimer = 0;
    }
    
    
    /**
     * getStartLevel()
     * 
     * @return startLevel
     */
    public static int getStartLevel() {
        return startLevel;
    }

    
    /**
     * setStartLevel(int startLevel)
     * 
     * @param startLevel
     */
    public static void setStartLevel(int startLevel) {
        Game.startLevel = startLevel;
    }
    
    
    /**
    * isRunning()
    * 
    * @return running
    */
    public boolean isRunning() {
        return running;
    }
    
    
    /**
    * tick()
    * 
    */
    private void tick() {
        if (pauseTime > 0 && (this.menu == null && !this.stateManager.currentState.getName().equals("menu")) || 
                stateManager.currentState.getName().equals("Credits")) {
		pauseTime --; 
		return;
	}
	time++;
        
        if(hasFocus()) {
            input.tick(this, this.menu, this.player);

            if(this.menu == null){
		if (tickDelayA > 0) tickDelayA--;
                    if (tickDelayB > 0 && tickDelayA < 100) tickDelayB--;
            } else {
                hadFocus = true;
		tickDelayA = 110;
		tickDelayB = 110;
            }
			
            newX = MouseInput.MouseX;
            //newY = InputHandler.MouseY;
            if (MouseInput.MouseButton == 1) {
                Player.mouseFire = true;
            }
            if (MouseInput.MouseButton != 1) {
                Player.mouseFire = false;
            }
            if (newX > oldX) {
		Player.mouseRight = true;
            }
            if (newX < oldX) {
		Player.mouseLeft = true;
            }
            if (newX == oldX) {
		Player.mouseLeft = false;
		Player.mouseRight = false;
            }
            MouseSpeed = Math.abs(newX - oldX);
            oldX = newX;
	}
        
        stateManager.tick();
        
        if (pauseTime == 0 && Level.levelComplete){
            win();
        }
        
    }

    
    /**
    * render()
    * 
    * Renders/Repaints Game Objects
    */
    private void render() {
        if(this.menu == null){// && !stateManager.currentState.getName().equals("Credits")){
            if (hadFocus != hasFocus()) {
                hadFocus = !hadFocus;
                setCursor(hadFocus ? emptyCursor : defaultCursor);
                if(!hadFocus && this.menu == null){
                    if(getGameSound()){
                        Sound.Focus.loop();
                    }
                } else {
                    Sound.Focus.stop();
                }
            }
        }
         
            
        bs = getBufferStrategy();
	if (bs == null) {
            try{
                createBufferStrategy(3);
                return;
            } catch(Exception e){
                return;
            }
	}
        Graphics g = bs.getDrawGraphics();
        
        Graphics2D g2d = (Graphics2D) g;
        //if(!Util.isUnix()){
            //g2d.translate(-6, -28);
        //}
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ///////////////////////////////////////////////
        
        if(this.menu == null){
            stateManager.render(g2d);
        }
        
        if(!stateManager.currentState.getName().equals("menu")){
            
            g2d.drawImage(img, 0, 0, gameWidth, gameHeight, null);
            screen.render(this, hasFocus(), g2d);
            
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = screen.pixels[i];
            }     
        }
        
        //////////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    
    /**
    * getGameWidth()
    * 
    * @return gameWidth 
    */
    public static int getGameWidth() {
        if(gameWidth < 604){
            gameWidth = 604;
        }
        return gameWidth;
    }
    
    
    /**
    * getGameHeight()
    * 
    * @return gameHeight 
    */
    public static int getGameHeight() {
        if(gameHeight < 720){
            gameHeight = 720;
        }
        return gameHeight;
    }

    
    /**
    * setGameWidth()
    * 
    * @param w
    */
    public static void setGameWidth(int w) {
        if(w < 604){
            w = 604;
        }
        gameWidth = w;
    }
    
    
    /**
    * setGameHeight()
    * 
    * @param h
    */
    public static void setGameHeight(int h) {
        if(h < 720){
            h = 720;
        }
        gameHeight = h;
    }
    
    
    /**
    * getGame()
    * 
    * @return aGame
    */
    public static Game getGame() {
        return aGame;
    }

    
    /**
    * setStart()
    * 
    */
    public void setStart() {
        stateManager.setState("Level 1");
        setMenu(new StartMenu(this));
        System.out.println("Game: Start Menu Set");
    }
    
    
    /**
    * setAbout()
    * 
    */
    public void setAbout() {
        stateManager.setState("Level 1");
        setMenu(new AboutMenu(this));
        System.out.println("Game: About Menu Set");
    }
    
    
    /**
    * setInstructions()
    * 
    */
    public void setInstructions() {
        stateManager.setState("Level 1");
        setMenu(new InstructionsMenu(this));
        System.out.println("Game: Help Menu Set");
    }
    
    
    /**
    * setCredits()
    * 
    */
    public void setCredits() {
        //stateManager.setState("Level 1");
        stateManager.setState("Credits");
        setMenu(new CreditsMenu(this));
        System.out.println("Game: Credits Menu Set");
    }
    
    
    /**
    * setOptions()
    * 
    */
    public void setOptions() {
        stateManager.setState("Level 1");
        setMenu(new OptionsMenu(this));
        System.out.println("Game: Options Menu Set");
    }
    
    
    /**
    * setHiScore()
    * 
    */
    public void setHiScore() {
        stateManager.setState("Level 1");
        setMenu(new HiScoreMenu(this));
        System.out.println("Game: HiScore Menu Set");
    }
    
    
    /**
    * setKeys()
    * 
    */
    public void setKeys() {
        stateManager.setState("Level 1");
        setMenu(new KeysMenu(this));
        System.out.println("Game: Keys Menu Set");
    }

    
    /**
    * setMenu(Menu menu)
    * 
    * Sets a Menu object to a Game object
    * 
    * @param menu
    */ 
    public void setMenu(Menu menu) {
	this.menu = menu;
    }

    
    /**
    * getMenu()
    * 
    * Sets a Menu object to a Game object
    * 
    * @return menu
    */ 
    public Menu getMenu() {
	return this.menu;
    }
    
    
    /**
    * getPName()
    * 
    * @return PlayerN
    */
    public static String getPName() {
        if(PlayerN == null){
            if(Util.getUserNAME() == null){
                setPlayerName("Player 1");
            } else {
                if(Util.getUserNAME().length() > 8){
                    setPlayerName(Util.getUserNAME().substring(0, 8));
                }else{
                    setPlayerName(Util.getUserNAME());
                }
            }
        }
    	return PlayerN;
    }
    
    
    /**
    * setPlayerName(String name)
    * 
    * @param name
    */
    public static void setPlayerName(String name) {
        PlayerN = name;
    }

    
    /**
    * lose()
    * 
    */
    public void lose() {
        System.out.println("Lose Game");
        if(Player.getPLives() == 0){
            levelNo = 1;
            Level.setLevelNo(levelNo);
            setMenu(new LoseMenu(this));
        }
    }
    
    
    /**
    * win()
    * 
    */
    public void win() {
        //Record Game Time and Player Accuracy and determine Bonus'
        levelTime = getGameTime();
        shotsFired = Player.getShotsFired();
        enemizHit = Enemy.getEnemiesHit();

        System.out.println("Level Time: "+levelTime+" Shots Fired: "+shotsFired+" Enemies Hit: "+enemizHit);

        if(levelTime < 50){
            livesBonus = 300;
            timeBonus = 1000;
            accuracyBonus = 30;
        } else if(levelTime > 50 && levelTime < 150){
            livesBonus = 200;
            timeBonus = 500;
            accuracyBonus = 20;
        } else {
            livesBonus = 100;
            timeBonus = 350;
            accuracyBonus = 10;
        }

        livesBonus *= Player.getPLives();
        accuracyBonus *= (double) (shotsFired / enemizHit);
        levelBonus = timeBonus + levelTime / 100;
        levelBonus *= accuracyBonus + Player.getPLives() * Enemy.barStrength;
        levelBonus = levelBonus / 100;
        levelBonus = levelBonus + timeBonus + accuracyBonus;
        
        
        System.out.println("Level Bonus: "+levelBonus+" Time Bonus: "+timeBonus+" Accuracy Bonus: "+accuracyBonus);
        
        Display.setStatusBar("Time Bonus: "+timeBonus+" Accuracy Bonus: "+accuracyBonus+" Level Bonus: "+levelBonus);
        
        if(levelNo+1 < 9){//Game Levels Limit : Currently set to 8
            System.out.println("Level "+levelNo+" Complete!");
            setScore(getScore() + levelBonus);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            
            levelNo += 1;
            level = new Level(levelNo);
            Level.levelComplete = false;
            pauseTime = 150;
            
            Player.resetShotsFired();
            Enemy.resetEnemiesHit();
            
            Display.setStatusBar("Loading Level "+levelNo+" : "+level.getLevelName());
        } else {
            Display.setStatusBar("Game Complete!");
            level = new Level(9);
            Level.levelComplete = false;
            pauseTime = 150;
            
            //Show Credits . . .
            setCredits();
        }
    }
    
    
    /**
    * getTimeBonus()
    * 
    * @return timeBonus
    */
    public static int getTimeBonus(){       
        return gameStats.getTimeBonus();
    }
    
    
    /**
    * getAccuracyBonus()
    * 
    * @return accuracyBonus
    */
    public static int getAccuracyBonus(){       
        return gameStats.getAccuracyBonus();
    }
    
    
    /**
    * getLevelBonus()
    * 
    * @return levelBonus
    */
    public static int getLevelBonus(){       
        return gameStats.getLevelBonus();
    }

    
    /**
    * getLivesBonus()
    * 
    * @return livesBonus
    */
    public static int getLivesBonus() {
        return gameStats.getLivesBonus();
    }
    
    
    /**
    * getGameSound()
    * 
    * @return mainSndOn
    */
    public static boolean getGameSound(){       
        return mainSndOn;
    }
    
    
    /**
    * setGameSound(boolean sndOn)
    * 
    * @param sndOn
    */
    public static void setGameSound(boolean sndOn) {
        mainSndOn = sndOn;
    }

    
    /**
    * setGameControl(boolean keysOn)
    * 
    * @param keysOn
    */
    public static void setGameControl(boolean keysOn) {
        mainConKeys = keysOn;
        mainConMouse = !keysOn;
        if(keysOn){
            currentControl = "Keys";
        } else {
            currentControl = "Mouse";
        }
    }

    
    /**
    * getGameControl()
    * 
    * @return currentControl
    */
    public static String getGameControl() {
        return currentControl;
    }
    
    
    /**
    * setGameDifficulty(int difficulty)
    * 
    * @param difficulty
    */
    public static void setGameDifficulty(int difficulty) {
        mainDiff = difficulty;
    }
    
    
    /**
    * getGameDifficulty()
    * 
    * @return mainDiff
    */
    public static int getGameDifficulty() {
        return mainDiff;
    }

    
    /**
    * setGameLives(int i)
    * 
    * @param i
    */
    public static void setGameLives(int i) {
        Player.setPLives(i);
    }
    
    
    /**
    * increaseGameLives(int i)
    * 
    * @param i
    */
    public static void increaseGameLives(int i) {
        aGame.player.increasePlayerLives(i);
    }
    
    
    /**
    * increaseScore(int i)
    * 
    * @param i
    */
    public static void increaseScore(int i) {
        score += i;
    }
    
    
    /**
    * increaseScore(Enemy e)
    * 
    * @param e
    */
    public static void increaseScore(Enemy e) {
        if(e instanceof Enemy0){
            increaseScore(50);
        } else if(e instanceof Enemy1){
            increaseScore(50);
        } else if(e instanceof Enemy2){
            increaseScore(30);
        } else if(e instanceof Enemy3){
            increaseScore(30);
        } else if(e instanceof Enemy4){
            increaseScore(30);
        } else if(e instanceof Enemy5){
            increaseScore(25);
        } else if(e instanceof Enemy6){
            increaseScore(25);
        } else if(e instanceof Enemy7){
            increaseScore(25);
        } else if(e instanceof Enemy8){
            increaseScore(10);
        } else if(e instanceof Enemy9){
            increaseScore(10);
        } else if(e instanceof UFO){
            increaseScore(100);
        }
    }
    
    
    /**
    * resetScore()
    * 
    */
    public static void resetScore() {
        score = 0;
    }

    
    /**
    * getScore()
    * 
    * @return score
    */
    public static int getScore() {
        return score;
    }
    
    
    /**
    * setScore()
    * 
    * @param newScore
    */
    public static void setScore(int newScore) {
        score = newScore;
    }
    
    
    /**
    * setGameMusic(boolean musicOn)
    * 
    * @param musicOn
    */
    public void setGameMusic(boolean musicOn) {
        mainMusicOn = musicOn;
    }
    

    /**
    * getGameMusic()
    * 
    * @return mainMusicOn
    */
    public boolean getGameMusic() {
        return mainMusicOn;
    }

    
    /**
    * quitGame()
    * 
    */
    public static void quitGame() {
        JFrame parent = new JFrame();
        int dialog = JOptionPane.showConfirmDialog(parent, "Are You Sure You Want To Quit?", "Quit To Desktop", JOptionPane.YES_NO_OPTION);
        
        if(dialog == 0){
            Sound.Menu3.stop();
            Sound.sound5.play();
            
            System.out.println("Game: Quit");
            System.out.println("");
            System.out.println("Quitting " + Game.TITLE + " . . . Started by " + Util.getUserNAME());
            System.out.println("Home Directory:    " + Util.getHomeDIR());
            System.out.println("Memory: Max Memory: " + Display.memoryToMB(Runtime.getRuntime().maxMemory()) + " MB");
            System.out.println("Memory: Total Memory: " + Display.memoryToMB(Runtime.getRuntime().totalMemory()) + " MB");
            System.out.println("Memory: Free Memory: " + Display.memoryToMB(Runtime.getRuntime().freeMemory()) + " MB");
            System.out.println("Memory: Used Memory: " + Display.memoryToMB(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " MB");
            System.out.println("");
            
            Game.getGame().stop();
            System.exit(0);
        } 
        if(dialog == 1){
            Display.setStatusBar("Ready");
        }
        
    }
    
    
}
