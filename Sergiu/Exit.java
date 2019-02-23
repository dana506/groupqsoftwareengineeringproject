
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exit extends JButton {

    public Exit(String s){
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
