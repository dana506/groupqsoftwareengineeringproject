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
public class PlayView extends JPanel { 
    
    public PlayView() { 
        JFrame f = new JFrame("Guitar Zero Play"); // construct new JFrame
        // initialize JFrame size and properties
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // force program exit on frame close
        f.setSize(800, 1024); // set size of frame to 800x1024
        f.setResizable(false); // force the frame to be rigid in size
        setLayout(new BorderLayout()); //init the JPanel
        setBackground(Color.BLACK);
        PlayMode game = new PlayMode(); // construct new PlayMode (game management) JPanel object
        game.setLayout(null); // enable absolute positioning in game JPanel
        game.setBackground(Color.WHITE); // initialize PlayMode JPanel bgcolor
        game.play(); // start the game
        f.addKeyListener(game); // add game to frame as a key listener, so key events are logged from there, not here
        f.setContentPane(game); // add game to frame as a JPanel by setting it as the content pane
        f.setVisible(true); // have the frame appear again to show the changes
    }
//
//    // static main method for program to test
//    public static void main(String[] args) {
//        PlayView e = new PlayView(); // construct new Engine 
//    }
}
