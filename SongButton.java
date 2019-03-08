import javax.swing.*;
/**
 * This class sets up an icon for the Song Button button.
 *
 * @author Sergiu Ivanov
 */
public class SongButton extends JButton{

    public SongButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
    }
}
