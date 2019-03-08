import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//contains the static method to run the game
public class GuitarZeroPlay extends JPanel { 

    // instance field stage: represents current stage of game
    private boolean stage; // false = intro stage, true = game stage

    public GuitarZeroPlay() { // Engine constructor
        stage = false; // intro stage
        
        setLayout(new BorderLayout()); //init the JPanel
        setBackground(Color.BLACK);

        // initialize title content/layout
        JLabel title = new JLabel("<html><b>Guitar Zero Live</b></html>", SwingConstants.CENTER);
        title.setPreferredSize(new Dimension(800, 85));
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Default", Font.PLAIN, 48));

        // initialize instruction content/layout
        JPanel infoPanel = new JPanel(null);
        infoPanel.setPreferredSize(new Dimension(800, 1024));
        infoPanel.setLayout(new GridLayout(11, 1));
        infoPanel.setBackground(Color.BLACK);
        Font infoFont = new Font("Default", Font.PLAIN, 19);
        // instructions to play game
        String[] infoText = new String[] {"<div style = 'font-size: 23'>Guitar Zero Live play test</div>",
                "<b>Need to link to Slash mode</b>",
                "<div style = 'font-size: 24'><i>PRESS SPACE TO START</i></div>"};
        for (String s : infoText) {
            JLabel n = new JLabel("<html><center>" + s + "</center></html>", SwingConstants.CENTER);
            n.setFont(infoFont);
            n.setForeground(Color.WHITE);
            infoPanel.add(n);
        }

        // add title and instructions to Engine JPanel
        add(title, BorderLayout.NORTH);
        add(infoPanel, BorderLayout.CENTER);
    }

    // mutator for state instance field of Engine
    public void setStage(boolean s) {
        stage = s;
    }

    // accessor for state instance field of Engine
    public boolean getStage() {
        return stage;
    }

    // static main method for program to run
    public static void main(String[] args) {
        GuitarZeroPlay e = new GuitarZeroPlay(); // construct new Engine
        JFrame f = new JFrame("Guitar Zero Play"); // construct new JFrame
        // initialize JFrame size and properties
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // force program exit on frame close
        f.setSize(800, 1024); // set size of frame to 800x1024
        f.setResizable(false); // force the frame to be rigid in size

        PlayMode game = new PlayMode(); // construct new PlayMode (game management) JPanel object
        game.setLayout(null); // enable absolute positioning in game JPanel
        game.setBackground(Color.WHITE); // initialize PlayMode JPanel bgcolor

        // introductory functionality
        f.addKeyListener(new KeyListener() { // construct and add new anonymous key listener to frame
                public void keyReleased(KeyEvent ke) { // when key is pressed
                    // if the key pressed was the spacebar, and the engine is at its introductory stage
                    if ((ke.getKeyCode() == KeyEvent.VK_SPACE) && (!e.getStage())) {
                        e.setStage(true); // change engine's stage so this key listener is rendered useless
                        f.addKeyListener(game); // add game to frame as a key listener, so key events are logged from there, not here
                        f.setContentPane(game); // add game to frame as a JPanel by setting it as the content pane
                        f.setVisible(true); // have the frame appear again to show the changes
                        game.play(); // start the game
                    }
                }
                // method needed to satisfy KeyListener interface
                public void keyPressed(KeyEvent e) { }
                // method needed to satisfy KeyListener interface
                public void keyTyped(KeyEvent e) { }
            });
        f.setContentPane(e); // set the JFrame to load in the Jpanel
        f.setVisible(true); //make the frame visible
    }
}
