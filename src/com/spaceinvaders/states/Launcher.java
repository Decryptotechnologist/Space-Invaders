package com.spaceinvaders.states;

import com.spaceinvaders.graphics.Texture;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import com.spaceinvaders.input.*;
import com.spaceinvaders.pkg2018.*;


/**
 * Launcher objects represent . . .
 * 
 * @author(s), The Cherno, Ghomez
 */
public final class Launcher extends Canvas implements Runnable {

    /**Attributes*/
    
    /**serialVersionUID variable of Launcher object*/ 
    private static final long serialVersionUID = 1L;

    /**launcherWidth variable of Launcher object*/ 
    private final int launcherWidth = 800;
    
    /**launcherHeight variable of Launcher object*/ 
    private final int launcherHeight = 400;
    
    /**button_width variable of Launcher object*/ 
    protected int button_width = 80;
    
    /**button_height variable of Launcher object*/ 
    protected int button_height = 40;

    /**running boolean of Launcher object*/ 
    private boolean running = false;
    
    /**thread Thread of Launcher object*/ 
    private Thread thread;

    /**window JPanel of Launcher object*/ 
    protected JPanel window = new JPanel();
    
    /**play JButton of Launcher object*/ 
    private JButton play;

    /**options JButton of Launcher object*/ 
    private JButton options;
    
    /**help JButton of Launcher object*/ 
    private JButton help;
    
    /**quit JButton of Launcher object*/ 
    private JButton quit;
    
    /**rplay Rectangle of Launcher object*/ 
    private Rectangle rplay;
    
    /**roptions Rectangle of Launcher object*/ 
    private Rectangle roptions;
    
    /**rhelp Rectangle of Launcher object*/ 
    private Rectangle rhelp;
    
    /**rquit Rectangle of Launcher object*/ 
    private Rectangle rquit;
    
    /**Lframe JFrame of Launcher object*/ 
    private final JFrame Lframe = new JFrame();

    /**LauncherBG BufferedImage of Launcher object*/
    private final BufferedImage LauncherBG;
    
    /**playOffBtn BufferedImage of Launcher object*/
    private final BufferedImage playOffBtn;
    
    /**playOnBtn BufferedImage of Launcher object*/
    private final BufferedImage playOnBtn;
    
    /**optionsOffBtn BufferedImage of Launcher object*/
    private final BufferedImage optionsOffBtn;
    
    /**optionsOnBtn BufferedImage of Launcher object*/
    private final BufferedImage optionsOnBtn;
    
    /**helpOffBtn BufferedImage of Launcher object*/
    private final BufferedImage helpOffBtn;
    
    /**helpOnBtn BufferedImage of Launcher object*/
    private final BufferedImage helpOnBtn;
    
    /**quitOffBtn BufferedImage of Launcher object*/
    private final BufferedImage quitOffBtn;
    
    /**quitOnBtn BufferedImage of Launcher object*/
    private final BufferedImage quitOnBtn;
    
    /**aboutOffBtn BufferedImage of Launcher object*/
    private final BufferedImage aboutOffBtn;
    
    /**aboutOnBtn BufferedImage of Launcher object*/
    private final BufferedImage aboutOnBtn;
    
    /**leftArrowIcon BufferedImage of Launcher object*/
    private final BufferedImage leftArrowIcon;
    
    /**rightArrowIcon BufferedImage of Launcher object*/
    private final BufferedImage rightArrowIcon;
    
    /**bs variable of Launcher object*/
    private BufferStrategy bs;
    
    /**input KeyInput of Launcher object*/
    private final KeyInput input;
    
    /**mouseInput MouseInput of Launcher object*/
    private final MouseInput mouseInput;
    
    
    /**Constructor*/
    
    
    /**
    * Launcher(int id)
    * 
    * Initialises a new Launcher object with a this.x set to x,
    * this.y set to y, this.isDead set to isDead, 
    * this.height set to h, this.width set to w, this.visible 
    * set to vis
    * 
    * @param id the height of Render
    */       
    public Launcher(int id) {
        System.out.println("Launcher: New Launcher Created");
        
        //Setup Launcher: Background Image
        LauncherBG = new Texture("/menu/SI2018-MENUA").getImage();
        
        //Setup Launcher: Button Images
        playOffBtn = new Texture("/menu/play_off1").getImage();
        playOnBtn = new Texture("/menu/play_on1").getImage();
        optionsOffBtn = new Texture("/menu/options_off1").getImage();
        optionsOnBtn = new Texture("/menu/options_on1").getImage();
        helpOffBtn = new Texture("/menu/help_off1").getImage();
        helpOnBtn = new Texture("/menu/help_on1").getImage();
        quitOffBtn = new Texture("/menu/quit_off1").getImage();
        quitOnBtn = new Texture("/menu/quit_on1").getImage();
        aboutOffBtn = new Texture("/menu/about_off1").getImage();
        aboutOnBtn = new Texture("/menu/about_on1").getImage();

        //Setup Launcher: Arrow Images
        leftArrowIcon = new Texture("/menu/arrow1").getImage();//ImageIO.read(getClass().getResource("/menu/arrow1.png"));
        rightArrowIcon = new Texture("/menu/arrow1R").getImage();//ImageIO.read(getClass().getResource("/menu/arrow1R.png"));
       
            
        Lframe.setUndecorated(true);
        Lframe.setTitle(Game.TITLE);
        Lframe.setSize(new Dimension(launcherWidth, launcherHeight));
        Lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lframe.setOpacity(0.95f);
        Lframe.add(this);
        Lframe.setLocationRelativeTo(null);
        Lframe.setResizable(false);
        Lframe.setVisible(true);
        window.setLayout(null);
        if (id == 0) {
            drawButtons();
        }
        
        input = new KeyInput();
        addKeyListener(input);
        mouseInput = new MouseInput();
        addFocusListener(input);
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
        startMenu();
        Lframe.repaint();
    }

    
    /**
    * renderMenu()
    * 
    */
    private void renderMenu() {
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

        //Draw Background
        g.drawImage(LauncherBG, 0, 0, 800, 400, null);
            
        //Draw Play Button
        if (MouseInput.MouseX > 690 && MouseInput.MouseX < 690 + 80 && MouseInput.MouseY > 90 && MouseInput.MouseY < 90 + 30) {
            g.drawImage(playOffBtn, 690, 90, 80, 30, null);

            //Draw Play Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g.drawImage(leftArrowIcon, 690 + 80, 94, 22, 20, null);
                g.drawImage(rightArrowIcon, 690 - 25, 95, 22, 20, null);
            }

            //Set Play Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                //Sound.Menu2.stop();
                Sound.btnPushed.play();

                Lframe.dispose();
                System.out.println("Launcher: Play Selected");
                Display.display = new Display();
                this.stopMenu();

                //config.loadConfiguration("res/sys/config.xml");
            }
        } else {
            g.drawImage(playOnBtn, 690, 90, 80, 30, null);
        }

        //Draw Options Button
        if (MouseInput.MouseX > 641 && MouseInput.MouseX < 641 + 130 && MouseInput.MouseY > 130 && MouseInput.MouseY < 130 + 30) {
            g.drawImage(optionsOffBtn, 641, 130, 130, 30, null);

            //Draw Options Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g.drawImage(leftArrowIcon, 690 + 80, 134, 22, 20, null);
                g.drawImage(rightArrowIcon, 690 - 75, 136, 22, 20, null);
            }

            //Set Options Button Click Logic
            if (MouseInput.MouseButton == 1) {
                //Sound.Menu2.stop();
                Sound.stopAll();
                Sound.btnPushed.play();
                Lframe.dispose();
                System.out.println("Launcher: Options Selected");

                Display.display = new Display();
                Display.optionsOn = true;

                this.stopMenu();
            }
        } else {
            g.drawImage(optionsOnBtn, 641, 130, 130, 30, null);
        }

        //Draw Help Button
        if (MouseInput.MouseX > 690 && MouseInput.MouseX < 690 + 80 && MouseInput.MouseY > 170 && MouseInput.MouseY < 170 + 30) {
            g.drawImage(helpOffBtn, 690, 170, 80, 30, null);

            //Draw Help Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g.drawImage(leftArrowIcon, 690 + 80, 174, 22, 20, null);
                g.drawImage(rightArrowIcon, 690 - 25, 174, 22, 20, null);
            }

            //Set Help Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();

                Lframe.dispose();
                System.out.println("Launcher: Help Selected");

                Display.display = new Display();
                Display.instructionsOn = true;

                this.stopMenu();

            }
        } else {
            g.drawImage(helpOnBtn, 690, 170, 80, 30, null);
        }

        //Draw Quit Button
        if (MouseInput.MouseX > 690 && MouseInput.MouseX < 690 + 80 && MouseInput.MouseY > 210 && MouseInput.MouseY < 210 + 30) {
            g.drawImage(quitOffBtn, 690, 210, 80, 30, null);

            //Draw Quit Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g.drawImage(leftArrowIcon, 690 + 80, 214, 22, 20, null);
                g.drawImage(rightArrowIcon, 690 - 28, 214, 22, 20, null);
            }

            //Set Quit Button Click Logic
            if (MouseInput.MouseButton == 1) {
                quitGame();
            }
        } else {
            g.drawImage(quitOnBtn, 690, 210, 80, 30, null);
        }

        //Draw About Button
        if (MouseInput.MouseX > 690 && MouseInput.MouseX < 690 + 80 && MouseInput.MouseY > 290 && MouseInput.MouseY < 290 + 30) {
            g.drawImage(aboutOffBtn, 690, 290, 80, 30, null);

            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g.drawImage(leftArrowIcon, 690 + 80, 294, 22, 20, null);
                g.drawImage(rightArrowIcon, 690 - 28, 294, 22, 20, null);
            }

            if (MouseInput.MouseButton == 1) {
                //Sound.Menu2.stop();
                Sound.stopAll();
                Sound.btnPushed.play();

                Lframe.dispose();
                System.out.println("About");
                Display.display = new Display();
                Display.aboutOn = true;

                this.stopMenu();

            }

        } else {
            g.drawImage(aboutOnBtn, 690, 290, 80, 30, null);
        }
            
        //Draw Version
        g.drawString(Game.version, 620, 386);

        g.dispose();
        bs.show();
    }

    
    /**
    * drawButtons()
    * 
    */
    private void drawButtons() {
        play = new JButton("Play!");
        rplay = new Rectangle((launcherWidth / 2) - (button_width / 2), 90, button_width, button_height);
        play.setBounds(rplay);
        window.add(play);

        options = new JButton("Options");
        roptions = new Rectangle((launcherWidth / 2) - (button_width / 2), 140, button_width, button_height);
        options.setBounds(roptions);
        window.add(options);

        help = new JButton("Help");
        rhelp = new Rectangle((launcherWidth / 2) - (button_width / 2), 190, button_width, button_height);
        help.setBounds(rhelp);
        window.add(help);

        quit = new JButton("Quit");
        rquit = new Rectangle((launcherWidth / 2) - (button_width / 2), 240, button_width, button_height);
        quit.setBounds(rquit);
        window.add(quit);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
                quitGame();
            }
        });
    }
    
    
    /**
    * updateFrame()
    * 
    */
    public void updateFrame() {
        if (MouseInput.dragged) {
            Point p = Lframe.getLocation();
            Lframe.setLocation(p.x + MouseInput.MouseDX - MouseInput.MousePX, p.y + MouseInput.MouseDY - MouseInput.MousePY);
        }
    }

    
    /**
    * startMenu()
    * 
    */
    public void startMenu() {
        running = true;
        thread = new Thread(this, "launcher");
        thread.start();
        Sound.Launcher.loop();
    }

    
    /**
    * stopMenu()
    * 
    * @return running
    */
    public boolean stopMenu() {
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
        
        return running;
    }

    
    /**
    * run()
    * 
    */
    @Override
    public void run() {
        requestFocus();
        while (running) {
            try {
                renderMenu();
            } catch (IllegalStateException e) {
                System.out.println("Handled!!");
            }
            updateFrame();
        }
    }
    
    
    /**
    * quitGame()
    * 
    */
    private void quitGame() {
        
        JFrame parent = new JFrame();
        int dialog = JOptionPane.showConfirmDialog(parent, "Are You Sure You Want To Quit?", "Quit To Desktop", JOptionPane.YES_NO_OPTION);
        
        if(dialog == 0){
            //Sound.Menu2.stop();
            Sound.stopAll();
            Sound.sound5.play();

            Lframe.dispose();
            System.out.println("Launcher: Quit Selected");

            System.exit(0);
        }

    }

    
}