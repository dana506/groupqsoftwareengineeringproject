
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Sergiu Ivanov
 *
 */
public class ExitButton extends JButton {

    public ExitButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );

        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
}
