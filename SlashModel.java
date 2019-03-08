import javax.swing.*;
import java.util.ArrayList;
/**
 * This is the model class for the slash mode(In development)
 *
 * @author Sergiu Ivanov
 */
public class SlashModel {
//    // the index of the selected button
//    private   int defaultButtonPosition = 2;
//    // the index of the first icon on the left
//    private  int firstPosition = 0;
//    private ArrayList<JButton> buttons = new ArrayList<>();
//
//    public void addButton(JButton button) {
//
//        buttons.add(button);
//    }
//
//    public ArrayList<JButton> getButtons() {
//
//        return buttons;
//    }
//
//    public  int getFirstPosition() {
//        return firstPosition;
//    }
//
//    public  int getDefaultButtonPosition() {
//        return defaultButtonPosition;
//    }
//
//    public void setButtons(ArrayList<JButton> buttons) {
//        this.buttons = buttons;
//    }
//
//    public  void setDefaultButtonPosition(int defaultButtonPosition) {
//        defaultButtonPosition = defaultButtonPosition;
//    }
//
//    public  void setFirstPosition(int firstPosition) {
//        firstPosition = firstPosition;
//    }
//
//    /**
//     * This method shows 5 buttons from an array list . The index of the first button should be set as a parameter,
//     *     the position of the rest will be computed automatically.
//     *
//     * @param buttonsList means any array list of JButtons
//     * @param first means de index of the button that is to be shown first
//     *
//     * @author Sergiu Ivanov and Callum Browne
//     */
//    public  void showCurrentButtons (JPanel jPanel, ArrayList<JButton> buttonsList, int first){
//        jPanel.removeAll();
//        jPanel.revalidate();
////        System.out.println("The first position is: " + firstPosition);
////        System.out.println("The default button position is: " + defaultButtonPosition);
//        int mod = buttonsList.size();
//        for (int i = 0; i < 5; i++){
//            setButtons(jPanel, buttonsList.get(Math.floorMod(first + i, mod)));
////            System.out.printf("First: %d: Showing button %d at position %d\n", first, Math.floorMod(first+i, mod), i);
//        }
//        jPanel.revalidate();
//    }
//
//    /**
//     * This method sets up de index of the button that is selected by the user. The index is used to highlight
//     * the selected button that should always be in the middle.
//     *
//     * @param buttonsList means any Arraylist of Jbuttons
//     * @author Sergiu Ivanov
//     */
//    public  void setDefaultButton(ArrayList<JButton> buttonsList){
//        int mod = buttonsList.size();
//        defaultButtonPosition = Math.floorMod(firstPosition + 2, mod);
//        JButton defaultButton = buttons.get(defaultButtonPosition);
//        JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
//        if (rootPane != null) {
//            rootPane.setDefaultButton(defaultButton);
//        }
//    }
//    /**
//     * This method adds a button to the JPanel
//     *
//     * @param button is a JButton that needs to be added to the panel
//     * @author Sergiu Ivanov
//     */
//    public void setButtons( JPanel jPanel, JButton button){
//
//        jPanel.add( button );
//    }
}
