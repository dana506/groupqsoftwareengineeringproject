

import javax.swing.*;

/**
 * This class sets up an icon for the tutorial button.
 *
 * @author Sergiu Ivanov
 */

public class TutorialButton extends JButton{

    public TutorialButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
    }
}
