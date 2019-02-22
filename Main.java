
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.Arrays;

import java.io.IOException;

public class Main extends JFrame{

    final Exit btnExit = new Exit("exit.png");
    final Play btnPlay = new Play("play.png");
    final Select btnSelect = new Select("select.png");
    final Store btnStore = new Store("store.png");
    final Tutorial btnTutorial = new Tutorial("tutorial.png");

    GuitarController guitarController;

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
        
        try {
        	guitarController = new GuitarController();
        }
        catch(IOException e)
        {
        	System.out.println("No guitar controller found");
        	System.exit(-1);
        }
        
        GuitarState state;
        while(true) {
        	state = guitarController.getState();
        	System.out.println(Arrays.toString(state.getFretButtons()));
        }
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
