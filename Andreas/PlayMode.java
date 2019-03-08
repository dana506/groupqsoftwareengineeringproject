import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComponent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;

public final class PlayMode extends JPanel implements KeyListener { // declare class game as a type of JPanel that is also a KeyListener
    
    private final int[] subKeys; // contains the subsitute keys. TODO: guitar implementations
    private int gameState; //if the game is active or in another menu
    private final ArrayList<ArrayList<Note>> notes = new ArrayList<>(); // contains the notes to be played. TODO: import note file from server
    private final Song song = new Song("testSong"); // test song, TODO: import song from server
    private JLabel multiplierCounter; //displays current multiplier
    private JLabel scoreCounter; // displays current score
    private JLabel streakCounter; // displays current streak
    private JComponent guitarImg; // displays background image
    private CatchBox mainCapture; // area in which notes can be caught. If area is missed, note is dropped
    private int score; // contains score
    private int streak; // contains streak
    private int multiplier = 1; //contains multiplier
    private int noteClick; // stores notes clicked intervals
    private Timer gameTimer; // timer used to control gameplay

    public PlayMode() { // constructor for PlayMode
        subKeys = new int[] {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6}; // keys ued for input for testing
        gameTimer = new Timer(); // create new timer
        noteClick = 0; // set note counter to 0
        streak = 0; // streak is initaially 0
        score = 0; // score is initially 0
        multiplier = 1; //multiplier is initially 1
        for(int i = 0; i < 6; i++) notes.add(new ArrayList<>()); // import the notes from the notes list
        setComponents(); // initialize UI
    }

    // method to set and reset UI
    public void setComponents() {
        
        // create score,streak and muliplier title labels
        Font titleFont = new Font("Defalt", Font.PLAIN, 20);//streak title
        JLabel streakCounterLabel = new JLabel("STREAK");//sreak title
        streakCounterLabel.setForeground(Color.RED);//streak title
        streakCounterLabel.setBounds(670, -260, 800, 1024);//absolute positioning, TODO make relitive to resolution
        streakCounterLabel.setFont(titleFont);//streak title
        JLabel scoreCounterLabel = new JLabel("SCORE");//score title
        scoreCounterLabel.setForeground(Color.BLACK);//score title set to black
        scoreCounterLabel.setBounds(37, -260, 800, 1024);//absolute positioning, TODO make relitive to resolution
        scoreCounterLabel.setFont(titleFont);//score title
        JLabel muliplierLabel = new JLabel("MULTIPLIER");//sreak title
        muliplierLabel.setForeground(Color.BLUE);//streak title
        muliplierLabel.setBounds(650, -100, 800, 1024);//absolute positioning, TODO make relitive to resolution
        muliplierLabel.setFont(titleFont);//streak title
        
        // create score,streak,multiplier and currency counters
        scoreCounter = new JLabel(Integer.toString(score));//create score counter
        scoreCounter.setForeground(Color.BLACK);//set score counter colour to black
        scoreCounter.setBounds(37, -210, 800, 1025);//absolute positioning, TODO make relitive to resolution
        scoreCounter.setFont(new Font("Default", Font.PLAIN, 70));//set the font value
        streakCounter = new JLabel(Integer.toString(streak));//create streak counter
        streakCounter.setForeground(Color.RED);//set colour of streak to red
        streakCounter.setBounds(690, -210, 800, 1024);//absolute positioning, TODO make relitive to resolution
        streakCounter.setFont(new Font("Default", Font.PLAIN, 70));//set the font value
        multiplierCounter = new JLabel(Integer.toString(multiplier));
        multiplierCounter.setForeground(Color.BLUE);//set colour of multiplier to blue
        multiplierCounter.setBounds(690, -50, 800, 1025);//absolute positioning, TODO make relitive to resolution
        multiplierCounter.setFont(new Font("Default", Font.PLAIN, 70));//set the font value
        
        // create background image (the guitar, finial image to be decided)
        BufferedImage img = null; // initialize img 
        try { 
            img = ImageIO.read(new File(this.getClass().getResource("files/guitar/guitar.png").toURI())); // try reading the image from the image file. TODO: decide on final image to be used
        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getCause());
            // catch block to recieve potential errors thrown by image buffering
            // print errors, if caught: TODO work on error reporting
                    }
        final BufferedImage imgFinal = img; // make it a final image variable
        guitarImg = new JComponent() { // creates a JComponent to draw the image file onto
            @Override
            public void paintComponent(Graphics g) { // using an overridden paint component to draw the image of the background
                g.drawImage(imgFinal, 0, 0, null); // draw the image using the graphics component 
            }
        };
        guitarImg.setBounds(0, 0, 800, 1024); //absolute positioning: TODO: make relative to resolution
        mainCapture = new CatchBox(280, 710, 200, 50, 10);//absolute positioning for acceptable note catch area: TODO: make relative to resolution
        
        // add all components to this current PlayMode panel in order
        add(mainCapture);
        add(guitarImg);
        add(scoreCounterLabel);
        add(streakCounterLabel);
        add(muliplierLabel);
        add(scoreCounter);
        add(streakCounter);
        add(multiplierCounter);
    }

    // method for starting game
    public void play() {
        gameState = 1; // game in start mode, 0 would be stopped
        int bpm = 128; //arbritatry bpm, TODO import bpm from song
        int npb = 2; //arbritraty notes per beat. TODO: calculate from imported song
        double dificulty = 8; //dificulty level. TODO: implement a way of changing difficulty
        long tDelay = (long) ((10000.0/dificulty)/(bpm/60)/npb/60);//60 is a constant dictating when notes are added
        if (gameTimer == null) { } //do nothing if the game timer is null  
        else { //if the game timer does exist
            gameTimer.scheduleAtFixedRate(new TimerTask() { // scheduleAtFixedRate is there to reduce lag
                @Override
                public void run() { // run method for the timer
                    boolean full = false; // dictating whether the strings are full or not
                    for (int i = 0; i < 6; i++) { //loop through notes
                        for (int j = 0; j < notes.get(i).size(); j++) {
                            Note currNote = notes.get(i).get(j); // retrive note needed
                            currNote.move(); // move the retrieved note
                            currNote.repaint(); // update the graphic
                            if (!currNote.isMissed()) {}// if the current note was not missed continue
                            else {   
                                streak=0; // reset the streak
                                streakCounter.setText(Integer.toString(streak)); // update streak label
                                break;
                            }
                            if (currNote.isOut()) { // if the current note is out of the frame
                                notes.get(i).remove(j); //remove from notes list
                                break;
                            }
                        }
                        if (notes.get(i).size() > 0) {
                            full = true;
                        } // all strings are full, then full set to true
                    }
                    
                    noteClick++; // add to note counter
                    if (noteClick == 60 ) { // only add note to the screen at certain intervals
                        noteClick = 0; // reset note counter
                        int k = song.nextKey(); // get next key from song
                        if (k != 7) { // if the song is not over
                            for (int i = 0; i < 6; i++) { // loop through the array of guitar strings
                                if (k!= Note.strings[i]) {} else {
                                    Note newNote = new Note(k); // create a note with teh correct key
                                    notes.get(i).add(newNote); // using the index to add it to the correct string
                                    add(newNote); // add the new note to this PlayMode panel
                                    add(guitarImg); // add the background image behind it
                                    break;
                                }
                            }
                            
                        } else if (!full) { // song is finished and all strings are completed
                            gameState = 0; // stop the game
                        }
                    }
                }
            }, tDelay, tDelay); // to finish defining the timer
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { // when a key is pressed
        if (gameState == 1) { // if the game is running
            boolean miss = true; // if note missed
            for (int i = 0; i < 6; i++) { // loop through notes
                if (subKeys[i] == e.getKeyCode()) { // if correct key is pressed
                    for (int j = 0; j < notes.get(i).size(); j++) { // look for notes on string
                        Note currNote = notes.get(i).get(j); // check if note has been hit been hit and store
                        if (currNote.isIn()) { // if the note is in the catchbox when key is hit
                            currNote.setYPos(2000); // make the note "dissapear"
                            currNote.repaint(); // repaint
                            notes.get(i).remove(j); // remove so it is no longer checked
                            streak ++; //increment streak
                            if (streak % 10 == 1 && streak> 9) {//every 10 points in the streak, update the multiplier
                                multiplier= multiplier*2;//every time the multiplier increases, it doubles
                            }
                            score++;//increment score
                            int newScore = score*multiplier; // multiply score               
                            scoreCounter.setText(Integer.toString(newScore)); // update score label
                            score = newScore;
                            streakCounter.setText(Integer.toString(streak)); //update streak label
                            multiplierCounter.setText(Integer.toString(multiplier)); //update multiplier
                            miss = false; // miss is false if in this block
                            break;
                        }
                    }
                }
            }
            if (miss) { // if the player accidentally hits another key/ wrong key
                streak = 0; //reset streak
                multiplier = 1; //reset multiplier
                streakCounter.setText(Integer.toString(streak)); // update streak label
                multiplierCounter.setText(Integer.toString(multiplier)); //update multiplier
            }
        }
    }
    // needed for keylistener abstraction
    @Override
    public void keyTyped(KeyEvent e) { }
    // needed for keylistener abstraction
    @Override
    public void keyReleased(KeyEvent e) { }
}
