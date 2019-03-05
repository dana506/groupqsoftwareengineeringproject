
import javax.swing.*;

/**
 * This class sets up an icon for the select button.
 *
 * @author Sergiu Ivanov
 */

public class SelectButton extends JButton {

    public SelectButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
    }
}
