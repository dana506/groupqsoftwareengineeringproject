
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Main extends JFrame{


    final Exit btnExit = new Exit("exit.png");
    final Play btnPlay = new Play("play.png");
    final Select btnSelect = new Select("select.png");
    final Store btnStore = new Store("store.png");
    final Tutorial btnTutorial = new Tutorial("tutorial.png");


    //constructor
    public Main(){

        setTitle( "Guitar Zero Live (SLASH MODE)" );
        setContentPane( new JLabel( new ImageIcon( "guitar.png" ) ) );
        setLayout( null );

        btnExit.setBounds  (  50, 200,  100, 130 ); add( btnExit  );
        btnPlay.setBounds  (  200, 200,  100, 130 ); add( btnPlay  );
        btnSelect.setBounds  (  350, 200,  100, 130 ); add( btnSelect  );
        btnStore.setBounds  (  500, 200,  100, 130 ); add( btnStore  );
        btnTutorial.setBounds  (  650, 200,  100, 130 ); add( btnTutorial  );

    }


    public static void main(String[] args) {
        JFrame frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setSize( 791, 600 );
        frame.setResizable( true );
        frame.setVisible( true );
    }
}
