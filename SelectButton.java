
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class sets up an icon for the select button.
 *
 * @author Sergiu Ivanov
 */

public class SelectButton extends JButton {

    public SelectButton(String s){
        setIcon( new ImageIcon(  s  ) );
        setBorder( null );
//        this.slashView = slashView;
//        this.slashModel = slashModel;
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("Select button clicked!");


            }
        });
    }
}
