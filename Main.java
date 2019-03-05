import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is the main class that represents the Slash mode menu
 * 
 * @author Sergiu Ivanov
 */

public class Main extends JFrame implements EscapeButtonListener, StrumBarListener, ZeroPowerButtonListener{

    private static JPanel jPanel;
    private  static ExitButton btnExit ;
    private  static ExitButton btnExit2 ;
    private  static PlayButton btnPlay ;
    private  static SelectButton btnSelect ;
    private  static StoreButton btnStore ;
    private  static TutorialButton btnTutorial ;
    // the index of the selected button
    private  static int defaultButtonPosition = 2;
    // the index of the first icon on the left
    private static int firstPosition = 0;

    private static ArrayList<JButton> buttons = new ArrayList<>();
    public static Border border = BorderFactory.createLineBorder(Color.BLUE, 5);


    /**
     * This is the main constructor that set up the background image, creates Jbuttons and adds them
     * to an Arraylist "buttons" for further use
     *
     * @author Sergiu Ivanov
     */
    public Main(){
        setTitle( "Guitar Zero Live (SLASH MODE)" );
        setContentPane( new JLabel( new ImageIcon( "guitar2.png" ) ) );
        setLayout( null );

        btnExit = new ExitButton("exit2.png");
//        btnExit2 = new ExitButton("exit.png");
        btnPlay = new PlayButton("play2.png");
        btnSelect = new SelectButton("select2.png");
        btnStore = new StoreButton("store2.png");
        btnTutorial = new TutorialButton("tutorial2.png");
        buttons.add(btnExit);
//        buttons.add(btnExit2);
        buttons.add(btnPlay);
        buttons.add(btnSelect);
        buttons.add(btnStore);
        buttons.add(btnTutorial);
//        jPanel= new JPanel();
//        jPanel.add(btnExit);
//        jPanel.add(btnPlay);
//        jPanel.add(btnSelect);
//        add(jPanel);
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
     */

    public void setButtons( JButton button, int position){
        if (position == 0)
            button.setBounds  (  20, 192,  150, 182 );
        else if (position == 1)
            button.setBounds  (  170, 192,  150, 182 );
        else if (position == 2)
            button.setBounds  (  320, 192,  150, 182 );
        else if (position == 3)
            button.setBounds  (  470, 192,  150, 182 );
        else if (position== 4)
            button.setBounds  (  620, 192,  150, 182 );
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
     * @author Sergiu Ivanov and Callum Brownie
     */
    public  void showCurrentButtons (ArrayList<JButton> buttonsList, int first){
        System.out.println("The first position is: " + firstPosition);
        System.out.println("The default button position is: " + defaultButtonPosition);
        int mod = buttonsList.size();
        for (int i = 0; i < 5; i++){
            setButtons(buttonsList.get(Math.floorMod(first + i, mod)), i);
            System.out.printf("First: %d: Showing button %d at position %d\n", first, Math.floorMod(first+i, mod), i);
        }
        System.out.println();
    }

    public  void removeAllButtons(){
        for (JButton button: buttons){
            this.remove(button);
        }
    }

    /**
     * This method sets up de index of the selected button. The index is used to highlight
     * the selected button that should always be in the middle
     *
     * @param buttonsList means any Arraylist of Jbuttons
     * @author Sergiu Ivanov
     */
    public static void setDefaultButton(ArrayList<JButton> buttonsList){
        int mod = buttonsList.size();
        defaultButtonPosition = Math.floorMod(firstPosition + 2, mod);
        JButton defaultButton = buttons.get(defaultButtonPosition);
        //defaultButton.setBorder(null);
        JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
        if (rootPane != null) {
            rootPane.setDefaultButton(defaultButton);
            //defaultButton.setBorder(border);
        }
    }

    /**
     * This method implements a carousel that cycles forwards or backwards,
     * when the strum bar is tweaked up or down.
     *
     * @param event is the event fired by the strum bar
     * @author Sergiu Ivanov
     */
    public void strumBarEventReceived(GuitarEvent event){
        //removeAllButtons();
        int strumbarValue = event.getState().getStrumBar();
        if (strumbarValue == 1 || strumbarValue == -1){
            firstPosition += strumbarValue;
            setDefaultButton(buttons);
            showCurrentButtons(buttons, firstPosition);
        }
    }
    /**
     * This method exits the game
     *
     * @param event is the event fired by the strum bar
     * @author Callum Brownie
     */
    public void escapeButtonEventReceived(GuitarEvent event) {
        System.exit(0);
    }

    /**
     * This method selects the intended game mode.
     *
     * @param event is the event fired by the zero power button
     * @author Sergiu Ivanov
     */
    public void zeroPowerButtonEventReceived(GuitarEvent event) {
        boolean isTrue = false;
        if (isTrue == event.getState().getZeroPowerButton()){
            if (buttons.get(defaultButtonPosition) == btnSelect){
                JOptionPane.showMessageDialog(this, "SELECT button clicked");
            }
            else if (buttons.get(defaultButtonPosition) == btnPlay){
                JOptionPane.showMessageDialog(this, "PLAY button clicked");
            }
            else if (buttons.get(defaultButtonPosition) == btnStore){
                JOptionPane.showMessageDialog(this, "STORE button clicked");
            }
            else if (buttons.get(defaultButtonPosition) == btnTutorial){
                JOptionPane.showMessageDialog(this, "TUTORIAL button clicked");
            }
            else if (buttons.get(defaultButtonPosition) == btnExit){
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(this, "OTHER button clicked");
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo( null );
        frame.setSize( 791, 711 );
        frame.setResizable( false );
        frame.setVisible( true );
        frame.setFocusable(true);

        ((Main) frame).showCurrentButtons(buttons, firstPosition);

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
        poller.addZeroButtonListener((ZeroPowerButtonListener) frame);
        (new Thread(poller)).start();
        System.out.println();
    }
}
