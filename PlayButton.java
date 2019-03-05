
import javax.swing.*;

/**
 * This class sets up an icon for the play button.
 *
 * @author Sergiu Ivanov
 */

public class PlayButton extends JButton {

    public PlayButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
    }
}
