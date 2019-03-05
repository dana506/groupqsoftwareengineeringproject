
import javax.swing.*;

/**
 * This class sets up an icon for the store button.
 *
 * @author Sergiu Ivanov
 */
public class StoreButton extends JButton{

    public StoreButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
    }
}
