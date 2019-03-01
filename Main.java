
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * 
 * @author Sergiu Ivanov
 *
 */
public class Main extends JFrame implements EscapeButtonListener{

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

    public void escapeButtonEventReceived(GuitarEvent event) {
        System.exit(0);
    }

    public static void main(String[] args) {
        JFrame frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setSize( 791, 600 );
        frame.setResizable( true );
        frame.setVisible( true );
        frame.setFocusable(true);


        GuitarController guitarController = null;

        /**
         * If you want to mock the guitar with your computer's keyboard, uncomment below and comment the block after - Callum
         */
        KeyboardWatcher keyboardWatcher = new KeyboardWatcher();
        frame.addKeyListener(keyboardWatcher);
        guitarController = new MockGuitarController(keyboardWatcher);

        /**
         * If you want to use the physical guitar controller, uncomment below and comment the block above
         */
        /*
        try {
            guitarController = new PhysicalGuitarController();
        }
        catch(IOException e)
        {
            System.out.println("No guitar controller found");
            System.exit(-1);
        }*/

        /* Set up the guitar poller to run in its own thread. Pass this poller into your class to be able to register it
        as a listener - Callum
         */
        GuitarPoller poller = new GuitarPoller(guitarController);
        poller.addEscapeButtonListener((EscapeButtonListener) frame);
        (new Thread(poller)).start();
    }
}
