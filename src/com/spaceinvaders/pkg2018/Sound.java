package com.spaceinvaders.pkg2018;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import javax.sound.sampled.*;

/**
 * Sound objects represent the sounds & sfx in the game
 * 
 * @author(s) Ghomez
 */
public final class Sound implements LineListener {   

    /**Attributes*/
        
    /**clip Audioclip of Sound object*/
    private AudioClip clip;

    /**clip1 Clip of Sound object*/
    private static Clip clip1;
    
    
    //Menu sfx
    /**Launcher variable of Sound object*/
    public static Sound Launcher = new Sound("/No Monkey.wav");
    
    /**sound5 variable of Sound object*/
    public static final Sound sound5 = new Sound("/Pickup_Coin2.wav", 0.5);
    
    /**Paused variable of Sound object*/
    public static final Sound Paused = new Sound("/SI2018 Paused.wav");
    
    /**Focus variable of Sound object*/
    public static final Sound Focus = new Sound("/SI2015 LostFocus.wav");
    
    public static final Sound btnPushed = new Sound("/btnPushed Sonar Blip.wav");
        
    
    //Game Soundtracks 
    /**Soundtrack variable of Sound object*/
    //public static final Sound Soundtrack = new Sound("/Hit N Hide - Space invaders 2013 short.wav");
    
    /**creditsSoundtrack variable of Sound object*/
    public static final Sound creditsSoundtrack = new Sound("/credits.wav");
    
    /**creditsSoundtrack variable of Sound object*/
    public static final Sound creditsSoundtrackA = new Sound("/creditsB.wav");
    
    
    //Menu Sounds
    /**Menu variable of Sound object*/
    public static final Sound Menu = new Sound("/Space Invaders Menu.wav");
    
    /**Menu1 variable of Sound object*/
    public static final Sound Menu1 = new Sound("/Fiddly music.wav");
    
    /**Menu2 variable of Sound object*/
    public static final Sound Menu2 = new Sound("/Game Ambient Forest loop.wav");
    
    /**Menu3 variable of Sound object*/
    public static final Sound Menu3 = new Sound("/Retro1 140.wav");
    
    /**Menu3 variable of Sound object*/
    public static final Sound Menu4 = new Sound("/chargingCannons_RemixA.wav");
    
    
    //Level Sounds
    /**Level1 variable of Sound object*/
    public static final Sound Level1 = new Sound("/Videogame2.wav");
    
    /**Level2 variable of Sound object*/
    public static final Sound Level2 = new Sound("/Androids.wav");
    
    /**Level3 variable of Sound object*/
    public static final Sound Level3 = new Sound("/Fast Ace.wav");
    
    /**Level4 variable of Sound object*/
    public static final Sound Level4 = new Sound("/Power Bots Loop.wav");
    
    /**Level5 variable of Sound object*/
    public static final Sound Level5 = new Sound("/Retro1 140.wav");
    
    /**Level6 variable of Sound object*/
    public static final Sound Level6 = new Sound("/Star Commander1.wav");
    
    /**Level7 variable of Sound object*/
    public static final Sound Level7 = new Sound("/Traveler.wav");
    
    /**Level8 variable of Sound object*/
    public static final Sound Level8 = new Sound("/No Monkey.wav");
    
    /**Level9 variable of Sound object*/
    public static final Sound Level9 = new Sound("/Androids.wav");
        
    
    //Ingame Sprite sounds
    /**P1Shoot variable of Sound object*/
    public static final Sound P1Shoot = new Sound("/shoot.wav");
    
    /**P1Shoot variable of Sound object*/
    public static final Sound P1ShootCannon = new Sound("/laserPistol.wav");
    
    /**P1Exp variable of Sound object*/
    public static final Sound P1Exp = new Sound("/explosion.wav");
    
    /**EnExp variable of Sound object*/
    public static final Sound EnExp = new Sound("/invaderkilled.wav");
    
    /**UFOsnd variable of Sound object*/
    public static final Sound UFOsnd = new Sound("/ufo_highpitchA.wav");
    
    /**UFOsndA variable of Sound object*/
    public static final Sound UFOsndA = new Sound("/ufo_lowpitchA.wav");
    
    /**ricochet variable of Sound object*/
    public static final Sound ricochet = new Sound("/ricochet.wav");
    
    /**EnMove variable of Sound object*/
    public static final Sound EnMove = new Sound("/fastinvader1.wav");
    
    /**extraLife variable of Sound object*/
    public static final Sound extraLife = new Sound("/extraLife.wav");
    
    /**chargeCannon variable of Sound object*/
    public static final Sound chargeCannon = new Sound("/chargingCannons.wav");
    
    /**shieldOn variable of Sound object*/
    public static final Sound shieldOn = new Sound("/shieldsOn.wav");
    
    /**shieldOn variable of Sound object*/
    public static final Sound shieldDown = new Sound("/shieldsDown.wav");
    
    /**shieldOn variable of Sound object*/
    public static final Sound speedOn = new Sound("/speedOn.wav");
    
    
    /**soundFile File of Sound object*/
    private File soundFile;
    
    /**ai AudioInputStream of Sound object*/
    private AudioInputStream ai;
    
    /**format AudioFormat of Sound object*/
    private AudioFormat format;
    
    /**info DataLine.Info of Sound object*/
    private DataLine.Info info;
    
    /**aClip Clip of Sound object*/
    private Clip aClip;
    
    /**playing boolean of Sound object*/
    private boolean playing;
    
    /**gainControl FloatControl of Sound object*/
    private FloatControl gainControl;
    
    /**fileName variable of Sound object*/
    private String fileName;
    
    /**audioFileName variable of Sound object*/
    private String audioFileName;
    
    
    
    /**Constructors*/
        
    
    /**
    * Sound(String filename, double vol)
    * 
    * Initialises a new Sound object with 
    * (Sound file) filename as the argument
    * 
    * @param filename - the filename variable of Sound object
    * @param vol - the vol variable of Sound object
    */    
    public Sound(String filename, double vol){
        audioFileName = filename;
        soundFile = new File("snd"+filename);
        
        Clip oldSnd = Display.sndMap.get(filename);
        if(oldSnd != null){
            this.aClip = oldSnd;
        } else {
            try{
                System.out.println("Loading Sound: "+Display.soundCount+": " + audioFileName);
                ai = AudioSystem.getAudioInputStream(soundFile);
                format = ai.getFormat();
                info = new DataLine.Info(Clip.class, format);
                aClip = (Clip) AudioSystem.getLine(info);
                aClip.addLineListener(this);
                aClip.open(ai);
                gainControl = (FloatControl) aClip.getControl(FloatControl.Type.MASTER_GAIN);
                setVolume(vol);
                Display.sndMap.put(filename, aClip);
                Display.soundCount++;
            } catch(Exception e){
            }
        }
    }
	
    
    /**
    * Sound(String filename)
    * 
    * Initialises a new Sound object with 
    * (Sound file) filename as the argument
    * 
    * @param filename - the filename variable of Sound object
    */    
    public Sound(String filename){
        this.fileName = filename;
        AudioClip oldAudio = Display.audioMap.get(filename);
        if(oldAudio != null){
            this.clip = oldAudio;
        } else {
            try{
                System.out.println("Loading Audio: "+Display.audioCount+": "+"/snd"+ filename);
                clip = Applet.newAudioClip(Sound.class.getResource("/snd"+filename));
                Display.audioMap.put(filename, clip);
                Display.audioCount++;
            } catch (Exception e) {
            }
        }
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
            Display.sndMap.remove(fileName);
            System.out.println("Removing Sound from memory: " + fileName);
        }
        if(!audioFileName.isEmpty()){ 
            Display.audioMap.remove(audioFileName);
            System.out.println("Removing Audio from memory: " + audioFileName);
        }
        super.finalize();
    }
    
    
    /**
    * play()
    * 
    * Plays reciever Sound object.
    */
    public void play(){
        if(aClip != null){
            aClip.stop();
            aClip.start();
            playing = true;
        }
	try{
            if (clip != null) {
		new Thread(){
                    @Override
                    public void run(){
			synchronized (clip) {
				clip.stop();
				clip.play();
			}					
                    }
		}.start();
            }
	}catch(Exception ex){
	}		
    }

    
    /**
    * stop()
    * 
    * Stops reciever Sound object.
    */
    public void stop() {
	try{
            clip.stop();
	} catch(Exception exc){
	}
    }
    
    
    /**
    * stopAll()
    * 
    * Stops All Sound object.
    */
    public static void stopAll() {
        Sound.Level1.stop();
        Sound.Level2.stop();
        Sound.Level3.stop();
        Sound.Level4.stop();
        Sound.Level5.stop();
        Sound.Level6.stop();
        Sound.Level7.stop();
        Sound.Level8.stop();
        Sound.Level9.stop();
        //Sound.Soundtrack.stop();
        Sound.creditsSoundtrack.stop();
        Sound.Paused.stop();
        Sound.Menu1.stop();
        Sound.Menu2.stop();
        Sound.Menu3.stop();
        Sound.Menu4.stop();
        Sound.UFOsnd.stop();
        Sound.UFOsndA.stop();
        Sound.EnMove.stop();
        Sound.EnExp.stop();
        Sound.Focus.stop();
        Sound.Launcher.stop();
        Sound.ricochet.stop();
        Sound.sound5.stop();
    }

    
    /**
    * loop()
    * 
    * Loops reciever Sound object.
    */
    public void loop(){
    	try{
            if (clip != null) {
		new Thread(){
                    @Override
                    public void run(){
			synchronized (clip) {
				clip.stop();
				clip.loop();
			}
                    }
		}.start();
            }
	}catch(Exception ex2){
	}
    }
        

    /**
    * setVolume(double vol)
    * 
    * Sets Volume of reciever Sound object.
    * 
    * @param vol - the volume variable of Sound object
    */
    private void setVolume(double vol) {
        float db = (float) (Math.log(vol) / Math.log(10) * 20);
        gainControl.setValue(db); // Reduce volume by 10 decibels.
    }

    
    /**
    * update(LineEvent le)
    * 
    * Updates reciever Sound object.
    * 
    * @param le
    */
    @Override
    public void update(LineEvent le) {
        if(le.getType() == LineEvent.Type.START){
            playing = true;
        } else if(le.getType() == LineEvent.Type.STOP){
            aClip.stop();
            aClip.flush();
            aClip.setFramePosition(0);
            playing = false;
        }
    }
    
    
    /**
    * isPlaying()
    * 
    * @return playing
    */
    public boolean isPlaying() {
        return playing;
    }
 
    
    /**
    * reloopLevel(int levelNo)
    * 
    * @param levelNo
    */
    public static void reloopLevel(int levelNo) {
        
        switch(levelNo){
            case 1:
                Sound.Level1.loop();
                break;
            case 2:
                Sound.Level2.loop(); 
                break;
            case 3:
                Sound.Level3.loop();
                break;
            case 4:
                Sound.Level4.loop();
                break;
            case 5:
                Sound.Level5.loop();
                break;
            case 6:
                Sound.Level6.loop();
                break;
            case 7:
                Sound.Level7.loop();
                break;
            case 8:
                Sound.Level8.loop();
                break;
            case 9:
                Sound.Level9.loop();
                break;
        }
                
    }
}