import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Sergiu Ivanov
 *
 */

public class Main extends JFrame implements EscapeButtonListener, StrumBarListener{

    private  static ExitButton btnExit ;
    private  static ExitButton btnExit2 ;
    private  static PlayButton btnPlay ;
    private  static SelectButton btnSelect ;
    private  static StoreButton btnStore ;
    private  static TutorialButton btnTutorial ;
    private  static int defaultButtonPosition = 2;
    private static int firstPosition = 0;

    private static ArrayList<JButton> buttons = new ArrayList<>();
    public static Border border = BorderFactory.createLineBorder(Color.BLUE, 5);


    /**
     * This is the main constructor that set up the background image, creates Jbuttons and adds them
     * to an Arraylist "buttons" for further use
     *
     * @author Sergiu Ivanov
     *
     */
    public Main(){
        setTitle( "Guitar Zero Live (SLASH MODE)" );
        setContentPane( new JLabel( new ImageIcon( "guitar.png" ) ) );
        setLayout( null );
        btnExit = new ExitButton("exit.png");
        btnExit2 = new ExitButton("exit.png");
        btnPlay = new PlayButton("play.png");
        btnSelect = new SelectButton("select.png");
        btnStore = new StoreButton("store.png");
        btnTutorial = new TutorialButton("tutorial.png");
        buttons.add(btnExit);
        buttons.add(btnExit2);
        buttons.add(btnPlay);
        buttons.add(btnSelect);
        buttons.add(btnStore);
        buttons.add(btnTutorial);
    }

    public  static ExitButton getBtnExit() {
        return btnExit;
    }

    public  static PlayButton getBtnPlay() {
        return btnPlay;
    }

    public  static SelectButton getBtnSelect() {
        return btnSelect;
    }

    public  static StoreButton getBtnStore() {
        return btnStore;
    }

    public  static TutorialButton getBtnTutorial() {
        return btnTutorial;
    }

    public static int getDefaultButtonPosition() {
        return defaultButtonPosition;
    }
    public static ArrayList<JButton> getButtons() {
        return buttons;
    }

    public static int getFirstPosition() {
        return firstPosition;
    }

    /**
     * This method set up the bounds of a Jbutton on a frame . The button position is determined by the position
     * parameter, from 0 to 4.
     *
     * @param button means any Jbutton that needs to be added to the frame
     * @param position means de position of the button ( 0 is the first on the left, 1 is the next one on the
     * right, 4 is the last etc.)
     *
     * @author Sergiu Ivanov
     *
     */

    public void setButtons( JButton button, int position){
        if (position == 0)
            button.setBounds  (  150, 200,  100, 130 );
        else if (position == 1)
            button.setBounds  (  250, 200,  100, 130 );
        else if (position == 2)
            button.setBounds  (  350, 200,  100, 130 );
        else if (position == 3)
            button.setBounds  (  450, 200,  100, 130 );
        else if (position== 4)
            button.setBounds  (  550, 200,  100, 130 );
        else
            System.out.println("No such position ");
        add( button );
    }

    /**
     * This method shows 5 buttons from an arraylist . The index of the first button should be set as a parameter,
     *     the position of the rest will be computed automatically.
     *
     * @param buttonsList means any Arraylist of Jbuttons
     * @param first means de index of the buttons that is to be shown first
     *
     * @authors Sergiu and Callum
     *
     */
    public  void showCurrentButtons (ArrayList<JButton> buttonsList, int first){
        //defaultButtonPosition = (Math.floorMod(first, 5)) + 2;
//        System.out.println(" The number of buttons in the list is :" + buttonsList.size());
        System.out.println("The first position is: " + firstPosition);
//        System.out.println("The default button position is: " + defaultButtonPosition);
//        System.out.println();
        for (int i = 0; i < 5; i++){
            //int mod = Math.floorMod(first, 6);
            setButtons(buttonsList.get(Math.floorMod(first + i, 6)), i);
            System.out.printf("First: %d; Showing button %d at position %d\n", first, Math.floorMod(first+i, 6), i);
            //System.out.printf("mod %d %% %d = %d\n", first, 6, mod);
            //first++;
        }
        System.out.println();
    }

    public static void setDefaultButton(){
        JButton defaultButton = buttons.get(getDefaultButtonPosition());
        defaultButton.setBorder(null);
        JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
        if (rootPane != null) {
            rootPane.setDefaultButton(defaultButton);
            defaultButton.setBorder(border);
        }
    }

    public void escapeButtonEventReceived(GuitarEvent event) {
        System.exit(0);
    }

    public void strumBarEventReceived(GuitarEvent event){
        int strumbarValue = event.getState().getStrumBar();
        if (strumbarValue == 1 || strumbarValue == -1){
            firstPosition += strumbarValue;
            showCurrentButtons(buttons, firstPosition);
            //setDefaultButton();
        }

    }

    public static void main(String[] args) {
        JFrame frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setSize( 791, 600 );
        frame.setResizable( false );
        frame.setVisible( true );
        frame.setFocusable(true);



        try {
            Thread.sleep(10);
            ((Main) frame).showCurrentButtons(getButtons(), getFirstPosition());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

//        try {
//            guitarController = new PhysicalGuitarController();
//        }
//        catch(IOException e)
//        {
//            System.out.println("No guitar controller found");
//            System.exit(-1);
//        }


        /* Set up the guitar poller to run in its own thread. Pass this poller into your class to be able to register it
        as a listener - Callum
         */


        GuitarPoller poller = new GuitarPoller(guitarController);
        poller.addEscapeButtonListener((EscapeButtonListener) frame);
        poller.addStrumBarListener((StrumBarListener) frame);
        (new Thread(poller)).start();
        System.out.println();
    }
}
