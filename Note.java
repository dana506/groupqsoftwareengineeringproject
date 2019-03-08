import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;

// class Note is used to create, manage and draw notes onto a panel with a guitar image
// it interacts indirectly with the song class and reaction rectangle class to create a realistic series
public class Note extends JComponent { // declare Note class as a type of JComponent
    
    // declare instance fields
    private int yPos; // y position of note
    private int xPos; // x position of note (does not change except for animations)
    private int dy; // speed of note
    private int string; // string that the note is on
    private Color color; // color of note
    private Ellipse2D.Double e2d; // ellipse defining shape of note
    private int size; // size of note's ellipse
    private int shrinkStage; // which animation state note is at (0 = stable/fully grown, 1 = shrinking/growing, 2 = fully shrunken)
    private int count; // counter used to change x twice as slowly for animations
    public static final int[] xs = new int[] {312, 335, 355, 380, 400, 420}; // array of x positions based on string
    public static final int[] strings = new int[] {1,2,3,4,5,6}; // array of key names of strings
    public static final Color[] colors = new Color[] {Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE, Color.YELLOW, Color.MAGENTA}; // array of colors for each string
    
    public Note(int k) { // constructor for Note, pass in key and note of Note
        yPos = -20; // start note out of frame
        size = 1; // start note at small size
        dy = 1; // move note at one unit at a time
        // = n; // initialize note for guitar to play later
        if (k == 0) string = 6; // if the note is a blank note, set the string to 6 (out of bounds) so it is not drawn
        else { // if the note is note blank
            for (int i = 0; i < 6; i++) { // loop through strings
                if (k == strings[i]) { // if the string key is the same as the parameter
                    string = i; // mark that as the correct string using the index
                    break; // leave this loop
                }
            }
        }
        setBounds(0, 0, 800, 1024); // set bounds of the note so it shows up in absolute positioning of game frame
        color = colors[string]; // obtain color of note based on string
        xPos = xs[string] + 4; // obtain x position of note based on string, add 4 for size issues (growing)
        e2d = new Ellipse2D.Double(xPos, yPos, size, size); // initialize ellipse
        
        // grow note into position
        shrinkStage = 1; // start growing note
        final Timer t = new Timer(50, null); // create swing timer, null ActionListener to be able to control it within its own method
        t.addActionListener((ActionEvent e) -> {
            // when timer ticks
            size += 2; // increment size of note by 2
            count++; // increment x position counter
            if (count == 5) { // every five timer ticks
                xPos--; // decrement x position to recenter it as it shrinks
                count = 0; // reset counter
            }
            if (size >= 20) { // if the size is 20 or has grown too large, it should stop growing
                size = 20; // reset its size to 20
                xPos = xs[string]; // reset its x position
                shrinkStage = 0; // stop shrinking
                count = 0; // stop counting
                t.stop(); // stop the timer, so note stops growing
            }
        } // add new action listener to timer
        );
        t.start(); // start the timer, so this note grows in on constructions
    }

    @Override
    public void paintComponent(Graphics g) { // paintComponent method overrides method in JComponent
        if(string < 6) {
            // if the note is not a blank note
            Graphics2D g2 = (Graphics2D) g; // simplify graphics context to two dimensions
            e2d.setFrame(xPos + 2, yPos + 2, size - 4, size - 4); //reposition circle
            g2.setColor(color); // set colour of note
            if(yPos >= 770) g2.setColor(Color.BLACK); // missed notes go black
            g2.fill(e2d); //fill the ellipse
        }
    }

    // mutator for changing y position by speed of note
    public void move() {
        yPos += dy;
    }
    
    // accessor that detects if note has been missed
    public boolean isMissed() {
        return (yPos == 770);
    }
    
    // accessor that detects if note is out of frame
    public boolean isOut() {
        return ((yPos > 1000) && (yPos < 1024));
    }
    
    // accessor that detects if note is in the reaction rectangle
    public boolean isIn() {
        return ((yPos >= 650) && (yPos <= 800));
    }
    
    // mutator for setting y position of note
    public void setYPos(int y) {
        yPos = y;
    }
    
    // accessor for shrinking stage of note
    public int getStage() {
        return shrinkStage;
    }
    
    // method to shrink note
    public void shrink() {
        // utilize similar method to method used in constructor to shrink note
        shrinkStage = 1;
        count = 0;
        final Timer t = new Timer(25, null);
        t.addActionListener((ActionEvent e) -> {
            size -= 2;
            count++;
            if (count == 2) {
                xPos++;
                count = 0;
            }
            if (size <= 0) {
                shrinkStage = 2;
                t.stop();
            }
        });
        t.start();
    }
    
}
