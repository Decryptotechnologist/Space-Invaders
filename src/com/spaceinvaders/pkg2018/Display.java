/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spaceinvaders.pkg2018;

import com.spaceinvaders.graphics.Texture;
import com.thehowtotutorial.splashscreen.JSplash;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import com.spaceinvaders.states.Launcher;
import com.spaceinvaders.utils.*;
import java.applet.AudioClip;
import javax.sound.sampled.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.border.*;

/**
 *
 * @author Ghomez
 */
public class Display {

    /**Attributes*/                                      
    
    /**frame JFrame of Display object*/
    private static JFrame frame;
    
    /**panel JPanel of Display object*/
    public static JPanel panel;
    
    /**instructionsOn boolean of Display object*/
    public static boolean instructionsOn;
    
    /**aboutOn boolean of Display object*/
    public static boolean aboutOn;
    
    /**optionsOn boolean of Display object*/
    public static boolean optionsOn;
    
    /**hour String of Display object*/
    public static String hour;
    
    /**currentStatus String of Display object*/
    private static String currentStatus = "Ready.";
    
    /**showHUD variable of Display object*/
    public static boolean showHUD = true;

    /**frameWidth variable of Display object*/
    private int frameWidth = 600;
    
    /**frameHeight variable of Display object*/
    private int frameHeight = 720;
    
    /**icon BufferedImage of Display object*/
    public static BufferedImage icon;
    
    /**statusbar JLabel of Display object*/
    public static JLabel statusbar;
    
    /**showBounds boolean of Display object*/
    public static boolean showBounds = false;
    
    /**showKillShot boolean of Display object*/
    public static boolean showKillShot = true;
    
    /**fonts variable of Display object*/
    public static Font[] fonts = {
        new Font("Verdana", 0, 24), 
        new Font("Verdana", 1, 10), 
        new Font("Verdana", 2, 50), 
        new Font("Verdana", 3, 12),
        new Font("Verdana", 0, 16),
        new Font("Verdana", 1, 18),
        new Font("Verdana", 0, 18),
        new Font("SanSerif", Font.BOLD, 12), 
        new Font("SanSerif", Font.BOLD, 24), 
        new Font("Ariel", Font.BOLD, 12), 
        new Font("Ariel", Font.BOLD, 24), 
        new Font("TimesRoman", Font.BOLD, 12), 
        new Font("TimesRoman", Font.BOLD, 24), 
        new Font("SanSerif", Font.BOLD, 24),
        new Font("YouMurderer BB", Font.BOLD, 22),
        new Font("YouMurderer BB", Font.BOLD, 38),
        new Font("YouMurderer BB", Font.BOLD, 46)
    };
    
    /**colours variable of Display object*/
    public static Color[] colours ={
        Color.black, 
        Color.blue, 
        Color.cyan, 
        Color.darkGray, 
        Color.gray, 
        Color.green, 
        Color.lightGray, 
        Color.magenta, 
        Color.orange, 
        Color.pink, 
        Color.red, 
        Color.white, 
        Color.yellow
    };
    
    
    /**Links*/
    
    /**launcher Launcher of Display object*/
    public static Launcher launcher;

    /**game Game of Display object*/
    public static Game game;
    
    /**display Display of Display object*/
    public static Display display;
    
    /**menuBR JMenuBar of Display object*/
    public static JMenuBar menuBR;
    
    /**optionsWindow JPanel of Display object*/
    public static JPanel optionsWindow;
    
    /**redLine Border of Display object*/
    public Border redLine;
    
    /**raisedbevel Border of Display object*/
    public Border raisedbevel;
    
    /**loweredbevel Border of Display object*/
    public Border loweredbevel;
    
    /**compound CompoundBorder of Display object*/
    private CompoundBorder compound;
    
    /**altCol Color of Display object*/
    private static Color altCol;
    
    /**altBGCol Color of Display object*/
    private static Color altBGCol;
    
    /**altLine Border of Display object*/
    private static Border altLine;
    
    /**compound4 CompoundBorder of Display object*/
    private static CompoundBorder compound4;
    
    /**compound1 CompoundBorder of Display object*/
    private static CompoundBorder compound1;
    
    /**compound0 CompoundBorder of Display object*/
    private static CompoundBorder compound0;
    
    /**compound2 CompoundBorder of Display object*/
    private static CompoundBorder compound2;
    
    /**compound3 CompoundBorder of Display object*/
    private static CompoundBorder compound3;
    
    /**redLine1 Border of Display object*/
    private static Border redLine1;
    
    /**darkCol Color of Display object*/
    private static Color darkCol;
    
    /**lightCol Color of Display object*/
    private static Color lightCol;
    
    /**smallGameFont Color of Display object*/
    private static Font smallGameFont;
    
    /**medGameFont Color of Display object*/
    private static Font medGameFont;
    
    /**gameGreenCol Color of Display object*/
    private static Color gameGreenCol;
    
    /**soundCount boolean of Game object*/
    public static int soundCount = 0;
    
    /**audioCount boolean of Game object*/
    public static int audioCount = 0;
    
    /**audioMap Map<String, AudioClip> of Texture object*/
    public static Map<String, AudioClip> audioMap = new HashMap<String, AudioClip>();
    
    /**sndMap Map<String, Clip> of Texture object*/
    public static Map<String, Clip> sndMap = new HashMap<String, Clip>();
    
    

    /**Constructor*/
    
    
    /**
    * Display()
    * 
    * Creates a new Display object
    */
    public Display() {
        System.out.println("Display: New Display Created");
        
        //if frame already exists/not null, dispose() frame
        if(frame != null){
            frame.dispose();
        } else {
            //Set Look and Feel
            setLAF();
        }

        //Set Icon
        setIcon();
        
        //Create new JFrame: frame(Game.TITLE)
        frame = new JFrame(Game.TITLE);
        
        SwingUtilities.updateComponentTreeUI(frame);
        
        //Create new Game: game()
        game = new Game();
        
        //Create new MenuBar: menuBR()
        menuBR = new MainMenu(game);
        
        //Create new JPanel: panel(new BorderLayout())
        panel = new JPanel(new BorderLayout());
        Dimension size = new Dimension(frameWidth, frameHeight);
        panel.setPreferredSize(size);
        
        //Create new JPanel: optionsWindow(new FlowLayout())
        optionsWindow = new JPanel(new FlowLayout());
        optionsWindow.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.96f));
        optionsWindow.setSize(frameWidth, frameHeight);
        optionsWindow.setOpaque(true);
        optionsWindow.setVisible(false);
        
        //Create new JLabel: statusbar("Ready", SwingConstants.CENTER, raisedbevel)
        statusbar = new StatusBar("Ready", SwingConstants.CENTER, raisedbevel);
        
        panel.add(optionsWindow, BorderLayout.CENTER);
        panel.add(game, BorderLayout.CENTER); 
        panel.add(statusbar, BorderLayout.SOUTH);        

        frame.setContentPane(panel);
        frame.setIconImage(icon);
        frame.pack();

        frame.setVisible(true);

        frame.setJMenuBar(menuBR);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.err.println("Exiting Game!");
                game.stop();
                System.exit(0);
            }
        });
        
        game.requestFocus();
        
    }

    
    /**Public Protocol*/
    
    
    public static String memoryToMB(long mem){
        DecimalFormat dec = new DecimalFormat("#0.00");
        double result = (double) mem / (double) (1024 * 1024);
        return dec.format(result);
    }
    
    /**
     * main
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Starting " + Game.TITLE + " . . . Started by " + Util.getUserNAME());
        System.out.println("Running on OS:     " + Util.getOSName() + " "
                + Util.getOSARC() + " "+Util.getOSVER() +" Processor Cores: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Working Directory: " + Util.getDIR());
        System.out.println("Home Directory:    " + Util.getHomeDIR());
        System.out.println("Memory: Max Memory: " + memoryToMB(Runtime.getRuntime().maxMemory()) + " MB");
        System.out.println("Memory: Total Memory: " + memoryToMB(Runtime.getRuntime().totalMemory()) + " MB");
        System.out.println("Memory: Free Memory: " + memoryToMB(Runtime.getRuntime().freeMemory()) + " MB");
        System.out.println("Memory: Used Memory: " + memoryToMB(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " MB");
        System.out.println("");
        
        
        try{
            JSplash splash = new JSplash(Display.class.getResource("/menu/SI2018-MENUB.png"), true, true, false, Game.version, fonts[1], Color.red, Color.black);
            splash.splashOn();
            splash.setOpacity(0.95f);
            splash.setProgress(20, "Init . . .");
            Thread.sleep(1325);
            splash.setProgress(40, "Loading . . .");
            Thread.sleep(1450);
            splash.setProgress(60, "Applying Configs . . .");
            Thread.sleep(1575);
            splash.setProgress(80, "Starting App . . .");
            Thread.sleep(680);
            splash.splashOff();
	}catch(InterruptedException e){	
	}
	getLauncherInstance();
    }
    
    
    /**
    * getLauncherInstance()
    * 
    * @return launcher
    */
    public static Launcher getLauncherInstance() {
	if(launcher == null){
            launcher = new Launcher(0);
	}
	return launcher;
    }
    
    
    /**
    * revalidate()
    * 
    */
    public static void revalidate(){
        // NOTE: Here we need a workaround for the HW/LW Mixing feature to work
        // correctly due to yet unfixed bug 6852592.
        // The JTextField is a validate root, so the revalidate() method called
        // during the setText() operation does not validate the parent of the
        // component. Therefore, we need to force validating its parent here.
        Container parent = menuBR.getParent();
        if (parent instanceof JComponent) {
            ((JComponent)parent).revalidate();
        }
    }
    
    
    /**
    * addOptions()
    * 
    */
    public static void addOptions() {
        optionsWindow.setVisible(true);
    }
    
    
    /**
    * removeOptions()
    * 
    */
    public static void removeOptions() {
        optionsWindow.setVisible(false);
        optionsWindow.removeAll();
    }
    
    
    /**
    * setStatusBar(String msg)
    * 
    * @param msg
    */
    public static void setStatusBar(String msg) {
        currentStatus = msg;
        statusbar.setText(msg);
    }
    
    
    /**
    * getStatusBar()
    * 
    * @return currentStatus
    */
    public static String getStatusBar() {
        return currentStatus;
    }
    

    /**
    * setLAF()
    * 
    */
    private void setLAF() {
        //Set LaF
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch (Exception ex) {
            //Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Set Frame/Game Colors
        darkCol = new Color(0.25f, 0.05f, 0.05f, 0.90f);//new Color(0.15f, 0.15f, 0.15f, 0.96f);
        lightCol = Color.red;
        altCol = new Color(0, 129, 129);//Color.cyan;
        altBGCol = new Color(0, 49, 49);//Color.cyan;
        gameGreenCol = new Color(20, 36, 26);//new Color(0.06f, 0.10f, 0.02f, 0.80f);//new Color(0, 51, 51);
                
        //Set Frame/Game Fonts
        smallGameFont = new Font("Cosmic Alien", Font.PLAIN, 12);
        medGameFont = new Font("Cosmic Alien", Font.PLAIN, 10);
                
        //Set Frame/Game Borders
        redLine = BorderFactory.createLineBorder(lightCol, 2);
        redLine1 = BorderFactory.createLineBorder(lightCol, 2);
        altLine = BorderFactory.createLineBorder(altCol, 2);
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();
        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        compound0 = BorderFactory.createCompoundBorder(redLine, loweredbevel);
        compound1 = BorderFactory.createCompoundBorder(redLine, compound);
        compound2 = BorderFactory.createCompoundBorder(compound3, redLine1);
        compound3 = BorderFactory.createCompoundBorder(loweredbevel, raisedbevel);
        compound4 = BorderFactory.createCompoundBorder(altLine, loweredbevel);

        compound = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
        compound = BorderFactory.createCompoundBorder(redLine, compound);
//        UIManager.put("Button.border", compound);
//        UIManager.put("Button.selectBorder", BorderFactory.createLineBorder(lightCol, 2));
//        UIManager.put("Button.background", btnCol);
//        UIManager.put("Button.foreground", txtCol);
//        UIManager.put("Button.shadow", new ColorUIResource(Color.RED));
//        UIManager.put("Button.rollover", true);
//        UIManager.put("Button.select", Color.black);
//        UIManager.put("Button.gradient", new ColorUIResource(Color.blue));
//        //UIManager.put("Button.opaque", true);
//        UIManager.put("Button.font", smallGameFont);
//        
//        UIManager.put("Panel.border", compound0);
//        UIManager.put("Panel.background", darkCol);
//        UIManager.put("Panel.foreground", lightCol);
//        UIManager.put("Panel.font", medGameFont);
//        
//        UIManager.put("Label.font", smallGameFont);
//        UIManager.put("Label.foreground", txtCol);
//        
//        UIManager.put("CheckBox.background", darkCol);
//        UIManager.put("CheckBox.foreground", lightCol);
//        UIManager.put("CheckBox.selectionBackground", new ColorUIResource(darkCol));
//        UIManager.put("CheckBox.selectionForeground", new ColorUIResource(lightCol));
//        UIManager.put("CheckBox.border", redLine);
//        UIManager.put("CheckBox.font", new Font("Cosmic Alien", Font.PLAIN, 10));
//        
//        UIManager.put("TextField.background", darkCol);
//        UIManager.put("TextField.foreground", lightCol);
//        UIManager.put("TextField.border", loweredbevel);
//        UIManager.put("TextField.font", lgeGameFont);
//        
//        UIManager.put("ComboBox.buttonBackground", btnCol);
//        UIManager.put("ComboBox.background", Color.black);
//        UIManager.put("ComboBox.foreground", lightCol);
//        UIManager.put("ComboBox.selectionBackground", lightCol);
//        UIManager.put("ComboBox.selectionForeground", Color.black);
//        UIManager.put("ComboBox.border", raisedbevel);
//        UIManager.put("ComboBox.font", smallGameFont);
//
//        UIManager.put("RadioButton.border", raisedbevel);
//        UIManager.put("RadioButton.background", darkCol);
//        UIManager.put("RadioButton.foreground", lightCol);
//        UIManager.put("RadioButton.focus", Color.black);
//        UIManager.put("RadioButton.font", new Font("Cosmic Alien", Font.PLAIN, 10));
//        
//        UIManager.put("Slider.border", raisedbevel);
//        UIManager.put("Slider.background", darkCol);
//        UIManager.put("Slider.foreground", lightCol);
//        UIManager.put("Slider.highlight", darkCol);
//        UIManager.put("Slider.tickColor", lightCol);
//        UIManager.put("Slider.altTrackColor", Color.black);
//        UIManager.put("Slider.trackColor", Color.orange);
//        //UIManager.put("Slider.horizontalThumbIcon", sliderIconImage);
//        UIManager.put("Slider.margin", new Insets(5, 2, 5, 2));
//        UIManager.put("Slider.font", smallGameFont);
        
        //Set Frame/Game Style: InternalFrame
        UIManager.put("InternalFrame.titleFont", smallGameFont);
        //UIManager.put("InternalFrame.borderColor", Color.black);
//        UIManager.put("InternalFrame.activeTitleBackground", new Color(0.0f, 0.0f, 0.0f, 0.96f));
        UIManager.put("InternalFrame.titleForeground", lightCol);
        
        
        
        
        
        
        
        //Set Frame/Game Style: MenuBar
        UIManager.put("MenuBar.border", BorderFactory.createLineBorder(lightCol, 1));
        UIManager.put("MenuBar.background", new Color(0.15f, 0.15f, 0.15f, 0.96f));
        UIManager.put("MenuBar.foreground", lightCol);
        UIManager.put("MenuBar.font", smallGameFont);
        
        //Set Frame/Game Style: Menu
        UIManager.put("Menu.border", BorderFactory.createRaisedBevelBorder());
        UIManager.put("Menu.background", new Color(0.15f, 0.15f, 0.15f, 0.96f));
        UIManager.put("Menu.foreground", lightCol);
        UIManager.put("Menu.selectionBackground", lightCol);
        UIManager.put("Menu.selectionForeground", new Color(0.0f, 0.0f, 0.0f, 0.96f));
        UIManager.put("Menu.font", smallGameFont);
        
        //Set Frame/Game Style: MenuItem
        UIManager.put("MenuItem.background", new Color(0.15f, 0.15f, 0.15f, 0.96f));
        UIManager.put("MenuItem.foreground", lightCol);
        UIManager.put("MenuItem.selectionBackground", lightCol);
        UIManager.put("MenuItem.selectionForeground", Color.black);
        UIManager.put("MenuItem.font", smallGameFont);
        
        //Set Frame/Game Style: CheckBoxMenuItem
        UIManager.put("CheckBoxMenuItem.background", new Color(0.15f, 0.15f, 0.15f, 0.96f));
        UIManager.put("CheckBoxMenuItem.foreground", lightCol);
        UIManager.put("CheckBoxMenuItem.selectionBackground", lightCol);
        UIManager.put("CheckBoxMenuItem.selectionForeground", Color.black);
        UIManager.put("CheckBoxMenuItem.font", smallGameFont);
        
        //Set Frame/Game Style: OptionPane
        UIManager.put("OptionPane.messageBackground", new Color(0.15f, 0.15f, 0.15f, 0.96f));
        UIManager.put("OptionPane.messageForeground", lightCol);
        UIManager.put("OptionPane.border", BorderFactory.createLineBorder(Color.red, 1));
        UIManager.put("OptionPane.buttonFont", smallGameFont);
        UIManager.put("OptionPane.messageFont", smallGameFont);
        UIManager.put("OptionPane.font", smallGameFont);
    }

    
    /**
    * setIcon()
    * 
    */
    private void setIcon() {
        //Set Frame Icon Image
        icon = new Texture("/icon/SI2015-Icon").getImage();
    }
    
}
