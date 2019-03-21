import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyPair;
import java.util.ArrayList;

/**
 * This is the main class that creates the main frame of the game and display its components.
 *
 * (NOT THE FINAL VERSION)
 *
 * @author Sergiu Ivanov
 */

public class Main extends JFrame implements EscapeButtonListener, StrumBarListener, ZeroPowerButtonListener{

    private static JPanel inputPanel = new JPanel();
    private static String backgroundString = "guitar2.png";
    private ImageIcon backgroundImage = new ImageIcon(backgroundString);
    private JLabel background = new JLabel("Background", backgroundImage, JLabel.CENTER);

    private static SlashView slashViewPanel = new SlashView();
    private static SelectView selectViewPanel = new SelectView();
    private static StoreView storeViewPanel = new StoreView();
    private  static TutorialView tutorialView = new TutorialView();
    // the index of the selected button
    private  static int defaultButtonPosition = 2;
    // the index of the first icon on the left
    private static int firstPosition = 0;
    private static ArrayList<JButton> buttons;

    /**
     * This is the main constructor that  and adds a JPanel to it.
     *
     * @author Sergiu Ivanov and Callum Browne
     */
    public Main(){
        //FRAME
        setTitle( "SLASH MODE");
        setSize( 790, 711 );
        setLayout( null );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable( false );
        setVisible( true );
        setFocusable(true);

        //PANEL IN THE MIDDLE

        buttons = slashViewPanel.getButtons();
        inputPanel = slashViewPanel.getSlashModePanel();
        background.add(inputPanel);
        background.setBounds(0,0,791,711);
        add(background);
       // setInputPanel(background, slashViewPanel.getSlashModePanel(), slashViewPanel.getButtons());

        // DISPLAY CURRENT BUTTONS IN THE PANEL
        showCurrentButtons(buttons, firstPosition);

        GuitarController guitarController = null;

        /**
         * If you want to mock the guitar with your computer's keyboard, uncomment below and comment the block after - Callum
         */
        KeyboardWatcher keyboardWatcher = new KeyboardWatcher();
        addKeyListener(keyboardWatcher);
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


        /**
         * Set up the guitar poller to run in its own thread. Pass this poller into your class to be able to register it
         *as a listener - Callum
         */
        GuitarPoller poller = new GuitarPoller(guitarController);
        poller.addEscapeButtonListener((EscapeButtonListener) this);
        poller.addStrumBarListener((StrumBarListener) this);
        poller.addZeroButtonListener((ZeroPowerButtonListener) this);
        (new Thread(poller)).start();
        System.out.println();
    }

    /**
     * This method sets up the background image for the main frame and  adds a JPanel to it.
     * The JPanel will contain the buttons from the array list of JButtons.
     *
     * @param jPanel is the JPanel displayed
     * @param  buttons is an array list of buttons
     * @author Sergiu Ivanov
     */

    public void setInputPanel(JLabel backgroundImage, JPanel jPanel, ArrayList<JButton> buttons){
        Main.buttons = buttons;
        Main.inputPanel = jPanel;
        remove(background);
        backgroundImage.add(inputPanel);
        backgroundImage.setBounds(0,0,791,711);
        add(backgroundImage);
        revalidate();

    }

    /**
     * This method adds a button to the JPanel
     *
     * @param button is a JButton that needs to be added to the panel
     * @author Sergiu Ivanov
     */
    public void setButtons( JButton button){

        inputPanel.add( button );
    }

    /**
     * This method clear all components in a JPanel
     *
     * @param jPanel is a JPanel that is to be cleared and revalidate
     * @author Sergiu Ivanov
     */
    public  void removeAllButtons(JPanel jPanel){
        jPanel.removeAll();
        jPanel.revalidate();
    }

    /**
     * This method shows 5 buttons from an array list . The index of the first button should be set as a parameter,
     *     the position of the rest will be computed automatically.
     *
     * @param buttonsList means any array list of JButtons
     * @param first means de index of the button that is to be shown first
     *
     * @author Sergiu Ivanov and Callum Browne
     */
    public  void showCurrentButtons ( ArrayList<JButton> buttonsList, int first){
        removeAllButtons(inputPanel);
//        System.out.println("The first position is: " + firstPosition);
//        System.out.println("The default button position is: " + defaultButtonPosition);
        int mod = buttonsList.size();
        for (int i = 0; i < 5; i++){
            setButtons(buttonsList.get(Math.floorMod(first + i, mod)));
//            System.out.printf("First: %d: Showing button %d at position %d\n", first, Math.floorMod(first+i, mod), i);
        }
//        System.out.println();
        inputPanel.revalidate();
    }

    /**
     * This method sets up de index of the button that is selected by the user. The index is used to highlight
     * the selected button that should always be in the middle.
     *
     * @param buttonsList means any Arraylist of Jbuttons
     * @author Sergiu Ivanov
     */
    public static void setDefaultButton(ArrayList<JButton> buttonsList){
        int mod = buttonsList.size();
        defaultButtonPosition = Math.floorMod(firstPosition + 2, mod);
        JButton defaultButton = buttons.get(defaultButtonPosition);
        JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
        if (rootPane != null) {
            rootPane.setDefaultButton(defaultButton);
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
        int strumbarValue = event.getState().getStrumBar();
        if (strumbarValue == 1 || strumbarValue == -1){
            //System.out.println(" strum bar clicked");
            firstPosition += strumbarValue;
            setDefaultButton(buttons);
            showCurrentButtons( buttons, firstPosition);
        }
    }
    /**
     * This method exits the game
     *
     * @param event is the event fired by the strum bar
     * @author Sergiu Ivanov and Callum Browne
     */
    public void escapeButtonEventReceived(GuitarEvent event) {
        if(!event.getState().getEscapeButton()){
            if (getTitle().equals("SLASH MODE")){
                System.exit(0);
            }
            else if(getTitle().equals("SELECT MODE") || getTitle().equals("STORE MODE (IN DEVELOPMENT)")){

                setTitle("SLASH MODE");
                background.remove(inputPanel);
                setInputPanel(background, slashViewPanel.getSlashModePanel(), slashViewPanel.getButtons());
                inputPanel.revalidate();
                inputPanel.repaint();
                showCurrentButtons(buttons,firstPosition);
                revalidate();
            }
        }
    }


    /**
     * This method selects the intended game mode.
     *
     * @param event is the event fired by the zero power button
     * @author Sergiu Ivanov
     */
    public void zeroPowerButtonEventReceived(GuitarEvent event) {
        if (!event.getState().getZeroPowerButton() && getTitle().equals("SLASH MODE") ){
            // System.out.println(" Zero power button  clicked");
            if (buttons.get(defaultButtonPosition) == slashViewPanel.getBtnSelect()){
                setTitle("SELECT MODE");
                setInputPanel(background, selectViewPanel.getSelectModePanel(), selectViewPanel.getButtons());
                inputPanel.revalidate();
                inputPanel.repaint();
                showCurrentButtons(buttons,firstPosition);

            }
            else if (buttons.get(defaultButtonPosition) == slashViewPanel.getBtnStore()) {
                setTitle("STORE MODE (IN DEVELOPMENT)");
                inputPanel.removeAll();
                setInputPanel(background, storeViewPanel.getStoreModePanel(), storeViewPanel.getButtons());
                inputPanel.revalidate();
                inputPanel.repaint();
                showCurrentButtons(buttons, firstPosition);
            }
            else if (buttons.get(defaultButtonPosition) == slashViewPanel.getBtnTutorial()){
                JOptionPane.showMessageDialog(this, "TUTORIAL MODE IS CURRENTLY IN DEVELOPMENT");
            }

            else if (buttons.get(defaultButtonPosition) == slashViewPanel.getBtnPlay()){
                JOptionPane.showMessageDialog(this, "PLAY button clicked");
            }

            else if (buttons.get(defaultButtonPosition) == slashViewPanel.getBtnExit()){
                System.exit(0);
            }
            else {
                JOptionPane.showMessageDialog(this, "OTHER button clicked");
            }
        }

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
